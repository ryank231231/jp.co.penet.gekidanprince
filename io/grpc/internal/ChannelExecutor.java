package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
class ChannelExecutor {
  private static final Logger log = Logger.getLogger(ChannelExecutor.class.getName());
  
  @GuardedBy("lock")
  private boolean draining;
  
  private final Object lock = new Object();
  
  @GuardedBy("lock")
  private final Queue<Runnable> queue = new ArrayDeque<Runnable>();
  
  final void drain() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield lock : Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: iload_1
    //   10: istore_3
    //   11: iload_1
    //   12: ifne -> 32
    //   15: aload_0
    //   16: getfield draining : Z
    //   19: ifeq -> 25
    //   22: aload_2
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield draining : Z
    //   30: iconst_1
    //   31: istore_3
    //   32: aload_0
    //   33: getfield queue : Ljava/util/Queue;
    //   36: invokeinterface poll : ()Ljava/lang/Object;
    //   41: checkcast java/lang/Runnable
    //   44: astore #4
    //   46: aload #4
    //   48: ifnonnull -> 59
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield draining : Z
    //   56: aload_2
    //   57: monitorexit
    //   58: return
    //   59: aload_2
    //   60: monitorexit
    //   61: aload #4
    //   63: invokeinterface run : ()V
    //   68: iload_3
    //   69: istore_1
    //   70: goto -> 2
    //   73: astore_2
    //   74: aload_0
    //   75: aload_2
    //   76: invokevirtual handleUncaughtThrowable : (Ljava/lang/Throwable;)V
    //   79: iload_3
    //   80: istore_1
    //   81: goto -> 2
    //   84: astore #4
    //   86: aload_2
    //   87: monitorexit
    //   88: aload #4
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   15	24	84	finally
    //   25	30	84	finally
    //   32	46	84	finally
    //   51	58	84	finally
    //   59	61	84	finally
    //   61	68	73	java/lang/Throwable
    //   86	88	84	finally
  }
  
  final ChannelExecutor executeLater(Runnable paramRunnable) {
    synchronized (this.lock) {
      this.queue.add(Preconditions.checkNotNull(paramRunnable, "runnable is null"));
      return this;
    } 
  }
  
  void handleUncaughtThrowable(Throwable paramThrowable) {
    log.log(Level.WARNING, "Runnable threw exception in ChannelExecutor", paramThrowable);
  }
  
  @VisibleForTesting
  final int numPendingTasks() {
    synchronized (this.lock) {
      return this.queue.size();
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ChannelExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */