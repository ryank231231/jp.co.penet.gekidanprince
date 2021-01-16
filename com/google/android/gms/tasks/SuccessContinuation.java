package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface SuccessContinuation<TResult, TContinuationResult> {
  @NonNull
  Task<TContinuationResult> then(@Nullable TResult paramTResult) throws Exception;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\SuccessContinuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */