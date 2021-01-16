package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class zza extends Fragment implements LifecycleFragment {
  private static WeakHashMap<Activity, WeakReference<zza>> zzbe = new WeakHashMap<Activity, WeakReference<zza>>();
  
  private Map<String, LifecycleCallback> zzbf = (Map<String, LifecycleCallback>)new ArrayMap();
  
  private int zzbg = 0;
  
  private Bundle zzbh;
  
  public static zza zza(Activity paramActivity) {
    WeakReference<zza> weakReference = zzbe.get(paramActivity);
    if (weakReference != null) {
      zza zza1 = weakReference.get();
      if (zza1 != null)
        return zza1; 
    } 
    try {
      zza zza2 = (zza)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (zza2 != null) {
        zza zza3 = zza2;
        if (zza2.isRemoving()) {
          zza3 = new zza();
          paramActivity.getFragmentManager().beginTransaction().add(zza3, "LifecycleFragmentImpl").commitAllowingStateLoss();
          zzbe.put(paramActivity, new WeakReference<zza>(zza3));
          return zza3;
        } 
        zzbe.put(paramActivity, new WeakReference<zza>(zza3));
        return zza3;
      } 
      zza zza1 = new zza();
      paramActivity.getFragmentManager().beginTransaction().add(zza1, "LifecycleFragmentImpl").commitAllowingStateLoss();
      zzbe.put(paramActivity, new WeakReference<zza>(zza1));
      return zza1;
    } catch (ClassCastException classCastException) {
      throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", classCastException);
    } 
  }
  
  public final void addCallback(String paramString, @NonNull LifecycleCallback paramLifecycleCallback) {
    if (!this.zzbf.containsKey(paramString)) {
      this.zzbf.put(paramString, paramLifecycleCallback);
      if (this.zzbg > 0)
        (new zze(Looper.getMainLooper())).post(new zzb(this, paramLifecycleCallback, paramString)); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 59);
    stringBuilder.append("LifecycleCallback with tag ");
    stringBuilder.append(paramString);
    stringBuilder.append(" already added to this fragment.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator<LifecycleCallback> iterator = this.zzbf.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString); 
  }
  
  public final <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass) {
    return paramClass.cast(this.zzbf.get(paramString));
  }
  
  public final Activity getLifecycleActivity() {
    return getActivity();
  }
  
  public final boolean isCreated() {
    return (this.zzbg > 0);
  }
  
  public final boolean isStarted() {
    return (this.zzbg >= 2);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator<LifecycleCallback> iterator = this.zzbf.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent); 
  }
  
  public final void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.zzbg = 1;
    this.zzbh = paramBundle;
    for (Map.Entry<String, LifecycleCallback> entry : this.zzbf.entrySet()) {
      LifecycleCallback lifecycleCallback = (LifecycleCallback)entry.getValue();
      if (paramBundle != null) {
        Bundle bundle = paramBundle.getBundle((String)entry.getKey());
      } else {
        entry = null;
      } 
      lifecycleCallback.onCreate((Bundle)entry);
    } 
  }
  
  public final void onDestroy() {
    super.onDestroy();
    this.zzbg = 5;
    Iterator<LifecycleCallback> iterator = this.zzbf.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onDestroy(); 
  }
  
  public final void onResume() {
    super.onResume();
    this.zzbg = 3;
    Iterator<LifecycleCallback> iterator = this.zzbf.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onResume(); 
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null)
      return; 
    for (Map.Entry<String, LifecycleCallback> entry : this.zzbf.entrySet()) {
      Bundle bundle = new Bundle();
      ((LifecycleCallback)entry.getValue()).onSaveInstanceState(bundle);
      paramBundle.putBundle((String)entry.getKey(), bundle);
    } 
  }
  
  public final void onStart() {
    super.onStart();
    this.zzbg = 2;
    Iterator<LifecycleCallback> iterator = this.zzbf.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onStart(); 
  }
  
  public final void onStop() {
    super.onStop();
    this.zzbg = 4;
    Iterator<LifecycleCallback> iterator = this.zzbf.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onStop(); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */