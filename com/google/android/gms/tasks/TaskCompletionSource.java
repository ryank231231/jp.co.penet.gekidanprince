package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public class TaskCompletionSource<TResult> {
  private final zzu<TResult> zza = new zzu<TResult>();
  
  public TaskCompletionSource() {}
  
  public TaskCompletionSource(@NonNull CancellationToken paramCancellationToken) {
    paramCancellationToken.onCanceledRequested(new zzs(this));
  }
  
  @NonNull
  public Task<TResult> getTask() {
    return this.zza;
  }
  
  public void setException(@NonNull Exception paramException) {
    this.zza.setException(paramException);
  }
  
  public void setResult(TResult paramTResult) {
    this.zza.setResult(paramTResult);
  }
  
  public boolean trySetException(@NonNull Exception paramException) {
    return this.zza.trySetException(paramException);
  }
  
  public boolean trySetResult(TResult paramTResult) {
    return this.zza.trySetResult(paramTResult);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\TaskCompletionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */