package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@GwtCompatible
class TrustedListenableFutureTask<V> extends AbstractFuture.TrustedFuture<V> implements RunnableFuture<V> {
  private TrustedFutureInterruptibleTask task;
  
  TrustedListenableFutureTask(Callable<V> paramCallable) {
    this.task = new TrustedFutureInterruptibleTask(paramCallable);
  }
  
  static <V> TrustedListenableFutureTask<V> create(Runnable paramRunnable, @Nullable V paramV) {
    return new TrustedListenableFutureTask<V>(Executors.callable(paramRunnable, paramV));
  }
  
  static <V> TrustedListenableFutureTask<V> create(Callable<V> paramCallable) {
    return new TrustedListenableFutureTask<V>(paramCallable);
  }
  
  protected void afterDone() {
    super.afterDone();
    if (wasInterrupted()) {
      TrustedFutureInterruptibleTask trustedFutureInterruptibleTask = this.task;
      if (trustedFutureInterruptibleTask != null)
        trustedFutureInterruptibleTask.interruptTask(); 
    } 
    this.task = null;
  }
  
  public void run() {
    TrustedFutureInterruptibleTask trustedFutureInterruptibleTask = this.task;
    if (trustedFutureInterruptibleTask != null)
      trustedFutureInterruptibleTask.run(); 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append(" (delegate = ");
    stringBuilder.append(this.task);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  private final class TrustedFutureInterruptibleTask extends InterruptibleTask {
    private final Callable<V> callable;
    
    TrustedFutureInterruptibleTask(Callable<V> param1Callable) {
      this.callable = (Callable<V>)Preconditions.checkNotNull(param1Callable);
    }
    
    void runInterruptibly() {
      if (!TrustedListenableFutureTask.this.isDone())
        try {
          TrustedListenableFutureTask.this.set(this.callable.call());
        } catch (Throwable throwable) {
          TrustedListenableFutureTask.this.setException(throwable);
        }  
    }
    
    public String toString() {
      return this.callable.toString();
    }
    
    boolean wasInterrupted() {
      return TrustedListenableFutureTask.this.wasInterrupted();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\TrustedListenableFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */