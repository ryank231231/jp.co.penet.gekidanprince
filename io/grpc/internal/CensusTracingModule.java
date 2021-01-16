package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.NetworkEvent;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.Status;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.propagation.BinaryFormat;
import io.opencensus.trace.unsafe.ContextUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class CensusTracingModule {
  @Nullable
  private static final AtomicIntegerFieldUpdater<ClientCallTracer> callEndedUpdater;
  
  private static final Logger logger = Logger.getLogger(CensusTracingModule.class.getName());
  
  @Nullable
  private static final AtomicIntegerFieldUpdater<ServerTracer> streamClosedUpdater;
  
  private final Tracer censusTracer;
  
  private final TracingClientInterceptor clientInterceptor = new TracingClientInterceptor();
  
  private final ServerTracerFactory serverTracerFactory = new ServerTracerFactory();
  
  @VisibleForTesting
  final Metadata.Key<SpanContext> tracingHeader;
  
  static {
    AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater = null;
    try {
      AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater1 = AtomicIntegerFieldUpdater.newUpdater(ClientCallTracer.class, "callEnded");
      AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater2 = AtomicIntegerFieldUpdater.newUpdater(ServerTracer.class, "streamClosed");
      atomicIntegerFieldUpdater = atomicIntegerFieldUpdater1;
    } catch (Throwable throwable) {
      logger.log(Level.SEVERE, "Creating atomic field updaters failed", throwable);
      throwable = null;
    } 
    callEndedUpdater = atomicIntegerFieldUpdater;
    streamClosedUpdater = (AtomicIntegerFieldUpdater<ServerTracer>)throwable;
  }
  
  CensusTracingModule(Tracer paramTracer, final BinaryFormat censusPropagationBinaryFormat) {
    this.censusTracer = (Tracer)Preconditions.checkNotNull(paramTracer, "censusTracer");
    Preconditions.checkNotNull(censusPropagationBinaryFormat, "censusPropagationBinaryFormat");
    this.tracingHeader = Metadata.Key.of("grpc-trace-bin", new Metadata.BinaryMarshaller<SpanContext>() {
          public SpanContext parseBytes(byte[] param1ArrayOfbyte) {
            try {
              return censusPropagationBinaryFormat.fromByteArray(param1ArrayOfbyte);
            } catch (Exception exception) {
              CensusTracingModule.logger.log(Level.FINE, "Failed to parse tracing header", exception);
              return SpanContext.INVALID;
            } 
          }
          
          public byte[] toBytes(SpanContext param1SpanContext) {
            return censusPropagationBinaryFormat.toByteArray(param1SpanContext);
          }
        });
  }
  
  @VisibleForTesting
  static Status convertStatus(Status paramStatus) {
    StringBuilder stringBuilder;
    Status status1;
    switch (paramStatus.getCode()) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unhandled status code ");
        stringBuilder.append(paramStatus.getCode());
        throw new AssertionError(stringBuilder.toString());
      case UNAUTHENTICATED:
        status1 = Status.UNAUTHENTICATED;
        break;
      case DATA_LOSS:
        status1 = Status.DATA_LOSS;
        break;
      case UNAVAILABLE:
        status1 = Status.UNAVAILABLE;
        break;
      case INTERNAL:
        status1 = Status.INTERNAL;
        break;
      case UNIMPLEMENTED:
        status1 = Status.UNIMPLEMENTED;
        break;
      case OUT_OF_RANGE:
        status1 = Status.OUT_OF_RANGE;
        break;
      case ABORTED:
        status1 = Status.ABORTED;
        break;
      case FAILED_PRECONDITION:
        status1 = Status.FAILED_PRECONDITION;
        break;
      case RESOURCE_EXHAUSTED:
        status1 = Status.RESOURCE_EXHAUSTED;
        break;
      case PERMISSION_DENIED:
        status1 = Status.PERMISSION_DENIED;
        break;
      case ALREADY_EXISTS:
        status1 = Status.ALREADY_EXISTS;
        break;
      case NOT_FOUND:
        status1 = Status.NOT_FOUND;
        break;
      case DEADLINE_EXCEEDED:
        status1 = Status.DEADLINE_EXCEEDED;
        break;
      case INVALID_ARGUMENT:
        status1 = Status.INVALID_ARGUMENT;
        break;
      case UNKNOWN:
        status1 = Status.UNKNOWN;
        break;
      case CANCELLED:
        status1 = Status.CANCELLED;
        break;
      case OK:
        status1 = Status.OK;
        break;
    } 
    Status status2 = status1;
    if (paramStatus.getDescription() != null)
      status2 = status1.withDescription(paramStatus.getDescription()); 
    return status2;
  }
  
  private static EndSpanOptions createEndSpanOptions(Status paramStatus, boolean paramBoolean) {
    return EndSpanOptions.builder().setStatus(convertStatus(paramStatus)).setSampleToLocalSpanStore(paramBoolean).build();
  }
  
  @VisibleForTesting
  static String generateTraceSpanName(boolean paramBoolean, String paramString) {
    String str;
    if (paramBoolean) {
      str = "Recv";
    } else {
      str = "Sent";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(".");
    stringBuilder.append(paramString.replace('/', '.'));
    return stringBuilder.toString();
  }
  
  private static void recordNetworkEvent(Span paramSpan, NetworkEvent.Type paramType, int paramInt, long paramLong1, long paramLong2) {
    NetworkEvent.Builder builder = NetworkEvent.builder(paramType, paramInt);
    if (paramLong2 != -1L)
      builder.setUncompressedMessageSize(paramLong2); 
    if (paramLong1 != -1L)
      builder.setCompressedMessageSize(paramLong1); 
    paramSpan.addNetworkEvent(builder.build());
  }
  
  ClientInterceptor getClientInterceptor() {
    return this.clientInterceptor;
  }
  
  ServerStreamTracer.Factory getServerTracerFactory() {
    return this.serverTracerFactory;
  }
  
  @VisibleForTesting
  ClientCallTracer newClientCallTracer(@Nullable Span paramSpan, MethodDescriptor<?, ?> paramMethodDescriptor) {
    return new ClientCallTracer(paramSpan, paramMethodDescriptor);
  }
  
  @VisibleForTesting
  final class ClientCallTracer extends ClientStreamTracer.Factory {
    volatile int callEnded;
    
    private final boolean isSampledToLocalTracing;
    
    private final Span span;
    
    ClientCallTracer(Span param1Span, MethodDescriptor<?, ?> param1MethodDescriptor) {
      Preconditions.checkNotNull(param1MethodDescriptor, "method");
      this.isSampledToLocalTracing = param1MethodDescriptor.isSampledToLocalTracing();
      this.span = CensusTracingModule.this.censusTracer.spanBuilderWithExplicitParent(CensusTracingModule.generateTraceSpanName(false, param1MethodDescriptor.getFullMethodName()), param1Span).setRecordEvents(true).startSpan();
    }
    
    void callEnded(Status param1Status) {
      if (CensusTracingModule.callEndedUpdater != null) {
        if (CensusTracingModule.callEndedUpdater.getAndSet(this, 1) != 0)
          return; 
      } else {
        if (this.callEnded != 0)
          return; 
        this.callEnded = 1;
      } 
      this.span.end(CensusTracingModule.createEndSpanOptions(param1Status, this.isSampledToLocalTracing));
    }
    
    public ClientStreamTracer newClientStreamTracer(CallOptions param1CallOptions, Metadata param1Metadata) {
      param1Metadata.discardAll(CensusTracingModule.this.tracingHeader);
      param1Metadata.put(CensusTracingModule.this.tracingHeader, this.span.getContext());
      return new CensusTracingModule.ClientTracer(this.span);
    }
  }
  
  private static final class ClientTracer extends ClientStreamTracer {
    private final Span span;
    
    ClientTracer(Span param1Span) {
      this.span = (Span)Preconditions.checkNotNull(param1Span, "span");
    }
    
    public void inboundMessageRead(int param1Int, long param1Long1, long param1Long2) {
      CensusTracingModule.recordNetworkEvent(this.span, NetworkEvent.Type.RECV, param1Int, param1Long1, param1Long2);
    }
    
    public void outboundMessageSent(int param1Int, long param1Long1, long param1Long2) {
      CensusTracingModule.recordNetworkEvent(this.span, NetworkEvent.Type.SENT, param1Int, param1Long1, param1Long2);
    }
  }
  
  private final class ServerTracer extends ServerStreamTracer {
    volatile boolean isSampledToLocalTracing;
    
    private final Span span;
    
    volatile int streamClosed;
    
    ServerTracer(@Nullable String param1String, SpanContext param1SpanContext) {
      Preconditions.checkNotNull(param1String, "fullMethodName");
      this.span = CensusTracingModule.this.censusTracer.spanBuilderWithRemoteParent(CensusTracingModule.generateTraceSpanName(true, param1String), param1SpanContext).setRecordEvents(true).startSpan();
    }
    
    public Context filterContext(Context param1Context) {
      return param1Context.withValue(ContextUtils.CONTEXT_SPAN_KEY, this.span);
    }
    
    public void inboundMessageRead(int param1Int, long param1Long1, long param1Long2) {
      CensusTracingModule.recordNetworkEvent(this.span, NetworkEvent.Type.RECV, param1Int, param1Long1, param1Long2);
    }
    
    public void outboundMessageSent(int param1Int, long param1Long1, long param1Long2) {
      CensusTracingModule.recordNetworkEvent(this.span, NetworkEvent.Type.SENT, param1Int, param1Long1, param1Long2);
    }
    
    public void serverCallStarted(ServerStreamTracer.ServerCallInfo<?, ?> param1ServerCallInfo) {
      this.isSampledToLocalTracing = param1ServerCallInfo.getMethodDescriptor().isSampledToLocalTracing();
    }
    
    public void streamClosed(Status param1Status) {
      if (CensusTracingModule.streamClosedUpdater != null) {
        if (CensusTracingModule.streamClosedUpdater.getAndSet(this, 1) != 0)
          return; 
      } else {
        if (this.streamClosed != 0)
          return; 
        this.streamClosed = 1;
      } 
      this.span.end(CensusTracingModule.createEndSpanOptions(param1Status, this.isSampledToLocalTracing));
    }
  }
  
  @VisibleForTesting
  final class ServerTracerFactory extends ServerStreamTracer.Factory {
    public ServerStreamTracer newServerStreamTracer(String param1String, Metadata param1Metadata) {
      SpanContext spanContext2 = (SpanContext)param1Metadata.get(CensusTracingModule.this.tracingHeader);
      SpanContext spanContext1 = spanContext2;
      if (spanContext2 == SpanContext.INVALID)
        spanContext1 = null; 
      return new CensusTracingModule.ServerTracer(param1String, spanContext1);
    }
  }
  
  @VisibleForTesting
  final class TracingClientInterceptor implements ClientInterceptor {
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, CallOptions param1CallOptions, Channel param1Channel) {
      final CensusTracingModule.ClientCallTracer tracerFactory = CensusTracingModule.this.newClientCallTracer((Span)ContextUtils.CONTEXT_SPAN_KEY.get(), param1MethodDescriptor);
      return (ClientCall<ReqT, RespT>)new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(param1Channel.newCall(param1MethodDescriptor, param1CallOptions.withStreamTracerFactory(clientCallTracer))) {
          public void start(ClientCall.Listener<RespT> param2Listener, Metadata param2Metadata) {
            delegate().start((ClientCall.Listener)new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(param2Listener) {
                  public void onClose(Status param3Status, Metadata param3Metadata) {
                    tracerFactory.callEnded(param3Status);
                    super.onClose(param3Status, param3Metadata);
                  }
                }param2Metadata);
          }
        };
    }
  }
  
  class null extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
    null(ClientCall param1ClientCall) {
      super(param1ClientCall);
    }
    
    public void start(ClientCall.Listener<RespT> param1Listener, Metadata param1Metadata) {
      delegate().start((ClientCall.Listener)new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(param1Listener) {
            public void onClose(Status param3Status, Metadata param3Metadata) {
              tracerFactory.callEnded(param3Status);
              super.onClose(param3Status, param3Metadata);
            }
          }param1Metadata);
    }
  }
  
  class null extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
    public void onClose(Status param1Status, Metadata param1Metadata) {
      tracerFactory.callEnded(param1Status);
      super.onClose(param1Status, param1Metadata);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\CensusTracingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */