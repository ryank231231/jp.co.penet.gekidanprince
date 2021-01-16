package com.google.android.gms.internal.measurement;

public enum zzfj {
  zzaho(Void.class, Void.class, null),
  zzahp(int.class, Integer.class, Integer.valueOf(0)),
  zzahq(long.class, Long.class, Long.valueOf(0L)),
  zzahr(float.class, Float.class, Float.valueOf(0.0F)),
  zzahs(double.class, Double.class, Double.valueOf(0.0D)),
  zzaht(boolean.class, Boolean.class, Boolean.valueOf(false)),
  zzahu(String.class, String.class, ""),
  zzahv(zzdp.class, zzdp.class, zzdp.zzaby),
  zzahw(int.class, Integer.class, null),
  zzahx(Object.class, Object.class, null);
  
  private final Class<?> zzahy;
  
  private final Class<?> zzahz;
  
  private final Object zzaia;
  
  zzfj(Class<?> paramClass1, Class<?> paramClass2, Object paramObject) {
    this.zzahy = paramClass1;
    this.zzahz = paramClass2;
    this.zzaia = paramObject;
  }
  
  public final Class<?> zznd() {
    return this.zzahz;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */