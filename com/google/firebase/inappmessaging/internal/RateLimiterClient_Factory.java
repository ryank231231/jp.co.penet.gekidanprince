package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RateLimiterClient_Factory implements Factory<RateLimiterClient> {
  private final Provider<Clock> clockProvider;
  
  private final Provider<ProtoStorageClient> storageClientProvider;
  
  public RateLimiterClient_Factory(Provider<ProtoStorageClient> paramProvider, Provider<Clock> paramProvider1) {
    this.storageClientProvider = paramProvider;
    this.clockProvider = paramProvider1;
  }
  
  public static Factory<RateLimiterClient> create(Provider<ProtoStorageClient> paramProvider, Provider<Clock> paramProvider1) {
    return new RateLimiterClient_Factory(paramProvider, paramProvider1);
  }
  
  public static RateLimiterClient newRateLimiterClient(ProtoStorageClient paramProtoStorageClient, Clock paramClock) {
    return new RateLimiterClient(paramProtoStorageClient, paramClock);
  }
  
  public RateLimiterClient get() {
    return new RateLimiterClient((ProtoStorageClient)this.storageClientProvider.get(), (Clock)this.clockProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\RateLimiterClient_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */