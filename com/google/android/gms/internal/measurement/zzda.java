package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzda extends zzcw<Double> {
  zzda(zzdc paramzzdc, String paramString, Double paramDouble) {
    super(paramzzdc, paramString, paramDouble, null);
  }
  
  private final Double zzf(Object paramObject) {
    if (paramObject instanceof Double)
      return (Double)paramObject; 
    if (paramObject instanceof Float)
      return Double.valueOf(((Float)paramObject).doubleValue()); 
    if (paramObject instanceof String)
      try {
        double d = Double.parseDouble((String)paramObject);
        return Double.valueOf(d);
      } catch (NumberFormatException numberFormatException) {} 
    String str = zzjq();
    paramObject = String.valueOf(paramObject);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(paramObject).length());
    stringBuilder.append("Invalid double value for ");
    stringBuilder.append(str);
    stringBuilder.append(": ");
    stringBuilder.append((String)paramObject);
    Log.e("PhenotypeFlag", stringBuilder.toString());
    return null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */