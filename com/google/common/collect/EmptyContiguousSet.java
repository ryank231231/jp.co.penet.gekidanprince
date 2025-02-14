package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class EmptyContiguousSet<C extends Comparable> extends ContiguousSet<C> {
  EmptyContiguousSet(DiscreteDomain<C> paramDiscreteDomain) {
    super(paramDiscreteDomain);
  }
  
  public ImmutableList<C> asList() {
    return ImmutableList.of();
  }
  
  public boolean contains(Object paramObject) {
    return false;
  }
  
  @GwtIncompatible
  ImmutableSortedSet<C> createDescendingSet() {
    return ImmutableSortedSet.emptySet(Ordering.<Comparable>natural().reverse());
  }
  
  @GwtIncompatible
  public UnmodifiableIterator<C> descendingIterator() {
    return Iterators.emptyIterator();
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return (paramObject instanceof Set) ? ((Set)paramObject).isEmpty() : false;
  }
  
  public C first() {
    throw new NoSuchElementException();
  }
  
  public int hashCode() {
    return 0;
  }
  
  ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean) {
    return this;
  }
  
  @GwtIncompatible
  int indexOf(Object paramObject) {
    return -1;
  }
  
  public ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet) {
    return this;
  }
  
  public boolean isEmpty() {
    return true;
  }
  
  @GwtIncompatible
  boolean isHashCodeFast() {
    return true;
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public UnmodifiableIterator<C> iterator() {
    return Iterators.emptyIterator();
  }
  
  public C last() {
    throw new NoSuchElementException();
  }
  
  public Range<C> range() {
    throw new NoSuchElementException();
  }
  
  public Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2) {
    throw new NoSuchElementException();
  }
  
  public int size() {
    return 0;
  }
  
  ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2) {
    return this;
  }
  
  ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean) {
    return this;
  }
  
  public String toString() {
    return "[]";
  }
  
  @GwtIncompatible
  Object writeReplace() {
    return new SerializedForm<Comparable>(this.domain);
  }
  
  @GwtIncompatible
  private static final class SerializedForm<C extends Comparable> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final DiscreteDomain<C> domain;
    
    private SerializedForm(DiscreteDomain<C> param1DiscreteDomain) {
      this.domain = param1DiscreteDomain;
    }
    
    private Object readResolve() {
      return new EmptyContiguousSet<C>(this.domain);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\EmptyContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */