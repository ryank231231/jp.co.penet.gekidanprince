package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible
class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
  private final ImmutableSortedSet<E> forward;
  
  DescendingImmutableSortedSet(ImmutableSortedSet<E> paramImmutableSortedSet) {
    super(Ordering.from(paramImmutableSortedSet.comparator()).reverse());
    this.forward = paramImmutableSortedSet;
  }
  
  public E ceiling(E paramE) {
    return this.forward.floor(paramE);
  }
  
  public boolean contains(@Nullable Object paramObject) {
    return this.forward.contains(paramObject);
  }
  
  @GwtIncompatible("NavigableSet")
  ImmutableSortedSet<E> createDescendingSet() {
    throw new AssertionError("should never be called");
  }
  
  @GwtIncompatible("NavigableSet")
  public UnmodifiableIterator<E> descendingIterator() {
    return this.forward.iterator();
  }
  
  @GwtIncompatible("NavigableSet")
  public ImmutableSortedSet<E> descendingSet() {
    return this.forward;
  }
  
  public E floor(E paramE) {
    return this.forward.ceiling(paramE);
  }
  
  ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean) {
    return this.forward.tailSet(paramE, paramBoolean).descendingSet();
  }
  
  public E higher(E paramE) {
    return this.forward.lower(paramE);
  }
  
  int indexOf(@Nullable Object paramObject) {
    int i = this.forward.indexOf(paramObject);
    return (i == -1) ? i : (size() - 1 - i);
  }
  
  boolean isPartialView() {
    return this.forward.isPartialView();
  }
  
  public UnmodifiableIterator<E> iterator() {
    return this.forward.descendingIterator();
  }
  
  public E lower(E paramE) {
    return this.forward.higher(paramE);
  }
  
  public int size() {
    return this.forward.size();
  }
  
  ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
    return this.forward.subSet(paramE2, paramBoolean2, paramE1, paramBoolean1).descendingSet();
  }
  
  ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean) {
    return this.forward.headSet(paramE, paramBoolean).descendingSet();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\DescendingImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */