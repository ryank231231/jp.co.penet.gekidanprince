package io.grpc.internal;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

class SerializeReentrantCallsDirectExecutor implements Executor {
  private static final Logger log = Logger.getLogger(SerializeReentrantCallsDirectExecutor.class.getName());
  
  private boolean executing;
  
  private ArrayDeque<Runnable> taskQueue;
  
  private void completeQueuedTasks() {
    while (true) {
      Runnable runnable = this.taskQueue.poll();
      if (runnable != null) {
        try {
          runnable.run();
        } catch (Throwable throwable) {
          Logger logger = log;
          Level level = Level.SEVERE;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Exception while executing runnable ");
          stringBuilder.append(runnable);
          logger.log(level, stringBuilder.toString(), throwable);
        } 
        continue;
      } 
      break;
    } 
  }
  
  private void enqueue(Runnable paramRunnable) {
    if (this.taskQueue == null)
      this.taskQueue = new ArrayDeque<Runnable>(4); 
    this.taskQueue.add(paramRunnable);
  }
  
  public void execute(Runnable paramRunnable) {
    // Byte code:
    //   0: aload_1
    //   1: ldc ''task' must not be null.'
    //   3: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield executing : Z
    //   11: ifne -> 123
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield executing : Z
    //   19: aload_1
    //   20: invokeinterface run : ()V
    //   25: aload_0
    //   26: getfield taskQueue : Ljava/util/ArrayDeque;
    //   29: ifnull -> 36
    //   32: aload_0
    //   33: invokespecial completeQueuedTasks : ()V
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield executing : Z
    //   41: goto -> 128
    //   44: astore_1
    //   45: goto -> 105
    //   48: astore_2
    //   49: getstatic io/grpc/internal/SerializeReentrantCallsDirectExecutor.log : Ljava/util/logging/Logger;
    //   52: astore_3
    //   53: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
    //   56: astore #4
    //   58: new java/lang/StringBuilder
    //   61: astore #5
    //   63: aload #5
    //   65: invokespecial <init> : ()V
    //   68: aload #5
    //   70: ldc 'Exception while executing runnable '
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #5
    //   78: aload_1
    //   79: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_3
    //   84: aload #4
    //   86: aload #5
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: aload_2
    //   92: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_0
    //   96: getfield taskQueue : Ljava/util/ArrayDeque;
    //   99: ifnull -> 36
    //   102: goto -> 32
    //   105: aload_0
    //   106: getfield taskQueue : Ljava/util/ArrayDeque;
    //   109: ifnull -> 116
    //   112: aload_0
    //   113: invokespecial completeQueuedTasks : ()V
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield executing : Z
    //   121: aload_1
    //   122: athrow
    //   123: aload_0
    //   124: aload_1
    //   125: invokespecial enqueue : (Ljava/lang/Runnable;)V
    //   128: return
    // Exception table:
    //   from	to	target	type
    //   19	25	48	java/lang/Throwable
    //   19	25	44	finally
    //   49	95	44	finally
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\SerializeReentrantCallsDirectExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */