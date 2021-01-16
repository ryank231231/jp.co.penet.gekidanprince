package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzcb extends zzip<zzcb> {
  private static volatile zzcb[] zzwp;
  
  public Boolean zzvx = null;
  
  public Boolean zzvy = null;
  
  public Integer zzwa = null;
  
  public String zzwq = null;
  
  public zzbz zzwr = null;
  
  public static zzcb[] zzjd() {
    if (zzwp == null)
      synchronized (zzit.zzanl) {
        if (zzwp == null)
          zzwp = new zzcb[0]; 
      }  
    return zzwp;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzcb))
      return false; 
    paramObject = paramObject;
    Integer integer = this.zzwa;
    if (integer == null) {
      if (((zzcb)paramObject).zzwa != null)
        return false; 
    } else if (!integer.equals(((zzcb)paramObject).zzwa)) {
      return false;
    } 
    String str = this.zzwq;
    if (str == null) {
      if (((zzcb)paramObject).zzwq != null)
        return false; 
    } else if (!str.equals(((zzcb)paramObject).zzwq)) {
      return false;
    } 
    zzbz zzbz1 = this.zzwr;
    if (zzbz1 == null) {
      if (((zzcb)paramObject).zzwr != null)
        return false; 
    } else if (!zzbz1.equals(((zzcb)paramObject).zzwr)) {
      return false;
    } 
    Boolean bool = this.zzvx;
    if (bool == null) {
      if (((zzcb)paramObject).zzvx != null)
        return false; 
    } else if (!bool.equals(((zzcb)paramObject).zzvx)) {
      return false;
    } 
    bool = this.zzvy;
    if (bool == null) {
      if (((zzcb)paramObject).zzvy != null)
        return false; 
    } else if (!bool.equals(((zzcb)paramObject).zzvy)) {
      return false;
    } 
    return (this.zzand == null || this.zzand.isEmpty()) ? ((((zzcb)paramObject).zzand == null || ((zzcb)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzcb)paramObject).zzand);
  }
  
  public final int hashCode() {
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i = getClass().getName().hashCode();
    Integer integer = this.zzwa;
    byte b = 0;
    if (integer == null) {
      j = 0;
    } else {
      j = integer.hashCode();
    } 
    String str = this.zzwq;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    } 
    zzbz zzbz1 = this.zzwr;
    if (zzbz1 == null) {
      m = 0;
    } else {
      m = zzbz1.hashCode();
    } 
    Boolean bool = this.zzvx;
    if (bool == null) {
      n = 0;
    } else {
      n = bool.hashCode();
    } 
    bool = this.zzvy;
    if (bool == null) {
      i1 = 0;
    } else {
      i1 = bool.hashCode();
    } 
    int i2 = b;
    if (this.zzand != null)
      if (this.zzand.isEmpty()) {
        i2 = b;
      } else {
        i2 = this.zzand.hashCode();
      }  
    return ((((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final void zza(zzin paramzzin) throws IOException {
    Integer integer = this.zzwa;
    if (integer != null)
      paramzzin.zzc(1, integer.intValue()); 
    String str = this.zzwq;
    if (str != null)
      paramzzin.zzb(2, str); 
    zzbz zzbz1 = this.zzwr;
    if (zzbz1 != null)
      paramzzin.zza(3, zzbz1); 
    Boolean bool = this.zzvx;
    if (bool != null)
      paramzzin.zzb(4, bool.booleanValue()); 
    bool = this.zzvy;
    if (bool != null)
      paramzzin.zzb(5, bool.booleanValue()); 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    Integer integer = this.zzwa;
    int j = i;
    if (integer != null)
      j = i + zzin.zzg(1, integer.intValue()); 
    String str = this.zzwq;
    int k = j;
    if (str != null)
      k = j + zzin.zzc(2, str); 
    zzbz zzbz1 = this.zzwr;
    i = k;
    if (zzbz1 != null)
      i = k + zzin.zzb(3, zzbz1); 
    Boolean bool = this.zzvx;
    j = i;
    if (bool != null) {
      bool.booleanValue();
      j = i + zzin.zzaj(4) + 1;
    } 
    bool = this.zzvy;
    i = j;
    if (bool != null) {
      bool.booleanValue();
      i = j + zzin.zzaj(5) + 1;
    } 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */