package com.google.android.gms.internal.clearcut;

public enum zzcq {
  zzkx(Void.class, Void.class, null),
  zzky(int.class, Integer.class, Integer.valueOf(0)),
  zzkz(long.class, Long.class, Long.valueOf(0L)),
  zzla(float.class, Float.class, Float.valueOf(0.0F)),
  zzlb(double.class, Double.class, Double.valueOf(0.0D)),
  zzlc(boolean.class, Boolean.class, Boolean.valueOf(false)),
  zzld(String.class, String.class, ""),
  zzle(zzbb.class, zzbb.class, zzbb.zzfi),
  zzlf(int.class, Integer.class, null),
  zzlg(Object.class, Object.class, null);
  
  private final Class<?> zzlh;
  
  private final Class<?> zzli;
  
  private final Object zzlj;
  
  zzcq(Class<?> paramClass1, Class<?> paramClass2, Object paramObject) {
    this.zzlh = paramClass1;
    this.zzli = paramClass2;
    this.zzlj = paramObject;
  }
  
  public final Class<?> zzbq() {
    return this.zzli;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */