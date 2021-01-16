package com.google.android.gms.internal.measurement;

final class zzey implements zzgg {
  private static final zzey zzagm = new zzey();
  
  public static zzey zzmf() {
    return zzagm;
  }
  
  public final boolean zzb(Class<?> paramClass) {
    return zzez.class.isAssignableFrom(paramClass);
  }
  
  public final zzgf zzc(Class<?> paramClass) {
    String str;
    if (!zzez.class.isAssignableFrom(paramClass)) {
      str = String.valueOf(paramClass.getName());
      if (str.length() != 0) {
        str = "Unsupported message type: ".concat(str);
      } else {
        str = new String("Unsupported message type: ");
      } 
      throw new IllegalArgumentException(str);
    } 
    try {
      return (zzgf)zzez.<zzez<?, ?>>zzd(str.asSubclass(zzez.class)).zza(zzez.zze.zzagw, (Object)null, (Object)null);
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */