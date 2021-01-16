package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzcy extends zzcw<Integer> {
  zzcy(zzdc paramzzdc, String paramString, Integer paramInteger) {
    super(paramzzdc, paramString, paramInteger, null);
  }
  
  private final Integer zze(Object paramObject) {
    if (paramObject instanceof Integer)
      return (Integer)paramObject; 
    if (paramObject instanceof Long)
      return Integer.valueOf(((Long)paramObject).intValue()); 
    if (paramObject instanceof String)
      try {
        int i = Integer.parseInt((String)paramObject);
        return Integer.valueOf(i);
      } catch (NumberFormatException numberFormatException) {} 
    String str = zzjq();
    paramObject = String.valueOf(paramObject);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(paramObject).length());
    stringBuilder.append("Invalid int value for ");
    stringBuilder.append(str);
    stringBuilder.append(": ");
    stringBuilder.append((String)paramObject);
    Log.e("PhenotypeFlag", stringBuilder.toString());
    return null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */