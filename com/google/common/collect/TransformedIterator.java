package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;

@GwtCompatible
abstract class TransformedIterator<F, T> implements Iterator<T> {
  final Iterator<? extends F> backingIterator;
  
  TransformedIterator(Iterator<? extends F> paramIterator) {
    this.backingIterator = (Iterator<? extends F>)Preconditions.checkNotNull(paramIterator);
  }
  
  public final boolean hasNext() {
    return this.backingIterator.hasNext();
  }
  
  public final T next() {
    return transform(this.backingIterator.next());
  }
  
  public final void remove() {
    this.backingIterator.remove();
  }
  
  abstract T transform(F paramF);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\TransformedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */