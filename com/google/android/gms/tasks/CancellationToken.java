package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public abstract class CancellationToken {
  public abstract boolean isCancellationRequested();
  
  public abstract CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener paramOnTokenCanceledListener);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\CancellationToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */