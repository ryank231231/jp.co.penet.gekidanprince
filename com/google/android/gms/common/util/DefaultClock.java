package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DefaultClock implements Clock {
  private static final DefaultClock zzgm = new DefaultClock();
  
  @KeepForSdk
  public static Clock getInstance() {
    return zzgm;
  }
  
  public long currentThreadTimeMillis() {
    return SystemClock.currentThreadTimeMillis();
  }
  
  public long currentTimeMillis() {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime() {
    return SystemClock.elapsedRealtime();
  }
  
  public long nanoTime() {
    return System.nanoTime();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\DefaultClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */