package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

@Beta
@GwtIncompatible
public final class JdkFutureAdapters {
  public static <V> ListenableFuture<V> listenInPoolThread(Future<V> paramFuture) {
    return (paramFuture instanceof ListenableFuture) ? (ListenableFuture<V>)paramFuture : new ListenableFutureAdapter<V>(paramFuture);
  }
  
  public static <V> ListenableFuture<V> listenInPoolThread(Future<V> paramFuture, Executor paramExecutor) {
    Preconditions.checkNotNull(paramExecutor);
    return (paramFuture instanceof ListenableFuture) ? (ListenableFuture<V>)paramFuture : new ListenableFutureAdapter<V>(paramFuture, paramExecutor);
  }
  
  private static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    private static final Executor defaultAdapterExecutor = Executors.newCachedThreadPool(threadFactory);
    
    private static final ThreadFactory threadFactory = (new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
    
    private final Executor adapterExecutor;
    
    private final Future<V> delegate;
    
    private final ExecutionList executionList = new ExecutionList();
    
    private final AtomicBoolean hasListeners = new AtomicBoolean(false);
    
    static {
    
    }
    
    ListenableFutureAdapter(Future<V> param1Future) {
      this(param1Future, defaultAdapterExecutor);
    }
    
    ListenableFutureAdapter(Future<V> param1Future, Executor param1Executor) {
      this.delegate = (Future<V>)Preconditions.checkNotNull(param1Future);
      this.adapterExecutor = (Executor)Preconditions.checkNotNull(param1Executor);
    }
    
    public void addListener(Runnable param1Runnable, Executor param1Executor) {
      this.executionList.add(param1Runnable, param1Executor);
      if (this.hasListeners.compareAndSet(false, true)) {
        if (this.delegate.isDone()) {
          this.executionList.execute();
          return;
        } 
        this.adapterExecutor.execute(new Runnable() {
              public void run() {
                try {
                  Uninterruptibles.getUninterruptibly(JdkFutureAdapters.ListenableFutureAdapter.this.delegate);
                } catch (Throwable throwable) {}
                JdkFutureAdapters.ListenableFutureAdapter.this.executionList.execute();
              }
            });
      } 
    }
    
    protected Future<V> delegate() {
      return this.delegate;
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        Uninterruptibles.getUninterruptibly(this.this$0.delegate);
      } catch (Throwable throwable) {}
      this.this$0.executionList.execute();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\JdkFutureAdapters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */