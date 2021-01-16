package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DataCollectionHelper_Factory implements Factory<DataCollectionHelper> {
  private final Provider<FirebaseApp> firebaseAppProvider;
  
  private final Provider<Subscriber> firebaseEventsSubscriberProvider;
  
  private final Provider<FirebaseInstanceId> firebaseInstanceIdProvider;
  
  private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;
  
  public DataCollectionHelper_Factory(Provider<FirebaseApp> paramProvider, Provider<SharedPreferencesUtils> paramProvider1, Provider<FirebaseInstanceId> paramProvider2, Provider<Subscriber> paramProvider3) {
    this.firebaseAppProvider = paramProvider;
    this.sharedPreferencesUtilsProvider = paramProvider1;
    this.firebaseInstanceIdProvider = paramProvider2;
    this.firebaseEventsSubscriberProvider = paramProvider3;
  }
  
  public static Factory<DataCollectionHelper> create(Provider<FirebaseApp> paramProvider, Provider<SharedPreferencesUtils> paramProvider1, Provider<FirebaseInstanceId> paramProvider2, Provider<Subscriber> paramProvider3) {
    return new DataCollectionHelper_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }
  
  public DataCollectionHelper get() {
    return new DataCollectionHelper((FirebaseApp)this.firebaseAppProvider.get(), (SharedPreferencesUtils)this.sharedPreferencesUtilsProvider.get(), (FirebaseInstanceId)this.firebaseInstanceIdProvider.get(), (Subscriber)this.firebaseEventsSubscriberProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\DataCollectionHelper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */