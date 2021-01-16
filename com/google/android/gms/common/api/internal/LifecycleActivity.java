package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class LifecycleActivity {
  private final Object zzbd;
  
  public LifecycleActivity(Activity paramActivity) {
    Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    this.zzbd = paramActivity;
  }
  
  @KeepForSdk
  public LifecycleActivity(ContextWrapper paramContextWrapper) {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public Activity asActivity() {
    return (Activity)this.zzbd;
  }
  
  @KeepForSdk
  public FragmentActivity asFragmentActivity() {
    return (FragmentActivity)this.zzbd;
  }
  
  @KeepForSdk
  public Object asObject() {
    return this.zzbd;
  }
  
  @KeepForSdk
  public boolean isChimera() {
    return false;
  }
  
  @KeepForSdk
  public boolean isSupport() {
    return this.zzbd instanceof FragmentActivity;
  }
  
  public final boolean zzh() {
    return this.zzbd instanceof Activity;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\LifecycleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */