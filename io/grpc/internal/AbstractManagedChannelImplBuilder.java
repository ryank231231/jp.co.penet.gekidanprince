package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.opencensus.trace.Tracing;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class AbstractManagedChannelImplBuilder<T extends AbstractManagedChannelImplBuilder<T>> extends ManagedChannelBuilder<T> {
  private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY;
  
  private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY;
  
  private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL;
  
  private static final NameResolver.Factory DEFAULT_NAME_RESOLVER_FACTORY;
  
  private static final long DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES = 1048576L;
  
  private static final long DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES = 16777216L;
  
  private static final String DIRECT_ADDRESS_SCHEME = "directaddress";
  
  @VisibleForTesting
  static final long IDLE_MODE_DEFAULT_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(30L);
  
  @VisibleForTesting
  static final long IDLE_MODE_MAX_TIMEOUT_DAYS = 30L;
  
  @VisibleForTesting
  static final long IDLE_MODE_MIN_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(1L);
  
  @Nullable
  @VisibleForTesting
  String authorityOverride;
  
  @Nullable
  BinaryLogProvider binlogProvider = BinaryLogProvider.provider();
  
  @Nullable
  private CensusStatsModule censusStatsOverride;
  
  Channelz channelz = Channelz.instance();
  
  CompressorRegistry compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
  
  DecompressorRegistry decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
  
  @Nullable
  private final SocketAddress directServerAddress;
  
  ObjectPool<? extends Executor> executorPool = DEFAULT_EXECUTOR_POOL;
  
  boolean fullStreamDecompression;
  
  long idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
  
  private final List<ClientInterceptor> interceptors = new ArrayList<ClientInterceptor>();
  
  @Nullable
  LoadBalancer.Factory loadBalancerFactory;
  
  int maxHedgedAttempts = 5;
  
  private int maxInboundMessageSize = 4194304;
  
  int maxRetryAttempts = 5;
  
  private NameResolver.Factory nameResolverFactory = DEFAULT_NAME_RESOLVER_FACTORY;
  
  long perRpcBufferLimit = 1048576L;
  
  private boolean recordFinishedRpcs = true;
  
  private boolean recordStartedRpcs = true;
  
  long retryBufferSize = 16777216L;
  
  boolean retryEnabled = false;
  
  private boolean statsEnabled = true;
  
  final String target;
  
  boolean temporarilyDisableRetry;
  
  private boolean tracingEnabled = true;
  
  protected TransportTracer.Factory transportTracerFactory = TransportTracer.getDefaultFactory();
  
  @Nullable
  String userAgent;
  
  static {
    DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource((SharedResourceHolder.Resource)GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    DEFAULT_NAME_RESOLVER_FACTORY = NameResolverProvider.asFactory();
    DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();
  }
  
  protected AbstractManagedChannelImplBuilder(String paramString) {
    this.target = (String)Preconditions.checkNotNull(paramString, "target");
    this.directServerAddress = null;
  }
  
  protected AbstractManagedChannelImplBuilder(SocketAddress paramSocketAddress, String paramString) {
    this.target = makeTargetStringForDirectAddress(paramSocketAddress);
    this.directServerAddress = paramSocketAddress;
    this.nameResolverFactory = new DirectAddressNameResolverFactory(paramSocketAddress, paramString);
  }
  
  public static ManagedChannelBuilder<?> forAddress(String paramString, int paramInt) {
    throw new UnsupportedOperationException("Subclass failed to hide static factory");
  }
  
  public static ManagedChannelBuilder<?> forTarget(String paramString) {
    throw new UnsupportedOperationException("Subclass failed to hide static factory");
  }
  
  @VisibleForTesting
  static String makeTargetStringForDirectAddress(SocketAddress paramSocketAddress) {
    try {
      URI uRI = new URI();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("/");
      stringBuilder.append(paramSocketAddress);
      this("directaddress", "", stringBuilder.toString(), null);
      return uRI.toString();
    } catch (URISyntaxException uRISyntaxException) {
      throw new RuntimeException(uRISyntaxException);
    } 
  }
  
  private T thisT() {
    return (T)this;
  }
  
  public ManagedChannel build() {
    return new ManagedChannelOrphanWrapper(new ManagedChannelImpl(this, buildTransportFactory(), new ExponentialBackoffPolicy.Provider(), SharedResourcePool.forResource((SharedResourceHolder.Resource)GrpcUtil.SHARED_CHANNEL_EXECUTOR), GrpcUtil.STOPWATCH_SUPPLIER, getEffectiveInterceptors(), CallTracer.getDefaultFactory()));
  }
  
  protected abstract ClientTransportFactory buildTransportFactory();
  
  protected String checkAuthority(String paramString) {
    return GrpcUtil.checkAuthority(paramString);
  }
  
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
  
  public final T disableRetry() {
    this.retryEnabled = false;
    return thisT();
  }
  
  public final T enableFullStreamDecompression() {
    this.fullStreamDecompression = true;
    return thisT();
  }
  
  public final T enableRetry() {
    this.retryEnabled = true;
    return thisT();
  }
  
  public final T executor(Executor paramExecutor) {
    if (paramExecutor != null) {
      this.executorPool = new FixedObjectPool<Executor>(paramExecutor);
    } else {
      this.executorPool = DEFAULT_EXECUTOR_POOL;
    } 
    return thisT();
  }
  
  @VisibleForTesting
  final List<ClientInterceptor> getEffectiveInterceptors() {
    ArrayList<ClientInterceptor> arrayList = new ArrayList<ClientInterceptor>(this.interceptors);
    this.temporarilyDisableRetry = false;
    if (this.statsEnabled) {
      this.temporarilyDisableRetry = true;
      CensusStatsModule censusStatsModule1 = this.censusStatsOverride;
      CensusStatsModule censusStatsModule2 = censusStatsModule1;
      if (censusStatsModule1 == null)
        censusStatsModule2 = new CensusStatsModule(GrpcUtil.STOPWATCH_SUPPLIER, true); 
      arrayList.add(0, censusStatsModule2.getClientInterceptor(this.recordStartedRpcs, this.recordFinishedRpcs));
    } 
    if (this.tracingEnabled) {
      this.temporarilyDisableRetry = true;
      arrayList.add(0, (new CensusTracingModule(Tracing.getTracer(), Tracing.getPropagationComponent().getBinaryFormat())).getClientInterceptor());
    } 
    BinaryLogProvider binaryLogProvider = this.binlogProvider;
    if (binaryLogProvider != null)
      arrayList.add(0, binaryLogProvider.getClientCallIdSetter()); 
    return arrayList;
  }
  
  @VisibleForTesting
  final long getIdleTimeoutMillis() {
    return this.idleTimeoutMillis;
  }
  
  NameResolver.Factory getNameResolverFactory() {
    String str = this.authorityOverride;
    return (str == null) ? this.nameResolverFactory : new OverrideAuthorityNameResolverFactory(this.nameResolverFactory, str);
  }
  
  protected Attributes getNameResolverParams() {
    return Attributes.EMPTY;
  }
  
  public final T idleTimeout(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "idle timeout is %s, but must be positive", paramLong);
    if (paramTimeUnit.toDays(paramLong) >= 30L) {
      this.idleTimeoutMillis = -1L;
    } else {
      this.idleTimeoutMillis = Math.max(paramTimeUnit.toMillis(paramLong), IDLE_MODE_MIN_TIMEOUT_MILLIS);
    } 
    return thisT();
  }
  
  public final T intercept(List<ClientInterceptor> paramList) {
    this.interceptors.addAll(paramList);
    return thisT();
  }
  
  public final T intercept(ClientInterceptor... paramVarArgs) {
    return intercept(Arrays.asList(paramVarArgs));
  }
  
  public final T loadBalancerFactory(LoadBalancer.Factory paramFactory) {
    boolean bool;
    if (this.directServerAddress == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "directServerAddress is set (%s), which forbids the use of LoadBalancer.Factory", this.directServerAddress);
    this.loadBalancerFactory = paramFactory;
    return thisT();
  }
  
  public final T maxHedgedAttempts(int paramInt) {
    this.maxHedgedAttempts = paramInt;
    return thisT();
  }
  
  protected final int maxInboundMessageSize() {
    return this.maxInboundMessageSize;
  }
  
  public T maxInboundMessageSize(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "negative max");
    this.maxInboundMessageSize = paramInt;
    return thisT();
  }
  
  public final T maxRetryAttempts(int paramInt) {
    this.maxRetryAttempts = paramInt;
    return thisT();
  }
  
  public final T nameResolverFactory(NameResolver.Factory paramFactory) {
    boolean bool;
    if (this.directServerAddress == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", this.directServerAddress);
    if (paramFactory != null) {
      this.nameResolverFactory = paramFactory;
    } else {
      this.nameResolverFactory = DEFAULT_NAME_RESOLVER_FACTORY;
    } 
    return thisT();
  }
  
  public final T overrideAuthority(String paramString) {
    this.authorityOverride = checkAuthority(paramString);
    return thisT();
  }
  
  @VisibleForTesting
  protected final T overrideCensusStatsModule(CensusStatsModule paramCensusStatsModule) {
    this.censusStatsOverride = paramCensusStatsModule;
    return thisT();
  }
  
  public final T perRpcBufferLimit(long paramLong) {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "per RPC buffer limit must be positive");
    this.perRpcBufferLimit = paramLong;
    return thisT();
  }
  
  public final T retryBufferSize(long paramLong) {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "retry buffer size must be positive");
    this.retryBufferSize = paramLong;
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
  
  public final T userAgent(@Nullable String paramString) {
    this.userAgent = paramString;
    return thisT();
  }
  
  private static class DirectAddressNameResolverFactory extends NameResolver.Factory {
    final SocketAddress address;
    
    final String authority;
    
    DirectAddressNameResolverFactory(SocketAddress param1SocketAddress, String param1String) {
      this.address = param1SocketAddress;
      this.authority = param1String;
    }
    
    public String getDefaultScheme() {
      return "directaddress";
    }
    
    public NameResolver newNameResolver(URI param1URI, Attributes param1Attributes) {
      return new NameResolver() {
          public String getServiceAuthority() {
            return AbstractManagedChannelImplBuilder.DirectAddressNameResolverFactory.this.authority;
          }
          
          public void shutdown() {}
          
          public void start(NameResolver.Listener param2Listener) {
            param2Listener.onAddresses(Collections.singletonList(new EquivalentAddressGroup(AbstractManagedChannelImplBuilder.DirectAddressNameResolverFactory.this.address)), Attributes.EMPTY);
          }
        };
    }
  }
  
  class null extends NameResolver {
    public String getServiceAuthority() {
      return this.this$0.authority;
    }
    
    public void shutdown() {}
    
    public void start(NameResolver.Listener param1Listener) {
      param1Listener.onAddresses(Collections.singletonList(new EquivalentAddressGroup(this.this$0.address)), Attributes.EMPTY);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AbstractManagedChannelImplBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */