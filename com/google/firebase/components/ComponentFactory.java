package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface ComponentFactory<T> {
  @KeepForSdk
  T create(ComponentContainer paramComponentContainer);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\ComponentFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */