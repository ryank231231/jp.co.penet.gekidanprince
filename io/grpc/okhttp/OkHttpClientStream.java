package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Http2ClientStreamTransportState;
import io.grpc.internal.ReadableBuffer;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
import okio.Buffer;

class OkHttpClientStream extends AbstractClientStream {
  public static final int ABSENT_ID = -1;
  
  private static final Buffer EMPTY_BUFFER = new Buffer();
  
  private static final int WINDOW_UPDATE_THRESHOLD = 32767;
  
  private final Attributes attributes;
  
  private String authority;
  
  private volatile int id = -1;
  
  private final MethodDescriptor<?, ?> method;
  
  private Object outboundFlowState;
  
  private final Sink sink = new Sink();
  
  private final TransportState state;
  
  private final StatsTraceContext statsTraceCtx;
  
  private boolean useGet = false;
  
  private final String userAgent;
  
  OkHttpClientStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, AsyncFrameWriter paramAsyncFrameWriter, OkHttpClientTransport paramOkHttpClientTransport, OutboundFlowController paramOutboundFlowController, Object paramObject, int paramInt, String paramString1, String paramString2, StatsTraceContext paramStatsTraceContext, TransportTracer paramTransportTracer) {
    super(new OkHttpWritableBufferAllocator(), paramStatsTraceContext, paramTransportTracer, paramMetadata, paramMethodDescriptor.isSafe());
    this.statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx");
    this.method = paramMethodDescriptor;
    this.authority = paramString1;
    this.userAgent = paramString2;
    this.attributes = paramOkHttpClientTransport.getAttributes();
    this.state = new TransportState(paramInt, paramStatsTraceContext, paramObject, paramAsyncFrameWriter, paramOutboundFlowController, paramOkHttpClientTransport);
  }
  
  protected Sink abstractClientStreamSink() {
    return this.sink;
  }
  
  public Attributes getAttributes() {
    return this.attributes;
  }
  
  Object getOutboundFlowState() {
    return this.outboundFlowState;
  }
  
  public MethodDescriptor.MethodType getType() {
    return this.method.getType();
  }
  
  public int id() {
    return this.id;
  }
  
  public void setAuthority(String paramString) {
    this.authority = (String)Preconditions.checkNotNull(paramString, "authority");
  }
  
  void setOutboundFlowState(Object paramObject) {
    this.outboundFlowState = paramObject;
  }
  
  protected TransportState transportState() {
    return this.state;
  }
  
  boolean useGet() {
    return this.useGet;
  }
  
  private static class PendingData {
    Buffer buffer;
    
    boolean endOfStream;
    
    boolean flush;
    
    PendingData(Buffer param1Buffer, boolean param1Boolean1, boolean param1Boolean2) {
      this.buffer = param1Buffer;
      this.endOfStream = param1Boolean1;
      this.flush = param1Boolean2;
    }
  }
  
  class Sink implements AbstractClientStream.Sink {
    public void cancel(Status param1Status) {
      synchronized (OkHttpClientStream.this.state.lock) {
        OkHttpClientStream.this.state.cancel(param1Status, true, (Metadata)null);
        return;
      } 
    }
    
    public void request(int param1Int) {
      synchronized (OkHttpClientStream.this.state.lock) {
        OkHttpClientStream.this.state.requestMessagesFromDeframer(param1Int);
        return;
      } 
    }
    
    public void writeFrame(WritableBuffer param1WritableBuffer, boolean param1Boolean1, boolean param1Boolean2, int param1Int) {
      if (param1WritableBuffer == null) {
        null = OkHttpClientStream.EMPTY_BUFFER;
      } else {
        Buffer buffer = ((OkHttpWritableBuffer)null).buffer();
        int i = (int)buffer.size();
        null = buffer;
        if (i > 0) {
          OkHttpClientStream.this.onSendingBytes(i);
          null = buffer;
        } 
      } 
      synchronized (OkHttpClientStream.this.state.lock) {
        OkHttpClientStream.this.state.sendBuffer(null, param1Boolean1, param1Boolean2);
        OkHttpClientStream.this.getTransportTracer().reportMessageSent(param1Int);
        return;
      } 
    }
    
    public void writeHeaders(Metadata param1Metadata, byte[] param1ArrayOfbyte) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/");
      stringBuilder.append(OkHttpClientStream.this.method.getFullMethodName());
      String str2 = stringBuilder.toString();
      String str1 = str2;
      if (param1ArrayOfbyte != null) {
        OkHttpClientStream.access$102(OkHttpClientStream.this, true);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append("?");
        stringBuilder1.append(BaseEncoding.base64().encode(param1ArrayOfbyte));
        str1 = stringBuilder1.toString();
      } 
      synchronized (OkHttpClientStream.this.state.lock) {
        OkHttpClientStream.this.state.streamReady(param1Metadata, str1);
        return;
      } 
    }
  }
  
  class TransportState extends Http2ClientStreamTransportState {
    @GuardedBy("lock")
    private boolean cancelSent = false;
    
    @GuardedBy("lock")
    private final AsyncFrameWriter frameWriter;
    
    private final Object lock;
    
    @GuardedBy("lock")
    private final OutboundFlowController outboundFlow;
    
    @GuardedBy("lock")
    private Queue<OkHttpClientStream.PendingData> pendingData = new ArrayDeque<OkHttpClientStream.PendingData>();
    
    @GuardedBy("lock")
    private int processedWindow = 65535;
    
    @GuardedBy("lock")
    private List<Header> requestHeaders;
    
    @GuardedBy("lock")
    private final OkHttpClientTransport transport;
    
    @GuardedBy("lock")
    private int window = 65535;
    
    public TransportState(int param1Int, StatsTraceContext param1StatsTraceContext, Object param1Object, AsyncFrameWriter param1AsyncFrameWriter, OutboundFlowController param1OutboundFlowController, OkHttpClientTransport param1OkHttpClientTransport) {
      super(param1Int, param1StatsTraceContext, OkHttpClientStream.this.getTransportTracer());
      this.lock = Preconditions.checkNotNull(param1Object, "lock");
      this.frameWriter = param1AsyncFrameWriter;
      this.outboundFlow = param1OutboundFlowController;
      this.transport = param1OkHttpClientTransport;
    }
    
    @GuardedBy("lock")
    private void cancel(Status param1Status, boolean param1Boolean, Metadata param1Metadata) {
      if (this.cancelSent)
        return; 
      this.cancelSent = true;
      if (this.pendingData != null) {
        this.transport.removePendingStream(OkHttpClientStream.this);
        this.requestHeaders = null;
        Iterator<OkHttpClientStream.PendingData> iterator = this.pendingData.iterator();
        while (iterator.hasNext())
          ((OkHttpClientStream.PendingData)iterator.next()).buffer.clear(); 
        this.pendingData = null;
        if (param1Metadata == null)
          param1Metadata = new Metadata(); 
        transportReportStatus(param1Status, true, param1Metadata);
      } else {
        this.transport.finishStream(OkHttpClientStream.this.id(), param1Status, ClientStreamListener.RpcProgress.PROCESSED, param1Boolean, ErrorCode.CANCEL, param1Metadata);
      } 
    }
    
    @GuardedBy("lock")
    private void onEndOfStream() {
      if (!isOutboundClosed()) {
        this.transport.finishStream(OkHttpClientStream.this.id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.CANCEL, null);
      } else {
        this.transport.finishStream(OkHttpClientStream.this.id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
      } 
    }
    
    @GuardedBy("lock")
    private void sendBuffer(Buffer param1Buffer, boolean param1Boolean1, boolean param1Boolean2) {
      if (this.cancelSent)
        return; 
      Queue<OkHttpClientStream.PendingData> queue = this.pendingData;
      if (queue != null) {
        queue.add(new OkHttpClientStream.PendingData(param1Buffer, param1Boolean1, param1Boolean2));
      } else {
        boolean bool;
        if (OkHttpClientStream.this.id() != -1) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool, "streamId should be set");
        this.outboundFlow.data(param1Boolean1, OkHttpClientStream.this.id(), param1Buffer, param1Boolean2);
      } 
    }
    
    @GuardedBy("lock")
    private void streamReady(Metadata param1Metadata, String param1String) {
      this.requestHeaders = Headers.createRequestHeaders(param1Metadata, param1String, OkHttpClientStream.this.authority, OkHttpClientStream.this.userAgent, OkHttpClientStream.this.useGet);
      this.transport.streamReadyToStart(OkHttpClientStream.this);
    }
    
    @GuardedBy("lock")
    public void bytesRead(int param1Int) {
      this.processedWindow -= param1Int;
      param1Int = this.processedWindow;
      if (param1Int <= 32767) {
        int i = 65535 - param1Int;
        this.window += i;
        this.processedWindow = param1Int + i;
        this.frameWriter.windowUpdate(OkHttpClientStream.this.id(), i);
      } 
    }
    
    @GuardedBy("lock")
    public void deframeFailed(Throwable param1Throwable) {
      http2ProcessingFailed(Status.fromThrowable(param1Throwable), true, new Metadata());
    }
    
    @GuardedBy("lock")
    public void deframerClosed(boolean param1Boolean) {
      onEndOfStream();
      super.deframerClosed(param1Boolean);
    }
    
    @GuardedBy("lock")
    protected void http2ProcessingFailed(Status param1Status, boolean param1Boolean, Metadata param1Metadata) {
      cancel(param1Status, param1Boolean, param1Metadata);
    }
    
    @GuardedBy("lock")
    protected void onStreamAllocated() {
      super.onStreamAllocated();
      getTransportTracer().reportLocalStreamStarted();
    }
    
    @GuardedBy("lock")
    public void runOnTransportThread(Runnable param1Runnable) {
      synchronized (this.lock) {
        param1Runnable.run();
        return;
      } 
    }
    
    @GuardedBy("lock")
    public void start(int param1Int) {
      boolean bool;
      if (OkHttpClientStream.this.id == -1) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "the stream has been started with id %s", param1Int);
      OkHttpClientStream.access$1102(OkHttpClientStream.this, param1Int);
      OkHttpClientStream.this.state.onStreamAllocated();
      if (this.pendingData != null) {
        this.frameWriter.synStream(OkHttpClientStream.this.useGet, false, OkHttpClientStream.this.id, 0, this.requestHeaders);
        OkHttpClientStream.this.statsTraceCtx.clientOutboundHeaders();
        this.requestHeaders = null;
        param1Int = 0;
        while (!this.pendingData.isEmpty()) {
          OkHttpClientStream.PendingData pendingData = this.pendingData.poll();
          this.outboundFlow.data(pendingData.endOfStream, OkHttpClientStream.this.id, pendingData.buffer, false);
          if (pendingData.flush)
            param1Int = 1; 
        } 
        if (param1Int != 0)
          this.outboundFlow.flush(); 
        this.pendingData = null;
      } 
    }
    
    @GuardedBy("lock")
    public void transportDataReceived(Buffer param1Buffer, boolean param1Boolean) {
      int i = (int)param1Buffer.size();
      this.window -= i;
      if (this.window < 0) {
        this.frameWriter.rstStream(OkHttpClientStream.this.id(), ErrorCode.FLOW_CONTROL_ERROR);
        this.transport.finishStream(OkHttpClientStream.this.id(), Status.INTERNAL.withDescription("Received data size exceeded our receiving window size"), ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
        return;
      } 
      transportDataReceived((ReadableBuffer)new OkHttpReadableBuffer(param1Buffer), param1Boolean);
    }
    
    @GuardedBy("lock")
    public void transportHeadersReceived(List<Header> param1List, boolean param1Boolean) {
      if (param1Boolean) {
        transportTrailersReceived(Utils.convertTrailers(param1List));
      } else {
        transportHeadersReceived(Utils.convertHeaders(param1List));
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */