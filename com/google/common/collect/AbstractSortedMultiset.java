package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {
  @GwtTransient
  final Comparator<? super E> comparator;
  
  private transient SortedMultiset<E> descendingMultiset;
  
  AbstractSortedMultiset() {
    this(Ordering.natural());
  }
  
  AbstractSortedMultiset(Comparator<? super E> paramComparator) {
    this.comparator = (Comparator<? super E>)Preconditions.checkNotNull(paramComparator);
  }
  
  public Comparator<? super E> comparator() {
    return this.comparator;
  }
  
  SortedMultiset<E> createDescendingMultiset() {
    class DescendingMultisetImpl extends DescendingMultiset<E> {
      Iterator<Multiset.Entry<E>> entryIterator() {
        return AbstractSortedMultiset.this.descendingEntryIterator();
      }
      
      SortedMultiset<E> forwardMultiset() {
        return AbstractSortedMultiset.this;
      }
      
      public Iterator<E> iterator() {
        return AbstractSortedMultiset.this.descendingIterator();
      }
    };
    return new DescendingMultisetImpl();
  }
  
  NavigableSet<E> createElementSet() {
    return new SortedMultisets.NavigableElementSet<E>(this);
  }
  
  abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();
  
  Iterator<E> descendingIterator() {
    return Multisets.iteratorImpl(descendingMultiset());
  }
  
  public SortedMultiset<E> descendingMultiset() {
    SortedMultiset<E> sortedMultiset1 = this.descendingMultiset;
    SortedMultiset<E> sortedMultiset2 = sortedMultiset1;
    if (sortedMultiset1 == null) {
      sortedMultiset2 = createDescendingMultiset();
      this.descendingMultiset = sortedMultiset2;
    } 
    return sortedMultiset2;
  }
  
  public NavigableSet<E> elementSet() {
    return (NavigableSet<E>)super.elementSet();
  }
  
  public Multiset.Entry<E> firstEntry() {
    Iterator<Multiset.Entry<E>> iterator = entryIterator();
    if (iterator.hasNext()) {
      Multiset.Entry entry = iterator.next();
    } else {
      iterator = null;
    } 
    return (Multiset.Entry)iterator;
  }
  
  public Multiset.Entry<E> lastEntry() {
    Iterator<Multiset.Entry<E>> iterator = descendingEntryIterator();
    if (iterator.hasNext()) {
      Multiset.Entry entry = iterator.next();
    } else {
      iterator = null;
    } 
    return (Multiset.Entry)iterator;
  }
  
  public Multiset.Entry<E> pollFirstEntry() {
    Iterator<Multiset.Entry<E>> iterator = entryIterator();
    if (iterator.hasNext()) {
      Multiset.Entry<?> entry = iterator.next();
      entry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
      iterator.remove();
      return (Multiset.Entry)entry;
    } 
    return null;
  }
  
  public Multiset.Entry<E> pollLastEntry() {
    Iterator<Multiset.Entry<E>> iterator = descendingEntryIterator();
    if (iterator.hasNext()) {
      Multiset.Entry<?> entry = iterator.next();
      entry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
      iterator.remove();
      return (Multiset.Entry)entry;
    } 
    return null;
  }
  
  public SortedMultiset<E> subMultiset(@Nullable E paramE1, BoundType paramBoundType1, @Nullable E paramE2, BoundType paramBoundType2) {
    Preconditions.checkNotNull(paramBoundType1);
    Preconditions.checkNotNull(paramBoundType2);
    return tailMultiset(paramE1, paramBoundType1).headMultiset(paramE2, paramBoundType2);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */