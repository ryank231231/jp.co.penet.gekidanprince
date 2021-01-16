package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.util.Clock;
import javax.net.ssl.SSLSocketFactory;

public final class zzdz extends zzcu {
  private final SSLSocketFactory zzkj;
  
  zzdz(zzby paramzzby) {
    super(paramzzby);
    if (Build.VERSION.SDK_INT < 19) {
      zzge zzge = new zzge();
    } else {
      paramzzby = null;
    } 
    this.zzkj = (SSLSocketFactory)paramzzby;
  }
  
  protected final boolean zzak() {
    return false;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzdz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */