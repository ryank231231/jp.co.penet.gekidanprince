package com.google.firebase.auth;

import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.annotations.PublicApi;
import java.util.Map;

@PublicApi
public class GetTokenResult {
  private static final String AUTH_TIMESTAMP = "auth_time";
  
  private static final String EXPIRATION_TIMESTAMP = "exp";
  
  private static final String FIREBASE_KEY = "firebase";
  
  private static final String ISSUED_AT_TIMESTAMP = "iat";
  
  private static final String SIGN_IN_PROVIDER = "sign_in_provider";
  
  private Map<String, Object> claims;
  
  private String token;
  
  @KeepForSdk
  public GetTokenResult(String paramString, Map<String, Object> paramMap) {
    this.token = paramString;
    this.claims = paramMap;
  }
  
  private long getLongFromClaimsSafely(String paramString) {
    long l;
    Integer integer = (Integer)this.claims.get(paramString);
    if (integer == null) {
      l = 0L;
    } else {
      l = integer.longValue();
    } 
    return l;
  }
  
  @PublicApi
  public long getAuthTimestamp() {
    return getLongFromClaimsSafely("auth_time");
  }
  
  @PublicApi
  public Map<String, Object> getClaims() {
    return this.claims;
  }
  
  @PublicApi
  public long getExpirationTimestamp() {
    return getLongFromClaimsSafely("exp");
  }
  
  @PublicApi
  public long getIssuedAtTimestamp() {
    return getLongFromClaimsSafely("iat");
  }
  
  @Nullable
  @PublicApi
  public String getSignInProvider() {
    Map map = (Map)this.claims.get("firebase");
    return (map != null) ? (String)map.get("sign_in_provider") : null;
  }
  
  @Nullable
  @PublicApi
  public String getToken() {
    return this.token;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\auth\GetTokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */