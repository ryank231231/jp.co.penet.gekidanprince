package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

final class zzak extends zzae<String> {
  zzak(zzao paramzzao, String paramString1, String paramString2) {
    super(paramzzao, paramString1, paramString2, null);
  }
  
  private final String zzc(SharedPreferences paramSharedPreferences) {
    try {
      return paramSharedPreferences.getString(this.zzds, null);
    } catch (ClassCastException classCastException) {
      String str = String.valueOf(this.zzds);
      if (str.length() != 0) {
        str = "Invalid string value in SharedPreferences for ".concat(str);
      } else {
        str = new String("Invalid string value in SharedPreferences for ");
      } 
      Log.e("PhenotypeFlag", str, classCastException);
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */