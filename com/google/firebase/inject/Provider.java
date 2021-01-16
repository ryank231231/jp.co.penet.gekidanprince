package com.google.firebase.inject;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface Provider<T> {
  @KeepForSdk
  T get();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inject\Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */