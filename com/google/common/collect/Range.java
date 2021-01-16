package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public final class Range<C extends Comparable> implements Predicate<C>, Serializable {
  private static final Range<Comparable> ALL;
  
  private static final Function<Range, Cut> LOWER_BOUND_FN = new Function<Range, Cut>() {
      public Cut apply(Range param1Range) {
        return param1Range.lowerBound;
      }
    };
  
  static final Ordering<Range<?>> RANGE_LEX_ORDERING;
  
  private static final Function<Range, Cut> UPPER_BOUND_FN = new Function<Range, Cut>() {
      public Cut apply(Range param1Range) {
        return param1Range.upperBound;
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  final Cut<C> lowerBound;
  
  final Cut<C> upperBound;
  
  static {
    RANGE_LEX_ORDERING = new RangeLexOrdering();
    ALL = new Range((Cut)Cut.belowAll(), (Cut)Cut.aboveAll());
  }
  
  private Range(Cut<C> paramCut1, Cut<C> paramCut2) {
    this.lowerBound = (Cut<C>)Preconditions.checkNotNull(paramCut1);
    this.upperBound = (Cut<C>)Preconditions.checkNotNull(paramCut2);
    if (paramCut1.compareTo(paramCut2) <= 0 && paramCut1 != Cut.aboveAll() && paramCut2 != Cut.belowAll())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid range: ");
    stringBuilder.append(toString(paramCut1, paramCut2));
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static <C extends Comparable<?>> Range<C> all() {
    return (Range)ALL;
  }
  
  public static <C extends Comparable<?>> Range<C> atLeast(C paramC) {
    return create((Cut)Cut.belowValue((Comparable)paramC), (Cut)Cut.aboveAll());
  }
  
  public static <C extends Comparable<?>> Range<C> atMost(C paramC) {
    return create((Cut)Cut.belowAll(), (Cut)Cut.aboveValue((Comparable)paramC));
  }
  
  private static <T> SortedSet<T> cast(Iterable<T> paramIterable) {
    return (SortedSet<T>)paramIterable;
  }
  
  public static <C extends Comparable<?>> Range<C> closed(C paramC1, C paramC2) {
    return create((Cut)Cut.belowValue((Comparable)paramC1), (Cut)Cut.aboveValue((Comparable)paramC2));
  }
  
  public static <C extends Comparable<?>> Range<C> closedOpen(C paramC1, C paramC2) {
    return create((Cut)Cut.belowValue((Comparable)paramC1), (Cut)Cut.belowValue((Comparable)paramC2));
  }
  
  static int compareOrThrow(Comparable<Comparable> paramComparable1, Comparable paramComparable2) {
    return paramComparable1.compareTo(paramComparable2);
  }
  
  static <C extends Comparable<?>> Range<C> create(Cut<C> paramCut1, Cut<C> paramCut2) {
    return (Range)new Range<Comparable>(paramCut1, paramCut2);
  }
  
  public static <C extends Comparable<?>> Range<C> downTo(C paramC, BoundType paramBoundType) {
    switch (paramBoundType) {
      default:
        throw new AssertionError();
      case CLOSED:
        return atLeast(paramC);
      case OPEN:
        break;
    } 
    return greaterThan(paramC);
  }
  
  public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> paramIterable) {
    Preconditions.checkNotNull(paramIterable);
    if (paramIterable instanceof ContiguousSet)
      return ((ContiguousSet)paramIterable).range(); 
    Iterator<C> iterator = paramIterable.iterator();
    Comparable comparable2 = (Comparable)Preconditions.checkNotNull(iterator.next());
    Comparable comparable1;
    for (comparable1 = comparable2; iterator.hasNext(); comparable1 = (Comparable)Ordering.<Comparable>natural().max(comparable1, comparable)) {
      Comparable comparable = (Comparable)Preconditions.checkNotNull(iterator.next());
      comparable2 = (Comparable)Ordering.<Comparable>natural().min(comparable2, comparable);
    } 
    return closed((C)comparable2, (C)comparable1);
  }
  
  public static <C extends Comparable<?>> Range<C> greaterThan(C paramC) {
    return create((Cut)Cut.aboveValue((Comparable)paramC), (Cut)Cut.aboveAll());
  }
  
  public static <C extends Comparable<?>> Range<C> lessThan(C paramC) {
    return create((Cut)Cut.belowAll(), (Cut)Cut.belowValue((Comparable)paramC));
  }
  
  static <C extends Comparable<?>> Function<Range<C>, Cut<C>> lowerBoundFn() {
    return (Function)LOWER_BOUND_FN;
  }
  
  public static <C extends Comparable<?>> Range<C> open(C paramC1, C paramC2) {
    return create((Cut)Cut.aboveValue((Comparable)paramC1), (Cut)Cut.belowValue((Comparable)paramC2));
  }
  
  public static <C extends Comparable<?>> Range<C> openClosed(C paramC1, C paramC2) {
    return create((Cut)Cut.aboveValue((Comparable)paramC1), (Cut)Cut.aboveValue((Comparable)paramC2));
  }
  
  public static <C extends Comparable<?>> Range<C> range(C paramC1, BoundType paramBoundType1, C paramC2, BoundType paramBoundType2) {
    Cut<Comparable> cut1;
    Cut<Comparable> cut2;
    Preconditions.checkNotNull(paramBoundType1);
    Preconditions.checkNotNull(paramBoundType2);
    if (paramBoundType1 == BoundType.OPEN) {
      cut1 = Cut.aboveValue((Comparable)paramC1);
    } else {
      cut1 = Cut.belowValue(cut1);
    } 
    if (paramBoundType2 == BoundType.OPEN) {
      cut2 = Cut.belowValue((Comparable)paramC2);
    } else {
      cut2 = Cut.aboveValue((Comparable)paramC2);
    } 
    return create((Cut)cut1, (Cut)cut2);
  }
  
  public static <C extends Comparable<?>> Range<C> singleton(C paramC) {
    return closed(paramC, paramC);
  }
  
  private static String toString(Cut<?> paramCut1, Cut<?> paramCut2) {
    StringBuilder stringBuilder = new StringBuilder(16);
    paramCut1.describeAsLowerBound(stringBuilder);
    stringBuilder.append("..");
    paramCut2.describeAsUpperBound(stringBuilder);
    return stringBuilder.toString();
  }
  
  public static <C extends Comparable<?>> Range<C> upTo(C paramC, BoundType paramBoundType) {
    switch (paramBoundType) {
      default:
        throw new AssertionError();
      case CLOSED:
        return atMost(paramC);
      case OPEN:
        break;
    } 
    return lessThan(paramC);
  }
  
  static <C extends Comparable<?>> Function<Range<C>, Cut<C>> upperBoundFn() {
    return (Function)UPPER_BOUND_FN;
  }
  
  @Deprecated
  public boolean apply(C paramC) {
    return contains(paramC);
  }
  
  public Range<C> canonical(DiscreteDomain<C> paramDiscreteDomain) {
    Range<Comparable<?>> range;
    Preconditions.checkNotNull(paramDiscreteDomain);
    Cut<C> cut2 = this.lowerBound.canonical(paramDiscreteDomain);
    Cut<C> cut1 = this.upperBound.canonical(paramDiscreteDomain);
    if (cut2 == this.lowerBound && cut1 == this.upperBound) {
      range = this;
    } else {
      range = create(cut2, (Cut<Comparable<?>>)range);
    } 
    return (Range)range;
  }
  
  public boolean contains(C paramC) {
    boolean bool;
    Preconditions.checkNotNull(paramC);
    if (this.lowerBound.isLessThan(paramC) && !this.upperBound.isLessThan(paramC)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsAll(Iterable<? extends C> paramIterable) {
    boolean bool = Iterables.isEmpty(paramIterable);
    boolean bool1 = true;
    if (bool)
      return true; 
    if (paramIterable instanceof SortedSet) {
      SortedSet<? extends C> sortedSet = cast(paramIterable);
      Comparator<? super C> comparator = sortedSet.comparator();
      if (Ordering.<Comparable>natural().equals(comparator) || comparator == null) {
        if (!contains(sortedSet.first()) || !contains(sortedSet.last()))
          bool1 = false; 
        return bool1;
      } 
    } 
    Iterator<? extends C> iterator = paramIterable.iterator();
    while (iterator.hasNext()) {
      if (!contains(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public boolean encloses(Range<C> paramRange) {
    boolean bool;
    if (this.lowerBound.compareTo(paramRange.lowerBound) <= 0 && this.upperBound.compareTo(paramRange.upperBound) >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof Range;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (this.lowerBound.equals(((Range)paramObject).lowerBound)) {
        bool = bool1;
        if (this.upperBound.equals(((Range)paramObject).upperBound))
          bool = true; 
      } 
      return bool;
    } 
    return false;
  }
  
  public boolean hasLowerBound() {
    boolean bool;
    if (this.lowerBound != Cut.belowAll()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasUpperBound() {
    boolean bool;
    if (this.upperBound != Cut.aboveAll()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return this.lowerBound.hashCode() * 31 + this.upperBound.hashCode();
  }
  
  public Range<C> intersection(Range<C> paramRange) {
    Cut<C> cut1;
    Cut<C> cut2;
    int i = this.lowerBound.compareTo(paramRange.lowerBound);
    int j = this.upperBound.compareTo(paramRange.upperBound);
    if (i >= 0 && j <= 0)
      return this; 
    if (i <= 0 && j >= 0)
      return paramRange; 
    if (i >= 0) {
      cut2 = this.lowerBound;
    } else {
      cut2 = paramRange.lowerBound;
    } 
    if (j <= 0) {
      cut1 = this.upperBound;
    } else {
      cut1 = ((Range)cut1).upperBound;
    } 
    return (Range)create(cut2, cut1);
  }
  
  public boolean isConnected(Range<C> paramRange) {
    boolean bool;
    if (this.lowerBound.compareTo(paramRange.upperBound) <= 0 && paramRange.lowerBound.compareTo(this.upperBound) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isEmpty() {
    return this.lowerBound.equals(this.upperBound);
  }
  
  public BoundType lowerBoundType() {
    return this.lowerBound.typeAsLowerBound();
  }
  
  public C lowerEndpoint() {
    return this.lowerBound.endpoint();
  }
  
  Object readResolve() {
    return equals(ALL) ? all() : this;
  }
  
  public Range<C> span(Range<C> paramRange) {
    Cut<C> cut1;
    Cut<C> cut2;
    int i = this.lowerBound.compareTo(paramRange.lowerBound);
    int j = this.upperBound.compareTo(paramRange.upperBound);
    if (i <= 0 && j >= 0)
      return this; 
    if (i >= 0 && j <= 0)
      return paramRange; 
    if (i <= 0) {
      cut2 = this.lowerBound;
    } else {
      cut2 = paramRange.lowerBound;
    } 
    if (j >= 0) {
      cut1 = this.upperBound;
    } else {
      cut1 = ((Range)cut1).upperBound;
    } 
    return (Range)create(cut2, cut1);
  }
  
  public String toString() {
    return toString(this.lowerBound, this.upperBound);
  }
  
  public BoundType upperBoundType() {
    return this.upperBound.typeAsUpperBound();
  }
  
  public C upperEndpoint() {
    return this.upperBound.endpoint();
  }
  
  private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private RangeLexOrdering() {}
    
    public int compare(Range<?> param1Range1, Range<?> param1Range2) {
      return ComparisonChain.start().compare(param1Range1.lowerBound, param1Range2.lowerBound).compare(param1Range1.upperBound, param1Range2.upperBound).result();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */