package io.grpc;

public abstract class ForwardingClientCallListener<RespT> extends PartialForwardingClientCallListener<RespT> {
  protected abstract ClientCall.Listener<RespT> delegate();
  
  public void onMessage(RespT paramRespT) {
    delegate().onMessage(paramRespT);
  }
  
  public static abstract class SimpleForwardingClientCallListener<RespT> extends ForwardingClientCallListener<RespT> {
    private final ClientCall.Listener<RespT> delegate;
    
    protected SimpleForwardingClientCallListener(ClientCall.Listener<RespT> param1Listener) {
      this.delegate = param1Listener;
    }
    
    protected ClientCall.Listener<RespT> delegate() {
      return this.delegate;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ForwardingClientCallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */