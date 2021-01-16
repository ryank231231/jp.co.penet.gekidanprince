package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CampaignCacheClient_Factory implements Factory<CampaignCacheClient> {
  private final Provider<Application> applicationProvider;
  
  private final Provider<Clock> clockProvider;
  
  private final Provider<ProtoStorageClient> storageClientProvider;
  
  public CampaignCacheClient_Factory(Provider<ProtoStorageClient> paramProvider, Provider<Application> paramProvider1, Provider<Clock> paramProvider2) {
    this.storageClientProvider = paramProvider;
    this.applicationProvider = paramProvider1;
    this.clockProvider = paramProvider2;
  }
  
  public static Factory<CampaignCacheClient> create(Provider<ProtoStorageClient> paramProvider, Provider<Application> paramProvider1, Provider<Clock> paramProvider2) {
    return new CampaignCacheClient_Factory(paramProvider, paramProvider1, paramProvider2);
  }
  
  public static CampaignCacheClient newCampaignCacheClient(ProtoStorageClient paramProtoStorageClient, Application paramApplication, Clock paramClock) {
    return new CampaignCacheClient(paramProtoStorageClient, paramApplication, paramClock);
  }
  
  public CampaignCacheClient get() {
    return new CampaignCacheClient((ProtoStorageClient)this.storageClientProvider.get(), (Application)this.applicationProvider.get(), (Clock)this.clockProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\CampaignCacheClient_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */