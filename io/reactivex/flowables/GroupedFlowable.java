package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;

public abstract class GroupedFlowable<K, T> extends Flowable<T> {
  final K key;
  
  protected GroupedFlowable(@Nullable K paramK) {
    this.key = paramK;
  }
  
  @Nullable
  public K getKey() {
    return this.key;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\flowables\GroupedFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */