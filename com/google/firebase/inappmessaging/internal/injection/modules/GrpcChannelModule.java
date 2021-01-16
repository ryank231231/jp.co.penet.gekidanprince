package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.Module;
import dagger.Provides;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class GrpcChannelModule {
  @Provides
  @Singleton
  public Channel providesGrpcChannel(@Named("host") String paramString) {
    return (Channel)ManagedChannelBuilder.forTarget(paramString).build();
  }
  
  @Provides
  @Named("host")
  @Singleton
  public String providesServiceHost() {
    return "firebaseinappmessaging.googleapis.com";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\GrpcChannelModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */