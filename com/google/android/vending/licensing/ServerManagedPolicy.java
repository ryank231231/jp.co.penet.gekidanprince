package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class ServerManagedPolicy implements Policy {
  private static final String DEFAULT_MAX_RETRIES = "0";
  
  private static final String DEFAULT_RETRY_COUNT = "0";
  
  private static final String DEFAULT_RETRY_UNTIL = "0";
  
  private static final String DEFAULT_VALIDITY_TIMESTAMP = "0";
  
  private static final long MILLIS_PER_MINUTE = 60000L;
  
  private static final String PREFS_FILE = "com.android.vending.licensing.ServerManagedPolicy";
  
  private static final String PREF_LAST_RESPONSE = "lastResponse";
  
  private static final String PREF_MAX_RETRIES = "maxRetries";
  
  private static final String PREF_RETRY_COUNT = "retryCount";
  
  private static final String PREF_RETRY_UNTIL = "retryUntil";
  
  private static final String PREF_VALIDITY_TIMESTAMP = "validityTimestamp";
  
  private static final String TAG = "ServerManagedPolicy";
  
  private int mLastResponse;
  
  private long mLastResponseTime = 0L;
  
  private long mMaxRetries;
  
  private PreferenceObfuscator mPreferences;
  
  private long mRetryCount;
  
  private long mRetryUntil;
  
  private long mValidityTimestamp;
  
  public ServerManagedPolicy(Context paramContext, Obfuscator paramObfuscator) {
    this.mPreferences = new PreferenceObfuscator(paramContext.getSharedPreferences("com.android.vending.licensing.ServerManagedPolicy", 0), paramObfuscator);
    this.mLastResponse = Integer.parseInt(this.mPreferences.getString("lastResponse", Integer.toString(291)));
    this.mValidityTimestamp = Long.parseLong(this.mPreferences.getString("validityTimestamp", "0"));
    this.mRetryUntil = Long.parseLong(this.mPreferences.getString("retryUntil", "0"));
    this.mMaxRetries = Long.parseLong(this.mPreferences.getString("maxRetries", "0"));
    this.mRetryCount = Long.parseLong(this.mPreferences.getString("retryCount", "0"));
  }
  
  private Map<String, String> decodeExtras(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      URI uRI = new URI();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("?");
      stringBuilder.append(paramString);
      this(stringBuilder.toString());
      for (NameValuePair nameValuePair : URLEncodedUtils.parse(uRI, "UTF-8"))
        hashMap.put(nameValuePair.getName(), nameValuePair.getValue()); 
    } catch (URISyntaxException uRISyntaxException) {
      Log.w("ServerManagedPolicy", "Invalid syntax error while decoding extras data from server.");
    } 
    return (Map)hashMap;
  }
  
  private void setLastResponse(int paramInt) {
    this.mLastResponseTime = System.currentTimeMillis();
    this.mLastResponse = paramInt;
    this.mPreferences.putString("lastResponse", Integer.toString(paramInt));
  }
  
  private void setMaxRetries(String paramString) {
    String str;
    Long long_;
    try {
      long_ = Long.valueOf(Long.parseLong(paramString));
    } catch (NumberFormatException numberFormatException) {
      Log.w("ServerManagedPolicy", "Licence retry count (GR) missing, grace period disabled");
      str = "0";
      long_ = Long.valueOf(0L);
    } 
    this.mMaxRetries = long_.longValue();
    this.mPreferences.putString("maxRetries", str);
  }
  
  private void setRetryCount(long paramLong) {
    this.mRetryCount = paramLong;
    this.mPreferences.putString("retryCount", Long.toString(paramLong));
  }
  
  private void setRetryUntil(String paramString) {
    String str;
    Long long_;
    try {
      long_ = Long.valueOf(Long.parseLong(paramString));
    } catch (NumberFormatException numberFormatException) {
      Log.w("ServerManagedPolicy", "License retry timestamp (GT) missing, grace period disabled");
      str = "0";
      long_ = Long.valueOf(0L);
    } 
    this.mRetryUntil = long_.longValue();
    this.mPreferences.putString("retryUntil", str);
  }
  
  private void setValidityTimestamp(String paramString) {
    String str;
    Long long_;
    try {
      long_ = Long.valueOf(Long.parseLong(paramString));
    } catch (NumberFormatException numberFormatException) {
      Log.w("ServerManagedPolicy", "License validity timestamp (VT) missing, caching for a minute");
      long_ = Long.valueOf(System.currentTimeMillis() + 60000L);
      str = Long.toString(long_.longValue());
    } 
    this.mValidityTimestamp = long_.longValue();
    this.mPreferences.putString("validityTimestamp", str);
  }
  
  public boolean allowAccess() {
    long l = System.currentTimeMillis();
    int i = this.mLastResponse;
    boolean bool = true;
    if (i == 256) {
      if (l <= this.mValidityTimestamp)
        return true; 
    } else if (i == 291 && l < this.mLastResponseTime + 60000L) {
      boolean bool1 = bool;
      if (l > this.mRetryUntil)
        if (this.mRetryCount <= this.mMaxRetries) {
          bool1 = bool;
        } else {
          bool1 = false;
        }  
      return bool1;
    } 
    return false;
  }
  
  public long getMaxRetries() {
    return this.mMaxRetries;
  }
  
  public long getRetryCount() {
    return this.mRetryCount;
  }
  
  public long getRetryUntil() {
    return this.mRetryUntil;
  }
  
  public long getValidityTimestamp() {
    return this.mValidityTimestamp;
  }
  
  public void processServerResponse(int paramInt, ResponseData paramResponseData) {
    if (paramInt != 291) {
      setRetryCount(0L);
    } else {
      setRetryCount(this.mRetryCount + 1L);
    } 
    if (paramInt == 256) {
      Map<String, String> map = decodeExtras(paramResponseData.extra);
      this.mLastResponse = paramInt;
      setValidityTimestamp(map.get("VT"));
      setRetryUntil(map.get("GT"));
      setMaxRetries(map.get("GR"));
    } else if (paramInt == 561) {
      setValidityTimestamp("0");
      setRetryUntil("0");
      setMaxRetries("0");
    } 
    setLastResponse(paramInt);
    this.mPreferences.commit();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\vending\licensing\ServerManagedPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */