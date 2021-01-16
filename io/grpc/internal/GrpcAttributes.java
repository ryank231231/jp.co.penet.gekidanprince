package io.grpc.internal;

import io.grpc.Attributes;
import java.util.Map;

public final class GrpcAttributes {
  public static final Attributes.Key<String> ATTR_LB_ADDR_AUTHORITY;
  
  public static final Attributes.Key<Map<String, Object>> NAME_RESOLVER_SERVICE_CONFIG = Attributes.Key.of("service-config");
  
  static {
    ATTR_LB_ADDR_AUTHORITY = Attributes.Key.of("io.grpc.grpclb.lbAddrAuthority");
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\GrpcAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */