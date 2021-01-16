package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public abstract class AbstractClientStream extends AbstractStream implements ClientStream, MessageFramer.Sink {
  private static final Logger log = Logger.getLogger(AbstractClientStream.class.getName());
  
  private volatile boolean cancelled;
  
  private final Framer framer;
  
  private Metadata headers;
  
  private final TransportTracer transportTracer;
  
  private boolean useGet;
  
  protected AbstractClientStream(WritableBufferAllocator paramWritableBufferAllocator, StatsTraceContext paramStatsTraceContext, TransportTracer paramTransportTracer, Metadata paramMetadata, boolean paramBoolean) {
    Preconditions.checkNotNull(paramMetadata, "headers");
    this.transportTracer = (TransportTracer)Preconditions.checkNotNull(paramTransportTracer, "transportTracer");
    this.useGet = paramBoolean;
    if (!paramBoolean) {
      this.framer = new MessageFramer(this, paramWritableBufferAllocator, paramStatsTraceContext);
      this.headers = paramMetadata;
    } else {
      this.framer = new GetFramer(paramMetadata, paramStatsTraceContext);
    } 
  }
  
  protected abstract Sink abstractClientStreamSink();
  
  public final void cancel(Status paramStatus) {
    Preconditions.checkArgument(paramStatus.isOk() ^ true, "Should not cancel with OK status");
    this.cancelled = true;
    abstractClientStreamSink().cancel(paramStatus);
  }
  
  public final void deliverFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
    boolean bool;
    if (paramWritableBuffer != null || paramBoolean1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "null frame before EOS");
    abstractClientStreamSink().writeFrame(paramWritableBuffer, paramBoolean1, paramBoolean2, paramInt);
  }
  
  protected final Framer framer() {
    return this.framer;
  }
  
  protected TransportTracer getTransportTracer() {
    return this.transportTracer;
  }
  
  public final void halfClose() {
    if (!transportState().isOutboundClosed()) {
      transportState().setOutboundClosed();
      endOfMessages();
    } 
  }
  
  public final boolean isReady() {
    boolean bool;
    if (super.isReady() && !this.cancelled) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final void request(int paramInt) {
    abstractClientStreamSink().request(paramInt);
  }
  
  public final void setDecompressorRegistry(DecompressorRegistry paramDecompressorRegistry) {
    transportState().setDecompressorRegistry(paramDecompressorRegistry);
  }
  
  public final void setFullStreamDecompression(boolean paramBoolean) {
    transportState().setFullStreamDecompression(paramBoolean);
  }
  
  public void setMaxInboundMessageSize(int paramInt) {
    transportState().setMaxInboundMessageSize(paramInt);
  }
  
  public void setMaxOutboundMessageSize(int paramInt) {
    this.framer.setMaxOutboundMessageSize(paramInt);
  }
  
  public final void start(ClientStreamListener paramClientStreamListener) {
    transportState().setListener(paramClientStreamListener);
    if (!this.useGet) {
      abstractClientStreamSink().writeHeaders(this.headers, null);
      this.headers = null;
    } 
  }
  
  protected abstract TransportState transportState();
  
  private class GetFramer implements Framer {
    private boolean closed;
    
    private Metadata headers;
    
    private byte[] payload;
    
    private final StatsTraceContext statsTraceCtx;
    
    public GetFramer(Metadata param1Metadata, StatsTraceContext param1StatsTraceContext) {
      this.headers = (Metadata)Preconditions.checkNotNull(param1Metadata, "headers");
      this.statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(param1StatsTraceContext, "statsTraceCtx");
    }
    
    public void close() {
      boolean bool = true;
      this.closed = true;
      if (this.payload == null)
        bool = false; 
      Preconditions.checkState(bool, "Lack of request message. GET request is only supported for unary requests");
      AbstractClientStream.this.abstractClientStreamSink().writeHeaders(this.headers, this.payload);
      this.payload = null;
      this.headers = null;
    }
    
    public void dispose() {
      this.closed = true;
      this.payload = null;
      this.headers = null;
    }
    
    public void flush() {}
    
    public boolean isClosed() {
      return this.closed;
    }
    
    public Framer setCompressor(Compressor param1Compressor) {
      return this;
    }
    
    public void setMaxOutboundMessageSize(int param1Int) {}
    
    public Framer setMessageCompression(boolean param1Boolean) {
      return this;
    }
    
    public void writePayload(InputStream param1InputStream) {
      boolean bool;
      if (this.payload == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "writePayload should not be called multiple times");
      try {
        this.payload = IoUtils.toByteArray(param1InputStream);
        this.statsTraceCtx.outboundMessage(0);
        StatsTraceContext statsTraceContext = this.statsTraceCtx;
        byte[] arrayOfByte = this.payload;
        statsTraceContext.outboundMessageSent(0, arrayOfByte.length, arrayOfByte.length);
        this.statsTraceCtx.outboundUncompressedSize(this.payload.length);
        this.statsTraceCtx.outboundWireSize(this.payload.length);
        return;
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    }
  }
  
  protected static interface Sink {
    void cancel(Status param1Status);
    
    void request(int param1Int);
    
    void writeFrame(@Nullable WritableBuffer param1WritableBuffer, boolean param1Boolean1, boolean param1Boolean2, int param1Int);
    
    void writeHeaders(Metadata param1Metadata, @Nullable byte[] param1ArrayOfbyte);
  }
  
  protected static abstract class TransportState extends AbstractStream.TransportState {
    private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    
    private boolean deframerClosed = false;
    
    private Runnable deframerClosedTask;
    
    private boolean fullStreamDecompression;
    
    private ClientStreamListener listener;
    
    private boolean listenerClosed;
    
    private volatile boolean outboundClosed;
    
    private final StatsTraceContext statsTraceCtx;
    
    private boolean statusReported;
    
    protected TransportState(int param1Int, StatsTraceContext param1StatsTraceContext, TransportTracer param1TransportTracer) {
      super(param1Int, param1StatsTraceContext, param1TransportTracer);
      this.statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(param1StatsTraceContext, "statsTraceCtx");
    }
    
    private void closeListener(Status param1Status, ClientStreamListener.RpcProgress param1RpcProgress, Metadata param1Metadata) {
      if (!this.listenerClosed) {
        this.listenerClosed = true;
        this.statsTraceCtx.streamClosed(param1Status);
        listener().closed(param1Status, param1RpcProgress, param1Metadata);
        if (getTransportTracer() != null)
          getTransportTracer().reportStreamClosed(param1Status.isOk()); 
      } 
    }
    
    private void setDecompressorRegistry(DecompressorRegistry param1DecompressorRegistry) {
      boolean bool;
      if (this.listener == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Already called start");
      this.decompressorRegistry = (DecompressorRegistry)Preconditions.checkNotNull(param1DecompressorRegistry, "decompressorRegistry");
    }
    
    private void setFullStreamDecompression(boolean param1Boolean) {
      this.fullStreamDecompression = param1Boolean;
    }
    
    private final void setOutboundClosed() {
      this.outboundClosed = true;
    }
    
    public void deframerClosed(boolean param1Boolean) {
      this.deframerClosed = true;
      Runnable runnable = this.deframerClosedTask;
      if (runnable != null) {
        runnable.run();
        this.deframerClosedTask = null;
      } 
    }
    
    protected void inboundDataReceived(ReadableBuffer param1ReadableBuffer) {
      Preconditions.checkNotNull(param1ReadableBuffer, "frame");
      boolean bool1 = true;
      boolean bool2 = bool1;
      try {
        if (this.statusReported) {
          bool2 = bool1;
          AbstractClientStream.log.log(Level.INFO, "Received data on closed stream");
          return;
        } 
        bool2 = false;
        return;
      } finally {
        if (bool2)
          param1ReadableBuffer.close(); 
      } 
    }
    
    protected void inboundHeadersReceived(Metadata param1Metadata) {
      Preconditions.checkState(this.statusReported ^ true, "Received headers on closed stream");
      this.statsTraceCtx.clientInboundHeaders();
      String str = (String)param1Metadata.get(GrpcUtil.CONTENT_ENCODING_KEY);
      if (this.fullStreamDecompression && str != null) {
        boolean bool1;
        if (str.equalsIgnoreCase("gzip")) {
          setFullStreamDecompressor(new GzipInflatingBuffer());
          bool1 = true;
        } else {
          if (!str.equalsIgnoreCase("identity")) {
            deframeFailed((Throwable)Status.INTERNAL.withDescription(String.format("Can't find full stream decompressor for %s", new Object[] { str })).asRuntimeException());
            return;
          } 
          bool1 = false;
        } 
        str = (String)param1Metadata.get(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (str != null) {
          Decompressor decompressor = this.decompressorRegistry.lookupDecompressor(str);
          if (decompressor == null) {
            deframeFailed((Throwable)Status.INTERNAL.withDescription(String.format("Can't find decompressor for %s", new Object[] { str })).asRuntimeException());
            return;
          } 
          if (decompressor != Codec.Identity.NONE) {
            if (bool1) {
              deframeFailed((Throwable)Status.INTERNAL.withDescription(String.format("Full stream and gRPC message encoding cannot both be set", new Object[0])).asRuntimeException());
              return;
            } 
            setDecompressor(decompressor);
          } 
        } 
        listener().headersRead(param1Metadata);
        return;
      } 
      boolean bool = false;
    }
    
    protected void inboundTrailersReceived(Metadata param1Metadata, Status param1Status) {
      Preconditions.checkNotNull(param1Status, "status");
      Preconditions.checkNotNull(param1Metadata, "trailers");
      if (this.statusReported) {
        AbstractClientStream.log.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[] { param1Status, param1Metadata });
        return;
      } 
      transportReportStatus(param1Status, false, param1Metadata);
    }
    
    protected final boolean isOutboundClosed() {
      return this.outboundClosed;
    }
    
    protected final ClientStreamListener listener() {
      return this.listener;
    }
    
    @VisibleForTesting
    public final void setListener(ClientStreamListener param1ClientStreamListener) {
      boolean bool;
      if (this.listener == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Already called setListener");
      this.listener = (ClientStreamListener)Preconditions.checkNotNull(param1ClientStreamListener, "listener");
    }
    
    public final void transportReportStatus(final Status status, final ClientStreamListener.RpcProgress rpcProgress, boolean param1Boolean, final Metadata trailers) {
      Preconditions.checkNotNull(status, "status");
      Preconditions.checkNotNull(trailers, "trailers");
      if (this.statusReported && !param1Boolean)
        return; 
      this.statusReported = true;
      onStreamDeallocated();
      if (this.deframerClosed) {
        this.deframerClosedTask = null;
        closeListener(status, rpcProgress, trailers);
      } else {
        this.deframerClosedTask = new Runnable() {
            public void run() {
              AbstractClientStream.TransportState.this.closeListener(status, rpcProgress, trailers);
            }
          };
        closeDeframer(param1Boolean);
      } 
    }
    
    public final void transportReportStatus(Status param1Status, boolean param1Boolean, Metadata param1Metadata) {
      transportReportStatus(param1Status, ClientStreamListener.RpcProgress.PROCESSED, param1Boolean, param1Metadata);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.closeListener(status, rpcProgress, trailers);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AbstractClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */