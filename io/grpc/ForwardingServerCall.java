package io.grpc;

public abstract class ForwardingServerCall<ReqT, RespT> extends PartialForwardingServerCall<ReqT, RespT> {
  protected abstract ServerCall<ReqT, RespT> delegate();
  
  public void sendMessage(RespT paramRespT) {
    delegate().sendMessage(paramRespT);
  }
  
  public static abstract class SimpleForwardingServerCall<ReqT, RespT> extends ForwardingServerCall<ReqT, RespT> {
    private final ServerCall<ReqT, RespT> delegate;
    
    protected SimpleForwardingServerCall(ServerCall<ReqT, RespT> param1ServerCall) {
      this.delegate = param1ServerCall;
    }
    
    protected ServerCall<ReqT, RespT> delegate() {
      return this.delegate;
    }
    
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
      return this.delegate.getMethodDescriptor();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ForwardingServerCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */