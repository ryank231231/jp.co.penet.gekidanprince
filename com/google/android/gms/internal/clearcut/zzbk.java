package com.google.android.gms.internal.clearcut;

public abstract class zzbk {
  private static volatile boolean zzft = true;
  
  private int zzfq = 100;
  
  private int zzfr = Integer.MAX_VALUE;
  
  private boolean zzfs = false;
  
  private zzbk() {}
  
  public static long zza(long paramLong) {
    return -(paramLong & 0x1L) ^ paramLong >>> 1L;
  }
  
  static zzbk zza(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    zzbm zzbm = new zzbm(paramArrayOfbyte, 0, paramInt2, false, null);
    try {
      zzbm.zzl(paramInt2);
      return zzbm;
    } catch (zzco zzco) {
      throw new IllegalArgumentException(zzco);
    } 
  }
  
  public static int zzm(int paramInt) {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public abstract int zzaf();
  
  public abstract int zzl(int paramInt) throws zzco;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */