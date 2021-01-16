package io.grpc;

import javax.annotation.Nullable;

public abstract class ForwardingClientCall<ReqT, RespT> extends PartialForwardingClientCall<ReqT, RespT> {
  protected abstract ClientCall<ReqT, RespT> delegate();
  
  public void sendMessage(ReqT paramReqT) {
    delegate().sendMessage(paramReqT);
  }
  
  public void start(ClientCall.Listener<RespT> paramListener, Metadata paramMetadata) {
    delegate().start(paramListener, paramMetadata);
  }
  
  public static abstract class SimpleForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
    private final ClientCall<ReqT, RespT> delegate;
    
    protected SimpleForwardingClientCall(ClientCall<ReqT, RespT> param1ClientCall) {
      this.delegate = param1ClientCall;
    }
    
    protected ClientCall<ReqT, RespT> delegate() {
      return this.delegate;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ForwardingClientCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */