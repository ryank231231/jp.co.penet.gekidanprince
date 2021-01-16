package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

@GwtCompatible(emulated = true)
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
  final DiscreteDomain<C> domain;
  
  ContiguousSet(DiscreteDomain<C> paramDiscreteDomain) {
    super(Ordering.natural());
    this.domain = paramDiscreteDomain;
  }
  
  @Deprecated
  public static <E> ImmutableSortedSet.Builder<E> builder() {
    throw new UnsupportedOperationException();
  }
  
  public static <C extends Comparable> ContiguousSet<C> create(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain) {
    Preconditions.checkNotNull(paramRange);
    Preconditions.checkNotNull(paramDiscreteDomain);
    try {
      RegularContiguousSet<C> regularContiguousSet;
      Range<C> range1;
      boolean bool;
      if (!paramRange.hasLowerBound()) {
        range1 = paramRange.intersection((Range)Range.atLeast((Comparable<?>)paramDiscreteDomain.minValue()));
      } else {
        range1 = paramRange;
      } 
      Range<C> range2 = range1;
      if (!paramRange.hasUpperBound())
        range2 = range1.intersection((Range)Range.atMost((Comparable<?>)paramDiscreteDomain.maxValue())); 
      if (range2.isEmpty() || Range.compareOrThrow((Comparable)paramRange.lowerBound.leastValueAbove(paramDiscreteDomain), (Comparable)paramRange.upperBound.greatestValueBelow(paramDiscreteDomain)) > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        EmptyContiguousSet<C> emptyContiguousSet = new EmptyContiguousSet<C>(paramDiscreteDomain);
      } else {
        regularContiguousSet = new RegularContiguousSet<C>(range2, paramDiscreteDomain);
      } 
      return regularContiguousSet;
    } catch (NoSuchElementException noSuchElementException) {
      throw new IllegalArgumentException(noSuchElementException);
    } 
  }
  
  public ContiguousSet<C> headSet(C paramC) {
    return headSetImpl((C)Preconditions.checkNotNull(paramC), false);
  }
  
  @GwtIncompatible
  public ContiguousSet<C> headSet(C paramC, boolean paramBoolean) {
    return headSetImpl((C)Preconditions.checkNotNull(paramC), paramBoolean);
  }
  
  abstract ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean);
  
  public abstract ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet);
  
  public abstract Range<C> range();
  
  public abstract Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2);
  
  public ContiguousSet<C> subSet(C paramC1, C paramC2) {
    boolean bool;
    Preconditions.checkNotNull(paramC1);
    Preconditions.checkNotNull(paramC2);
    if (comparator().compare(paramC1, paramC2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return subSetImpl(paramC1, true, paramC2, false);
  }
  
  @GwtIncompatible
  public ContiguousSet<C> subSet(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2) {
    boolean bool;
    Preconditions.checkNotNull(paramC1);
    Preconditions.checkNotNull(paramC2);
    if (comparator().compare(paramC1, paramC2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return subSetImpl(paramC1, paramBoolean1, paramC2, paramBoolean2);
  }
  
  abstract ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2);
  
  public ContiguousSet<C> tailSet(C paramC) {
    return tailSetImpl((C)Preconditions.checkNotNull(paramC), true);
  }
  
  @GwtIncompatible
  public ContiguousSet<C> tailSet(C paramC, boolean paramBoolean) {
    return tailSetImpl((C)Preconditions.checkNotNull(paramC), paramBoolean);
  }
  
  abstract ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean);
  
  public String toString() {
    return range().toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */