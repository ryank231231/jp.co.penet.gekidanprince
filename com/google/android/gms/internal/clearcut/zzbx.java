package com.google.android.gms.internal.clearcut;

final class zzbx {
  private static final zzbu<?> zzgr = new zzbv();
  
  private static final zzbu<?> zzgs = zzao();
  
  private static zzbu<?> zzao() {
    try {
      return Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  static zzbu<?> zzap() {
    return zzgr;
  }
  
  static zzbu<?> zzaq() {
    zzbu<?> zzbu1 = zzgs;
    if (zzbu1 != null)
      return zzbu1; 
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */