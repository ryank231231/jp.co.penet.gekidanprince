package com.google.android.gms.internal.clearcut;

final class zzdy {
  private static final zzdw zzna = zzcl();
  
  private static final zzdw zznb = new zzdx();
  
  static zzdw zzcj() {
    return zzna;
  }
  
  static zzdw zzck() {
    return zznb;
  }
  
  private static zzdw zzcl() {
    try {
      return Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */