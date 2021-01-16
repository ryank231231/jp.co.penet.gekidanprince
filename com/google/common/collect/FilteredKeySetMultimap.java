package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredKeySetMultimap<K, V> extends FilteredKeyMultimap<K, V> implements FilteredSetMultimap<K, V> {
  FilteredKeySetMultimap(SetMultimap<K, V> paramSetMultimap, Predicate<? super K> paramPredicate) {
    super(paramSetMultimap, paramPredicate);
  }
  
  Set<Map.Entry<K, V>> createEntries() {
    return new EntrySet();
  }
  
  public Set<Map.Entry<K, V>> entries() {
    return (Set<Map.Entry<K, V>>)super.entries();
  }
  
  public Set<V> get(K paramK) {
    return (Set<V>)super.get(paramK);
  }
  
  public Set<V> removeAll(Object paramObject) {
    return (Set<V>)super.removeAll(paramObject);
  }
  
  public Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    return (Set<V>)super.replaceValues(paramK, paramIterable);
  }
  
  public SetMultimap<K, V> unfiltered() {
    return (SetMultimap<K, V>)this.unfiltered;
  }
  
  class EntrySet extends FilteredKeyMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
    public boolean equals(@Nullable Object param1Object) {
      return Sets.equalsImpl(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.hashCodeImpl(this);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\FilteredKeySetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */