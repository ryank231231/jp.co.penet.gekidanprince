package com.google.android.gms.phenotype;

import android.content.SharedPreferences;
import android.util.Log;

final class zzs extends PhenotypeFlag<String> {
  zzs(PhenotypeFlag.Factory paramFactory, String paramString1, String paramString2) {
    super(paramFactory, paramString1, paramString2, null);
  }
  
  private final String zzb(SharedPreferences paramSharedPreferences) {
    try {
      return paramSharedPreferences.getString(this.zzap, null);
    } catch (ClassCastException classCastException) {
      String str = String.valueOf(this.zzap);
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\phenotype\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */