package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible
final class ListenerCallQueue<L> implements Runnable {
  private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
  
  private final Executor executor;
  
  @GuardedBy("this")
  private boolean isThreadScheduled;
  
  private final L listener;
  
  @GuardedBy("this")
  private final Queue<Callback<L>> waitQueue = Queues.newArrayDeque();
  
  ListenerCallQueue(L paramL, Executor paramExecutor) {
    this.listener = (L)Preconditions.checkNotNull(paramL);
    this.executor = (Executor)Preconditions.checkNotNull(paramExecutor);
  }
  
  void add(Callback<L> paramCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield waitQueue : Ljava/util/Queue;
    //   6: aload_1
    //   7: invokeinterface add : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  void execute() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield isThreadScheduled : Z
    //   6: istore_1
    //   7: iconst_1
    //   8: istore_2
    //   9: iload_1
    //   10: ifne -> 21
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield isThreadScheduled : Z
    //   18: goto -> 23
    //   21: iconst_0
    //   22: istore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ifeq -> 129
    //   29: aload_0
    //   30: getfield executor : Ljava/util/concurrent/Executor;
    //   33: aload_0
    //   34: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   39: goto -> 129
    //   42: astore_3
    //   43: aload_0
    //   44: monitorenter
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield isThreadScheduled : Z
    //   50: aload_0
    //   51: monitorexit
    //   52: getstatic com/google/common/util/concurrent/ListenerCallQueue.logger : Ljava/util/logging/Logger;
    //   55: astore #4
    //   57: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
    //   60: astore #5
    //   62: new java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore #6
    //   71: aload #6
    //   73: ldc 'Exception while running callbacks for '
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload #6
    //   81: aload_0
    //   82: getfield listener : Ljava/lang/Object;
    //   85: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload #6
    //   91: ldc ' on '
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #6
    //   99: aload_0
    //   100: getfield executor : Ljava/util/concurrent/Executor;
    //   103: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload #4
    //   109: aload #5
    //   111: aload #6
    //   113: invokevirtual toString : ()Ljava/lang/String;
    //   116: aload_3
    //   117: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_3
    //   121: athrow
    //   122: astore #4
    //   124: aload_0
    //   125: monitorexit
    //   126: aload #4
    //   128: athrow
    //   129: return
    //   130: astore #4
    //   132: aload_0
    //   133: monitorexit
    //   134: aload #4
    //   136: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	130	finally
    //   13	18	130	finally
    //   23	25	130	finally
    //   29	39	42	java/lang/RuntimeException
    //   45	52	122	finally
    //   124	126	122	finally
    //   132	134	130	finally
  }
  
  public void run() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: iconst_1
    //   3: istore_2
    //   4: iload_1
    //   5: istore_3
    //   6: aload_0
    //   7: monitorenter
    //   8: iload_2
    //   9: istore #4
    //   11: aload_0
    //   12: getfield isThreadScheduled : Z
    //   15: invokestatic checkState : (Z)V
    //   18: iload_2
    //   19: istore #4
    //   21: aload_0
    //   22: getfield waitQueue : Ljava/util/Queue;
    //   25: invokeinterface poll : ()Ljava/lang/Object;
    //   30: checkcast com/google/common/util/concurrent/ListenerCallQueue$Callback
    //   33: astore #5
    //   35: aload #5
    //   37: ifnonnull -> 58
    //   40: iload_2
    //   41: istore #4
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield isThreadScheduled : Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore #6
    //   53: iconst_0
    //   54: istore_3
    //   55: goto -> 176
    //   58: iload_2
    //   59: istore #4
    //   61: aload_0
    //   62: monitorexit
    //   63: iload_1
    //   64: istore_3
    //   65: aload #5
    //   67: aload_0
    //   68: getfield listener : Ljava/lang/Object;
    //   71: invokevirtual call : (Ljava/lang/Object;)V
    //   74: goto -> 0
    //   77: astore #7
    //   79: iload_1
    //   80: istore_3
    //   81: getstatic com/google/common/util/concurrent/ListenerCallQueue.logger : Ljava/util/logging/Logger;
    //   84: astore #8
    //   86: iload_1
    //   87: istore_3
    //   88: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
    //   91: astore #9
    //   93: iload_1
    //   94: istore_3
    //   95: new java/lang/StringBuilder
    //   98: astore #6
    //   100: iload_1
    //   101: istore_3
    //   102: aload #6
    //   104: invokespecial <init> : ()V
    //   107: iload_1
    //   108: istore_3
    //   109: aload #6
    //   111: ldc 'Exception while executing callback: '
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: iload_1
    //   118: istore_3
    //   119: aload #6
    //   121: aload_0
    //   122: getfield listener : Ljava/lang/Object;
    //   125: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: iload_1
    //   130: istore_3
    //   131: aload #6
    //   133: ldc '.'
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: iload_1
    //   140: istore_3
    //   141: aload #6
    //   143: aload #5
    //   145: invokestatic access$000 : (Lcom/google/common/util/concurrent/ListenerCallQueue$Callback;)Ljava/lang/String;
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: iload_1
    //   153: istore_3
    //   154: aload #8
    //   156: aload #9
    //   158: aload #6
    //   160: invokevirtual toString : ()Ljava/lang/String;
    //   163: aload #7
    //   165: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: goto -> 0
    //   171: astore #6
    //   173: iload #4
    //   175: istore_3
    //   176: iload_3
    //   177: istore #4
    //   179: aload_0
    //   180: monitorexit
    //   181: aload #6
    //   183: athrow
    //   184: astore #6
    //   186: iload_3
    //   187: ifeq -> 209
    //   190: aload_0
    //   191: monitorenter
    //   192: aload_0
    //   193: iconst_0
    //   194: putfield isThreadScheduled : Z
    //   197: aload_0
    //   198: monitorexit
    //   199: goto -> 209
    //   202: astore #6
    //   204: aload_0
    //   205: monitorexit
    //   206: aload #6
    //   208: athrow
    //   209: aload #6
    //   211: athrow
    // Exception table:
    //   from	to	target	type
    //   6	8	184	finally
    //   11	18	171	finally
    //   21	35	171	finally
    //   43	48	171	finally
    //   48	50	51	finally
    //   61	63	171	finally
    //   65	74	77	java/lang/RuntimeException
    //   65	74	184	finally
    //   81	86	184	finally
    //   88	93	184	finally
    //   95	100	184	finally
    //   102	107	184	finally
    //   109	117	184	finally
    //   119	129	184	finally
    //   131	139	184	finally
    //   141	152	184	finally
    //   154	168	184	finally
    //   179	181	171	finally
    //   181	184	184	finally
    //   192	199	202	finally
    //   204	206	202	finally
  }
  
  static abstract class Callback<L> {
    private final String methodCall;
    
    Callback(String param1String) {
      this.methodCall = param1String;
    }
    
    abstract void call(L param1L);
    
    void enqueueOn(Iterable<ListenerCallQueue<L>> param1Iterable) {
      Iterator<ListenerCallQueue<L>> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        ((ListenerCallQueue)iterator.next()).add(this); 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ListenerCallQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */