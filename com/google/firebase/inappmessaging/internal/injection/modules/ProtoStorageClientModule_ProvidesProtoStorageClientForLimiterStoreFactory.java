package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory implements Factory<ProtoStorageClient> {
  private final Provider<Application> applicationProvider;
  
  private final ProtoStorageClientModule module;
  
  public ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory(ProtoStorageClientModule paramProtoStorageClientModule, Provider<Application> paramProvider) {
    this.module = paramProtoStorageClientModule;
    this.applicationProvider = paramProvider;
  }
  
  public static Factory<ProtoStorageClient> create(ProtoStorageClientModule paramProtoStorageClientModule, Provider<Application> paramProvider) {
    return new ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory(paramProtoStorageClientModule, paramProvider);
  }
  
  public ProtoStorageClient get() {
    return (ProtoStorageClient)Preconditions.checkNotNull(this.module.providesProtoStorageClientForLimiterStore((Application)this.applicationProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */