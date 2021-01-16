package com.google.android.gms.internal.clearcut;

import java.util.HashMap;
import java.util.Map;

public final class zzbt {
  private static volatile boolean zzgm = false;
  
  private static final Class<?> zzgn = zzam();
  
  static final zzbt zzgo = new zzbt(true);
  
  private final Map<Object, zzcg.zzf<?, ?>> zzgp = new HashMap<Object, zzcg.zzf<?, ?>>();
  
  zzbt() {}
  
  private zzbt(boolean paramBoolean) {}
  
  private static Class<?> zzam() {
    try {
      return Class.forName("com.google.protobuf.Extension");
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  public static zzbt zzan() {
    return zzbs.zzal();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */