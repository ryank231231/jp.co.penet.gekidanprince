package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface LifecycleDelegate {
  @KeepForSdk
  void onCreate(Bundle paramBundle);
  
  @KeepForSdk
  View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle);
  
  @KeepForSdk
  void onDestroy();
  
  @KeepForSdk
  void onDestroyView();
  
  @KeepForSdk
  void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2);
  
  @KeepForSdk
  void onLowMemory();
  
  @KeepForSdk
  void onPause();
  
  @KeepForSdk
  void onResume();
  
  @KeepForSdk
  void onSaveInstanceState(Bundle paramBundle);
  
  @KeepForSdk
  void onStart();
  
  @KeepForSdk
  void onStop();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\dynamic\LifecycleDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */