package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
  Map<K, Collection<V>> asMap();
  
  SortedSet<V> get(@Nullable K paramK);
  
  @CanIgnoreReturnValue
  SortedSet<V> removeAll(@Nullable Object paramObject);
  
  @CanIgnoreReturnValue
  SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  Comparator<? super V> valueComparator();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */