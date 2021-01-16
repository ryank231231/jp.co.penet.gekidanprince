package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

public final class zzdc {
  private final Uri zzaaa;
  
  private final String zzaab;
  
  private final String zzaac;
  
  private final boolean zzaad;
  
  private final boolean zzaae;
  
  private final boolean zzaaf;
  
  private final boolean zzaag;
  
  @Nullable
  private final zzdf<Context, Boolean> zzaah;
  
  private final String zzzz = null;
  
  public zzdc(Uri paramUri) {
    this(null, paramUri, "", "", false, false, false, false, null);
  }
  
  private zzdc(String paramString1, Uri paramUri, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @Nullable zzdf<Context, Boolean> paramzzdf) {
    this.zzaaa = paramUri;
    this.zzaab = paramString2;
    this.zzaac = paramString3;
    this.zzaad = false;
    this.zzaae = false;
    this.zzaaf = false;
    this.zzaag = false;
    this.zzaah = null;
  }
  
  public final zzcw<Double> zza(String paramString, double paramDouble) {
    return zzcw.zzb(this, paramString, paramDouble);
  }
  
  public final zzcw<Integer> zza(String paramString, int paramInt) {
    return zzcw.zzb(this, paramString, paramInt);
  }
  
  public final zzcw<Boolean> zzb(String paramString, boolean paramBoolean) {
    return zzcw.zzb(this, paramString, paramBoolean);
  }
  
  public final zzcw<Long> zze(String paramString, long paramLong) {
    return zzcw.zzb(this, paramString, paramLong);
  }
  
  public final zzcw<String> zzt(String paramString1, String paramString2) {
    return zzcw.zzb(this, paramString1, paramString2);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */