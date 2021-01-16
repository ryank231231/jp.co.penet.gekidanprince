package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableSet<E> extends ImmutableSet.Indexed<E> {
  static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet(ObjectArrays.EMPTY_ARRAY, 0, null, 0);
  
  private final transient Object[] elements;
  
  private final transient int hashCode;
  
  private final transient int mask;
  
  @VisibleForTesting
  final transient Object[] table;
  
  RegularImmutableSet(Object[] paramArrayOfObject1, int paramInt1, Object[] paramArrayOfObject2, int paramInt2) {
    this.elements = paramArrayOfObject1;
    this.table = paramArrayOfObject2;
    this.mask = paramInt2;
    this.hashCode = paramInt1;
  }
  
  public boolean contains(@Nullable Object paramObject) {
    Object[] arrayOfObject = this.table;
    if (paramObject == null || arrayOfObject == null)
      return false; 
    for (int i = Hashing.smearedHash(paramObject);; i++) {
      i &= this.mask;
      Object object = arrayOfObject[i];
      if (object == null)
        return false; 
      if (object.equals(paramObject))
        return true; 
    } 
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt) {
    Object[] arrayOfObject = this.elements;
    System.arraycopy(arrayOfObject, 0, paramArrayOfObject, paramInt, arrayOfObject.length);
    return paramInt + this.elements.length;
  }
  
  ImmutableList<E> createAsList() {
    ImmutableList<?> immutableList;
    if (this.table == null) {
      immutableList = ImmutableList.of();
    } else {
      immutableList = new RegularImmutableAsList(this, this.elements);
    } 
    return (ImmutableList)immutableList;
  }
  
  E get(int paramInt) {
    return (E)this.elements[paramInt];
  }
  
  public int hashCode() {
    return this.hashCode;
  }
  
  boolean isHashCodeFast() {
    return true;
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public int size() {
    return this.elements.length;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */