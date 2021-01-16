package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzei implements zzil {
  private final zzeg zzacf;
  
  private zzei(zzeg paramzzeg) {
    this.zzacf = zzfb.<zzeg>zza(paramzzeg, "output");
    this.zzacf.zzacw = this;
  }
  
  public static zzei zza(zzeg paramzzeg) {
    return (paramzzeg.zzacw != null) ? paramzzeg.zzacw : new zzei(paramzzeg);
  }
  
  public final void zza(int paramInt, double paramDouble) throws IOException {
    this.zzacf.zza(paramInt, paramDouble);
  }
  
  public final void zza(int paramInt, float paramFloat) throws IOException {
    this.zzacf.zza(paramInt, paramFloat);
  }
  
  public final void zza(int paramInt, long paramLong) throws IOException {
    this.zzacf.zza(paramInt, paramLong);
  }
  
  public final void zza(int paramInt, zzdp paramzzdp) throws IOException {
    this.zzacf.zza(paramInt, paramzzdp);
  }
  
  public final <K, V> void zza(int paramInt, zzga<K, V> paramzzga, Map<K, V> paramMap) throws IOException {
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      this.zzacf.zzb(paramInt, 2);
      this.zzacf.zzag(zzfz.zza(paramzzga, (K)entry.getKey(), (V)entry.getValue()));
      zzfz.zza(this.zzacf, paramzzga, (K)entry.getKey(), (V)entry.getValue());
    } 
  }
  
  public final void zza(int paramInt, Object paramObject) throws IOException {
    if (paramObject instanceof zzdp) {
      this.zzacf.zzb(paramInt, (zzdp)paramObject);
      return;
    } 
    this.zzacf.zzb(paramInt, (zzgh)paramObject);
  }
  
  public final void zza(int paramInt, Object paramObject, zzgy paramzzgy) throws IOException {
    this.zzacf.zza(paramInt, (zzgh)paramObject, paramzzgy);
  }
  
  public final void zza(int paramInt, List<String> paramList) throws IOException {
    boolean bool = paramList instanceof zzfq;
    byte b1 = 0;
    byte b2 = 0;
    if (bool) {
      zzfq zzfq = (zzfq)paramList;
      for (b1 = b2; b1 < paramList.size(); b1++) {
        Object object = zzfq.zzaw(b1);
        if (object instanceof String) {
          this.zzacf.zzb(paramInt, (String)object);
        } else {
          this.zzacf.zza(paramInt, (zzdp)object);
        } 
      } 
      return;
    } 
    while (b1 < paramList.size()) {
      this.zzacf.zzb(paramInt, paramList.get(b1));
      b1++;
    } 
  }
  
  public final void zza(int paramInt, List<?> paramList, zzgy paramzzgy) throws IOException {
    for (byte b = 0; b < paramList.size(); b++)
      zza(paramInt, paramList.get(b), paramzzgy); 
  }
  
  public final void zza(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    byte b = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      b = 0;
      paramInt = 0;
      while (b < paramList.size()) {
        paramInt += zzeg.zzak(((Integer)paramList.get(b)).intValue());
        b++;
      } 
      this.zzacf.zzag(paramInt);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzaf(((Integer)paramList.get(paramInt)).intValue()); 
      return;
    } 
    while (b < paramList.size()) {
      this.zzacf.zzc(paramInt, ((Integer)paramList.get(b)).intValue());
      b++;
    } 
  }
  
  public final void zzas(int paramInt) throws IOException {
    this.zzacf.zzb(paramInt, 3);
  }
  
  public final void zzat(int paramInt) throws IOException {
    this.zzacf.zzb(paramInt, 4);
  }
  
  public final void zzb(int paramInt, long paramLong) throws IOException {
    this.zzacf.zzb(paramInt, paramLong);
  }
  
  public final void zzb(int paramInt, Object paramObject, zzgy<Object> paramzzgy) throws IOException {
    zzeg zzeg1 = this.zzacf;
    paramObject = paramObject;
    zzeg1.zzb(paramInt, 3);
    paramzzgy.zza(paramObject, zzeg1.zzacw);
    zzeg1.zzb(paramInt, 4);
  }
  
  public final void zzb(int paramInt, String paramString) throws IOException {
    this.zzacf.zzb(paramInt, paramString);
  }
  
  public final void zzb(int paramInt, List<zzdp> paramList) throws IOException {
    for (byte b = 0; b < paramList.size(); b++)
      this.zzacf.zza(paramInt, paramList.get(b)); 
  }
  
  public final void zzb(int paramInt, List<?> paramList, zzgy paramzzgy) throws IOException {
    for (byte b = 0; b < paramList.size(); b++)
      zzb(paramInt, paramList.get(b), paramzzgy); 
  }
  
  public final void zzb(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += zzeg.zzan(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.zzacf.zzag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzai(((Integer)paramList.get(paramInt)).intValue()); 
      return;
    } 
    while (i < paramList.size()) {
      this.zzacf.zzf(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    } 
  }
  
  public final void zzb(int paramInt, boolean paramBoolean) throws IOException {
    this.zzacf.zzb(paramInt, paramBoolean);
  }
  
  public final void zzc(int paramInt1, int paramInt2) throws IOException {
    this.zzacf.zzc(paramInt1, paramInt2);
  }
  
  public final void zzc(int paramInt, long paramLong) throws IOException {
    this.zzacf.zzc(paramInt, paramLong);
  }
  
  public final void zzc(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    byte b = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      b = 0;
      paramInt = 0;
      while (b < paramList.size()) {
        paramInt += zzeg.zzat(((Long)paramList.get(b)).longValue());
        b++;
      } 
      this.zzacf.zzag(paramInt);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzaq(((Long)paramList.get(paramInt)).longValue()); 
      return;
    } 
    while (b < paramList.size()) {
      this.zzacf.zza(paramInt, ((Long)paramList.get(b)).longValue());
      b++;
    } 
  }
  
  public final void zzd(int paramInt1, int paramInt2) throws IOException {
    this.zzacf.zzd(paramInt1, paramInt2);
  }
  
  public final void zzd(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += zzeg.zzau(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      } 
      this.zzacf.zzag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzaq(((Long)paramList.get(paramInt)).longValue()); 
      return;
    } 
    while (i < paramList.size()) {
      this.zzacf.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    } 
  }
  
  public final void zze(int paramInt1, int paramInt2) throws IOException {
    this.zzacf.zze(paramInt1, paramInt2);
  }
  
  public final void zze(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    byte b = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      b = 0;
      paramInt = 0;
      while (b < paramList.size()) {
        paramInt += zzeg.zzaw(((Long)paramList.get(b)).longValue());
        b++;
      } 
      this.zzacf.zzag(paramInt);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzas(((Long)paramList.get(paramInt)).longValue()); 
      return;
    } 
    while (b < paramList.size()) {
      this.zzacf.zzc(paramInt, ((Long)paramList.get(b)).longValue());
      b++;
    } 
  }
  
  public final void zzf(int paramInt1, int paramInt2) throws IOException {
    this.zzacf.zzf(paramInt1, paramInt2);
  }
  
  public final void zzf(int paramInt, List<Float> paramList, boolean paramBoolean) throws IOException {
    byte b = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      b = 0;
      paramInt = 0;
      while (b < paramList.size()) {
        paramInt += zzeg.zzb(((Float)paramList.get(b)).floatValue());
        b++;
      } 
      this.zzacf.zzag(paramInt);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zza(((Float)paramList.get(paramInt)).floatValue()); 
      return;
    } 
    while (b < paramList.size()) {
      this.zzacf.zza(paramInt, ((Float)paramList.get(b)).floatValue());
      b++;
    } 
  }
  
  public final void zzg(int paramInt, List<Double> paramList, boolean paramBoolean) throws IOException {
    byte b = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      b = 0;
      paramInt = 0;
      while (b < paramList.size()) {
        paramInt += zzeg.zze(((Double)paramList.get(b)).doubleValue());
        b++;
      } 
      this.zzacf.zzag(paramInt);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzd(((Double)paramList.get(paramInt)).doubleValue()); 
      return;
    } 
    while (b < paramList.size()) {
      this.zzacf.zza(paramInt, ((Double)paramList.get(b)).doubleValue());
      b++;
    } 
  }
  
  public final void zzh(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += zzeg.zzap(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.zzacf.zzag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzaf(((Integer)paramList.get(paramInt)).intValue()); 
      return;
    } 
    while (i < paramList.size()) {
      this.zzacf.zzc(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    } 
  }
  
  public final void zzi(int paramInt, long paramLong) throws IOException {
    this.zzacf.zza(paramInt, paramLong);
  }
  
  public final void zzi(int paramInt, List<Boolean> paramList, boolean paramBoolean) throws IOException {
    byte b = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      b = 0;
      paramInt = 0;
      while (b < paramList.size()) {
        paramInt += zzeg.zzn(((Boolean)paramList.get(b)).booleanValue());
        b++;
      } 
      this.zzacf.zzag(paramInt);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzm(((Boolean)paramList.get(paramInt)).booleanValue()); 
      return;
    } 
    while (b < paramList.size()) {
      this.zzacf.zzb(paramInt, ((Boolean)paramList.get(b)).booleanValue());
      b++;
    } 
  }
  
  public final void zzj(int paramInt, long paramLong) throws IOException {
    this.zzacf.zzc(paramInt, paramLong);
  }
  
  public final void zzj(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    byte b = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      b = 0;
      paramInt = 0;
      while (b < paramList.size()) {
        paramInt += zzeg.zzal(((Integer)paramList.get(b)).intValue());
        b++;
      } 
      this.zzacf.zzag(paramInt);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzag(((Integer)paramList.get(paramInt)).intValue()); 
      return;
    } 
    while (b < paramList.size()) {
      this.zzacf.zzd(paramInt, ((Integer)paramList.get(b)).intValue());
      b++;
    } 
  }
  
  public final void zzk(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += zzeg.zzao(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.zzacf.zzag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzai(((Integer)paramList.get(paramInt)).intValue()); 
      return;
    } 
    while (i < paramList.size()) {
      this.zzacf.zzf(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    } 
  }
  
  public final void zzl(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    byte b = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      b = 0;
      paramInt = 0;
      while (b < paramList.size()) {
        paramInt += zzeg.zzax(((Long)paramList.get(b)).longValue());
        b++;
      } 
      this.zzacf.zzag(paramInt);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzas(((Long)paramList.get(paramInt)).longValue()); 
      return;
    } 
    while (b < paramList.size()) {
      this.zzacf.zzc(paramInt, ((Long)paramList.get(b)).longValue());
      b++;
    } 
  }
  
  public final int zzln() {
    return zzez.zze.zzahf;
  }
  
  public final void zzm(int paramInt1, int paramInt2) throws IOException {
    this.zzacf.zzf(paramInt1, paramInt2);
  }
  
  public final void zzm(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += zzeg.zzam(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.zzacf.zzag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzah(((Integer)paramList.get(paramInt)).intValue()); 
      return;
    } 
    while (i < paramList.size()) {
      this.zzacf.zze(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    } 
  }
  
  public final void zzn(int paramInt1, int paramInt2) throws IOException {
    this.zzacf.zzc(paramInt1, paramInt2);
  }
  
  public final void zzn(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.zzacf.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += zzeg.zzav(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      } 
      this.zzacf.zzag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.zzacf.zzar(((Long)paramList.get(paramInt)).longValue()); 
      return;
    } 
    while (i < paramList.size()) {
      this.zzacf.zzb(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */