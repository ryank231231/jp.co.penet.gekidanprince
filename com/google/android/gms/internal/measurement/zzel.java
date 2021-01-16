package com.google.android.gms.internal.measurement;

final class zzel {
  private static final Class<?> zzadi = zzlo();
  
  private static final zzem zzcr(String paramString) throws Exception {
    return (zzem)zzadi.getDeclaredMethod(paramString, new Class[0]).invoke(null, new Object[0]);
  }
  
  private static Class<?> zzlo() {
    try {
      return Class.forName("com.google.protobuf.ExtensionRegistry");
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  public static zzem zzlp() {
    if (zzadi != null)
      try {
        return zzcr("getEmptyRegistry");
      } catch (Exception exception) {} 
    return zzem.zzadm;
  }
  
  static zzem zzlq() {
    // Byte code:
    //   0: getstatic com/google/android/gms/internal/measurement/zzel.zzadi : Ljava/lang/Class;
    //   3: ifnull -> 15
    //   6: ldc 'loadGeneratedRegistry'
    //   8: invokestatic zzcr : (Ljava/lang/String;)Lcom/google/android/gms/internal/measurement/zzem;
    //   11: astore_0
    //   12: goto -> 17
    //   15: aconst_null
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 27
    //   23: invokestatic zzlq : ()Lcom/google/android/gms/internal/measurement/zzem;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_1
    //   30: ifnonnull -> 37
    //   33: invokestatic zzlp : ()Lcom/google/android/gms/internal/measurement/zzem;
    //   36: astore_0
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: goto -> 15
    // Exception table:
    //   from	to	target	type
    //   6	12	39	java/lang/Exception
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */