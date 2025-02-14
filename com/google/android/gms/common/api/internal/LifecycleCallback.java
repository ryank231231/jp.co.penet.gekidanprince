package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.MainThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback {
  @KeepForSdk
  protected final LifecycleFragment mLifecycleFragment;
  
  @KeepForSdk
  protected LifecycleCallback(LifecycleFragment paramLifecycleFragment) {
    this.mLifecycleFragment = paramLifecycleFragment;
  }
  
  @Keep
  private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity paramLifecycleActivity) {
    throw new IllegalStateException("Method not available in SDK.");
  }
  
  @KeepForSdk
  public static LifecycleFragment getFragment(Activity paramActivity) {
    return getFragment(new LifecycleActivity(paramActivity));
  }
  
  @KeepForSdk
  public static LifecycleFragment getFragment(ContextWrapper paramContextWrapper) {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  protected static LifecycleFragment getFragment(LifecycleActivity paramLifecycleActivity) {
    if (paramLifecycleActivity.isSupport())
      return zzc.zza(paramLifecycleActivity.asFragmentActivity()); 
    if (paramLifecycleActivity.zzh())
      return zza.zza(paramLifecycleActivity.asActivity()); 
    throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
  }
  
  @MainThread
  @KeepForSdk
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  @KeepForSdk
  public Activity getActivity() {
    return this.mLifecycleFragment.getLifecycleActivity();
  }
  
  @MainThread
  @KeepForSdk
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @MainThread
  @KeepForSdk
  public void onCreate(Bundle paramBundle) {}
  
  @MainThread
  @KeepForSdk
  public void onDestroy() {}
  
  @MainThread
  @KeepForSdk
  public void onResume() {}
  
  @MainThread
  @KeepForSdk
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  @MainThread
  @KeepForSdk
  public void onStart() {}
  
  @MainThread
  @KeepForSdk
  public void onStop() {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\LifecycleCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */