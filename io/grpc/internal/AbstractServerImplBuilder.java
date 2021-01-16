package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.Internal;
import io.grpc.InternalNotifyOnServerBuild;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerStreamTracer;
import io.grpc.ServerTransportFilter;
import io.opencensus.trace.Tracing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class AbstractServerImplBuilder<T extends AbstractServerImplBuilder<T>> extends ServerBuilder<T> {
  private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY;
  
  private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY;
  
  private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource((SharedResourceHolder.Resource)GrpcUtil.SHARED_CHANNEL_EXECUTOR);
  
  private static final HandlerRegistry DEFAULT_FALLBACK_REGISTRY = new HandlerRegistry() {
      public List<ServerServiceDefinition> getServices() {
        return Collections.emptyList();
      }
      
      public ServerMethodDefinition<?, ?> lookupMethod(String param1String1, @Nullable String param1String2) {
        return null;
      }
    };
  
  private static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS;
  
  protected BinaryLogProvider binlogProvider = BinaryLogProvider.provider();
  
  protected CallTracer.Factory callTracerFactory = CallTracer.getDefaultFactory();
  
  @Nullable
  private CensusStatsModule censusStatsOverride;
  
  protected Channelz channelz = Channelz.instance();
  
  CompressorRegistry compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
  
  DecompressorRegistry decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
  
  ObjectPool<? extends Executor> executorPool = DEFAULT_EXECUTOR_POOL;
  
  HandlerRegistry fallbackRegistry = DEFAULT_FALLBACK_REGISTRY;
  
  long handshakeTimeoutMillis = DEFAULT_HANDSHAKE_TIMEOUT_MILLIS;
  
  final List<ServerInterceptor> interceptors = new ArrayList<ServerInterceptor>();
  
  private final List<InternalNotifyOnServerBuild> notifyOnBuildList = new ArrayList<InternalNotifyOnServerBuild>();
  
  private boolean recordFinishedRpcs = true;
  
  private boolean recordStartedRpcs = true;
  
  final InternalHandlerRegistry.Builder registryBuilder = new InternalHandlerRegistry.Builder();
  
  private boolean statsEnabled = true;
  
  private final List<ServerStreamTracer.Factory> streamTracerFactories = new ArrayList<ServerStreamTracer.Factory>();
  
  private boolean tracingEnabled = true;
  
  final List<ServerTransportFilter> transportFilters = new ArrayList<ServerTransportFilter>();
  
  protected TransportTracer.Factory transportTracerFactory = TransportTracer.getDefaultFactory();
  
  static {
    DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();
    DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(120L);
  }
  
  public static ServerBuilder<?> forPort(int paramInt) {
    throw new UnsupportedOperationException("Subclass failed to hide static factory");
  }
  
  private T thisT() {
    return (T)this;
  }
  
  public final T addService(BindableService paramBindableService) {
    if (paramBindableService instanceof InternalNotifyOnServerBuild)
      this.notifyOnBuildList.add((InternalNotifyOnServerBuild)paramBindableService); 
    return addService(paramBindableService.bindService());
  }
  
  public final T addService(ServerServiceDefinition paramServerServiceDefinition) {
    this.registryBuilder.addService(paramServerServiceDefinition);
    return thisT();
  }
  
  public final T addStreamTracerFactory(ServerStreamTracer.Factory paramFactory) {
    this.streamTracerFactories.add(Preconditions.checkNotNull(paramFactory, "factory"));
    return thisT();
  }
  
  public final T addTransportFilter(ServerTransportFilter paramServerTransportFilter) {
    this.transportFilters.add(Preconditions.checkNotNull(paramServerTransportFilter, "filter"));
    return thisT();
  }
  
  public Server build() {
    ServerImpl serverImpl = new ServerImpl(this, buildTransportServer(Collections.unmodifiableList(getTracerFactories())), Context.ROOT);
    Iterator<InternalNotifyOnServerBuild> iterator = this.notifyOnBuildList.iterator();
    while (iterator.hasNext())
      ((InternalNotifyOnServerBuild)iterator.next()).notifyOnBuild(serverImpl); 
    return serverImpl;
  }
  
  @Internal
  protected abstract InternalServer buildTransportServer(List<ServerStreamTracer.Factory> paramList);
  
  public final T compressorRegistry(CompressorRegistry paramCompressorRegistry) {
    if (paramCompressorRegistry != null) {
      this.compressorRegistry = paramCompressorRegistry;
    } else {
      this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
    } 
    return thisT();
  }
  
  public final T decompressorRegistry(DecompressorRegistry paramDecompressorRegistry) {
    if (paramDecompressorRegistry != null) {
      this.decompressorRegistry = paramDecompressorRegistry;
    } else {
      this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
    } 
    return thisT();
  }
  
  public final T directExecutor() {
    return executor(MoreExecutors.directExecutor());
  }
  
  public final T executor(@Nullable Executor paramExecutor) {
    if (paramExecutor != null) {
      this.executorPool = new FixedObjectPool<Executor>(paramExecutor);
    } else {
      this.executorPool = DEFAULT_EXECUTOR_POOL;
    } 
    return thisT();
  }
  
  public final T fallbackHandlerRegistry(HandlerRegistry paramHandlerRegistry) {
    if (paramHandlerRegistry != null) {
      this.fallbackRegistry = paramHandlerRegistry;
    } else {
      this.fallbackRegistry = DEFAULT_FALLBACK_REGISTRY;
    } 
    return thisT();
  }
  
  @VisibleForTesting
  final List<ServerStreamTracer.Factory> getTracerFactories() {
    ArrayList<ServerStreamTracer.Factory> arrayList = new ArrayList();
    if (this.statsEnabled) {
      CensusStatsModule censusStatsModule1 = this.censusStatsOverride;
      CensusStatsModule censusStatsModule2 = censusStatsModule1;
      if (censusStatsModule1 == null)
        censusStatsModule2 = new CensusStatsModule(GrpcUtil.STOPWATCH_SUPPLIER, true); 
      arrayList.add(censusStatsModule2.getServerTracerFactory(this.recordStartedRpcs, this.recordFinishedRpcs));
    } 
    if (this.tracingEnabled)
      arrayList.add((new CensusTracingModule(Tracing.getTracer(), Tracing.getPropagationComponent().getBinaryFormat())).getServerTracerFactory()); 
    BinaryLogProvider binaryLogProvider = this.binlogProvider;
    if (binaryLogProvider != null)
      arrayList.add(binaryLogProvider.getServerCallIdSetter()); 
    arrayList.addAll(this.streamTracerFactories);
    return arrayList;
  }
  
  public final T handshakeTimeout(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "handshake timeout is %s, but must be positive", paramLong);
    this.handshakeTimeoutMillis = paramTimeUnit.toMillis(paramLong);
    return thisT();
  }
  
  public final T intercept(ServerInterceptor paramServerInterceptor) {
    this.interceptors.add(paramServerInterceptor);
    return thisT();
  }
  
  @VisibleForTesting
  protected T overrideCensusStatsModule(CensusStatsModule paramCensusStatsModule) {
    this.censusStatsOverride = paramCensusStatsModule;
    return thisT();
  }
  
  protected void setStatsEnabled(boolean paramBoolean) {
    this.statsEnabled = paramBoolean;
  }
  
  protected void setStatsRecordFinishedRpcs(boolean paramBoolean) {
    this.recordFinishedRpcs = paramBoolean;
  }
  
  protected void setStatsRecordStartedRpcs(boolean paramBoolean) {
    this.recordStartedRpcs = paramBoolean;
  }
  
  protected void setTracingEnabled(boolean paramBoolean) {
    this.tracingEnabled = paramBoolean;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AbstractServerImplBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */