package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApiClientModule_ProvidesDataCollectionHelperFactory implements Factory<DataCollectionHelper> {
  private final Provider<Subscriber> firebaseEventSubscriberProvider;
  
  private final ApiClientModule module;
  
  private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;
  
  public ApiClientModule_ProvidesDataCollectionHelperFactory(ApiClientModule paramApiClientModule, Provider<SharedPreferencesUtils> paramProvider, Provider<Subscriber> paramProvider1) {
    this.module = paramApiClientModule;
    this.sharedPreferencesUtilsProvider = paramProvider;
    this.firebaseEventSubscriberProvider = paramProvider1;
  }
  
  public static Factory<DataCollectionHelper> create(ApiClientModule paramApiClientModule, Provider<SharedPreferencesUtils> paramProvider, Provider<Subscriber> paramProvider1) {
    return new ApiClientModule_ProvidesDataCollectionHelperFactory(paramApiClientModule, paramProvider, paramProvider1);
  }
  
  public static DataCollectionHelper proxyProvidesDataCollectionHelper(ApiClientModule paramApiClientModule, SharedPreferencesUtils paramSharedPreferencesUtils, Subscriber paramSubscriber) {
    return paramApiClientModule.providesDataCollectionHelper(paramSharedPreferencesUtils, paramSubscriber);
  }
  
  public DataCollectionHelper get() {
    return (DataCollectionHelper)Preconditions.checkNotNull(this.module.providesDataCollectionHelper((SharedPreferencesUtils)this.sharedPreferencesUtilsProvider.get(), (Subscriber)this.firebaseEventSubscriberProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApiClientModule_ProvidesDataCollectionHelperFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */