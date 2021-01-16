package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FirebaseInAppMessaging_Factory implements Factory<FirebaseInAppMessaging> {
  private final Provider<DataCollectionHelper> dataCollectionHelperProvider;
  
  private final Provider<DeveloperListenerManager> developerListenerManagerProvider;
  
  private final Provider<DisplayCallbacksFactory> displayCallbacksFactoryProvider;
  
  private final Provider<InAppMessageStreamManager> inAppMessageStreamManagerProvider;
  
  public FirebaseInAppMessaging_Factory(Provider<InAppMessageStreamManager> paramProvider, Provider<DataCollectionHelper> paramProvider1, Provider<DisplayCallbacksFactory> paramProvider2, Provider<DeveloperListenerManager> paramProvider3) {
    this.inAppMessageStreamManagerProvider = paramProvider;
    this.dataCollectionHelperProvider = paramProvider1;
    this.displayCallbacksFactoryProvider = paramProvider2;
    this.developerListenerManagerProvider = paramProvider3;
  }
  
  public static Factory<FirebaseInAppMessaging> create(Provider<InAppMessageStreamManager> paramProvider, Provider<DataCollectionHelper> paramProvider1, Provider<DisplayCallbacksFactory> paramProvider2, Provider<DeveloperListenerManager> paramProvider3) {
    return new FirebaseInAppMessaging_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }
  
  public static FirebaseInAppMessaging newFirebaseInAppMessaging(InAppMessageStreamManager paramInAppMessageStreamManager, DataCollectionHelper paramDataCollectionHelper, DisplayCallbacksFactory paramDisplayCallbacksFactory, DeveloperListenerManager paramDeveloperListenerManager) {
    return new FirebaseInAppMessaging(paramInAppMessageStreamManager, paramDataCollectionHelper, paramDisplayCallbacksFactory, paramDeveloperListenerManager);
  }
  
  public FirebaseInAppMessaging get() {
    return new FirebaseInAppMessaging((InAppMessageStreamManager)this.inAppMessageStreamManagerProvider.get(), (DataCollectionHelper)this.dataCollectionHelperProvider.get(), (DisplayCallbacksFactory)this.displayCallbacksFactoryProvider.get(), (DeveloperListenerManager)this.developerListenerManagerProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\FirebaseInAppMessaging_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */