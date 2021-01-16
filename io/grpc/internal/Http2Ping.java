package io.grpc.internal;

import com.google.common.base.Stopwatch;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public class Http2Ping {
  private static final Logger log = Logger.getLogger(Http2Ping.class.getName());
  
  @GuardedBy("this")
  private Map<ClientTransport$PingCallback, Executor> callbacks = new LinkedHashMap<ClientTransport$PingCallback, Executor>();
  
  @GuardedBy("this")
  private boolean completed;
  
  private final long data;
  
  @GuardedBy("this")
  private Throwable failureCause;
  
  @GuardedBy("this")
  private long roundTripTimeNanos;
  
  private final Stopwatch stopwatch;
  
  public Http2Ping(long paramLong, Stopwatch paramStopwatch) {
    this.data = paramLong;
    this.stopwatch = paramStopwatch;
  }
  
  private static Runnable asRunnable(final ClientTransport$PingCallback callback, final long roundTripTimeNanos) {
    return new Runnable() {
        public void run() {
          callback.onSuccess(roundTripTimeNanos);
        }
      };
  }
  
  private static Runnable asRunnable(final ClientTransport$PingCallback callback, final Throwable failureCause) {
    return new Runnable() {
        public void run() {
          callback.onFailure(failureCause);
        }
      };
  }
  
  private static void doExecute(Executor paramExecutor, Runnable paramRunnable) {
    try {
      paramExecutor.execute(paramRunnable);
    } catch (Throwable throwable) {
      log.log(Level.SEVERE, "Failed to execute PingCallback", throwable);
    } 
  }
  
  public static void notifyFailed(ClientTransport$PingCallback paramClientTransport$PingCallback, Executor paramExecutor, Throwable paramThrowable) {
    doExecute(paramExecutor, asRunnable(paramClientTransport$PingCallback, paramThrowable));
  }
  
  public void addCallback(ClientTransport$PingCallback paramClientTransport$PingCallback, Executor paramExecutor) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield completed : Z
    //   6: ifne -> 24
    //   9: aload_0
    //   10: getfield callbacks : Ljava/util/Map;
    //   13: aload_1
    //   14: aload_2
    //   15: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   20: pop
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield failureCause : Ljava/lang/Throwable;
    //   28: ifnull -> 43
    //   31: aload_1
    //   32: aload_0
    //   33: getfield failureCause : Ljava/lang/Throwable;
    //   36: invokestatic asRunnable : (Lio/grpc/internal/ClientTransport$PingCallback;Ljava/lang/Throwable;)Ljava/lang/Runnable;
    //   39: astore_1
    //   40: goto -> 52
    //   43: aload_1
    //   44: aload_0
    //   45: getfield roundTripTimeNanos : J
    //   48: invokestatic asRunnable : (Lio/grpc/internal/ClientTransport$PingCallback;J)Ljava/lang/Runnable;
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: aload_1
    //   56: invokestatic doExecute : (Ljava/util/concurrent/Executor;Ljava/lang/Runnable;)V
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	60	finally
    //   24	40	60	finally
    //   43	52	60	finally
    //   52	54	60	finally
    //   61	63	60	finally
  }
  
  public boolean complete() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield completed : Z
    //   6: ifeq -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield completed : Z
    //   18: aload_0
    //   19: getfield stopwatch : Lcom/google/common/base/Stopwatch;
    //   22: getstatic java/util/concurrent/TimeUnit.NANOSECONDS : Ljava/util/concurrent/TimeUnit;
    //   25: invokevirtual elapsed : (Ljava/util/concurrent/TimeUnit;)J
    //   28: lstore_1
    //   29: aload_0
    //   30: lload_1
    //   31: putfield roundTripTimeNanos : J
    //   34: aload_0
    //   35: getfield callbacks : Ljava/util/Map;
    //   38: astore_3
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield callbacks : Ljava/util/Map;
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: invokeinterface entrySet : ()Ljava/util/Set;
    //   52: invokeinterface iterator : ()Ljava/util/Iterator;
    //   57: astore #4
    //   59: aload #4
    //   61: invokeinterface hasNext : ()Z
    //   66: ifeq -> 108
    //   69: aload #4
    //   71: invokeinterface next : ()Ljava/lang/Object;
    //   76: checkcast java/util/Map$Entry
    //   79: astore_3
    //   80: aload_3
    //   81: invokeinterface getValue : ()Ljava/lang/Object;
    //   86: checkcast java/util/concurrent/Executor
    //   89: aload_3
    //   90: invokeinterface getKey : ()Ljava/lang/Object;
    //   95: checkcast io/grpc/internal/ClientTransport$PingCallback
    //   98: lload_1
    //   99: invokestatic asRunnable : (Lio/grpc/internal/ClientTransport$PingCallback;J)Ljava/lang/Runnable;
    //   102: invokestatic doExecute : (Ljava/util/concurrent/Executor;Ljava/lang/Runnable;)V
    //   105: goto -> 59
    //   108: iconst_1
    //   109: ireturn
    //   110: astore_3
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	110	finally
    //   13	46	110	finally
    //   111	113	110	finally
  }
  
  public void failed(Throwable paramThrowable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield completed : Z
    //   6: ifeq -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield completed : Z
    //   17: aload_0
    //   18: aload_1
    //   19: putfield failureCause : Ljava/lang/Throwable;
    //   22: aload_0
    //   23: getfield callbacks : Ljava/util/Map;
    //   26: astore_2
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield callbacks : Ljava/util/Map;
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: invokeinterface entrySet : ()Ljava/util/Set;
    //   40: invokeinterface iterator : ()Ljava/util/Iterator;
    //   45: astore_2
    //   46: aload_2
    //   47: invokeinterface hasNext : ()Z
    //   52: ifeq -> 90
    //   55: aload_2
    //   56: invokeinterface next : ()Ljava/lang/Object;
    //   61: checkcast java/util/Map$Entry
    //   64: astore_3
    //   65: aload_3
    //   66: invokeinterface getKey : ()Ljava/lang/Object;
    //   71: checkcast io/grpc/internal/ClientTransport$PingCallback
    //   74: aload_3
    //   75: invokeinterface getValue : ()Ljava/lang/Object;
    //   80: checkcast java/util/concurrent/Executor
    //   83: aload_1
    //   84: invokestatic notifyFailed : (Lio/grpc/internal/ClientTransport$PingCallback;Ljava/util/concurrent/Executor;Ljava/lang/Throwable;)V
    //   87: goto -> 46
    //   90: return
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	91	finally
    //   12	34	91	finally
    //   92	94	91	finally
  }
  
  public long payload() {
    return this.data;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\Http2Ping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */