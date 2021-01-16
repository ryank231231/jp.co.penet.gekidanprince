package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface Multimap<K, V> {
  Map<K, Collection<V>> asMap();
  
  void clear();
  
  boolean containsEntry(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  boolean containsKey(@Nullable Object paramObject);
  
  boolean containsValue(@Nullable Object paramObject);
  
  Collection<Map.Entry<K, V>> entries();
  
  boolean equals(@Nullable Object paramObject);
  
  Collection<V> get(@Nullable K paramK);
  
  int hashCode();
  
  boolean isEmpty();
  
  Set<K> keySet();
  
  Multiset<K> keys();
  
  @CanIgnoreReturnValue
  boolean put(@Nullable K paramK, @Nullable V paramV);
  
  @CanIgnoreReturnValue
  boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
  
  @CanIgnoreReturnValue
  boolean putAll(@Nullable K paramK, Iterable<? extends V> paramIterable);
  
  @CanIgnoreReturnValue
  boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  @CanIgnoreReturnValue
  Collection<V> removeAll(@Nullable Object paramObject);
  
  @CanIgnoreReturnValue
  Collection<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable);
  
  int size();
  
  Collection<V> values();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Multimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */