package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public interface RangeSet<C extends Comparable> {
  void add(Range<C> paramRange);
  
  void addAll(RangeSet<C> paramRangeSet);
  
  Set<Range<C>> asDescendingSetOfRanges();
  
  Set<Range<C>> asRanges();
  
  void clear();
  
  RangeSet<C> complement();
  
  boolean contains(C paramC);
  
  boolean encloses(Range<C> paramRange);
  
  boolean enclosesAll(RangeSet<C> paramRangeSet);
  
  boolean equals(@Nullable Object paramObject);
  
  int hashCode();
  
  boolean intersects(Range<C> paramRange);
  
  boolean isEmpty();
  
  Range<C> rangeContaining(C paramC);
  
  void remove(Range<C> paramRange);
  
  void removeAll(RangeSet<C> paramRangeSet);
  
  Range<C> span();
  
  RangeSet<C> subRangeSet(Range<C> paramRange);
  
  String toString();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */