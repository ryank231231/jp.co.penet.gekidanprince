package io.grpc;

import java.net.SocketAddress;
import javax.net.ssl.SSLSession;

public final class Grpc {
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1710")
  public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_REMOTE_ADDR = Attributes.Key.of("remote-addr");
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1710")
  public static final Attributes.Key<SSLSession> TRANSPORT_ATTR_SSL_SESSION = Attributes.Key.of("ssl-session");
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Grpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */