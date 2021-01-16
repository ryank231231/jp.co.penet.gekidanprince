package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableList<E> extends ImmutableList<E> {
  static final ImmutableList<Object> EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);
  
  private final transient Object[] array;
  
  RegularImmutableList(Object[] paramArrayOfObject) {
    this.array = paramArrayOfObject;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt) {
    Object[] arrayOfObject = this.array;
    System.arraycopy(arrayOfObject, 0, paramArrayOfObject, paramInt, arrayOfObject.length);
    return paramInt + this.array.length;
  }
  
  public E get(int paramInt) {
    return (E)this.array[paramInt];
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt) {
    Object[] arrayOfObject = this.array;
    return Iterators.forArray((E[])arrayOfObject, 0, arrayOfObject.length, paramInt);
  }
  
  public int size() {
    return this.array.length;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */