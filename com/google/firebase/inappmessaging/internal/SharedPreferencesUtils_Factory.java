package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SharedPreferencesUtils_Factory implements Factory<SharedPreferencesUtils> {
  private final Provider<FirebaseApp> firebaseAppProvider;
  
  public SharedPreferencesUtils_Factory(Provider<FirebaseApp> paramProvider) {
    this.firebaseAppProvider = paramProvider;
  }
  
  public static Factory<SharedPreferencesUtils> create(Provider<FirebaseApp> paramProvider) {
    return new SharedPreferencesUtils_Factory(paramProvider);
  }
  
  public SharedPreferencesUtils get() {
    return new SharedPreferencesUtils((FirebaseApp)this.firebaseAppProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\SharedPreferencesUtils_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */