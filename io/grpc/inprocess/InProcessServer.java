package io.grpc.inprocess;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.Channelz;
import io.grpc.internal.Instrumented;
import io.grpc.internal.InternalServer;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import io.grpc.internal.ServerTransportListener;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class InProcessServer implements InternalServer {
  private static final ConcurrentMap<String, InProcessServer> registry = new ConcurrentHashMap<String, InProcessServer>();
  
  private ServerListener listener;
  
  private final String name;
  
  private ScheduledExecutorService scheduler;
  
  private final ObjectPool<ScheduledExecutorService> schedulerPool;
  
  private boolean shutdown;
  
  private final List<ServerStreamTracer.Factory> streamTracerFactories;
  
  InProcessServer(String paramString, ObjectPool<ScheduledExecutorService> paramObjectPool, List<ServerStreamTracer.Factory> paramList) {
    this.name = paramString;
    this.schedulerPool = paramObjectPool;
    this.streamTracerFactories = Collections.unmodifiableList((List<? extends ServerStreamTracer.Factory>)Preconditions.checkNotNull(paramList, "streamTracerFactories"));
  }
  
  static InProcessServer findServer(String paramString) {
    return registry.get(paramString);
  }
  
  public List<Instrumented<Channelz.SocketStats>> getListenSockets() {
    return Collections.emptyList();
  }
  
  public int getPort() {
    return -1;
  }
  
  ObjectPool<ScheduledExecutorService> getScheduledExecutorServicePool() {
    return this.schedulerPool;
  }
  
  List<ServerStreamTracer.Factory> getStreamTracerFactories() {
    return this.streamTracerFactories;
  }
  
  ServerTransportListener register(InProcessTransport paramInProcessTransport) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield shutdown : Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield listener : Lio/grpc/internal/ServerListener;
    //   19: aload_1
    //   20: invokeinterface transportCreated : (Lio/grpc/internal/ServerTransport;)Lio/grpc/internal/ServerTransportListener;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	30	finally
    //   15	26	30	finally
  }
  
  public void shutdown() {
    // Byte code:
    //   0: getstatic io/grpc/inprocess/InProcessServer.registry : Ljava/util/concurrent/ConcurrentMap;
    //   3: aload_0
    //   4: getfield name : Ljava/lang/String;
    //   7: aload_0
    //   8: invokeinterface remove : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   13: ifeq -> 60
    //   16: aload_0
    //   17: aload_0
    //   18: getfield schedulerPool : Lio/grpc/internal/ObjectPool;
    //   21: aload_0
    //   22: getfield scheduler : Ljava/util/concurrent/ScheduledExecutorService;
    //   25: invokeinterface returnObject : (Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast java/util/concurrent/ScheduledExecutorService
    //   33: putfield scheduler : Ljava/util/concurrent/ScheduledExecutorService;
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield shutdown : Z
    //   43: aload_0
    //   44: getfield listener : Lio/grpc/internal/ServerListener;
    //   47: invokeinterface serverShutdown : ()V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    //   60: new java/lang/AssertionError
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   38	54	55	finally
    //   56	58	55	finally
  }
  
  public void start(ServerListener paramServerListener) throws IOException {
    this.listener = paramServerListener;
    this.scheduler = (ScheduledExecutorService)this.schedulerPool.getObject();
    if (registry.putIfAbsent(this.name, this) == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("name already registered: ");
    stringBuilder.append(this.name);
    throw new IOException(stringBuilder.toString());
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", this.name).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\inprocess\InProcessServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */