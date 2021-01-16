package com.google.firebase.iid;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class zzax {
  private static final long zzdh = TimeUnit.DAYS.toMillis(7L);
  
  private final long timestamp;
  
  final String zzbr;
  
  private final String zzdi;
  
  private zzax(String paramString1, String paramString2, long paramLong) {
    this.zzbr = paramString1;
    this.zzdi = paramString2;
    this.timestamp = paramLong;
  }
  
  static String zza(String paramString1, String paramString2, long paramLong) {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("token", paramString1);
      jSONObject.put("appVersion", paramString2);
      jSONObject.put("timestamp", paramLong);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      paramString2 = String.valueOf(jSONException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 24);
      stringBuilder.append("Failed to encode token: ");
      stringBuilder.append(paramString2);
      Log.w("FirebaseInstanceId", stringBuilder.toString());
      return null;
    } 
  }
  
  static String zzb(@Nullable zzax paramzzax) {
    return (paramzzax == null) ? null : paramzzax.zzbr;
  }
  
  static zzax zzi(String paramString) {
    String str;
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (paramString.startsWith("{"))
      try {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        return new zzax(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
      } catch (JSONException jSONException) {
        str = String.valueOf(jSONException);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 23);
        stringBuilder.append("Failed to parse token: ");
        stringBuilder.append(str);
        Log.w("FirebaseInstanceId", stringBuilder.toString());
        return null;
      }  
    return new zzax(str, null, 0L);
  }
  
  final boolean zzj(String paramString) {
    return (System.currentTimeMillis() > this.timestamp + zzdh || !paramString.equals(this.zzdi));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */