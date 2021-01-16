package com.google.android.gms.internal.clearcut;

final class zzdl {
  private static final zzdj zzmf = zzce();
  
  private static final zzdj zzmg = new zzdk();
  
  static zzdj zzcc() {
    return zzmf;
  }
  
  static zzdj zzcd() {
    return zzmg;
  }
  
  private static zzdj zzce() {
    try {
      return Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */