package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PublicApi;

@PublicApi
public class FirebaseInitProvider extends ContentProvider {
  @VisibleForTesting
  static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseinitprovider";
  
  private static final String TAG = "FirebaseInitProvider";
  
  private static void checkContentProviderAuthority(@NonNull ProviderInfo paramProviderInfo) {
    Preconditions.checkNotNull(paramProviderInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
    if (!"com.google.firebase.firebaseinitprovider".equals(paramProviderInfo.authority))
      return; 
    throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo) {
    checkContentProviderAuthority(paramProviderInfo);
    super.attachInfo(paramContext, paramProviderInfo);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
    return 0;
  }
  
  @Nullable
  public String getType(Uri paramUri) {
    return null;
  }
  
  @Nullable
  public Uri insert(Uri paramUri, ContentValues paramContentValues) {
    return null;
  }
  
  public boolean onCreate() {
    if (FirebaseApp.initializeApp(getContext()) == null) {
      Log.i("FirebaseInitProvider", "FirebaseApp initialization unsuccessful");
    } else {
      Log.i("FirebaseInitProvider", "FirebaseApp initialization successful");
    } 
    return false;
  }
  
  @Nullable
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    return 0;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\provider\FirebaseInitProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */