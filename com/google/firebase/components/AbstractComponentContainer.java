package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

abstract class AbstractComponentContainer implements ComponentContainer {
  public <T> T get(Class<T> paramClass) {
    Provider<T> provider = getProvider(paramClass);
    return (T)((provider == null) ? null : provider.get());
  }
  
  public <T> Set<T> setOf(Class<T> paramClass) {
    return (Set<T>)setOfProvider(paramClass).get();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\AbstractComponentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */