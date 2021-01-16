package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Map;

final class zzgn<T> implements zzgy<T> {
  private final zzgh zzaje;
  
  private final boolean zzajf;
  
  private final zzhq<?, ?> zzajo;
  
  private final zzen<?> zzajp;
  
  private zzgn(zzhq<?, ?> paramzzhq, zzen<?> paramzzen, zzgh paramzzgh) {
    this.zzajo = paramzzhq;
    this.zzajf = paramzzen.zze(paramzzgh);
    this.zzajp = paramzzen;
    this.zzaje = paramzzgh;
  }
  
  static <T> zzgn<T> zza(zzhq<?, ?> paramzzhq, zzen<?> paramzzen, zzgh paramzzgh) {
    return new zzgn<T>(paramzzhq, paramzzen, paramzzgh);
  }
  
  public final boolean equals(T paramT1, T paramT2) {
    return !this.zzajo.zzw(paramT1).equals(this.zzajo.zzw(paramT2)) ? false : (this.zzajf ? this.zzajp.zzg(paramT1).equals(this.zzajp.zzg(paramT2)) : true);
  }
  
  public final int hashCode(T paramT) {
    int i = this.zzajo.zzw(paramT).hashCode();
    int j = i;
    if (this.zzajf)
      j = i * 53 + this.zzajp.zzg(paramT).hashCode(); 
    return j;
  }
  
  public final T newInstance() {
    return (T)this.zzaje.zzml().zzmq();
  }
  
  public final void zza(T paramT, zzgx paramzzgx, zzem paramzzem) throws IOException {
    zzhq<?, ?> zzhq1 = this.zzajo;
    zzen<?> zzen1 = this.zzajp;
    Object object = zzhq1.zzx(paramT);
    zzeq<?> zzeq = zzen1.zzh(paramT);
    try {
      while (true) {
        int i = paramzzgx.zzlh();
        if (i == Integer.MAX_VALUE)
          return; 
        i = paramzzgx.getTag();
        if (i != 11) {
          if ((i & 0x7) == 2) {
            Object object1 = zzen1.zza(paramzzem, this.zzaje, i >>> 3);
            if (object1 != null) {
              zzen1.zza(paramzzgx, object1, paramzzem, zzeq);
            } else {
              boolean bool1 = zzhq1.zza(object, paramzzgx);
              if (!bool1)
                return; 
            } 
          } else {
            boolean bool1 = paramzzgx.zzli();
            if (!bool1)
              return; 
          } 
        } else {
          i = 0;
          Object object1 = null;
          zzdp zzdp = null;
          while (paramzzgx.zzlh() != Integer.MAX_VALUE) {
            int j = paramzzgx.getTag();
            if (j == 16) {
              i = paramzzgx.zzks();
              object1 = zzen1.zza(paramzzem, this.zzaje, i);
              continue;
            } 
            if (j == 26) {
              if (object1 != null) {
                zzen1.zza(paramzzgx, object1, paramzzem, zzeq);
                continue;
              } 
              zzdp = paramzzgx.zzkr();
              continue;
            } 
            if (!paramzzgx.zzli())
              break; 
          } 
          if (paramzzgx.getTag() == 12) {
            if (zzdp != null)
              if (object1 != null) {
                zzen1.zza(zzdp, object1, paramzzem, zzeq);
              } else {
                zzhq1.zza(object, i, zzdp);
              }  
          } else {
            throw zzfh.zzmy();
          } 
        } 
        boolean bool = true;
        if (!bool)
          return; 
      } 
    } finally {
      zzhq1.zzf(paramT, object);
    } 
  }
  
  public final void zza(T paramT, zzil paramzzil) throws IOException {
    for (Map.Entry entry : this.zzajp.zzg(paramT)) {
      zzes zzes = (zzes)entry.getKey();
      if (zzes.zzmb() == zzik.zzamu && !zzes.zzmc() && !zzes.zzmd()) {
        if (entry instanceof zzfm) {
          paramzzil.zza(zzes.zzgp(), ((zzfm)entry).zznf().zzjv());
          continue;
        } 
        paramzzil.zza(zzes.zzgp(), entry.getValue());
        continue;
      } 
      throw new IllegalStateException("Found invalid MessageSet item.");
    } 
    zzhq<?, ?> zzhq1 = this.zzajo;
    zzhq1.zzc(zzhq1.zzw(paramT), paramzzil);
  }
  
  public final void zza(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, zzdm paramzzdm) throws IOException {
    zzez zzez = (zzez)paramT;
    zzhr zzhr1 = zzez.zzagn;
    zzhr zzhr2 = zzhr1;
    if (zzhr1 == zzhr.zzor()) {
      zzhr2 = zzhr.zzos();
      zzez.zzagn = zzhr2;
    } 
    ((zzez.zzc)paramT).zzms();
    paramT = null;
    while (paramInt1 < paramInt2) {
      zzez.zzd zzd;
      zzdp zzdp;
      paramInt1 = zzdl.zza(paramArrayOfbyte, paramInt1, paramzzdm);
      int i = paramzzdm.zzabs;
      if (i != 11) {
        if ((i & 0x7) == 2) {
          zzd = (zzez.zzd)this.zzajp.zza(paramzzdm.zzabv, this.zzaje, i >>> 3);
          if (zzd == null) {
            paramInt1 = zzdl.zza(i, paramArrayOfbyte, paramInt1, paramInt2, zzhr2, paramzzdm);
            continue;
          } 
          zzgu.zznz();
          throw new NoSuchMethodError();
        } 
        paramInt1 = zzdl.zza(i, paramArrayOfbyte, paramInt1, paramInt2, paramzzdm);
        continue;
      } 
      int j = 0;
      zzhr1 = null;
      while (true) {
        i = paramInt1;
        if (paramInt1 < paramInt2) {
          paramInt1 = zzdl.zza(paramArrayOfbyte, paramInt1, paramzzdm);
          int k = paramzzdm.zzabs;
          i = k & 0x7;
          switch (k >>> 3) {
            case 3:
              if (zzd == null) {
                if (i == 2) {
                  paramInt1 = zzdl.zze(paramArrayOfbyte, paramInt1, paramzzdm);
                  zzdp = (zzdp)paramzzdm.zzabu;
                  continue;
                } 
                break;
              } 
              zzgu.zznz();
              throw new NoSuchMethodError();
            case 2:
              if (i == 0) {
                paramInt1 = zzdl.zza(paramArrayOfbyte, paramInt1, paramzzdm);
                j = paramzzdm.zzabs;
                zzd = (zzez.zzd)this.zzajp.zza(paramzzdm.zzabv, this.zzaje, j);
                continue;
              } 
              break;
          } 
          i = paramInt1;
          if (k != 12) {
            paramInt1 = zzdl.zza(k, paramArrayOfbyte, paramInt1, paramInt2, paramzzdm);
            continue;
          } 
        } 
        break;
      } 
      if (zzdp != null)
        zzhr2.zzb(j << 3 | 0x2, zzdp); 
      paramInt1 = i;
    } 
    if (paramInt1 == paramInt2)
      return; 
    throw zzfh.zznb();
  }
  
  public final void zzc(T paramT1, T paramT2) {
    zzha.zza(this.zzajo, paramT1, paramT2);
    if (this.zzajf)
      zzha.zza(this.zzajp, paramT1, paramT2); 
  }
  
  public final void zzi(T paramT) {
    this.zzajo.zzi(paramT);
    this.zzajp.zzi(paramT);
  }
  
  public final int zzs(T paramT) {
    zzhq<?, ?> zzhq1 = this.zzajo;
    int i = zzhq1.zzy(zzhq1.zzw(paramT)) + 0;
    int j = i;
    if (this.zzajf)
      j = i + this.zzajp.zzg(paramT).zzlz(); 
    return j;
  }
  
  public final boolean zzu(T paramT) {
    return this.zzajp.zzg(paramT).isInitialized();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */