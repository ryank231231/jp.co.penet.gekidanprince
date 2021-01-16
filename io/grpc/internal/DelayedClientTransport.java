package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.CallOptions;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class DelayedClientTransport implements ManagedClientTransport {
  private final ChannelExecutor channelExecutor;
  
  private final Executor defaultAppExecutor;
  
  @Nullable
  @GuardedBy("lock")
  private LoadBalancer.SubchannelPicker lastPicker;
  
  @GuardedBy("lock")
  private long lastPickerVersion;
  
  private ManagedClientTransport.Listener listener;
  
  private final Object lock = new Object();
  
  private final LogId lodId = LogId.allocate(getClass().getName());
  
  @Nonnull
  @GuardedBy("lock")
  private Collection<PendingStream> pendingStreams = new LinkedHashSet<PendingStream>();
  
  private Runnable reportTransportInUse;
  
  private Runnable reportTransportNotInUse;
  
  private Runnable reportTransportTerminated;
  
  @GuardedBy("lock")
  private Status shutdownStatus;
  
  DelayedClientTransport(Executor paramExecutor, ChannelExecutor paramChannelExecutor) {
    this.defaultAppExecutor = paramExecutor;
    this.channelExecutor = paramChannelExecutor;
  }
  
  @GuardedBy("lock")
  private PendingStream createPendingStream(LoadBalancer.PickSubchannelArgs paramPickSubchannelArgs) {
    PendingStream pendingStream = new PendingStream(this, paramPickSubchannelArgs, null);
    this.pendingStreams.add(pendingStream);
    if (getPendingStreamsCount() == 1)
      this.channelExecutor.executeLater(this.reportTransportInUse); 
    return pendingStream;
  }
  
  public LogId getLogId() {
    return this.lodId;
  }
  
  @VisibleForTesting
  final int getPendingStreamsCount() {
    synchronized (this.lock) {
      return this.pendingStreams.size();
    } 
  }
  
  public ListenableFuture<Channelz.SocketStats> getStats() {
    SettableFuture settableFuture = SettableFuture.create();
    settableFuture.set(null);
    return (ListenableFuture<Channelz.SocketStats>)settableFuture;
  }
  
  public final boolean hasPendingStreams() {
    synchronized (this.lock) {
      boolean bool;
      if (!this.pendingStreams.isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } 
  }
  
  public final ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions) {
    try {
      PickSubchannelArgsImpl pickSubchannelArgsImpl = new PickSubchannelArgsImpl();
      this(paramMethodDescriptor, paramMetadata, paramCallOptions);
    } finally {
      this.channelExecutor.drain();
    } 
  }
  
  public final void ping(ClientTransport.PingCallback paramPingCallback, Executor paramExecutor) {
    throw new UnsupportedOperationException("This method is not expected to be called");
  }
  
  final void reprocess(@Nullable LoadBalancer.SubchannelPicker paramSubchannelPicker) {
    synchronized (this.lock) {
      this.lastPicker = paramSubchannelPicker;
      this.lastPickerVersion++;
      if (paramSubchannelPicker == null || !hasPendingStreams())
        return; 
      null = new ArrayList();
      this((Collection)this.pendingStreams);
      null = new ArrayList();
      for (PendingStream pendingStream : null) {
        LoadBalancer.PickResult pickResult = paramSubchannelPicker.pickSubchannel(PendingStream.access$200(pendingStream));
        CallOptions callOptions = PendingStream.access$200(pendingStream).getCallOptions();
        ClientTransport clientTransport = GrpcUtil.getTransportFromPickResult(pickResult, callOptions.isWaitForReady());
        if (clientTransport != null) {
          Executor executor = this.defaultAppExecutor;
          if (callOptions.getExecutor() != null)
            executor = callOptions.getExecutor(); 
          executor.execute((Runnable)new Object(this, pendingStream, clientTransport));
          null.add(pendingStream);
        } 
      } 
      synchronized (this.lock) {
        if (!hasPendingStreams())
          return; 
        this.pendingStreams.removeAll((Collection<?>)null);
        if (this.pendingStreams.isEmpty()) {
          LinkedHashSet<PendingStream> linkedHashSet = new LinkedHashSet();
          this();
          this.pendingStreams = linkedHashSet;
        } 
        if (!hasPendingStreams()) {
          this.channelExecutor.executeLater(this.reportTransportNotInUse);
          if (this.shutdownStatus != null && this.reportTransportTerminated != null) {
            this.channelExecutor.executeLater(this.reportTransportTerminated);
            this.reportTransportTerminated = null;
          } 
        } 
        this.channelExecutor.drain();
        return;
      } 
    } 
  }
  
  public final void shutdown(Status paramStatus) {
    synchronized (this.lock) {
      if (this.shutdownStatus != null)
        return; 
      this.shutdownStatus = paramStatus;
      ChannelExecutor channelExecutor = this.channelExecutor;
      Object object = new Object();
      super(this, paramStatus);
      channelExecutor.executeLater((Runnable)object);
      if (!hasPendingStreams() && this.reportTransportTerminated != null) {
        this.channelExecutor.executeLater(this.reportTransportTerminated);
        this.reportTransportTerminated = null;
      } 
      this.channelExecutor.drain();
      return;
    } 
  }
  
  public final void shutdownNow(Status paramStatus) {
    shutdown(paramStatus);
    synchronized (this.lock) {
      Collection<PendingStream> collection = this.pendingStreams;
      Runnable runnable = this.reportTransportTerminated;
      this.reportTransportTerminated = null;
      if (!this.pendingStreams.isEmpty())
        this.pendingStreams = Collections.emptyList(); 
      if (runnable != null) {
        null = (Object<PendingStream>)collection.iterator();
        while (null.hasNext())
          ((PendingStream)null.next()).cancel(paramStatus); 
        this.channelExecutor.executeLater(runnable).drain();
      } 
      return;
    } 
  }
  
  public final Runnable start(ManagedClientTransport.Listener paramListener) {
    this.listener = paramListener;
    this.reportTransportInUse = (Runnable)new Object(this, paramListener);
    this.reportTransportNotInUse = (Runnable)new Object(this, paramListener);
    this.reportTransportTerminated = (Runnable)new Object(this, paramListener);
    return null;
  }
  
  class DelayedClientTransport {}
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\DelayedClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */