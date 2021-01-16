package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zabu extends zal {
  private TaskCompletionSource<Void> zajo = new TaskCompletionSource();
  
  private zabu(LifecycleFragment paramLifecycleFragment) {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
  }
  
  public static zabu zac(Activity paramActivity) {
    LifecycleFragment lifecycleFragment = getFragment(paramActivity);
    zabu zabu1 = lifecycleFragment.<zabu>getCallbackOrNull("GmsAvailabilityHelper", zabu.class);
    if (zabu1 != null) {
      if (zabu1.zajo.getTask().isComplete())
        zabu1.zajo = new TaskCompletionSource(); 
      return zabu1;
    } 
    return new zabu(lifecycleFragment);
  }
  
  public final Task<Void> getTask() {
    return this.zajo.getTask();
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.zajo.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt) {
    this.zajo.setException((Exception)ApiExceptionUtil.fromStatus(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution())));
  }
  
  protected final void zao() {
    int i = this.zacc.isGooglePlayServicesAvailable((Context)this.mLifecycleFragment.getLifecycleActivity());
    if (i == 0) {
      this.zajo.setResult(null);
      return;
    } 
    if (!this.zajo.getTask().isComplete())
      zab(new ConnectionResult(i, null), 0); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zabu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */