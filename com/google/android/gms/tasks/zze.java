package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zze<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
  private final Executor zzd;
  
  private final Continuation<TResult, Task<TContinuationResult>> zze;
  
  private final zzu<TContinuationResult> zzf;
  
  public zze(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation, @NonNull zzu<TContinuationResult> paramzzu) {
    this.zzd = paramExecutor;
    this.zze = paramContinuation;
    this.zzf = paramzzu;
  }
  
  public final void cancel() {
    throw new UnsupportedOperationException();
  }
  
  public final void onCanceled() {
    this.zzf.zza();
  }
  
  public final void onComplete(@NonNull Task<TResult> paramTask) {
    this.zzd.execute(new zzf(this, paramTask));
  }
  
  public final void onFailure(@NonNull Exception paramException) {
    this.zzf.setException(paramException);
  }
  
  public final void onSuccess(TContinuationResult paramTContinuationResult) {
    this.zzf.setResult(paramTContinuationResult);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */