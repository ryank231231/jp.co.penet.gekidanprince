package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import javax.inject.Inject;

public class SharedPreferencesUtils {
  @VisibleForTesting
  static final String PREFERENCES_PACKAGE_NAME = "com.google.firebase.inappmessaging";
  
  private final FirebaseApp firebaseApp;
  
  @Inject
  public SharedPreferencesUtils(FirebaseApp paramFirebaseApp) {
    this.firebaseApp = paramFirebaseApp;
  }
  
  public boolean getAndSetBooleanPreference(String paramString, boolean paramBoolean) {
    SharedPreferences sharedPreferences = ((Application)this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
    if (sharedPreferences.contains(paramString))
      return sharedPreferences.getBoolean(paramString, paramBoolean); 
    setBooleanPreference(paramString, paramBoolean);
    return paramBoolean;
  }
  
  public boolean getBooleanManifestValue(String paramString, boolean paramBoolean) {
    Application application = (Application)this.firebaseApp.getApplicationContext();
    try {
      PackageManager packageManager = application.getPackageManager();
      if (packageManager != null) {
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128);
        if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(paramString))
          return applicationInfo.metaData.getBoolean(paramString); 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return paramBoolean;
  }
  
  public boolean getBooleanPreference(String paramString, boolean paramBoolean) {
    SharedPreferences sharedPreferences = ((Application)this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
    return sharedPreferences.contains(paramString) ? sharedPreferences.getBoolean(paramString, paramBoolean) : paramBoolean;
  }
  
  public boolean isManifestSet(String paramString) {
    Application application = (Application)this.firebaseApp.getApplicationContext();
    boolean bool = false;
    try {
      PackageManager packageManager = application.getPackageManager();
      if (packageManager != null) {
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128);
        boolean bool1 = bool;
        if (applicationInfo != null) {
          bool1 = bool;
          if (applicationInfo.metaData != null) {
            boolean bool2 = applicationInfo.metaData.containsKey(paramString);
            bool1 = bool;
            if (bool2)
              bool1 = true; 
          } 
        } 
        return bool1;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return false;
  }
  
  public boolean isPreferenceSet(String paramString) {
    return ((Application)this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).contains(paramString);
  }
  
  public void setBooleanPreference(String paramString, boolean paramBoolean) {
    SharedPreferences.Editor editor = ((Application)this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
    editor.putBoolean(paramString, paramBoolean);
    editor.apply();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\SharedPreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */