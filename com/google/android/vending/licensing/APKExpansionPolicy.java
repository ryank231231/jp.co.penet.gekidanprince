package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class APKExpansionPolicy implements Policy {
  private static final String DEFAULT_MAX_RETRIES = "0";
  
  private static final String DEFAULT_RETRY_COUNT = "0";
  
  private static final String DEFAULT_RETRY_UNTIL = "0";
  
  private static final String DEFAULT_VALIDITY_TIMESTAMP = "0";
  
  public static final int MAIN_FILE_URL_INDEX = 0;
  
  private static final long MILLIS_PER_MINUTE = 60000L;
  
  public static final int PATCH_FILE_URL_INDEX = 1;
  
  private static final String PREFS_FILE = "com.android.vending.licensing.APKExpansionPolicy";
  
  private static final String PREF_LAST_RESPONSE = "lastResponse";
  
  private static final String PREF_MAX_RETRIES = "maxRetries";
  
  private static final String PREF_RETRY_COUNT = "retryCount";
  
  private static final String PREF_RETRY_UNTIL = "retryUntil";
  
  private static final String PREF_VALIDITY_TIMESTAMP = "validityTimestamp";
  
  private static final String TAG = "APKExpansionPolicy";
  
  private Vector<String> mExpansionFileNames = new Vector<String>();
  
  private Vector<Long> mExpansionFileSizes = new Vector<Long>();
  
  private Vector<String> mExpansionURLs = new Vector<String>();
  
  private int mLastResponse;
  
  private long mLastResponseTime = 0L;
  
  private long mMaxRetries;
  
  private PreferenceObfuscator mPreferences;
  
  private long mRetryCount;
  
  private long mRetryUntil;
  
  private long mValidityTimestamp;
  
  public APKExpansionPolicy(Context paramContext, Obfuscator paramObfuscator) {
    this.mPreferences = new PreferenceObfuscator(paramContext.getSharedPreferences("com.android.vending.licensing.APKExpansionPolicy", 0), paramObfuscator);
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
      for (NameValuePair nameValuePair : URLEncodedUtils.parse(uRI, "UTF-8")) {
        String str;
        paramString = nameValuePair.getName();
        byte b = 0;
        while (hashMap.containsKey(paramString)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append(nameValuePair.getName());
          stringBuilder1.append(++b);
          str = stringBuilder1.toString();
        } 
        hashMap.put(str, nameValuePair.getValue());
      } 
    } catch (URISyntaxException uRISyntaxException) {
      Log.w("APKExpansionPolicy", "Invalid syntax error while decoding extras data from server.");
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
      Log.w("APKExpansionPolicy", "Licence retry count (GR) missing, grace period disabled");
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
      Log.w("APKExpansionPolicy", "License retry timestamp (GT) missing, grace period disabled");
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
      Log.w("APKExpansionPolicy", "License validity timestamp (VT) missing, caching for a minute");
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
  
  public String getExpansionFileName(int paramInt) {
    return (paramInt < this.mExpansionFileNames.size()) ? this.mExpansionFileNames.elementAt(paramInt) : null;
  }
  
  public long getExpansionFileSize(int paramInt) {
    return (paramInt < this.mExpansionFileSizes.size()) ? ((Long)this.mExpansionFileSizes.elementAt(paramInt)).longValue() : -1L;
  }
  
  public String getExpansionURL(int paramInt) {
    return (paramInt < this.mExpansionURLs.size()) ? this.mExpansionURLs.elementAt(paramInt) : null;
  }
  
  public int getExpansionURLCount() {
    return this.mExpansionURLs.size();
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
      setValidityTimestamp(Long.toString(System.currentTimeMillis() + 60000L));
      for (String str : map.keySet()) {
        if (str.equals("VT")) {
          setValidityTimestamp(map.get(str));
          continue;
        } 
        if (str.equals("GT")) {
          setRetryUntil(map.get(str));
          continue;
        } 
        if (str.equals("GR")) {
          setMaxRetries(map.get(str));
          continue;
        } 
        if (str.startsWith("FILE_URL")) {
          setExpansionURL(Integer.parseInt(str.substring(8)) - 1, map.get(str));
          continue;
        } 
        if (str.startsWith("FILE_NAME")) {
          setExpansionFileName(Integer.parseInt(str.substring(9)) - 1, map.get(str));
          continue;
        } 
        if (str.startsWith("FILE_SIZE"))
          setExpansionFileSize(Integer.parseInt(str.substring(9)) - 1, Long.parseLong(map.get(str))); 
      } 
    } else if (paramInt == 561) {
      setValidityTimestamp("0");
      setRetryUntil("0");
      setMaxRetries("0");
    } 
    setLastResponse(paramInt);
    this.mPreferences.commit();
  }
  
  public void resetPolicy() {
    this.mPreferences.putString("lastResponse", Integer.toString(291));
    setRetryUntil("0");
    setMaxRetries("0");
    setRetryCount(Long.parseLong("0"));
    setValidityTimestamp("0");
    this.mPreferences.commit();
  }
  
  public void setExpansionFileName(int paramInt, String paramString) {
    if (paramInt >= this.mExpansionFileNames.size())
      this.mExpansionFileNames.setSize(paramInt + 1); 
    this.mExpansionFileNames.set(paramInt, paramString);
  }
  
  public void setExpansionFileSize(int paramInt, long paramLong) {
    if (paramInt >= this.mExpansionFileSizes.size())
      this.mExpansionFileSizes.setSize(paramInt + 1); 
    this.mExpansionFileSizes.set(paramInt, Long.valueOf(paramLong));
  }
  
  public void setExpansionURL(int paramInt, String paramString) {
    if (paramInt >= this.mExpansionURLs.size())
      this.mExpansionURLs.setSize(paramInt + 1); 
    this.mExpansionURLs.set(paramInt, paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\vending\licensing\APKExpansionPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */