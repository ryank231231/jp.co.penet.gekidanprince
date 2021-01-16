package com.google.firebase.inappmessaging;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import io.reactivex.Maybe;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@FirebaseAppScope
public class FirebaseInAppMessaging {
  private boolean areMessagesSuppressed;
  
  private final DataCollectionHelper dataCollectionHelper;
  
  private final DeveloperListenerManager developerListenerManager;
  
  private final DisplayCallbacksFactory displayCallbacksFactory;
  
  private final InAppMessageStreamManager inAppMessageStreamManager;
  
  private Maybe<FirebaseInAppMessagingDisplay> listener = Maybe.empty();
  
  @Inject
  @VisibleForTesting
  FirebaseInAppMessaging(InAppMessageStreamManager paramInAppMessageStreamManager, DataCollectionHelper paramDataCollectionHelper, DisplayCallbacksFactory paramDisplayCallbacksFactory, DeveloperListenerManager paramDeveloperListenerManager) {
    this.inAppMessageStreamManager = paramInAppMessageStreamManager;
    this.dataCollectionHelper = paramDataCollectionHelper;
    this.areMessagesSuppressed = false;
    this.displayCallbacksFactory = paramDisplayCallbacksFactory;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Starting InAppMessaging runtime with Instance ID ");
    stringBuilder.append(FirebaseInstanceId.getInstance().getId());
    Logging.logi(stringBuilder.toString());
    this.developerListenerManager = paramDeveloperListenerManager;
    initializeFiam();
  }
  
  @Keep
  public static FirebaseInAppMessaging getInstance() {
    return (FirebaseInAppMessaging)FirebaseApp.getInstance().get(FirebaseInAppMessaging.class);
  }
  
  private void initializeFiam() {
    this.inAppMessageStreamManager.createFirebaseInAppMessageStream().subscribe(FirebaseInAppMessaging$$Lambda$1.lambdaFactory$(this));
  }
  
  public void addClickListener(FirebaseInAppMessagingClickListener paramFirebaseInAppMessagingClickListener) {
    this.developerListenerManager.addClickListener(paramFirebaseInAppMessagingClickListener);
  }
  
  public void addClickListener(FirebaseInAppMessagingClickListener paramFirebaseInAppMessagingClickListener, Executor paramExecutor) {
    this.developerListenerManager.addClickListener(paramFirebaseInAppMessagingClickListener, paramExecutor);
  }
  
  public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener paramFirebaseInAppMessagingDisplayErrorListener) {
    this.developerListenerManager.addDisplayErrorListener(paramFirebaseInAppMessagingDisplayErrorListener);
  }
  
  public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener paramFirebaseInAppMessagingDisplayErrorListener, Executor paramExecutor) {
    this.developerListenerManager.addDisplayErrorListener(paramFirebaseInAppMessagingDisplayErrorListener, paramExecutor);
  }
  
  public void addImpressionListener(FirebaseInAppMessagingImpressionListener paramFirebaseInAppMessagingImpressionListener) {
    this.developerListenerManager.addImpressionListener(paramFirebaseInAppMessagingImpressionListener);
  }
  
  public void addImpressionListener(FirebaseInAppMessagingImpressionListener paramFirebaseInAppMessagingImpressionListener, Executor paramExecutor) {
    this.developerListenerManager.addImpressionListener(paramFirebaseInAppMessagingImpressionListener, paramExecutor);
  }
  
  @Keep
  public boolean areMessagesSuppressed() {
    return this.areMessagesSuppressed;
  }
  
  @Keep
  @KeepForSdk
  public void clearDisplayListener() {
    Logging.logi("Removing display event listener");
    this.listener = Maybe.empty();
  }
  
  @Keep
  public boolean isAutomaticDataCollectionEnabled() {
    return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
  }
  
  public void removeClickListener(FirebaseInAppMessagingClickListener paramFirebaseInAppMessagingClickListener) {
    this.developerListenerManager.removeClickListener(paramFirebaseInAppMessagingClickListener);
  }
  
  public void removeDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener paramFirebaseInAppMessagingDisplayErrorListener) {
    this.developerListenerManager.removeDisplayErrorListener(paramFirebaseInAppMessagingDisplayErrorListener);
  }
  
  public void removeImpressionListener(FirebaseInAppMessagingImpressionListener paramFirebaseInAppMessagingImpressionListener) {
    this.developerListenerManager.removeImpressionListener(paramFirebaseInAppMessagingImpressionListener);
  }
  
  @Keep
  public void setAutomaticDataCollectionEnabled(boolean paramBoolean) {
    this.dataCollectionHelper.setAutomaticDataCollectionEnabled(paramBoolean);
  }
  
  @Keep
  public void setMessageDisplayComponent(FirebaseInAppMessagingDisplay paramFirebaseInAppMessagingDisplay) {
    Logging.logi("Setting display event listener");
    this.listener = Maybe.just(paramFirebaseInAppMessagingDisplay);
  }
  
  @Keep
  public void setMessagesSuppressed(Boolean paramBoolean) {
    this.areMessagesSuppressed = paramBoolean.booleanValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\FirebaseInAppMessaging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */