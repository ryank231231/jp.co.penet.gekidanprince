package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.NameResolver;
import java.net.URI;
import javax.annotation.Nullable;

final class OverrideAuthorityNameResolverFactory extends NameResolver.Factory {
  private final String authorityOverride;
  
  private final NameResolver.Factory delegate;
  
  OverrideAuthorityNameResolverFactory(NameResolver.Factory paramFactory, String paramString) {
    this.delegate = paramFactory;
    this.authorityOverride = paramString;
  }
  
  public String getDefaultScheme() {
    return this.delegate.getDefaultScheme();
  }
  
  @Nullable
  public NameResolver newNameResolver(URI paramURI, Attributes paramAttributes) {
    NameResolver nameResolver = this.delegate.newNameResolver(paramURI, paramAttributes);
    return (nameResolver == null) ? null : new ForwardingNameResolver(nameResolver) {
        public String getServiceAuthority() {
          return OverrideAuthorityNameResolverFactory.this.authorityOverride;
        }
      };
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\OverrideAuthorityNameResolverFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */