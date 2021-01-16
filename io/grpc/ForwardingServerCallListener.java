package io.grpc;

public abstract class ForwardingServerCallListener<ReqT> extends PartialForwardingServerCallListener<ReqT> {
  protected abstract ServerCall.Listener<ReqT> delegate();
  
  public void onMessage(ReqT paramReqT) {
    delegate().onMessage(paramReqT);
  }
  
  public static abstract class SimpleForwardingServerCallListener<ReqT> extends ForwardingServerCallListener<ReqT> {
    private final ServerCall.Listener<ReqT> delegate;
    
    protected SimpleForwardingServerCallListener(ServerCall.Listener<ReqT> param1Listener) {
      this.delegate = param1Listener;
    }
    
    protected ServerCall.Listener<ReqT> delegate() {
      return this.delegate;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ForwardingServerCallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */