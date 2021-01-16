package io.grpc;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2132")
public abstract class ServerTransportFilter {
  public Attributes transportReady(Attributes paramAttributes) {
    return paramAttributes;
  }
  
  public void transportTerminated(Attributes paramAttributes) {}
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerTransportFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */