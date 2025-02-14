package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingObject;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingExecutorService extends ForwardingObject implements ExecutorService {
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return delegate().awaitTermination(paramLong, paramTimeUnit);
  }
  
  protected abstract ExecutorService delegate();
  
  public void execute(Runnable paramRunnable) {
    delegate().execute(paramRunnable);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection) throws InterruptedException {
    return delegate().invokeAll(paramCollection);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return delegate().invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection) throws InterruptedException, ExecutionException {
    return delegate().invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return delegate().invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown() {
    return delegate().isShutdown();
  }
  
  public boolean isTerminated() {
    return delegate().isTerminated();
  }
  
  public void shutdown() {
    delegate().shutdown();
  }
  
  public List<Runnable> shutdownNow() {
    return delegate().shutdownNow();
  }
  
  public Future<?> submit(Runnable paramRunnable) {
    return delegate().submit(paramRunnable);
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT) {
    return delegate().submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable) {
    return delegate().submit(paramCallable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */