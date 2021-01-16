package com.google.firebase.inappmessaging.display.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

public class FirebaseInAppMessagingDisplayImpl implements FirebaseInAppMessagingDisplay, Application.ActivityLifecycleCallbacks {
  public void displayMessage(InAppMessage paramInAppMessage, FirebaseInAppMessagingDisplayCallbacks paramFirebaseInAppMessagingDisplayCallbacks) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Created activity: ");
    stringBuilder.append(paramActivity.getClass().getName());
    Logging.logd(stringBuilder.toString());
  }
  
  public void onActivityDestroyed(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Destroyed activity: ");
    stringBuilder.append(paramActivity.getClass().getName());
    Logging.logd(stringBuilder.toString());
  }
  
  public void onActivityPaused(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Pausing activity: ");
    stringBuilder.append(paramActivity.getClass().getName());
    Logging.logd(stringBuilder.toString());
  }
  
  public void onActivityResumed(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Resumed activity: ");
    stringBuilder.append(paramActivity.getClass().getName());
    Logging.logd(stringBuilder.toString());
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SavedInstance activity: ");
    stringBuilder.append(paramActivity.getClass().getName());
    Logging.logd(stringBuilder.toString());
  }
  
  public void onActivityStarted(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Started activity: ");
    stringBuilder.append(paramActivity.getClass().getName());
    Logging.logd(stringBuilder.toString());
  }
  
  public void onActivityStopped(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Stopped activity: ");
    stringBuilder.append(paramActivity.getClass().getName());
    Logging.logd(stringBuilder.toString());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\FirebaseInAppMessagingDisplayImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */