package io.grpc.okhttp;

import io.grpc.Internal;
import io.grpc.InternalServiceProviders;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannelProvider;
import io.grpc.internal.GrpcUtil;

@Internal
public final class OkHttpChannelProvider extends ManagedChannelProvider {
  public OkHttpChannelBuilder builderForAddress(String paramString, int paramInt) {
    return OkHttpChannelBuilder.forAddress(paramString, paramInt);
  }
  
  public OkHttpChannelBuilder builderForTarget(String paramString) {
    return OkHttpChannelBuilder.forTarget(paramString);
  }
  
  public boolean isAvailable() {
    return true;
  }
  
  public int priority() {
    return (GrpcUtil.IS_RESTRICTED_APPENGINE || InternalServiceProviders.isAndroid(getClass().getClassLoader())) ? 8 : 3;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpChannelProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */