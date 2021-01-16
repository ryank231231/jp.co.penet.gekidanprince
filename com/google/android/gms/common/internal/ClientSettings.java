package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings {
  public static final String KEY_CLIENT_SESSION_ID = "com.google.android.gms.common.internal.ClientSettings.sessionId";
  
  private final Set<Scope> zabr;
  
  private final int zabt;
  
  private final View zabu;
  
  private final String zabv;
  
  private final String zabw;
  
  private final Set<Scope> zaoa;
  
  private final Map<Api<?>, OptionalApiSettings> zaob;
  
  private final SignInOptions zaoc;
  
  private Integer zaod;
  
  private final Account zax;
  
  public ClientSettings(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, OptionalApiSettings> paramMap, int paramInt, View paramView, String paramString1, String paramString2, SignInOptions paramSignInOptions) {
    Set<Scope> set;
    this.zax = paramAccount;
    if (paramSet == null) {
      set = Collections.EMPTY_SET;
    } else {
      set = Collections.unmodifiableSet(paramSet);
    } 
    this.zabr = set;
    Map<Api<?>, OptionalApiSettings> map = paramMap;
    if (paramMap == null)
      map = Collections.EMPTY_MAP; 
    this.zaob = map;
    this.zabu = paramView;
    this.zabt = paramInt;
    this.zabv = paramString1;
    this.zabw = paramString2;
    this.zaoc = paramSignInOptions;
    paramSet = new HashSet<Scope>(this.zabr);
    Iterator iterator = this.zaob.values().iterator();
    while (iterator.hasNext())
      paramSet.addAll(((OptionalApiSettings)iterator.next()).mScopes); 
    this.zaoa = Collections.unmodifiableSet(paramSet);
  }
  
  @KeepForSdk
  public static ClientSettings createDefault(Context paramContext) {
    return (new GoogleApiClient.Builder(paramContext)).buildClientSettings();
  }
  
  @Nullable
  @KeepForSdk
  public final Account getAccount() {
    return this.zax;
  }
  
  @Deprecated
  @Nullable
  @KeepForSdk
  public final String getAccountName() {
    Account account = this.zax;
    return (account != null) ? account.name : null;
  }
  
  @KeepForSdk
  public final Account getAccountOrDefault() {
    Account account = this.zax;
    return (account != null) ? account : new Account("<<default account>>", "com.google");
  }
  
  @KeepForSdk
  public final Set<Scope> getAllRequestedScopes() {
    return this.zaoa;
  }
  
  @KeepForSdk
  public final Set<Scope> getApplicableScopes(Api<?> paramApi) {
    OptionalApiSettings optionalApiSettings = this.zaob.get(paramApi);
    if (optionalApiSettings == null || optionalApiSettings.mScopes.isEmpty())
      return this.zabr; 
    HashSet<Scope> hashSet = new HashSet<Scope>(this.zabr);
    hashSet.addAll(optionalApiSettings.mScopes);
    return hashSet;
  }
  
  @Nullable
  public final Integer getClientSessionId() {
    return this.zaod;
  }
  
  @KeepForSdk
  public final int getGravityForPopups() {
    return this.zabt;
  }
  
  public final Map<Api<?>, OptionalApiSettings> getOptionalApiSettings() {
    return this.zaob;
  }
  
  @Nullable
  public final String getRealClientClassName() {
    return this.zabw;
  }
  
  @Nullable
  @KeepForSdk
  public final String getRealClientPackageName() {
    return this.zabv;
  }
  
  @KeepForSdk
  public final Set<Scope> getRequiredScopes() {
    return this.zabr;
  }
  
  @Nullable
  public final SignInOptions getSignInOptions() {
    return this.zaoc;
  }
  
  @Nullable
  @KeepForSdk
  public final View getViewForPopups() {
    return this.zabu;
  }
  
  public final void setClientSessionId(Integer paramInteger) {
    this.zaod = paramInteger;
  }
  
  @KeepForSdk
  public static final class Builder {
    private int zabt = 0;
    
    private View zabu;
    
    private String zabv;
    
    private String zabw;
    
    private Map<Api<?>, ClientSettings.OptionalApiSettings> zaob;
    
    private SignInOptions zaoc = SignInOptions.DEFAULT;
    
    private ArraySet<Scope> zaoe;
    
    private Account zax;
    
    public final Builder addAllRequiredScopes(Collection<Scope> param1Collection) {
      if (this.zaoe == null)
        this.zaoe = new ArraySet(); 
      this.zaoe.addAll(param1Collection);
      return this;
    }
    
    public final Builder addRequiredScope(Scope param1Scope) {
      if (this.zaoe == null)
        this.zaoe = new ArraySet(); 
      this.zaoe.add(param1Scope);
      return this;
    }
    
    @KeepForSdk
    public final ClientSettings build() {
      return new ClientSettings(this.zax, (Set<Scope>)this.zaoe, this.zaob, this.zabt, this.zabu, this.zabv, this.zabw, this.zaoc);
    }
    
    public final Builder setAccount(Account param1Account) {
      this.zax = param1Account;
      return this;
    }
    
    public final Builder setGravityForPopups(int param1Int) {
      this.zabt = param1Int;
      return this;
    }
    
    public final Builder setOptionalApiSettingsMap(Map<Api<?>, ClientSettings.OptionalApiSettings> param1Map) {
      this.zaob = param1Map;
      return this;
    }
    
    public final Builder setRealClientClassName(String param1String) {
      this.zabw = param1String;
      return this;
    }
    
    @KeepForSdk
    public final Builder setRealClientPackageName(String param1String) {
      this.zabv = param1String;
      return this;
    }
    
    public final Builder setSignInOptions(SignInOptions param1SignInOptions) {
      this.zaoc = param1SignInOptions;
      return this;
    }
    
    public final Builder setViewForPopups(View param1View) {
      this.zabu = param1View;
      return this;
    }
  }
  
  public static final class OptionalApiSettings {
    public final Set<Scope> mScopes;
    
    public OptionalApiSettings(Set<Scope> param1Set) {
      Preconditions.checkNotNull(param1Set);
      this.mScopes = Collections.unmodifiableSet(param1Set);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\ClientSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */