package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

public final class zzey {
  private static final zzey zzoz = new zzey(0, new int[0], new Object[0], false);
  
  private int count;
  
  private boolean zzfa;
  
  private int zzjq = -1;
  
  private Object[] zzmj;
  
  private int[] zzpa;
  
  private zzey() {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzey(int paramInt, int[] paramArrayOfint, Object[] paramArrayOfObject, boolean paramBoolean) {
    this.count = paramInt;
    this.zzpa = paramArrayOfint;
    this.zzmj = paramArrayOfObject;
    this.zzfa = paramBoolean;
  }
  
  static zzey zza(zzey paramzzey1, zzey paramzzey2) {
    int i = paramzzey1.count + paramzzey2.count;
    int[] arrayOfInt = Arrays.copyOf(paramzzey1.zzpa, i);
    System.arraycopy(paramzzey2.zzpa, 0, arrayOfInt, paramzzey1.count, paramzzey2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramzzey1.zzmj, i);
    System.arraycopy(paramzzey2.zzmj, 0, arrayOfObject, paramzzey1.count, paramzzey2.count);
    return new zzey(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void zzb(int paramInt, Object paramObject, zzfr paramzzfr) throws IOException {
    int i = paramInt >>> 3;
    paramInt &= 0x7;
    if (paramInt != 5) {
      switch (paramInt) {
        default:
          throw new RuntimeException(zzco.zzbn());
        case 3:
          if (paramzzfr.zzaj() == zzcg.zzg.zzko) {
            paramzzfr.zzaa(i);
            ((zzey)paramObject).zzb(paramzzfr);
            paramzzfr.zzab(i);
            return;
          } 
          paramzzfr.zzab(i);
          ((zzey)paramObject).zzb(paramzzfr);
          paramzzfr.zzaa(i);
          return;
        case 2:
          paramzzfr.zza(i, (zzbb)paramObject);
          return;
        case 1:
          paramzzfr.zzc(i, ((Long)paramObject).longValue());
          return;
        case 0:
          break;
      } 
      paramzzfr.zzi(i, ((Long)paramObject).longValue());
      return;
    } 
    paramzzfr.zzf(i, ((Integer)paramObject).intValue());
  }
  
  public static zzey zzea() {
    return zzoz;
  }
  
  static zzey zzeb() {
    return new zzey();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof zzey))
      return false; 
    paramObject = paramObject;
    int i = this.count;
    if (i == ((zzey)paramObject).count) {
      int[] arrayOfInt1 = this.zzpa;
      int[] arrayOfInt2 = ((zzey)paramObject).zzpa;
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
        Object[] arrayOfObject = this.zzmj;
        paramObject = ((zzey)paramObject).zzmj;
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
    int[] arrayOfInt = this.zzpa;
    boolean bool = false;
    int j = 17;
    byte b = 0;
    int k = 17;
    while (b < i) {
      k = k * 31 + arrayOfInt[b];
      b++;
    } 
    Object[] arrayOfObject = this.zzmj;
    int m = this.count;
    for (b = bool; b < m; b++)
      j = j * 31 + arrayOfObject[b].hashCode(); 
    return ((i + 527) * 31 + k) * 31 + j;
  }
  
  final void zza(zzfr paramzzfr) throws IOException {
    if (paramzzfr.zzaj() == zzcg.zzg.zzkp) {
      for (int i = this.count - 1; i >= 0; i--)
        paramzzfr.zza(this.zzpa[i] >>> 3, this.zzmj[i]); 
      return;
    } 
    for (byte b = 0; b < this.count; b++)
      paramzzfr.zza(this.zzpa[b] >>> 3, this.zzmj[b]); 
  }
  
  final void zza(StringBuilder paramStringBuilder, int paramInt) {
    for (byte b = 0; b < this.count; b++)
      zzdr.zza(paramStringBuilder, paramInt, String.valueOf(this.zzpa[b] >>> 3), this.zzmj[b]); 
  }
  
  public final int zzas() {
    int i = this.zzjq;
    if (i != -1)
      return i; 
    byte b = 0;
    int j = 0;
    while (b < this.count) {
      int k = this.zzpa[b];
      i = k >>> 3;
      k &= 0x7;
      if (k != 5) {
        switch (k) {
          default:
            throw new IllegalStateException(zzco.zzbn());
          case 3:
            i = (zzbn.zzr(i) << 1) + ((zzey)this.zzmj[b]).zzas();
            break;
          case 2:
            i = zzbn.zzc(i, (zzbb)this.zzmj[b]);
            break;
          case 1:
            i = zzbn.zzg(i, ((Long)this.zzmj[b]).longValue());
            break;
          case 0:
            i = zzbn.zze(i, ((Long)this.zzmj[b]).longValue());
            break;
        } 
      } else {
        i = zzbn.zzj(i, ((Integer)this.zzmj[b]).intValue());
      } 
      j += i;
      b++;
    } 
    this.zzjq = j;
    return j;
  }
  
  final void zzb(int paramInt, Object paramObject) {
    if (this.zzfa) {
      int i = this.count;
      if (i == this.zzpa.length) {
        if (i < 4) {
          i = 8;
        } else {
          i >>= 1;
        } 
        i = this.count + i;
        this.zzpa = Arrays.copyOf(this.zzpa, i);
        this.zzmj = Arrays.copyOf(this.zzmj, i);
      } 
      int[] arrayOfInt = this.zzpa;
      i = this.count;
      arrayOfInt[i] = paramInt;
      this.zzmj[i] = paramObject;
      this.count = i + 1;
      return;
    } 
    throw new UnsupportedOperationException();
  }
  
  public final void zzb(zzfr paramzzfr) throws IOException {
    if (this.count == 0)
      return; 
    if (paramzzfr.zzaj() == zzcg.zzg.zzko) {
      for (byte b = 0; b < this.count; b++)
        zzb(this.zzpa[b], this.zzmj[b], paramzzfr); 
      return;
    } 
    for (int i = this.count - 1; i >= 0; i--)
      zzb(this.zzpa[i], this.zzmj[i], paramzzfr); 
  }
  
  public final int zzec() {
    int i = this.zzjq;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.count) {
      j += zzbn.zzd(this.zzpa[i] >>> 3, (zzbb)this.zzmj[i]);
      i++;
    } 
    this.zzjq = j;
    return j;
  }
  
  public final void zzv() {
    this.zzfa = false;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */