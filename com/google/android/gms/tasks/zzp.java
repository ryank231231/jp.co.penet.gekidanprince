package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

final class zzp implements Runnable {
  zzp(zzo paramzzo, Task paramTask) {}
  
  public final void run() {
    try {
      Task task = zzo.zza(this.zzs).then(this.zzg.getResult());
      if (task == null) {
        this.zzs.onFailure(new NullPointerException("Continuation returned null"));
        return;
      } 
      task.addOnSuccessListener(TaskExecutors.zzw, this.zzs);
      task.addOnFailureListener(TaskExecutors.zzw, this.zzs);
      task.addOnCanceledListener(TaskExecutors.zzw, this.zzs);
      return;
    } catch (RuntimeExecutionException runtimeExecutionException) {
      if (runtimeExecutionException.getCause() instanceof Exception) {
        this.zzs.onFailure((Exception)runtimeExecutionException.getCause());
        return;
      } 
      this.zzs.onFailure(runtimeExecutionException);
      return;
    } catch (CancellationException cancellationException) {
      this.zzs.onCanceled();
      return;
    } catch (Exception exception) {
      this.zzs.onFailure(exception);
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */