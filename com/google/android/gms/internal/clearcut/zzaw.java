package com.google.android.gms.internal.clearcut;

final class zzaw {
  static {
    if (zze("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    } 
    zzfc = bool;
  }
  
  private static <T> Class<T> zze(String paramString) {
    try {
      return (Class)Class.forName(paramString);
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  static boolean zzx() {
    return (zzfb != null && !zzfc);
  }
  
  static Class<?> zzy() {
    return zzfb;
  }
  
  static {
    boolean bool;
  }
  
  private static final Class<?> zzfb = zze("libcore.io.Memory");
  
  private static final boolean zzfc;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */