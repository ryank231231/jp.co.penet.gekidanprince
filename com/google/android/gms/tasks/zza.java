package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

final class zza extends CancellationToken {
  private final zzu<Void> zza = new zzu<Void>();
  
  public final void cancel() {
    this.zza.trySetResult(null);
  }
  
  public final boolean isCancellationRequested() {
    return this.zza.isComplete();
  }
  
  public final CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener paramOnTokenCanceledListener) {
    this.zza.addOnSuccessListener(new zzb(this, paramOnTokenCanceledListener));
    return this;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */