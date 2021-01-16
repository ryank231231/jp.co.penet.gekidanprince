package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Context;
import io.grpc.Internal;
import io.grpc.InternalClientInterceptors;
import io.grpc.InternalServerInterceptors;
import io.grpc.InternalServiceProviders;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerStreamTracer;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracing;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public abstract class BinaryLogProvider implements Closeable {
  @VisibleForTesting
  public static final MethodDescriptor.Marshaller<byte[]> BYTEARRAY_MARSHALLER;
  
  private static final ClientInterceptor CLIENT_CALLID_SETTER;
  
  @Internal
  public static final CallOptions.Key<CallId> CLIENT_CALL_ID_CALLOPTION_KEY;
  
  private static final BinaryLogProvider PROVIDER;
  
  private static final ServerStreamTracer SERVER_CALLID_SETTER;
  
  private static final ServerStreamTracer.Factory SERVER_CALLID_SETTER_FACTORY;
  
  @Internal
  public static final Context.Key<CallId> SERVER_CALL_ID_CONTEXT_KEY = Context.key("binarylog-context-key");
  
  private static final Logger logger;
  
  private final ClientInterceptor binaryLogShim = new BinaryLogShim();
  
  static {
    CLIENT_CALL_ID_CALLOPTION_KEY = CallOptions.Key.of("binarylog-calloptions-key", null);
    BYTEARRAY_MARSHALLER = new ByteArrayMarshaller();
    logger = Logger.getLogger(BinaryLogProvider.class.getName());
    PROVIDER = (BinaryLogProvider)InternalServiceProviders.load(BinaryLogProvider.class, Collections.emptyList(), BinaryLogProvider.class.getClassLoader(), new InternalServiceProviders.PriorityAccessor<BinaryLogProvider>() {
          public int getPriority(BinaryLogProvider param1BinaryLogProvider) {
            return param1BinaryLogProvider.priority();
          }
          
          public boolean isAvailable(BinaryLogProvider param1BinaryLogProvider) {
            return param1BinaryLogProvider.isAvailable();
          }
        });
    SERVER_CALLID_SETTER = new ServerStreamTracer() {
        public Context filterContext(Context param1Context) {
          Context context = param1Context.attach();
          try {
            Span span = Tracing.getTracer().getCurrentSpan();
            if (span == null)
              return param1Context; 
            return param1Context.withValue(BinaryLogProvider.SERVER_CALL_ID_CONTEXT_KEY, BinaryLogProvider.CallId.fromCensusSpan(span));
          } finally {
            param1Context.detach(context);
          } 
        }
      };
    SERVER_CALLID_SETTER_FACTORY = new ServerStreamTracer.Factory() {
        public ServerStreamTracer newServerStreamTracer(String param1String, Metadata param1Metadata) {
          return BinaryLogProvider.SERVER_CALLID_SETTER;
        }
      };
    CLIENT_CALLID_SETTER = new ClientInterceptor() {
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, CallOptions param1CallOptions, Channel param1Channel) {
          Span span = Tracing.getTracer().getCurrentSpan();
          return (span == null) ? param1Channel.newCall(param1MethodDescriptor, param1CallOptions) : param1Channel.newCall(param1MethodDescriptor, param1CallOptions.withOption(BinaryLogProvider.CLIENT_CALL_ID_CALLOPTION_KEY, BinaryLogProvider.CallId.fromCensusSpan(span)));
        }
      };
  }
  
  @Nullable
  public static BinaryLogProvider provider() {
    return PROVIDER;
  }
  
  private static MethodDescriptor<byte[], byte[]> toByteBufferMethod(MethodDescriptor<?, ?> paramMethodDescriptor) {
    MethodDescriptor.Marshaller<byte[]> marshaller = BYTEARRAY_MARSHALLER;
    return paramMethodDescriptor.toBuilder(marshaller, marshaller).build();
  }
  
  public void close() throws IOException {}
  
  public ClientInterceptor getClientCallIdSetter() {
    return CLIENT_CALLID_SETTER;
  }
  
  @Nullable
  protected abstract ClientInterceptor getClientInterceptor(String paramString);
  
  public ServerStreamTracer.Factory getServerCallIdSetter() {
    return SERVER_CALLID_SETTER_FACTORY;
  }
  
  @Nullable
  protected abstract ServerInterceptor getServerInterceptor(String paramString);
  
  protected abstract boolean isAvailable();
  
  protected abstract int priority();
  
  public final Channel wrapChannel(Channel paramChannel) {
    return ClientInterceptors.intercept(paramChannel, new ClientInterceptor[] { this.binaryLogShim });
  }
  
  public final <ReqT, RespT> ServerMethodDefinition<?, ?> wrapMethodDefinition(ServerMethodDefinition<ReqT, RespT> paramServerMethodDefinition) {
    ServerInterceptor serverInterceptor = getServerInterceptor(paramServerMethodDefinition.getMethodDescriptor().getFullMethodName());
    if (serverInterceptor == null)
      return paramServerMethodDefinition; 
    MethodDescriptor<byte[], byte[]> methodDescriptor = toByteBufferMethod(paramServerMethodDefinition.getMethodDescriptor());
    return ServerMethodDefinition.create(methodDescriptor, InternalServerInterceptors.interceptCallHandler(serverInterceptor, InternalServerInterceptors.wrapMethod(paramServerMethodDefinition, methodDescriptor).getServerCallHandler()));
  }
  
  private final class BinaryLogShim implements ClientInterceptor {
    private BinaryLogShim() {}
    
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, CallOptions param1CallOptions, Channel param1Channel) {
      ClientInterceptor clientInterceptor = BinaryLogProvider.this.getClientInterceptor(param1MethodDescriptor.getFullMethodName());
      return (clientInterceptor == null) ? param1Channel.newCall(param1MethodDescriptor, param1CallOptions) : InternalClientInterceptors.wrapClientInterceptor(clientInterceptor, BinaryLogProvider.BYTEARRAY_MARSHALLER, BinaryLogProvider.BYTEARRAY_MARSHALLER).interceptCall(param1MethodDescriptor, param1CallOptions, param1Channel);
    }
  }
  
  private static final class ByteArrayMarshaller implements MethodDescriptor.Marshaller<byte[]> {
    private ByteArrayMarshaller() {}
    
    private byte[] parseHelper(InputStream param1InputStream) throws IOException {
      try {
        return IoUtils.toByteArray(param1InputStream);
      } finally {
        param1InputStream.close();
      } 
    }
    
    public byte[] parse(InputStream param1InputStream) {
      try {
        return parseHelper(param1InputStream);
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    }
    
    public InputStream stream(byte[] param1ArrayOfbyte) {
      return new ByteArrayInputStream(param1ArrayOfbyte);
    }
  }
  
  public static final class CallId {
    public final long hi;
    
    public final long lo;
    
    public CallId(long param1Long1, long param1Long2) {
      this.hi = param1Long1;
      this.lo = param1Long2;
    }
    
    static CallId fromCensusSpan(Span param1Span) {
      return new CallId(0L, ByteBuffer.wrap(param1Span.getContext().getSpanId().getBytes()).getLong());
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\BinaryLogProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */