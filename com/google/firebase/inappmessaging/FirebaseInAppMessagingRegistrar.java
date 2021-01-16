package com.google.firebase.inappmessaging;

import android.app.Application;
import android.support.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInAppMessagingRegistrar implements ComponentRegistrar {
  private FirebaseInAppMessaging providesFirebaseInAppMessaging(ComponentContainer paramComponentContainer) {
    FirebaseApp firebaseApp = (FirebaseApp)paramComponentContainer.get(FirebaseApp.class);
    FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId)paramComponentContainer.get(FirebaseInstanceId.class);
    AnalyticsConnector analyticsConnector = (AnalyticsConnector)paramComponentContainer.get(AnalyticsConnector.class);
    Subscriber subscriber = (Subscriber)paramComponentContainer.get(Subscriber.class);
    Application application = (Application)firebaseApp.getApplicationContext();
    UniversalComponent universalComponent = DaggerUniversalComponent.builder().applicationModule(new ApplicationModule(application)).appMeasurementModule(new AppMeasurementModule(analyticsConnector, subscriber)).analyticsEventsModule(new AnalyticsEventsModule()).build();
    return DaggerAppComponent.builder().apiClientModule(new ApiClientModule(firebaseApp, firebaseInstanceId, universalComponent.clock())).clearcutLoggerClientModule(new ClearcutLoggerClientModule(firebaseApp)).grpcClientModule(new GrpcClientModule(firebaseApp)).universalComponent(universalComponent).build().providesFirebaseInAppMessaging();
  }
  
  @Keep
  public List<Component<?>> getComponents() {
    return Arrays.asList((Component<?>[])new Component[] { Component.builder(FirebaseInAppMessaging.class).add(Dependency.required(FirebaseInstanceId.class)).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(AnalyticsConnector.class)).add(Dependency.required(Subscriber.class)).factory(FirebaseInAppMessagingRegistrar$$Lambda$1.lambdaFactory$(this)).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-fiam", "17.1.0") });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\FirebaseInAppMessagingRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */