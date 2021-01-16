package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
  @LazyInit
  @RetainedWith
  transient ImmutableBiMap<V, K> inverse;
  
  final transient K singleKey;
  
  final transient V singleValue;
  
  SingletonImmutableBiMap(K paramK, V paramV) {
    CollectPreconditions.checkEntryNotNull(paramK, paramV);
    this.singleKey = paramK;
    this.singleValue = paramV;
  }
  
  private SingletonImmutableBiMap(K paramK, V paramV, ImmutableBiMap<V, K> paramImmutableBiMap) {
    this.singleKey = paramK;
    this.singleValue = paramV;
    this.inverse = paramImmutableBiMap;
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    return this.singleKey.equals(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    return this.singleValue.equals(paramObject);
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet() {
    return ImmutableSet.of(Maps.immutableEntry(this.singleKey, this.singleValue));
  }
  
  ImmutableSet<K> createKeySet() {
    return ImmutableSet.of(this.singleKey);
  }
  
  public V get(@Nullable Object paramObject) {
    if (this.singleKey.equals(paramObject)) {
      paramObject = this.singleValue;
    } else {
      paramObject = null;
    } 
    return (V)paramObject;
  }
  
  public ImmutableBiMap<V, K> inverse() {
    ImmutableBiMap<V, K> immutableBiMap = this.inverse;
    if (immutableBiMap == null) {
      immutableBiMap = new SingletonImmutableBiMap((K)this.singleValue, (V)this.singleKey, this);
      this.inverse = immutableBiMap;
      return immutableBiMap;
    } 
    return immutableBiMap;
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public int size() {
    return 1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SingletonImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */