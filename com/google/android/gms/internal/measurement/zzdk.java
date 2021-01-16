package com.google.android.gms.internal.measurement;

final class zzdk {
  static {
    if (zzcm("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    } 
    zzabr = bool;
  }
  
  private static <T> Class<T> zzcm(String paramString) {
    try {
      return (Class)Class.forName(paramString);
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  static boolean zzkb() {
    return (zzabq != null && !zzabr);
  }
  
  static Class<?> zzkc() {
    return zzabq;
  }
  
  static {
    boolean bool;
  }
  
  private static final Class<?> zzabq = zzcm("libcore.io.Memory");
  
  private static final boolean zzabr;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */