package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.NameResolver;

abstract class ForwardingNameResolver extends NameResolver {
  private final NameResolver delegate;
  
  ForwardingNameResolver(NameResolver paramNameResolver) {
    Preconditions.checkNotNull(paramNameResolver, "delegate can not be null");
    this.delegate = paramNameResolver;
  }
  
  public String getServiceAuthority() {
    return this.delegate.getServiceAuthority();
  }
  
  public void refresh() {
    this.delegate.refresh();
  }
  
  public void shutdown() {
    this.delegate.shutdown();
  }
  
  public void start(NameResolver.Listener paramListener) {
    this.delegate.start(paramListener);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ForwardingNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */