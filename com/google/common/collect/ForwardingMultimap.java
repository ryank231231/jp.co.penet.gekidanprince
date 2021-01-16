package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
  public Map<K, Collection<V>> asMap() {
    return delegate().asMap();
  }
  
  public void clear() {
    delegate().clear();
  }
  
  public boolean containsEntry(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    return delegate().containsEntry(paramObject1, paramObject2);
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    return delegate().containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    return delegate().containsValue(paramObject);
  }
  
  protected abstract Multimap<K, V> delegate();
  
  public Collection<Map.Entry<K, V>> entries() {
    return delegate().entries();
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return (paramObject == this || delegate().equals(paramObject));
  }
  
  public Collection<V> get(@Nullable K paramK) {
    return delegate().get(paramK);
  }
  
  public int hashCode() {
    return delegate().hashCode();
  }
  
  public boolean isEmpty() {
    return delegate().isEmpty();
  }
  
  public Set<K> keySet() {
    return delegate().keySet();
  }
  
  public Multiset<K> keys() {
    return delegate().keys();
  }
  
  @CanIgnoreReturnValue
  public boolean put(K paramK, V paramV) {
    return delegate().put(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap) {
    return delegate().putAll(paramMultimap);
  }
  
  @CanIgnoreReturnValue
  public boolean putAll(K paramK, Iterable<? extends V> paramIterable) {
    return delegate().putAll(paramK, paramIterable);
  }
  
  @CanIgnoreReturnValue
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    return delegate().remove(paramObject1, paramObject2);
  }
  
  @CanIgnoreReturnValue
  public Collection<V> removeAll(@Nullable Object paramObject) {
    return delegate().removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    return delegate().replaceValues(paramK, paramIterable);
  }
  
  public int size() {
    return delegate().size();
  }
  
  public Collection<V> values() {
    return delegate().values();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */