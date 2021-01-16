package com.google.firebase.inappmessaging.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

public class DataCollectionHelper {
  @VisibleForTesting
  static final String AUTO_INIT_PREFERENCES = "auto_init";
  
  @VisibleForTesting
  static final String MANIFEST_METADATA_AUTO_INIT_ENABLED = "firebase_inapp_messaging_auto_data_collection_enabled";
  
  private AtomicBoolean isGlobalAutomaticDataCollectionEnabled;
  
  private SharedPreferencesUtils sharedPreferencesUtils;
  
  @Inject
  public DataCollectionHelper(FirebaseApp paramFirebaseApp, SharedPreferencesUtils paramSharedPreferencesUtils, FirebaseInstanceId paramFirebaseInstanceId, Subscriber paramSubscriber) {
    this.sharedPreferencesUtils = paramSharedPreferencesUtils;
    this.isGlobalAutomaticDataCollectionEnabled = new AtomicBoolean(paramFirebaseApp.isDataCollectionDefaultEnabled());
    if (isAutomaticDataCollectionEnabled())
      paramFirebaseInstanceId.getToken(); 
    paramSubscriber.subscribe(DataCollectionDefaultChange.class, DataCollectionHelper$$Lambda$1.lambdaFactory$(this));
  }
  
  private boolean isProductManifestSet() {
    return this.sharedPreferencesUtils.isManifestSet("firebase_inapp_messaging_auto_data_collection_enabled");
  }
  
  private boolean isProductManuallySet() {
    return this.sharedPreferencesUtils.isPreferenceSet("auto_init");
  }
  
  private boolean readAutomaticDataCollectionEnabledFromPreferences() {
    return this.sharedPreferencesUtils.getBooleanPreference("auto_init", true);
  }
  
  public boolean isAutomaticDataCollectionEnabled() {
    return isProductManuallySet() ? this.sharedPreferencesUtils.getBooleanPreference("auto_init", true) : (isProductManifestSet() ? this.sharedPreferencesUtils.getBooleanManifestValue("firebase_inapp_messaging_auto_data_collection_enabled", true) : this.isGlobalAutomaticDataCollectionEnabled.get());
  }
  
  public void setAutomaticDataCollectionEnabled(boolean paramBoolean) {
    this.sharedPreferencesUtils.setBooleanPreference("auto_init", paramBoolean);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\DataCollectionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */