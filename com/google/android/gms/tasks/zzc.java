package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult> implements zzq<TResult> {
  private final Executor zzd;
  
  private final Continuation<TResult, TContinuationResult> zze;
  
  private final zzu<TContinuationResult> zzf;
  
  public zzc(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation, @NonNull zzu<TContinuationResult> paramzzu) {
    this.zzd = paramExecutor;
    this.zze = paramContinuation;
    this.zzf = paramzzu;
  }
  
  public final void cancel() {
    throw new UnsupportedOperationException();
  }
  
  public final void onComplete(@NonNull Task<TResult> paramTask) {
    this.zzd.execute(new zzd(this, paramTask));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */