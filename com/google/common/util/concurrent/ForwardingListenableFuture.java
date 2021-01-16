package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    delegate().addListener(paramRunnable, paramExecutor);
  }
  
  protected abstract ListenableFuture<? extends V> delegate();
  
  public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
    private final ListenableFuture<V> delegate;
    
    protected SimpleForwardingListenableFuture(ListenableFuture<V> param1ListenableFuture) {
      this.delegate = (ListenableFuture<V>)Preconditions.checkNotNull(param1ListenableFuture);
    }
    
    protected final ListenableFuture<V> delegate() {
      return this.delegate;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingListenableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */