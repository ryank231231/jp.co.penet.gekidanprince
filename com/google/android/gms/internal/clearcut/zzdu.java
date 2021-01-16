package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Map;

final class zzdu<T> implements zzef<T> {
  private final zzdo zzmn;
  
  private final boolean zzmo;
  
  private final zzex<?, ?> zzmx;
  
  private final zzbu<?> zzmy;
  
  private zzdu(zzex<?, ?> paramzzex, zzbu<?> paramzzbu, zzdo paramzzdo) {
    this.zzmx = paramzzex;
    this.zzmo = paramzzbu.zze(paramzzdo);
    this.zzmy = paramzzbu;
    this.zzmn = paramzzdo;
  }
  
  static <T> zzdu<T> zza(zzex<?, ?> paramzzex, zzbu<?> paramzzbu, zzdo paramzzdo) {
    return new zzdu<T>(paramzzex, paramzzbu, paramzzdo);
  }
  
  public final boolean equals(T paramT1, T paramT2) {
    return !this.zzmx.zzq(paramT1).equals(this.zzmx.zzq(paramT2)) ? false : (this.zzmo ? this.zzmy.zza(paramT1).equals(this.zzmy.zza(paramT2)) : true);
  }
  
  public final int hashCode(T paramT) {
    int i = this.zzmx.zzq(paramT).hashCode();
    int j = i;
    if (this.zzmo)
      j = i * 53 + this.zzmy.zza(paramT).hashCode(); 
    return j;
  }
  
  public final T newInstance() {
    return (T)this.zzmn.zzbd().zzbi();
  }
  
  public final void zza(T paramT, zzfr paramzzfr) throws IOException {
    for (Map.Entry entry : this.zzmy.zza(paramT)) {
      zzca zzca = (zzca)entry.getKey();
      if (zzca.zzav() == zzfq.zzrf && !zzca.zzaw() && !zzca.zzax()) {
        zzbb zzbb;
        int i;
        if (entry instanceof zzct) {
          i = zzca.zzc();
          zzbb = ((zzct)entry).zzbs().zzr();
        } else {
          i = zzca.zzc();
          zzbb = (zzbb)zzbb.getValue();
        } 
        paramzzfr.zza(i, zzbb);
        continue;
      } 
      throw new IllegalStateException("Found invalid MessageSet item.");
    } 
    zzex<?, ?> zzex1 = this.zzmx;
    zzex1.zzc(zzex1.zzq(paramT), paramzzfr);
  }
  
  public final void zza(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, zzay paramzzay) throws IOException {
    zzcg zzcg = (zzcg)paramT;
    zzey zzey2 = zzcg.zzjp;
    zzey zzey1 = zzey2;
    if (zzey2 == zzey.zzea()) {
      zzey1 = zzey.zzeb();
      zzcg.zzjp = zzey1;
    } 
    while (paramInt1 < paramInt2) {
      zzbb zzbb;
      paramInt1 = zzax.zza(paramArrayOfbyte, paramInt1, paramzzay);
      int i = paramzzay.zzfd;
      if (i != 11) {
        if ((i & 0x7) == 2) {
          paramInt1 = zzax.zza(i, paramArrayOfbyte, paramInt1, paramInt2, zzey1, paramzzay);
          continue;
        } 
        paramInt1 = zzax.zza(i, paramArrayOfbyte, paramInt1, paramInt2, paramzzay);
        continue;
      } 
      int j = 0;
      zzey2 = null;
      while (true) {
        i = paramInt1;
        if (paramInt1 < paramInt2) {
          paramInt1 = zzax.zza(paramArrayOfbyte, paramInt1, paramzzay);
          int k = paramzzay.zzfd;
          i = k & 0x7;
          switch (k >>> 3) {
            case 3:
              if (i == 2) {
                paramInt1 = zzax.zze(paramArrayOfbyte, paramInt1, paramzzay);
                zzbb = (zzbb)paramzzay.zzff;
                continue;
              } 
              break;
            case 2:
              if (i == 0) {
                paramInt1 = zzax.zza(paramArrayOfbyte, paramInt1, paramzzay);
                j = paramzzay.zzfd;
                continue;
              } 
              break;
          } 
          i = paramInt1;
          if (k != 12) {
            paramInt1 = zzax.zza(k, paramArrayOfbyte, paramInt1, paramInt2, paramzzay);
            continue;
          } 
        } 
        break;
      } 
      if (zzbb != null)
        zzey1.zzb(j << 3 | 0x2, zzbb); 
      paramInt1 = i;
    } 
    if (paramInt1 == paramInt2)
      return; 
    throw zzco.zzbo();
  }
  
  public final void zzc(T paramT) {
    this.zzmx.zzc(paramT);
    this.zzmy.zzc(paramT);
  }
  
  public final void zzc(T paramT1, T paramT2) {
    zzeh.zza(this.zzmx, paramT1, paramT2);
    if (this.zzmo)
      zzeh.zza(this.zzmy, paramT1, paramT2); 
  }
  
  public final int zzm(T paramT) {
    zzex<?, ?> zzex1 = this.zzmx;
    int i = zzex1.zzr(zzex1.zzq(paramT)) + 0;
    int j = i;
    if (this.zzmo)
      j = i + this.zzmy.zza(paramT).zzat(); 
    return j;
  }
  
  public final boolean zzo(T paramT) {
    return this.zzmy.zza(paramT).isInitialized();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */