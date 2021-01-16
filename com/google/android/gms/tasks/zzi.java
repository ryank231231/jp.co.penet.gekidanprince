package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzi<TResult> implements zzq<TResult> {
  private final Object mLock = new Object();
  
  private final Executor zzd;
  
  @GuardedBy("mLock")
  private OnCompleteListener<TResult> zzl;
  
  public zzi(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    this.zzd = paramExecutor;
    this.zzl = paramOnCompleteListener;
  }
  
  public final void cancel() {
    synchronized (this.mLock) {
      this.zzl = null;
      return;
    } 
  }
  
  public final void onComplete(@NonNull Task<TResult> paramTask) {
    synchronized (this.mLock) {
      if (this.zzl == null)
        return; 
      this.zzd.execute(new zzj(this, paramTask));
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */