package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
  private static final long serialVersionUID = 0L;
  
  private final Range<C> range;
  
  RegularContiguousSet(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain) {
    super(paramDiscreteDomain);
    this.range = paramRange;
  }
  
  private static boolean equalsOrThrow(Comparable<?> paramComparable1, @Nullable Comparable<?> paramComparable2) {
    boolean bool;
    if (paramComparable2 != null && Range.compareOrThrow(paramComparable1, paramComparable2) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private ContiguousSet<C> intersectionInCurrentDomain(Range<C> paramRange) {
    ContiguousSet<C> contiguousSet;
    if (this.range.isConnected(paramRange)) {
      contiguousSet = ContiguousSet.create(this.range.intersection(paramRange), this.domain);
    } else {
      contiguousSet = new EmptyContiguousSet<C>(this.domain);
    } 
    return contiguousSet;
  }
  
  public boolean contains(@Nullable Object paramObject) {
    if (paramObject == null)
      return false; 
    try {
      return this.range.contains((C)paramObject);
    } catch (ClassCastException classCastException) {
      return false;
    } 
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    return Collections2.containsAllImpl(this, paramCollection);
  }
  
  @GwtIncompatible
  public UnmodifiableIterator<C> descendingIterator() {
    return new AbstractSequentialIterator<C>((Comparable)last()) {
        final C first = RegularContiguousSet.this.first();
        
        protected C computeNext(C param1C) {
          if (RegularContiguousSet.equalsOrThrow((Comparable<?>)param1C, (Comparable<?>)this.first)) {
            param1C = null;
          } else {
            param1C = RegularContiguousSet.this.domain.previous(param1C);
          } 
          return param1C;
        }
      };
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof RegularContiguousSet) {
      RegularContiguousSet regularContiguousSet = (RegularContiguousSet)paramObject;
      if (this.domain.equals(regularContiguousSet.domain)) {
        if (!first().equals(regularContiguousSet.first()) || !last().equals(regularContiguousSet.last()))
          bool = false; 
        return bool;
      } 
    } 
    return super.equals(paramObject);
  }
  
  public C first() {
    return this.range.lowerBound.leastValueAbove(this.domain);
  }
  
  public int hashCode() {
    return Sets.hashCodeImpl(this);
  }
  
  ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean) {
    return intersectionInCurrentDomain((Range)Range.upTo((Comparable<?>)paramC, BoundType.forBoolean(paramBoolean)));
  }
  
  @GwtIncompatible
  int indexOf(Object paramObject) {
    byte b;
    if (contains(paramObject)) {
      b = (int)this.domain.distance(first(), (C)paramObject);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet) {
    ContiguousSet<C> contiguousSet;
    Preconditions.checkNotNull(paramContiguousSet);
    Preconditions.checkArgument(this.domain.equals(paramContiguousSet.domain));
    if (paramContiguousSet.isEmpty())
      return paramContiguousSet; 
    Comparable<Comparable> comparable2 = (Comparable)Ordering.<Comparable>natural().max(first(), paramContiguousSet.first());
    Comparable<Comparable> comparable1 = (Comparable)Ordering.<Comparable>natural().min(last(), paramContiguousSet.last());
    if (comparable2.compareTo(comparable1) <= 0) {
      contiguousSet = ContiguousSet.create((Range)Range.closed(comparable2, comparable1), this.domain);
    } else {
      contiguousSet = new EmptyContiguousSet<C>(this.domain);
    } 
    return contiguousSet;
  }
  
  public boolean isEmpty() {
    return false;
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public UnmodifiableIterator<C> iterator() {
    return new AbstractSequentialIterator<C>((Comparable)first()) {
        final C last = RegularContiguousSet.this.last();
        
        protected C computeNext(C param1C) {
          if (RegularContiguousSet.equalsOrThrow((Comparable<?>)param1C, (Comparable<?>)this.last)) {
            param1C = null;
          } else {
            param1C = RegularContiguousSet.this.domain.next(param1C);
          } 
          return param1C;
        }
      };
  }
  
  public C last() {
    return this.range.upperBound.greatestValueBelow(this.domain);
  }
  
  public Range<C> range() {
    return range(BoundType.CLOSED, BoundType.CLOSED);
  }
  
  public Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2) {
    return (Range)Range.create(this.range.lowerBound.withLowerBoundType(paramBoundType1, this.domain), this.range.upperBound.withUpperBoundType(paramBoundType2, this.domain));
  }
  
  public int size() {
    int i;
    long l = this.domain.distance(first(), last());
    if (l >= 2147483647L) {
      i = Integer.MAX_VALUE;
    } else {
      i = (int)l + 1;
    } 
    return i;
  }
  
  ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2) {
    return (paramC1.compareTo(paramC2) == 0 && !paramBoolean1 && !paramBoolean2) ? new EmptyContiguousSet<C>(this.domain) : intersectionInCurrentDomain((Range)Range.range((Comparable<?>)paramC1, BoundType.forBoolean(paramBoolean1), (Comparable<?>)paramC2, BoundType.forBoolean(paramBoolean2)));
  }
  
  ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean) {
    return intersectionInCurrentDomain((Range)Range.downTo((Comparable<?>)paramC, BoundType.forBoolean(paramBoolean)));
  }
  
  @GwtIncompatible
  Object writeReplace() {
    return new SerializedForm<Comparable>(this.range, this.domain);
  }
  
  @GwtIncompatible
  private static final class SerializedForm<C extends Comparable> implements Serializable {
    final DiscreteDomain<C> domain;
    
    final Range<C> range;
    
    private SerializedForm(Range<C> param1Range, DiscreteDomain<C> param1DiscreteDomain) {
      this.range = param1Range;
      this.domain = param1DiscreteDomain;
    }
    
    private Object readResolve() {
      return new RegularContiguousSet<C>(this.range, this.domain);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */