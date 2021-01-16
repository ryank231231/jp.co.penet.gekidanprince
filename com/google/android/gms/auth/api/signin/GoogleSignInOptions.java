package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
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
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
  
  public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
  
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  
  private static Comparator<Scope> zaaf;
  
  @VisibleForTesting
  public static final Scope zar = new Scope("profile");
  
  @VisibleForTesting
  public static final Scope zas = new Scope("email");
  
  @VisibleForTesting
  public static final Scope zat = new Scope("openid");
  
  @VisibleForTesting
  public static final Scope zau = new Scope("https://www.googleapis.com/auth/games_lite");
  
  @VisibleForTesting
  public static final Scope zav = new Scope("https://www.googleapis.com/auth/games");
  
  @VersionField(id = 1)
  private final int versionCode;
  
  @Field(getter = "isForceCodeForRefreshToken", id = 6)
  private final boolean zaaa;
  
  @Field(getter = "getServerClientId", id = 7)
  private String zaab;
  
  @Field(getter = "getHostedDomain", id = 8)
  private String zaac;
  
  @Field(getter = "getExtensions", id = 9)
  private ArrayList<GoogleSignInOptionsExtensionParcelable> zaad;
  
  private Map<Integer, GoogleSignInOptionsExtensionParcelable> zaae;
  
  @Field(getter = "getScopes", id = 2)
  private final ArrayList<Scope> zaw;
  
  @Field(getter = "getAccount", id = 3)
  private Account zax;
  
  @Field(getter = "isIdTokenRequested", id = 4)
  private boolean zay;
  
  @Field(getter = "isServerAuthCodeRequested", id = 5)
  private final boolean zaz;
  
  static {
    DEFAULT_SIGN_IN = (new Builder()).requestId().requestProfile().build();
    DEFAULT_GAMES_SIGN_IN = (new Builder()).requestScopes(zau, new Scope[0]).build();
    CREATOR = new zad();
    zaaf = new zac();
  }
  
  @Constructor
  GoogleSignInOptions(@Param(id = 1) int paramInt, @Param(id = 2) ArrayList<Scope> paramArrayList, @Param(id = 3) Account paramAccount, @Param(id = 4) boolean paramBoolean1, @Param(id = 5) boolean paramBoolean2, @Param(id = 6) boolean paramBoolean3, @Param(id = 7) String paramString1, @Param(id = 8) String paramString2, @Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> paramArrayList1) {
    this(paramInt, paramArrayList, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, zaa(paramArrayList1));
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map<Integer, GoogleSignInOptionsExtensionParcelable> paramMap) {
    this.versionCode = paramInt;
    this.zaw = paramArrayList;
    this.zax = paramAccount;
    this.zay = paramBoolean1;
    this.zaz = paramBoolean2;
    this.zaaa = paramBoolean3;
    this.zaab = paramString1;
    this.zaac = paramString2;
    this.zaad = new ArrayList<GoogleSignInOptionsExtensionParcelable>(paramMap.values());
    this.zaae = paramMap;
  }
  
  private static Map<Integer, GoogleSignInOptionsExtensionParcelable> zaa(@Nullable List<GoogleSignInOptionsExtensionParcelable> paramList) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramList == null)
      return (Map)hashMap; 
    for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : paramList)
      hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable); 
    return (Map)hashMap;
  }
  
  @Nullable
  public static GoogleSignInOptions zab(@Nullable String paramString) throws JSONException {
    if (TextUtils.isEmpty(paramString))
      return null; 
    JSONObject jSONObject = new JSONObject(paramString);
    HashSet<Scope> hashSet = new HashSet();
    JSONArray jSONArray = jSONObject.getJSONArray("scopes");
    int i = jSONArray.length();
    for (byte b = 0; b < i; b++)
      hashSet.add(new Scope(jSONArray.getString(b))); 
    String str = jSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(str)) {
      Account account = new Account(str, "com.google");
    } else {
      str = null;
    } 
    return new GoogleSignInOptions(3, new ArrayList<Scope>(hashSet), (Account)str, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>());
  }
  
  private final JSONObject zad() {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONArray jSONArray = new JSONArray();
      this();
      Collections.sort(this.zaw, zaaf);
      ArrayList<Scope> arrayList = this.zaw;
      int i = arrayList.size();
      byte b = 0;
      while (b < i) {
        Scope scope = (Scope)arrayList.get(b);
        b++;
        jSONArray.put(((Scope)scope).getScopeUri());
      } 
      jSONObject.put("scopes", jSONArray);
      if (this.zax != null)
        jSONObject.put("accountName", this.zax.name); 
      jSONObject.put("idTokenRequested", this.zay);
      jSONObject.put("forceCodeForRefreshToken", this.zaaa);
      jSONObject.put("serverAuthRequested", this.zaz);
      if (!TextUtils.isEmpty(this.zaab))
        jSONObject.put("serverClientId", this.zaab); 
      if (!TextUtils.isEmpty(this.zaac))
        jSONObject.put("hostedDomain", this.zaac); 
      return jSONObject;
    } catch (JSONException jSONException) {
      throw new RuntimeException(jSONException);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    try {
      paramObject = paramObject;
      if (this.zaad.size() > 0 || ((GoogleSignInOptions)paramObject).zaad.size() > 0)
        return false; 
      if (this.zaw.size() != paramObject.getScopes().size() || !this.zaw.containsAll(paramObject.getScopes()))
        return false; 
      if (((this.zax == null) ? (paramObject.getAccount() == null) : this.zax.equals(paramObject.getAccount())) && (TextUtils.isEmpty(this.zaab) ? TextUtils.isEmpty(paramObject.getServerClientId()) : this.zaab.equals(paramObject.getServerClientId())) && this.zaaa == paramObject.isForceCodeForRefreshToken() && this.zay == paramObject.isIdTokenRequested()) {
        boolean bool1 = this.zaz;
        boolean bool2 = paramObject.isServerAuthCodeRequested();
        if (bool1 == bool2)
          return true; 
      } 
      return false;
    } catch (ClassCastException classCastException) {
      return false;
    } 
  }
  
  @KeepForSdk
  public Account getAccount() {
    return this.zax;
  }
  
  @KeepForSdk
  public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
    return this.zaad;
  }
  
  public Scope[] getScopeArray() {
    ArrayList<Scope> arrayList = this.zaw;
    return arrayList.<Scope>toArray(new Scope[arrayList.size()]);
  }
  
  @KeepForSdk
  public ArrayList<Scope> getScopes() {
    return new ArrayList<Scope>(this.zaw);
  }
  
  @KeepForSdk
  public String getServerClientId() {
    return this.zaab;
  }
  
  public int hashCode() {
    ArrayList<String> arrayList = new ArrayList();
    ArrayList<Scope> arrayList1 = this.zaw;
    int i = arrayList1.size();
    byte b = 0;
    while (b < i) {
      Scope scope = (Scope)arrayList1.get(b);
      b++;
      arrayList.add(((Scope)scope).getScopeUri());
    } 
    Collections.sort(arrayList);
    return (new HashAccumulator()).addObject(arrayList).addObject(this.zax).addObject(this.zaab).zaa(this.zaaa).zaa(this.zay).zaa(this.zaz).hash();
  }
  
  @KeepForSdk
  public boolean isForceCodeForRefreshToken() {
    return this.zaaa;
  }
  
  @KeepForSdk
  public boolean isIdTokenRequested() {
    return this.zay;
  }
  
  @KeepForSdk
  public boolean isServerAuthCodeRequested() {
    return this.zaz;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getScopes(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)getAccount(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, isIdTokenRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isServerAuthCodeRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isForceCodeForRefreshToken());
    SafeParcelWriter.writeString(paramParcel, 7, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zaac, false);
    SafeParcelWriter.writeTypedList(paramParcel, 9, getExtensions(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final String zae() {
    return zad().toString();
  }
  
  public static final class Builder {
    private Set<Scope> mScopes = new HashSet<Scope>();
    
    private boolean zaaa;
    
    private String zaab;
    
    private String zaac;
    
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zaag = new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>();
    
    private Account zax;
    
    private boolean zay;
    
    private boolean zaz;
    
    public Builder() {}
    
    public Builder(@NonNull GoogleSignInOptions param1GoogleSignInOptions) {
      Preconditions.checkNotNull(param1GoogleSignInOptions);
      this.mScopes = new HashSet<Scope>(GoogleSignInOptions.zaa(param1GoogleSignInOptions));
      this.zaz = GoogleSignInOptions.zab(param1GoogleSignInOptions);
      this.zaaa = GoogleSignInOptions.zac(param1GoogleSignInOptions);
      this.zay = GoogleSignInOptions.zad(param1GoogleSignInOptions);
      this.zaab = GoogleSignInOptions.zae(param1GoogleSignInOptions);
      this.zax = GoogleSignInOptions.zaf(param1GoogleSignInOptions);
      this.zaac = GoogleSignInOptions.zag(param1GoogleSignInOptions);
      this.zaag = GoogleSignInOptions.zab(GoogleSignInOptions.zah(param1GoogleSignInOptions));
    }
    
    private final String zac(String param1String) {
      Preconditions.checkNotEmpty(param1String);
      String str = this.zaab;
      if (str == null || str.equals(param1String)) {
        boolean bool1 = true;
        Preconditions.checkArgument(bool1, "two different server client ids provided");
        return param1String;
      } 
      boolean bool = false;
      Preconditions.checkArgument(bool, "two different server client ids provided");
      return param1String;
    }
    
    public final Builder addExtension(GoogleSignInOptionsExtension param1GoogleSignInOptionsExtension) {
      if (!this.zaag.containsKey(Integer.valueOf(param1GoogleSignInOptionsExtension.getExtensionType()))) {
        if (param1GoogleSignInOptionsExtension.getImpliedScopes() != null)
          this.mScopes.addAll(param1GoogleSignInOptionsExtension.getImpliedScopes()); 
        this.zaag.put(Integer.valueOf(param1GoogleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(param1GoogleSignInOptionsExtension));
        return this;
      } 
      throw new IllegalStateException("Only one extension per type may be added");
    }
    
    public final GoogleSignInOptions build() {
      if (this.mScopes.contains(GoogleSignInOptions.zav) && this.mScopes.contains(GoogleSignInOptions.zau))
        this.mScopes.remove(GoogleSignInOptions.zau); 
      if (this.zay && (this.zax == null || !this.mScopes.isEmpty()))
        requestId(); 
      return new GoogleSignInOptions(3, new ArrayList<Scope>(this.mScopes), this.zax, this.zay, this.zaz, this.zaaa, this.zaab, this.zaac, this.zaag, null);
    }
    
    public final Builder requestEmail() {
      this.mScopes.add(GoogleSignInOptions.zas);
      return this;
    }
    
    public final Builder requestId() {
      this.mScopes.add(GoogleSignInOptions.zat);
      return this;
    }
    
    public final Builder requestIdToken(String param1String) {
      this.zay = true;
      this.zaab = zac(param1String);
      return this;
    }
    
    public final Builder requestProfile() {
      this.mScopes.add(GoogleSignInOptions.zar);
      return this;
    }
    
    public final Builder requestScopes(Scope param1Scope, Scope... param1VarArgs) {
      this.mScopes.add(param1Scope);
      this.mScopes.addAll(Arrays.asList(param1VarArgs));
      return this;
    }
    
    public final Builder requestServerAuthCode(String param1String) {
      return requestServerAuthCode(param1String, false);
    }
    
    public final Builder requestServerAuthCode(String param1String, boolean param1Boolean) {
      this.zaz = true;
      this.zaab = zac(param1String);
      this.zaaa = param1Boolean;
      return this;
    }
    
    public final Builder setAccountName(String param1String) {
      this.zax = new Account(Preconditions.checkNotEmpty(param1String), "com.google");
      return this;
    }
    
    public final Builder setHostedDomain(String param1String) {
      this.zaac = Preconditions.checkNotEmpty(param1String);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */