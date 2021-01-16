package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.ListIterator;

@GwtCompatible
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
  public void add(E paramE) {
    delegate().add(paramE);
  }
  
  protected abstract ListIterator<E> delegate();
  
  public boolean hasPrevious() {
    return delegate().hasPrevious();
  }
  
  public int nextIndex() {
    return delegate().nextIndex();
  }
  
  @CanIgnoreReturnValue
  public E previous() {
    return delegate().previous();
  }
  
  public int previousIndex() {
    return delegate().previousIndex();
  }
  
  public void set(E paramE) {
    delegate().set(paramE);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */