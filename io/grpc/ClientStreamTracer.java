package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
@ThreadSafe
public abstract class ClientStreamTracer extends StreamTracer {
  public void inboundHeaders() {}
  
  public void outboundHeaders() {}
  
  public static abstract class Factory {
    public ClientStreamTracer newClientStreamTracer(CallOptions param1CallOptions, Metadata param1Metadata) {
      return newClientStreamTracer(param1Metadata);
    }
    
    @Deprecated
    public ClientStreamTracer newClientStreamTracer(Metadata param1Metadata) {
      throw new UnsupportedOperationException("This method will be deleted. Do not call.");
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ClientStreamTracer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */