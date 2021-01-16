package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class SortedMultisets {
  private static <E> E getElementOrNull(@Nullable Multiset.Entry<E> paramEntry) {
    if (paramEntry == null) {
      paramEntry = null;
    } else {
      paramEntry = (Multiset.Entry<E>)paramEntry.getElement();
    } 
    return (E)paramEntry;
  }
  
  private static <E> E getElementOrThrow(Multiset.Entry<E> paramEntry) {
    if (paramEntry != null)
      return paramEntry.getElement(); 
    throw new NoSuchElementException();
  }
  
  static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {
    @Weak
    private final SortedMultiset<E> multiset;
    
    ElementSet(SortedMultiset<E> param1SortedMultiset) {
      this.multiset = param1SortedMultiset;
    }
    
    public Comparator<? super E> comparator() {
      return multiset().comparator();
    }
    
    public E first() {
      return SortedMultisets.getElementOrThrow(multiset().firstEntry());
    }
    
    public SortedSet<E> headSet(E param1E) {
      return multiset().headMultiset(param1E, BoundType.OPEN).elementSet();
    }
    
    public E last() {
      return SortedMultisets.getElementOrThrow(multiset().lastEntry());
    }
    
    final SortedMultiset<E> multiset() {
      return this.multiset;
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return multiset().subMultiset(param1E1, BoundType.CLOSED, param1E2, BoundType.OPEN).elementSet();
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return multiset().tailMultiset(param1E, BoundType.CLOSED).elementSet();
    }
  }
  
  @GwtIncompatible
  static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
    NavigableElementSet(SortedMultiset<E> param1SortedMultiset) {
      super(param1SortedMultiset);
    }
    
    public E ceiling(E param1E) {
      return SortedMultisets.getElementOrNull(multiset().tailMultiset(param1E, BoundType.CLOSED).firstEntry());
    }
    
    public Iterator<E> descendingIterator() {
      return descendingSet().iterator();
    }
    
    public NavigableSet<E> descendingSet() {
      return new NavigableElementSet(multiset().descendingMultiset());
    }
    
    public E floor(E param1E) {
      return SortedMultisets.getElementOrNull(multiset().headMultiset(param1E, BoundType.CLOSED).lastEntry());
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      return new NavigableElementSet(multiset().headMultiset(param1E, BoundType.forBoolean(param1Boolean)));
    }
    
    public E higher(E param1E) {
      return SortedMultisets.getElementOrNull(multiset().tailMultiset(param1E, BoundType.OPEN).firstEntry());
    }
    
    public E lower(E param1E) {
      return SortedMultisets.getElementOrNull(multiset().headMultiset(param1E, BoundType.OPEN).lastEntry());
    }
    
    public E pollFirst() {
      return SortedMultisets.getElementOrNull(multiset().pollFirstEntry());
    }
    
    public E pollLast() {
      return SortedMultisets.getElementOrNull(multiset().pollLastEntry());
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      return new NavigableElementSet(multiset().subMultiset(param1E1, BoundType.forBoolean(param1Boolean1), param1E2, BoundType.forBoolean(param1Boolean2)));
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      return new NavigableElementSet(multiset().tailMultiset(param1E, BoundType.forBoolean(param1Boolean)));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SortedMultisets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */