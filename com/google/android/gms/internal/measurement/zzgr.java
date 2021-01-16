package com.google.android.gms.internal.measurement;

final class zzgr {
  private static final zzgp zzajr = zzny();
  
  private static final zzgp zzajs = new zzgq();
  
  static zzgp zznw() {
    return zzajr;
  }
  
  static zzgp zznx() {
    return zzajs;
  }
  
  private static zzgp zzny() {
    try {
      return Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */