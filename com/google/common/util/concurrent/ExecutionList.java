package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible
public final class ExecutionList {
  private static final Logger log = Logger.getLogger(ExecutionList.class.getName());
  
  @GuardedBy("this")
  private boolean executed;
  
  @GuardedBy("this")
  private RunnableExecutorPair runnables;
  
  private static void executeListener(Runnable paramRunnable, Executor paramExecutor) {
    try {
      paramExecutor.execute(paramRunnable);
    } catch (RuntimeException runtimeException) {
      Logger logger = log;
      Level level = Level.SEVERE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RuntimeException while executing runnable ");
      stringBuilder.append(paramRunnable);
      stringBuilder.append(" with executor ");
      stringBuilder.append(paramExecutor);
      logger.log(level, stringBuilder.toString(), runtimeException);
    } 
  }
  
  public void add(Runnable paramRunnable, Executor paramExecutor) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'Runnable was null.'
    //   3: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: ldc 'Executor was null.'
    //   10: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield executed : Z
    //   20: ifne -> 45
    //   23: new com/google/common/util/concurrent/ExecutionList$RunnableExecutorPair
    //   26: astore_3
    //   27: aload_3
    //   28: aload_1
    //   29: aload_2
    //   30: aload_0
    //   31: getfield runnables : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   34: invokespecial <init> : (Ljava/lang/Runnable;Ljava/util/concurrent/Executor;Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;)V
    //   37: aload_0
    //   38: aload_3
    //   39: putfield runnables : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: aload_2
    //   49: invokestatic executeListener : (Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V
    //   52: return
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   16	44	53	finally
    //   45	47	53	finally
    //   54	56	53	finally
  }
  
  public void execute() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: ifeq -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield executed : Z
    //   17: aload_0
    //   18: getfield runnables : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   21: astore_1
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield runnables : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   27: aload_0
    //   28: monitorexit
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: astore_3
    //   33: aload_1
    //   34: ifnull -> 54
    //   37: aload_1
    //   38: getfield next : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   41: astore_3
    //   42: aload_1
    //   43: aload_2
    //   44: putfield next : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   47: aload_1
    //   48: astore_2
    //   49: aload_3
    //   50: astore_1
    //   51: goto -> 31
    //   54: aload_3
    //   55: ifnull -> 77
    //   58: aload_3
    //   59: getfield runnable : Ljava/lang/Runnable;
    //   62: aload_3
    //   63: getfield executor : Ljava/util/concurrent/Executor;
    //   66: invokestatic executeListener : (Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V
    //   69: aload_3
    //   70: getfield next : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   73: astore_3
    //   74: goto -> 54
    //   77: return
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	78	finally
    //   12	29	78	finally
    //   79	81	78	finally
  }
  
  private static final class RunnableExecutorPair {
    final Executor executor;
    
    @Nullable
    RunnableExecutorPair next;
    
    final Runnable runnable;
    
    RunnableExecutorPair(Runnable param1Runnable, Executor param1Executor, RunnableExecutorPair param1RunnableExecutorPair) {
      this.runnable = param1Runnable;
      this.executor = param1Executor;
      this.next = param1RunnableExecutorPair;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ExecutionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */