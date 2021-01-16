package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {
  SetMultimap<K, V> unfiltered();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\FilteredSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */