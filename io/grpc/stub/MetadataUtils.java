package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ExperimentalApi;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicReference;

public final class MetadataUtils {
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1789")
  public static <T extends AbstractStub<T>> T attachHeaders(T paramT, Metadata paramMetadata) {
    return paramT.withInterceptors(new ClientInterceptor[] { newAttachHeadersInterceptor(paramMetadata) });
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1789")
  public static <T extends AbstractStub<T>> T captureMetadata(T paramT, AtomicReference<Metadata> paramAtomicReference1, AtomicReference<Metadata> paramAtomicReference2) {
    return paramT.withInterceptors(new ClientInterceptor[] { newCaptureMetadataInterceptor(paramAtomicReference1, paramAtomicReference2) });
  }
  
  public static ClientInterceptor newAttachHeadersInterceptor(Metadata paramMetadata) {
    return new HeaderAttachingClientInterceptor(paramMetadata);
  }
  
  public static ClientInterceptor newCaptureMetadataInterceptor(AtomicReference<Metadata> paramAtomicReference1, AtomicReference<Metadata> paramAtomicReference2) {
    return new MetadataCapturingClientInterceptor(paramAtomicReference1, paramAtomicReference2);
  }
  
  private static final class HeaderAttachingClientInterceptor implements ClientInterceptor {
    private final Metadata extraHeaders;
    
    HeaderAttachingClientInterceptor(Metadata param1Metadata) {
      this.extraHeaders = (Metadata)Preconditions.checkNotNull(param1Metadata, param1Metadata);
    }
    
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, CallOptions param1CallOptions, Channel param1Channel) {
      return (ClientCall)new HeaderAttachingClientCall<Object, Object>(param1Channel.newCall(param1MethodDescriptor, param1CallOptions));
    }
    
    private final class HeaderAttachingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
      HeaderAttachingClientCall(ClientCall<ReqT, RespT> param2ClientCall) {
        super(param2ClientCall);
      }
      
      public void start(ClientCall.Listener<RespT> param2Listener, Metadata param2Metadata) {
        param2Metadata.merge(MetadataUtils.HeaderAttachingClientInterceptor.this.extraHeaders);
        super.start(param2Listener, param2Metadata);
      }
    }
  }
  
  private final class HeaderAttachingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
    HeaderAttachingClientCall(ClientCall<ReqT, RespT> param1ClientCall) {
      super(param1ClientCall);
    }
    
    public void start(ClientCall.Listener<RespT> param1Listener, Metadata param1Metadata) {
      param1Metadata.merge(this.this$0.extraHeaders);
      super.start(param1Listener, param1Metadata);
    }
  }
  
  private static final class MetadataCapturingClientInterceptor implements ClientInterceptor {
    final AtomicReference<Metadata> headersCapture;
    
    final AtomicReference<Metadata> trailersCapture;
    
    MetadataCapturingClientInterceptor(AtomicReference<Metadata> param1AtomicReference1, AtomicReference<Metadata> param1AtomicReference2) {
      this.headersCapture = (AtomicReference<Metadata>)Preconditions.checkNotNull(param1AtomicReference1, "headersCapture");
      this.trailersCapture = (AtomicReference<Metadata>)Preconditions.checkNotNull(param1AtomicReference2, "trailersCapture");
    }
    
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, CallOptions param1CallOptions, Channel param1Channel) {
      return (ClientCall)new MetadataCapturingClientCall<Object, Object>(param1Channel.newCall(param1MethodDescriptor, param1CallOptions));
    }
    
    private final class MetadataCapturingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
      MetadataCapturingClientCall(ClientCall<ReqT, RespT> param2ClientCall) {
        super(param2ClientCall);
      }
      
      public void start(ClientCall.Listener<RespT> param2Listener, Metadata param2Metadata) {
        MetadataUtils.MetadataCapturingClientInterceptor.this.headersCapture.set(null);
        MetadataUtils.MetadataCapturingClientInterceptor.this.trailersCapture.set(null);
        super.start((ClientCall.Listener)new MetadataCapturingClientCallListener(param2Listener), param2Metadata);
      }
      
      private final class MetadataCapturingClientCallListener extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
        MetadataCapturingClientCallListener(ClientCall.Listener<RespT> param3Listener) {
          super(param3Listener);
        }
        
        public void onClose(Status param3Status, Metadata param3Metadata) {
          MetadataUtils.MetadataCapturingClientInterceptor.this.trailersCapture.set(param3Metadata);
          super.onClose(param3Status, param3Metadata);
        }
        
        public void onHeaders(Metadata param3Metadata) {
          MetadataUtils.MetadataCapturingClientInterceptor.this.headersCapture.set(param3Metadata);
          super.onHeaders(param3Metadata);
        }
      }
    }
    
    private final class MetadataCapturingClientCallListener extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
      MetadataCapturingClientCallListener(ClientCall.Listener<RespT> param2Listener) {
        super(param2Listener);
      }
      
      public void onClose(Status param2Status, Metadata param2Metadata) {
        MetadataUtils.MetadataCapturingClientInterceptor.this.trailersCapture.set(param2Metadata);
        super.onClose(param2Status, param2Metadata);
      }
      
      public void onHeaders(Metadata param2Metadata) {
        MetadataUtils.MetadataCapturingClientInterceptor.this.headersCapture.set(param2Metadata);
        super.onHeaders(param2Metadata);
      }
    }
  }
  
  private final class MetadataCapturingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
    MetadataCapturingClientCall(ClientCall<ReqT, RespT> param1ClientCall) {
      super(param1ClientCall);
    }
    
    public void start(ClientCall.Listener<RespT> param1Listener, Metadata param1Metadata) {
      this.this$0.headersCapture.set(null);
      this.this$0.trailersCapture.set(null);
      super.start((ClientCall.Listener)new MetadataCapturingClientCallListener(param1Listener), param1Metadata);
    }
    
    private final class MetadataCapturingClientCallListener extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
      MetadataCapturingClientCallListener(ClientCall.Listener<RespT> param3Listener) {
        super(param3Listener);
      }
      
      public void onClose(Status param3Status, Metadata param3Metadata) {
        this.this$1.this$0.trailersCapture.set(param3Metadata);
        super.onClose(param3Status, param3Metadata);
      }
      
      public void onHeaders(Metadata param3Metadata) {
        this.this$1.this$0.headersCapture.set(param3Metadata);
        super.onHeaders(param3Metadata);
      }
    }
  }
  
  private final class MetadataCapturingClientCallListener extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
    MetadataCapturingClientCallListener(ClientCall.Listener<RespT> param1Listener) {
      super(param1Listener);
    }
    
    public void onClose(Status param1Status, Metadata param1Metadata) {
      this.this$1.this$0.trailersCapture.set(param1Metadata);
      super.onClose(param1Status, param1Metadata);
    }
    
    public void onHeaders(Metadata param1Metadata) {
      this.this$1.this$0.headersCapture.set(param1Metadata);
      super.onHeaders(param1Metadata);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\MetadataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */