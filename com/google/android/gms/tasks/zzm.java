package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzm<TResult> implements zzq<TResult> {
  private final Object mLock = new Object();
  
  private final Executor zzd;
  
  @GuardedBy("mLock")
  private OnSuccessListener<? super TResult> zzp;
  
  public zzm(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener) {
    this.zzd = paramExecutor;
    this.zzp = paramOnSuccessListener;
  }
  
  public final void cancel() {
    synchronized (this.mLock) {
      this.zzp = null;
      return;
    } 
  }
  
  public final void onComplete(@NonNull Task<TResult> paramTask) {
    if (paramTask.isSuccessful())
      synchronized (this.mLock) {
        if (this.zzp == null)
          return; 
        this.zzd.execute(new zzn(this, paramTask));
      }  
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */