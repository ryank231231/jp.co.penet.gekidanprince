package com.google.android.gms.internal.clearcut;

final class zzbs {
  private static final Class<?> zzgl = zzak();
  
  private static Class<?> zzak() {
    try {
      return Class.forName("com.google.protobuf.ExtensionRegistry");
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  public static zzbt zzal() {
    Class<?> clazz = zzgl;
    if (clazz != null)
      try {
        return (zzbt)clazz.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
      } catch (Exception exception) {} 
    return zzbt.zzgo;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */