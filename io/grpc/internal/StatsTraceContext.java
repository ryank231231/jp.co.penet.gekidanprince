package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.StreamTracer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class StatsTraceContext {
  public static final StatsTraceContext NOOP = new StatsTraceContext(new StreamTracer[0]);
  
  private final AtomicBoolean closed = new AtomicBoolean(false);
  
  private final StreamTracer[] tracers;
  
  @VisibleForTesting
  StatsTraceContext(StreamTracer[] paramArrayOfStreamTracer) {
    this.tracers = paramArrayOfStreamTracer;
  }
  
  public static StatsTraceContext newClientContext(CallOptions paramCallOptions, Metadata paramMetadata) {
    List<ClientStreamTracer.Factory> list = paramCallOptions.getStreamTracerFactories();
    if (list.isEmpty())
      return NOOP; 
    StreamTracer[] arrayOfStreamTracer = new StreamTracer[list.size()];
    for (byte b = 0; b < arrayOfStreamTracer.length; b++)
      arrayOfStreamTracer[b] = (StreamTracer)((ClientStreamTracer.Factory)list.get(b)).newClientStreamTracer(paramCallOptions, paramMetadata); 
    return new StatsTraceContext(arrayOfStreamTracer);
  }
  
  public static StatsTraceContext newServerContext(List<ServerStreamTracer.Factory> paramList, String paramString, Metadata paramMetadata) {
    if (paramList.isEmpty())
      return NOOP; 
    StreamTracer[] arrayOfStreamTracer = new StreamTracer[paramList.size()];
    for (byte b = 0; b < arrayOfStreamTracer.length; b++)
      arrayOfStreamTracer[b] = (StreamTracer)((ServerStreamTracer.Factory)paramList.get(b)).newServerStreamTracer(paramString, paramMetadata); 
    return new StatsTraceContext(arrayOfStreamTracer);
  }
  
  public void clientInboundHeaders() {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      ((ClientStreamTracer)arrayOfStreamTracer[b]).inboundHeaders(); 
  }
  
  public void clientOutboundHeaders() {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      ((ClientStreamTracer)arrayOfStreamTracer[b]).outboundHeaders(); 
  }
  
  @VisibleForTesting
  public List<StreamTracer> getTracersForTest() {
    return new ArrayList<StreamTracer>(Arrays.asList(this.tracers));
  }
  
  public void inboundMessage(int paramInt) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      arrayOfStreamTracer[b].inboundMessage(paramInt); 
  }
  
  public void inboundMessageRead(int paramInt, long paramLong1, long paramLong2) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      arrayOfStreamTracer[b].inboundMessageRead(paramInt, paramLong1, paramLong2); 
  }
  
  public void inboundUncompressedSize(long paramLong) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      arrayOfStreamTracer[b].inboundUncompressedSize(paramLong); 
  }
  
  public void inboundWireSize(long paramLong) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      arrayOfStreamTracer[b].inboundWireSize(paramLong); 
  }
  
  public void outboundMessage(int paramInt) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      arrayOfStreamTracer[b].outboundMessage(paramInt); 
  }
  
  public void outboundMessageSent(int paramInt, long paramLong1, long paramLong2) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      arrayOfStreamTracer[b].outboundMessageSent(paramInt, paramLong1, paramLong2); 
  }
  
  public void outboundUncompressedSize(long paramLong) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      arrayOfStreamTracer[b].outboundUncompressedSize(paramLong); 
  }
  
  public void outboundWireSize(long paramLong) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      arrayOfStreamTracer[b].outboundWireSize(paramLong); 
  }
  
  public void serverCallStarted(ServerStreamTracer.ServerCallInfo<?, ?> paramServerCallInfo) {
    StreamTracer[] arrayOfStreamTracer = this.tracers;
    int i = arrayOfStreamTracer.length;
    for (byte b = 0; b < i; b++)
      ((ServerStreamTracer)arrayOfStreamTracer[b]).serverCallStarted(paramServerCallInfo); 
  }
  
  public <ReqT, RespT> Context serverFilterContext(Context paramContext) {
    paramContext = (Context)Preconditions.checkNotNull(paramContext, "context");
    for (StreamTracer streamTracer : this.tracers) {
      paramContext = ((ServerStreamTracer)streamTracer).filterContext(paramContext);
      Preconditions.checkNotNull(paramContext, "%s returns null context", streamTracer);
    } 
    return paramContext;
  }
  
  public void streamClosed(Status paramStatus) {
    AtomicBoolean atomicBoolean = this.closed;
    byte b = 0;
    if (atomicBoolean.compareAndSet(false, true)) {
      StreamTracer[] arrayOfStreamTracer = this.tracers;
      int i = arrayOfStreamTracer.length;
      while (b < i) {
        arrayOfStreamTracer[b].streamClosed(paramStatus);
        b++;
      } 
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\StatsTraceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */