package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.Executor;

class FailingClientTransport implements ClientTransport {
  @VisibleForTesting
  final Status error;
  
  private final ClientStreamListener.RpcProgress rpcProgress;
  
  FailingClientTransport(Status paramStatus, ClientStreamListener.RpcProgress paramRpcProgress) {
    Preconditions.checkArgument(paramStatus.isOk() ^ true, "error must not be OK");
    this.error = paramStatus;
    this.rpcProgress = paramRpcProgress;
  }
  
  public LogId getLogId() {
    throw new UnsupportedOperationException("Not a real transport");
  }
  
  public ListenableFuture<Channelz.SocketStats> getStats() {
    SettableFuture settableFuture = SettableFuture.create();
    settableFuture.set(null);
    return (ListenableFuture<Channelz.SocketStats>)settableFuture;
  }
  
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions) {
    return new FailingClientStream(this.error, this.rpcProgress);
  }
  
  public void ping(final ClientTransport.PingCallback callback, Executor paramExecutor) {
    paramExecutor.execute(new Runnable() {
          public void run() {
            callback.onFailure((Throwable)FailingClientTransport.this.error.asException());
          }
        });
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\FailingClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */