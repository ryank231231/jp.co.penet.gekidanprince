package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzby extends zzip<zzby> {
  private static volatile zzby[] zzvz;
  
  public Boolean zzvx = null;
  
  public Boolean zzvy = null;
  
  public Integer zzwa = null;
  
  public String zzwb = null;
  
  public zzbz[] zzwc = zzbz.zzjc();
  
  private Boolean zzwd = null;
  
  public zzca zzwe = null;
  
  public static zzby[] zzjb() {
    if (zzvz == null)
      synchronized (zzit.zzanl) {
        if (zzvz == null)
          zzvz = new zzby[0]; 
      }  
    return zzvz;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzby))
      return false; 
    paramObject = paramObject;
    Integer integer = this.zzwa;
    if (integer == null) {
      if (((zzby)paramObject).zzwa != null)
        return false; 
    } else if (!integer.equals(((zzby)paramObject).zzwa)) {
      return false;
    } 
    String str = this.zzwb;
    if (str == null) {
      if (((zzby)paramObject).zzwb != null)
        return false; 
    } else if (!str.equals(((zzby)paramObject).zzwb)) {
      return false;
    } 
    if (!zzit.equals((Object[])this.zzwc, (Object[])((zzby)paramObject).zzwc))
      return false; 
    Boolean bool2 = this.zzwd;
    if (bool2 == null) {
      if (((zzby)paramObject).zzwd != null)
        return false; 
    } else if (!bool2.equals(((zzby)paramObject).zzwd)) {
      return false;
    } 
    zzca zzca1 = this.zzwe;
    if (zzca1 == null) {
      if (((zzby)paramObject).zzwe != null)
        return false; 
    } else if (!zzca1.equals(((zzby)paramObject).zzwe)) {
      return false;
    } 
    Boolean bool1 = this.zzvx;
    if (bool1 == null) {
      if (((zzby)paramObject).zzvx != null)
        return false; 
    } else if (!bool1.equals(((zzby)paramObject).zzvx)) {
      return false;
    } 
    bool1 = this.zzvy;
    if (bool1 == null) {
      if (((zzby)paramObject).zzvy != null)
        return false; 
    } else if (!bool1.equals(((zzby)paramObject).zzvy)) {
      return false;
    } 
    return (this.zzand == null || this.zzand.isEmpty()) ? ((((zzby)paramObject).zzand == null || ((zzby)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzby)paramObject).zzand);
  }
  
  public final int hashCode() {
    int j;
    int k;
    int n;
    int i1;
    int i2;
    int i3;
    int i = getClass().getName().hashCode();
    Integer integer = this.zzwa;
    byte b = 0;
    if (integer == null) {
      j = 0;
    } else {
      j = integer.hashCode();
    } 
    String str = this.zzwb;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    } 
    int m = zzit.hashCode((Object[])this.zzwc);
    Boolean bool2 = this.zzwd;
    if (bool2 == null) {
      n = 0;
    } else {
      n = bool2.hashCode();
    } 
    zzca zzca1 = this.zzwe;
    if (zzca1 == null) {
      i1 = 0;
    } else {
      i1 = zzca1.hashCode();
    } 
    Boolean bool1 = this.zzvx;
    if (bool1 == null) {
      i2 = 0;
    } else {
      i2 = bool1.hashCode();
    } 
    bool1 = this.zzvy;
    if (bool1 == null) {
      i3 = 0;
    } else {
      i3 = bool1.hashCode();
    } 
    int i4 = b;
    if (this.zzand != null)
      if (this.zzand.isEmpty()) {
        i4 = b;
      } else {
        i4 = this.zzand.hashCode();
      }  
    return ((((((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4;
  }
  
  public final void zza(zzin paramzzin) throws IOException {
    Integer integer = this.zzwa;
    if (integer != null)
      paramzzin.zzc(1, integer.intValue()); 
    String str = this.zzwb;
    if (str != null)
      paramzzin.zzb(2, str); 
    zzbz[] arrayOfZzbz = this.zzwc;
    if (arrayOfZzbz != null && arrayOfZzbz.length > 0) {
      byte b = 0;
      while (true) {
        arrayOfZzbz = this.zzwc;
        if (b < arrayOfZzbz.length) {
          zzbz zzbz1 = arrayOfZzbz[b];
          if (zzbz1 != null)
            paramzzin.zza(3, zzbz1); 
          b++;
          continue;
        } 
        break;
      } 
    } 
    Boolean bool2 = this.zzwd;
    if (bool2 != null)
      paramzzin.zzb(4, bool2.booleanValue()); 
    zzca zzca1 = this.zzwe;
    if (zzca1 != null)
      paramzzin.zza(5, zzca1); 
    Boolean bool1 = this.zzvx;
    if (bool1 != null)
      paramzzin.zzb(6, bool1.booleanValue()); 
    bool1 = this.zzvy;
    if (bool1 != null)
      paramzzin.zzb(7, bool1.booleanValue()); 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    Integer integer = this.zzwa;
    int j = i;
    if (integer != null)
      j = i + zzin.zzg(1, integer.intValue()); 
    String str = this.zzwb;
    i = j;
    if (str != null)
      i = j + zzin.zzc(2, str); 
    zzbz[] arrayOfZzbz = this.zzwc;
    j = i;
    if (arrayOfZzbz != null) {
      j = i;
      if (arrayOfZzbz.length > 0) {
        byte b = 0;
        while (true) {
          arrayOfZzbz = this.zzwc;
          j = i;
          if (b < arrayOfZzbz.length) {
            zzbz zzbz1 = arrayOfZzbz[b];
            j = i;
            if (zzbz1 != null)
              j = i + zzin.zzb(3, zzbz1); 
            b++;
            i = j;
            continue;
          } 
          break;
        } 
      } 
    } 
    Boolean bool2 = this.zzwd;
    int k = j;
    if (bool2 != null) {
      bool2.booleanValue();
      k = j + zzin.zzaj(4) + 1;
    } 
    zzca zzca1 = this.zzwe;
    i = k;
    if (zzca1 != null)
      i = k + zzin.zzb(5, zzca1); 
    Boolean bool1 = this.zzvx;
    j = i;
    if (bool1 != null) {
      bool1.booleanValue();
      j = i + zzin.zzaj(6) + 1;
    } 
    bool1 = this.zzvy;
    i = j;
    if (bool1 != null) {
      bool1.booleanValue();
      i = j + zzin.zzaj(7) + 1;
    } 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */