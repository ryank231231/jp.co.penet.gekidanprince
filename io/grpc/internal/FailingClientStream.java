package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.Status;

public final class FailingClientStream extends NoopClientStream {
  private final Status error;
  
  private final ClientStreamListener.RpcProgress rpcProgress;
  
  private boolean started;
  
  public FailingClientStream(Status paramStatus) {
    this(paramStatus, ClientStreamListener.RpcProgress.PROCESSED);
  }
  
  public FailingClientStream(Status paramStatus, ClientStreamListener.RpcProgress paramRpcProgress) {
    Preconditions.checkArgument(paramStatus.isOk() ^ true, "error must not be OK");
    this.error = paramStatus;
    this.rpcProgress = paramRpcProgress;
  }
  
  @VisibleForTesting
  Status getError() {
    return this.error;
  }
  
  public void start(ClientStreamListener paramClientStreamListener) {
    Preconditions.checkState(this.started ^ true, "already started");
    this.started = true;
    paramClientStreamListener.closed(this.error, this.rpcProgress, new Metadata());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\FailingClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */