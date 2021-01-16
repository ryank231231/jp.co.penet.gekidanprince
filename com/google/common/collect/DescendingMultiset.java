package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible(emulated = true)
abstract class DescendingMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
  private transient Comparator<? super E> comparator;
  
  private transient NavigableSet<E> elementSet;
  
  private transient Set<Multiset.Entry<E>> entrySet;
  
  public Comparator<? super E> comparator() {
    Comparator<? super E> comparator = this.comparator;
    if (comparator == null) {
      comparator = Ordering.from(forwardMultiset().comparator()).reverse();
      this.comparator = comparator;
      return comparator;
    } 
    return comparator;
  }
  
  Set<Multiset.Entry<E>> createEntrySet() {
    class EntrySetImpl extends Multisets.EntrySet<E> {
      public Iterator<Multiset.Entry<E>> iterator() {
        return DescendingMultiset.this.entryIterator();
      }
      
      Multiset<E> multiset() {
        return DescendingMultiset.this;
      }
      
      public int size() {
        return DescendingMultiset.this.forwardMultiset().entrySet().size();
      }
    };
    return new EntrySetImpl();
  }
  
  protected Multiset<E> delegate() {
    return forwardMultiset();
  }
  
  public SortedMultiset<E> descendingMultiset() {
    return forwardMultiset();
  }
  
  public NavigableSet<E> elementSet() {
    NavigableSet<E> navigableSet = this.elementSet;
    if (navigableSet == null) {
      navigableSet = new SortedMultisets.NavigableElementSet<E>(this);
      this.elementSet = navigableSet;
      return navigableSet;
    } 
    return navigableSet;
  }
  
  abstract Iterator<Multiset.Entry<E>> entryIterator();
  
  public Set<Multiset.Entry<E>> entrySet() {
    Set<Multiset.Entry<E>> set1 = this.entrySet;
    Set<Multiset.Entry<E>> set2 = set1;
    if (set1 == null) {
      set2 = createEntrySet();
      this.entrySet = set2;
    } 
    return set2;
  }
  
  public Multiset.Entry<E> firstEntry() {
    return forwardMultiset().lastEntry();
  }
  
  abstract SortedMultiset<E> forwardMultiset();
  
  public SortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType) {
    return forwardMultiset().tailMultiset(paramE, paramBoundType).descendingMultiset();
  }
  
  public Iterator<E> iterator() {
    return Multisets.iteratorImpl(this);
  }
  
  public Multiset.Entry<E> lastEntry() {
    return forwardMultiset().firstEntry();
  }
  
  public Multiset.Entry<E> pollFirstEntry() {
    return forwardMultiset().pollLastEntry();
  }
  
  public Multiset.Entry<E> pollLastEntry() {
    return forwardMultiset().pollFirstEntry();
  }
  
  public SortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2) {
    return forwardMultiset().subMultiset(paramE2, paramBoundType2, paramE1, paramBoundType1).descendingMultiset();
  }
  
  public SortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType) {
    return forwardMultiset().headMultiset(paramE, paramBoundType).descendingMultiset();
  }
  
  public Object[] toArray() {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    return (T[])standardToArray((Object[])paramArrayOfT);
  }
  
  public String toString() {
    return entrySet().toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\DescendingMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */