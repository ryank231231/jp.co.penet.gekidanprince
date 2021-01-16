package io.grpc.internal;

public interface ServerListener {
  void serverShutdown();
  
  ServerTransportListener transportCreated(ServerTransport paramServerTransport);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ServerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */