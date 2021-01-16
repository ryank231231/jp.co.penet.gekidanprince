package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory implements Factory<FirebaseInAppMessaging> {
  private final HeadlessInAppMessagingModule module;
  
  public HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(HeadlessInAppMessagingModule paramHeadlessInAppMessagingModule) {
    this.module = paramHeadlessInAppMessagingModule;
  }
  
  public static Factory<FirebaseInAppMessaging> create(HeadlessInAppMessagingModule paramHeadlessInAppMessagingModule) {
    return new HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(paramHeadlessInAppMessagingModule);
  }
  
  public static FirebaseInAppMessaging proxyProvidesHeadlesssSingleton(HeadlessInAppMessagingModule paramHeadlessInAppMessagingModule) {
    return paramHeadlessInAppMessagingModule.providesHeadlesssSingleton();
  }
  
  public FirebaseInAppMessaging get() {
    return (FirebaseInAppMessaging)Preconditions.checkNotNull(this.module.providesHeadlesssSingleton(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */