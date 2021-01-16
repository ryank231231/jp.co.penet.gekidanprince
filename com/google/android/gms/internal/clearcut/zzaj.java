package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

final class zzaj extends zzae<Boolean> {
  zzaj(zzao paramzzao, String paramString, Boolean paramBoolean) {
    super(paramzzao, paramString, paramBoolean, null);
  }
  
  private final Boolean zzb(SharedPreferences paramSharedPreferences) {
    try {
      boolean bool = paramSharedPreferences.getBoolean(this.zzds, false);
      return Boolean.valueOf(bool);
    } catch (ClassCastException classCastException) {
      String str = String.valueOf(this.zzds);
      if (str.length() != 0) {
        str = "Invalid boolean value in SharedPreferences for ".concat(str);
      } else {
        str = new String("Invalid boolean value in SharedPreferences for ");
      } 
      Log.e("PhenotypeFlag", str, classCastException);
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */