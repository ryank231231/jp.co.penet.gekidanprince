package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class zzbb implements Serializable, Iterable<Byte> {
  static {
    if (zzaw.zzx()) {
      zzbj zzbj = new zzbj(null);
    } else {
      zzbd = new zzbd(null);
    } 
    zzfj = zzbd;
  }
  
  static int zzb(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0) {
      if (paramInt1 >= 0) {
        if (paramInt2 < paramInt1) {
          StringBuilder stringBuilder2 = new StringBuilder(66);
          stringBuilder2.append("Beginning index larger than ending index: ");
          stringBuilder2.append(paramInt1);
          stringBuilder2.append(", ");
          stringBuilder2.append(paramInt2);
          throw new IndexOutOfBoundsException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder(37);
        stringBuilder1.append("End index: ");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" >= ");
        stringBuilder1.append(paramInt3);
        throw new IndexOutOfBoundsException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder(32);
      stringBuilder.append("Beginning index: ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    } 
    return i;
  }
  
  public static zzbb zzb(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return new zzbi(zzfj.zzc(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  public static zzbb zzf(String paramString) {
    return new zzbi(paramString.getBytes(zzci.UTF_8));
  }
  
  static zzbg zzk(int paramInt) {
    return new zzbg(paramInt, null);
  }
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode() {
    int i = this.zzfk;
    int j = i;
    if (i == 0) {
      j = size();
      i = zza(j, 0, j);
      j = i;
      if (i == 0)
        j = 1; 
      this.zzfk = j;
    } 
    return j;
  }
  
  public abstract int size();
  
  public final String toString() {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  protected abstract int zza(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract zzbb zza(int paramInt1, int paramInt2);
  
  protected abstract String zza(Charset paramCharset);
  
  abstract void zza(zzba paramzzba) throws IOException;
  
  public abstract boolean zzaa();
  
  protected final int zzab() {
    return this.zzfk;
  }
  
  public abstract byte zzj(int paramInt);
  
  public final String zzz() {
    Charset charset = zzci.UTF_8;
    return (size() == 0) ? "" : zza(charset);
  }
  
  static {
    zzbd zzbd;
  }
  
  public static final zzbb zzfi = new zzbi(zzci.zzkt);
  
  private static final zzbf zzfj;
  
  private int zzfk = 0;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */