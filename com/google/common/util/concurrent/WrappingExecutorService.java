package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@CanIgnoreReturnValue
abstract class WrappingExecutorService implements ExecutorService {
  private final ExecutorService delegate;
  
  protected WrappingExecutorService(ExecutorService paramExecutorService) {
    this.delegate = (ExecutorService)Preconditions.checkNotNull(paramExecutorService);
  }
  
  private final <T> ImmutableList<Callable<T>> wrapTasks(Collection<? extends Callable<T>> paramCollection) {
    ImmutableList.Builder builder = ImmutableList.builder();
    Iterator<? extends Callable<T>> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      builder.add(wrapTask(iterator.next())); 
    return builder.build();
  }
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.delegate.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public final void execute(Runnable paramRunnable) {
    this.delegate.execute(wrapTask(paramRunnable));
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection) throws InterruptedException {
    return this.delegate.invokeAll((Collection<? extends Callable<T>>)wrapTasks(paramCollection));
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.delegate.invokeAll((Collection<? extends Callable<T>>)wrapTasks(paramCollection), paramLong, paramTimeUnit);
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection) throws InterruptedException, ExecutionException {
    return this.delegate.invokeAny((Collection<? extends Callable<T>>)wrapTasks(paramCollection));
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return this.delegate.invokeAny((Collection<? extends Callable<T>>)wrapTasks(paramCollection), paramLong, paramTimeUnit);
  }
  
  public final boolean isShutdown() {
    return this.delegate.isShutdown();
  }
  
  public final boolean isTerminated() {
    return this.delegate.isTerminated();
  }
  
  public final void shutdown() {
    this.delegate.shutdown();
  }
  
  public final List<Runnable> shutdownNow() {
    return this.delegate.shutdownNow();
  }
  
  public final Future<?> submit(Runnable paramRunnable) {
    return this.delegate.submit(wrapTask(paramRunnable));
  }
  
  public final <T> Future<T> submit(Runnable paramRunnable, T paramT) {
    return this.delegate.submit(wrapTask(paramRunnable), paramT);
  }
  
  public final <T> Future<T> submit(Callable<T> paramCallable) {
    return this.delegate.submit(wrapTask((Callable<T>)Preconditions.checkNotNull(paramCallable)));
  }
  
  protected Runnable wrapTask(Runnable paramRunnable) {
    return new Runnable() {
        public void run() {
          try {
            wrapped.call();
            return;
          } catch (Exception exception) {
            Throwables.throwIfUnchecked(exception);
            throw new RuntimeException(exception);
          } 
        }
      };
  }
  
  protected abstract <T> Callable<T> wrapTask(Callable<T> paramCallable);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\WrappingExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */