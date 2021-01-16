package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingListeningExecutorService extends ForwardingExecutorService implements ListeningExecutorService {
  protected abstract ListeningExecutorService delegate();
  
  public ListenableFuture<?> submit(Runnable paramRunnable) {
    return delegate().submit(paramRunnable);
  }
  
  public <T> ListenableFuture<T> submit(Runnable paramRunnable, T paramT) {
    return delegate().submit(paramRunnable, paramT);
  }
  
  public <T> ListenableFuture<T> submit(Callable<T> paramCallable) {
    return delegate().submit(paramCallable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingListeningExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */