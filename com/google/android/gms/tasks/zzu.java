package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzu<TResult> extends Task<TResult> {
  private final Object mLock = new Object();
  
  @GuardedBy("mLock")
  private TResult zzaa;
  
  @GuardedBy("mLock")
  private Exception zzab;
  
  private final zzr<TResult> zzx = new zzr<TResult>();
  
  @GuardedBy("mLock")
  private boolean zzy;
  
  private volatile boolean zzz;
  
  @GuardedBy("mLock")
  private final void zzb() {
    Preconditions.checkState(this.zzy, "Task is not yet complete");
  }
  
  @GuardedBy("mLock")
  private final void zzc() {
    Preconditions.checkState(this.zzy ^ true, "Task is already complete");
  }
  
  @GuardedBy("mLock")
  private final void zzd() {
    if (!this.zzz)
      return; 
    throw new CancellationException("Task is already canceled.");
  }
  
  private final void zze() {
    synchronized (this.mLock) {
      if (!this.zzy)
        return; 
      this.zzx.zza(this);
      return;
    } 
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull Activity paramActivity, @NonNull OnCanceledListener paramOnCanceledListener) {
    zzg<TResult> zzg = new zzg(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    this.zzx.zza(zzg);
    zza.zza(paramActivity).zzb(zzg);
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull OnCanceledListener paramOnCanceledListener) {
    return super.addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull Executor paramExecutor, @NonNull OnCanceledListener paramOnCanceledListener) {
    this.zzx.zza(new zzg<TResult>(paramExecutor, paramOnCanceledListener));
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull Activity paramActivity, @NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    zzi<TResult> zzi = new zzi<TResult>(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzx.zza(zzi);
    zza.zza(paramActivity).zzb(zzi);
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    return super.addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    this.zzx.zza(new zzi<TResult>(paramExecutor, paramOnCompleteListener));
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull Activity paramActivity, @NonNull OnFailureListener paramOnFailureListener) {
    zzk<TResult> zzk = new zzk(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzx.zza(zzk);
    zza.zza(paramActivity).zzb(zzk);
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener paramOnFailureListener) {
    return super.addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener) {
    this.zzx.zza(new zzk<TResult>(paramExecutor, paramOnFailureListener));
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull Activity paramActivity, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener) {
    zzm<TResult> zzm = new zzm<TResult>(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzx.zza(zzm);
    zza.zza(paramActivity).zzb(zzm);
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> paramOnSuccessListener) {
    return super.addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener) {
    this.zzx.zza(new zzm<TResult>(paramExecutor, paramOnSuccessListener));
    zze();
    return this;
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> paramContinuation) {
    return super.continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation) {
    zzu<TContinuationResult> zzu1 = new zzu();
    this.zzx.zza(new zzc<TResult, TContinuationResult>(paramExecutor, paramContinuation, zzu1));
    zze();
    return zzu1;
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation) {
    return super.continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation) {
    zzu<TContinuationResult> zzu1 = new zzu();
    this.zzx.zza(new zze<TResult, TContinuationResult>(paramExecutor, paramContinuation, zzu1));
    zze();
    return zzu1;
  }
  
  @Nullable
  public final Exception getException() {
    synchronized (this.mLock) {
      return this.zzab;
    } 
  }
  
  public final TResult getResult() {
    synchronized (this.mLock) {
      zzb();
      zzd();
      if (this.zzab == null)
        return this.zzaa; 
      RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException();
      this(this.zzab);
      throw runtimeExecutionException;
    } 
  }
  
  public final <X extends Throwable> TResult getResult(@NonNull Class<X> paramClass) throws X {
    synchronized (this.mLock) {
      RuntimeExecutionException runtimeExecutionException;
      zzb();
      zzd();
      if (!paramClass.isInstance(this.zzab)) {
        if (this.zzab == null)
          return this.zzaa; 
        runtimeExecutionException = new RuntimeExecutionException();
        this(this.zzab);
        throw (X)runtimeExecutionException;
      } 
      throw (X)runtimeExecutionException.cast(this.zzab);
    } 
  }
  
  public final boolean isCanceled() {
    return this.zzz;
  }
  
  public final boolean isComplete() {
    synchronized (this.mLock) {
      return this.zzy;
    } 
  }
  
  public final boolean isSuccessful() {
    synchronized (this.mLock) {
      boolean bool;
      if (this.zzy && !this.zzz && this.zzab == null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } 
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation) {
    return super.onSuccessTask(TaskExecutors.MAIN_THREAD, paramSuccessContinuation);
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation) {
    zzu<TContinuationResult> zzu1 = new zzu();
    this.zzx.zza(new zzo<TResult, TContinuationResult>(paramExecutor, paramSuccessContinuation, zzu1));
    zze();
    return zzu1;
  }
  
  public final void setException(@NonNull Exception paramException) {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock) {
      zzc();
      this.zzy = true;
      this.zzab = paramException;
      this.zzx.zza(this);
      return;
    } 
  }
  
  public final void setResult(TResult paramTResult) {
    synchronized (this.mLock) {
      zzc();
      this.zzy = true;
      this.zzaa = paramTResult;
      this.zzx.zza(this);
      return;
    } 
  }
  
  public final boolean trySetException(@NonNull Exception paramException) {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock) {
      if (this.zzy)
        return false; 
      this.zzy = true;
      this.zzab = paramException;
      this.zzx.zza(this);
      return true;
    } 
  }
  
  public final boolean trySetResult(TResult paramTResult) {
    synchronized (this.mLock) {
      if (this.zzy)
        return false; 
      this.zzy = true;
      this.zzaa = paramTResult;
      this.zzx.zza(this);
      return true;
    } 
  }
  
  public final boolean zza() {
    synchronized (this.mLock) {
      if (this.zzy)
        return false; 
      this.zzy = true;
      this.zzz = true;
      this.zzx.zza(this);
      return true;
    } 
  }
  
  private static class zza extends LifecycleCallback {
    private final List<WeakReference<zzq<?>>> zzac = new ArrayList<WeakReference<zzq<?>>>();
    
    private zza(LifecycleFragment param1LifecycleFragment) {
      super(param1LifecycleFragment);
      this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }
    
    public static zza zza(Activity param1Activity) {
      LifecycleFragment lifecycleFragment = getFragment(param1Activity);
      zza zza2 = (zza)lifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
      zza zza1 = zza2;
      if (zza2 == null)
        zza1 = new zza(lifecycleFragment); 
      return zza1;
    }
    
    @MainThread
    public void onStop() {
      synchronized (this.zzac) {
        Iterator<WeakReference<zzq<?>>> iterator = this.zzac.iterator();
        while (iterator.hasNext()) {
          zzq zzq = ((WeakReference<zzq>)iterator.next()).get();
          if (zzq != null)
            zzq.cancel(); 
        } 
        this.zzac.clear();
        return;
      } 
    }
    
    public final <T> void zzb(zzq<T> param1zzq) {
      synchronized (this.zzac) {
        List<WeakReference<zzq<?>>> list = this.zzac;
        WeakReference<zzq<?>> weakReference = new WeakReference();
        this((T)param1zzq);
        list.add(weakReference);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */