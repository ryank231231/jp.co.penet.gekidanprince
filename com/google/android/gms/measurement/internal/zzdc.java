package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzy;

@VisibleForTesting
public final class zzdc {
  final Context zzno;
  
  String zznp;
  
  String zznq;
  
  Boolean zzoj;
  
  zzy zzpe;
  
  long zzu;
  
  boolean zzv = true;
  
  String zzx;
  
  @VisibleForTesting
  public zzdc(Context paramContext, zzy paramzzy) {
    Preconditions.checkNotNull(paramContext);
    paramContext = paramContext.getApplicationContext();
    Preconditions.checkNotNull(paramContext);
    this.zzno = paramContext;
    if (paramzzy != null) {
      this.zzpe = paramzzy;
      this.zzx = paramzzy.zzx;
      this.zznp = paramzzy.origin;
      this.zznq = paramzzy.zzw;
      this.zzv = paramzzy.zzv;
      this.zzu = paramzzy.zzu;
      if (paramzzy.zzy != null)
        this.zzoj = Boolean.valueOf(paramzzy.zzy.getBoolean("dataCollectionDefaultEnabled", true)); 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */