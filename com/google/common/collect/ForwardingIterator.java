package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
  protected abstract Iterator<T> delegate();
  
  public boolean hasNext() {
    return delegate().hasNext();
  }
  
  @CanIgnoreReturnValue
  public T next() {
    return delegate().next();
  }
  
  public void remove() {
    delegate().remove();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */