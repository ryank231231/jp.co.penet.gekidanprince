package com.google.firebase.inappmessaging.display;

import android.app.Application;
import android.support.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInAppMessagingDisplayRegistrar implements ComponentRegistrar {
  private FirebaseInAppMessagingDisplay buildFirebaseInAppMessagingUI(ComponentContainer paramComponentContainer) {
    FirebaseApp firebaseApp = FirebaseApp.getInstance();
    FirebaseInAppMessaging firebaseInAppMessaging = (FirebaseInAppMessaging)paramComponentContainer.get(FirebaseInAppMessaging.class);
    Application application = (Application)firebaseApp.getApplicationContext();
    UniversalComponent universalComponent = DaggerUniversalComponent.builder().applicationModule(new ApplicationModule(application)).build();
    FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay = DaggerAppComponent.builder().universalComponent(universalComponent).headlessInAppMessagingModule(new HeadlessInAppMessagingModule(firebaseInAppMessaging)).build().providesFirebaseInAppMessagingUI();
    application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)firebaseInAppMessagingDisplay);
    return firebaseInAppMessagingDisplay;
  }
  
  @Keep
  public List<Component<?>> getComponents() {
    return Arrays.asList((Component<?>[])new Component[] { Component.builder(FirebaseInAppMessagingDisplay.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(AnalyticsConnector.class)).add(Dependency.required(FirebaseInAppMessaging.class)).factory(FirebaseInAppMessagingDisplayRegistrar$$Lambda$1.lambdaFactory$(this)).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-fiamd", "17.1.0") });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\FirebaseInAppMessagingDisplayRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */