package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzcx extends zzcw<Long> {
  zzcx(zzdc paramzzdc, String paramString, Long paramLong) {
    super(paramzzdc, paramString, paramLong, null);
  }
  
  private final Long zzd(Object paramObject) {
    if (paramObject instanceof Long)
      return (Long)paramObject; 
    if (paramObject instanceof String)
      try {
        long l = Long.parseLong((String)paramObject);
        return Long.valueOf(l);
      } catch (NumberFormatException numberFormatException) {} 
    String str = zzjq();
    paramObject = String.valueOf(paramObject);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(paramObject).length());
    stringBuilder.append("Invalid long value for ");
    stringBuilder.append(str);
    stringBuilder.append(": ");
    stringBuilder.append((String)paramObject);
    Log.e("PhenotypeFlag", stringBuilder.toString());
    return null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */