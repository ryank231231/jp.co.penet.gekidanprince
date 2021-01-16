package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Map;

final class zzbv extends zzbu<zzcg.zze> {
  final int zza(Map.Entry<?, ?> paramEntry) {
    return ((zzcg.zze)paramEntry.getKey()).number;
  }
  
  final zzby<zzcg.zze> zza(Object paramObject) {
    return ((zzcg.zzd)paramObject).zzjv;
  }
  
  final void zza(zzfr paramzzfr, Map.Entry<?, ?> paramEntry) throws IOException {
    zzcg.zze zze = (zzcg.zze)paramEntry.getKey();
    switch (zzbw.zzgq[zze.zzjx.ordinal()]) {
      default:
        return;
      case 18:
        paramzzfr.zza(zze.number, paramEntry.getValue(), zzea.zzcm().zze(paramEntry.getValue().getClass()));
      case 17:
        paramzzfr.zzb(zze.number, paramEntry.getValue(), zzea.zzcm().zze(paramEntry.getValue().getClass()));
        return;
      case 16:
        paramzzfr.zza(zze.number, (String)paramEntry.getValue());
        return;
      case 15:
        paramzzfr.zza(zze.number, (zzbb)paramEntry.getValue());
        return;
      case 14:
        paramzzfr.zzc(zze.number, ((Integer)paramEntry.getValue()).intValue());
        return;
      case 13:
        paramzzfr.zzb(zze.number, ((Long)paramEntry.getValue()).longValue());
        return;
      case 12:
        paramzzfr.zze(zze.number, ((Integer)paramEntry.getValue()).intValue());
        return;
      case 11:
        paramzzfr.zzj(zze.number, ((Long)paramEntry.getValue()).longValue());
        return;
      case 10:
        paramzzfr.zzm(zze.number, ((Integer)paramEntry.getValue()).intValue());
        return;
      case 9:
        paramzzfr.zzd(zze.number, ((Integer)paramEntry.getValue()).intValue());
        return;
      case 8:
        paramzzfr.zzb(zze.number, ((Boolean)paramEntry.getValue()).booleanValue());
        return;
      case 7:
        paramzzfr.zzf(zze.number, ((Integer)paramEntry.getValue()).intValue());
        return;
      case 6:
        paramzzfr.zzc(zze.number, ((Long)paramEntry.getValue()).longValue());
        return;
      case 5:
        paramzzfr.zzc(zze.number, ((Integer)paramEntry.getValue()).intValue());
        return;
      case 4:
        paramzzfr.zza(zze.number, ((Long)paramEntry.getValue()).longValue());
        return;
      case 3:
        paramzzfr.zzi(zze.number, ((Long)paramEntry.getValue()).longValue());
        return;
      case 2:
        paramzzfr.zza(zze.number, ((Float)paramEntry.getValue()).floatValue());
        return;
      case 1:
        break;
    } 
    paramzzfr.zza(zze.number, ((Double)paramEntry.getValue()).doubleValue());
  }
  
  final void zza(Object paramObject, zzby<zzcg.zze> paramzzby) {
    ((zzcg.zzd)paramObject).zzjv = paramzzby;
  }
  
  final zzby<zzcg.zze> zzb(Object paramObject) {
    zzby<zzcg.zze> zzby1 = super.zza(paramObject);
    zzby<zzcg.zze> zzby2 = zzby1;
    if (zzby1.isImmutable()) {
      zzby2 = (zzby<zzcg.zze>)zzby1.clone();
      super.zza(paramObject, zzby2);
    } 
    return zzby2;
  }
  
  final void zzc(Object paramObject) {
    super.zza(paramObject).zzv();
  }
  
  final boolean zze(zzdo paramzzdo) {
    return paramzzdo instanceof zzcg.zzd;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */