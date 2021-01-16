package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class SerializingExecutor implements Executor, Runnable {
  private static final int RUNNING = -1;
  
  private static final int STOPPED = 0;
  
  private static final AtomicHelper atomicHelper;
  
  private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
  
  private final Executor executor;
  
  private final Queue<Runnable> runQueue = new ConcurrentLinkedQueue<Runnable>();
  
  private volatile int runState = 0;
  
  static {
    atomicHelper = getAtomicHelper();
  }
  
  public SerializingExecutor(Executor paramExecutor) {
    Preconditions.checkNotNull(paramExecutor, "'executor' must not be null.");
    this.executor = paramExecutor;
  }
  
  private static AtomicHelper getAtomicHelper() {
    SynchronizedAtomicHelper synchronizedAtomicHelper;
    try {
      FieldUpdaterAtomicHelper fieldUpdaterAtomicHelper = new FieldUpdaterAtomicHelper();
      this(AtomicIntegerFieldUpdater.newUpdater(SerializingExecutor.class, "runState"));
    } catch (Throwable throwable) {
      log.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", throwable);
      synchronizedAtomicHelper = new SynchronizedAtomicHelper();
    } 
    return synchronizedAtomicHelper;
  }
  
  private void schedule(@Nullable Runnable paramRunnable) {
    if (atomicHelper.runStateCompareAndSet(this, 0, -1))
      try {
        this.executor.execute(this);
      } finally {
        if (paramRunnable != null)
          this.runQueue.remove(paramRunnable); 
        atomicHelper.runStateSet(this, 0);
      }  
  }
  
  public void execute(Runnable paramRunnable) {
    this.runQueue.add(Preconditions.checkNotNull(paramRunnable, "'r' must not be null."));
    schedule(paramRunnable);
  }
  
  public void run() {
    try {
      while (true) {
        Runnable runnable = this.runQueue.poll();
        if (runnable != null) {
          try {
            runnable.run();
          } catch (RuntimeException runtimeException) {
            Logger logger = log;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("Exception while executing runnable ");
            stringBuilder.append(runnable);
            logger.log(level, stringBuilder.toString(), runtimeException);
          } 
          continue;
        } 
        atomicHelper.runStateSet(this, 0);
        return;
      } 
    } finally {
      atomicHelper.runStateSet(this, 0);
    } 
  }
  
  private static abstract class AtomicHelper {
    private AtomicHelper() {}
    
    public abstract boolean runStateCompareAndSet(SerializingExecutor param1SerializingExecutor, int param1Int1, int param1Int2);
    
    public abstract void runStateSet(SerializingExecutor param1SerializingExecutor, int param1Int);
  }
  
  private static final class FieldUpdaterAtomicHelper extends AtomicHelper {
    private final AtomicIntegerFieldUpdater<SerializingExecutor> runStateUpdater;
    
    private FieldUpdaterAtomicHelper(AtomicIntegerFieldUpdater<SerializingExecutor> param1AtomicIntegerFieldUpdater) {
      this.runStateUpdater = param1AtomicIntegerFieldUpdater;
    }
    
    public boolean runStateCompareAndSet(SerializingExecutor param1SerializingExecutor, int param1Int1, int param1Int2) {
      return this.runStateUpdater.compareAndSet(param1SerializingExecutor, param1Int1, param1Int2);
    }
    
    public void runStateSet(SerializingExecutor param1SerializingExecutor, int param1Int) {
      this.runStateUpdater.set(param1SerializingExecutor, param1Int);
    }
  }
  
  private static final class SynchronizedAtomicHelper extends AtomicHelper {
    private SynchronizedAtomicHelper() {}
    
    public boolean runStateCompareAndSet(SerializingExecutor param1SerializingExecutor, int param1Int1, int param1Int2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$300 : (Lio/grpc/internal/SerializingExecutor;)I
      //   6: iload_2
      //   7: if_icmpne -> 20
      //   10: aload_1
      //   11: iload_3
      //   12: invokestatic access$302 : (Lio/grpc/internal/SerializingExecutor;I)I
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: iconst_1
      //   19: ireturn
      //   20: aload_1
      //   21: monitorexit
      //   22: iconst_0
      //   23: ireturn
      //   24: astore #4
      //   26: aload_1
      //   27: monitorexit
      //   28: aload #4
      //   30: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	24	finally
      //   20	22	24	finally
      //   26	28	24	finally
    }
    
    public void runStateSet(SerializingExecutor param1SerializingExecutor, int param1Int) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: iload_2
      //   4: invokestatic access$302 : (Lio/grpc/internal/SerializingExecutor;I)I
      //   7: pop
      //   8: aload_1
      //   9: monitorexit
      //   10: return
      //   11: astore_3
      //   12: aload_1
      //   13: monitorexit
      //   14: aload_3
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	10	11	finally
      //   12	14	11	finally
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\SerializingExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */