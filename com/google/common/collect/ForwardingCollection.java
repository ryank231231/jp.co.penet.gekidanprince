package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
  @CanIgnoreReturnValue
  public boolean add(E paramE) {
    return delegate().add(paramE);
  }
  
  @CanIgnoreReturnValue
  public boolean addAll(Collection<? extends E> paramCollection) {
    return delegate().addAll(paramCollection);
  }
  
  public void clear() {
    delegate().clear();
  }
  
  public boolean contains(Object paramObject) {
    return delegate().contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    return delegate().containsAll(paramCollection);
  }
  
  protected abstract Collection<E> delegate();
  
  public boolean isEmpty() {
    return delegate().isEmpty();
  }
  
  public Iterator<E> iterator() {
    return delegate().iterator();
  }
  
  @CanIgnoreReturnValue
  public boolean remove(Object paramObject) {
    return delegate().remove(paramObject);
  }
  
  @CanIgnoreReturnValue
  public boolean removeAll(Collection<?> paramCollection) {
    return delegate().removeAll(paramCollection);
  }
  
  @CanIgnoreReturnValue
  public boolean retainAll(Collection<?> paramCollection) {
    return delegate().retainAll(paramCollection);
  }
  
  public int size() {
    return delegate().size();
  }
  
  protected boolean standardAddAll(Collection<? extends E> paramCollection) {
    return Iterators.addAll(this, paramCollection.iterator());
  }
  
  protected void standardClear() {
    Iterators.clear(iterator());
  }
  
  protected boolean standardContains(@Nullable Object paramObject) {
    return Iterators.contains(iterator(), paramObject);
  }
  
  protected boolean standardContainsAll(Collection<?> paramCollection) {
    return Collections2.containsAllImpl(this, paramCollection);
  }
  
  protected boolean standardIsEmpty() {
    return iterator().hasNext() ^ true;
  }
  
  protected boolean standardRemove(@Nullable Object paramObject) {
    Iterator<E> iterator = iterator();
    while (iterator.hasNext()) {
      if (Objects.equal(iterator.next(), paramObject)) {
        iterator.remove();
        return true;
      } 
    } 
    return false;
  }
  
  protected boolean standardRemoveAll(Collection<?> paramCollection) {
    return Iterators.removeAll(iterator(), paramCollection);
  }
  
  protected boolean standardRetainAll(Collection<?> paramCollection) {
    return Iterators.retainAll(iterator(), paramCollection);
  }
  
  protected Object[] standardToArray() {
    return toArray(new Object[size()]);
  }
  
  protected <T> T[] standardToArray(T[] paramArrayOfT) {
    return ObjectArrays.toArrayImpl(this, paramArrayOfT);
  }
  
  protected String standardToString() {
    return Collections2.toStringImpl(this);
  }
  
  public Object[] toArray() {
    return delegate().toArray();
  }
  
  @CanIgnoreReturnValue
  public <T> T[] toArray(T[] paramArrayOfT) {
    return delegate().toArray(paramArrayOfT);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */