package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzhb extends zzfu<zzhb> implements Cloneable {
  private static volatile zzhb[] zzbkd;
  
  private String value = "";
  
  private String zzbke = "";
  
  public static zzhb[] zzge() {
    if (zzbkd == null)
      synchronized (zzfy.zzrr) {
        if (zzbkd == null)
          zzbkd = new zzhb[0]; 
      }  
    return zzbkd;
  }
  
  private final zzhb zzgf() {
    try {
      return super.zzeo();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzhb))
      return false; 
    paramObject = paramObject;
    String str = this.zzbke;
    if (str == null) {
      if (((zzhb)paramObject).zzbke != null)
        return false; 
    } else if (!str.equals(((zzhb)paramObject).zzbke)) {
      return false;
    } 
    str = this.value;
    if (str == null) {
      if (((zzhb)paramObject).value != null)
        return false; 
    } else if (!str.equals(((zzhb)paramObject).value)) {
      return false;
    } 
    return (this.zzrj == null || this.zzrj.isEmpty()) ? ((((zzhb)paramObject).zzrj == null || ((zzhb)paramObject).zzrj.isEmpty())) : this.zzrj.equals(((zzhb)paramObject).zzrj);
  }
  
  public final int hashCode() {
    int j;
    int k;
    int i = getClass().getName().hashCode();
    String str = this.zzbke;
    byte b = 0;
    if (str == null) {
      j = 0;
    } else {
      j = str.hashCode();
    } 
    str = this.value;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    } 
    int m = b;
    if (this.zzrj != null)
      if (this.zzrj.isEmpty()) {
        m = b;
      } else {
        m = this.zzrj.hashCode();
      }  
    return (((i + 527) * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final void zza(zzfs paramzzfs) throws IOException {
    String str = this.zzbke;
    if (str != null && !str.equals(""))
      paramzzfs.zza(1, this.zzbke); 
    str = this.value;
    if (str != null && !str.equals(""))
      paramzzfs.zza(2, this.value); 
    super.zza(paramzzfs);
  }
  
  protected final int zzen() {
    int i = super.zzen();
    String str = this.zzbke;
    int j = i;
    if (str != null) {
      j = i;
      if (!str.equals(""))
        j = i + zzfs.zzb(1, this.zzbke); 
    } 
    str = this.value;
    i = j;
    if (str != null) {
      i = j;
      if (!str.equals(""))
        i = j + zzfs.zzb(2, this.value); 
    } 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */