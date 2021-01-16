package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;

final class zzal extends zzae<T> {
  private final Object lock = new Object();
  
  private String zzec;
  
  private T zzed;
  
  zzal(zzao paramzzao, String paramString, Object paramObject, zzan paramzzan) {
    super(paramzzao, paramString, paramObject, null);
  }
  
  protected final T zza(SharedPreferences paramSharedPreferences) {
    try {
      return super.zzb(paramSharedPreferences.getString(this.zzds, ""));
    } catch (ClassCastException classCastException) {
      String str = String.valueOf(this.zzds);
      if (str.length() != 0) {
        str = "Invalid byte[] value in SharedPreferences for ".concat(str);
      } else {
        str = new String("Invalid byte[] value in SharedPreferences for ");
      } 
      Log.e("PhenotypeFlag", str, classCastException);
      return null;
    } 
  }
  
  protected final T zzb(String paramString) {
    try {
      synchronized (this.lock) {
        if (!paramString.equals(this.zzec)) {
          T t = (T)this.zzee.zzb(Base64.decode(paramString, 3));
          this.zzec = paramString;
          this.zzed = t;
        } 
        return this.zzed;
      } 
    } catch (IOException|IllegalArgumentException iOException) {
      String str = this.zzds;
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(paramString).length());
      stringBuilder.append("Invalid byte[] value for ");
      stringBuilder.append(str);
      stringBuilder.append(": ");
      stringBuilder.append(paramString);
      Log.e("PhenotypeFlag", stringBuilder.toString());
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */