package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
abstract class InterruptibleTask implements Runnable {
  static {
    try {
      SafeAtomicHelper safeAtomicHelper = new SafeAtomicHelper();
      this(AtomicReferenceFieldUpdater.newUpdater(InterruptibleTask.class, Thread.class, "runner"));
    } catch (Throwable throwable) {
      log.log(Level.SEVERE, "SafeAtomicHelper is broken!", throwable);
      synchronizedAtomicHelper = new SynchronizedAtomicHelper();
    } 
    ATOMIC_HELPER = synchronizedAtomicHelper;
  }
  
  final void interruptTask() {
    Thread thread = this.runner;
    if (thread != null)
      thread.interrupt(); 
    this.doneInterrupting = true;
  }
  
  public final void run() {
    if (!ATOMIC_HELPER.compareAndSetRunner(this, null, Thread.currentThread()))
      return; 
    try {
      runInterruptibly();
      return;
    } finally {
      if (wasInterrupted())
        while (!this.doneInterrupting)
          Thread.yield();  
    } 
  }
  
  abstract void runInterruptibly();
  
  abstract boolean wasInterrupted();
  
  static {
    SynchronizedAtomicHelper synchronizedAtomicHelper;
  }
  
  private static final AtomicHelper ATOMIC_HELPER;
  
  private static final Logger log = Logger.getLogger(InterruptibleTask.class.getName());
  
  private volatile boolean doneInterrupting;
  
  private volatile Thread runner;
  
  private static abstract class AtomicHelper {
    private AtomicHelper() {}
    
    abstract boolean compareAndSetRunner(InterruptibleTask param1InterruptibleTask, Thread param1Thread1, Thread param1Thread2);
  }
  
  private static final class SafeAtomicHelper extends AtomicHelper {
    final AtomicReferenceFieldUpdater<InterruptibleTask, Thread> runnerUpdater;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater<InterruptibleTask, Thread> param1AtomicReferenceFieldUpdater) {
      this.runnerUpdater = param1AtomicReferenceFieldUpdater;
    }
    
    boolean compareAndSetRunner(InterruptibleTask param1InterruptibleTask, Thread param1Thread1, Thread param1Thread2) {
      return this.runnerUpdater.compareAndSet(param1InterruptibleTask, param1Thread1, param1Thread2);
    }
  }
  
  private static final class SynchronizedAtomicHelper extends AtomicHelper {
    private SynchronizedAtomicHelper() {}
    
    boolean compareAndSetRunner(InterruptibleTask param1InterruptibleTask, Thread param1Thread1, Thread param1Thread2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$200 : (Lcom/google/common/util/concurrent/InterruptibleTask;)Ljava/lang/Thread;
      //   6: aload_2
      //   7: if_acmpne -> 16
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic access$202 : (Lcom/google/common/util/concurrent/InterruptibleTask;Ljava/lang/Thread;)Ljava/lang/Thread;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: iconst_1
      //   19: ireturn
      //   20: astore_2
      //   21: aload_1
      //   22: monitorexit
      //   23: aload_2
      //   24: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	20	finally
      //   16	18	20	finally
      //   21	23	20	finally
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\InterruptibleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */