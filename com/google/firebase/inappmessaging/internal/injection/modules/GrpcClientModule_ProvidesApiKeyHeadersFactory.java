package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.grpc.Metadata;

public final class GrpcClientModule_ProvidesApiKeyHeadersFactory implements Factory<Metadata> {
  private final GrpcClientModule module;
  
  public GrpcClientModule_ProvidesApiKeyHeadersFactory(GrpcClientModule paramGrpcClientModule) {
    this.module = paramGrpcClientModule;
  }
  
  public static Factory<Metadata> create(GrpcClientModule paramGrpcClientModule) {
    return new GrpcClientModule_ProvidesApiKeyHeadersFactory(paramGrpcClientModule);
  }
  
  public Metadata get() {
    return (Metadata)Preconditions.checkNotNull(this.module.providesApiKeyHeaders(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\GrpcClientModule_ProvidesApiKeyHeadersFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */