package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;

public final class zzcw {
  public static <T> T zza(@NonNull Bundle paramBundle, String paramString, Class<T> paramClass, T paramT) {
    Object object = paramBundle.get(paramString);
    if (object == null)
      return paramT; 
    if (paramClass.isAssignableFrom(object.getClass()))
      return (T)object; 
    throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", new Object[] { paramString, paramClass.getCanonicalName(), object.getClass().getCanonicalName() }));
  }
  
  public static void zza(@NonNull Bundle paramBundle, @NonNull Object paramObject) {
    if (paramObject instanceof Double) {
      paramBundle.putDouble("value", ((Double)paramObject).doubleValue());
      return;
    } 
    if (paramObject instanceof Long) {
      paramBundle.putLong("value", ((Long)paramObject).longValue());
      return;
    } 
    paramBundle.putString("value", paramObject.toString());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */