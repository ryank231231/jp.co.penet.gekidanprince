package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

final class zzg {
  private final String zzcf;
  
  private String zzcg;
  
  private String zzch;
  
  private String zzci;
  
  private String zzcj;
  
  private long zzck;
  
  private long zzcl;
  
  private long zzcm;
  
  private String zzcn;
  
  private long zzco;
  
  private String zzcp;
  
  private long zzcq;
  
  private boolean zzcr;
  
  private long zzcs;
  
  private boolean zzct;
  
  private boolean zzcu;
  
  private String zzcv;
  
  private Boolean zzcw;
  
  private long zzcx;
  
  private long zzcy;
  
  private long zzcz;
  
  private long zzda;
  
  private long zzdb;
  
  private long zzdc;
  
  private String zzdd;
  
  private boolean zzde;
  
  private long zzdf;
  
  private long zzdg;
  
  private final zzby zzl;
  
  private long zzt;
  
  private long zzu;
  
  @WorkerThread
  zzg(zzby paramzzby, String paramString) {
    Preconditions.checkNotNull(paramzzby);
    Preconditions.checkNotEmpty(paramString);
    this.zzl = paramzzby;
    this.zzcf = paramString;
    this.zzl.zzac().zzq();
  }
  
  @WorkerThread
  public final String getAppInstanceId() {
    this.zzl.zzac().zzq();
    return this.zzcg;
  }
  
  @WorkerThread
  public final String getFirebaseInstanceId() {
    this.zzl.zzac().zzq();
    return this.zzcj;
  }
  
  @WorkerThread
  public final String getGmpAppId() {
    this.zzl.zzac().zzq();
    return this.zzch;
  }
  
  @WorkerThread
  public final boolean isMeasurementEnabled() {
    this.zzl.zzac().zzq();
    return this.zzcr;
  }
  
  @WorkerThread
  public final void setMeasurementEnabled(boolean paramBoolean) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzcr != paramBoolean) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzcr = paramBoolean;
  }
  
  @WorkerThread
  public final void zza(Boolean paramBoolean) {
    this.zzl.zzac().zzq();
    this.zzde = zzgd.zza(this.zzcw, paramBoolean) ^ true;
    this.zzcw = paramBoolean;
  }
  
  @WorkerThread
  public final void zza(String paramString) {
    this.zzl.zzac().zzq();
    this.zzde |= zzgd.zzs(this.zzcg, paramString) ^ true;
    this.zzcg = paramString;
  }
  
  @WorkerThread
  public final void zzam() {
    this.zzl.zzac().zzq();
    this.zzde = false;
  }
  
  @WorkerThread
  public final String zzan() {
    this.zzl.zzac().zzq();
    return this.zzcf;
  }
  
  @WorkerThread
  public final String zzao() {
    this.zzl.zzac().zzq();
    return this.zzcv;
  }
  
  @WorkerThread
  public final String zzap() {
    this.zzl.zzac().zzq();
    return this.zzci;
  }
  
  @WorkerThread
  public final long zzaq() {
    this.zzl.zzac().zzq();
    return this.zzcl;
  }
  
  @WorkerThread
  public final long zzar() {
    this.zzl.zzac().zzq();
    return this.zzcm;
  }
  
  @WorkerThread
  public final String zzas() {
    this.zzl.zzac().zzq();
    return this.zzcn;
  }
  
  @WorkerThread
  public final long zzat() {
    this.zzl.zzac().zzq();
    return this.zzco;
  }
  
  @WorkerThread
  public final String zzau() {
    this.zzl.zzac().zzq();
    return this.zzcp;
  }
  
  @WorkerThread
  public final long zzav() {
    this.zzl.zzac().zzq();
    return this.zzt;
  }
  
  @WorkerThread
  public final long zzaw() {
    this.zzl.zzac().zzq();
    return this.zzcq;
  }
  
  @WorkerThread
  public final long zzax() {
    this.zzl.zzac().zzq();
    return this.zzu;
  }
  
  @WorkerThread
  public final long zzay() {
    this.zzl.zzac().zzq();
    return this.zzck;
  }
  
  @WorkerThread
  public final long zzaz() {
    this.zzl.zzac().zzq();
    return this.zzdf;
  }
  
  @WorkerThread
  public final void zzb(String paramString) {
    this.zzl.zzac().zzq();
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = null; 
    this.zzde |= zzgd.zzs(this.zzch, str) ^ true;
    this.zzch = str;
  }
  
  @WorkerThread
  public final void zzb(boolean paramBoolean) {
    boolean bool;
    this.zzl.zzac().zzq();
    if (this.zzct != paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.zzde = bool;
    this.zzct = paramBoolean;
  }
  
  @WorkerThread
  public final long zzba() {
    this.zzl.zzac().zzq();
    return this.zzdg;
  }
  
  @WorkerThread
  public final void zzbb() {
    this.zzl.zzac().zzq();
    long l1 = this.zzck + 1L;
    long l2 = l1;
    if (l1 > 2147483647L) {
      this.zzl.zzad().zzdd().zza("Bundle index overflow. appId", zzau.zzao(this.zzcf));
      l2 = 0L;
    } 
    this.zzde = true;
    this.zzck = l2;
  }
  
  @WorkerThread
  public final long zzbc() {
    this.zzl.zzac().zzq();
    return this.zzcx;
  }
  
  @WorkerThread
  public final long zzbd() {
    this.zzl.zzac().zzq();
    return this.zzcy;
  }
  
  @WorkerThread
  public final long zzbe() {
    this.zzl.zzac().zzq();
    return this.zzcz;
  }
  
  @WorkerThread
  public final long zzbf() {
    this.zzl.zzac().zzq();
    return this.zzda;
  }
  
  @WorkerThread
  public final long zzbg() {
    this.zzl.zzac().zzq();
    return this.zzdc;
  }
  
  @WorkerThread
  public final long zzbh() {
    this.zzl.zzac().zzq();
    return this.zzdb;
  }
  
  @WorkerThread
  public final String zzbi() {
    this.zzl.zzac().zzq();
    return this.zzdd;
  }
  
  @WorkerThread
  public final String zzbj() {
    this.zzl.zzac().zzq();
    String str = this.zzdd;
    zzh((String)null);
    return str;
  }
  
  @WorkerThread
  public final long zzbk() {
    this.zzl.zzac().zzq();
    return this.zzcs;
  }
  
  @WorkerThread
  public final boolean zzbl() {
    this.zzl.zzac().zzq();
    return this.zzct;
  }
  
  @WorkerThread
  public final boolean zzbm() {
    this.zzl.zzac().zzq();
    return this.zzcu;
  }
  
  @WorkerThread
  public final Boolean zzbn() {
    this.zzl.zzac().zzq();
    return this.zzcw;
  }
  
  @WorkerThread
  public final void zzc(String paramString) {
    this.zzl.zzac().zzq();
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = null; 
    this.zzde |= zzgd.zzs(this.zzcv, str) ^ true;
    this.zzcv = str;
  }
  
  @WorkerThread
  public final void zzc(boolean paramBoolean) {
    boolean bool;
    this.zzl.zzac().zzq();
    if (this.zzcu != paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.zzde = bool;
    this.zzcu = paramBoolean;
  }
  
  @WorkerThread
  public final void zzd(String paramString) {
    this.zzl.zzac().zzq();
    this.zzde |= zzgd.zzs(this.zzci, paramString) ^ true;
    this.zzci = paramString;
  }
  
  @WorkerThread
  public final void zze(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzcl != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzcl = paramLong;
  }
  
  @WorkerThread
  public final void zze(String paramString) {
    this.zzl.zzac().zzq();
    this.zzde |= zzgd.zzs(this.zzcj, paramString) ^ true;
    this.zzcj = paramString;
  }
  
  @WorkerThread
  public final void zzf(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzcm != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzcm = paramLong;
  }
  
  @WorkerThread
  public final void zzf(String paramString) {
    this.zzl.zzac().zzq();
    this.zzde |= zzgd.zzs(this.zzcn, paramString) ^ true;
    this.zzcn = paramString;
  }
  
  @WorkerThread
  public final void zzg(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzco != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzco = paramLong;
  }
  
  @WorkerThread
  public final void zzg(String paramString) {
    this.zzl.zzac().zzq();
    this.zzde |= zzgd.zzs(this.zzcp, paramString) ^ true;
    this.zzcp = paramString;
  }
  
  @WorkerThread
  public final void zzh(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzt != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzt = paramLong;
  }
  
  @WorkerThread
  public final void zzh(String paramString) {
    this.zzl.zzac().zzq();
    this.zzde |= zzgd.zzs(this.zzdd, paramString) ^ true;
    this.zzdd = paramString;
  }
  
  @WorkerThread
  public final void zzi(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzcq != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzcq = paramLong;
  }
  
  @WorkerThread
  public final void zzj(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzu != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzu = paramLong;
  }
  
  @WorkerThread
  public final void zzk(long paramLong) {
    boolean bool1 = true;
    if (paramLong >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    this.zzl.zzac().zzq();
    boolean bool2 = this.zzde;
    if (this.zzck == paramLong)
      bool1 = false; 
    this.zzde = bool1 | bool2;
    this.zzck = paramLong;
  }
  
  @WorkerThread
  public final void zzl(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzdf != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzdf = paramLong;
  }
  
  @WorkerThread
  public final void zzm(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzdg != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzdg = paramLong;
  }
  
  @WorkerThread
  public final void zzn(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzcx != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzcx = paramLong;
  }
  
  @WorkerThread
  public final void zzo(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzcy != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzcy = paramLong;
  }
  
  @WorkerThread
  public final void zzp(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzcz != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzcz = paramLong;
  }
  
  @WorkerThread
  public final void zzq(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzda != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzda = paramLong;
  }
  
  @WorkerThread
  public final void zzr(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzdc != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzdc = paramLong;
  }
  
  @WorkerThread
  public final void zzs(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzdb != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzdb = paramLong;
  }
  
  @WorkerThread
  public final void zzt(long paramLong) {
    boolean bool2;
    this.zzl.zzac().zzq();
    boolean bool1 = this.zzde;
    if (this.zzcs != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.zzde = bool1 | bool2;
    this.zzcs = paramLong;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */