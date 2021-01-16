package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Decompressor;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import javax.annotation.Nullable;

public abstract class AbstractServerStream extends AbstractStream implements ServerStream, MessageFramer.Sink {
  private final MessageFramer framer;
  
  private boolean headersSent;
  
  private boolean outboundClosed;
  
  private final StatsTraceContext statsTraceCtx;
  
  protected AbstractServerStream(WritableBufferAllocator paramWritableBufferAllocator, StatsTraceContext paramStatsTraceContext) {
    this.statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx");
    this.framer = new MessageFramer(this, paramWritableBufferAllocator, paramStatsTraceContext);
  }
  
  private void addStatusToTrailers(Metadata paramMetadata, Status paramStatus) {
    paramMetadata.discardAll(InternalStatus.CODE_KEY);
    paramMetadata.discardAll(InternalStatus.MESSAGE_KEY);
    paramMetadata.put(InternalStatus.CODE_KEY, paramStatus);
    if (paramStatus.getDescription() != null)
      paramMetadata.put(InternalStatus.MESSAGE_KEY, paramStatus.getDescription()); 
  }
  
  protected abstract Sink abstractServerStreamSink();
  
  public final void cancel(Status paramStatus) {
    abstractServerStreamSink().cancel(paramStatus);
  }
  
  public final void close(Status paramStatus, Metadata paramMetadata) {
    Preconditions.checkNotNull(paramStatus, "status");
    Preconditions.checkNotNull(paramMetadata, "trailers");
    if (!this.outboundClosed) {
      this.outboundClosed = true;
      endOfMessages();
      addStatusToTrailers(paramMetadata, paramStatus);
      transportState().setClosedStatus(paramStatus);
      abstractServerStreamSink().writeTrailers(paramMetadata, this.headersSent, paramStatus);
    } 
  }
  
  public final void deliverFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
    Sink sink = abstractServerStreamSink();
    if (paramBoolean1)
      paramBoolean2 = false; 
    sink.writeFrame(paramWritableBuffer, paramBoolean2, paramInt);
  }
  
  protected final MessageFramer framer() {
    return this.framer;
  }
  
  public Attributes getAttributes() {
    return Attributes.EMPTY;
  }
  
  public String getAuthority() {
    return null;
  }
  
  public final boolean isReady() {
    return super.isReady();
  }
  
  public final void request(int paramInt) {
    abstractServerStreamSink().request(paramInt);
  }
  
  public final void setDecompressor(Decompressor paramDecompressor) {
    transportState().setDecompressor((Decompressor)Preconditions.checkNotNull(paramDecompressor, "decompressor"));
  }
  
  public final void setListener(ServerStreamListener paramServerStreamListener) {
    transportState().setListener(paramServerStreamListener);
  }
  
  public StatsTraceContext statsTraceContext() {
    return this.statsTraceCtx;
  }
  
  protected abstract TransportState transportState();
  
  public final void writeHeaders(Metadata paramMetadata) {
    Preconditions.checkNotNull(paramMetadata, "headers");
    this.headersSent = true;
    abstractServerStreamSink().writeHeaders(paramMetadata);
  }
  
  protected static interface Sink {
    void cancel(Status param1Status);
    
    void request(int param1Int);
    
    void writeFrame(@Nullable WritableBuffer param1WritableBuffer, boolean param1Boolean, int param1Int);
    
    void writeHeaders(Metadata param1Metadata);
    
    void writeTrailers(Metadata param1Metadata, boolean param1Boolean, Status param1Status);
  }
  
  protected static abstract class TransportState extends AbstractStream.TransportState {
    @Nullable
    private Status closedStatus;
    
    private boolean deframerClosed = false;
    
    private Runnable deframerClosedTask;
    
    private boolean endOfStream = false;
    
    private boolean immediateCloseRequested = false;
    
    private ServerStreamListener listener;
    
    private boolean listenerClosed;
    
    private final StatsTraceContext statsTraceCtx;
    
    protected TransportState(int param1Int, StatsTraceContext param1StatsTraceContext, TransportTracer param1TransportTracer) {
      super(param1Int, param1StatsTraceContext, (TransportTracer)Preconditions.checkNotNull(param1TransportTracer, "transportTracer"));
      this.statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(param1StatsTraceContext, "statsTraceCtx");
    }
    
    private void closeListener(Status param1Status) {
      boolean bool;
      if (!param1Status.isOk() || this.closedStatus != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      if (!this.listenerClosed) {
        if (!param1Status.isOk()) {
          this.statsTraceCtx.streamClosed(param1Status);
          getTransportTracer().reportStreamClosed(false);
        } else {
          this.statsTraceCtx.streamClosed(this.closedStatus);
          getTransportTracer().reportStreamClosed(this.closedStatus.isOk());
        } 
        this.listenerClosed = true;
        onStreamDeallocated();
        listener().closed(param1Status);
      } 
    }
    
    private void setClosedStatus(Status param1Status) {
      boolean bool;
      if (this.closedStatus == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "closedStatus can only be set once");
      this.closedStatus = param1Status;
    }
    
    public void complete() {
      if (this.deframerClosed) {
        this.deframerClosedTask = null;
        closeListener(Status.OK);
      } else {
        this.deframerClosedTask = new Runnable() {
            public void run() {
              AbstractServerStream.TransportState.this.closeListener(Status.OK);
            }
          };
        this.immediateCloseRequested = true;
        closeDeframer(true);
      } 
    }
    
    public void deframerClosed(boolean param1Boolean) {
      this.deframerClosed = true;
      if (this.endOfStream) {
        if (!this.immediateCloseRequested && param1Boolean) {
          deframeFailed((Throwable)Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame").asRuntimeException());
          this.deframerClosedTask = null;
          return;
        } 
        this.listener.halfClosed();
      } 
      Runnable runnable = this.deframerClosedTask;
      if (runnable != null) {
        runnable.run();
        this.deframerClosedTask = null;
      } 
    }
    
    public void inboundDataReceived(ReadableBuffer param1ReadableBuffer, boolean param1Boolean) {
      Preconditions.checkState(this.endOfStream ^ true, "Past end of stream");
      deframe(param1ReadableBuffer);
      if (param1Boolean) {
        this.endOfStream = true;
        closeDeframer(false);
      } 
    }
    
    protected ServerStreamListener listener() {
      return this.listener;
    }
    
    public final void onStreamAllocated() {
      super.onStreamAllocated();
      getTransportTracer().reportRemoteStreamStarted();
    }
    
    public final void setListener(ServerStreamListener param1ServerStreamListener) {
      boolean bool;
      if (this.listener == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "setListener should be called only once");
      this.listener = (ServerStreamListener)Preconditions.checkNotNull(param1ServerStreamListener, "listener");
    }
    
    public final void transportReportStatus(final Status status) {
      Preconditions.checkArgument(status.isOk() ^ true, "status must not be OK");
      if (this.deframerClosed) {
        this.deframerClosedTask = null;
        closeListener(status);
      } else {
        this.deframerClosedTask = new Runnable() {
            public void run() {
              AbstractServerStream.TransportState.this.closeListener(status);
            }
          };
        this.immediateCloseRequested = true;
        closeDeframer(true);
      } 
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.closeListener(status);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.closeListener(Status.OK);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AbstractServerStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */