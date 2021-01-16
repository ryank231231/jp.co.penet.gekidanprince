package com.google.android.gms.internal.measurement;

final class zzep {
  private static final zzen<?> zzado = new zzeo();
  
  private static final zzen<?> zzadp = zzlu();
  
  private static zzen<?> zzlu() {
    try {
      return Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  static zzen<?> zzlv() {
    return zzado;
  }
  
  static zzen<?> zzlw() {
    zzen<?> zzen1 = zzadp;
    if (zzen1 != null)
      return zzen1; 
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */