package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzeb {
  int zzach;
  
  int zzaci = 100;
  
  private int zzacj = Integer.MAX_VALUE;
  
  zzee zzack;
  
  private boolean zzacl = false;
  
  private zzeb() {}
  
  static zzeb zza(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    zzed zzed = new zzed(paramArrayOfbyte, paramInt1, paramInt2, false, null);
    try {
      zzed.zzx(paramInt2);
      return zzed;
    } catch (zzfh zzfh) {
      throw new IllegalArgumentException(zzfh);
    } 
  }
  
  public static int zzaa(int paramInt) {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public static long zzap(long paramLong) {
    return -(paramLong & 0x1L) ^ paramLong >>> 1L;
  }
  
  public static zzeb zzd(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return zza(paramArrayOfbyte, paramInt1, paramInt2, false);
  }
  
  public abstract double readDouble() throws IOException;
  
  public abstract float readFloat() throws IOException;
  
  public abstract String readString() throws IOException;
  
  public abstract <T extends zzgh> T zza(zzgs<T> paramzzgs, zzem paramzzem) throws IOException;
  
  public abstract int zzkj() throws IOException;
  
  public abstract long zzkk() throws IOException;
  
  public abstract long zzkl() throws IOException;
  
  public abstract int zzkm() throws IOException;
  
  public abstract long zzkn() throws IOException;
  
  public abstract int zzko() throws IOException;
  
  public abstract boolean zzkp() throws IOException;
  
  public abstract String zzkq() throws IOException;
  
  public abstract zzdp zzkr() throws IOException;
  
  public abstract int zzks() throws IOException;
  
  public abstract int zzkt() throws IOException;
  
  public abstract int zzku() throws IOException;
  
  public abstract long zzkv() throws IOException;
  
  public abstract int zzkw() throws IOException;
  
  public abstract long zzkx() throws IOException;
  
  abstract long zzky() throws IOException;
  
  public abstract boolean zzkz() throws IOException;
  
  public abstract int zzla();
  
  public abstract void zzu(int paramInt) throws zzfh;
  
  public abstract boolean zzv(int paramInt) throws IOException;
  
  public final int zzw(int paramInt) {
    if (paramInt >= 0) {
      int i = this.zzaci;
      this.zzaci = paramInt;
      return i;
    } 
    StringBuilder stringBuilder = new StringBuilder(47);
    stringBuilder.append("Recursion limit cannot be negative: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public abstract int zzx(int paramInt) throws zzfh;
  
  public abstract void zzy(int paramInt);
  
  public abstract void zzz(int paramInt) throws IOException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */