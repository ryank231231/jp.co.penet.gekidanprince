package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzdp implements Serializable, Iterable<Byte> {
  public static final zzdp zzaby = new zzdz(zzfb.zzahk);
  
  private static final zzdv zzabz;
  
  private static final Comparator<zzdp> zzacb = new zzdr();
  
  private int zzaca = 0;
  
  private static int zza(byte paramByte) {
    return paramByte & 0xFF;
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
  
  public static zzdp zzb(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    return new zzdz(zzabz.zzc(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  public static zzdp zzcn(String paramString) {
    return new zzdz(paramString.getBytes(zzfb.UTF_8));
  }
  
  static zzdp zzg(byte[] paramArrayOfbyte) {
    return new zzdz(paramArrayOfbyte);
  }
  
  static zzdx zzt(int paramInt) {
    return new zzdx(paramInt, null);
  }
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode() {
    int i = this.zzaca;
    int j = i;
    if (i == 0) {
      j = size();
      i = zza(j, 0, j);
      j = i;
      if (i == 0)
        j = 1; 
      this.zzaca = j;
    } 
    return j;
  }
  
  public abstract int size();
  
  public final String toString() {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  protected abstract int zza(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract zzdp zza(int paramInt1, int paramInt2);
  
  protected abstract String zza(Charset paramCharset);
  
  abstract void zza(zzdo paramzzdo) throws IOException;
  
  public final String zzkd() {
    Charset charset = zzfb.UTF_8;
    return (size() == 0) ? "" : zza(charset);
  }
  
  public abstract boolean zzke();
  
  protected final int zzkf() {
    return this.zzaca;
  }
  
  public abstract byte zzr(int paramInt);
  
  abstract byte zzs(int paramInt);
  
  static {
    zzdt zzdt;
  }
  
  static {
    if (zzdk.zzkb()) {
      zzea zzea = new zzea(null);
    } else {
      zzdt = new zzdt(null);
    } 
    zzabz = zzdt;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */