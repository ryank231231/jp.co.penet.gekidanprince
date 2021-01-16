package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
final class SortedIterables {
  public static <E> Comparator<? super E> comparator(SortedSet<E> paramSortedSet) {
    Comparator<? super E> comparator2 = paramSortedSet.comparator();
    Comparator<? super E> comparator1 = comparator2;
    if (comparator2 == null)
      comparator1 = Ordering.natural(); 
    return comparator1;
  }
  
  public static boolean hasSameComparator(Comparator<?> paramComparator, Iterable<?> paramIterable) {
    Comparator<?> comparator;
    Preconditions.checkNotNull(paramComparator);
    Preconditions.checkNotNull(paramIterable);
    if (paramIterable instanceof SortedSet) {
      comparator = comparator((SortedSet)paramIterable);
    } else {
      if (comparator instanceof SortedIterable) {
        comparator = ((SortedIterable)comparator).comparator();
        return paramComparator.equals(comparator);
      } 
      return false;
    } 
    return paramComparator.equals(comparator);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SortedIterables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */