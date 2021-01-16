package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class Storage {
  private static final Lock zaaj = new ReentrantLock();
  
  @GuardedBy("sLk")
  private static Storage zaak;
  
  private final Lock zaal = new ReentrantLock();
  
  @GuardedBy("mLk")
  private final SharedPreferences zaam;
  
  @VisibleForTesting
  private Storage(Context paramContext) {
    this.zaam = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  @KeepForSdk
  public static Storage getInstance(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    zaaj.lock();
    try {
      if (zaak == null) {
        Storage storage = new Storage();
        this(paramContext.getApplicationContext());
        zaak = storage;
      } 
      return zaak;
    } finally {
      zaaj.unlock();
    } 
  }
  
  private final void zaa(String paramString1, String paramString2) {
    this.zaal.lock();
    try {
      this.zaam.edit().putString(paramString1, paramString2).apply();
      return;
    } finally {
      this.zaal.unlock();
    } 
  }
  
  private static String zab(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length());
    stringBuilder.append(paramString1);
    stringBuilder.append(":");
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  @Nullable
  @VisibleForTesting
  private final GoogleSignInAccount zad(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    paramString = zaf(zab("googleSignInAccount", paramString));
    if (paramString != null)
      try {
        return GoogleSignInAccount.zaa(paramString);
      } catch (JSONException jSONException) {
        return null;
      }  
    return null;
  }
  
  @Nullable
  @VisibleForTesting
  private final GoogleSignInOptions zae(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    paramString = zaf(zab("googleSignInOptions", paramString));
    if (paramString != null)
      try {
        return GoogleSignInOptions.zab(paramString);
      } catch (JSONException jSONException) {
        return null;
      }  
    return null;
  }
  
  @Nullable
  private final String zaf(String paramString) {
    this.zaal.lock();
    try {
      paramString = this.zaam.getString(paramString, null);
      return paramString;
    } finally {
      this.zaal.unlock();
    } 
  }
  
  private final void zag(String paramString) {
    this.zaal.lock();
    try {
      this.zaam.edit().remove(paramString).apply();
      return;
    } finally {
      this.zaal.unlock();
    } 
  }
  
  @KeepForSdk
  public void clear() {
    this.zaal.lock();
    try {
      this.zaam.edit().clear().apply();
      return;
    } finally {
      this.zaal.unlock();
    } 
  }
  
  @Nullable
  @KeepForSdk
  public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
    return zad(zaf("defaultGoogleSignInAccount"));
  }
  
  @Nullable
  @KeepForSdk
  public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
    return zae(zaf("defaultGoogleSignInAccount"));
  }
  
  @Nullable
  @KeepForSdk
  public String getSavedRefreshToken() {
    return zaf("refreshToken");
  }
  
  @KeepForSdk
  public void saveDefaultGoogleSignInAccount(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions) {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    zaa("defaultGoogleSignInAccount", paramGoogleSignInAccount.zab());
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zab();
    zaa(zab("googleSignInAccount", str), paramGoogleSignInAccount.zac());
    zaa(zab("googleSignInOptions", str), paramGoogleSignInOptions.zae());
  }
  
  public final void zaf() {
    String str = zaf("defaultGoogleSignInAccount");
    zag("defaultGoogleSignInAccount");
    if (!TextUtils.isEmpty(str)) {
      zag(zab("googleSignInAccount", str));
      zag(zab("googleSignInOptions", str));
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\Storage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */