package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.clearcut.zzaa;
import com.google.android.gms.internal.clearcut.zze;
import com.google.android.gms.internal.clearcut.zzge;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzj;
import com.google.android.gms.internal.clearcut.zzp;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.ArrayList;
import java.util.TimeZone;
import javax.annotation.Nullable;

@KeepForSdk
public final class ClearcutLogger {
  @Deprecated
  public static final Api<Api.ApiOptions.NoOptions> API;
  
  private static final Api.AbstractClientBuilder<zzj, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  
  private static final Api.ClientKey<zzj> CLIENT_KEY = new Api.ClientKey();
  
  private static final ExperimentTokens[] zze;
  
  private static final String[] zzf;
  
  private static final byte[][] zzg;
  
  private final String packageName;
  
  private final Context zzh;
  
  private final int zzi;
  
  private String zzj;
  
  private int zzk = -1;
  
  private String zzl;
  
  private String zzm;
  
  private final boolean zzn;
  
  private zzge.zzv.zzb zzo = zzge.zzv.zzb.zzbhk;
  
  private final zzb zzp;
  
  private final Clock zzq;
  
  private zzc zzr;
  
  private final zza zzs;
  
  static {
    CLIENT_BUILDER = new zza();
    API = new Api("ClearcutLogger.API", CLIENT_BUILDER, CLIENT_KEY);
    zze = new ExperimentTokens[0];
    zzf = new String[0];
    zzg = new byte[0][];
  }
  
  @VisibleForTesting
  private ClearcutLogger(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, zzb paramzzb, Clock paramClock, zzc paramzzc, zza paramzza) {
    this.zzh = paramContext;
    this.packageName = paramContext.getPackageName();
    this.zzi = zza(paramContext);
    this.zzk = -1;
    this.zzj = paramString1;
    this.zzl = paramString2;
    this.zzm = null;
    this.zzn = paramBoolean;
    this.zzp = paramzzb;
    this.zzq = paramClock;
    this.zzr = new zzc();
    this.zzo = zzge.zzv.zzb.zzbhk;
    this.zzs = paramzza;
    if (paramBoolean) {
      if (paramString2 == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      Preconditions.checkArgument(paramBoolean, "can't be anonymous with an upload account");
    } 
  }
  
  @KeepForSdk
  public ClearcutLogger(Context paramContext, String paramString1, @Nullable String paramString2) {
    this(paramContext, -1, paramString1, paramString2, null, false, zze.zzb(paramContext), DefaultClock.getInstance(), null, (zza)new zzp(paramContext));
  }
  
  @KeepForSdk
  public static ClearcutLogger anonymousLogger(Context paramContext, String paramString) {
    return new ClearcutLogger(paramContext, -1, paramString, null, null, true, zze.zzb(paramContext), DefaultClock.getInstance(), null, (zza)new zzp(paramContext));
  }
  
  private static int zza(Context paramContext) {
    boolean bool2;
    boolean bool1 = false;
    try {
      bool2 = (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.wtf("ClearcutLogger", "This can't happen.", (Throwable)nameNotFoundException);
      bool2 = bool1;
    } 
    return bool2;
  }
  
  private static int[] zza(ArrayList<Integer> paramArrayList) {
    if (paramArrayList == null)
      return null; 
    int[] arrayOfInt = new int[paramArrayList.size()];
    paramArrayList = paramArrayList;
    int i = paramArrayList.size();
    byte b1 = 0;
    for (byte b2 = 0; b1 < i; b2++) {
      Object object = paramArrayList.get(b1);
      b1++;
      arrayOfInt[b2] = ((Integer)object).intValue();
    } 
    return arrayOfInt;
  }
  
  @KeepForSdk
  public final LogEventBuilder newEvent(@Nullable byte[] paramArrayOfbyte) {
    return new LogEventBuilder(paramArrayOfbyte, null);
  }
  
  public class LogEventBuilder {
    private final zzha zzaa;
    
    private boolean zzab;
    
    private String zzj = ClearcutLogger.zzb(this.zzac);
    
    private int zzk = ClearcutLogger.zza(this.zzac);
    
    private String zzl = ClearcutLogger.zzc(this.zzac);
    
    private String zzm;
    
    private zzge.zzv.zzb zzo;
    
    private final ClearcutLogger.zzb zzt;
    
    private ArrayList<Integer> zzu;
    
    private ArrayList<String> zzv;
    
    private ArrayList<Integer> zzw;
    
    private ArrayList<ExperimentTokens> zzx;
    
    private ArrayList<byte[]> zzy;
    
    private boolean zzz;
    
    private LogEventBuilder(byte[] param1ArrayOfbyte) {
      this(param1ArrayOfbyte, null);
    }
    
    private LogEventBuilder(byte[] param1ArrayOfbyte, ClearcutLogger.zzb param1zzb) {
      ClearcutLogger clearcutLogger = this.zzac;
      this.zzm = null;
      this.zzo = ClearcutLogger.zzd(clearcutLogger);
      this.zzu = null;
      this.zzv = null;
      this.zzw = null;
      this.zzx = null;
      this.zzy = null;
      this.zzz = true;
      this.zzaa = new zzha();
      this.zzab = false;
      this.zzl = ClearcutLogger.zzc(ClearcutLogger.this);
      this.zzm = null;
      this.zzaa.zzbkc = zzaa.zze(ClearcutLogger.zze(ClearcutLogger.this));
      this.zzaa.zzbjf = ClearcutLogger.zzf(ClearcutLogger.this).currentTimeMillis();
      this.zzaa.zzbjg = ClearcutLogger.zzf(ClearcutLogger.this).elapsedRealtime();
      zzha zzha1 = this.zzaa;
      ClearcutLogger.zzg(ClearcutLogger.this);
      long l = this.zzaa.zzbjf;
      zzha1.zzbju = (TimeZone.getDefault().getOffset(l) / 1000);
      if (param1ArrayOfbyte != null)
        this.zzaa.zzbjp = param1ArrayOfbyte; 
      this.zzt = null;
    }
    
    @KeepForSdk
    public void log() {
      if (!this.zzab) {
        this.zzab = true;
        zze zze = new zze(new zzr(ClearcutLogger.zzi(this.zzac), ClearcutLogger.zzj(this.zzac), this.zzk, this.zzj, this.zzl, this.zzm, ClearcutLogger.zzh(this.zzac), this.zzo), this.zzaa, null, null, ClearcutLogger.zzb((ArrayList)null), null, ClearcutLogger.zzb((ArrayList)null), null, null, this.zzz);
        if (ClearcutLogger.zzk(this.zzac).zza(zze)) {
          ClearcutLogger.zzl(this.zzac).zzb(zze);
          return;
        } 
        PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, null);
        return;
      } 
      throw new IllegalStateException("do not reuse LogEventBuilder");
    }
    
    @KeepForSdk
    public LogEventBuilder setEventCode(int param1Int) {
      this.zzaa.zzbji = param1Int;
      return this;
    }
  }
  
  public static interface zza {
    boolean zza(zze param1zze);
  }
  
  public static interface zzb {
    byte[] zza();
  }
  
  public static final class zzc {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\clearcut\ClearcutLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */