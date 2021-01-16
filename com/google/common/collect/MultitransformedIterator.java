package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class MultitransformedIterator<F, T> implements Iterator<T> {
  final Iterator<? extends F> backingIterator;
  
  private Iterator<? extends T> current = Iterators.emptyIterator();
  
  private Iterator<? extends T> removeFrom;
  
  MultitransformedIterator(Iterator<? extends F> paramIterator) {
    this.backingIterator = (Iterator<? extends F>)Preconditions.checkNotNull(paramIterator);
  }
  
  public boolean hasNext() {
    Preconditions.checkNotNull(this.current);
    if (this.current.hasNext())
      return true; 
    while (this.backingIterator.hasNext()) {
      Iterator<? extends T> iterator = transform(this.backingIterator.next());
      this.current = iterator;
      Preconditions.checkNotNull(iterator);
      if (this.current.hasNext())
        return true; 
    } 
    return false;
  }
  
  public T next() {
    if (hasNext()) {
      Iterator<? extends T> iterator = this.current;
      this.removeFrom = iterator;
      return iterator.next();
    } 
    throw new NoSuchElementException();
  }
  
  public void remove() {
    boolean bool;
    if (this.removeFrom != null) {
      bool = true;
    } else {
      bool = false;
    } 
    CollectPreconditions.checkRemove(bool);
    this.removeFrom.remove();
    this.removeFrom = null;
  }
  
  abstract Iterator<? extends T> transform(F paramF);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MultitransformedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */