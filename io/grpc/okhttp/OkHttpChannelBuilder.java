package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.TlsVersion;
import io.grpc.Attributes;
import io.grpc.ExperimentalApi;
import io.grpc.Internal;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.AtomicBackoff;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ProxyParameters;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.TlsVersion;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1785")
public class OkHttpChannelBuilder extends AbstractManagedChannelImplBuilder<OkHttpChannelBuilder> {
  private static final long AS_LARGE_AS_INFINITE;
  
  @Deprecated
  public static final ConnectionSpec DEFAULT_CONNECTION_SPEC = (new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)).cipherSuites(new CipherSuite[] { CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 }).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2 }).supportsTlsExtensions(true).build();
  
  @VisibleForTesting
  static final ConnectionSpec INTERNAL_DEFAULT_CONNECTION_SPEC = (new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)).cipherSuites(new CipherSuite[] { CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 }).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2 }).supportsTlsExtensions(true).build();
  
  private static final SharedResourceHolder.Resource<ExecutorService> SHARED_EXECUTOR;
  
  private ConnectionSpec connectionSpec = INTERNAL_DEFAULT_CONNECTION_SPEC;
  
  private HostnameVerifier hostnameVerifier;
  
  private long keepAliveTimeNanos = Long.MAX_VALUE;
  
  private long keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
  
  private boolean keepAliveWithoutCalls;
  
  private NegotiationType negotiationType = NegotiationType.TLS;
  
  private ScheduledExecutorService scheduledExecutorService;
  
  private SSLSocketFactory sslSocketFactory;
  
  private Executor transportExecutor;
  
  static {
    AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000L);
    SHARED_EXECUTOR = new SharedResourceHolder.Resource<ExecutorService>() {
        public void close(ExecutorService param1ExecutorService) {
          param1ExecutorService.shutdown();
        }
        
        public ExecutorService create() {
          return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-okhttp-%d", true));
        }
      };
  }
  
  private OkHttpChannelBuilder(String paramString) {
    super(paramString);
  }
  
  protected OkHttpChannelBuilder(String paramString, int paramInt) {
    this(GrpcUtil.authorityFromHostAndPort(paramString, paramInt));
  }
  
  public static OkHttpChannelBuilder forAddress(String paramString, int paramInt) {
    return new OkHttpChannelBuilder(paramString, paramInt);
  }
  
  public static OkHttpChannelBuilder forTarget(String paramString) {
    return new OkHttpChannelBuilder(paramString);
  }
  
  @Internal
  protected final ClientTransportFactory buildTransportFactory() {
    boolean bool;
    if (this.keepAliveTimeNanos != Long.MAX_VALUE) {
      bool = true;
    } else {
      bool = false;
    } 
    return new OkHttpTransportFactory(this.transportExecutor, this.scheduledExecutorService, createSocketFactory(), this.hostnameVerifier, this.connectionSpec, maxInboundMessageSize(), bool, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls, this.transportTracerFactory);
  }
  
  public final OkHttpChannelBuilder connectionSpec(ConnectionSpec paramConnectionSpec) {
    Preconditions.checkArgument(paramConnectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
    this.connectionSpec = Utils.convertSpec(paramConnectionSpec);
    return this;
  }
  
  @Nullable
  @VisibleForTesting
  SSLSocketFactory createSocketFactory() {
    StringBuilder stringBuilder;
    switch (this.negotiationType) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown negotiation type: ");
        stringBuilder.append(this.negotiationType);
        throw new RuntimeException(stringBuilder.toString());
      case TLS:
        try {
          if (this.sslSocketFactory == null) {
            SSLContext sSLContext;
            if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
              sSLContext = SSLContext.getInstance("TLS", Platform.get().getProvider());
              TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
              trustManagerFactory.init((KeyStore)null);
              sSLContext.init(null, trustManagerFactory.getTrustManagers(), SecureRandom.getInstance("SHA1PRNG", Platform.get().getProvider()));
            } else {
              sSLContext = SSLContext.getInstance("Default", Platform.get().getProvider());
            } 
            this.sslSocketFactory = sSLContext.getSocketFactory();
          } 
          return this.sslSocketFactory;
        } catch (GeneralSecurityException generalSecurityException) {
          throw new RuntimeException("TLS Provider failure", generalSecurityException);
        } 
      case PLAINTEXT:
        break;
    } 
    return null;
  }
  
  @Deprecated
  public final OkHttpChannelBuilder enableKeepAlive(boolean paramBoolean) {
    return paramBoolean ? keepAliveTime(GrpcUtil.DEFAULT_KEEPALIVE_TIME_NANOS, TimeUnit.NANOSECONDS) : keepAliveTime(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
  }
  
  @Deprecated
  public final OkHttpChannelBuilder enableKeepAlive(boolean paramBoolean, long paramLong1, TimeUnit paramTimeUnit1, long paramLong2, TimeUnit paramTimeUnit2) {
    return paramBoolean ? keepAliveTime(paramLong1, paramTimeUnit1).keepAliveTimeout(paramLong2, paramTimeUnit2) : keepAliveTime(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
  }
  
  protected Attributes getNameResolverParams() {
    StringBuilder stringBuilder;
    switch (this.negotiationType) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.negotiationType);
        stringBuilder.append(" not handled");
        throw new AssertionError(stringBuilder.toString());
      case TLS:
        c = 'ƻ';
        return Attributes.newBuilder().set(NameResolver.Factory.PARAMS_DEFAULT_PORT, Integer.valueOf(c)).build();
      case PLAINTEXT:
        break;
    } 
    char c = 'P';
    return Attributes.newBuilder().set(NameResolver.Factory.PARAMS_DEFAULT_PORT, Integer.valueOf(c)).build();
  }
  
  public final OkHttpChannelBuilder hostnameVerifier(@Nullable HostnameVerifier paramHostnameVerifier) {
    this.hostnameVerifier = paramHostnameVerifier;
    return this;
  }
  
  public OkHttpChannelBuilder keepAliveTime(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "keepalive time must be positive");
    this.keepAliveTimeNanos = paramTimeUnit.toNanos(paramLong);
    this.keepAliveTimeNanos = KeepAliveManager.clampKeepAliveTimeInNanos(this.keepAliveTimeNanos);
    if (this.keepAliveTimeNanos >= AS_LARGE_AS_INFINITE)
      this.keepAliveTimeNanos = Long.MAX_VALUE; 
    return this;
  }
  
  public OkHttpChannelBuilder keepAliveTimeout(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "keepalive timeout must be positive");
    this.keepAliveTimeoutNanos = paramTimeUnit.toNanos(paramLong);
    this.keepAliveTimeoutNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(this.keepAliveTimeoutNanos);
    return this;
  }
  
  public OkHttpChannelBuilder keepAliveWithoutCalls(boolean paramBoolean) {
    this.keepAliveWithoutCalls = paramBoolean;
    return this;
  }
  
  public final OkHttpChannelBuilder negotiationType(NegotiationType paramNegotiationType) {
    this.negotiationType = (NegotiationType)Preconditions.checkNotNull(paramNegotiationType, "type");
    return this;
  }
  
  public final OkHttpChannelBuilder scheduledExecutorService(ScheduledExecutorService paramScheduledExecutorService) {
    this.scheduledExecutorService = (ScheduledExecutorService)Preconditions.checkNotNull(paramScheduledExecutorService, "scheduledExecutorService");
    return this;
  }
  
  @VisibleForTesting
  final OkHttpChannelBuilder setTransportTracerFactory(TransportTracer.Factory paramFactory) {
    this.transportTracerFactory = paramFactory;
    return this;
  }
  
  public final OkHttpChannelBuilder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory) {
    this.sslSocketFactory = paramSSLSocketFactory;
    negotiationType(NegotiationType.TLS);
    return this;
  }
  
  public final OkHttpChannelBuilder transportExecutor(@Nullable Executor paramExecutor) {
    this.transportExecutor = paramExecutor;
    return this;
  }
  
  public final OkHttpChannelBuilder usePlaintext() {
    negotiationType(NegotiationType.PLAINTEXT);
    return this;
  }
  
  @Deprecated
  public final OkHttpChannelBuilder usePlaintext(boolean paramBoolean) {
    if (paramBoolean) {
      negotiationType(NegotiationType.PLAINTEXT);
      return this;
    } 
    throw new IllegalArgumentException("Plaintext negotiation not currently supported");
  }
  
  public final OkHttpChannelBuilder useTransportSecurity() {
    negotiationType(NegotiationType.TLS);
    return this;
  }
  
  @Internal
  static final class OkHttpTransportFactory implements ClientTransportFactory {
    private boolean closed;
    
    private final ConnectionSpec connectionSpec;
    
    private final boolean enableKeepAlive;
    
    private final Executor executor;
    
    @Nullable
    private final HostnameVerifier hostnameVerifier;
    
    private final AtomicBackoff keepAliveTimeNanos;
    
    private final long keepAliveTimeoutNanos;
    
    private final boolean keepAliveWithoutCalls;
    
    private final int maxMessageSize;
    
    @Nullable
    private final SSLSocketFactory socketFactory;
    
    private final ScheduledExecutorService timeoutService;
    
    private final TransportTracer.Factory transportTracerFactory;
    
    private final boolean usingSharedExecutor;
    
    private final boolean usingSharedScheduler;
    
    private OkHttpTransportFactory(Executor param1Executor, @Nullable ScheduledExecutorService param1ScheduledExecutorService, @Nullable SSLSocketFactory param1SSLSocketFactory, @Nullable HostnameVerifier param1HostnameVerifier, ConnectionSpec param1ConnectionSpec, int param1Int, boolean param1Boolean1, long param1Long1, long param1Long2, boolean param1Boolean2, TransportTracer.Factory param1Factory) {
      boolean bool2;
      boolean bool1 = true;
      if (param1ScheduledExecutorService == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      this.usingSharedScheduler = bool2;
      if (this.usingSharedScheduler)
        param1ScheduledExecutorService = (ScheduledExecutorService)SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE); 
      this.timeoutService = param1ScheduledExecutorService;
      this.socketFactory = param1SSLSocketFactory;
      this.hostnameVerifier = param1HostnameVerifier;
      this.connectionSpec = param1ConnectionSpec;
      this.maxMessageSize = param1Int;
      this.enableKeepAlive = param1Boolean1;
      this.keepAliveTimeNanos = new AtomicBackoff("keepalive time nanos", param1Long1);
      this.keepAliveTimeoutNanos = param1Long2;
      this.keepAliveWithoutCalls = param1Boolean2;
      if (param1Executor == null) {
        param1Boolean1 = bool1;
      } else {
        param1Boolean1 = false;
      } 
      this.usingSharedExecutor = param1Boolean1;
      this.transportTracerFactory = (TransportTracer.Factory)Preconditions.checkNotNull(param1Factory, "transportTracerFactory");
      if (this.usingSharedExecutor) {
        this.executor = (Executor)SharedResourceHolder.get(OkHttpChannelBuilder.SHARED_EXECUTOR);
      } else {
        this.executor = param1Executor;
      } 
    }
    
    public void close() {
      if (this.closed)
        return; 
      this.closed = true;
      if (this.usingSharedScheduler)
        SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timeoutService); 
      if (this.usingSharedExecutor)
        SharedResourceHolder.release(OkHttpChannelBuilder.SHARED_EXECUTOR, this.executor); 
    }
    
    public ScheduledExecutorService getScheduledExecutorService() {
      return this.timeoutService;
    }
    
    public ConnectionClientTransport newClientTransport(SocketAddress param1SocketAddress, String param1String1, @Nullable String param1String2, @Nullable ProxyParameters param1ProxyParameters) {
      if (!this.closed) {
        final AtomicBackoff.State keepAliveTimeNanosState = this.keepAliveTimeNanos.getState();
        Runnable runnable = new Runnable() {
            public void run() {
              keepAliveTimeNanosState.backoff();
            }
          };
        OkHttpClientTransport okHttpClientTransport = new OkHttpClientTransport((InetSocketAddress)param1SocketAddress, param1String1, param1String2, this.executor, this.socketFactory, this.hostnameVerifier, this.connectionSpec, this.maxMessageSize, param1ProxyParameters, runnable, this.transportTracerFactory.create());
        if (this.enableKeepAlive)
          okHttpClientTransport.enableKeepAlive(true, state.get(), this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls); 
        return okHttpClientTransport;
      } 
      throw new IllegalStateException("The transport factory is closed.");
    }
  }
  
  class null implements Runnable {
    public void run() {
      keepAliveTimeNanosState.backoff();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpChannelBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */