package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class ActivityLifecycleObserver {
  @KeepForSdk
  public static final ActivityLifecycleObserver of(Activity paramActivity) {
    return new zaa(paramActivity);
  }
  
  @KeepForSdk
  public abstract ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\ActivityLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */