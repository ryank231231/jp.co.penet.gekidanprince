package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtCompatible(emulated = true)
public final class Uninterruptibles {
  @GwtIncompatible
  public static void awaitUninterruptibly(CountDownLatch paramCountDownLatch) {
    boolean bool = false;
    while (true) {
      try {
        paramCountDownLatch.await();
        return;
      } catch (InterruptedException interruptedException) {
      
      } finally {
        if (bool)
          Thread.currentThread().interrupt(); 
      } 
    } 
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static boolean awaitUninterruptibly(CountDownLatch paramCountDownLatch, long paramLong, TimeUnit paramTimeUnit) {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = bool1;
    try {
      long l1 = paramTimeUnit.toNanos(paramLong);
      bool3 = bool1;
      long l2 = System.nanoTime();
      paramLong = l1;
      while (true) {
        bool3 = bool2;
        try {
          return paramCountDownLatch.await(paramLong, TimeUnit.NANOSECONDS);
        } catch (InterruptedException interruptedException) {
          bool3 = true;
          bool2 = true;
          paramLong = System.nanoTime();
          paramLong = l2 + l1 - paramLong;
        } 
      } 
    } finally {
      if (bool3)
        Thread.currentThread().interrupt(); 
    } 
  }
  
  @CanIgnoreReturnValue
  public static <V> V getUninterruptibly(Future<V> paramFuture) throws ExecutionException {
    boolean bool = false;
    while (true) {
      try {
        return paramFuture.get();
      } catch (InterruptedException interruptedException) {
      
      } finally {
        if (bool)
          Thread.currentThread().interrupt(); 
      } 
    } 
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <V> V getUninterruptibly(Future<V> paramFuture, long paramLong, TimeUnit paramTimeUnit) throws ExecutionException, TimeoutException {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = bool1;
    try {
      long l1 = paramTimeUnit.toNanos(paramLong);
      bool3 = bool1;
      long l2 = System.nanoTime();
      paramLong = l1;
      while (true) {
        bool3 = bool2;
        try {
          paramTimeUnit = (TimeUnit)paramFuture.get(paramLong, TimeUnit.NANOSECONDS);
          return (V)paramTimeUnit;
        } catch (InterruptedException interruptedException) {
          bool3 = true;
          bool2 = true;
          paramLong = System.nanoTime();
          paramLong = l2 + l1 - paramLong;
        } 
      } 
    } finally {
      if (bool3)
        Thread.currentThread().interrupt(); 
    } 
  }
  
  @GwtIncompatible
  public static void joinUninterruptibly(Thread paramThread) {
    boolean bool = false;
    while (true) {
      try {
        paramThread.join();
        return;
      } catch (InterruptedException interruptedException) {
      
      } finally {
        if (bool)
          Thread.currentThread().interrupt(); 
      } 
    } 
  }
  
  @GwtIncompatible
  public static void joinUninterruptibly(Thread paramThread, long paramLong, TimeUnit paramTimeUnit) {
    Preconditions.checkNotNull(paramThread);
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = bool1;
    try {
      long l1 = paramTimeUnit.toNanos(paramLong);
      bool3 = bool1;
      long l2 = System.nanoTime();
      paramLong = l1;
      while (true) {
        bool3 = bool2;
        try {
          TimeUnit.NANOSECONDS.timedJoin(paramThread, paramLong);
          return;
        } catch (InterruptedException interruptedException) {
          bool3 = true;
          bool2 = true;
          paramLong = System.nanoTime();
          paramLong = l2 + l1 - paramLong;
        } 
      } 
    } finally {
      if (bool3)
        Thread.currentThread().interrupt(); 
    } 
  }
  
  @GwtIncompatible
  public static <E> void putUninterruptibly(BlockingQueue<E> paramBlockingQueue, E paramE) {
    boolean bool = false;
    while (true) {
      try {
        paramBlockingQueue.put(paramE);
        return;
      } catch (InterruptedException interruptedException) {
      
      } finally {
        if (bool)
          Thread.currentThread().interrupt(); 
      } 
    } 
  }
  
  @GwtIncompatible
  public static void sleepUninterruptibly(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = bool1;
    try {
      long l1 = paramTimeUnit.toNanos(paramLong);
      bool3 = bool1;
      long l2 = System.nanoTime();
      paramLong = l1;
      while (true) {
        bool3 = bool2;
        try {
          TimeUnit.NANOSECONDS.sleep(paramLong);
          return;
        } catch (InterruptedException interruptedException) {
          bool3 = true;
          bool2 = true;
          paramLong = System.nanoTime();
          paramLong = l2 + l1 - paramLong;
        } 
      } 
    } finally {
      if (bool3)
        Thread.currentThread().interrupt(); 
    } 
  }
  
  @GwtIncompatible
  public static <E> E takeUninterruptibly(BlockingQueue<E> paramBlockingQueue) {
    boolean bool = false;
    while (true) {
      try {
        return paramBlockingQueue.take();
      } catch (InterruptedException interruptedException) {
      
      } finally {
        if (bool)
          Thread.currentThread().interrupt(); 
      } 
    } 
  }
  
  @GwtIncompatible
  public static boolean tryAcquireUninterruptibly(Semaphore paramSemaphore, int paramInt, long paramLong, TimeUnit paramTimeUnit) {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = bool1;
    try {
      long l1 = paramTimeUnit.toNanos(paramLong);
      bool3 = bool1;
      long l2 = System.nanoTime();
      paramLong = l1;
      while (true) {
        bool3 = bool2;
        try {
          return paramSemaphore.tryAcquire(paramInt, paramLong, TimeUnit.NANOSECONDS);
        } catch (InterruptedException interruptedException) {
          bool3 = true;
          bool2 = true;
          paramLong = System.nanoTime();
          paramLong = l2 + l1 - paramLong;
        } 
      } 
    } finally {
      if (bool3)
        Thread.currentThread().interrupt(); 
    } 
  }
  
  @GwtIncompatible
  public static boolean tryAcquireUninterruptibly(Semaphore paramSemaphore, long paramLong, TimeUnit paramTimeUnit) {
    return tryAcquireUninterruptibly(paramSemaphore, 1, paramLong, paramTimeUnit);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Uninterruptibles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */