package com.google.firebase.inappmessaging.internal.injection.components;

import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import dagger.Component;

@Component(dependencies = {UniversalComponent.class}, modules = {ApiClientModule.class, GrpcClientModule.class, ClearcutLoggerClientModule.class})
@FirebaseAppScope
public interface FirebaseInAppMessagingComponent {
  DataCollectionHelper dataCollectionHelper();
  
  DisplayCallbacksFactory displayCallbacksFactory();
  
  MetricsLoggerClient metricsLoggerClient();
  
  InAppMessageStreamManager streamManager();
  
  TestDeviceHelper testDeviceHelper();
  
  UniversalComponent universalComponent();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\components\FirebaseInAppMessagingComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */