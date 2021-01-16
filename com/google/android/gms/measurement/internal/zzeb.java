package com.google.android.gms.measurement.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public final class zzeb {
  public static Object zza(Object paramObject) {
    ObjectOutputStream objectOutputStream1;
    ObjectOutputStream objectOutputStream2;
    if (paramObject == null)
      return null; 
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      objectOutputStream1 = new ObjectOutputStream();
    } finally {
      paramObject = null;
      objectOutputStream2 = null;
    } 
    if (objectOutputStream1 != null)
      objectOutputStream1.close(); 
    if (objectOutputStream2 != null)
      objectOutputStream2.close(); 
    throw paramObject;
  }
  
  @Nullable
  public static String zza(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    int i = Math.min(paramArrayOfString1.length, paramArrayOfString2.length);
    for (byte b = 0; b < i; b++) {
      boolean bool;
      String str = paramArrayOfString1[b];
      if (paramString == null && str == null) {
        bool = true;
      } else if (paramString == null) {
        bool = false;
      } else {
        bool = paramString.equals(str);
      } 
      if (bool)
        return paramArrayOfString2[b]; 
    } 
    return null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */