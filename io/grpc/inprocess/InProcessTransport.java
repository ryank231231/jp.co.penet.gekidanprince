package io.grpc.inprocess;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.internal.Channelz;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.LogId;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class InProcessTransport implements ServerTransport, ConnectionClientTransport {
  private static final Logger log = Logger.getLogger(InProcessTransport.class.getName());
  
  private final String authority;
  
  private ManagedClientTransport.Listener clientTransportListener;
  
  private final LogId logId = LogId.allocate(getClass().getName());
  
  private final String name;
  
  private ScheduledExecutorService serverScheduler;
  
  private ObjectPool<ScheduledExecutorService> serverSchedulerPool;
  
  private Attributes serverStreamAttributes;
  
  @GuardedBy("this")
  private List<ServerStreamTracer.Factory> serverStreamTracerFactories;
  
  private ServerTransportListener serverTransportListener;
  
  @GuardedBy("this")
  private boolean shutdown;
  
  @GuardedBy("this")
  private Status shutdownStatus;
  
  @GuardedBy("this")
  private Set<InProcessStream> streams = new HashSet<InProcessStream>();
  
  @GuardedBy("this")
  private boolean terminated;
  
  private final String userAgent;
  
  public InProcessTransport(String paramString1, String paramString2, String paramString3) {
    this.name = paramString1;
    this.authority = paramString2;
    this.userAgent = GrpcUtil.getGrpcUserAgent("inprocess", paramString3);
  }
  
  private void notifyShutdown(Status paramStatus) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield shutdown : Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield shutdown : Z
    //   19: aload_0
    //   20: getfield clientTransportListener : Lio/grpc/internal/ManagedClientTransport$Listener;
    //   23: aload_1
    //   24: invokeinterface transportShutdown : (Lio/grpc/Status;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   14	29	32	finally
  }
  
  private void notifyTerminated() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield terminated : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield terminated : Z
    //   19: aload_0
    //   20: getfield serverScheduler : Ljava/util/concurrent/ScheduledExecutorService;
    //   23: ifnull -> 46
    //   26: aload_0
    //   27: aload_0
    //   28: getfield serverSchedulerPool : Lio/grpc/internal/ObjectPool;
    //   31: aload_0
    //   32: getfield serverScheduler : Ljava/util/concurrent/ScheduledExecutorService;
    //   35: invokeinterface returnObject : (Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast java/util/concurrent/ScheduledExecutorService
    //   43: putfield serverScheduler : Ljava/util/concurrent/ScheduledExecutorService;
    //   46: aload_0
    //   47: getfield clientTransportListener : Lio/grpc/internal/ManagedClientTransport$Listener;
    //   50: invokeinterface transportTerminated : ()V
    //   55: aload_0
    //   56: getfield serverTransportListener : Lio/grpc/internal/ServerTransportListener;
    //   59: ifnull -> 71
    //   62: aload_0
    //   63: getfield serverTransportListener : Lio/grpc/internal/ServerTransportListener;
    //   66: invokeinterface transportTerminated : ()V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	74	finally
    //   14	46	74	finally
    //   46	71	74	finally
  }
  
  private static Status stripCause(Status paramStatus) {
    return (paramStatus == null) ? null : Status.fromCodeValue(paramStatus.getCode().value()).withDescription(paramStatus.getDescription());
  }
  
  public Attributes getAttributes() {
    return Attributes.EMPTY;
  }
  
  public LogId getLogId() {
    return this.logId;
  }
  
  public ScheduledExecutorService getScheduledExecutorService() {
    return this.serverScheduler;
  }
  
  public ListenableFuture<Channelz.SocketStats> getStats() {
    SettableFuture settableFuture = SettableFuture.create();
    settableFuture.set(null);
    return (ListenableFuture<Channelz.SocketStats>)settableFuture;
  }
  
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield shutdownStatus : Lio/grpc/Status;
    //   6: ifnull -> 33
    //   9: aload_0
    //   10: getfield shutdownStatus : Lio/grpc/Status;
    //   13: astore_1
    //   14: new io/grpc/inprocess/InProcessTransport$3
    //   17: dup
    //   18: aload_0
    //   19: aload_3
    //   20: aload_2
    //   21: invokestatic newClientContext : (Lio/grpc/CallOptions;Lio/grpc/Metadata;)Lio/grpc/internal/StatsTraceContext;
    //   24: aload_1
    //   25: invokespecial <init> : (Lio/grpc/inprocess/InProcessTransport;Lio/grpc/internal/StatsTraceContext;Lio/grpc/Status;)V
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: aload_2
    //   34: getstatic io/grpc/internal/GrpcUtil.USER_AGENT_KEY : Lio/grpc/Metadata$Key;
    //   37: aload_0
    //   38: getfield userAgent : Ljava/lang/String;
    //   41: invokevirtual put : (Lio/grpc/Metadata$Key;Ljava/lang/Object;)V
    //   44: new io/grpc/inprocess/InProcessTransport$InProcessStream
    //   47: astore #4
    //   49: aload #4
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: aload_3
    //   55: aload_0
    //   56: getfield authority : Ljava/lang/String;
    //   59: aconst_null
    //   60: invokespecial <init> : (Lio/grpc/inprocess/InProcessTransport;Lio/grpc/MethodDescriptor;Lio/grpc/Metadata;Lio/grpc/CallOptions;Ljava/lang/String;Lio/grpc/inprocess/InProcessTransport$1;)V
    //   63: aload #4
    //   65: invokestatic access$700 : (Lio/grpc/inprocess/InProcessTransport$InProcessStream;)Lio/grpc/inprocess/InProcessTransport$InProcessStream$InProcessClientStream;
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	73	finally
    //   33	69	73	finally
  }
  
  public void ping(ClientTransport.PingCallback paramPingCallback, Executor paramExecutor) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield terminated : Z
    //   6: ifeq -> 38
    //   9: aload_0
    //   10: getfield shutdownStatus : Lio/grpc/Status;
    //   13: astore_3
    //   14: new io/grpc/inprocess/InProcessTransport$4
    //   17: astore #4
    //   19: aload #4
    //   21: aload_0
    //   22: aload_1
    //   23: aload_3
    //   24: invokespecial <init> : (Lio/grpc/inprocess/InProcessTransport;Lio/grpc/internal/ClientTransport$PingCallback;Lio/grpc/Status;)V
    //   27: aload_2
    //   28: aload #4
    //   30: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   35: goto -> 58
    //   38: new io/grpc/inprocess/InProcessTransport$5
    //   41: astore #4
    //   43: aload #4
    //   45: aload_0
    //   46: aload_1
    //   47: invokespecial <init> : (Lio/grpc/inprocess/InProcessTransport;Lio/grpc/internal/ClientTransport$PingCallback;)V
    //   50: aload_2
    //   51: aload #4
    //   53: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	61	finally
    //   38	58	61	finally
  }
  
  public void shutdown() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic io/grpc/Status.UNAVAILABLE : Lio/grpc/Status;
    //   6: ldc_w 'InProcessTransport shutdown by the server-side'
    //   9: invokevirtual withDescription : (Ljava/lang/String;)Lio/grpc/Status;
    //   12: invokevirtual shutdown : (Lio/grpc/Status;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
  }
  
  public void shutdown(Status paramStatus) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield shutdown : Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: putfield shutdownStatus : Lio/grpc/Status;
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial notifyShutdown : (Lio/grpc/Status;)V
    //   24: aload_0
    //   25: getfield streams : Ljava/util/Set;
    //   28: invokeinterface isEmpty : ()Z
    //   33: ifeq -> 40
    //   36: aload_0
    //   37: invokespecial notifyTerminated : ()V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   14	40	43	finally
  }
  
  public void shutdownNow(Status paramStatus) {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 'reason'
    //   4: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual shutdown : (Lio/grpc/Status;)V
    //   15: aload_0
    //   16: getfield terminated : Z
    //   19: ifeq -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: new java/util/ArrayList
    //   28: astore_2
    //   29: aload_2
    //   30: aload_0
    //   31: getfield streams : Ljava/util/Set;
    //   34: invokespecial <init> : (Ljava/util/Collection;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: invokeinterface iterator : ()Ljava/util/Iterator;
    //   45: astore_2
    //   46: aload_2
    //   47: invokeinterface hasNext : ()Z
    //   52: ifeq -> 74
    //   55: aload_2
    //   56: invokeinterface next : ()Ljava/lang/Object;
    //   61: checkcast io/grpc/inprocess/InProcessTransport$InProcessStream
    //   64: invokestatic access$700 : (Lio/grpc/inprocess/InProcessTransport$InProcessStream;)Lio/grpc/inprocess/InProcessTransport$InProcessStream$InProcessClientStream;
    //   67: aload_1
    //   68: invokevirtual cancel : (Lio/grpc/Status;)V
    //   71: goto -> 46
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	75	finally
    //   25	39	75	finally
    //   76	78	75	finally
  }
  
  @CheckReturnValue
  public Runnable start(ManagedClientTransport.Listener paramListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield clientTransportListener : Lio/grpc/internal/ManagedClientTransport$Listener;
    //   7: aload_0
    //   8: getfield name : Ljava/lang/String;
    //   11: invokestatic findServer : (Ljava/lang/String;)Lio/grpc/inprocess/InProcessServer;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull -> 60
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual getScheduledExecutorServicePool : ()Lio/grpc/internal/ObjectPool;
    //   24: putfield serverSchedulerPool : Lio/grpc/internal/ObjectPool;
    //   27: aload_0
    //   28: aload_0
    //   29: getfield serverSchedulerPool : Lio/grpc/internal/ObjectPool;
    //   32: invokeinterface getObject : ()Ljava/lang/Object;
    //   37: checkcast java/util/concurrent/ScheduledExecutorService
    //   40: putfield serverScheduler : Ljava/util/concurrent/ScheduledExecutorService;
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual getStreamTracerFactories : ()Ljava/util/List;
    //   48: putfield serverStreamTracerFactories : Ljava/util/List;
    //   51: aload_0
    //   52: aload_1
    //   53: aload_0
    //   54: invokevirtual register : (Lio/grpc/inprocess/InProcessTransport;)Lio/grpc/internal/ServerTransportListener;
    //   57: putfield serverTransportListener : Lio/grpc/internal/ServerTransportListener;
    //   60: aload_0
    //   61: getfield serverTransportListener : Lio/grpc/internal/ServerTransportListener;
    //   64: ifnonnull -> 125
    //   67: getstatic io/grpc/Status.UNAVAILABLE : Lio/grpc/Status;
    //   70: astore_2
    //   71: new java/lang/StringBuilder
    //   74: astore_1
    //   75: aload_1
    //   76: invokespecial <init> : ()V
    //   79: aload_1
    //   80: ldc_w 'Could not find server: '
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_1
    //   88: aload_0
    //   89: getfield name : Ljava/lang/String;
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_0
    //   97: aload_2
    //   98: aload_1
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokevirtual withDescription : (Ljava/lang/String;)Lio/grpc/Status;
    //   105: putfield shutdownStatus : Lio/grpc/Status;
    //   108: new io/grpc/inprocess/InProcessTransport$1
    //   111: dup
    //   112: aload_0
    //   113: aload_0
    //   114: getfield shutdownStatus : Lio/grpc/Status;
    //   117: invokespecial <init> : (Lio/grpc/inprocess/InProcessTransport;Lio/grpc/Status;)V
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: areturn
    //   125: new io/grpc/inprocess/InProcessTransport$2
    //   128: dup
    //   129: aload_0
    //   130: invokespecial <init> : (Lio/grpc/inprocess/InProcessTransport;)V
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: areturn
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	138	finally
    //   19	60	138	finally
    //   60	121	138	finally
    //   125	134	138	finally
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getLogId());
    stringBuilder.append("(");
    stringBuilder.append(this.name);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  class InProcessTransport {}
  
  class InProcessTransport {}
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\inprocess\InProcessTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */