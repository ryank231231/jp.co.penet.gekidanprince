package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiClientModule {
  private final Clock clock;
  
  private final FirebaseApp firebaseApp;
  
  private final FirebaseInstanceId firebaseInstanceId;
  
  public ApiClientModule(FirebaseApp paramFirebaseApp, FirebaseInstanceId paramFirebaseInstanceId, Clock paramClock) {
    this.firebaseApp = paramFirebaseApp;
    this.firebaseInstanceId = paramFirebaseInstanceId;
    this.clock = paramClock;
  }
  
  @Provides
  @FirebaseAppScope
  ApiClient providesApiClient(GrpcClient paramGrpcClient, Application paramApplication, DataCollectionHelper paramDataCollectionHelper) {
    return new ApiClient(paramGrpcClient, this.firebaseApp, paramApplication, this.firebaseInstanceId, paramDataCollectionHelper, this.clock);
  }
  
  @Provides
  DataCollectionHelper providesDataCollectionHelper(SharedPreferencesUtils paramSharedPreferencesUtils, Subscriber paramSubscriber) {
    return new DataCollectionHelper(this.firebaseApp, paramSharedPreferencesUtils, this.firebaseInstanceId, paramSubscriber);
  }
  
  @Provides
  FirebaseApp providesFirebaseApp() {
    return this.firebaseApp;
  }
  
  @Provides
  FirebaseInstanceId providesFirebaseInstanceId() {
    return this.firebaseInstanceId;
  }
  
  @Provides
  SharedPreferencesUtils providesSharedPreferencesUtils() {
    return new SharedPreferencesUtils(this.firebaseApp);
  }
  
  @Provides
  TestDeviceHelper providesTestDeviceHelper(SharedPreferencesUtils paramSharedPreferencesUtils) {
    return new TestDeviceHelper(paramSharedPreferencesUtils);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApiClientModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */