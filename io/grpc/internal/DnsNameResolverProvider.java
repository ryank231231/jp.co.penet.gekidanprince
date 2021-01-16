package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import java.net.URI;

public final class DnsNameResolverProvider extends NameResolverProvider {
  private static final String SCHEME = "dns";
  
  public String getDefaultScheme() {
    return "dns";
  }
  
  protected boolean isAvailable() {
    return true;
  }
  
  public DnsNameResolver newNameResolver(URI paramURI, Attributes paramAttributes) {
    if ("dns".equals(paramURI.getScheme())) {
      String str = (String)Preconditions.checkNotNull(paramURI.getPath(), "targetPath");
      Preconditions.checkArgument(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, paramURI);
      str = str.substring(1);
      return new DnsNameResolver(paramURI.getAuthority(), str, paramAttributes, GrpcUtil.SHARED_CHANNEL_EXECUTOR, GrpcUtil.getDefaultProxyDetector());
    } 
    return null;
  }
  
  protected int priority() {
    return 5;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\DnsNameResolverProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */