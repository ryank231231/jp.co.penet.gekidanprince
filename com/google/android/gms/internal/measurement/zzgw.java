package com.google.android.gms.internal.measurement;

final class zzgw implements zzgf {
  private final int flags;
  
  private final String info;
  
  private final Object[] zzajb;
  
  private final zzgh zzaje;
  
  zzgw(zzgh paramzzgh, String paramString, Object[] paramArrayOfObject) {
    this.zzaje = paramzzgh;
    this.info = paramString;
    this.zzajb = paramArrayOfObject;
    char c = paramString.charAt(0);
    if (c < '?') {
      this.flags = c;
      return;
    } 
    int i = c & 0x1FFF;
    byte b = 13;
    c = '\001';
    while (true) {
      char c1 = paramString.charAt(c);
      if (c1 >= '?') {
        i |= (c1 & 0x1FFF) << b;
        b += 13;
        c++;
        continue;
      } 
      this.flags = i | c1 << b;
      return;
    } 
  }
  
  public final int zzns() {
    return ((this.flags & 0x1) == 1) ? zzez.zze.zzahc : zzez.zze.zzahd;
  }
  
  public final boolean zznt() {
    return ((this.flags & 0x2) == 2);
  }
  
  public final zzgh zznu() {
    return this.zzaje;
  }
  
  final String zzob() {
    return this.info;
  }
  
  final Object[] zzoc() {
    return this.zzajb;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */