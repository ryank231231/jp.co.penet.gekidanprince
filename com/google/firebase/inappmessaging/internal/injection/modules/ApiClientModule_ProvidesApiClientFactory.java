package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApiClientModule_ProvidesApiClientFactory implements Factory<ApiClient> {
  private final Provider<Application> applicationProvider;
  
  private final Provider<DataCollectionHelper> dataCollectionHelperProvider;
  
  private final Provider<GrpcClient> grpcClientProvider;
  
  private final ApiClientModule module;
  
  public ApiClientModule_ProvidesApiClientFactory(ApiClientModule paramApiClientModule, Provider<GrpcClient> paramProvider, Provider<Application> paramProvider1, Provider<DataCollectionHelper> paramProvider2) {
    this.module = paramApiClientModule;
    this.grpcClientProvider = paramProvider;
    this.applicationProvider = paramProvider1;
    this.dataCollectionHelperProvider = paramProvider2;
  }
  
  public static Factory<ApiClient> create(ApiClientModule paramApiClientModule, Provider<GrpcClient> paramProvider, Provider<Application> paramProvider1, Provider<DataCollectionHelper> paramProvider2) {
    return new ApiClientModule_ProvidesApiClientFactory(paramApiClientModule, paramProvider, paramProvider1, paramProvider2);
  }
  
  public static ApiClient proxyProvidesApiClient(ApiClientModule paramApiClientModule, GrpcClient paramGrpcClient, Application paramApplication, DataCollectionHelper paramDataCollectionHelper) {
    return paramApiClientModule.providesApiClient(paramGrpcClient, paramApplication, paramDataCollectionHelper);
  }
  
  public ApiClient get() {
    return (ApiClient)Preconditions.checkNotNull(this.module.providesApiClient((GrpcClient)this.grpcClientProvider.get(), (Application)this.applicationProvider.get(), (DataCollectionHelper)this.dataCollectionHelperProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApiClientModule_ProvidesApiClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */