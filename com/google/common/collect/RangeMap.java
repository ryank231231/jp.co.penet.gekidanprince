package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public interface RangeMap<K extends Comparable, V> {
  Map<Range<K>, V> asDescendingMapOfRanges();
  
  Map<Range<K>, V> asMapOfRanges();
  
  void clear();
  
  boolean equals(@Nullable Object paramObject);
  
  @Nullable
  V get(K paramK);
  
  @Nullable
  Map.Entry<Range<K>, V> getEntry(K paramK);
  
  int hashCode();
  
  void put(Range<K> paramRange, V paramV);
  
  void putAll(RangeMap<K, V> paramRangeMap);
  
  void remove(Range<K> paramRange);
  
  Range<K> span();
  
  RangeMap<K, V> subRangeMap(Range<K> paramRange);
  
  String toString();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */