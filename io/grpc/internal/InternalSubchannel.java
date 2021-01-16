package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.errorprone.annotations.ForOverride;
import io.grpc.CallOptions;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class InternalSubchannel implements Instrumented<Channelz.ChannelStats> {
  private static final Logger log = Logger.getLogger(InternalSubchannel.class.getName());
  
  @Nullable
  private volatile ManagedClientTransport activeTransport;
  
  @GuardedBy("lock")
  private EquivalentAddressGroup addressGroup;
  
  @GuardedBy("lock")
  private int addressIndex;
  
  private final String authority;
  
  private final BackoffPolicy.Provider backoffPolicyProvider;
  
  private final Callback callback;
  
  private final CallTracer callsTracer;
  
  private final ChannelExecutor channelExecutor;
  
  private final Channelz channelz;
  
  @GuardedBy("lock")
  private final Stopwatch connectingTimer;
  
  private final InUseStateAggregator<ConnectionClientTransport> inUseStateAggregator = new InUseStateAggregator<ConnectionClientTransport>() {
      void handleInUse() {
        InternalSubchannel.this.callback.onInUse(InternalSubchannel.this);
      }
      
      void handleNotInUse() {
        InternalSubchannel.this.callback.onNotInUse(InternalSubchannel.this);
      }
    };
  
  private final Object lock = new Object();
  
  private final LogId logId = LogId.allocate(getClass().getName());
  
  @Nullable
  @GuardedBy("lock")
  private ConnectionClientTransport pendingTransport;
  
  @GuardedBy("lock")
  private boolean reconnectCanceled;
  
  @GuardedBy("lock")
  private BackoffPolicy reconnectPolicy;
  
  @Nullable
  @GuardedBy("lock")
  private ScheduledFuture<?> reconnectTask;
  
  private final ScheduledExecutorService scheduledExecutor;
  
  @GuardedBy("lock")
  private Status shutdownReason;
  
  @GuardedBy("lock")
  private ConnectivityStateInfo state = ConnectivityStateInfo.forNonError(ConnectivityState.IDLE);
  
  private final ClientTransportFactory transportFactory;
  
  @GuardedBy("lock")
  private final Collection<ConnectionClientTransport> transports = new ArrayList<ConnectionClientTransport>();
  
  private final String userAgent;
  
  InternalSubchannel(EquivalentAddressGroup paramEquivalentAddressGroup, String paramString1, String paramString2, BackoffPolicy.Provider paramProvider, ClientTransportFactory paramClientTransportFactory, ScheduledExecutorService paramScheduledExecutorService, Supplier<Stopwatch> paramSupplier, ChannelExecutor paramChannelExecutor, Callback paramCallback, Channelz paramChannelz, CallTracer paramCallTracer) {
    this.addressGroup = (EquivalentAddressGroup)Preconditions.checkNotNull(paramEquivalentAddressGroup, "addressGroup");
    this.authority = paramString1;
    this.userAgent = paramString2;
    this.backoffPolicyProvider = paramProvider;
    this.transportFactory = paramClientTransportFactory;
    this.scheduledExecutor = paramScheduledExecutorService;
    this.connectingTimer = (Stopwatch)paramSupplier.get();
    this.channelExecutor = paramChannelExecutor;
    this.callback = paramCallback;
    this.channelz = paramChannelz;
    this.callsTracer = paramCallTracer;
  }
  
  @GuardedBy("lock")
  private void cancelReconnectTask() {
    ScheduledFuture<?> scheduledFuture = this.reconnectTask;
    if (scheduledFuture != null) {
      scheduledFuture.cancel(false);
      this.reconnectCanceled = true;
      this.reconnectTask = null;
      this.reconnectPolicy = null;
    } 
  }
  
  @GuardedBy("lock")
  private void gotoNonErrorState(ConnectivityState paramConnectivityState) {
    gotoState(ConnectivityStateInfo.forNonError(paramConnectivityState));
  }
  
  @GuardedBy("lock")
  private void gotoState(final ConnectivityStateInfo newState) {
    if (this.state.getState() != newState.getState()) {
      boolean bool;
      if (this.state.getState() != ConnectivityState.SHUTDOWN) {
        bool = true;
      } else {
        bool = false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot transition out of SHUTDOWN to ");
      stringBuilder.append(newState);
      Preconditions.checkState(bool, stringBuilder.toString());
      this.state = newState;
      this.channelExecutor.executeLater(new Runnable() {
            public void run() {
              InternalSubchannel.this.callback.onStateChange(InternalSubchannel.this, newState);
            }
          });
    } 
  }
  
  @GuardedBy("lock")
  private void handleTermination() {
    this.channelExecutor.executeLater(new Runnable() {
          public void run() {
            InternalSubchannel.this.callback.onTerminated(InternalSubchannel.this);
          }
        });
  }
  
  private void handleTransportInUseState(final ConnectionClientTransport transport, final boolean inUse) {
    this.channelExecutor.executeLater(new Runnable() {
          public void run() {
            InternalSubchannel.this.inUseStateAggregator.updateObjectInUse(transport, inUse);
          }
        }).drain();
  }
  
  @GuardedBy("lock")
  private void scheduleBackoff(Status paramStatus) {
    gotoState(ConnectivityStateInfo.forTransientFailure(paramStatus));
    if (this.reconnectPolicy == null)
      this.reconnectPolicy = this.backoffPolicyProvider.get(); 
    long l = this.reconnectPolicy.nextBackoffNanos() - this.connectingTimer.elapsed(TimeUnit.NANOSECONDS);
    boolean bool = log.isLoggable(Level.FINE);
    boolean bool1 = true;
    if (bool)
      log.log(Level.FINE, "[{0}] Scheduling backoff for {1} ns", new Object[] { this.logId, Long.valueOf(l) }); 
    if (this.reconnectTask != null)
      bool1 = false; 
    Preconditions.checkState(bool1, "previous reconnectTask is not done");
    this.reconnectCanceled = false;
    class EndOfCurrentBackoff implements Runnable {
      public void run() {
        try {
          synchronized (InternalSubchannel.this.lock) {
            InternalSubchannel.access$302(InternalSubchannel.this, null);
            if (InternalSubchannel.this.reconnectCanceled) {
              InternalSubchannel.this.channelExecutor.drain();
              return;
            } 
            InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
            InternalSubchannel.this.startNewTransport();
          } 
        } catch (Throwable throwable) {
          InternalSubchannel.log.log(Level.WARNING, "Exception handling end of backoff", throwable);
        } finally {
          Exception exception;
        } 
        InternalSubchannel.this.channelExecutor.drain();
      }
    };
    this.reconnectTask = this.scheduledExecutor.schedule(new LogExceptionRunnable(new EndOfCurrentBackoff()), l, TimeUnit.NANOSECONDS);
  }
  
  @GuardedBy("lock")
  private void startNewTransport() {
    boolean bool;
    if (this.reconnectTask == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Should have no reconnectTask scheduled");
    if (this.addressIndex == 0)
      this.connectingTimer.reset().start(); 
    SocketAddress socketAddress = this.addressGroup.getAddresses().get(this.addressIndex);
    if (socketAddress instanceof PairSocketAddress) {
      socketAddress = socketAddress;
      callTracingTransport = (CallTracingTransport)socketAddress.getAttributes().get(ProxyDetector.PROXY_PARAMS_KEY);
      socketAddress = socketAddress.getAddress();
    } else {
      callTracingTransport = null;
    } 
    CallTracingTransport callTracingTransport = new CallTracingTransport(this.transportFactory.newClientTransport(socketAddress, this.authority, this.userAgent, (ProxyParameters)callTracingTransport), this.callsTracer);
    this.channelz.addClientSocket((Instrumented<Channelz.SocketStats>)callTracingTransport);
    if (log.isLoggable(Level.FINE))
      log.log(Level.FINE, "[{0}] Created {1} for {2}", new Object[] { this.logId, callTracingTransport.getLogId(), socketAddress }); 
    this.pendingTransport = callTracingTransport;
    this.transports.add(callTracingTransport);
    Runnable runnable = callTracingTransport.start(new TransportListener(callTracingTransport, socketAddress));
    if (runnable != null)
      this.channelExecutor.executeLater(runnable); 
  }
  
  EquivalentAddressGroup getAddressGroup() {
    try {
    
    } finally {
      this.channelExecutor.drain();
    } 
  }
  
  public LogId getLogId() {
    return this.logId;
  }
  
  @VisibleForTesting
  ConnectivityState getState() {
    try {
    
    } finally {
      this.channelExecutor.drain();
    } 
  }
  
  public ListenableFuture<Channelz.ChannelStats> getStats() {
    SettableFuture settableFuture = SettableFuture.create();
    null = new Channelz.ChannelStats.Builder();
    synchronized (this.lock) {
      null.setTarget(this.addressGroup.toString()).setState(getState());
      ArrayList<WithLogId> arrayList = new ArrayList();
      this((Collection)this.transports);
      null.setSockets(arrayList);
      this.callsTracer.updateBuilder(null);
      settableFuture.set(null.build());
      return (ListenableFuture<Channelz.ChannelStats>)settableFuture;
    } 
  }
  
  @Nullable
  ClientTransport obtainActiveTransport() {
    null = this.activeTransport;
    if (null != null)
      return (ClientTransport)null; 
    try {
    
    } finally {
      this.channelExecutor.drain();
    } 
  }
  
  void resetConnectBackoff() {
    try {
    
    } finally {
      this.channelExecutor.drain();
    } 
  }
  
  public void shutdown(Status paramStatus) {
    try {
    
    } finally {
      this.channelExecutor.drain();
    } 
  }
  
  void shutdownNow(Status paramStatus) {
    shutdown(paramStatus);
    try {
    
    } finally {
      this.channelExecutor.drain();
    } 
  }
  
  public void updateAddresses(EquivalentAddressGroup paramEquivalentAddressGroup) {
    try {
    
    } finally {
      this.channelExecutor.drain();
    } 
  }
  
  @VisibleForTesting
  static final class CallTracingTransport extends ForwardingConnectionClientTransport {
    private final CallTracer callTracer;
    
    private final ConnectionClientTransport delegate;
    
    private CallTracingTransport(ConnectionClientTransport param1ConnectionClientTransport, CallTracer param1CallTracer) {
      this.delegate = param1ConnectionClientTransport;
      this.callTracer = param1CallTracer;
    }
    
    protected ConnectionClientTransport delegate() {
      return this.delegate;
    }
    
    public ClientStream newStream(MethodDescriptor<?, ?> param1MethodDescriptor, Metadata param1Metadata, CallOptions param1CallOptions) {
      return new ForwardingClientStream() {
          protected ClientStream delegate() {
            return streamDelegate;
          }
          
          public void start(final ClientStreamListener listener) {
            InternalSubchannel.CallTracingTransport.this.callTracer.reportCallStarted();
            super.start(new ForwardingClientStreamListener() {
                  public void closed(Status param3Status, Metadata param3Metadata) {
                    InternalSubchannel.CallTracingTransport.this.callTracer.reportCallEnded(param3Status.isOk());
                    super.closed(param3Status, param3Metadata);
                  }
                  
                  public void closed(Status param3Status, ClientStreamListener.RpcProgress param3RpcProgress, Metadata param3Metadata) {
                    InternalSubchannel.CallTracingTransport.this.callTracer.reportCallEnded(param3Status.isOk());
                    super.closed(param3Status, param3RpcProgress, param3Metadata);
                  }
                  
                  protected ClientStreamListener delegate() {
                    return listener;
                  }
                });
          }
        };
    }
  }
  
  class null extends ForwardingClientStream {
    protected ClientStream delegate() {
      return streamDelegate;
    }
    
    public void start(final ClientStreamListener listener) {
      this.this$0.callTracer.reportCallStarted();
      super.start(new ForwardingClientStreamListener() {
            public void closed(Status param3Status, Metadata param3Metadata) {
              this.this$1.this$0.callTracer.reportCallEnded(param3Status.isOk());
              super.closed(param3Status, param3Metadata);
            }
            
            public void closed(Status param3Status, ClientStreamListener.RpcProgress param3RpcProgress, Metadata param3Metadata) {
              this.this$1.this$0.callTracer.reportCallEnded(param3Status.isOk());
              super.closed(param3Status, param3RpcProgress, param3Metadata);
            }
            
            protected ClientStreamListener delegate() {
              return listener;
            }
          });
    }
  }
  
  class null extends ForwardingClientStreamListener {
    public void closed(Status param1Status, Metadata param1Metadata) {
      this.this$1.this$0.callTracer.reportCallEnded(param1Status.isOk());
      super.closed(param1Status, param1Metadata);
    }
    
    public void closed(Status param1Status, ClientStreamListener.RpcProgress param1RpcProgress, Metadata param1Metadata) {
      this.this$1.this$0.callTracer.reportCallEnded(param1Status.isOk());
      super.closed(param1Status, param1RpcProgress, param1Metadata);
    }
    
    protected ClientStreamListener delegate() {
      return listener;
    }
  }
  
  static abstract class Callback {
    @ForOverride
    void onInUse(InternalSubchannel param1InternalSubchannel) {}
    
    @ForOverride
    void onNotInUse(InternalSubchannel param1InternalSubchannel) {}
    
    @ForOverride
    void onStateChange(InternalSubchannel param1InternalSubchannel, ConnectivityStateInfo param1ConnectivityStateInfo) {}
    
    @ForOverride
    void onTerminated(InternalSubchannel param1InternalSubchannel) {}
  }
  
  private class TransportListener implements ManagedClientTransport.Listener {
    final SocketAddress address;
    
    final ConnectionClientTransport transport;
    
    TransportListener(ConnectionClientTransport param1ConnectionClientTransport, SocketAddress param1SocketAddress) {
      this.transport = param1ConnectionClientTransport;
      this.address = param1SocketAddress;
    }
    
    public void transportInUse(boolean param1Boolean) {
      InternalSubchannel.this.handleTransportInUseState(this.transport, param1Boolean);
    }
    
    public void transportReady() {
      boolean bool = InternalSubchannel.log.isLoggable(Level.FINE);
      boolean bool1 = true;
      if (bool)
        InternalSubchannel.log.log(Level.FINE, "[{0}] {1} for {2} is ready", new Object[] { InternalSubchannel.access$1000(this.this$0), this.transport.getLogId(), this.address }); 
      try {
      
      } finally {
        InternalSubchannel.this.channelExecutor.drain();
      } 
    }
    
    public void transportShutdown(Status param1Status) {
      boolean bool = InternalSubchannel.log.isLoggable(Level.FINE);
      boolean bool1 = true;
      if (bool)
        InternalSubchannel.log.log(Level.FINE, "[{0}] {1} for {2} is being shutdown with status {3}", new Object[] { InternalSubchannel.access$1000(this.this$0), this.transport.getLogId(), this.address, param1Status }); 
      try {
      
      } finally {
        InternalSubchannel.this.channelExecutor.drain();
      } 
    }
    
    public void transportTerminated() {
      boolean bool = InternalSubchannel.log.isLoggable(Level.FINE);
      boolean bool1 = true;
      if (bool)
        InternalSubchannel.log.log(Level.FINE, "[{0}] {1} for {2} is terminated", new Object[] { InternalSubchannel.access$1000(this.this$0), this.transport.getLogId(), this.address }); 
      InternalSubchannel.this.channelz.removeClientSocket((Instrumented<Channelz.SocketStats>)this.transport);
      InternalSubchannel.this.handleTransportInUseState(this.transport, false);
      try {
      
      } finally {
        InternalSubchannel.this.channelExecutor.drain();
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\InternalSubchannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */