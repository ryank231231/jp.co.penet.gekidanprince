package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzcf extends zzip<zzcf> {
  private static volatile zzcf[] zzxh;
  
  public Integer count = null;
  
  public String name = null;
  
  public zzbt.zzd[] zzxi = new zzbt.zzd[0];
  
  public Long zzxj = null;
  
  public Long zzxk = null;
  
  public static zzcf zze(byte[] paramArrayOfbyte) throws zziu {
    return zziv.<zzcf>zza(new zzcf(), paramArrayOfbyte);
  }
  
  public static zzcf[] zzjf() {
    if (zzxh == null)
      synchronized (zzit.zzanl) {
        if (zzxh == null)
          zzxh = new zzcf[0]; 
      }  
    return zzxh;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzcf))
      return false; 
    paramObject = paramObject;
    if (!zzit.equals((Object[])this.zzxi, (Object[])((zzcf)paramObject).zzxi))
      return false; 
    String str = this.name;
    if (str == null) {
      if (((zzcf)paramObject).name != null)
        return false; 
    } else if (!str.equals(((zzcf)paramObject).name)) {
      return false;
    } 
    Long long_ = this.zzxj;
    if (long_ == null) {
      if (((zzcf)paramObject).zzxj != null)
        return false; 
    } else if (!long_.equals(((zzcf)paramObject).zzxj)) {
      return false;
    } 
    long_ = this.zzxk;
    if (long_ == null) {
      if (((zzcf)paramObject).zzxk != null)
        return false; 
    } else if (!long_.equals(((zzcf)paramObject).zzxk)) {
      return false;
    } 
    Integer integer = this.count;
    if (integer == null) {
      if (((zzcf)paramObject).count != null)
        return false; 
    } else if (!integer.equals(((zzcf)paramObject).count)) {
      return false;
    } 
    return (this.zzand == null || this.zzand.isEmpty()) ? ((((zzcf)paramObject).zzand == null || ((zzcf)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzcf)paramObject).zzand);
  }
  
  public final int hashCode() {
    int k;
    int m;
    int n;
    int i1;
    int i = getClass().getName().hashCode();
    int j = zzit.hashCode((Object[])this.zzxi);
    String str = this.name;
    byte b = 0;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    } 
    Long long_ = this.zzxj;
    if (long_ == null) {
      m = 0;
    } else {
      m = long_.hashCode();
    } 
    long_ = this.zzxk;
    if (long_ == null) {
      n = 0;
    } else {
      n = long_.hashCode();
    } 
    Integer integer = this.count;
    if (integer == null) {
      i1 = 0;
    } else {
      i1 = integer.hashCode();
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
    zzbt.zzd[] arrayOfZzd = this.zzxi;
    if (arrayOfZzd != null && arrayOfZzd.length > 0) {
      byte b = 0;
      while (true) {
        arrayOfZzd = this.zzxi;
        if (b < arrayOfZzd.length) {
          zzbt.zzd zzd1 = arrayOfZzd[b];
          if (zzd1 != null)
            paramzzin.zze(1, zzd1); 
          b++;
          continue;
        } 
        break;
      } 
    } 
    String str = this.name;
    if (str != null)
      paramzzin.zzb(2, str); 
    Long long_ = this.zzxj;
    if (long_ != null)
      paramzzin.zzi(3, long_.longValue()); 
    long_ = this.zzxk;
    if (long_ != null)
      paramzzin.zzi(4, long_.longValue()); 
    Integer integer = this.count;
    if (integer != null)
      paramzzin.zzc(5, integer.intValue()); 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    zzbt.zzd[] arrayOfZzd = this.zzxi;
    int j = i;
    if (arrayOfZzd != null) {
      j = i;
      if (arrayOfZzd.length > 0) {
        byte b = 0;
        while (true) {
          arrayOfZzd = this.zzxi;
          j = i;
          if (b < arrayOfZzd.length) {
            zzbt.zzd zzd1 = arrayOfZzd[b];
            j = i;
            if (zzd1 != null)
              j = i + zzeg.zzc(1, zzd1); 
            b++;
            i = j;
            continue;
          } 
          break;
        } 
      } 
    } 
    String str = this.name;
    int k = j;
    if (str != null)
      k = j + zzin.zzc(2, str); 
    Long long_ = this.zzxj;
    i = k;
    if (long_ != null)
      i = k + zzin.zzd(3, long_.longValue()); 
    long_ = this.zzxk;
    j = i;
    if (long_ != null)
      j = i + zzin.zzd(4, long_.longValue()); 
    Integer integer = this.count;
    i = j;
    if (integer != null)
      i = j + zzin.zzg(5, integer.intValue()); 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */