package com.google.firebase.inappmessaging.internal.injection.components;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import dagger.Component;

@Component(dependencies = {UniversalComponent.class}, modules = {ApiClientModule.class, GrpcClientModule.class, ClearcutLoggerClientModule.class})
@FirebaseAppScope
public interface AppComponent {
  DisplayCallbacksFactory displayCallbacksFactory();
  
  FirebaseInAppMessaging providesFirebaseInAppMessaging();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\components\AppComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */