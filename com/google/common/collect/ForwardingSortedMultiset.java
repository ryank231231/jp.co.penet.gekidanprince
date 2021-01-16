package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@Beta
@GwtCompatible(emulated = true)
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
  public Comparator<? super E> comparator() {
    return delegate().comparator();
  }
  
  protected abstract SortedMultiset<E> delegate();
  
  public SortedMultiset<E> descendingMultiset() {
    return delegate().descendingMultiset();
  }
  
  public NavigableSet<E> elementSet() {
    return (NavigableSet<E>)super.elementSet();
  }
  
  public Multiset.Entry<E> firstEntry() {
    return delegate().firstEntry();
  }
  
  public SortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType) {
    return delegate().headMultiset(paramE, paramBoundType);
  }
  
  public Multiset.Entry<E> lastEntry() {
    return delegate().lastEntry();
  }
  
  public Multiset.Entry<E> pollFirstEntry() {
    return delegate().pollFirstEntry();
  }
  
  public Multiset.Entry<E> pollLastEntry() {
    return delegate().pollLastEntry();
  }
  
  protected Multiset.Entry<E> standardFirstEntry() {
    Iterator<Multiset.Entry<E>> iterator = entrySet().iterator();
    if (!iterator.hasNext())
      return null; 
    Multiset.Entry<E> entry = iterator.next();
    return Multisets.immutableEntry(entry.getElement(), entry.getCount());
  }
  
  protected Multiset.Entry<E> standardLastEntry() {
    Iterator<Multiset.Entry> iterator = descendingMultiset().entrySet().iterator();
    if (!iterator.hasNext())
      return null; 
    Multiset.Entry<E> entry = iterator.next();
    return Multisets.immutableEntry(entry.getElement(), entry.getCount());
  }
  
  protected Multiset.Entry<E> standardPollFirstEntry() {
    Iterator<Multiset.Entry<E>> iterator = entrySet().iterator();
    if (!iterator.hasNext())
      return null; 
    Multiset.Entry<?> entry = iterator.next();
    entry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
    iterator.remove();
    return (Multiset.Entry)entry;
  }
  
  protected Multiset.Entry<E> standardPollLastEntry() {
    Iterator<Multiset.Entry> iterator = descendingMultiset().entrySet().iterator();
    if (!iterator.hasNext())
      return null; 
    Multiset.Entry<?> entry = iterator.next();
    entry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
    iterator.remove();
    return (Multiset.Entry)entry;
  }
  
  protected SortedMultiset<E> standardSubMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2) {
    return tailMultiset(paramE1, paramBoundType1).headMultiset(paramE2, paramBoundType2);
  }
  
  public SortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2) {
    return delegate().subMultiset(paramE1, paramBoundType1, paramE2, paramBoundType2);
  }
  
  public SortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType) {
    return delegate().tailMultiset(paramE, paramBoundType);
  }
  
  protected abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
    SortedMultiset<E> forwardMultiset() {
      return ForwardingSortedMultiset.this;
    }
  }
  
  protected class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
    public StandardElementSet() {
      super(ForwardingSortedMultiset.this);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */