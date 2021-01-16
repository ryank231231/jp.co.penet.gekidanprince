package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

final class zzed extends zzeb {
  private final byte[] buffer;
  
  private int limit;
  
  private int pos;
  
  private final boolean zzacm;
  
  private int zzacn;
  
  private int zzaco;
  
  private int zzacp;
  
  private int zzacq = Integer.MAX_VALUE;
  
  private zzed(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    super(null);
    this.buffer = paramArrayOfbyte;
    this.limit = paramInt2 + paramInt1;
    this.pos = paramInt1;
    this.zzaco = this.pos;
    this.zzacm = paramBoolean;
  }
  
  private final int zzlb() throws IOException {
    int i = this.pos;
    int j = this.limit;
    if (j != i) {
      byte[] arrayOfByte = this.buffer;
      int k = i + 1;
      i = arrayOfByte[i];
      if (i >= 0) {
        this.pos = k;
        return i;
      } 
      if (j - k >= 9) {
        j = k + 1;
        i ^= arrayOfByte[k] << 7;
        if (i < 0) {
          k = i ^ 0xFFFFFF80;
        } else {
          k = j + 1;
          i ^= arrayOfByte[j] << 14;
          if (i >= 0) {
            i ^= 0x3F80;
            j = k;
            k = i;
          } else {
            j = k + 1;
            i ^= arrayOfByte[k] << 21;
            if (i < 0) {
              k = i ^ 0xFFE03F80;
            } else {
              int m = j + 1;
              k = arrayOfByte[j];
              i = i ^ k << 28 ^ 0xFE03F80;
              j = m;
              if (k < 0) {
                int n = m + 1;
                k = i;
                j = n;
                if (arrayOfByte[m] < 0) {
                  int i1 = n + 1;
                  j = i1;
                  if (arrayOfByte[n] < 0) {
                    m = i1 + 1;
                    k = i;
                    j = m;
                    if (arrayOfByte[i1] < 0) {
                      k = m + 1;
                      j = k;
                      if (arrayOfByte[m] < 0) {
                        j = k + 1;
                        if (arrayOfByte[k] >= 0) {
                          k = i;
                          this.pos = j;
                          return k;
                        } 
                        return (int)super.zzky();
                      } 
                    } else {
                      this.pos = j;
                      return k;
                    } 
                  } 
                } else {
                  this.pos = j;
                  return k;
                } 
              } 
              k = i;
            } 
          } 
        } 
        this.pos = j;
        return k;
      } 
    } 
    return (int)super.zzky();
  }
  
  private final long zzlc() throws IOException {
    int i = this.pos;
    int j = this.limit;
    if (j != i) {
      byte[] arrayOfByte = this.buffer;
      int k = i + 1;
      i = arrayOfByte[i];
      if (i >= 0) {
        this.pos = k;
        return i;
      } 
      if (j - k >= 9) {
        long l;
        j = k + 1;
        i ^= arrayOfByte[k] << 7;
        if (i < 0) {
          l = (i ^ 0xFFFFFF80);
        } else {
          k = j + 1;
          i ^= arrayOfByte[j] << 14;
          if (i >= 0) {
            l = (i ^ 0x3F80);
            j = k;
          } else {
            j = k + 1;
            k = i ^ arrayOfByte[k] << 21;
            if (k < 0) {
              l = (k ^ 0xFFE03F80);
            } else {
              l = k;
              k = j + 1;
              l ^= arrayOfByte[j] << 28L;
              if (l >= 0L) {
                l = 0xFE03F80L ^ l;
                j = k;
              } else {
                j = k + 1;
                l ^= arrayOfByte[k] << 35L;
                if (l < 0L) {
                  l ^= 0xFFFFFFF80FE03F80L;
                } else {
                  k = j + 1;
                  l ^= arrayOfByte[j] << 42L;
                  if (l >= 0L) {
                    l = 0x3F80FE03F80L ^ l;
                    j = k;
                  } else {
                    i = k + 1;
                    l ^= arrayOfByte[k] << 49L;
                    if (l < 0L) {
                      l ^= 0xFFFE03F80FE03F80L;
                      j = i;
                    } else {
                      j = i + 1;
                      l = l ^ arrayOfByte[i] << 56L ^ 0xFE03F80FE03F80L;
                      if (l < 0L) {
                        k = j + 1;
                        if (arrayOfByte[j] >= 0L) {
                          j = k;
                          this.pos = j;
                          return l;
                        } 
                      } else {
                        this.pos = j;
                        return l;
                      } 
                      return super.zzky();
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
        this.pos = j;
        return l;
      } 
    } 
    return super.zzky();
  }
  
  private final int zzld() throws IOException {
    int i = this.pos;
    if (this.limit - i >= 4) {
      byte[] arrayOfByte = this.buffer;
      this.pos = i + 4;
      byte b1 = arrayOfByte[i];
      byte b2 = arrayOfByte[i + 1];
      byte b3 = arrayOfByte[i + 2];
      return (arrayOfByte[i + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
    } 
    throw zzfh.zzmu();
  }
  
  private final long zzle() throws IOException {
    int i = this.pos;
    if (this.limit - i >= 8) {
      byte[] arrayOfByte = this.buffer;
      this.pos = i + 8;
      long l1 = arrayOfByte[i];
      long l2 = arrayOfByte[i + 1];
      long l3 = arrayOfByte[i + 2];
      long l4 = arrayOfByte[i + 3];
      long l5 = arrayOfByte[i + 4];
      long l6 = arrayOfByte[i + 5];
      long l7 = arrayOfByte[i + 6];
      return (arrayOfByte[i + 7] & 0xFFL) << 56L | l1 & 0xFFL | (l2 & 0xFFL) << 8L | (l3 & 0xFFL) << 16L | (l4 & 0xFFL) << 24L | (l5 & 0xFFL) << 32L | (l6 & 0xFFL) << 40L | (l7 & 0xFFL) << 48L;
    } 
    throw zzfh.zzmu();
  }
  
  private final void zzlf() {
    this.limit += this.zzacn;
    int i = this.limit;
    int j = i - this.zzaco;
    int k = this.zzacq;
    if (j > k) {
      this.zzacn = j - k;
      this.limit = i - this.zzacn;
      return;
    } 
    this.zzacn = 0;
  }
  
  private final byte zzlg() throws IOException {
    int i = this.pos;
    if (i != this.limit) {
      byte[] arrayOfByte = this.buffer;
      this.pos = i + 1;
      return arrayOfByte[i];
    } 
    throw zzfh.zzmu();
  }
  
  public final double readDouble() throws IOException {
    return Double.longBitsToDouble(zzle());
  }
  
  public final float readFloat() throws IOException {
    return Float.intBitsToFloat(zzld());
  }
  
  public final String readString() throws IOException {
    int i = zzlb();
    if (i > 0) {
      int j = this.limit;
      int k = this.pos;
      if (i <= j - k) {
        String str = new String(this.buffer, k, i, zzfb.UTF_8);
        this.pos += i;
        return str;
      } 
    } 
    if (i == 0)
      return ""; 
    if (i < 0)
      throw zzfh.zzmv(); 
    throw zzfh.zzmu();
  }
  
  public final <T extends zzgh> T zza(zzgs<T> paramzzgs, zzem paramzzem) throws IOException {
    int i = zzlb();
    if (this.zzach < this.zzaci) {
      i = super.zzx(i);
      this.zzach++;
      zzgh zzgh = (zzgh)paramzzgs.zza(this, paramzzem);
      super.zzu(0);
      this.zzach--;
      super.zzy(i);
      return (T)zzgh;
    } 
    throw zzfh.zzna();
  }
  
  public final int zzkj() throws IOException {
    if (super.zzkz()) {
      this.zzacp = 0;
      return 0;
    } 
    this.zzacp = zzlb();
    int i = this.zzacp;
    if (i >>> 3 != 0)
      return i; 
    throw zzfh.zzmx();
  }
  
  public final long zzkk() throws IOException {
    return zzlc();
  }
  
  public final long zzkl() throws IOException {
    return zzlc();
  }
  
  public final int zzkm() throws IOException {
    return zzlb();
  }
  
  public final long zzkn() throws IOException {
    return zzle();
  }
  
  public final int zzko() throws IOException {
    return zzld();
  }
  
  public final boolean zzkp() throws IOException {
    return (zzlc() != 0L);
  }
  
  public final String zzkq() throws IOException {
    int i = zzlb();
    if (i > 0) {
      int j = this.limit;
      int k = this.pos;
      if (i <= j - k) {
        String str = zzhy.zzh(this.buffer, k, i);
        this.pos += i;
        return str;
      } 
    } 
    if (i == 0)
      return ""; 
    if (i <= 0)
      throw zzfh.zzmv(); 
    throw zzfh.zzmu();
  }
  
  public final zzdp zzkr() throws IOException {
    int i = zzlb();
    if (i > 0) {
      int j = this.limit;
      int k = this.pos;
      if (i <= j - k) {
        zzdp zzdp = zzdp.zzb(this.buffer, k, i);
        this.pos += i;
        return zzdp;
      } 
    } 
    if (i == 0)
      return zzdp.zzaby; 
    if (i > 0) {
      int k = this.limit;
      int j = this.pos;
      if (i <= k - j) {
        this.pos = i + j;
        byte[] arrayOfByte = Arrays.copyOfRange(this.buffer, j, this.pos);
        return zzdp.zzg(arrayOfByte);
      } 
    } 
    if (i <= 0) {
      if (i == 0) {
        byte[] arrayOfByte = zzfb.zzahk;
        return zzdp.zzg(arrayOfByte);
      } 
      throw zzfh.zzmv();
    } 
    throw zzfh.zzmu();
  }
  
  public final int zzks() throws IOException {
    return zzlb();
  }
  
  public final int zzkt() throws IOException {
    return zzlb();
  }
  
  public final int zzku() throws IOException {
    return zzld();
  }
  
  public final long zzkv() throws IOException {
    return zzle();
  }
  
  public final int zzkw() throws IOException {
    return zzaa(zzlb());
  }
  
  public final long zzkx() throws IOException {
    return zzap(zzlc());
  }
  
  final long zzky() throws IOException {
    long l = 0L;
    for (byte b = 0; b < 64; b += 7) {
      byte b1 = zzlg();
      l |= (b1 & Byte.MAX_VALUE) << b;
      if ((b1 & 0x80) == 0)
        return l; 
    } 
    throw zzfh.zzmw();
  }
  
  public final boolean zzkz() throws IOException {
    return (this.pos == this.limit);
  }
  
  public final int zzla() {
    return this.pos - this.zzaco;
  }
  
  public final void zzu(int paramInt) throws zzfh {
    if (this.zzacp == paramInt)
      return; 
    throw zzfh.zzmy();
  }
  
  public final boolean zzv(int paramInt) throws IOException {
    boolean bool = false;
    int i = 0;
    switch (paramInt & 0x7) {
      default:
        throw zzfh.zzmz();
      case 5:
        super.zzz(4);
        return true;
      case 4:
        return false;
      case 3:
        do {
          i = super.zzkj();
        } while (i != 0 && super.zzv(i));
        super.zzu(paramInt >>> 3 << 3 | 0x4);
        return true;
      case 2:
        super.zzz(zzlb());
        return true;
      case 1:
        super.zzz(8);
        return true;
      case 0:
        break;
    } 
    paramInt = bool;
    if (this.limit - this.pos >= 10) {
      paramInt = i;
      while (paramInt < 10) {
        byte[] arrayOfByte = this.buffer;
        i = this.pos;
        this.pos = i + 1;
        if (arrayOfByte[i] < 0) {
          paramInt++;
          continue;
        } 
        return true;
      } 
      throw zzfh.zzmw();
    } 
    while (paramInt < 10) {
      if (zzlg() < 0) {
        paramInt++;
        continue;
      } 
      return true;
    } 
    throw zzfh.zzmw();
  }
  
  public final int zzx(int paramInt) throws zzfh {
    if (paramInt >= 0) {
      paramInt += super.zzla();
      int i = this.zzacq;
      if (paramInt <= i) {
        this.zzacq = paramInt;
        zzlf();
        return i;
      } 
      throw zzfh.zzmu();
    } 
    throw zzfh.zzmv();
  }
  
  public final void zzy(int paramInt) {
    this.zzacq = paramInt;
    zzlf();
  }
  
  public final void zzz(int paramInt) throws IOException {
    if (paramInt >= 0) {
      int i = this.limit;
      int j = this.pos;
      if (paramInt <= i - j) {
        this.pos = j + paramInt;
        return;
      } 
    } 
    if (paramInt < 0)
      throw zzfh.zzmv(); 
    throw zzfh.zzmu();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */