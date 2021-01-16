package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class OobChannel extends ManagedChannel implements Instrumented<Channelz.ChannelStats> {
  private static final Logger log = Logger.getLogger(OobChannel.class.getName());
  
  private final String authority;
  
  private final CallTracer channelCallsTracer;
  
  private final Channelz channelz;
  
  private final ScheduledExecutorService deadlineCancellationExecutor;
  
  private final DelayedClientTransport delayedTransport;
  
  private final Executor executor;
  
  private final ObjectPool<? extends Executor> executorPool;
  
  private final LogId logId = LogId.allocate(getClass().getName());
  
  private volatile boolean shutdown;
  
  private InternalSubchannel subchannel;
  
  private AbstractSubchannel subchannelImpl;
  
  private LoadBalancer.SubchannelPicker subchannelPicker;
  
  private final CountDownLatch terminatedLatch = new CountDownLatch(1);
  
  private final ClientCallImpl.ClientTransportProvider transportProvider = new ClientCallImpl.ClientTransportProvider() {
      public ClientTransport get(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs) {
        return (ClientTransport)OobChannel.this.delayedTransport;
      }
      
      public <ReqT> RetriableStream<ReqT> newRetriableStream(MethodDescriptor<ReqT, ?> param1MethodDescriptor, CallOptions param1CallOptions, Metadata param1Metadata, Context param1Context) {
        throw new UnsupportedOperationException("OobChannel should not create retriable streams");
      }
    };
  
  OobChannel(String paramString, ObjectPool<? extends Executor> paramObjectPool, ScheduledExecutorService paramScheduledExecutorService, ChannelExecutor paramChannelExecutor, CallTracer paramCallTracer, Channelz paramChannelz) {
    this.authority = (String)Preconditions.checkNotNull(paramString, "authority");
    this.executorPool = (ObjectPool<? extends Executor>)Preconditions.checkNotNull(paramObjectPool, "executorPool");
    this.executor = (Executor)Preconditions.checkNotNull(paramObjectPool.getObject(), "executor");
    this.deadlineCancellationExecutor = (ScheduledExecutorService)Preconditions.checkNotNull(paramScheduledExecutorService, "deadlineCancellationExecutor");
    this.delayedTransport = new DelayedClientTransport(this.executor, paramChannelExecutor);
    this.channelz = (Channelz)Preconditions.checkNotNull(paramChannelz);
    this.delayedTransport.start(new ManagedClientTransport$Listener() {
          public void transportInUse(boolean param1Boolean) {}
          
          public void transportReady() {}
          
          public void transportShutdown(Status param1Status) {}
          
          public void transportTerminated() {
            OobChannel.this.subchannelImpl.shutdown();
          }
        });
    this.channelCallsTracer = paramCallTracer;
  }
  
  public String authority() {
    return this.authority;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.terminatedLatch.await(paramLong, paramTimeUnit);
  }
  
  InternalSubchannel getInternalSubchannel() {
    return this.subchannel;
  }
  
  public LogId getLogId() {
    return this.logId;
  }
  
  public ListenableFuture<Channelz.ChannelStats> getStats() {
    SettableFuture settableFuture = SettableFuture.create();
    Channelz.ChannelStats.Builder builder = new Channelz.ChannelStats.Builder();
    this.channelCallsTracer.updateBuilder(builder);
    builder.setTarget(this.authority).setState(this.subchannel.getState()).setSubchannels((List)Collections.singletonList(this.subchannel));
    settableFuture.set(builder.build());
    return (ListenableFuture<Channelz.ChannelStats>)settableFuture;
  }
  
  @VisibleForTesting
  LoadBalancer.Subchannel getSubchannel() {
    return this.subchannelImpl;
  }
  
  void handleSubchannelStateChange(final ConnectivityStateInfo newState) {
    switch (newState.getState()) {
      default:
        return;
      case TRANSIENT_FAILURE:
        this.delayedTransport.reprocess(new LoadBalancer.SubchannelPicker() {
              final LoadBalancer.PickResult errorResult = LoadBalancer.PickResult.withError(newState.getStatus());
              
              public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs) {
                return this.errorResult;
              }
            });
      case READY:
      case IDLE:
        break;
    } 
    this.delayedTransport.reprocess(this.subchannelPicker);
  }
  
  void handleSubchannelTerminated() {
    this.channelz.removeSubchannel(this);
    this.executorPool.returnObject(this.executor);
    this.terminatedLatch.countDown();
  }
  
  public boolean isShutdown() {
    return this.shutdown;
  }
  
  public boolean isTerminated() {
    boolean bool;
    if (this.terminatedLatch.getCount() == 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> paramMethodDescriptor, CallOptions paramCallOptions) {
    Executor executor;
    if (paramCallOptions.getExecutor() == null) {
      executor = this.executor;
    } else {
      executor = paramCallOptions.getExecutor();
    } 
    return new ClientCallImpl<RequestT, ResponseT>(paramMethodDescriptor, executor, paramCallOptions, this.transportProvider, this.deadlineCancellationExecutor, this.channelCallsTracer, false);
  }
  
  public void resetConnectBackoff() {
    this.subchannel.resetConnectBackoff();
  }
  
  void setSubchannel(final InternalSubchannel subchannel) {
    log.log(Level.FINE, "[{0}] Created with [{1}]", new Object[] { this, subchannel });
    this.subchannel = subchannel;
    this.subchannelImpl = new AbstractSubchannel() {
        public EquivalentAddressGroup getAddresses() {
          return subchannel.getAddressGroup();
        }
        
        public Attributes getAttributes() {
          return Attributes.EMPTY;
        }
        
        Instrumented<Channelz.ChannelStats> getInternalSubchannel() {
          return subchannel;
        }
        
        ClientTransport obtainActiveTransport() {
          return subchannel.obtainActiveTransport();
        }
        
        public void requestConnection() {
          subchannel.obtainActiveTransport();
        }
        
        public void shutdown() {
          subchannel.shutdown(Status.UNAVAILABLE.withDescription("OobChannel is shutdown"));
        }
      };
    this.subchannelPicker = new LoadBalancer.SubchannelPicker() {
        final LoadBalancer.PickResult result = LoadBalancer.PickResult.withSubchannel(OobChannel.this.subchannelImpl);
        
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs) {
          return this.result;
        }
      };
    this.delayedTransport.reprocess(this.subchannelPicker);
  }
  
  public ManagedChannel shutdown() {
    this.shutdown = true;
    this.delayedTransport.shutdown(Status.UNAVAILABLE.withDescription("OobChannel.shutdown() called"));
    return this;
  }
  
  public ManagedChannel shutdownNow() {
    this.shutdown = true;
    this.delayedTransport.shutdownNow(Status.UNAVAILABLE.withDescription("OobChannel.shutdownNow() called"));
    return this;
  }
  
  void updateAddresses(EquivalentAddressGroup paramEquivalentAddressGroup) {
    this.subchannel.updateAddresses(paramEquivalentAddressGroup);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\OobChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */