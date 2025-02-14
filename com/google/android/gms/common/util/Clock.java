package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public interface Clock {
  @KeepForSdk
  long currentThreadTimeMillis();
  
  @KeepForSdk
  long currentTimeMillis();
  
  @KeepForSdk
  long elapsedRealtime();
  
  @KeepForSdk
  long nanoTime();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */