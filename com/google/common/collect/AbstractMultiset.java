package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
  private transient Set<E> elementSet;
  
  private transient Set<Multiset.Entry<E>> entrySet;
  
  @CanIgnoreReturnValue
  public int add(@Nullable E paramE, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @CanIgnoreReturnValue
  public boolean add(@Nullable E paramE) {
    add(paramE, 1);
    return true;
  }
  
  @CanIgnoreReturnValue
  public boolean addAll(Collection<? extends E> paramCollection) {
    return Multisets.addAllImpl(this, paramCollection);
  }
  
  public void clear() {
    Iterators.clear(entryIterator());
  }
  
  public boolean contains(@Nullable Object paramObject) {
    boolean bool;
    if (count(paramObject) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int count(@Nullable Object paramObject) {
    for (Multiset.Entry<E> entry : entrySet()) {
      if (Objects.equal(entry.getElement(), paramObject))
        return entry.getCount(); 
    } 
    return 0;
  }
  
  Set<E> createElementSet() {
    return new ElementSet();
  }
  
  Set<Multiset.Entry<E>> createEntrySet() {
    return new EntrySet();
  }
  
  abstract int distinctElements();
  
  public Set<E> elementSet() {
    Set<E> set1 = this.elementSet;
    Set<E> set2 = set1;
    if (set1 == null) {
      set2 = createElementSet();
      this.elementSet = set2;
    } 
    return set2;
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
  
  public boolean equals(@Nullable Object paramObject) {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  public int hashCode() {
    return entrySet().hashCode();
  }
  
  public boolean isEmpty() {
    return entrySet().isEmpty();
  }
  
  public Iterator<E> iterator() {
    return Multisets.iteratorImpl(this);
  }
  
  @CanIgnoreReturnValue
  public int remove(@Nullable Object paramObject, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @CanIgnoreReturnValue
  public boolean remove(@Nullable Object paramObject) {
    boolean bool = true;
    if (remove(paramObject, 1) <= 0)
      bool = false; 
    return bool;
  }
  
  @CanIgnoreReturnValue
  public boolean removeAll(Collection<?> paramCollection) {
    return Multisets.removeAllImpl(this, paramCollection);
  }
  
  @CanIgnoreReturnValue
  public boolean retainAll(Collection<?> paramCollection) {
    return Multisets.retainAllImpl(this, paramCollection);
  }
  
  @CanIgnoreReturnValue
  public int setCount(@Nullable E paramE, int paramInt) {
    return Multisets.setCountImpl(this, paramE, paramInt);
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(@Nullable E paramE, int paramInt1, int paramInt2) {
    return Multisets.setCountImpl(this, paramE, paramInt1, paramInt2);
  }
  
  public int size() {
    return Multisets.sizeImpl(this);
  }
  
  public String toString() {
    return entrySet().toString();
  }
  
  class ElementSet extends Multisets.ElementSet<E> {
    Multiset<E> multiset() {
      return AbstractMultiset.this;
    }
  }
  
  class EntrySet extends Multisets.EntrySet<E> {
    public Iterator<Multiset.Entry<E>> iterator() {
      return AbstractMultiset.this.entryIterator();
    }
    
    Multiset<E> multiset() {
      return AbstractMultiset.this;
    }
    
    public int size() {
      return AbstractMultiset.this.distinctElements();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */