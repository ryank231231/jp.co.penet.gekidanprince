package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzhr {
  private static final zzhr zzakp = new zzhr(0, new int[0], new Object[0], false);
  
  private int count;
  
  private boolean zzabp;
  
  private int zzago = -1;
  
  private Object[] zzajb;
  
  private int[] zzakq;
  
  private zzhr() {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzhr(int paramInt, int[] paramArrayOfint, Object[] paramArrayOfObject, boolean paramBoolean) {
    this.count = paramInt;
    this.zzakq = paramArrayOfint;
    this.zzajb = paramArrayOfObject;
    this.zzabp = paramBoolean;
  }
  
  static zzhr zza(zzhr paramzzhr1, zzhr paramzzhr2) {
    int i = paramzzhr1.count + paramzzhr2.count;
    int[] arrayOfInt = Arrays.copyOf(paramzzhr1.zzakq, i);
    System.arraycopy(paramzzhr2.zzakq, 0, arrayOfInt, paramzzhr1.count, paramzzhr2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramzzhr1.zzajb, i);
    System.arraycopy(paramzzhr2.zzajb, 0, arrayOfObject, paramzzhr1.count, paramzzhr2.count);
    return new zzhr(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void zzb(int paramInt, Object paramObject, zzil paramzzil) throws IOException {
    int i = paramInt >>> 3;
    paramInt &= 0x7;
    if (paramInt != 5) {
      switch (paramInt) {
        default:
          throw new RuntimeException(zzfh.zzmz());
        case 3:
          if (paramzzil.zzln() == zzez.zze.zzahf) {
            paramzzil.zzas(i);
            ((zzhr)paramObject).zzb(paramzzil);
            paramzzil.zzat(i);
            return;
          } 
          paramzzil.zzat(i);
          ((zzhr)paramObject).zzb(paramzzil);
          paramzzil.zzas(i);
          return;
        case 2:
          paramzzil.zza(i, (zzdp)paramObject);
          return;
        case 1:
          paramzzil.zzc(i, ((Long)paramObject).longValue());
          return;
        case 0:
          break;
      } 
      paramzzil.zzi(i, ((Long)paramObject).longValue());
      return;
    } 
    paramzzil.zzf(i, ((Integer)paramObject).intValue());
  }
  
  public static zzhr zzor() {
    return zzakp;
  }
  
  static zzhr zzos() {
    return new zzhr();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof zzhr))
      return false; 
    paramObject = paramObject;
    int i = this.count;
    if (i == ((zzhr)paramObject).count) {
      int[] arrayOfInt1 = this.zzakq;
      int[] arrayOfInt2 = ((zzhr)paramObject).zzakq;
      byte b = 0;
      while (true) {
        if (b < i) {
          if (arrayOfInt1[b] != arrayOfInt2[b]) {
            b = 0;
            break;
          } 
          b++;
          continue;
        } 
        b = 1;
        break;
      } 
      if (b != 0) {
        Object[] arrayOfObject = this.zzajb;
        paramObject = ((zzhr)paramObject).zzajb;
        i = this.count;
        b = 0;
        while (true) {
          if (b < i) {
            if (!arrayOfObject[b].equals(paramObject[b])) {
              b = 0;
              break;
            } 
            b++;
            continue;
          } 
          b = 1;
          break;
        } 
        if (b != 0)
          return true; 
      } 
    } 
    return false;
  }
  
  public final int hashCode() {
    int i = this.count;
    int[] arrayOfInt = this.zzakq;
    byte b1 = 0;
    byte b2 = 17;
    int j = 0;
    int k = 17;
    while (j < i) {
      k = k * 31 + arrayOfInt[j];
      j++;
    } 
    Object[] arrayOfObject = this.zzajb;
    int m = this.count;
    j = b2;
    while (b1 < m) {
      j = j * 31 + arrayOfObject[b1].hashCode();
      b1++;
    } 
    return ((i + 527) * 31 + k) * 31 + j;
  }
  
  final void zza(zzil paramzzil) throws IOException {
    if (paramzzil.zzln() == zzez.zze.zzahg) {
      for (int i = this.count - 1; i >= 0; i--)
        paramzzil.zza(this.zzakq[i] >>> 3, this.zzajb[i]); 
      return;
    } 
    for (byte b = 0; b < this.count; b++)
      paramzzil.zza(this.zzakq[b] >>> 3, this.zzajb[b]); 
  }
  
  final void zzb(int paramInt, Object paramObject) {
    if (this.zzabp) {
      int i = this.count;
      if (i == this.zzakq.length) {
        if (i < 4) {
          i = 8;
        } else {
          i >>= 1;
        } 
        i = this.count + i;
        this.zzakq = Arrays.copyOf(this.zzakq, i);
        this.zzajb = Arrays.copyOf(this.zzajb, i);
      } 
      int[] arrayOfInt = this.zzakq;
      i = this.count;
      arrayOfInt[i] = paramInt;
      this.zzajb[i] = paramObject;
      this.count = i + 1;
      return;
    } 
    throw new UnsupportedOperationException();
  }
  
  public final void zzb(zzil paramzzil) throws IOException {
    if (this.count == 0)
      return; 
    if (paramzzil.zzln() == zzez.zze.zzahf) {
      for (byte b = 0; b < this.count; b++)
        zzb(this.zzakq[b], this.zzajb[b], paramzzil); 
      return;
    } 
    for (int i = this.count - 1; i >= 0; i--)
      zzb(this.zzakq[i], this.zzajb[i], paramzzil); 
  }
  
  final void zzb(StringBuilder paramStringBuilder, int paramInt) {
    for (byte b = 0; b < this.count; b++)
      zzgk.zzb(paramStringBuilder, paramInt, String.valueOf(this.zzakq[b] >>> 3), this.zzajb[b]); 
  }
  
  public final void zzjz() {
    this.zzabp = false;
  }
  
  public final int zzly() {
    int i = this.zzago;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.count) {
      int j = this.zzakq[b];
      int k = j >>> 3;
      j &= 0x7;
      if (j != 5) {
        switch (j) {
          default:
            throw new IllegalStateException(zzfh.zzmz());
          case 3:
            i += (zzeg.zzaj(k) << 1) + ((zzhr)this.zzajb[b]).zzly();
            break;
          case 2:
            i += zzeg.zzc(k, (zzdp)this.zzajb[b]);
            break;
          case 1:
            i += zzeg.zzg(k, ((Long)this.zzajb[b]).longValue());
            break;
          case 0:
            i += zzeg.zze(k, ((Long)this.zzajb[b]).longValue());
            break;
        } 
      } else {
        i += zzeg.zzj(k, ((Integer)this.zzajb[b]).intValue());
      } 
      b++;
    } 
    this.zzago = i;
    return i;
  }
  
  public final int zzot() {
    int i = this.zzago;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.count) {
      j += zzeg.zzd(this.zzakq[i] >>> 3, (zzdp)this.zzajb[i]);
      i++;
    } 
    this.zzago = j;
    return j;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */