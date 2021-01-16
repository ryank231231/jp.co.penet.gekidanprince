package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class zaj implements PendingResult.StatusListener {
  zaj(PendingResult paramPendingResult, TaskCompletionSource paramTaskCompletionSource, PendingResultUtil.ResultConverter paramResultConverter, PendingResultUtil.zaa paramzaa) {}
  
  public final void onComplete(Status paramStatus) {
    Result result;
    if (paramStatus.isSuccess()) {
      result = this.zaou.await(0L, TimeUnit.MILLISECONDS);
      this.zaov.setResult(this.zaow.convert(result));
      return;
    } 
    this.zaov.setException((Exception)this.zaox.zaf((Status)result));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */