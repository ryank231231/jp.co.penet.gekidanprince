package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzbz extends zzip<zzbz> {
  private static volatile zzbz[] zzwf;
  
  public zzcc zzwg = null;
  
  public zzca zzwh = null;
  
  public Boolean zzwi = null;
  
  public String zzwj = null;
  
  public static zzbz[] zzjc() {
    if (zzwf == null)
      synchronized (zzit.zzanl) {
        if (zzwf == null)
          zzwf = new zzbz[0]; 
      }  
    return zzwf;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzbz))
      return false; 
    paramObject = paramObject;
    zzcc zzcc1 = this.zzwg;
    if (zzcc1 == null) {
      if (((zzbz)paramObject).zzwg != null)
        return false; 
    } else if (!zzcc1.equals(((zzbz)paramObject).zzwg)) {
      return false;
    } 
    zzca zzca1 = this.zzwh;
    if (zzca1 == null) {
      if (((zzbz)paramObject).zzwh != null)
        return false; 
    } else if (!zzca1.equals(((zzbz)paramObject).zzwh)) {
      return false;
    } 
    Boolean bool = this.zzwi;
    if (bool == null) {
      if (((zzbz)paramObject).zzwi != null)
        return false; 
    } else if (!bool.equals(((zzbz)paramObject).zzwi)) {
      return false;
    } 
    String str = this.zzwj;
    if (str == null) {
      if (((zzbz)paramObject).zzwj != null)
        return false; 
    } else if (!str.equals(((zzbz)paramObject).zzwj)) {
      return false;
    } 
    return (this.zzand == null || this.zzand.isEmpty()) ? ((((zzbz)paramObject).zzand == null || ((zzbz)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzbz)paramObject).zzand);
  }
  
  public final int hashCode() {
    int j;
    int k;
    int m;
    int n;
    int i = getClass().getName().hashCode();
    zzcc zzcc1 = this.zzwg;
    byte b = 0;
    if (zzcc1 == null) {
      j = 0;
    } else {
      j = zzcc1.hashCode();
    } 
    zzca zzca1 = this.zzwh;
    if (zzca1 == null) {
      k = 0;
    } else {
      k = zzca1.hashCode();
    } 
    Boolean bool = this.zzwi;
    if (bool == null) {
      m = 0;
    } else {
      m = bool.hashCode();
    } 
    String str = this.zzwj;
    if (str == null) {
      n = 0;
    } else {
      n = str.hashCode();
    } 
    int i1 = b;
    if (this.zzand != null)
      if (this.zzand.isEmpty()) {
        i1 = b;
      } else {
        i1 = this.zzand.hashCode();
      }  
    return (((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final void zza(zzin paramzzin) throws IOException {
    zzcc zzcc1 = this.zzwg;
    if (zzcc1 != null)
      paramzzin.zza(1, zzcc1); 
    zzca zzca1 = this.zzwh;
    if (zzca1 != null)
      paramzzin.zza(2, zzca1); 
    Boolean bool = this.zzwi;
    if (bool != null)
      paramzzin.zzb(3, bool.booleanValue()); 
    String str = this.zzwj;
    if (str != null)
      paramzzin.zzb(4, str); 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    zzcc zzcc1 = this.zzwg;
    int j = i;
    if (zzcc1 != null)
      j = i + zzin.zzb(1, zzcc1); 
    zzca zzca1 = this.zzwh;
    i = j;
    if (zzca1 != null)
      i = j + zzin.zzb(2, zzca1); 
    Boolean bool = this.zzwi;
    j = i;
    if (bool != null) {
      bool.booleanValue();
      j = i + zzin.zzaj(3) + 1;
    } 
    String str = this.zzwj;
    i = j;
    if (str != null)
      i = j + zzin.zzc(4, str); 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */