package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public class zzfz {
  protected volatile int zzrs = -1;
  
  public static final void zza(zzfz paramzzfz, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      zzfs zzfs = zzfs.zzh(paramArrayOfbyte, 0, paramInt2);
      paramzzfz.zza(zzfs);
      zzfs.zzem();
      return;
    } catch (IOException iOException) {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
    } 
  }
  
  public String toString() {
    return zzga.zza(this);
  }
  
  public void zza(zzfs paramzzfs) throws IOException {}
  
  public final int zzas() {
    int i = zzen();
    this.zzrs = i;
    return i;
  }
  
  protected int zzen() {
    return 0;
  }
  
  public zzfz zzep() throws CloneNotSupportedException {
    return (zzfz)super.clone();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */