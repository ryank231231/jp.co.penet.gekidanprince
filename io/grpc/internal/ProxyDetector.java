package io.grpc.internal;

import io.grpc.Attributes;
import java.io.IOException;
import java.net.SocketAddress;
import javax.annotation.Nullable;

public interface ProxyDetector {
  public static final Attributes.Key<ProxyParameters> PROXY_PARAMS_KEY = Attributes.Key.of("proxy-params-key");
  
  @Nullable
  ProxyParameters proxyFor(SocketAddress paramSocketAddress) throws IOException;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ProxyDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */