package io.grpc.internal;

import java.io.IOException;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface InternalServer {
  List<Instrumented<Channelz.SocketStats>> getListenSockets();
  
  int getPort();
  
  void shutdown();
  
  void start(ServerListener paramServerListener) throws IOException;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\InternalServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */