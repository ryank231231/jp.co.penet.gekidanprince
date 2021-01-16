package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.grpc.Channel;
import javax.inject.Provider;

public final class GrpcChannelModule_ProvidesGrpcChannelFactory implements Factory<Channel> {
  private final Provider<String> hostProvider;
  
  private final GrpcChannelModule module;
  
  public GrpcChannelModule_ProvidesGrpcChannelFactory(GrpcChannelModule paramGrpcChannelModule, Provider<String> paramProvider) {
    this.module = paramGrpcChannelModule;
    this.hostProvider = paramProvider;
  }
  
  public static Factory<Channel> create(GrpcChannelModule paramGrpcChannelModule, Provider<String> paramProvider) {
    return new GrpcChannelModule_ProvidesGrpcChannelFactory(paramGrpcChannelModule, paramProvider);
  }
  
  public Channel get() {
    return (Channel)Preconditions.checkNotNull(this.module.providesGrpcChannel((String)this.hostProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\GrpcChannelModule_ProvidesGrpcChannelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */