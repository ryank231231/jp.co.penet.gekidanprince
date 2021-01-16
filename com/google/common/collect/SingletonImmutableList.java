package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableList<E> extends ImmutableList<E> {
  final transient E element;
  
  SingletonImmutableList(E paramE) {
    this.element = (E)Preconditions.checkNotNull(paramE);
  }
  
  public E get(int paramInt) {
    Preconditions.checkElementIndex(paramInt, 1);
    return this.element;
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public UnmodifiableIterator<E> iterator() {
    return Iterators.singletonIterator(this.element);
  }
  
  public int size() {
    return 1;
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2) {
    ImmutableList<?> immutableList;
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, 1);
    if (paramInt1 == paramInt2) {
      immutableList = ImmutableList.of();
    } else {
      immutableList = this;
    } 
    return (ImmutableList)immutableList;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[');
    stringBuilder.append(this.element.toString());
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SingletonImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */