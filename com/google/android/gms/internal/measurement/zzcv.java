package com.google.android.gms.internal.measurement;

import android.net.Uri;

public final class zzcv {
  public static Uri zzcd(String paramString) {
    paramString = String.valueOf(Uri.encode(paramString));
    if (paramString.length() != 0) {
      paramString = "content://com.google.android.gms.phenotype/".concat(paramString);
    } else {
      paramString = new String("content://com.google.android.gms.phenotype/");
    } 
    return Uri.parse(paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */