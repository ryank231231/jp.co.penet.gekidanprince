package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzbj {
  @VisibleForTesting
  private final String zzma;
  
  private final String zzmb;
  
  private final String zzmc;
  
  private final long zzmd;
  
  private zzbj(zzbf paramzzbf, String paramString, long paramLong) {
    boolean bool;
    Preconditions.checkNotEmpty(paramString);
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    this.zzma = String.valueOf(paramString).concat(":start");
    this.zzmb = String.valueOf(paramString).concat(":count");
    this.zzmc = String.valueOf(paramString).concat(":value");
    this.zzmd = paramLong;
  }
  
  @WorkerThread
  private final void zzea() {
    this.zzly.zzq();
    long l = this.zzly.zzz().currentTimeMillis();
    SharedPreferences.Editor editor = zzbf.zza(this.zzly).edit();
    editor.remove(this.zzmb);
    editor.remove(this.zzmc);
    editor.putLong(this.zzma, l);
    editor.apply();
  }
  
  @WorkerThread
  private final long zzec() {
    return zzbf.zza(this.zzly).getLong(this.zzma, 0L);
  }
  
  @WorkerThread
  public final void zzc(String paramString, long paramLong) {
    boolean bool;
    this.zzly.zzq();
    if (zzec() == 0L)
      zzea(); 
    String str = paramString;
    if (paramString == null)
      str = ""; 
    long l = zzbf.zza(this.zzly).getLong(this.zzmb, 0L);
    if (l <= 0L) {
      SharedPreferences.Editor editor1 = zzbf.zza(this.zzly).edit();
      editor1.putString(this.zzmc, str);
      editor1.putLong(this.zzmb, 1L);
      editor1.apply();
      return;
    } 
    paramLong = this.zzly.zzab().zzgl().nextLong();
    l++;
    if ((paramLong & Long.MAX_VALUE) < Long.MAX_VALUE / l) {
      bool = true;
    } else {
      bool = false;
    } 
    SharedPreferences.Editor editor = zzbf.zza(this.zzly).edit();
    if (bool)
      editor.putString(this.zzmc, str); 
    editor.putLong(this.zzmb, l);
    editor.apply();
  }
  
  @WorkerThread
  public final Pair<String, Long> zzeb() {
    this.zzly.zzq();
    this.zzly.zzq();
    long l1 = zzec();
    if (l1 == 0L) {
      zzea();
      l1 = 0L;
    } else {
      l1 = Math.abs(l1 - this.zzly.zzz().currentTimeMillis());
    } 
    long l2 = this.zzmd;
    if (l1 < l2)
      return null; 
    if (l1 > l2 << 1L) {
      zzea();
      return null;
    } 
    String str = zzbf.zza(this.zzly).getString(this.zzmc, null);
    l1 = zzbf.zza(this.zzly).getLong(this.zzmb, 0L);
    zzea();
    return (str == null || l1 <= 0L) ? zzbf.zzky : new Pair(str, Long.valueOf(l1));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */