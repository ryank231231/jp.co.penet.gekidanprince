package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

public final class zzgz extends zzfu<zzgz> implements Cloneable {
  private byte[] zzbjb = zzgb.zzse;
  
  private String zzbjc = "";
  
  private byte[][] zzbjd = zzgb.zzsd;
  
  private boolean zzbje = false;
  
  private final zzgz zzgc() {
    try {
      zzgz zzgz1 = super.zzeo();
      byte[][] arrayOfByte = this.zzbjd;
      if (arrayOfByte != null && arrayOfByte.length > 0)
        zzgz1.zzbjd = (byte[][])arrayOfByte.clone(); 
      return zzgz1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzgz))
      return false; 
    paramObject = paramObject;
    if (!Arrays.equals(this.zzbjb, ((zzgz)paramObject).zzbjb))
      return false; 
    String str = this.zzbjc;
    if (str == null) {
      if (((zzgz)paramObject).zzbjc != null)
        return false; 
    } else if (!str.equals(((zzgz)paramObject).zzbjc)) {
      return false;
    } 
    return !zzfy.zza(this.zzbjd, ((zzgz)paramObject).zzbjd) ? false : ((this.zzrj == null || this.zzrj.isEmpty()) ? ((((zzgz)paramObject).zzrj == null || ((zzgz)paramObject).zzrj.isEmpty())) : this.zzrj.equals(((zzgz)paramObject).zzrj));
  }
  
  public final int hashCode() {
    int k;
    int i = getClass().getName().hashCode();
    int j = Arrays.hashCode(this.zzbjb);
    String str = this.zzbjc;
    byte b = 0;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    } 
    int m = zzfy.zza(this.zzbjd);
    int n = b;
    if (this.zzrj != null)
      if (this.zzrj.isEmpty()) {
        n = b;
      } else {
        n = this.zzrj.hashCode();
      }  
    return (((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + 1237) * 31 + n;
  }
  
  public final void zza(zzfs paramzzfs) throws IOException {
    if (!Arrays.equals(this.zzbjb, zzgb.zzse))
      paramzzfs.zza(1, this.zzbjb); 
    byte[][] arrayOfByte = this.zzbjd;
    if (arrayOfByte != null && arrayOfByte.length > 0) {
      byte b = 0;
      while (true) {
        arrayOfByte = this.zzbjd;
        if (b < arrayOfByte.length) {
          byte[] arrayOfByte1 = arrayOfByte[b];
          if (arrayOfByte1 != null)
            paramzzfs.zza(2, arrayOfByte1); 
          b++;
          continue;
        } 
        break;
      } 
    } 
    String str = this.zzbjc;
    if (str != null && !str.equals(""))
      paramzzfs.zza(4, this.zzbjc); 
    super.zza(paramzzfs);
  }
  
  protected final int zzen() {
    int i = super.zzen();
    int j = i;
    if (!Arrays.equals(this.zzbjb, zzgb.zzse))
      j = i + zzfs.zzb(1, this.zzbjb); 
    byte[][] arrayOfByte = this.zzbjd;
    i = j;
    if (arrayOfByte != null) {
      i = j;
      if (arrayOfByte.length > 0) {
        byte b = 0;
        int k = 0;
        i = 0;
        while (true) {
          arrayOfByte = this.zzbjd;
          if (b < arrayOfByte.length) {
            byte[] arrayOfByte1 = arrayOfByte[b];
            int m = k;
            int n = i;
            if (arrayOfByte1 != null) {
              n = i + 1;
              m = k + zzfs.zzh(arrayOfByte1);
            } 
            b++;
            k = m;
            i = n;
            continue;
          } 
          i = j + k + i * 1;
          break;
        } 
      } 
    } 
    String str = this.zzbjc;
    j = i;
    if (str != null) {
      j = i;
      if (!str.equals(""))
        j = i + zzfs.zzb(4, this.zzbjc); 
    } 
    return j;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */