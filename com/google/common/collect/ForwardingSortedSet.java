package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
  private int unsafeCompare(Object paramObject1, Object paramObject2) {
    int i;
    Comparator<? super E> comparator = comparator();
    if (comparator == null) {
      i = ((Comparable<Object>)paramObject1).compareTo(paramObject2);
    } else {
      i = comparator.compare((E)paramObject1, (E)paramObject2);
    } 
    return i;
  }
  
  public Comparator<? super E> comparator() {
    return delegate().comparator();
  }
  
  protected abstract SortedSet<E> delegate();
  
  public E first() {
    return delegate().first();
  }
  
  public SortedSet<E> headSet(E paramE) {
    return delegate().headSet(paramE);
  }
  
  public E last() {
    return delegate().last();
  }
  
  @Beta
  protected boolean standardContains(@Nullable Object paramObject) {
    boolean bool = false;
    try {
      int i = unsafeCompare(super.tailSet((E)paramObject).first(), paramObject);
      if (i == 0)
        bool = true; 
      return bool;
    } catch (ClassCastException classCastException) {
      return false;
    } catch (NoSuchElementException noSuchElementException) {
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } 
  }
  
  @Beta
  protected boolean standardRemove(@Nullable Object paramObject) {
    try {
      Iterator iterator = super.tailSet((E)paramObject).iterator();
      if (iterator.hasNext() && unsafeCompare(iterator.next(), paramObject) == 0) {
        iterator.remove();
        return true;
      } 
      return false;
    } catch (ClassCastException classCastException) {
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } 
  }
  
  @Beta
  protected SortedSet<E> standardSubSet(E paramE1, E paramE2) {
    return tailSet(paramE1).headSet(paramE2);
  }
  
  public SortedSet<E> subSet(E paramE1, E paramE2) {
    return delegate().subSet(paramE1, paramE2);
  }
  
  public SortedSet<E> tailSet(E paramE) {
    return delegate().tailSet(paramE);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */