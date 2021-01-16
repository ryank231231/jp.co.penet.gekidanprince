package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class MetadataApplierImpl implements CallCredentials.MetadataApplier {
  private final CallOptions callOptions;
  
  private final Context ctx;
  
  DelayedStream delayedStream;
  
  boolean finalized;
  
  private final Object lock = new Object();
  
  private final MethodDescriptor<?, ?> method;
  
  private final Metadata origHeaders;
  
  @Nullable
  @GuardedBy("lock")
  private ClientStream returnedStream;
  
  private final ClientTransport transport;
  
  MetadataApplierImpl(ClientTransport paramClientTransport, MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions) {
    this.transport = paramClientTransport;
    this.method = paramMethodDescriptor;
    this.origHeaders = paramMetadata;
    this.callOptions = paramCallOptions;
    this.ctx = Context.current();
  }
  
  private void finalizeWith(ClientStream paramClientStream) {
    boolean bool = this.finalized;
    boolean bool1 = true;
    Preconditions.checkState(bool ^ true, "already finalized");
    this.finalized = true;
    synchronized (this.lock) {
      if (this.returnedStream == null) {
        this.returnedStream = paramClientStream;
        return;
      } 
      if (this.delayedStream == null)
        bool1 = false; 
      Preconditions.checkState(bool1, "delayedStream is null");
      this.delayedStream.setStream(paramClientStream);
      return;
    } 
  }
  
  public void apply(Metadata paramMetadata) {
    Preconditions.checkState(this.finalized ^ true, "apply() or fail() already called");
    Preconditions.checkNotNull(paramMetadata, "headers");
    this.origHeaders.merge(paramMetadata);
    Context context = this.ctx.attach();
    try {
      ClientStream clientStream = this.transport.newStream(this.method, this.origHeaders, this.callOptions);
      this.ctx.detach(context);
      return;
    } finally {
      this.ctx.detach(context);
    } 
  }
  
  public void fail(Status paramStatus) {
    Preconditions.checkArgument(paramStatus.isOk() ^ true, "Cannot fail with OK status");
    Preconditions.checkState(this.finalized ^ true, "apply() or fail() already called");
    finalizeWith(new FailingClientStream(paramStatus));
  }
  
  ClientStream returnStream() {
    synchronized (this.lock) {
      if (this.returnedStream == null) {
        DelayedStream delayedStream = new DelayedStream();
        this();
        this.delayedStream = delayedStream;
        delayedStream = this.delayedStream;
        this.returnedStream = delayedStream;
        return delayedStream;
      } 
      return this.returnedStream;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\MetadataApplierImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */