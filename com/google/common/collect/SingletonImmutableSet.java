package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Iterator;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
  @LazyInit
  private transient int cachedHashCode;
  
  final transient E element;
  
  SingletonImmutableSet(E paramE) {
    this.element = (E)Preconditions.checkNotNull(paramE);
  }
  
  SingletonImmutableSet(E paramE, int paramInt) {
    this.element = paramE;
    this.cachedHashCode = paramInt;
  }
  
  public boolean contains(Object paramObject) {
    return this.element.equals(paramObject);
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt) {
    paramArrayOfObject[paramInt] = this.element;
    return paramInt + 1;
  }
  
  ImmutableList<E> createAsList() {
    return ImmutableList.of(this.element);
  }
  
  public final int hashCode() {
    int i = this.cachedHashCode;
    int j = i;
    if (i == 0) {
      j = this.element.hashCode();
      this.cachedHashCode = j;
    } 
    return j;
  }
  
  boolean isHashCodeFast() {
    boolean bool;
    if (this.cachedHashCode != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
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
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[');
    stringBuilder.append(this.element.toString());
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SingletonImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */