package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V> {
  FilteredKeyListMultimap(ListMultimap<K, V> paramListMultimap, Predicate<? super K> paramPredicate) {
    super(paramListMultimap, paramPredicate);
  }
  
  public List<V> get(K paramK) {
    return (List<V>)super.get(paramK);
  }
  
  public List<V> removeAll(@Nullable Object paramObject) {
    return (List<V>)super.removeAll(paramObject);
  }
  
  public List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    return (List<V>)super.replaceValues(paramK, paramIterable);
  }
  
  public ListMultimap<K, V> unfiltered() {
    return (ListMultimap<K, V>)super.unfiltered();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\FilteredKeyListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */