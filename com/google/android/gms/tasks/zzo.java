package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzo<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
  private final Executor zzd;
  
  private final zzu<TContinuationResult> zzf;
  
  private final SuccessContinuation<TResult, TContinuationResult> zzr;
  
  public zzo(@NonNull Executor paramExecutor, @NonNull SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation, @NonNull zzu<TContinuationResult> paramzzu) {
    this.zzd = paramExecutor;
    this.zzr = paramSuccessContinuation;
    this.zzf = paramzzu;
  }
  
  public final void cancel() {
    throw new UnsupportedOperationException();
  }
  
  public final void onCanceled() {
    this.zzf.zza();
  }
  
  public final void onComplete(@NonNull Task<TResult> paramTask) {
    this.zzd.execute(new zzp(this, paramTask));
  }
  
  public final void onFailure(@NonNull Exception paramException) {
    this.zzf.setException(paramException);
  }
  
  public final void onSuccess(TContinuationResult paramTContinuationResult) {
    this.zzf.setResult(paramTContinuationResult);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */