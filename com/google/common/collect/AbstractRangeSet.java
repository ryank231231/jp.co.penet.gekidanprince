package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtIncompatible
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
  public void add(Range<C> paramRange) {
    throw new UnsupportedOperationException();
  }
  
  public void addAll(RangeSet<C> paramRangeSet) {
    Iterator<Range<C>> iterator = paramRangeSet.asRanges().iterator();
    while (iterator.hasNext())
      add(iterator.next()); 
  }
  
  public void clear() {
    remove((Range)Range.all());
  }
  
  public boolean contains(C paramC) {
    boolean bool;
    if (rangeContaining(paramC) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public abstract boolean encloses(Range<C> paramRange);
  
  public boolean enclosesAll(RangeSet<C> paramRangeSet) {
    Iterator<Range<C>> iterator = paramRangeSet.asRanges().iterator();
    while (iterator.hasNext()) {
      if (!encloses(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof RangeSet) {
      paramObject = paramObject;
      return asRanges().equals(paramObject.asRanges());
    } 
    return false;
  }
  
  public final int hashCode() {
    return asRanges().hashCode();
  }
  
  public boolean intersects(Range<C> paramRange) {
    return subRangeSet(paramRange).isEmpty() ^ true;
  }
  
  public boolean isEmpty() {
    return asRanges().isEmpty();
  }
  
  public abstract Range<C> rangeContaining(C paramC);
  
  public void remove(Range<C> paramRange) {
    throw new UnsupportedOperationException();
  }
  
  public void removeAll(RangeSet<C> paramRangeSet) {
    Iterator<Range<C>> iterator = paramRangeSet.asRanges().iterator();
    while (iterator.hasNext())
      remove(iterator.next()); 
  }
  
  public final String toString() {
    return asRanges().toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */