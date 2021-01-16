package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ClientStreamTracer;
import io.grpc.CompressorRegistry;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.NameResolver;
import io.grpc.Status;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class ManagedChannelImpl extends ManagedChannel implements Instrumented<Channelz.ChannelStats> {
  static final long IDLE_TIMEOUT_MILLIS_DISABLE = -1L;
  
  @VisibleForTesting
  static final Status SHUTDOWN_NOW_STATUS;
  
  @VisibleForTesting
  static final Status SHUTDOWN_STATUS;
  
  @VisibleForTesting
  static final long SUBCHANNEL_SHUTDOWN_DELAY_SECONDS = 5L;
  
  @VisibleForTesting
  static final Status SUBCHANNEL_SHUTDOWN_STATUS;
  
  @VisibleForTesting
  static final Pattern URI_PATTERN;
  
  static final Logger logger = Logger.getLogger(ManagedChannelImpl.class.getName());
  
  private final BackoffPolicy.Provider backoffPolicyProvider;
  
  private final CallTracer.Factory callTracerFactory;
  
  private final long channelBufferLimit;
  
  private final RetriableStream$ChannelBufferMeter channelBufferUsed;
  
  private final CallTracer channelCallTracer;
  
  private final ChannelExecutor channelExecutor;
  
  private final ConnectivityStateManager channelStateManager;
  
  private final Channelz channelz;
  
  private final CompressorRegistry compressorRegistry;
  
  private final DecompressorRegistry decompressorRegistry;
  
  private final DelayedClientTransport delayedTransport;
  
  private final ManagedClientTransport$Listener delayedTransportListener;
  
  private final Executor executor;
  
  private final ObjectPool<? extends Executor> executorPool;
  
  private boolean fullStreamDecompression;
  
  private final long idleTimeoutMillis;
  
  private final Rescheduler idleTimer;
  
  @VisibleForTesting
  final InUseStateAggregator<Object> inUseStateAggregator;
  
  private final Channel interceptorChannel;
  
  @Nullable
  private LbHelperImpl lbHelper;
  
  private final LoadBalancer.Factory loadBalancerFactory;
  
  private final LogId logId;
  
  private NameResolver nameResolver;
  
  @Nullable
  private BackoffPolicy nameResolverBackoffPolicy;
  
  private final NameResolver.Factory nameResolverFactory;
  
  private final Attributes nameResolverParams;
  
  @Nullable
  private NameResolverRefresh nameResolverRefresh;
  
  @Nullable
  private ScheduledFuture<?> nameResolverRefreshFuture;
  
  private boolean nameResolverStarted;
  
  private final Set<OobChannel> oobChannels;
  
  private final ObjectPool<? extends Executor> oobExecutorPool;
  
  private boolean panicMode;
  
  private final long perRpcBufferLimit;
  
  private final boolean retryEnabled;
  
  private final ServiceConfigInterceptor serviceConfigInterceptor;
  
  private final AtomicBoolean shutdown;
  
  private boolean shutdownNowed;
  
  private final Supplier<Stopwatch> stopwatchSupplier;
  
  @Nullable
  private volatile LoadBalancer.SubchannelPicker subchannelPicker;
  
  private final Set<InternalSubchannel> subchannels;
  
  private final String target;
  
  private volatile boolean terminated;
  
  private final CountDownLatch terminatedLatch;
  
  private volatile boolean terminating;
  
  @Nullable
  private RetriableStream$Throttle throttle;
  
  private final ClientTransportFactory transportFactory;
  
  private final ClientCallImpl.ClientTransportProvider transportProvider;
  
  private final UncommittedRetriableStreamsRegistry uncommittedRetriableStreamsRegistry;
  
  @Nullable
  private final String userAgent;
  
  static {
    URI_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
    SHUTDOWN_NOW_STATUS = Status.UNAVAILABLE.withDescription("Channel shutdownNow invoked");
    SHUTDOWN_STATUS = Status.UNAVAILABLE.withDescription("Channel shutdown invoked");
    SUBCHANNEL_SHUTDOWN_STATUS = Status.UNAVAILABLE.withDescription("Subchannel shutdown invoked");
  }
  
  ManagedChannelImpl(AbstractManagedChannelImplBuilder<?> paramAbstractManagedChannelImplBuilder, ClientTransportFactory paramClientTransportFactory, BackoffPolicy.Provider paramProvider, ObjectPool<? extends Executor> paramObjectPool, Supplier<Stopwatch> paramSupplier, List<ClientInterceptor> paramList, CallTracer.Factory paramFactory) {
    boolean bool;
    this.logId = LogId.allocate(getClass().getName());
    this.channelExecutor = new ChannelExecutor() {
        void handleUncaughtThrowable(Throwable param1Throwable) {
          super.handleUncaughtThrowable(param1Throwable);
          ManagedChannelImpl.this.panic(param1Throwable);
        }
      };
    this.channelStateManager = new ConnectivityStateManager();
    this.subchannels = new HashSet<InternalSubchannel>(16, 0.75F);
    this.oobChannels = new HashSet<OobChannel>(1, 0.75F);
    this.uncommittedRetriableStreamsRegistry = new UncommittedRetriableStreamsRegistry();
    this.shutdown = new AtomicBoolean(false);
    this.terminatedLatch = new CountDownLatch(1);
    this.channelBufferUsed = new RetriableStream$ChannelBufferMeter();
    this.delayedTransportListener = new ManagedClientTransport$Listener() {
        public void transportInUse(boolean param1Boolean) {
          ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(ManagedChannelImpl.this.delayedTransport, param1Boolean);
        }
        
        public void transportReady() {}
        
        public void transportShutdown(Status param1Status) {
          Preconditions.checkState(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
        }
        
        public void transportTerminated() {
          Preconditions.checkState(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
          ManagedChannelImpl.access$302(ManagedChannelImpl.this, true);
          ManagedChannelImpl.this.shutdownNameResolverAndLoadBalancer(false);
          ManagedChannelImpl.this.maybeShutdownNowSubchannels();
          ManagedChannelImpl.this.maybeTerminateChannel();
        }
      };
    this.inUseStateAggregator = new InUseStateAggregator() {
        void handleInUse() {
          ManagedChannelImpl.this.exitIdleMode();
        }
        
        void handleNotInUse() {
          if (ManagedChannelImpl.this.shutdown.get())
            return; 
          ManagedChannelImpl.this.rescheduleIdleTimer();
        }
      };
    this.transportProvider = new ClientCallImpl.ClientTransportProvider() {
        public ClientTransport get(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs) {
          LoadBalancer.SubchannelPicker subchannelPicker = ManagedChannelImpl.this.subchannelPicker;
          if (ManagedChannelImpl.this.shutdown.get())
            return (ClientTransport)ManagedChannelImpl.this.delayedTransport; 
          if (subchannelPicker == null) {
            ManagedChannelImpl.this.channelExecutor.executeLater(new Runnable() {
                  public void run() {
                    ManagedChannelImpl.this.exitIdleMode();
                  }
                }).drain();
            return (ClientTransport)ManagedChannelImpl.this.delayedTransport;
          } 
          ClientTransport clientTransport = GrpcUtil.getTransportFromPickResult(subchannelPicker.pickSubchannel(param1PickSubchannelArgs), param1PickSubchannelArgs.getCallOptions().isWaitForReady());
          return (ClientTransport)((clientTransport != null) ? clientTransport : ManagedChannelImpl.this.delayedTransport);
        }
        
        public <ReqT> RetriableStream<ReqT> newRetriableStream(final MethodDescriptor<ReqT, ?> method, final CallOptions callOptions, Metadata param1Metadata, final Context context) {
          Preconditions.checkState(ManagedChannelImpl.this.retryEnabled, "retry should be enabled");
          return new RetriableStream<ReqT>(method, param1Metadata, ManagedChannelImpl.this.channelBufferUsed, ManagedChannelImpl.this.perRpcBufferLimit, ManagedChannelImpl.this.channelBufferLimit, ManagedChannelImpl.this.getCallExecutor(callOptions), ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), (RetryPolicy.Provider)callOptions.getOption(ServiceConfigInterceptor.RETRY_POLICY_KEY), ManagedChannelImpl.this.throttle) {
              ClientStream newSubstream(ClientStreamTracer.Factory param2Factory, Metadata param2Metadata) {
                CallOptions callOptions = callOptions.withStreamTracerFactory(param2Factory);
                ClientTransport clientTransport = ManagedChannelImpl.null.this.get(new PickSubchannelArgsImpl(method, param2Metadata, callOptions));
                Context context = context.attach();
                try {
                  return clientTransport.newStream(method, param2Metadata, callOptions);
                } finally {
                  context.detach(context);
                } 
              }
              
              void postCommit() {
                ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.remove(this);
              }
              
              Status prestart() {
                return ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.add(this);
              }
            };
        }
      };
    this.target = (String)Preconditions.checkNotNull(paramAbstractManagedChannelImplBuilder.target, "target");
    this.nameResolverFactory = paramAbstractManagedChannelImplBuilder.getNameResolverFactory();
    this.nameResolverParams = (Attributes)Preconditions.checkNotNull(paramAbstractManagedChannelImplBuilder.getNameResolverParams(), "nameResolverParams");
    this.nameResolver = getNameResolver(this.target, this.nameResolverFactory, this.nameResolverParams);
    if (paramAbstractManagedChannelImplBuilder.loadBalancerFactory == null) {
      this.loadBalancerFactory = new AutoConfiguredLoadBalancerFactory();
    } else {
      this.loadBalancerFactory = paramAbstractManagedChannelImplBuilder.loadBalancerFactory;
    } 
    this.executorPool = (ObjectPool<? extends Executor>)Preconditions.checkNotNull(paramAbstractManagedChannelImplBuilder.executorPool, "executorPool");
    this.oobExecutorPool = (ObjectPool<? extends Executor>)Preconditions.checkNotNull(paramObjectPool, "oobExecutorPool");
    this.executor = (Executor)Preconditions.checkNotNull(this.executorPool.getObject(), "executor");
    this.delayedTransport = new DelayedClientTransport(this.executor, this.channelExecutor);
    this.delayedTransport.start(this.delayedTransportListener);
    this.backoffPolicyProvider = paramProvider;
    this.transportFactory = new CallCredentialsApplyingTransportFactory(paramClientTransportFactory, this.executor);
    if (paramAbstractManagedChannelImplBuilder.retryEnabled && !paramAbstractManagedChannelImplBuilder.temporarilyDisableRetry) {
      bool = true;
    } else {
      bool = false;
    } 
    this.retryEnabled = bool;
    this.serviceConfigInterceptor = new ServiceConfigInterceptor(this.retryEnabled, paramAbstractManagedChannelImplBuilder.maxRetryAttempts);
    Channel channel2 = ClientInterceptors.intercept(new RealChannel(), new ClientInterceptor[] { (ClientInterceptor)this.serviceConfigInterceptor });
    Channel channel1 = channel2;
    if (paramAbstractManagedChannelImplBuilder.binlogProvider != null)
      channel1 = paramAbstractManagedChannelImplBuilder.binlogProvider.wrapChannel(channel2); 
    this.interceptorChannel = ClientInterceptors.intercept(channel1, paramList);
    this.stopwatchSupplier = (Supplier<Stopwatch>)Preconditions.checkNotNull(paramSupplier, "stopwatchSupplier");
    if (paramAbstractManagedChannelImplBuilder.idleTimeoutMillis == -1L) {
      this.idleTimeoutMillis = paramAbstractManagedChannelImplBuilder.idleTimeoutMillis;
    } else {
      if (paramAbstractManagedChannelImplBuilder.idleTimeoutMillis >= AbstractManagedChannelImplBuilder.IDLE_MODE_MIN_TIMEOUT_MILLIS) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "invalid idleTimeoutMillis %s", paramAbstractManagedChannelImplBuilder.idleTimeoutMillis);
      this.idleTimeoutMillis = paramAbstractManagedChannelImplBuilder.idleTimeoutMillis;
    } 
    final class AutoDrainChannelExecutor implements Executor {
      public void execute(Runnable param1Runnable) {
        ManagedChannelImpl.this.channelExecutor.executeLater(param1Runnable);
        ManagedChannelImpl.this.channelExecutor.drain();
      }
    };
    this.idleTimer = new Rescheduler(new IdleModeTimer(), new AutoDrainChannelExecutor(), this.transportFactory.getScheduledExecutorService(), (Stopwatch)paramSupplier.get());
    this.fullStreamDecompression = paramAbstractManagedChannelImplBuilder.fullStreamDecompression;
    this.decompressorRegistry = (DecompressorRegistry)Preconditions.checkNotNull(paramAbstractManagedChannelImplBuilder.decompressorRegistry, "decompressorRegistry");
    this.compressorRegistry = (CompressorRegistry)Preconditions.checkNotNull(paramAbstractManagedChannelImplBuilder.compressorRegistry, "compressorRegistry");
    this.userAgent = paramAbstractManagedChannelImplBuilder.userAgent;
    this.channelBufferLimit = paramAbstractManagedChannelImplBuilder.retryBufferSize;
    this.perRpcBufferLimit = paramAbstractManagedChannelImplBuilder.perRpcBufferLimit;
    this.callTracerFactory = paramFactory;
    this.channelCallTracer = paramFactory.create();
    this.channelz = (Channelz)Preconditions.checkNotNull(paramAbstractManagedChannelImplBuilder.channelz);
    this.channelz.addRootChannel(this);
    logger.log(Level.FINE, "[{0}] Created with target {1}", new Object[] { getLogId(), this.target });
  }
  
  private void cancelIdleTimer(boolean paramBoolean) {
    this.idleTimer.cancel(paramBoolean);
  }
  
  private void cancelNameResolverBackoff() {
    ScheduledFuture<?> scheduledFuture = this.nameResolverRefreshFuture;
    if (scheduledFuture != null) {
      scheduledFuture.cancel(false);
      this.nameResolverRefresh.cancelled = true;
      this.nameResolverRefreshFuture = null;
      this.nameResolverRefresh = null;
      this.nameResolverBackoffPolicy = null;
    } 
  }
  
  private void enterIdleMode() {
    logger.log(Level.FINE, "[{0}] Entering idle mode", getLogId());
    shutdownNameResolverAndLoadBalancer(true);
    this.delayedTransport.reprocess(null);
    this.nameResolver = getNameResolver(this.target, this.nameResolverFactory, this.nameResolverParams);
    this.channelStateManager.gotoState(ConnectivityState.IDLE);
  }
  
  private Executor getCallExecutor(CallOptions paramCallOptions) {
    Executor executor2 = paramCallOptions.getExecutor();
    Executor executor1 = executor2;
    if (executor2 == null)
      executor1 = this.executor; 
    return executor1;
  }
  
  @VisibleForTesting
  static NameResolver getNameResolver(String paramString, NameResolver.Factory paramFactory, Attributes paramAttributes) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    try {
      URI uRI = new URI();
      this(paramString);
    } catch (URISyntaxException uRISyntaxException2) {
      stringBuilder.append(uRISyntaxException2.getMessage());
      uRISyntaxException2 = null;
    } 
    if (uRISyntaxException2 != null) {
      NameResolver nameResolver = paramFactory.newNameResolver((URI)uRISyntaxException2, paramAttributes);
      if (nameResolver != null)
        return nameResolver; 
    } 
    if (!URI_PATTERN.matcher(paramString).matches())
      try {
        String str1 = paramFactory.getDefaultScheme();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append("/");
        stringBuilder1.append(paramString);
        URI uRI = new URI(str1, "", stringBuilder1.toString(), null);
        NameResolver nameResolver = paramFactory.newNameResolver(uRI, paramAttributes);
        if (nameResolver != null)
          return nameResolver; 
      } catch (URISyntaxException uRISyntaxException1) {
        throw new IllegalArgumentException(uRISyntaxException1);
      }  
    if (stringBuilder.length() > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" (");
      stringBuilder1.append(stringBuilder);
      stringBuilder1.append(")");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", new Object[] { uRISyntaxException1, str }));
  }
  
  @Nullable
  private static RetriableStream$Throttle getThrottle(Attributes paramAttributes) {
    return ServiceConfigUtil.getThrottlePolicy((Map<String, Object>)paramAttributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG));
  }
  
  private void maybeShutdownNowSubchannels() {
    if (this.shutdownNowed) {
      Iterator<InternalSubchannel> iterator = this.subchannels.iterator();
      while (iterator.hasNext())
        ((InternalSubchannel)iterator.next()).shutdownNow(SHUTDOWN_NOW_STATUS); 
      iterator = (Iterator)this.oobChannels.iterator();
      while (iterator.hasNext())
        ((OobChannel)iterator.next()).getInternalSubchannel().shutdownNow(SHUTDOWN_NOW_STATUS); 
    } 
  }
  
  private void maybeTerminateChannel() {
    if (this.terminated)
      return; 
    if (this.shutdown.get() && this.subchannels.isEmpty() && this.oobChannels.isEmpty()) {
      logger.log(Level.FINE, "[{0}] Terminated", getLogId());
      this.channelz.removeRootChannel(this);
      this.terminated = true;
      this.terminatedLatch.countDown();
      this.executorPool.returnObject(this.executor);
      this.transportFactory.close();
    } 
  }
  
  private void rescheduleIdleTimer() {
    long l = this.idleTimeoutMillis;
    if (l == -1L)
      return; 
    this.idleTimer.reschedule(l, TimeUnit.MILLISECONDS);
  }
  
  private void shutdownNameResolverAndLoadBalancer(boolean paramBoolean) {
    if (paramBoolean) {
      NameResolver nameResolver = this.nameResolver;
      boolean bool = true;
      if (nameResolver != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      Preconditions.checkState(paramBoolean, "nameResolver is null");
      if (this.lbHelper != null) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      } 
      Preconditions.checkState(paramBoolean, "lbHelper is null");
    } 
    if (this.nameResolver != null) {
      cancelNameResolverBackoff();
      this.nameResolver.shutdown();
      this.nameResolver = null;
      this.nameResolverStarted = false;
    } 
    LbHelperImpl lbHelperImpl = this.lbHelper;
    if (lbHelperImpl != null) {
      lbHelperImpl.lb.shutdown();
      this.lbHelper = null;
    } 
    this.subchannelPicker = null;
  }
  
  private void updateSubchannelPicker(LoadBalancer.SubchannelPicker paramSubchannelPicker) {
    this.subchannelPicker = paramSubchannelPicker;
    this.delayedTransport.reprocess(paramSubchannelPicker);
  }
  
  public String authority() {
    return this.interceptorChannel.authority();
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.terminatedLatch.await(paramLong, paramTimeUnit);
  }
  
  public void enterIdle() {
    class PrepareToLoseNetworkRunnable implements Runnable {
      public void run() {
        if (ManagedChannelImpl.this.shutdown.get() || ManagedChannelImpl.this.lbHelper == null)
          return; 
        ManagedChannelImpl.this.cancelIdleTimer(false);
        ManagedChannelImpl.this.enterIdleMode();
      }
    };
    this.channelExecutor.executeLater(new PrepareToLoseNetworkRunnable()).drain();
  }
  
  @VisibleForTesting
  void exitIdleMode() {
    if (this.shutdown.get() || this.panicMode)
      return; 
    if (this.inUseStateAggregator.isInUse()) {
      cancelIdleTimer(false);
    } else {
      rescheduleIdleTimer();
    } 
    if (this.lbHelper != null)
      return; 
    logger.log(Level.FINE, "[{0}] Exiting idle mode", getLogId());
    this.lbHelper = new LbHelperImpl(this.nameResolver);
    LbHelperImpl lbHelperImpl = this.lbHelper;
    lbHelperImpl.lb = this.loadBalancerFactory.newLoadBalancer(lbHelperImpl);
    NameResolverListenerImpl nameResolverListenerImpl = new NameResolverListenerImpl(this.lbHelper);
    try {
      this.nameResolver.start(nameResolverListenerImpl);
      this.nameResolverStarted = true;
    } catch (Throwable throwable) {
      nameResolverListenerImpl.onError(Status.fromThrowable(throwable));
    } 
  }
  
  public LogId getLogId() {
    return this.logId;
  }
  
  public ConnectivityState getState(boolean paramBoolean) {
    ConnectivityState connectivityState = this.channelStateManager.getState();
    if (paramBoolean && connectivityState == ConnectivityState.IDLE)
      this.channelExecutor.executeLater(new Runnable() {
            public void run() {
              ManagedChannelImpl.this.exitIdleMode();
              if (ManagedChannelImpl.this.subchannelPicker != null)
                ManagedChannelImpl.this.subchannelPicker.requestConnection(); 
            }
          }).drain(); 
    return connectivityState;
  }
  
  public ListenableFuture<Channelz.ChannelStats> getStats() {
    final SettableFuture ret = SettableFuture.create();
    final Channelz.ChannelStats.Builder builder = new Channelz.ChannelStats.Builder();
    this.channelCallTracer.updateBuilder(builder);
    builder.setTarget(this.target).setState(this.channelStateManager.getState());
    this.channelExecutor.executeLater(new Runnable() {
          public void run() {
            ArrayList<WithLogId> arrayList = new ArrayList();
            arrayList.addAll(ManagedChannelImpl.this.subchannels);
            arrayList.addAll(ManagedChannelImpl.this.oobChannels);
            builder.setSubchannels(arrayList);
            ret.set(builder.build());
          }
        }).drain();
    return (ListenableFuture<Channelz.ChannelStats>)settableFuture;
  }
  
  public boolean isShutdown() {
    return this.shutdown.get();
  }
  
  public boolean isTerminated() {
    return this.terminated;
  }
  
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions) {
    return this.interceptorChannel.newCall(paramMethodDescriptor, paramCallOptions);
  }
  
  public void notifyWhenStateChanged(final ConnectivityState source, final Runnable callback) {
    this.channelExecutor.executeLater(new Runnable() {
          public void run() {
            ManagedChannelImpl.this.channelStateManager.notifyWhenStateChanged(callback, ManagedChannelImpl.this.executor, source);
          }
        }).drain();
  }
  
  @VisibleForTesting
  void panic(final Throwable t) {
    if (this.panicMode)
      return; 
    this.panicMode = true;
    cancelIdleTimer(true);
    shutdownNameResolverAndLoadBalancer(false);
    updateSubchannelPicker(new LoadBalancer.SubchannelPicker() {
          final LoadBalancer.PickResult panicPickResult = LoadBalancer.PickResult.withDrop(Status.INTERNAL.withDescription("Panic! This is a bug!").withCause(t));
          
          public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs) {
            return this.panicPickResult;
          }
        });
    this.channelStateManager.gotoState(ConnectivityState.TRANSIENT_FAILURE);
  }
  
  public void resetConnectBackoff() {
    this.channelExecutor.executeLater(new Runnable() {
          public void run() {
            if (ManagedChannelImpl.this.shutdown.get())
              return; 
            if (ManagedChannelImpl.this.nameResolverRefreshFuture != null) {
              Preconditions.checkState(ManagedChannelImpl.this.nameResolverStarted, "name resolver must be started");
              ManagedChannelImpl.this.cancelNameResolverBackoff();
              ManagedChannelImpl.this.nameResolver.refresh();
            } 
            Iterator<InternalSubchannel> iterator = ManagedChannelImpl.this.subchannels.iterator();
            while (iterator.hasNext())
              ((InternalSubchannel)iterator.next()).resetConnectBackoff(); 
            iterator = ManagedChannelImpl.this.oobChannels.iterator();
            while (iterator.hasNext())
              ((OobChannel)iterator.next()).resetConnectBackoff(); 
          }
        }).drain();
  }
  
  public ManagedChannelImpl shutdown() {
    logger.log(Level.FINE, "[{0}] shutdown() called", getLogId());
    if (!this.shutdown.compareAndSet(false, true))
      return this; 
    this.channelExecutor.executeLater(new Runnable() {
          public void run() {
            ManagedChannelImpl.this.channelStateManager.gotoState(ConnectivityState.SHUTDOWN);
          }
        });
    this.uncommittedRetriableStreamsRegistry.onShutdown(SHUTDOWN_STATUS);
    this.channelExecutor.executeLater(new Runnable() {
          public void run() {
            ManagedChannelImpl.this.cancelIdleTimer(true);
          }
        }).drain();
    logger.log(Level.FINE, "[{0}] Shutting down", getLogId());
    return this;
  }
  
  public ManagedChannelImpl shutdownNow() {
    logger.log(Level.FINE, "[{0}] shutdownNow() called", getLogId());
    shutdown();
    this.uncommittedRetriableStreamsRegistry.onShutdownNow(SHUTDOWN_NOW_STATUS);
    this.channelExecutor.executeLater(new Runnable() {
          public void run() {
            if (ManagedChannelImpl.this.shutdownNowed)
              return; 
            ManagedChannelImpl.access$2802(ManagedChannelImpl.this, true);
            ManagedChannelImpl.this.maybeShutdownNowSubchannels();
          }
        }).drain();
    return this;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("logId", this.logId).add("target", this.target).toString();
  }
  
  private class IdleModeTimer implements Runnable {
    private IdleModeTimer() {}
    
    public void run() {
      ManagedChannelImpl.this.enterIdleMode();
    }
  }
  
  private class LbHelperImpl extends LoadBalancer.Helper {
    LoadBalancer lb;
    
    final NameResolver nr;
    
    LbHelperImpl(NameResolver param1NameResolver) {
      this.nr = (NameResolver)Preconditions.checkNotNull(param1NameResolver, "NameResolver");
    }
    
    private void handleInternalSubchannelState(ConnectivityStateInfo param1ConnectivityStateInfo) {
      if (param1ConnectivityStateInfo.getState() == ConnectivityState.TRANSIENT_FAILURE || param1ConnectivityStateInfo.getState() == ConnectivityState.IDLE)
        this.nr.refresh(); 
    }
    
    public ManagedChannel createOobChannel(EquivalentAddressGroup param1EquivalentAddressGroup, String param1String) {
      Preconditions.checkState(ManagedChannelImpl.this.terminated ^ true, "Channel is terminated");
      final OobChannel oobChannel = new OobChannel(param1String, ManagedChannelImpl.this.oobExecutorPool, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.channelExecutor, ManagedChannelImpl.this.callTracerFactory.create(), ManagedChannelImpl.this.channelz);
      InternalSubchannel internalSubchannel = new InternalSubchannel(param1EquivalentAddressGroup, param1String, ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.channelExecutor, new InternalSubchannel.Callback() {
            void onStateChange(InternalSubchannel param2InternalSubchannel, ConnectivityStateInfo param2ConnectivityStateInfo) {
              ManagedChannelImpl.LbHelperImpl.this.handleInternalSubchannelState(param2ConnectivityStateInfo);
              oobChannel.handleSubchannelStateChange(param2ConnectivityStateInfo);
            }
            
            void onTerminated(InternalSubchannel param2InternalSubchannel) {
              ManagedChannelImpl.this.oobChannels.remove(oobChannel);
              ManagedChannelImpl.this.channelz.removeSubchannel(param2InternalSubchannel);
              oobChannel.handleSubchannelTerminated();
              ManagedChannelImpl.this.maybeTerminateChannel();
            }
          },  ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.callTracerFactory.create());
      ManagedChannelImpl.this.channelz.addSubchannel(oobChannel);
      ManagedChannelImpl.this.channelz.addSubchannel(internalSubchannel);
      oobChannel.setSubchannel(internalSubchannel);
      runSerialized(new Runnable() {
            public void run() {
              if (ManagedChannelImpl.this.terminating)
                oobChannel.shutdown(); 
              if (!ManagedChannelImpl.this.terminated)
                ManagedChannelImpl.this.oobChannels.add(oobChannel); 
            }
          });
      return oobChannel;
    }
    
    public AbstractSubchannel createSubchannel(EquivalentAddressGroup param1EquivalentAddressGroup, Attributes param1Attributes) {
      Preconditions.checkNotNull(param1EquivalentAddressGroup, "addressGroup");
      Preconditions.checkNotNull(param1Attributes, "attrs");
      Preconditions.checkState(ManagedChannelImpl.this.terminated ^ true, "Channel is terminated");
      final ManagedChannelImpl.SubchannelImpl subchannel = new ManagedChannelImpl.SubchannelImpl(param1Attributes);
      final InternalSubchannel internalSubchannel = new InternalSubchannel(param1EquivalentAddressGroup, ManagedChannelImpl.this.authority(), ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.channelExecutor, new InternalSubchannel.Callback() {
            void onInUse(InternalSubchannel param2InternalSubchannel) {
              ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(param2InternalSubchannel, true);
            }
            
            void onNotInUse(InternalSubchannel param2InternalSubchannel) {
              ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(param2InternalSubchannel, false);
            }
            
            void onStateChange(InternalSubchannel param2InternalSubchannel, ConnectivityStateInfo param2ConnectivityStateInfo) {
              ManagedChannelImpl.LbHelperImpl.this.handleInternalSubchannelState(param2ConnectivityStateInfo);
              ManagedChannelImpl.LbHelperImpl lbHelperImpl = ManagedChannelImpl.LbHelperImpl.this;
              if (lbHelperImpl == ManagedChannelImpl.this.lbHelper)
                ManagedChannelImpl.LbHelperImpl.this.lb.handleSubchannelState(subchannel, param2ConnectivityStateInfo); 
            }
            
            void onTerminated(InternalSubchannel param2InternalSubchannel) {
              ManagedChannelImpl.this.subchannels.remove(param2InternalSubchannel);
              ManagedChannelImpl.this.channelz.removeSubchannel(param2InternalSubchannel);
              ManagedChannelImpl.this.maybeTerminateChannel();
            }
          }ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.callTracerFactory.create());
      ManagedChannelImpl.this.channelz.addSubchannel(internalSubchannel);
      subchannelImpl.subchannel = internalSubchannel;
      ManagedChannelImpl.logger.log(Level.FINE, "[{0}] {1} created for {2}", new Object[] { this.this$0.getLogId(), internalSubchannel.getLogId(), param1EquivalentAddressGroup });
      runSerialized(new Runnable() {
            public void run() {
              if (ManagedChannelImpl.this.terminating)
                internalSubchannel.shutdown(ManagedChannelImpl.SHUTDOWN_STATUS); 
              if (!ManagedChannelImpl.this.terminated)
                ManagedChannelImpl.this.subchannels.add(internalSubchannel); 
            }
          });
      return subchannelImpl;
    }
    
    public String getAuthority() {
      return ManagedChannelImpl.this.authority();
    }
    
    public NameResolver.Factory getNameResolverFactory() {
      return ManagedChannelImpl.this.nameResolverFactory;
    }
    
    public void runSerialized(Runnable param1Runnable) {
      ManagedChannelImpl.this.channelExecutor.executeLater(param1Runnable).drain();
    }
    
    public void updateBalancingState(final ConnectivityState newState, final LoadBalancer.SubchannelPicker newPicker) {
      Preconditions.checkNotNull(newState, "newState");
      Preconditions.checkNotNull(newPicker, "newPicker");
      runSerialized(new Runnable() {
            public void run() {
              ManagedChannelImpl.LbHelperImpl lbHelperImpl = ManagedChannelImpl.LbHelperImpl.this;
              if (lbHelperImpl != ManagedChannelImpl.this.lbHelper)
                return; 
              ManagedChannelImpl.this.updateSubchannelPicker(newPicker);
              if (newState != ConnectivityState.SHUTDOWN)
                ManagedChannelImpl.this.channelStateManager.gotoState(newState); 
            }
          });
    }
    
    public void updateOobChannelAddresses(ManagedChannel param1ManagedChannel, EquivalentAddressGroup param1EquivalentAddressGroup) {
      Preconditions.checkArgument(param1ManagedChannel instanceof OobChannel, "channel must have been returned from createOobChannel");
      ((OobChannel)param1ManagedChannel).updateAddresses(param1EquivalentAddressGroup);
    }
    
    public void updateSubchannelAddresses(LoadBalancer.Subchannel param1Subchannel, EquivalentAddressGroup param1EquivalentAddressGroup) {
      Preconditions.checkArgument(param1Subchannel instanceof ManagedChannelImpl.SubchannelImpl, "subchannel must have been returned from createSubchannel");
      ((ManagedChannelImpl.SubchannelImpl)param1Subchannel).subchannel.updateAddresses(param1EquivalentAddressGroup);
    }
  }
  
  class null extends InternalSubchannel.Callback {
    void onInUse(InternalSubchannel param1InternalSubchannel) {
      ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(param1InternalSubchannel, true);
    }
    
    void onNotInUse(InternalSubchannel param1InternalSubchannel) {
      ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(param1InternalSubchannel, false);
    }
    
    void onStateChange(InternalSubchannel param1InternalSubchannel, ConnectivityStateInfo param1ConnectivityStateInfo) {
      this.this$1.handleInternalSubchannelState(param1ConnectivityStateInfo);
      ManagedChannelImpl.LbHelperImpl lbHelperImpl = this.this$1;
      if (lbHelperImpl == ManagedChannelImpl.this.lbHelper)
        this.this$1.lb.handleSubchannelState(subchannel, param1ConnectivityStateInfo); 
    }
    
    void onTerminated(InternalSubchannel param1InternalSubchannel) {
      ManagedChannelImpl.this.subchannels.remove(param1InternalSubchannel);
      ManagedChannelImpl.this.channelz.removeSubchannel(param1InternalSubchannel);
      ManagedChannelImpl.this.maybeTerminateChannel();
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (ManagedChannelImpl.this.terminating)
        internalSubchannel.shutdown(ManagedChannelImpl.SHUTDOWN_STATUS); 
      if (!ManagedChannelImpl.this.terminated)
        ManagedChannelImpl.this.subchannels.add(internalSubchannel); 
    }
  }
  
  class null implements Runnable {
    public void run() {
      ManagedChannelImpl.LbHelperImpl lbHelperImpl = this.this$1;
      if (lbHelperImpl != ManagedChannelImpl.this.lbHelper)
        return; 
      ManagedChannelImpl.this.updateSubchannelPicker(newPicker);
      if (newState != ConnectivityState.SHUTDOWN)
        ManagedChannelImpl.this.channelStateManager.gotoState(newState); 
    }
  }
  
  class null extends InternalSubchannel.Callback {
    void onStateChange(InternalSubchannel param1InternalSubchannel, ConnectivityStateInfo param1ConnectivityStateInfo) {
      this.this$1.handleInternalSubchannelState(param1ConnectivityStateInfo);
      oobChannel.handleSubchannelStateChange(param1ConnectivityStateInfo);
    }
    
    void onTerminated(InternalSubchannel param1InternalSubchannel) {
      ManagedChannelImpl.this.oobChannels.remove(oobChannel);
      ManagedChannelImpl.this.channelz.removeSubchannel(param1InternalSubchannel);
      oobChannel.handleSubchannelTerminated();
      ManagedChannelImpl.this.maybeTerminateChannel();
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (ManagedChannelImpl.this.terminating)
        oobChannel.shutdown(); 
      if (!ManagedChannelImpl.this.terminated)
        ManagedChannelImpl.this.oobChannels.add(oobChannel); 
    }
  }
  
  private class NameResolverListenerImpl implements NameResolver.Listener {
    final ManagedChannelImpl.LbHelperImpl helper;
    
    NameResolverListenerImpl(ManagedChannelImpl.LbHelperImpl param1LbHelperImpl) {
      this.helper = param1LbHelperImpl;
    }
    
    public void onAddresses(final List<EquivalentAddressGroup> servers, final Attributes config) {
      if (servers.isEmpty()) {
        onError(Status.UNAVAILABLE.withDescription("NameResolver returned an empty list"));
        return;
      } 
      if (ManagedChannelImpl.logger.isLoggable(Level.FINE))
        ManagedChannelImpl.logger.log(Level.FINE, "[{0}] resolved address: {1}, config={2}", new Object[] { this.this$0.getLogId(), servers, config }); 
      final class NamesResolved implements Runnable {
        public void run() {
          if (ManagedChannelImpl.NameResolverListenerImpl.this.helper != ManagedChannelImpl.this.lbHelper)
            return; 
          ManagedChannelImpl.access$4802(ManagedChannelImpl.this, null);
          Map map = (Map)config.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG);
          if (map != null)
            try {
              ManagedChannelImpl.this.serviceConfigInterceptor.handleUpdate(map);
              if (ManagedChannelImpl.this.retryEnabled)
                ManagedChannelImpl.access$2202(ManagedChannelImpl.this, ManagedChannelImpl.getThrottle(config)); 
            } catch (RuntimeException runtimeException) {
              Logger logger = ManagedChannelImpl.logger;
              Level level = Level.WARNING;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("[");
              stringBuilder.append(ManagedChannelImpl.this.getLogId());
              stringBuilder.append("] Unexpected exception from parsing service config");
              logger.log(level, stringBuilder.toString(), runtimeException);
            }  
          ManagedChannelImpl.NameResolverListenerImpl.this.helper.lb.handleResolvedAddressGroups(servers, config);
        }
      };
      this.helper.runSerialized(new NamesResolved());
    }
    
    public void onError(final Status error) {
      Preconditions.checkArgument(error.isOk() ^ true, "the error status must not be OK");
      ManagedChannelImpl.logger.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[] { this.this$0.getLogId(), error });
      ManagedChannelImpl.this.channelExecutor.executeLater(new Runnable() {
            public void run() {
              if (ManagedChannelImpl.NameResolverListenerImpl.this.helper != ManagedChannelImpl.this.lbHelper)
                return; 
              ManagedChannelImpl.NameResolverListenerImpl.this.helper.lb.handleNameResolutionError(error);
              if (ManagedChannelImpl.this.nameResolverRefreshFuture != null)
                return; 
              if (ManagedChannelImpl.this.nameResolverBackoffPolicy == null)
                ManagedChannelImpl.access$4802(ManagedChannelImpl.this, ManagedChannelImpl.this.backoffPolicyProvider.get()); 
              long l = ManagedChannelImpl.this.nameResolverBackoffPolicy.nextBackoffNanos();
              if (ManagedChannelImpl.logger.isLoggable(Level.FINE))
                ManagedChannelImpl.logger.log(Level.FINE, "[{0}] Scheduling DNS resolution backoff for {1} ns", new Object[] { ManagedChannelImpl.access$5100(this.this$1.this$0), Long.valueOf(l) }); 
              ManagedChannelImpl.access$1202(ManagedChannelImpl.this, new ManagedChannelImpl.NameResolverRefresh());
              ManagedChannelImpl.access$1102(ManagedChannelImpl.this, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService().schedule(ManagedChannelImpl.this.nameResolverRefresh, l, TimeUnit.NANOSECONDS));
            }
          }).drain();
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (this.this$1.helper != ManagedChannelImpl.this.lbHelper)
        return; 
      this.this$1.helper.lb.handleNameResolutionError(error);
      if (ManagedChannelImpl.this.nameResolverRefreshFuture != null)
        return; 
      if (ManagedChannelImpl.this.nameResolverBackoffPolicy == null)
        ManagedChannelImpl.access$4802(ManagedChannelImpl.this, ManagedChannelImpl.this.backoffPolicyProvider.get()); 
      long l = ManagedChannelImpl.this.nameResolverBackoffPolicy.nextBackoffNanos();
      if (ManagedChannelImpl.logger.isLoggable(Level.FINE))
        ManagedChannelImpl.logger.log(Level.FINE, "[{0}] Scheduling DNS resolution backoff for {1} ns", new Object[] { ManagedChannelImpl.access$5100(this.this$1.this$0), Long.valueOf(l) }); 
      ManagedChannelImpl.access$1202(ManagedChannelImpl.this, new ManagedChannelImpl.NameResolverRefresh());
      ManagedChannelImpl.access$1102(ManagedChannelImpl.this, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService().schedule(ManagedChannelImpl.this.nameResolverRefresh, l, TimeUnit.NANOSECONDS));
    }
  }
  
  final class NamesResolved implements Runnable {
    public void run() {
      if (this.this$1.helper != ManagedChannelImpl.this.lbHelper)
        return; 
      ManagedChannelImpl.access$4802(ManagedChannelImpl.this, null);
      Map map = (Map)config.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG);
      if (map != null)
        try {
          ManagedChannelImpl.this.serviceConfigInterceptor.handleUpdate(map);
          if (ManagedChannelImpl.this.retryEnabled)
            ManagedChannelImpl.access$2202(ManagedChannelImpl.this, ManagedChannelImpl.getThrottle(config)); 
        } catch (RuntimeException runtimeException) {
          Logger logger = ManagedChannelImpl.logger;
          Level level = Level.WARNING;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("[");
          stringBuilder.append(ManagedChannelImpl.this.getLogId());
          stringBuilder.append("] Unexpected exception from parsing service config");
          logger.log(level, stringBuilder.toString(), runtimeException);
        }  
      this.this$1.helper.lb.handleResolvedAddressGroups(servers, config);
    }
  }
  
  @VisibleForTesting
  class NameResolverRefresh implements Runnable {
    boolean cancelled;
    
    public void run() {
      if (this.cancelled)
        return; 
      ManagedChannelImpl.access$1102(ManagedChannelImpl.this, null);
      ManagedChannelImpl.access$1202(ManagedChannelImpl.this, null);
      if (ManagedChannelImpl.this.nameResolver != null)
        ManagedChannelImpl.this.nameResolver.refresh(); 
    }
  }
  
  private class RealChannel extends Channel {
    private RealChannel() {}
    
    public String authority() {
      return (String)Preconditions.checkNotNull(ManagedChannelImpl.this.nameResolver.getServiceAuthority(), "authority");
    }
    
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, CallOptions param1CallOptions) {
      ScheduledExecutorService scheduledExecutorService;
      Executor executor = ManagedChannelImpl.this.getCallExecutor(param1CallOptions);
      ClientCallImpl.ClientTransportProvider clientTransportProvider = ManagedChannelImpl.this.transportProvider;
      if (ManagedChannelImpl.this.terminated) {
        scheduledExecutorService = null;
      } else {
        scheduledExecutorService = ManagedChannelImpl.this.transportFactory.getScheduledExecutorService();
      } 
      return (new ClientCallImpl<ReqT, RespT>(param1MethodDescriptor, executor, param1CallOptions, clientTransportProvider, scheduledExecutorService, ManagedChannelImpl.this.channelCallTracer, ManagedChannelImpl.this.retryEnabled)).setFullStreamDecompression(ManagedChannelImpl.this.fullStreamDecompression).setDecompressorRegistry(ManagedChannelImpl.this.decompressorRegistry).setCompressorRegistry(ManagedChannelImpl.this.compressorRegistry);
    }
  }
  
  private final class SubchannelImpl extends AbstractSubchannel {
    final Attributes attrs;
    
    @GuardedBy("shutdownLock")
    ScheduledFuture<?> delayedShutdownTask;
    
    final Object shutdownLock = new Object();
    
    @GuardedBy("shutdownLock")
    boolean shutdownRequested;
    
    InternalSubchannel subchannel;
    
    SubchannelImpl(Attributes param1Attributes) {
      this.attrs = (Attributes)Preconditions.checkNotNull(param1Attributes, "attrs");
    }
    
    public EquivalentAddressGroup getAddresses() {
      return this.subchannel.getAddressGroup();
    }
    
    public Attributes getAttributes() {
      return this.attrs;
    }
    
    Instrumented<Channelz.ChannelStats> getInternalSubchannel() {
      return this.subchannel;
    }
    
    ClientTransport obtainActiveTransport() {
      return this.subchannel.obtainActiveTransport();
    }
    
    public void requestConnection() {
      this.subchannel.obtainActiveTransport();
    }
    
    public void shutdown() {
      synchronized (this.shutdownLock) {
        if (this.shutdownRequested) {
          if (ManagedChannelImpl.this.terminating && this.delayedShutdownTask != null) {
            this.delayedShutdownTask.cancel(false);
            this.delayedShutdownTask = null;
          } else {
            return;
          } 
        } else {
          this.shutdownRequested = true;
        } 
        if (!ManagedChannelImpl.this.terminating) {
          ScheduledExecutorService scheduledExecutorService = ManagedChannelImpl.this.transportFactory.getScheduledExecutorService();
          LogExceptionRunnable logExceptionRunnable = new LogExceptionRunnable();
          Runnable runnable = new Runnable() {
              public void run() {
                ManagedChannelImpl.SubchannelImpl.this.subchannel.shutdown(ManagedChannelImpl.SUBCHANNEL_SHUTDOWN_STATUS);
              }
            };
          super(this);
          this(runnable);
          this.delayedShutdownTask = scheduledExecutorService.schedule(logExceptionRunnable, 5L, TimeUnit.SECONDS);
          return;
        } 
        this.subchannel.shutdown(ManagedChannelImpl.SHUTDOWN_STATUS);
        return;
      } 
    }
    
    public String toString() {
      return this.subchannel.getLogId().toString();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.subchannel.shutdown(ManagedChannelImpl.SUBCHANNEL_SHUTDOWN_STATUS);
    }
  }
  
  private final class UncommittedRetriableStreamsRegistry {
    final Object lock = new Object();
    
    @GuardedBy("lock")
    Status shutdownStatus;
    
    @GuardedBy("lock")
    Collection<ClientStream> uncommittedRetriableStreams = new HashSet<ClientStream>();
    
    private UncommittedRetriableStreamsRegistry() {}
    
    @Nullable
    Status add(RetriableStream<?> param1RetriableStream) {
      synchronized (this.lock) {
        Status status;
        if (this.shutdownStatus != null) {
          status = this.shutdownStatus;
          return status;
        } 
        this.uncommittedRetriableStreams.add(status);
        return null;
      } 
    }
    
    void onShutdown(Status param1Status) {
      synchronized (this.lock) {
        if (this.shutdownStatus != null)
          return; 
        this.shutdownStatus = param1Status;
        boolean bool = this.uncommittedRetriableStreams.isEmpty();
        if (bool)
          ManagedChannelImpl.this.delayedTransport.shutdown(param1Status); 
        return;
      } 
    }
    
    void onShutdownNow(Status param1Status) {
      onShutdown(param1Status);
      synchronized (this.lock) {
        ArrayList arrayList = new ArrayList();
        this((Collection)this.uncommittedRetriableStreams);
        null = arrayList.iterator();
        while (null.hasNext())
          ((ClientStream)null.next()).cancel(param1Status); 
        ManagedChannelImpl.this.delayedTransport.shutdownNow(param1Status);
        return;
      } 
    }
    
    void remove(RetriableStream<?> param1RetriableStream) {
      synchronized (this.lock) {
        this.uncommittedRetriableStreams.remove(param1RetriableStream);
        if (this.uncommittedRetriableStreams.isEmpty()) {
          Status status = this.shutdownStatus;
          HashSet<ClientStream> hashSet = new HashSet();
          this();
          this.uncommittedRetriableStreams = hashSet;
        } else {
          param1RetriableStream = null;
        } 
        if (param1RetriableStream != null)
          ManagedChannelImpl.this.delayedTransport.shutdown((Status)param1RetriableStream); 
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ManagedChannelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */