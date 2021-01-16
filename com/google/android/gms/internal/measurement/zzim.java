package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzim {
  private final byte[] buffer;
  
  private int zzach;
  
  private int zzaci = 64;
  
  private int zzacj = 67108864;
  
  private int zzacn;
  
  private int zzacp;
  
  private int zzacq = Integer.MAX_VALUE;
  
  private final int zzamw;
  
  private final int zzamx;
  
  private int zzamy;
  
  private int zzamz;
  
  private zzeb zzana;
  
  private zzim(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.buffer = paramArrayOfbyte;
    this.zzamw = paramInt1;
    paramInt2 += paramInt1;
    this.zzamy = paramInt2;
    this.zzamx = paramInt2;
    this.zzamz = paramInt1;
  }
  
  public static zzim zzj(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return new zzim(paramArrayOfbyte, 0, paramInt2);
  }
  
  private final void zzlf() {
    this.zzamy += this.zzacn;
    int i = this.zzamy;
    int j = this.zzacq;
    if (i > j) {
      this.zzacn = i - j;
      this.zzamy = i - this.zzacn;
      return;
    } 
    this.zzacn = 0;
  }
  
  private final byte zzlg() throws IOException {
    int i = this.zzamz;
    if (i != this.zzamy) {
      byte[] arrayOfByte = this.buffer;
      this.zzamz = i + 1;
      return arrayOfByte[i];
    } 
    throw zziu.zzpg();
  }
  
  private final void zzz(int paramInt) throws IOException {
    if (paramInt >= 0) {
      int i = this.zzamz;
      int j = this.zzacq;
      if (i + paramInt <= j) {
        if (paramInt <= this.zzamy - i) {
          this.zzamz = i + paramInt;
          return;
        } 
        throw zziu.zzpg();
      } 
      zzz(j - i);
      throw zziu.zzpg();
    } 
    throw zziu.zzph();
  }
  
  public final int getPosition() {
    return this.zzamz - this.zzamw;
  }
  
  public final String readString() throws IOException {
    int i = zzlb();
    if (i >= 0) {
      int j = this.zzamy;
      int k = this.zzamz;
      if (i <= j - k) {
        String str = new String(this.buffer, k, i, zzit.UTF_8);
        this.zzamz += i;
        return str;
      } 
      throw zziu.zzpg();
    } 
    throw zziu.zzph();
  }
  
  public final <T extends zzez<T, ?>> T zza(zzgs<T> paramzzgs) throws IOException {
    try {
      if (this.zzana == null)
        this.zzana = zzeb.zzd(this.buffer, this.zzamw, this.zzamx); 
      int i = this.zzana.zzla();
      int j = this.zzamz - this.zzamw;
      if (i <= j) {
        this.zzana.zzz(j - i);
        this.zzana.zzw(this.zzaci - this.zzach);
        zzez zzez = this.zzana.<zzez>zza(paramzzgs, zzem.zzlt());
        zzv(this.zzacp);
        return (T)zzez;
      } 
      IOException iOException = new IOException();
      this(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      throw iOException;
    } catch (zzfh zzfh) {
      throw new zziu("", zzfh);
    } 
  }
  
  public final void zza(zziv paramzziv) throws IOException {
    int i = zzlb();
    if (this.zzach < this.zzaci) {
      i = zzx(i);
      this.zzach++;
      paramzziv.zza(this);
      zzu(0);
      this.zzach--;
      zzy(i);
      return;
    } 
    throw new zziu("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  public final void zzbj(int paramInt) {
    zzu(paramInt, this.zzacp);
  }
  
  public final int zzkj() throws IOException {
    if (this.zzamz == this.zzamy) {
      this.zzacp = 0;
      return 0;
    } 
    this.zzacp = zzlb();
    int i = this.zzacp;
    if (i != 0)
      return i; 
    throw new zziu("Protocol message contained an invalid tag (zero).");
  }
  
  public final boolean zzkp() throws IOException {
    return (zzlb() != 0);
  }
  
  public final int zzlb() throws IOException {
    int i = zzlg();
    if (i >= 0)
      return i; 
    int j = i & 0x7F;
    i = zzlg();
    if (i >= 0) {
      i = j | i << 7;
    } else {
      i = j | (i & 0x7F) << 7;
      j = zzlg();
      if (j >= 0) {
        i |= j << 14;
      } else {
        j = i | (j & 0x7F) << 14;
        i = zzlg();
        if (i >= 0) {
          i = j | i << 21;
        } else {
          byte b = zzlg();
          j = j | (i & 0x7F) << 21 | b << 28;
          i = j;
          if (b < 0) {
            for (i = 0; i < 5; i++) {
              if (zzlg() >= 0)
                return j; 
            } 
            throw zziu.zzpi();
          } 
        } 
      } 
    } 
    return i;
  }
  
  public final long zzlc() throws IOException {
    byte b = 0;
    long l = 0L;
    while (b < 64) {
      byte b1 = zzlg();
      l |= (b1 & Byte.MAX_VALUE) << b;
      if ((b1 & 0x80) == 0)
        return l; 
      b += 7;
    } 
    throw zziu.zzpi();
  }
  
  public final int zzpd() {
    int i = this.zzacq;
    return (i == Integer.MAX_VALUE) ? -1 : (i - this.zzamz);
  }
  
  public final byte[] zzt(int paramInt1, int paramInt2) {
    if (paramInt2 == 0)
      return zziy.zzanx; 
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.zzamw;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public final void zzu(int paramInt) throws zziu {
    if (this.zzacp == paramInt)
      return; 
    throw new zziu("Protocol message end-group tag did not match expected tag.");
  }
  
  final void zzu(int paramInt1, int paramInt2) {
    int i = this.zzamz;
    int j = this.zzamw;
    if (paramInt1 <= i - j) {
      if (paramInt1 >= 0) {
        this.zzamz = j + paramInt1;
        this.zzacp = paramInt2;
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder(24);
      stringBuilder1.append("Bad position ");
      stringBuilder1.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder(50);
    stringBuilder.append("Position ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" is beyond current ");
    stringBuilder.append(i - j);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final boolean zzv(int paramInt) throws IOException {
    int i;
    switch (paramInt & 0x7) {
      default:
        throw new zziu("Protocol message tag had invalid wire type.");
      case 5:
        zzlg();
        zzlg();
        zzlg();
        zzlg();
        return true;
      case 4:
        return false;
      case 3:
        do {
          i = zzkj();
        } while (i != 0 && zzv(i));
        zzu(paramInt >>> 3 << 3 | 0x4);
        return true;
      case 2:
        zzz(zzlb());
        return true;
      case 1:
        zzlg();
        zzlg();
        zzlg();
        zzlg();
        zzlg();
        zzlg();
        zzlg();
        zzlg();
        return true;
      case 0:
        break;
    } 
    zzlb();
    return true;
  }
  
  public final int zzx(int paramInt) throws zziu {
    if (paramInt >= 0) {
      int i = paramInt + this.zzamz;
      paramInt = this.zzacq;
      if (i <= paramInt) {
        this.zzacq = i;
        zzlf();
        return paramInt;
      } 
      throw zziu.zzpg();
    } 
    throw zziu.zzph();
  }
  
  public final void zzy(int paramInt) {
    this.zzacq = paramInt;
    zzlf();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */