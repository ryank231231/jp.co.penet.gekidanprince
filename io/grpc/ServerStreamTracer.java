package io.grpc;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
@ThreadSafe
public abstract class ServerStreamTracer extends StreamTracer {
  public Context filterContext(Context paramContext) {
    return paramContext;
  }
  
  @Deprecated
  public void serverCallStarted(ServerCall<?, ?> paramServerCall) {}
  
  public void serverCallStarted(ServerCallInfo<?, ?> paramServerCallInfo) {
    serverCallStarted(ReadOnlyServerCall.create((ServerCallInfo)paramServerCallInfo));
  }
  
  public static abstract class Factory {
    public abstract ServerStreamTracer newServerStreamTracer(String param1String, Metadata param1Metadata);
  }
  
  @Deprecated
  private static final class ReadOnlyServerCall<ReqT, RespT> extends ForwardingServerCall<ReqT, RespT> {
    private final ServerStreamTracer.ServerCallInfo<ReqT, RespT> callInfo;
    
    private ReadOnlyServerCall(ServerStreamTracer.ServerCallInfo<ReqT, RespT> param1ServerCallInfo) {
      this.callInfo = param1ServerCallInfo;
    }
    
    private static <ReqT, RespT> ReadOnlyServerCall<ReqT, RespT> create(ServerStreamTracer.ServerCallInfo<ReqT, RespT> param1ServerCallInfo) {
      return new ReadOnlyServerCall<ReqT, RespT>(param1ServerCallInfo);
    }
    
    protected ServerCall<ReqT, RespT> delegate() {
      throw new UnsupportedOperationException();
    }
    
    public Attributes getAttributes() {
      return this.callInfo.getAttributes();
    }
    
    public String getAuthority() {
      return this.callInfo.getAuthority();
    }
    
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
      return this.callInfo.getMethodDescriptor();
    }
    
    public boolean isCancelled() {
      return false;
    }
    
    public boolean isReady() {
      return false;
    }
  }
  
  public static abstract class ServerCallInfo<ReqT, RespT> {
    public abstract Attributes getAttributes();
    
    @Nullable
    public abstract String getAuthority();
    
    public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerStreamTracer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */