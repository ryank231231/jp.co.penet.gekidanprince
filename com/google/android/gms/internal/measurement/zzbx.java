package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzbx extends zzip<zzbx> {
  private static volatile zzbx[] zzvt;
  
  public Integer zzvu = null;
  
  public zzcb[] zzvv = zzcb.zzjd();
  
  public zzby[] zzvw = zzby.zzjb();
  
  private Boolean zzvx = null;
  
  private Boolean zzvy = null;
  
  public static zzbx[] zziz() {
    if (zzvt == null)
      synchronized (zzit.zzanl) {
        if (zzvt == null)
          zzvt = new zzbx[0]; 
      }  
    return zzvt;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzbx))
      return false; 
    paramObject = paramObject;
    Integer integer = this.zzvu;
    if (integer == null) {
      if (((zzbx)paramObject).zzvu != null)
        return false; 
    } else if (!integer.equals(((zzbx)paramObject).zzvu)) {
      return false;
    } 
    if (!zzit.equals((Object[])this.zzvv, (Object[])((zzbx)paramObject).zzvv))
      return false; 
    if (!zzit.equals((Object[])this.zzvw, (Object[])((zzbx)paramObject).zzvw))
      return false; 
    Boolean bool = this.zzvx;
    if (bool == null) {
      if (((zzbx)paramObject).zzvx != null)
        return false; 
    } else if (!bool.equals(((zzbx)paramObject).zzvx)) {
      return false;
    } 
    bool = this.zzvy;
    if (bool == null) {
      if (((zzbx)paramObject).zzvy != null)
        return false; 
    } else if (!bool.equals(((zzbx)paramObject).zzvy)) {
      return false;
    } 
    return (this.zzand == null || this.zzand.isEmpty()) ? ((((zzbx)paramObject).zzand == null || ((zzbx)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzbx)paramObject).zzand);
  }
  
  public final int hashCode() {
    int j;
    int n;
    int i1;
    int i = getClass().getName().hashCode();
    Integer integer = this.zzvu;
    byte b = 0;
    if (integer == null) {
      j = 0;
    } else {
      j = integer.hashCode();
    } 
    int k = zzit.hashCode((Object[])this.zzvv);
    int m = zzit.hashCode((Object[])this.zzvw);
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
    Integer integer = this.zzvu;
    if (integer != null)
      paramzzin.zzc(1, integer.intValue()); 
    zzcb[] arrayOfZzcb = this.zzvv;
    byte b = 0;
    if (arrayOfZzcb != null && arrayOfZzcb.length > 0) {
      byte b1 = 0;
      while (true) {
        arrayOfZzcb = this.zzvv;
        if (b1 < arrayOfZzcb.length) {
          zzcb zzcb1 = arrayOfZzcb[b1];
          if (zzcb1 != null)
            paramzzin.zza(2, zzcb1); 
          b1++;
          continue;
        } 
        break;
      } 
    } 
    zzby[] arrayOfZzby = this.zzvw;
    if (arrayOfZzby != null && arrayOfZzby.length > 0) {
      byte b1 = b;
      while (true) {
        arrayOfZzby = this.zzvw;
        if (b1 < arrayOfZzby.length) {
          zzby zzby1 = arrayOfZzby[b1];
          if (zzby1 != null)
            paramzzin.zza(3, zzby1); 
          b1++;
          continue;
        } 
        break;
      } 
    } 
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
    Integer integer = this.zzvu;
    int j = i;
    if (integer != null)
      j = i + zzin.zzg(1, integer.intValue()); 
    zzcb[] arrayOfZzcb = this.zzvv;
    byte b = 0;
    i = j;
    if (arrayOfZzcb != null) {
      i = j;
      if (arrayOfZzcb.length > 0) {
        i = j;
        j = 0;
        while (true) {
          arrayOfZzcb = this.zzvv;
          if (j < arrayOfZzcb.length) {
            zzcb zzcb1 = arrayOfZzcb[j];
            int k = i;
            if (zzcb1 != null)
              k = i + zzin.zzb(2, zzcb1); 
            j++;
            i = k;
            continue;
          } 
          break;
        } 
      } 
    } 
    zzby[] arrayOfZzby = this.zzvw;
    j = i;
    if (arrayOfZzby != null) {
      j = i;
      if (arrayOfZzby.length > 0) {
        byte b1 = b;
        while (true) {
          arrayOfZzby = this.zzvw;
          j = i;
          if (b1 < arrayOfZzby.length) {
            zzby zzby1 = arrayOfZzby[b1];
            j = i;
            if (zzby1 != null)
              j = i + zzin.zzb(3, zzby1); 
            b1++;
            i = j;
            continue;
          } 
          break;
        } 
      } 
    } 
    Boolean bool = this.zzvx;
    i = j;
    if (bool != null) {
      bool.booleanValue();
      i = j + zzin.zzaj(4) + 1;
    } 
    bool = this.zzvy;
    j = i;
    if (bool != null) {
      bool.booleanValue();
      j = i + zzin.zzaj(5) + 1;
    } 
    return j;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */