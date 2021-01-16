package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzce extends zzip<zzce> {
  public String zzch = null;
  
  public Long zzxa = null;
  
  private Integer zzxb = null;
  
  public zzbr.zza[] zzxc = new zzbr.zza[0];
  
  public zzcd[] zzxd = zzcd.zzje();
  
  public zzbx[] zzxe = zzbx.zziz();
  
  private String zzxf = null;
  
  public Boolean zzxg = null;
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzce))
      return false; 
    paramObject = paramObject;
    Long long_ = this.zzxa;
    if (long_ == null) {
      if (((zzce)paramObject).zzxa != null)
        return false; 
    } else if (!long_.equals(((zzce)paramObject).zzxa)) {
      return false;
    } 
    String str2 = this.zzch;
    if (str2 == null) {
      if (((zzce)paramObject).zzch != null)
        return false; 
    } else if (!str2.equals(((zzce)paramObject).zzch)) {
      return false;
    } 
    Integer integer = this.zzxb;
    if (integer == null) {
      if (((zzce)paramObject).zzxb != null)
        return false; 
    } else if (!integer.equals(((zzce)paramObject).zzxb)) {
      return false;
    } 
    if (!zzit.equals((Object[])this.zzxc, (Object[])((zzce)paramObject).zzxc))
      return false; 
    if (!zzit.equals((Object[])this.zzxd, (Object[])((zzce)paramObject).zzxd))
      return false; 
    if (!zzit.equals((Object[])this.zzxe, (Object[])((zzce)paramObject).zzxe))
      return false; 
    String str1 = this.zzxf;
    if (str1 == null) {
      if (((zzce)paramObject).zzxf != null)
        return false; 
    } else if (!str1.equals(((zzce)paramObject).zzxf)) {
      return false;
    } 
    Boolean bool = this.zzxg;
    if (bool == null) {
      if (((zzce)paramObject).zzxg != null)
        return false; 
    } else if (!bool.equals(((zzce)paramObject).zzxg)) {
      return false;
    } 
    return (this.zzand == null || this.zzand.isEmpty()) ? ((((zzce)paramObject).zzand == null || ((zzce)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzce)paramObject).zzand);
  }
  
  public final int hashCode() {
    int j;
    int k;
    int m;
    int i3;
    int i4;
    int i = getClass().getName().hashCode();
    Long long_ = this.zzxa;
    byte b = 0;
    if (long_ == null) {
      j = 0;
    } else {
      j = long_.hashCode();
    } 
    String str2 = this.zzch;
    if (str2 == null) {
      k = 0;
    } else {
      k = str2.hashCode();
    } 
    Integer integer = this.zzxb;
    if (integer == null) {
      m = 0;
    } else {
      m = integer.hashCode();
    } 
    int n = zzit.hashCode((Object[])this.zzxc);
    int i1 = zzit.hashCode((Object[])this.zzxd);
    int i2 = zzit.hashCode((Object[])this.zzxe);
    String str1 = this.zzxf;
    if (str1 == null) {
      i3 = 0;
    } else {
      i3 = str1.hashCode();
    } 
    Boolean bool = this.zzxg;
    if (bool == null) {
      i4 = 0;
    } else {
      i4 = bool.hashCode();
    } 
    int i5 = b;
    if (this.zzand != null)
      if (this.zzand.isEmpty()) {
        i5 = b;
      } else {
        i5 = this.zzand.hashCode();
      }  
    return (((((((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5;
  }
  
  public final void zza(zzin paramzzin) throws IOException {
    Long long_ = this.zzxa;
    if (long_ != null)
      paramzzin.zzi(1, long_.longValue()); 
    String str2 = this.zzch;
    if (str2 != null)
      paramzzin.zzb(2, str2); 
    Integer integer = this.zzxb;
    if (integer != null)
      paramzzin.zzc(3, integer.intValue()); 
    zzbr.zza[] arrayOfZza = this.zzxc;
    byte b = 0;
    if (arrayOfZza != null && arrayOfZza.length > 0) {
      byte b1 = 0;
      while (true) {
        arrayOfZza = this.zzxc;
        if (b1 < arrayOfZza.length) {
          zzbr.zza zza1 = arrayOfZza[b1];
          if (zza1 != null)
            paramzzin.zze(4, zza1); 
          b1++;
          continue;
        } 
        break;
      } 
    } 
    zzcd[] arrayOfZzcd = this.zzxd;
    if (arrayOfZzcd != null && arrayOfZzcd.length > 0) {
      byte b1 = 0;
      while (true) {
        arrayOfZzcd = this.zzxd;
        if (b1 < arrayOfZzcd.length) {
          zzcd zzcd1 = arrayOfZzcd[b1];
          if (zzcd1 != null)
            paramzzin.zza(5, zzcd1); 
          b1++;
          continue;
        } 
        break;
      } 
    } 
    zzbx[] arrayOfZzbx = this.zzxe;
    if (arrayOfZzbx != null && arrayOfZzbx.length > 0) {
      byte b1 = b;
      while (true) {
        arrayOfZzbx = this.zzxe;
        if (b1 < arrayOfZzbx.length) {
          zzbx zzbx1 = arrayOfZzbx[b1];
          if (zzbx1 != null)
            paramzzin.zza(6, zzbx1); 
          b1++;
          continue;
        } 
        break;
      } 
    } 
    String str1 = this.zzxf;
    if (str1 != null)
      paramzzin.zzb(7, str1); 
    Boolean bool = this.zzxg;
    if (bool != null)
      paramzzin.zzb(8, bool.booleanValue()); 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    Long long_ = this.zzxa;
    int j = i;
    if (long_ != null)
      j = i + zzin.zzd(1, long_.longValue()); 
    String str2 = this.zzch;
    i = j;
    if (str2 != null)
      i = j + zzin.zzc(2, str2); 
    Integer integer = this.zzxb;
    j = i;
    if (integer != null)
      j = i + zzin.zzg(3, integer.intValue()); 
    zzbr.zza[] arrayOfZza = this.zzxc;
    byte b = 0;
    i = j;
    if (arrayOfZza != null) {
      i = j;
      if (arrayOfZza.length > 0) {
        i = 0;
        while (true) {
          arrayOfZza = this.zzxc;
          if (i < arrayOfZza.length) {
            zzbr.zza zza1 = arrayOfZza[i];
            int k = j;
            if (zza1 != null)
              k = j + zzeg.zzc(4, zza1); 
            i++;
            j = k;
            continue;
          } 
          i = j;
          break;
        } 
      } 
    } 
    zzcd[] arrayOfZzcd = this.zzxd;
    j = i;
    if (arrayOfZzcd != null) {
      j = i;
      if (arrayOfZzcd.length > 0) {
        j = i;
        i = 0;
        while (true) {
          arrayOfZzcd = this.zzxd;
          if (i < arrayOfZzcd.length) {
            zzcd zzcd1 = arrayOfZzcd[i];
            int k = j;
            if (zzcd1 != null)
              k = j + zzin.zzb(5, zzcd1); 
            i++;
            j = k;
            continue;
          } 
          break;
        } 
      } 
    } 
    zzbx[] arrayOfZzbx = this.zzxe;
    i = j;
    if (arrayOfZzbx != null) {
      i = j;
      if (arrayOfZzbx.length > 0) {
        byte b1 = b;
        while (true) {
          arrayOfZzbx = this.zzxe;
          i = j;
          if (b1 < arrayOfZzbx.length) {
            zzbx zzbx1 = arrayOfZzbx[b1];
            i = j;
            if (zzbx1 != null)
              i = j + zzin.zzb(6, zzbx1); 
            b1++;
            j = i;
            continue;
          } 
          break;
        } 
      } 
    } 
    String str1 = this.zzxf;
    j = i;
    if (str1 != null)
      j = i + zzin.zzc(7, str1); 
    Boolean bool = this.zzxg;
    i = j;
    if (bool != null) {
      bool.booleanValue();
      i = j + zzin.zzaj(8) + 1;
    } 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */