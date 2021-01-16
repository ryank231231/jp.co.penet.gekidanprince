package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
abstract class AggregateFutureState {
  static {
    try {
      SafeAtomicHelper safeAtomicHelper = new SafeAtomicHelper();
      this(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
    } catch (Throwable throwable) {
      log.log(Level.SEVERE, "SafeAtomicHelper is broken!", throwable);
      synchronizedAtomicHelper = new SynchronizedAtomicHelper();
    } 
    ATOMIC_HELPER = synchronizedAtomicHelper;
  }
  
  AggregateFutureState(int paramInt) {
    this.remaining = paramInt;
  }
  
  abstract void addInitialException(Set<Throwable> paramSet);
  
  final int decrementRemainingAndGet() {
    return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
  }
  
  final Set<Throwable> getOrInitSeenExceptions() {
    Set<Throwable> set1 = this.seenExceptions;
    Set<Throwable> set2 = set1;
    if (set1 == null) {
      set2 = Sets.newConcurrentHashSet();
      addInitialException(set2);
      ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, set2);
      set2 = this.seenExceptions;
    } 
    return set2;
  }
  
  static {
    SynchronizedAtomicHelper synchronizedAtomicHelper;
  }
  
  private static final AtomicHelper ATOMIC_HELPER;
  
  private static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
  
  private volatile int remaining;
  
  private volatile Set<Throwable> seenExceptions = null;
  
  private static abstract class AtomicHelper {
    private AtomicHelper() {}
    
    abstract void compareAndSetSeenExceptions(AggregateFutureState param1AggregateFutureState, Set<Throwable> param1Set1, Set<Throwable> param1Set2);
    
    abstract int decrementAndGetRemainingCount(AggregateFutureState param1AggregateFutureState);
  }
  
  private static final class SafeAtomicHelper extends AtomicHelper {
    final AtomicIntegerFieldUpdater<AggregateFutureState> remainingCountUpdater;
    
    final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> seenExceptionsUpdater;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> param1AtomicReferenceFieldUpdater, AtomicIntegerFieldUpdater<AggregateFutureState> param1AtomicIntegerFieldUpdater) {
      this.seenExceptionsUpdater = param1AtomicReferenceFieldUpdater;
      this.remainingCountUpdater = param1AtomicIntegerFieldUpdater;
    }
    
    void compareAndSetSeenExceptions(AggregateFutureState param1AggregateFutureState, Set<Throwable> param1Set1, Set<Throwable> param1Set2) {
      this.seenExceptionsUpdater.compareAndSet(param1AggregateFutureState, param1Set1, param1Set2);
    }
    
    int decrementAndGetRemainingCount(AggregateFutureState param1AggregateFutureState) {
      return this.remainingCountUpdater.decrementAndGet(param1AggregateFutureState);
    }
  }
  
  private static final class SynchronizedAtomicHelper extends AtomicHelper {
    private SynchronizedAtomicHelper() {}
    
    void compareAndSetSeenExceptions(AggregateFutureState param1AggregateFutureState, Set<Throwable> param1Set1, Set<Throwable> param1Set2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$200 : (Lcom/google/common/util/concurrent/AggregateFutureState;)Ljava/util/Set;
      //   6: aload_2
      //   7: if_acmpne -> 16
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic access$202 : (Lcom/google/common/util/concurrent/AggregateFutureState;Ljava/util/Set;)Ljava/util/Set;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: return
      //   19: astore_2
      //   20: aload_1
      //   21: monitorexit
      //   22: aload_2
      //   23: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	19	finally
      //   16	18	19	finally
      //   20	22	19	finally
    }
    
    int decrementAndGetRemainingCount(AggregateFutureState param1AggregateFutureState) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$310 : (Lcom/google/common/util/concurrent/AggregateFutureState;)I
      //   6: pop
      //   7: aload_1
      //   8: invokestatic access$300 : (Lcom/google/common/util/concurrent/AggregateFutureState;)I
      //   11: istore_2
      //   12: aload_1
      //   13: monitorexit
      //   14: iload_2
      //   15: ireturn
      //   16: astore_3
      //   17: aload_1
      //   18: monitorexit
      //   19: aload_3
      //   20: athrow
      // Exception table:
      //   from	to	target	type
      //   2	14	16	finally
      //   17	19	16	finally
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AggregateFutureState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */