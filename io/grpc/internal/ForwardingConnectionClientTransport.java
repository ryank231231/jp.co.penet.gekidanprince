package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.Executor;

abstract class ForwardingConnectionClientTransport implements ConnectionClientTransport {
  protected abstract ConnectionClientTransport delegate();
  
  public Attributes getAttributes() {
    return delegate().getAttributes();
  }
  
  public LogId getLogId() {
    return delegate().getLogId();
  }
  
  public ListenableFuture<Channelz.SocketStats> getStats() {
    return delegate().getStats();
  }
  
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions) {
    return delegate().newStream(paramMethodDescriptor, paramMetadata, paramCallOptions);
  }
  
  public void ping(ClientTransport$PingCallback paramClientTransport$PingCallback, Executor paramExecutor) {
    delegate().ping(paramClientTransport$PingCallback, paramExecutor);
  }
  
  public void shutdown(Status paramStatus) {
    delegate().shutdown(paramStatus);
  }
  
  public void shutdownNow(Status paramStatus) {
    delegate().shutdownNow(paramStatus);
  }
  
  public Runnable start(ManagedClientTransport$Listener paramManagedClientTransport$Listener) {
    return delegate().start(paramManagedClientTransport$Listener);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ForwardingConnectionClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */