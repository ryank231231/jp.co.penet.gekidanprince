package io.grpc.internal;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

public interface ClientTransportFactory extends Closeable {
  void close();
  
  ScheduledExecutorService getScheduledExecutorService();
  
  ConnectionClientTransport newClientTransport(SocketAddress paramSocketAddress, String paramString1, @Nullable String paramString2, @Nullable ProxyParameters paramProxyParameters);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ClientTransportFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */