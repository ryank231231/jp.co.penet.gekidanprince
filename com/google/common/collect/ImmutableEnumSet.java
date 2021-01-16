package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
  private final transient EnumSet<E> delegate;
  
  @LazyInit
  private transient int hashCode;
  
  private ImmutableEnumSet(EnumSet<E> paramEnumSet) {
    this.delegate = paramEnumSet;
  }
  
  static ImmutableSet asImmutable(EnumSet<Enum> paramEnumSet) {
    switch (paramEnumSet.size()) {
      default:
        return new ImmutableEnumSet<Enum>(paramEnumSet);
      case 1:
        return ImmutableSet.of(Iterables.getOnlyElement(paramEnumSet));
      case 0:
        break;
    } 
    return ImmutableSet.of();
  }
  
  public boolean contains(Object paramObject) {
    return this.delegate.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof ImmutableEnumSet)
      collection = ((ImmutableEnumSet)paramCollection).delegate; 
    return this.delegate.containsAll(collection);
  }
  
  public boolean equals(Object<E> paramObject) {
    if (paramObject == this)
      return true; 
    Object<E> object = paramObject;
    if (paramObject instanceof ImmutableEnumSet)
      object = (Object<E>)((ImmutableEnumSet)paramObject).delegate; 
    return this.delegate.equals(object);
  }
  
  public int hashCode() {
    int i = this.hashCode;
    int j = i;
    if (i == 0) {
      j = this.delegate.hashCode();
      this.hashCode = j;
    } 
    return j;
  }
  
  public boolean isEmpty() {
    return this.delegate.isEmpty();
  }
  
  boolean isHashCodeFast() {
    return true;
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public UnmodifiableIterator<E> iterator() {
    return Iterators.unmodifiableIterator(this.delegate.iterator());
  }
  
  public int size() {
    return this.delegate.size();
  }
  
  public String toString() {
    return this.delegate.toString();
  }
  
  Object writeReplace() {
    return new EnumSerializedForm<E>(this.delegate);
  }
  
  private static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final EnumSet<E> delegate;
    
    EnumSerializedForm(EnumSet<E> param1EnumSet) {
      this.delegate = param1EnumSet;
    }
    
    Object readResolve() {
      return new ImmutableEnumSet<Enum>(this.delegate.clone());
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableEnumSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */