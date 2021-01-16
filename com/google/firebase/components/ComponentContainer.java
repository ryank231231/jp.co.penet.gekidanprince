package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.Set;

@KeepForSdk
public interface ComponentContainer {
  @KeepForSdk
  <T> T get(Class<T> paramClass);
  
  @KeepForSdk
  <T> Provider<T> getProvider(Class<T> paramClass);
  
  @KeepForSdk
  <T> Set<T> setOf(Class<T> paramClass);
  
  @KeepForSdk
  <T> Provider<Set<T>> setOfProvider(Class<T> paramClass);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\ComponentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */