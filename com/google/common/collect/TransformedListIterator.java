package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
  TransformedListIterator(ListIterator<? extends F> paramListIterator) {
    super(paramListIterator);
  }
  
  private ListIterator<? extends F> backingIterator() {
    return Iterators.cast(this.backingIterator);
  }
  
  public void add(T paramT) {
    throw new UnsupportedOperationException();
  }
  
  public final boolean hasPrevious() {
    return backingIterator().hasPrevious();
  }
  
  public final int nextIndex() {
    return backingIterator().nextIndex();
  }
  
  public final T previous() {
    return transform(backingIterator().previous());
  }
  
  public final int previousIndex() {
    return backingIterator().previousIndex();
  }
  
  public void set(T paramT) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\TransformedListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */