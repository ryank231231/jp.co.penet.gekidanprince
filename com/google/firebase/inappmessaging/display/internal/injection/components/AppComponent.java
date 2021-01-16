package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.PicassoModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import dagger.Component;

@Component(dependencies = {UniversalComponent.class}, modules = {HeadlessInAppMessagingModule.class, PicassoModule.class})
@FirebaseAppScope
public interface AppComponent {
  FiamImageLoader fiamImageLoader();
  
  PicassoErrorListener picassoErrorListener();
  
  @FirebaseAppScope
  FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\components\AppComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */