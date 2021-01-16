package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
public final class Queues {
  @Beta
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <E> int drain(BlockingQueue<E> paramBlockingQueue, Collection<? super E> paramCollection, int paramInt, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    int j;
    Preconditions.checkNotNull(paramCollection);
    long l = System.nanoTime();
    paramLong = paramTimeUnit.toNanos(paramLong);
    int i = 0;
    while (true) {
      j = i;
      if (i < paramInt) {
        j = i + paramBlockingQueue.drainTo(paramCollection, paramInt - i);
        i = j;
        if (j < paramInt) {
          paramTimeUnit = (TimeUnit)paramBlockingQueue.poll(l + paramLong - System.nanoTime(), TimeUnit.NANOSECONDS);
          if (paramTimeUnit == null)
            break; 
          paramCollection.add((E)paramTimeUnit);
          i = j + 1;
        } 
        continue;
      } 
      break;
    } 
    return j;
  }
  
  @Beta
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <E> int drainUninterruptibly(BlockingQueue<E> paramBlockingQueue, Collection<? super E> paramCollection, int paramInt, long paramLong, TimeUnit paramTimeUnit) {
    int j;
    boolean bool2;
    Preconditions.checkNotNull(paramCollection);
    long l = System.nanoTime();
    paramLong = paramTimeUnit.toNanos(paramLong);
    int i = 0;
    boolean bool1 = false;
    label28: while (true) {
      j = i;
      bool2 = bool1;
      if (i < paramInt) {
        bool2 = bool1;
        try {
          j = paramBlockingQueue.drainTo(paramCollection, paramInt - i);
          j = i + j;
          i = j;
          if (j < paramInt) {
            while (true) {
              bool2 = bool1;
              try {
                paramTimeUnit = (TimeUnit)paramBlockingQueue.poll(l + paramLong - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (paramTimeUnit == null) {
                  bool2 = bool1;
                  break;
                } 
                bool2 = bool1;
                paramCollection.add((E)paramTimeUnit);
                i = j + 1;
              } catch (InterruptedException interruptedException) {
                bool1 = true;
                continue;
              } 
              continue label28;
            } 
            break;
          } 
        } finally {
          if (bool2)
            Thread.currentThread().interrupt(); 
        } 
        continue;
      } 
      break;
    } 
    if (bool2)
      Thread.currentThread().interrupt(); 
    return j;
  }
  
  @GwtIncompatible
  public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int paramInt) {
    return new ArrayBlockingQueue<E>(paramInt);
  }
  
  public static <E> ArrayDeque<E> newArrayDeque() {
    return new ArrayDeque<E>();
  }
  
  public static <E> ArrayDeque<E> newArrayDeque(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection)
      return new ArrayDeque<E>(Collections2.cast(paramIterable)); 
    ArrayDeque<E> arrayDeque = new ArrayDeque();
    Iterables.addAll(arrayDeque, paramIterable);
    return arrayDeque;
  }
  
  @GwtIncompatible
  public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue() {
    return new ConcurrentLinkedQueue<E>();
  }
  
  @GwtIncompatible
  public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection)
      return new ConcurrentLinkedQueue<E>(Collections2.cast(paramIterable)); 
    ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue();
    Iterables.addAll(concurrentLinkedQueue, paramIterable);
    return concurrentLinkedQueue;
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque() {
    return new LinkedBlockingDeque<E>();
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int paramInt) {
    return new LinkedBlockingDeque<E>(paramInt);
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection)
      return new LinkedBlockingDeque<E>(Collections2.cast(paramIterable)); 
    LinkedBlockingDeque<E> linkedBlockingDeque = new LinkedBlockingDeque();
    Iterables.addAll(linkedBlockingDeque, paramIterable);
    return linkedBlockingDeque;
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue() {
    return new LinkedBlockingQueue<E>();
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int paramInt) {
    return new LinkedBlockingQueue<E>(paramInt);
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection)
      return new LinkedBlockingQueue<E>(Collections2.cast(paramIterable)); 
    LinkedBlockingQueue<E> linkedBlockingQueue = new LinkedBlockingQueue();
    Iterables.addAll(linkedBlockingQueue, paramIterable);
    return linkedBlockingQueue;
  }
  
  @GwtIncompatible
  public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue() {
    return new PriorityBlockingQueue<E>();
  }
  
  @GwtIncompatible
  public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection)
      return new PriorityBlockingQueue<E>(Collections2.cast(paramIterable)); 
    PriorityBlockingQueue<E> priorityBlockingQueue = new PriorityBlockingQueue();
    Iterables.addAll(priorityBlockingQueue, paramIterable);
    return priorityBlockingQueue;
  }
  
  public static <E extends Comparable> PriorityQueue<E> newPriorityQueue() {
    return new PriorityQueue<E>();
  }
  
  public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection)
      return new PriorityQueue<E>(Collections2.cast(paramIterable)); 
    PriorityQueue<E> priorityQueue = new PriorityQueue();
    Iterables.addAll(priorityQueue, paramIterable);
    return priorityQueue;
  }
  
  @GwtIncompatible
  public static <E> SynchronousQueue<E> newSynchronousQueue() {
    return new SynchronousQueue<E>();
  }
  
  public static <E> Deque<E> synchronizedDeque(Deque<E> paramDeque) {
    return Synchronized.deque(paramDeque, null);
  }
  
  public static <E> Queue<E> synchronizedQueue(Queue<E> paramQueue) {
    return Synchronized.queue(paramQueue, null);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Queues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */