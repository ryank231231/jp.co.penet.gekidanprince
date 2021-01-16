package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.Nullable;

@GwtCompatible
final class CombinedFuture<V> extends AggregateFuture<Object, V> {
  CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> paramImmutableCollection, boolean paramBoolean, Executor paramExecutor, AsyncCallable<V> paramAsyncCallable) {
    init(new CombinedFutureRunningState((ImmutableCollection)paramImmutableCollection, paramBoolean, new AsyncCallableInterruptibleTask(paramAsyncCallable, paramExecutor)));
  }
  
  CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> paramImmutableCollection, boolean paramBoolean, Executor paramExecutor, Callable<V> paramCallable) {
    init(new CombinedFutureRunningState((ImmutableCollection)paramImmutableCollection, paramBoolean, new CallableInterruptibleTask(paramCallable, paramExecutor)));
  }
  
  private final class AsyncCallableInterruptibleTask extends CombinedFutureInterruptibleTask {
    private final AsyncCallable<V> callable;
    
    public AsyncCallableInterruptibleTask(AsyncCallable<V> param1AsyncCallable, Executor param1Executor) {
      super(param1Executor);
      this.callable = (AsyncCallable<V>)Preconditions.checkNotNull(param1AsyncCallable);
    }
    
    void setValue() throws Exception {
      CombinedFuture.this.setFuture(this.callable.call());
    }
  }
  
  private final class CallableInterruptibleTask extends CombinedFutureInterruptibleTask {
    private final Callable<V> callable;
    
    public CallableInterruptibleTask(Callable<V> param1Callable, Executor param1Executor) {
      super(param1Executor);
      this.callable = (Callable<V>)Preconditions.checkNotNull(param1Callable);
    }
    
    void setValue() throws Exception {
      CombinedFuture.this.set(this.callable.call());
    }
  }
  
  private abstract class CombinedFutureInterruptibleTask extends InterruptibleTask {
    private final Executor listenerExecutor;
    
    volatile boolean thrownByExecute = true;
    
    public CombinedFutureInterruptibleTask(Executor param1Executor) {
      this.listenerExecutor = (Executor)Preconditions.checkNotNull(param1Executor);
    }
    
    final void execute() {
      try {
        this.listenerExecutor.execute(this);
      } catch (RejectedExecutionException rejectedExecutionException) {
        if (this.thrownByExecute)
          CombinedFuture.this.setException(rejectedExecutionException); 
      } 
    }
    
    final void runInterruptibly() {
      this.thrownByExecute = false;
      if (!CombinedFuture.this.isDone())
        try {
          setValue();
        } catch (ExecutionException executionException) {
          CombinedFuture.this.setException(executionException.getCause());
        } catch (CancellationException cancellationException) {
          CombinedFuture.this.cancel(false);
        } catch (Throwable throwable) {
          CombinedFuture.this.setException(throwable);
        }  
    }
    
    abstract void setValue() throws Exception;
    
    final boolean wasInterrupted() {
      return CombinedFuture.this.wasInterrupted();
    }
  }
  
  private final class CombinedFutureRunningState extends AggregateFuture<Object, V>.RunningState {
    private CombinedFuture<V>.CombinedFutureInterruptibleTask task;
    
    CombinedFutureRunningState(ImmutableCollection<? extends ListenableFuture<? extends Object>> param1ImmutableCollection, boolean param1Boolean, CombinedFuture<V>.CombinedFutureInterruptibleTask param1CombinedFutureInterruptibleTask) {
      super(param1ImmutableCollection, param1Boolean, false);
      this.task = param1CombinedFutureInterruptibleTask;
    }
    
    void collectOneValue(boolean param1Boolean, int param1Int, @Nullable Object param1Object) {}
    
    void handleAllCompleted() {
      CombinedFuture<V>.CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
      if (combinedFutureInterruptibleTask != null) {
        combinedFutureInterruptibleTask.execute();
      } else {
        Preconditions.checkState(CombinedFuture.this.isDone());
      } 
    }
    
    void interruptTask() {
      CombinedFuture<V>.CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
      if (combinedFutureInterruptibleTask != null)
        combinedFutureInterruptibleTask.interruptTask(); 
    }
    
    void releaseResourcesAfterFailure() {
      super.releaseResourcesAfterFailure();
      this.task = null;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\CombinedFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */