package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract class UnmodifiableIterator<E> implements Iterator<E> {
  @Deprecated
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\UnmodifiableIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */