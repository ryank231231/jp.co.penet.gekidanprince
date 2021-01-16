package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzgy extends zzfu<zzgy> implements Cloneable {
  private String[] zzbiw = zzgb.zzsc;
  
  private String[] zzbix = zzgb.zzsc;
  
  private int[] zzbiy = zzgb.zzrx;
  
  private long[] zzbiz = zzgb.zzry;
  
  private long[] zzbja = zzgb.zzry;
  
  private final zzgy zzgb() {
    try {
      zzgy zzgy1 = super.zzeo();
      String[] arrayOfString = this.zzbiw;
      if (arrayOfString != null && arrayOfString.length > 0)
        zzgy1.zzbiw = (String[])arrayOfString.clone(); 
      arrayOfString = this.zzbix;
      if (arrayOfString != null && arrayOfString.length > 0)
        zzgy1.zzbix = (String[])arrayOfString.clone(); 
      int[] arrayOfInt = this.zzbiy;
      if (arrayOfInt != null && arrayOfInt.length > 0)
        zzgy1.zzbiy = (int[])arrayOfInt.clone(); 
      long[] arrayOfLong = this.zzbiz;
      if (arrayOfLong != null && arrayOfLong.length > 0)
        zzgy1.zzbiz = (long[])arrayOfLong.clone(); 
      arrayOfLong = this.zzbja;
      if (arrayOfLong != null && arrayOfLong.length > 0)
        zzgy1.zzbja = (long[])arrayOfLong.clone(); 
      return zzgy1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzgy))
      return false; 
    paramObject = paramObject;
    return !zzfy.equals((Object[])this.zzbiw, (Object[])((zzgy)paramObject).zzbiw) ? false : (!zzfy.equals((Object[])this.zzbix, (Object[])((zzgy)paramObject).zzbix) ? false : (!zzfy.equals(this.zzbiy, ((zzgy)paramObject).zzbiy) ? false : (!zzfy.equals(this.zzbiz, ((zzgy)paramObject).zzbiz) ? false : (!zzfy.equals(this.zzbja, ((zzgy)paramObject).zzbja) ? false : ((this.zzrj == null || this.zzrj.isEmpty()) ? ((((zzgy)paramObject).zzrj == null || ((zzgy)paramObject).zzrj.isEmpty())) : this.zzrj.equals(((zzgy)paramObject).zzrj))))));
  }
  
  public final int hashCode() {
    int i = getClass().getName().hashCode();
    int j = zzfy.hashCode((Object[])this.zzbiw);
    int k = zzfy.hashCode((Object[])this.zzbix);
    int m = zzfy.hashCode(this.zzbiy);
    int n = zzfy.hashCode(this.zzbiz);
    int i1 = zzfy.hashCode(this.zzbja);
    if (this.zzrj == null || this.zzrj.isEmpty()) {
      byte b = 0;
      return ((((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + b;
    } 
    int i2 = this.zzrj.hashCode();
    return ((((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final void zza(zzfs paramzzfs) throws IOException {
    String[] arrayOfString = this.zzbiw;
    byte b = 0;
    if (arrayOfString != null && arrayOfString.length > 0) {
      byte b1 = 0;
      while (true) {
        arrayOfString = this.zzbiw;
        if (b1 < arrayOfString.length) {
          String str = arrayOfString[b1];
          if (str != null)
            paramzzfs.zza(1, str); 
          b1++;
          continue;
        } 
        break;
      } 
    } 
    arrayOfString = this.zzbix;
    if (arrayOfString != null && arrayOfString.length > 0) {
      byte b1 = 0;
      while (true) {
        arrayOfString = this.zzbix;
        if (b1 < arrayOfString.length) {
          String str = arrayOfString[b1];
          if (str != null)
            paramzzfs.zza(2, str); 
          b1++;
          continue;
        } 
        break;
      } 
    } 
    int[] arrayOfInt = this.zzbiy;
    if (arrayOfInt != null && arrayOfInt.length > 0) {
      byte b1 = 0;
      while (true) {
        arrayOfInt = this.zzbiy;
        if (b1 < arrayOfInt.length) {
          paramzzfs.zzc(3, arrayOfInt[b1]);
          b1++;
          continue;
        } 
        break;
      } 
    } 
    long[] arrayOfLong = this.zzbiz;
    if (arrayOfLong != null && arrayOfLong.length > 0) {
      byte b1 = 0;
      while (true) {
        arrayOfLong = this.zzbiz;
        if (b1 < arrayOfLong.length) {
          paramzzfs.zzi(4, arrayOfLong[b1]);
          b1++;
          continue;
        } 
        break;
      } 
    } 
    arrayOfLong = this.zzbja;
    if (arrayOfLong != null && arrayOfLong.length > 0) {
      byte b1 = b;
      while (true) {
        arrayOfLong = this.zzbja;
        if (b1 < arrayOfLong.length) {
          paramzzfs.zzi(5, arrayOfLong[b1]);
          b1++;
          continue;
        } 
        break;
      } 
    } 
    super.zza(paramzzfs);
  }
  
  protected final int zzen() {
    int i = super.zzen();
    String[] arrayOfString = this.zzbiw;
    boolean bool = false;
    int j = i;
    if (arrayOfString != null) {
      j = i;
      if (arrayOfString.length > 0) {
        byte b = 0;
        j = 0;
        int m = 0;
        while (true) {
          arrayOfString = this.zzbiw;
          if (b < arrayOfString.length) {
            String str = arrayOfString[b];
            int n = j;
            int i1 = m;
            if (str != null) {
              i1 = m + 1;
              n = j + zzfs.zzh(str);
            } 
            b++;
            j = n;
            m = i1;
            continue;
          } 
          j = i + j + m * 1;
          break;
        } 
      } 
    } 
    arrayOfString = this.zzbix;
    int k = j;
    if (arrayOfString != null) {
      k = j;
      if (arrayOfString.length > 0) {
        k = 0;
        int n = 0;
        int m = 0;
        while (true) {
          arrayOfString = this.zzbix;
          if (k < arrayOfString.length) {
            String str = arrayOfString[k];
            i = n;
            int i1 = m;
            if (str != null) {
              i1 = m + 1;
              i = n + zzfs.zzh(str);
            } 
            k++;
            n = i;
            m = i1;
            continue;
          } 
          k = j + n + m * 1;
          break;
        } 
      } 
    } 
    int[] arrayOfInt = this.zzbiy;
    j = k;
    if (arrayOfInt != null) {
      j = k;
      if (arrayOfInt.length > 0) {
        byte b = 0;
        j = 0;
        while (true) {
          arrayOfInt = this.zzbiy;
          if (b < arrayOfInt.length) {
            j += zzfs.zzs(arrayOfInt[b]);
            b++;
            continue;
          } 
          j = k + j + arrayOfInt.length * 1;
          break;
        } 
      } 
    } 
    long[] arrayOfLong = this.zzbiz;
    k = j;
    if (arrayOfLong != null) {
      k = j;
      if (arrayOfLong.length > 0) {
        byte b = 0;
        k = 0;
        while (true) {
          arrayOfLong = this.zzbiz;
          if (b < arrayOfLong.length) {
            k += zzfs.zzo(arrayOfLong[b]);
            b++;
            continue;
          } 
          k = j + k + arrayOfLong.length * 1;
          break;
        } 
      } 
    } 
    arrayOfLong = this.zzbja;
    j = k;
    if (arrayOfLong != null) {
      j = k;
      if (arrayOfLong.length > 0) {
        int m = 0;
        j = bool;
        while (true) {
          arrayOfLong = this.zzbja;
          if (j < arrayOfLong.length) {
            m += zzfs.zzo(arrayOfLong[j]);
            j++;
            continue;
          } 
          j = k + m + arrayOfLong.length * 1;
          break;
        } 
      } 
    } 
    return j;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */