package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
  private int position;
  
  private final int size;
  
  protected AbstractIndexedListIterator(int paramInt) {
    this(paramInt, 0);
  }
  
  protected AbstractIndexedListIterator(int paramInt1, int paramInt2) {
    Preconditions.checkPositionIndex(paramInt2, paramInt1);
    this.size = paramInt1;
    this.position = paramInt2;
  }
  
  protected abstract E get(int paramInt);
  
  public final boolean hasNext() {
    boolean bool;
    if (this.position < this.size) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean hasPrevious() {
    boolean bool;
    if (this.position > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final E next() {
    if (hasNext()) {
      int i = this.position;
      this.position = i + 1;
      return get(i);
    } 
    throw new NoSuchElementException();
  }
  
  public final int nextIndex() {
    return this.position;
  }
  
  public final E previous() {
    if (hasPrevious()) {
      int i = this.position - 1;
      this.position = i;
      return get(i);
    } 
    throw new NoSuchElementException();
  }
  
  public final int previousIndex() {
    return this.position - 1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractIndexedListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */