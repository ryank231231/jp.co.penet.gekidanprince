package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@CanIgnoreReturnValue
public interface ListeningExecutorService extends ExecutorService {
  <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection) throws InterruptedException;
  
  <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException;
  
  ListenableFuture<?> submit(Runnable paramRunnable);
  
  <T> ListenableFuture<T> submit(Runnable paramRunnable, T paramT);
  
  <T> ListenableFuture<T> submit(Callable<T> paramCallable);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ListeningExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */