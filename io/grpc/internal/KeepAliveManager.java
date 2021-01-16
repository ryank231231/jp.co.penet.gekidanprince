package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class KeepAliveManager {
  private static final long MIN_KEEPALIVE_TIMEOUT_NANOS;
  
  private static final long MIN_KEEPALIVE_TIME_NANOS;
  
  private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
  
  private final boolean keepAliveDuringTransportIdle;
  
  private final KeepAlivePinger keepAlivePinger;
  
  private long keepAliveTimeInNanos;
  
  private long keepAliveTimeoutInNanos;
  
  private long nextKeepaliveTime;
  
  private ScheduledFuture<?> pingFuture;
  
  private final ScheduledExecutorService scheduler;
  
  private final Runnable sendPing = new LogExceptionRunnable(new Runnable() {
        public void run() {
          KeepAliveManager.access$302(KeepAliveManager.this, null);
          synchronized (KeepAliveManager.this) {
            boolean bool;
            if (KeepAliveManager.this.state == KeepAliveManager.State.PING_SCHEDULED) {
              bool = true;
              KeepAliveManager.access$102(KeepAliveManager.this, KeepAliveManager.State.PING_SENT);
              KeepAliveManager.access$402(KeepAliveManager.this, KeepAliveManager.this.scheduler.schedule(KeepAliveManager.this.shutdown, KeepAliveManager.this.keepAliveTimeoutInNanos, TimeUnit.NANOSECONDS));
            } else {
              if (KeepAliveManager.this.state == KeepAliveManager.State.PING_DELAYED) {
                KeepAliveManager.access$302(KeepAliveManager.this, KeepAliveManager.this.scheduler.schedule(KeepAliveManager.this.sendPing, KeepAliveManager.this.nextKeepaliveTime - KeepAliveManager.this.ticker.read(), TimeUnit.NANOSECONDS));
                KeepAliveManager.access$102(KeepAliveManager.this, KeepAliveManager.State.PING_SCHEDULED);
              } 
              bool = false;
            } 
            if (bool)
              KeepAliveManager.this.keepAlivePinger.ping(); 
            return;
          } 
        }
      });
  
  private final Runnable shutdown = new LogExceptionRunnable(new Runnable() {
        public void run() {
          synchronized (KeepAliveManager.this) {
            boolean bool;
            if (KeepAliveManager.this.state != KeepAliveManager.State.DISCONNECTED) {
              KeepAliveManager.access$102(KeepAliveManager.this, KeepAliveManager.State.DISCONNECTED);
              bool = true;
            } else {
              bool = false;
            } 
            if (bool)
              KeepAliveManager.this.keepAlivePinger.onPingTimeout(); 
            return;
          } 
        }
      });
  
  private ScheduledFuture<?> shutdownFuture;
  
  private State state = State.IDLE;
  
  private final Ticker ticker;
  
  static {
    MIN_KEEPALIVE_TIME_NANOS = TimeUnit.SECONDS.toNanos(10L);
    MIN_KEEPALIVE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(10L);
  }
  
  public KeepAliveManager(KeepAlivePinger paramKeepAlivePinger, ScheduledExecutorService paramScheduledExecutorService, long paramLong1, long paramLong2, boolean paramBoolean) {
    this(paramKeepAlivePinger, paramScheduledExecutorService, SYSTEM_TICKER, paramLong1, paramLong2, paramBoolean);
  }
  
  @VisibleForTesting
  KeepAliveManager(KeepAlivePinger paramKeepAlivePinger, ScheduledExecutorService paramScheduledExecutorService, Ticker paramTicker, long paramLong1, long paramLong2, boolean paramBoolean) {
    this.keepAlivePinger = (KeepAlivePinger)Preconditions.checkNotNull(paramKeepAlivePinger, "keepAlivePinger");
    this.scheduler = (ScheduledExecutorService)Preconditions.checkNotNull(paramScheduledExecutorService, "scheduler");
    this.ticker = (Ticker)Preconditions.checkNotNull(paramTicker, "ticker");
    this.keepAliveTimeInNanos = paramLong1;
    this.keepAliveTimeoutInNanos = paramLong2;
    this.keepAliveDuringTransportIdle = paramBoolean;
    this.nextKeepaliveTime = paramTicker.read() + paramLong1;
  }
  
  public static long clampKeepAliveTimeInNanos(long paramLong) {
    return Math.max(paramLong, MIN_KEEPALIVE_TIME_NANOS);
  }
  
  public static long clampKeepAliveTimeoutInNanos(long paramLong) {
    return Math.max(paramLong, MIN_KEEPALIVE_TIMEOUT_NANOS);
  }
  
  public void onDataReceived() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield ticker : Lio/grpc/internal/KeepAliveManager$Ticker;
    //   7: invokevirtual read : ()J
    //   10: aload_0
    //   11: getfield keepAliveTimeInNanos : J
    //   14: ladd
    //   15: putfield nextKeepaliveTime : J
    //   18: aload_0
    //   19: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   22: getstatic io/grpc/internal/KeepAliveManager$State.PING_SCHEDULED : Lio/grpc/internal/KeepAliveManager$State;
    //   25: if_acmpne -> 38
    //   28: aload_0
    //   29: getstatic io/grpc/internal/KeepAliveManager$State.PING_DELAYED : Lio/grpc/internal/KeepAliveManager$State;
    //   32: putfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   35: goto -> 146
    //   38: aload_0
    //   39: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   42: getstatic io/grpc/internal/KeepAliveManager$State.PING_SENT : Lio/grpc/internal/KeepAliveManager$State;
    //   45: if_acmpeq -> 58
    //   48: aload_0
    //   49: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   52: getstatic io/grpc/internal/KeepAliveManager$State.IDLE_AND_PING_SENT : Lio/grpc/internal/KeepAliveManager$State;
    //   55: if_acmpne -> 146
    //   58: aload_0
    //   59: getfield shutdownFuture : Ljava/util/concurrent/ScheduledFuture;
    //   62: astore_1
    //   63: iconst_0
    //   64: istore_2
    //   65: aload_1
    //   66: ifnull -> 80
    //   69: aload_0
    //   70: getfield shutdownFuture : Ljava/util/concurrent/ScheduledFuture;
    //   73: iconst_0
    //   74: invokeinterface cancel : (Z)Z
    //   79: pop
    //   80: aload_0
    //   81: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   84: getstatic io/grpc/internal/KeepAliveManager$State.IDLE_AND_PING_SENT : Lio/grpc/internal/KeepAliveManager$State;
    //   87: if_acmpne -> 100
    //   90: aload_0
    //   91: getstatic io/grpc/internal/KeepAliveManager$State.IDLE : Lio/grpc/internal/KeepAliveManager$State;
    //   94: putfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: aload_0
    //   101: getstatic io/grpc/internal/KeepAliveManager$State.PING_SCHEDULED : Lio/grpc/internal/KeepAliveManager$State;
    //   104: putfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   107: aload_0
    //   108: getfield pingFuture : Ljava/util/concurrent/ScheduledFuture;
    //   111: ifnonnull -> 116
    //   114: iconst_1
    //   115: istore_2
    //   116: iload_2
    //   117: ldc 'There should be no outstanding pingFuture'
    //   119: invokestatic checkState : (ZLjava/lang/Object;)V
    //   122: aload_0
    //   123: aload_0
    //   124: getfield scheduler : Ljava/util/concurrent/ScheduledExecutorService;
    //   127: aload_0
    //   128: getfield sendPing : Ljava/lang/Runnable;
    //   131: aload_0
    //   132: getfield keepAliveTimeInNanos : J
    //   135: getstatic java/util/concurrent/TimeUnit.NANOSECONDS : Ljava/util/concurrent/TimeUnit;
    //   138: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   143: putfield pingFuture : Ljava/util/concurrent/ScheduledFuture;
    //   146: aload_0
    //   147: monitorexit
    //   148: return
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	149	finally
    //   38	58	149	finally
    //   58	63	149	finally
    //   69	80	149	finally
    //   80	97	149	finally
    //   100	107	149	finally
    //   107	114	149	finally
    //   116	146	149	finally
  }
  
  public void onTransportActive() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   6: getstatic io/grpc/internal/KeepAliveManager$State.IDLE : Lio/grpc/internal/KeepAliveManager$State;
    //   9: if_acmpne -> 61
    //   12: aload_0
    //   13: getstatic io/grpc/internal/KeepAliveManager$State.PING_SCHEDULED : Lio/grpc/internal/KeepAliveManager$State;
    //   16: putfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   19: aload_0
    //   20: getfield pingFuture : Ljava/util/concurrent/ScheduledFuture;
    //   23: ifnonnull -> 78
    //   26: aload_0
    //   27: aload_0
    //   28: getfield scheduler : Ljava/util/concurrent/ScheduledExecutorService;
    //   31: aload_0
    //   32: getfield sendPing : Ljava/lang/Runnable;
    //   35: aload_0
    //   36: getfield nextKeepaliveTime : J
    //   39: aload_0
    //   40: getfield ticker : Lio/grpc/internal/KeepAliveManager$Ticker;
    //   43: invokevirtual read : ()J
    //   46: lsub
    //   47: getstatic java/util/concurrent/TimeUnit.NANOSECONDS : Ljava/util/concurrent/TimeUnit;
    //   50: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   55: putfield pingFuture : Ljava/util/concurrent/ScheduledFuture;
    //   58: goto -> 78
    //   61: aload_0
    //   62: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   65: getstatic io/grpc/internal/KeepAliveManager$State.IDLE_AND_PING_SENT : Lio/grpc/internal/KeepAliveManager$State;
    //   68: if_acmpne -> 78
    //   71: aload_0
    //   72: getstatic io/grpc/internal/KeepAliveManager$State.PING_SENT : Lio/grpc/internal/KeepAliveManager$State;
    //   75: putfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Exception table:
    //   from	to	target	type
    //   2	58	81	finally
    //   61	78	81	finally
  }
  
  public void onTransportIdle() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield keepAliveDuringTransportIdle : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   18: getstatic io/grpc/internal/KeepAliveManager$State.PING_SCHEDULED : Lio/grpc/internal/KeepAliveManager$State;
    //   21: if_acmpeq -> 34
    //   24: aload_0
    //   25: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   28: getstatic io/grpc/internal/KeepAliveManager$State.PING_DELAYED : Lio/grpc/internal/KeepAliveManager$State;
    //   31: if_acmpne -> 41
    //   34: aload_0
    //   35: getstatic io/grpc/internal/KeepAliveManager$State.IDLE : Lio/grpc/internal/KeepAliveManager$State;
    //   38: putfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   41: aload_0
    //   42: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   45: getstatic io/grpc/internal/KeepAliveManager$State.PING_SENT : Lio/grpc/internal/KeepAliveManager$State;
    //   48: if_acmpne -> 58
    //   51: aload_0
    //   52: getstatic io/grpc/internal/KeepAliveManager$State.IDLE_AND_PING_SENT : Lio/grpc/internal/KeepAliveManager$State;
    //   55: putfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   14	34	61	finally
    //   34	41	61	finally
    //   41	58	61	finally
  }
  
  public void onTransportStarted() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield keepAliveDuringTransportIdle : Z
    //   6: ifeq -> 13
    //   9: aload_0
    //   10: invokevirtual onTransportActive : ()V
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
  
  public void onTransportTermination() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   6: getstatic io/grpc/internal/KeepAliveManager$State.DISCONNECTED : Lio/grpc/internal/KeepAliveManager$State;
    //   9: if_acmpeq -> 60
    //   12: aload_0
    //   13: getstatic io/grpc/internal/KeepAliveManager$State.DISCONNECTED : Lio/grpc/internal/KeepAliveManager$State;
    //   16: putfield state : Lio/grpc/internal/KeepAliveManager$State;
    //   19: aload_0
    //   20: getfield shutdownFuture : Ljava/util/concurrent/ScheduledFuture;
    //   23: ifnull -> 37
    //   26: aload_0
    //   27: getfield shutdownFuture : Ljava/util/concurrent/ScheduledFuture;
    //   30: iconst_0
    //   31: invokeinterface cancel : (Z)Z
    //   36: pop
    //   37: aload_0
    //   38: getfield pingFuture : Ljava/util/concurrent/ScheduledFuture;
    //   41: ifnull -> 60
    //   44: aload_0
    //   45: getfield pingFuture : Ljava/util/concurrent/ScheduledFuture;
    //   48: iconst_0
    //   49: invokeinterface cancel : (Z)Z
    //   54: pop
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield pingFuture : Ljava/util/concurrent/ScheduledFuture;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	63	finally
    //   37	60	63	finally
  }
  
  public static final class ClientKeepAlivePinger implements KeepAlivePinger {
    private final ConnectionClientTransport transport;
    
    public ClientKeepAlivePinger(ConnectionClientTransport param1ConnectionClientTransport) {
      this.transport = param1ConnectionClientTransport;
    }
    
    public void onPingTimeout() {
      this.transport.shutdownNow(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone"));
    }
    
    public void ping() {
      this.transport.ping(new ClientTransport$PingCallback() {
            public void onFailure(Throwable param2Throwable) {
              KeepAliveManager.ClientKeepAlivePinger.this.transport.shutdownNow(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone"));
            }
            
            public void onSuccess(long param2Long) {}
          },  MoreExecutors.directExecutor());
    }
  }
  
  class null implements ClientTransport$PingCallback {
    public void onFailure(Throwable param1Throwable) {
      this.this$0.transport.shutdownNow(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone"));
    }
    
    public void onSuccess(long param1Long) {}
  }
  
  public static interface KeepAlivePinger {
    void onPingTimeout();
    
    void ping();
  }
  
  private enum State {
    DISCONNECTED, IDLE, IDLE_AND_PING_SENT, PING_DELAYED, PING_SCHEDULED, PING_SENT;
    
    static {
      IDLE_AND_PING_SENT = new State("IDLE_AND_PING_SENT", 4);
      DISCONNECTED = new State("DISCONNECTED", 5);
      $VALUES = new State[] { IDLE, PING_SCHEDULED, PING_DELAYED, PING_SENT, IDLE_AND_PING_SENT, DISCONNECTED };
    }
  }
  
  private static class SystemTicker extends Ticker {
    private SystemTicker() {}
    
    public long read() {
      return System.nanoTime();
    }
  }
  
  static abstract class Ticker {
    public abstract long read();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\KeepAliveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */