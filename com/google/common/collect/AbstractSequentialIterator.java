package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
  private T nextOrNull;
  
  protected AbstractSequentialIterator(@Nullable T paramT) {
    this.nextOrNull = paramT;
  }
  
  protected abstract T computeNext(T paramT);
  
  public final boolean hasNext() {
    boolean bool;
    if (this.nextOrNull != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final T next() {
    if (hasNext())
      try {
        return this.nextOrNull;
      } finally {
        this.nextOrNull = computeNext(this.nextOrNull);
      }  
    throw new NoSuchElementException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractSequentialIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */