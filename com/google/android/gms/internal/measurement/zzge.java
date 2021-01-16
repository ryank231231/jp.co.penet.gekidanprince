package com.google.android.gms.internal.measurement;

final class zzge {
  private static final zzgc zzaiw = zznr();
  
  private static final zzgc zzaix = new zzgd();
  
  static zzgc zznp() {
    return zzaiw;
  }
  
  static zzgc zznq() {
    return zzaix;
  }
  
  private static zzgc zznr() {
    try {
      return Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */