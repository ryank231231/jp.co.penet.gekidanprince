package com.google.android.gms.internal.clearcut;

final class zzcf implements zzdn {
  private static final zzcf zzjo = new zzcf();
  
  public static zzcf zzay() {
    return zzjo;
  }
  
  public final boolean zza(Class<?> paramClass) {
    return zzcg.class.isAssignableFrom(paramClass);
  }
  
  public final zzdm zzb(Class<?> paramClass) {
    String str;
    if (!zzcg.class.isAssignableFrom(paramClass)) {
      str = String.valueOf(paramClass.getName());
      if (str.length() != 0) {
        str = "Unsupported message type: ".concat(str);
      } else {
        str = new String("Unsupported message type: ");
      } 
      throw new IllegalArgumentException(str);
    } 
    try {
      return (zzdm)zzcg.<zzcg<?, ?>>zzc(str.asSubclass(zzcg.class)).zza(zzcg.zzg.zzkf, (Object)null, (Object)null);
    } catch (Exception exception) {
      str = String.valueOf(str.getName());
      if (str.length() != 0) {
        str = "Unable to get message info for ".concat(str);
      } else {
        str = new String("Unable to get message info for ");
      } 
      throw new RuntimeException(str, exception);
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */