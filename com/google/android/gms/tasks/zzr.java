package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

final class zzr<TResult> {
  private final Object mLock = new Object();
  
  @GuardedBy("mLock")
  private Queue<zzq<TResult>> zzt;
  
  @GuardedBy("mLock")
  private boolean zzu;
  
  public final void zza(@NonNull Task<TResult> paramTask) {
    synchronized (this.mLock) {
      if (this.zzt == null || this.zzu)
        return; 
      this.zzu = true;
      while (true) {
        synchronized (this.mLock) {
          zzq<TResult> zzq = this.zzt.poll();
          if (zzq == null) {
            this.zzu = false;
            return;
          } 
          zzq.onComplete(paramTask);
        } 
      } 
    } 
  }
  
  public final void zza(@NonNull zzq<TResult> paramzzq) {
    synchronized (this.mLock) {
      if (this.zzt == null) {
        ArrayDeque<zzq<TResult>> arrayDeque = new ArrayDeque();
        this();
        this.zzt = arrayDeque;
      } 
      this.zzt.add(paramzzq);
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */