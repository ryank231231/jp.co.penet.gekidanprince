package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
  
  @VisibleForTesting
  private static Clock zae = DefaultClock.getInstance();
  
  @Field(getter = "getId", id = 2)
  private String mId;
  
  @VersionField(id = 1)
  private final int versionCode;
  
  @Field(getter = "getIdToken", id = 3)
  private String zaf;
  
  @Field(getter = "getEmail", id = 4)
  private String zag;
  
  @Field(getter = "getDisplayName", id = 5)
  private String zah;
  
  @Field(getter = "getPhotoUrl", id = 6)
  private Uri zai;
  
  @Field(getter = "getServerAuthCode", id = 7)
  private String zaj;
  
  @Field(getter = "getExpirationTimeSecs", id = 8)
  private long zak;
  
  @Field(getter = "getObfuscatedIdentifier", id = 9)
  private String zal;
  
  @Field(id = 10)
  private List<Scope> zam;
  
  @Field(getter = "getGivenName", id = 11)
  private String zan;
  
  @Field(getter = "getFamilyName", id = 12)
  private String zao;
  
  private Set<Scope> zap = new HashSet<Scope>();
  
  @Constructor
  GoogleSignInAccount(@Param(id = 1) int paramInt, @Param(id = 2) String paramString1, @Param(id = 3) String paramString2, @Param(id = 4) String paramString3, @Param(id = 5) String paramString4, @Param(id = 6) Uri paramUri, @Param(id = 7) String paramString5, @Param(id = 8) long paramLong, @Param(id = 9) String paramString6, @Param(id = 10) List<Scope> paramList, @Param(id = 11) String paramString7, @Param(id = 12) String paramString8) {
    this.versionCode = paramInt;
    this.mId = paramString1;
    this.zaf = paramString2;
    this.zag = paramString3;
    this.zah = paramString4;
    this.zai = paramUri;
    this.zaj = paramString5;
    this.zak = paramLong;
    this.zal = paramString6;
    this.zam = paramList;
    this.zan = paramString7;
    this.zao = paramString8;
  }
  
  @KeepForSdk
  public static GoogleSignInAccount createDefault() {
    Account account = new Account("<<default account>>", "com.google");
    HashSet<Scope> hashSet = new HashSet();
    return zaa(null, null, account.name, null, null, null, null, Long.valueOf(0L), account.name, hashSet);
  }
  
  @Nullable
  public static GoogleSignInAccount zaa(@Nullable String paramString) throws JSONException {
    if (TextUtils.isEmpty(paramString))
      return null; 
    JSONObject jSONObject = new JSONObject(paramString);
    paramString = jSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {
      Uri uri = Uri.parse(paramString);
    } else {
      paramString = null;
    } 
    long l = Long.parseLong(jSONObject.getString("expirationTime"));
    HashSet<Scope> hashSet = new HashSet();
    JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
    int i = jSONArray.length();
    for (byte b = 0; b < i; b++)
      hashSet.add(new Scope(jSONArray.getString(b))); 
    GoogleSignInAccount googleSignInAccount = zaa(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), (Uri)paramString, Long.valueOf(l), jSONObject.getString("obfuscatedIdentifier"), hashSet);
    googleSignInAccount.zaj = jSONObject.optString("serverAuthCode", null);
    return googleSignInAccount;
  }
  
  private static GoogleSignInAccount zaa(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable Uri paramUri, @Nullable Long paramLong, @NonNull String paramString7, @NonNull Set<Scope> paramSet) {
    if (paramLong == null)
      paramLong = Long.valueOf(zae.currentTimeMillis() / 1000L); 
    return new GoogleSignInAccount(3, paramString1, paramString2, paramString3, paramString4, paramUri, null, paramLong.longValue(), Preconditions.checkNotEmpty(paramString7), new ArrayList<Scope>((Collection<? extends Scope>)Preconditions.checkNotNull(paramSet)), paramString5, paramString6);
  }
  
  private final JSONObject zad() {
    JSONObject jSONObject = new JSONObject();
    try {
      if (getId() != null)
        jSONObject.put("id", getId()); 
      if (getIdToken() != null)
        jSONObject.put("tokenId", getIdToken()); 
      if (getEmail() != null)
        jSONObject.put("email", getEmail()); 
      if (getDisplayName() != null)
        jSONObject.put("displayName", getDisplayName()); 
      if (getGivenName() != null)
        jSONObject.put("givenName", getGivenName()); 
      if (getFamilyName() != null)
        jSONObject.put("familyName", getFamilyName()); 
      if (getPhotoUrl() != null)
        jSONObject.put("photoUrl", getPhotoUrl().toString()); 
      if (getServerAuthCode() != null)
        jSONObject.put("serverAuthCode", getServerAuthCode()); 
      jSONObject.put("expirationTime", this.zak);
      jSONObject.put("obfuscatedIdentifier", this.zal);
      JSONArray jSONArray = new JSONArray();
      this();
      Scope[] arrayOfScope = this.zam.<Scope>toArray(new Scope[this.zam.size()]);
      Arrays.sort(arrayOfScope, zaa.zaq);
      int i = arrayOfScope.length;
      for (byte b = 0; b < i; b++)
        jSONArray.put(arrayOfScope[b].getScopeUri()); 
      jSONObject.put("grantedScopes", jSONArray);
      return jSONObject;
    } catch (JSONException jSONException) {
      throw new RuntimeException(jSONException);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof GoogleSignInAccount))
      return false; 
    paramObject = paramObject;
    return (((GoogleSignInAccount)paramObject).zal.equals(this.zal) && paramObject.getRequestedScopes().equals(getRequestedScopes()));
  }
  
  @Nullable
  public Account getAccount() {
    String str = this.zag;
    return (str == null) ? null : new Account(str, "com.google");
  }
  
  @Nullable
  public String getDisplayName() {
    return this.zah;
  }
  
  @Nullable
  public String getEmail() {
    return this.zag;
  }
  
  @Nullable
  public String getFamilyName() {
    return this.zao;
  }
  
  @Nullable
  public String getGivenName() {
    return this.zan;
  }
  
  @NonNull
  public Set<Scope> getGrantedScopes() {
    return new HashSet<Scope>(this.zam);
  }
  
  @Nullable
  public String getId() {
    return this.mId;
  }
  
  @Nullable
  public String getIdToken() {
    return this.zaf;
  }
  
  @Nullable
  public Uri getPhotoUrl() {
    return this.zai;
  }
  
  @NonNull
  @KeepForSdk
  public Set<Scope> getRequestedScopes() {
    HashSet<Scope> hashSet = new HashSet<Scope>(this.zam);
    hashSet.addAll(this.zap);
    return hashSet;
  }
  
  @Nullable
  public String getServerAuthCode() {
    return this.zaj;
  }
  
  public int hashCode() {
    return (this.zal.hashCode() + 527) * 31 + getRequestedScopes().hashCode();
  }
  
  @KeepForSdk
  public boolean isExpired() {
    return (zae.currentTimeMillis() / 1000L >= this.zak - 300L);
  }
  
  @KeepForSdk
  public GoogleSignInAccount requestExtraScopes(Scope... paramVarArgs) {
    if (paramVarArgs != null)
      Collections.addAll(this.zap, paramVarArgs); 
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getIdToken(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getEmail(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getDisplayName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, (Parcelable)getPhotoUrl(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 7, getServerAuthCode(), false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zak);
    SafeParcelWriter.writeString(paramParcel, 9, this.zal, false);
    SafeParcelWriter.writeTypedList(paramParcel, 10, this.zam, false);
    SafeParcelWriter.writeString(paramParcel, 11, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 12, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  @NonNull
  public final String zab() {
    return this.zal;
  }
  
  public final String zac() {
    JSONObject jSONObject = zad();
    jSONObject.remove("serverAuthCode");
    return jSONObject.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */