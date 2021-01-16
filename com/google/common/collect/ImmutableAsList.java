package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

@GwtCompatible(emulated = true, serializable = true)
abstract class ImmutableAsList<E> extends ImmutableList<E> {
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws InvalidObjectException {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public boolean contains(Object paramObject) {
    return delegateCollection().contains(paramObject);
  }
  
  abstract ImmutableCollection<E> delegateCollection();
  
  public boolean isEmpty() {
    return delegateCollection().isEmpty();
  }
  
  boolean isPartialView() {
    return delegateCollection().isPartialView();
  }
  
  public int size() {
    return delegateCollection().size();
  }
  
  @GwtIncompatible
  Object writeReplace() {
    return new SerializedForm(delegateCollection());
  }
  
  @GwtIncompatible
  static class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final ImmutableCollection<?> collection;
    
    SerializedForm(ImmutableCollection<?> param1ImmutableCollection) {
      this.collection = param1ImmutableCollection;
    }
    
    Object readResolve() {
      return this.collection.asList();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */