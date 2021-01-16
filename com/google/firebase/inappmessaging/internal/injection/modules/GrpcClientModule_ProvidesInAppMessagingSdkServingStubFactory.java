package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.grpc.Channel;
import io.grpc.Metadata;
import javax.inject.Provider;

public final class GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory implements Factory<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> {
  private final Provider<Channel> channelProvider;
  
  private final Provider<Metadata> metadataProvider;
  
  private final GrpcClientModule module;
  
  public GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(GrpcClientModule paramGrpcClientModule, Provider<Channel> paramProvider, Provider<Metadata> paramProvider1) {
    this.module = paramGrpcClientModule;
    this.channelProvider = paramProvider;
    this.metadataProvider = paramProvider1;
  }
  
  public static Factory<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> create(GrpcClientModule paramGrpcClientModule, Provider<Channel> paramProvider, Provider<Metadata> paramProvider1) {
    return new GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(paramGrpcClientModule, paramProvider, paramProvider1);
  }
  
  public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub get() {
    return (InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub)Preconditions.checkNotNull(this.module.providesInAppMessagingSdkServingStub((Channel)this.channelProvider.get(), (Metadata)this.metadataProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */