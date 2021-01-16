package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import dagger.Module;
import dagger.Provides;

@Module
public class HeadlessInAppMessagingModule {
  private final FirebaseInAppMessaging headless;
  
  public HeadlessInAppMessagingModule(FirebaseInAppMessaging paramFirebaseInAppMessaging) {
    this.headless = paramFirebaseInAppMessaging;
  }
  
  @Provides
  @FirebaseAppScope
  FirebaseInAppMessaging providesHeadlesssSingleton() {
    return this.headless;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\HeadlessInAppMessagingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */