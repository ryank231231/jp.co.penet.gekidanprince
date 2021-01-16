package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;

public abstract class GroupedObservable<K, T> extends Observable<T> {
  final K key;
  
  protected GroupedObservable(@Nullable K paramK) {
    this.key = paramK;
  }
  
  @Nullable
  public K getKey() {
    return this.key;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\observables\GroupedObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */