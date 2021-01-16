package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zziv {
  protected volatile int zzanm = -1;
  
  public static final <T extends zziv> T zza(T paramT, byte[] paramArrayOfbyte) throws zziu {
    return zza(paramT, paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  private static final <T extends zziv> T zza(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws zziu {
    try {
      zzim zzim = zzim.zzj(paramArrayOfbyte, 0, paramInt2);
      paramT.zza(zzim);
      zzim.zzu(0);
      return paramT;
    } catch (zziu zziu) {
      throw zziu;
    } catch (IOException iOException) {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
    } 
  }
  
  public static final byte[] zzb(zziv paramzziv) {
    byte[] arrayOfByte = new byte[paramzziv.zzly()];
    int i = arrayOfByte.length;
    try {
      zzin zzin = zzin.zzk(arrayOfByte, 0, i);
      paramzziv.zza(zzin);
      zzin.zzlk();
      return arrayOfByte;
    } catch (IOException iOException) {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
    } 
  }
  
  public String toString() {
    return zziw.zzc(this);
  }
  
  public abstract zziv zza(zzim paramzzim) throws IOException;
  
  public void zza(zzin paramzzin) throws IOException {}
  
  protected int zzja() {
    return 0;
  }
  
  public final int zzly() {
    int i = zzja();
    this.zzanm = i;
    return i;
  }
  
  public zziv zzpe() throws CloneNotSupportedException {
    return (zziv)super.clone();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zziv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */