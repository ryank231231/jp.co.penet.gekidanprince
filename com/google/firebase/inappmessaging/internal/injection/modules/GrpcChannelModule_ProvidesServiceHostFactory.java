package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GrpcChannelModule_ProvidesServiceHostFactory implements Factory<String> {
  private final GrpcChannelModule module;
  
  public GrpcChannelModule_ProvidesServiceHostFactory(GrpcChannelModule paramGrpcChannelModule) {
    this.module = paramGrpcChannelModule;
  }
  
  public static Factory<String> create(GrpcChannelModule paramGrpcChannelModule) {
    return new GrpcChannelModule_ProvidesServiceHostFactory(paramGrpcChannelModule);
  }
  
  public String get() {
    return (String)Preconditions.checkNotNull(this.module.providesServiceHost(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\GrpcChannelModule_ProvidesServiceHostFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */