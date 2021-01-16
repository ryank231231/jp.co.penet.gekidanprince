package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {
  private static final ImmutableRangeSet<Comparable<?>> ALL;
  
  private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet(ImmutableList.of());
  
  @LazyInit
  private transient ImmutableRangeSet<C> complement;
  
  private final transient ImmutableList<Range<C>> ranges;
  
  static {
    ALL = new ImmutableRangeSet(ImmutableList.of((Range)Range.all()));
  }
  
  ImmutableRangeSet(ImmutableList<Range<C>> paramImmutableList) {
    this.ranges = paramImmutableList;
  }
  
  private ImmutableRangeSet(ImmutableList<Range<C>> paramImmutableList, ImmutableRangeSet<C> paramImmutableRangeSet) {
    this.ranges = paramImmutableList;
    this.complement = paramImmutableRangeSet;
  }
  
  static <C extends Comparable> ImmutableRangeSet<C> all() {
    return (ImmutableRangeSet)ALL;
  }
  
  public static <C extends Comparable<?>> Builder<C> builder() {
    return new Builder<C>();
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> paramRangeSet) {
    Preconditions.checkNotNull(paramRangeSet);
    if (paramRangeSet.isEmpty())
      return of(); 
    if (paramRangeSet.encloses((Range)Range.all()))
      return all(); 
    if (paramRangeSet instanceof ImmutableRangeSet) {
      ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet)paramRangeSet;
      if (!immutableRangeSet.isPartialView())
        return immutableRangeSet; 
    } 
    return new ImmutableRangeSet<C>(ImmutableList.copyOf(paramRangeSet.asRanges()));
  }
  
  private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
    final byte fromIndex;
    final int length;
    if (this.ranges.isEmpty() || range.isEmpty())
      return ImmutableList.of(); 
    if (range.encloses(span()))
      return this.ranges; 
    if (range.hasLowerBound()) {
      b = SortedLists.binarySearch(this.ranges, (Function)Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    } else {
      b = 0;
    } 
    if (range.hasUpperBound()) {
      i = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    } else {
      i = this.ranges.size();
    } 
    i -= b;
    return (i == 0) ? ImmutableList.of() : new ImmutableList<Range<C>>() {
        public Range<C> get(int param1Int) {
          Preconditions.checkElementIndex(param1Int, length);
          return (param1Int == 0 || param1Int == length - 1) ? ((Range<C>)ImmutableRangeSet.this.ranges.get(param1Int + fromIndex)).intersection(range) : ImmutableRangeSet.this.ranges.get(param1Int + fromIndex);
        }
        
        boolean isPartialView() {
          return true;
        }
        
        public int size() {
          return length;
        }
      };
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> of() {
    return (ImmutableRangeSet)EMPTY;
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> paramRange) {
    Preconditions.checkNotNull(paramRange);
    return paramRange.isEmpty() ? of() : (paramRange.equals(Range.all()) ? all() : new ImmutableRangeSet<C>(ImmutableList.of(paramRange)));
  }
  
  @Deprecated
  public void add(Range<C> paramRange) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void addAll(RangeSet<C> paramRangeSet) {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
    return this.ranges.isEmpty() ? ImmutableSet.of() : new RegularImmutableSortedSet<Range<C>>(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse());
  }
  
  public ImmutableSet<Range<C>> asRanges() {
    return (ImmutableSet<Range<C>>)(this.ranges.isEmpty() ? ImmutableSet.of() : new RegularImmutableSortedSet<Range<?>>(this.ranges, Range.RANGE_LEX_ORDERING));
  }
  
  public ImmutableSortedSet<C> asSet(DiscreteDomain<C> paramDiscreteDomain) {
    Preconditions.checkNotNull(paramDiscreteDomain);
    if (isEmpty())
      return ImmutableSortedSet.of(); 
    Range<C> range = span().canonical(paramDiscreteDomain);
    if (range.hasLowerBound()) {
      if (!range.hasUpperBound())
        try {
          paramDiscreteDomain.maxValue();
        } catch (NoSuchElementException noSuchElementException) {
          throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
        }  
      return new AsSet((DiscreteDomain<C>)noSuchElementException);
    } 
    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
  }
  
  public ImmutableRangeSet<C> complement() {
    ImmutableRangeSet<C> immutableRangeSet = this.complement;
    if (immutableRangeSet != null)
      return immutableRangeSet; 
    if (this.ranges.isEmpty()) {
      immutableRangeSet = all();
      this.complement = immutableRangeSet;
      return immutableRangeSet;
    } 
    if (this.ranges.size() == 1 && ((Range)this.ranges.get(0)).equals(Range.all())) {
      immutableRangeSet = of();
      this.complement = immutableRangeSet;
      return immutableRangeSet;
    } 
    immutableRangeSet = new ImmutableRangeSet(new ComplementRanges(), this);
    this.complement = immutableRangeSet;
    return immutableRangeSet;
  }
  
  public boolean encloses(Range<C> paramRange) {
    boolean bool;
    int i = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), paramRange.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    if (i != -1 && ((Range<C>)this.ranges.get(i)).encloses(paramRange)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean intersects(Range<C> paramRange) {
    int i = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), paramRange.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    int j = this.ranges.size();
    null = true;
    if (i < j && ((Range<C>)this.ranges.get(i)).isConnected(paramRange) && !((Range<C>)this.ranges.get(i)).intersection(paramRange).isEmpty())
      return true; 
    if (i > 0) {
      ImmutableList<Range<C>> immutableList = this.ranges;
      if (((Range<C>)immutableList.get(--i)).isConnected(paramRange) && !((Range<C>)this.ranges.get(i)).intersection(paramRange).isEmpty())
        return null; 
    } 
    return false;
  }
  
  public boolean isEmpty() {
    return this.ranges.isEmpty();
  }
  
  boolean isPartialView() {
    return this.ranges.isPartialView();
  }
  
  public Range<C> rangeContaining(C paramC) {
    int i = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), Cut.belowValue(paramC), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    if (i != -1) {
      Range<C> range = this.ranges.get(i);
      if (range.contains(paramC)) {
        Range<C> range1 = range;
      } else {
        paramC = null;
      } 
      return (Range<C>)paramC;
    } 
    return null;
  }
  
  @Deprecated
  public void remove(Range<C> paramRange) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void removeAll(RangeSet<C> paramRangeSet) {
    throw new UnsupportedOperationException();
  }
  
  public Range<C> span() {
    if (!this.ranges.isEmpty()) {
      Cut<Comparable<?>> cut = ((Range)this.ranges.get(0)).lowerBound;
      ImmutableList<Range<C>> immutableList = this.ranges;
      return (Range)Range.create(cut, ((Range)immutableList.get(immutableList.size() - 1)).upperBound);
    } 
    throw new NoSuchElementException();
  }
  
  public ImmutableRangeSet<C> subRangeSet(Range<C> paramRange) {
    if (!isEmpty()) {
      Range<C> range = span();
      if (paramRange.encloses(range))
        return this; 
      if (paramRange.isConnected(range))
        return new ImmutableRangeSet(intersectRanges(paramRange)); 
    } 
    return of();
  }
  
  Object writeReplace() {
    return new SerializedForm<C>(this.ranges);
  }
  
  private final class AsSet extends ImmutableSortedSet<C> {
    private final DiscreteDomain<C> domain;
    
    private transient Integer size;
    
    AsSet(DiscreteDomain<C> param1DiscreteDomain) {
      super(Ordering.natural());
      this.domain = param1DiscreteDomain;
    }
    
    public boolean contains(@Nullable Object param1Object) {
      if (param1Object == null)
        return false; 
      try {
        param1Object = param1Object;
        return ImmutableRangeSet.this.contains((Comparable)param1Object);
      } catch (ClassCastException classCastException) {
        return false;
      } 
    }
    
    @GwtIncompatible("NavigableSet")
    public UnmodifiableIterator<C> descendingIterator() {
      return new AbstractIterator<C>() {
          Iterator<C> elemItr = Iterators.emptyIterator();
          
          final Iterator<Range<C>> rangeItr = ImmutableRangeSet.this.ranges.reverse().iterator();
          
          protected C computeNext() {
            while (!this.elemItr.hasNext()) {
              if (this.rangeItr.hasNext()) {
                this.elemItr = ContiguousSet.<C>create(this.rangeItr.next(), ImmutableRangeSet.AsSet.this.domain).descendingIterator();
                continue;
              } 
              return endOfData();
            } 
            return this.elemItr.next();
          }
        };
    }
    
    ImmutableSortedSet<C> headSetImpl(C param1C, boolean param1Boolean) {
      return subSet((Range)Range.upTo((Comparable<?>)param1C, BoundType.forBoolean(param1Boolean)));
    }
    
    int indexOf(Object param1Object) {
      if (contains(param1Object)) {
        param1Object = param1Object;
        long l = 0L;
        for (Range<Object> range : (Iterable<Range<Object>>)ImmutableRangeSet.this.ranges) {
          if (range.contains(param1Object))
            return Ints.saturatedCast(l + ContiguousSet.<Object>create(range, this.domain).indexOf(param1Object)); 
          l += ContiguousSet.<Object>create(range, this.domain).size();
        } 
        throw new AssertionError("impossible");
      } 
      return -1;
    }
    
    boolean isPartialView() {
      return ImmutableRangeSet.this.ranges.isPartialView();
    }
    
    public UnmodifiableIterator<C> iterator() {
      return new AbstractIterator<C>() {
          Iterator<C> elemItr = Iterators.emptyIterator();
          
          final Iterator<Range<C>> rangeItr = ImmutableRangeSet.this.ranges.iterator();
          
          protected C computeNext() {
            while (!this.elemItr.hasNext()) {
              if (this.rangeItr.hasNext()) {
                this.elemItr = ContiguousSet.<C>create(this.rangeItr.next(), ImmutableRangeSet.AsSet.this.domain).iterator();
                continue;
              } 
              return endOfData();
            } 
            return this.elemItr.next();
          }
        };
    }
    
    public int size() {
      Integer integer1 = this.size;
      Integer integer2 = integer1;
      if (integer1 == null) {
        long l2;
        long l1 = 0L;
        Iterator<Range<C>> iterator = ImmutableRangeSet.this.ranges.iterator();
        while (true) {
          l2 = l1;
          if (iterator.hasNext()) {
            l2 = l1 + ContiguousSet.<C>create(iterator.next(), this.domain).size();
            l1 = l2;
            if (l2 >= 2147483647L)
              break; 
            continue;
          } 
          break;
        } 
        integer2 = Integer.valueOf(Ints.saturatedCast(l2));
        this.size = integer2;
      } 
      return integer2.intValue();
    }
    
    ImmutableSortedSet<C> subSet(Range<C> param1Range) {
      return ImmutableRangeSet.this.subRangeSet(param1Range).asSet(this.domain);
    }
    
    ImmutableSortedSet<C> subSetImpl(C param1C1, boolean param1Boolean1, C param1C2, boolean param1Boolean2) {
      return (!param1Boolean1 && !param1Boolean2 && Range.compareOrThrow((Comparable)param1C1, (Comparable)param1C2) == 0) ? ImmutableSortedSet.of() : subSet((Range)Range.range((Comparable<?>)param1C1, BoundType.forBoolean(param1Boolean1), (Comparable<?>)param1C2, BoundType.forBoolean(param1Boolean2)));
    }
    
    ImmutableSortedSet<C> tailSetImpl(C param1C, boolean param1Boolean) {
      return subSet((Range)Range.downTo((Comparable<?>)param1C, BoundType.forBoolean(param1Boolean)));
    }
    
    public String toString() {
      return ImmutableRangeSet.this.ranges.toString();
    }
    
    Object writeReplace() {
      return new ImmutableRangeSet.AsSetSerializedForm<C>(ImmutableRangeSet.this.ranges, this.domain);
    }
  }
  
  class null extends AbstractIterator<C> {
    Iterator<C> elemItr = Iterators.emptyIterator();
    
    final Iterator<Range<C>> rangeItr = ImmutableRangeSet.this.ranges.iterator();
    
    protected C computeNext() {
      while (!this.elemItr.hasNext()) {
        if (this.rangeItr.hasNext()) {
          this.elemItr = ContiguousSet.<C>create(this.rangeItr.next(), this.this$1.domain).iterator();
          continue;
        } 
        return endOfData();
      } 
      return this.elemItr.next();
    }
  }
  
  class null extends AbstractIterator<C> {
    Iterator<C> elemItr = Iterators.emptyIterator();
    
    final Iterator<Range<C>> rangeItr = ImmutableRangeSet.this.ranges.reverse().iterator();
    
    protected C computeNext() {
      while (!this.elemItr.hasNext()) {
        if (this.rangeItr.hasNext()) {
          this.elemItr = ContiguousSet.<C>create(this.rangeItr.next(), this.this$1.domain).descendingIterator();
          continue;
        } 
        return endOfData();
      } 
      return this.elemItr.next();
    }
  }
  
  private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
    private final DiscreteDomain<C> domain;
    
    private final ImmutableList<Range<C>> ranges;
    
    AsSetSerializedForm(ImmutableList<Range<C>> param1ImmutableList, DiscreteDomain<C> param1DiscreteDomain) {
      this.ranges = param1ImmutableList;
      this.domain = param1DiscreteDomain;
    }
    
    Object readResolve() {
      return (new ImmutableRangeSet<C>(this.ranges)).asSet(this.domain);
    }
  }
  
  public static class Builder<C extends Comparable<?>> {
    private final RangeSet<C> rangeSet = TreeRangeSet.create();
    
    @CanIgnoreReturnValue
    public Builder<C> add(Range<C> param1Range) {
      if (!param1Range.isEmpty()) {
        if (!this.rangeSet.complement().encloses(param1Range)) {
          for (Range<C> range : this.rangeSet.asRanges()) {
            boolean bool;
            if (!range.isConnected(param1Range) || range.intersection(param1Range).isEmpty()) {
              bool = true;
            } else {
              bool = false;
            } 
            Preconditions.checkArgument(bool, "Ranges may not overlap, but received %s and %s", range, param1Range);
          } 
          throw new AssertionError("should have thrown an IAE above");
        } 
        this.rangeSet.add(param1Range);
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("range must not be empty, but was ");
      stringBuilder.append(param1Range);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    @CanIgnoreReturnValue
    public Builder<C> addAll(RangeSet<C> param1RangeSet) {
      Iterator<Range<C>> iterator = param1RangeSet.asRanges().iterator();
      while (iterator.hasNext())
        add(iterator.next()); 
      return this;
    }
    
    public ImmutableRangeSet<C> build() {
      return (ImmutableRangeSet)ImmutableRangeSet.copyOf(this.rangeSet);
    }
  }
  
  private final class ComplementRanges extends ImmutableList<Range<C>> {
    private final boolean positiveBoundedAbove = ((Range)Iterables.<Range>getLast(ImmutableRangeSet.this.ranges)).hasUpperBound();
    
    private final boolean positiveBoundedBelow = ((Range)ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
    
    private final int size;
    
    ComplementRanges() {
      int i = ImmutableRangeSet.this.ranges.size() - 1;
      int j = i;
      if (this.positiveBoundedBelow)
        j = i + 1; 
      i = j;
      if (this.positiveBoundedAbove)
        i = j + 1; 
      this.size = i;
    }
    
    public Range<C> get(int param1Int) {
      Cut<Comparable<?>> cut1;
      Cut<Comparable<?>> cut2;
      Preconditions.checkElementIndex(param1Int, this.size);
      if (this.positiveBoundedBelow) {
        if (param1Int == 0) {
          cut1 = Cut.belowAll();
        } else {
          cut1 = ((Range)ImmutableRangeSet.this.ranges.get(param1Int - 1)).upperBound;
        } 
      } else {
        cut1 = ((Range)ImmutableRangeSet.this.ranges.get(param1Int)).upperBound;
      } 
      if (this.positiveBoundedAbove && param1Int == this.size - 1) {
        cut2 = Cut.aboveAll();
      } else {
        cut2 = ((Range)ImmutableRangeSet.this.ranges.get(param1Int + (this.positiveBoundedBelow ^ true))).lowerBound;
      } 
      return (Range)Range.create(cut1, cut2);
    }
    
    boolean isPartialView() {
      return true;
    }
    
    public int size() {
      return this.size;
    }
  }
  
  private static final class SerializedForm<C extends Comparable> implements Serializable {
    private final ImmutableList<Range<C>> ranges;
    
    SerializedForm(ImmutableList<Range<C>> param1ImmutableList) {
      this.ranges = param1ImmutableList;
    }
    
    Object readResolve() {
      return this.ranges.isEmpty() ? ImmutableRangeSet.of() : (this.ranges.equals(ImmutableList.of(Range.all())) ? ImmutableRangeSet.all() : new ImmutableRangeSet<C>(this.ranges));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */