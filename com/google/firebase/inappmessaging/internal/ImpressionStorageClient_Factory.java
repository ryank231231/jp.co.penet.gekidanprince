package com.google.firebase.inappmessaging.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ImpressionStorageClient_Factory implements Factory<ImpressionStorageClient> {
  private final Provider<ProtoStorageClient> storageClientProvider;
  
  public ImpressionStorageClient_Factory(Provider<ProtoStorageClient> paramProvider) {
    this.storageClientProvider = paramProvider;
  }
  
  public static Factory<ImpressionStorageClient> create(Provider<ProtoStorageClient> paramProvider) {
    return new ImpressionStorageClient_Factory(paramProvider);
  }
  
  public static ImpressionStorageClient newImpressionStorageClient(ProtoStorageClient paramProtoStorageClient) {
    return new ImpressionStorageClient(paramProtoStorageClient);
  }
  
  public ImpressionStorageClient get() {
    return new ImpressionStorageClient((ProtoStorageClient)this.storageClientProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\ImpressionStorageClient_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */