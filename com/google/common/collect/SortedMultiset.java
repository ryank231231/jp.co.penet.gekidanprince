package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible(emulated = true)
public interface SortedMultiset<E> extends SortedMultisetBridge<E>, SortedIterable<E> {
  Comparator<? super E> comparator();
  
  SortedMultiset<E> descendingMultiset();
  
  NavigableSet<E> elementSet();
  
  Set<Multiset.Entry<E>> entrySet();
  
  Multiset.Entry<E> firstEntry();
  
  SortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType);
  
  Iterator<E> iterator();
  
  Multiset.Entry<E> lastEntry();
  
  Multiset.Entry<E> pollFirstEntry();
  
  Multiset.Entry<E> pollLastEntry();
  
  SortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2);
  
  SortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */