package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtIncompatible
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
  static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET;
  
  private static final long[] ZERO_CUMULATIVE_COUNTS = new long[] { 0L };
  
  private final transient long[] cumulativeCounts;
  
  private final transient RegularImmutableSortedSet<E> elementSet;
  
  private final transient int length;
  
  private final transient int offset;
  
  static {
    NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());
  }
  
  RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> paramRegularImmutableSortedSet, long[] paramArrayOflong, int paramInt1, int paramInt2) {
    this.elementSet = paramRegularImmutableSortedSet;
    this.cumulativeCounts = paramArrayOflong;
    this.offset = paramInt1;
    this.length = paramInt2;
  }
  
  RegularImmutableSortedMultiset(Comparator<? super E> paramComparator) {
    this.elementSet = ImmutableSortedSet.emptySet(paramComparator);
    this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
    this.offset = 0;
    this.length = 0;
  }
  
  private int getCount(int paramInt) {
    long[] arrayOfLong = this.cumulativeCounts;
    int i = this.offset;
    return (int)(arrayOfLong[i + paramInt + 1] - arrayOfLong[i + paramInt]);
  }
  
  public int count(@Nullable Object paramObject) {
    int i = this.elementSet.indexOf(paramObject);
    if (i >= 0) {
      i = getCount(i);
    } else {
      i = 0;
    } 
    return i;
  }
  
  public ImmutableSortedSet<E> elementSet() {
    return this.elementSet;
  }
  
  public Multiset.Entry<E> firstEntry() {
    Multiset.Entry<E> entry;
    if (isEmpty()) {
      entry = null;
    } else {
      entry = getEntry(0);
    } 
    return entry;
  }
  
  Multiset.Entry<E> getEntry(int paramInt) {
    return Multisets.immutableEntry(this.elementSet.asList().get(paramInt), getCount(paramInt));
  }
  
  ImmutableSortedMultiset<E> getSubMultiset(int paramInt1, int paramInt2) {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, this.length);
    return (paramInt1 == paramInt2) ? emptyMultiset(comparator()) : ((paramInt1 == 0 && paramInt2 == this.length) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(paramInt1, paramInt2), this.cumulativeCounts, this.offset + paramInt1, paramInt2 - paramInt1));
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType) {
    boolean bool;
    RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
    if (Preconditions.checkNotNull(paramBoundType) == BoundType.CLOSED) {
      bool = true;
    } else {
      bool = false;
    } 
    return getSubMultiset(0, regularImmutableSortedSet.headIndex(paramE, bool));
  }
  
  boolean isPartialView() {
    int i = this.offset;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i <= 0)
      if (this.length < this.cumulativeCounts.length - 1) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    return bool2;
  }
  
  public Multiset.Entry<E> lastEntry() {
    Multiset.Entry<E> entry;
    if (isEmpty()) {
      entry = null;
    } else {
      entry = getEntry(this.length - 1);
    } 
    return entry;
  }
  
  public int size() {
    long[] arrayOfLong = this.cumulativeCounts;
    int i = this.offset;
    return Ints.saturatedCast(arrayOfLong[this.length + i] - arrayOfLong[i]);
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType) {
    boolean bool;
    RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
    if (Preconditions.checkNotNull(paramBoundType) == BoundType.CLOSED) {
      bool = true;
    } else {
      bool = false;
    } 
    return getSubMultiset(regularImmutableSortedSet.tailIndex(paramE, bool), this.length);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */