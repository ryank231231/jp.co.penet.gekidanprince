package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class PendingResultUtil {
  private static final zaa zaot = new zai();
  
  @KeepForSdk
  public static <R extends com.google.android.gms.common.api.Result, T extends Response<R>> Task<T> toResponseTask(PendingResult<R> paramPendingResult, T paramT) {
    return toTask(paramPendingResult, new zak((Response)paramT));
  }
  
  @KeepForSdk
  public static <R extends com.google.android.gms.common.api.Result, T> Task<T> toTask(PendingResult<R> paramPendingResult, ResultConverter<R, T> paramResultConverter) {
    zaa zaa1 = zaot;
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    paramPendingResult.addStatusListener(new zaj(paramPendingResult, taskCompletionSource, paramResultConverter, zaa1));
    return taskCompletionSource.getTask();
  }
  
  @KeepForSdk
  public static <R extends com.google.android.gms.common.api.Result> Task<Void> toVoidTask(PendingResult<R> paramPendingResult) {
    return toTask(paramPendingResult, new zal());
  }
  
  @KeepForSdk
  public static interface ResultConverter<R extends com.google.android.gms.common.api.Result, T> {
    @KeepForSdk
    T convert(R param1R);
  }
  
  public static interface zaa {
    ApiException zaf(Status param1Status);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\PendingResultUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */