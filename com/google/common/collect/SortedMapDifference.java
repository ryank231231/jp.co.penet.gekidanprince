package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.SortedMap;

@GwtCompatible
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
  SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();
  
  SortedMap<K, V> entriesInCommon();
  
  SortedMap<K, V> entriesOnlyOnLeft();
  
  SortedMap<K, V> entriesOnlyOnRight();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SortedMapDifference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */