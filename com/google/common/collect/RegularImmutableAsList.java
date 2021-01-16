package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.util.ListIterator;

@GwtCompatible(emulated = true)
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
  @Weak
  private final ImmutableCollection<E> delegate;
  
  private final ImmutableList<? extends E> delegateList;
  
  RegularImmutableAsList(ImmutableCollection<E> paramImmutableCollection, ImmutableList<? extends E> paramImmutableList) {
    this.delegate = paramImmutableCollection;
    this.delegateList = paramImmutableList;
  }
  
  RegularImmutableAsList(ImmutableCollection<E> paramImmutableCollection, Object[] paramArrayOfObject) {
    this(paramImmutableCollection, ImmutableList.asImmutableList(paramArrayOfObject));
  }
  
  @GwtIncompatible
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt) {
    return this.delegateList.copyIntoArray(paramArrayOfObject, paramInt);
  }
  
  ImmutableCollection<E> delegateCollection() {
    return this.delegate;
  }
  
  ImmutableList<? extends E> delegateList() {
    return this.delegateList;
  }
  
  public E get(int paramInt) {
    return this.delegateList.get(paramInt);
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt) {
    return (UnmodifiableListIterator)this.delegateList.listIterator(paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */