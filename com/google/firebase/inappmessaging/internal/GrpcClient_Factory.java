package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GrpcClient_Factory implements Factory<GrpcClient> {
  private final Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> stubProvider;
  
  public GrpcClient_Factory(Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> paramProvider) {
    this.stubProvider = paramProvider;
  }
  
  public static Factory<GrpcClient> create(Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> paramProvider) {
    return new GrpcClient_Factory(paramProvider);
  }
  
  public static GrpcClient newGrpcClient(InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub paramInAppMessagingSdkServingBlockingStub) {
    return new GrpcClient(paramInAppMessagingSdkServingBlockingStub);
  }
  
  public GrpcClient get() {
    return new GrpcClient((InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub)this.stubProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\GrpcClient_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */