package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

public final class Tasks {
  public static <TResult> TResult await(@NonNull Task<TResult> paramTask) throws ExecutionException, InterruptedException {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    if (paramTask.isComplete())
      return zzb(paramTask); 
    zza zza = new zza(null);
    zza(paramTask, zza);
    zza.await();
    return zzb(paramTask);
  }
  
  public static <TResult> TResult await(@NonNull Task<TResult> paramTask, long paramLong, @NonNull TimeUnit paramTimeUnit) throws ExecutionException, InterruptedException, TimeoutException {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete())
      return zzb(paramTask); 
    zza zza = new zza(null);
    zza(paramTask, zza);
    if (zza.await(paramLong, paramTimeUnit))
      return zzb(paramTask); 
    throw new TimeoutException("Timed out waiting for Task");
  }
  
  public static <TResult> Task<TResult> call(@NonNull Callable<TResult> paramCallable) {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }
  
  public static <TResult> Task<TResult> call(@NonNull Executor paramExecutor, @NonNull Callable<TResult> paramCallable) {
    Preconditions.checkNotNull(paramExecutor, "Executor must not be null");
    Preconditions.checkNotNull(paramCallable, "Callback must not be null");
    zzu<TResult> zzu = new zzu();
    paramExecutor.execute(new zzv(zzu, paramCallable));
    return zzu;
  }
  
  public static <TResult> Task<TResult> forCanceled() {
    zzu<TResult> zzu = new zzu();
    zzu.zza();
    return zzu;
  }
  
  public static <TResult> Task<TResult> forException(@NonNull Exception paramException) {
    zzu<TResult> zzu = new zzu();
    zzu.setException(paramException);
    return zzu;
  }
  
  public static <TResult> Task<TResult> forResult(TResult paramTResult) {
    zzu<TResult> zzu = new zzu();
    zzu.setResult(paramTResult);
    return zzu;
  }
  
  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection) {
    if (paramCollection.isEmpty())
      return forResult(null); 
    Iterator<? extends Task<?>> iterator2 = paramCollection.iterator();
    while (iterator2.hasNext()) {
      if ((Task)iterator2.next() != null)
        continue; 
      throw new NullPointerException("null tasks are not accepted");
    } 
    zzu<Void> zzu = new zzu();
    zzc zzc = new zzc(paramCollection.size(), zzu);
    Iterator<? extends Task<?>> iterator1 = paramCollection.iterator();
    while (iterator1.hasNext())
      zza(iterator1.next(), zzc); 
    return zzu;
  }
  
  public static Task<Void> whenAll(Task<?>... paramVarArgs) {
    return (paramVarArgs.length == 0) ? forResult(null) : whenAll(Arrays.asList(paramVarArgs));
  }
  
  public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> paramCollection) {
    return whenAll(paramCollection).continueWithTask(new zzx(paramCollection));
  }
  
  public static Task<List<Task<?>>> whenAllComplete(Task<?>... paramVarArgs) {
    return whenAllComplete(Arrays.asList(paramVarArgs));
  }
  
  public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> paramCollection) {
    return whenAll(paramCollection).continueWith(new zzw(paramCollection));
  }
  
  public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... paramVarArgs) {
    return whenAllSuccess(Arrays.asList(paramVarArgs));
  }
  
  private static void zza(Task<?> paramTask, zzb paramzzb) {
    paramTask.addOnSuccessListener(TaskExecutors.zzw, paramzzb);
    paramTask.addOnFailureListener(TaskExecutors.zzw, paramzzb);
    paramTask.addOnCanceledListener(TaskExecutors.zzw, paramzzb);
  }
  
  private static <TResult> TResult zzb(Task<TResult> paramTask) throws ExecutionException {
    if (paramTask.isSuccessful())
      return paramTask.getResult(); 
    if (paramTask.isCanceled())
      throw new CancellationException("Task is already canceled"); 
    throw new ExecutionException(paramTask.getException());
  }
  
  private static final class zza implements zzb {
    private final CountDownLatch zzaf = new CountDownLatch(1);
    
    private zza() {}
    
    public final void await() throws InterruptedException {
      this.zzaf.await();
    }
    
    public final boolean await(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      return this.zzaf.await(param1Long, param1TimeUnit);
    }
    
    public final void onCanceled() {
      this.zzaf.countDown();
    }
    
    public final void onFailure(@NonNull Exception param1Exception) {
      this.zzaf.countDown();
    }
    
    public final void onSuccess(Object param1Object) {
      this.zzaf.countDown();
    }
  }
  
  static interface zzb extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {}
  
  private static final class zzc implements zzb {
    private final Object mLock = new Object();
    
    private final zzu<Void> zza;
    
    @GuardedBy("mLock")
    private Exception zzab;
    
    private final int zzag;
    
    @GuardedBy("mLock")
    private int zzah;
    
    @GuardedBy("mLock")
    private int zzai;
    
    @GuardedBy("mLock")
    private int zzaj;
    
    @GuardedBy("mLock")
    private boolean zzak;
    
    public zzc(int param1Int, zzu<Void> param1zzu) {
      this.zzag = param1Int;
      this.zza = param1zzu;
    }
    
    @GuardedBy("mLock")
    private final void zzf() {
      int i = this.zzah;
      int j = this.zzai;
      int k = this.zzaj;
      int m = this.zzag;
      if (i + j + k == m) {
        if (this.zzab != null) {
          zzu<Void> zzu1 = this.zza;
          StringBuilder stringBuilder = new StringBuilder(54);
          stringBuilder.append(j);
          stringBuilder.append(" out of ");
          stringBuilder.append(m);
          stringBuilder.append(" underlying tasks failed");
          zzu1.setException(new ExecutionException(stringBuilder.toString(), this.zzab));
          return;
        } 
        if (this.zzak) {
          this.zza.zza();
          return;
        } 
        this.zza.setResult(null);
      } 
    }
    
    public final void onCanceled() {
      synchronized (this.mLock) {
        this.zzaj++;
        this.zzak = true;
        zzf();
        return;
      } 
    }
    
    public final void onFailure(@NonNull Exception param1Exception) {
      synchronized (this.mLock) {
        this.zzai++;
        this.zzab = param1Exception;
        zzf();
        return;
      } 
    }
    
    public final void onSuccess(Object param1Object) {
      synchronized (this.mLock) {
        this.zzah++;
        zzf();
        return;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\Tasks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */