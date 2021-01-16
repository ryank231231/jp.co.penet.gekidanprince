package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {
  @CanIgnoreReturnValue
  public int add(E paramE, int paramInt) {
    return delegate().add(paramE, paramInt);
  }
  
  public int count(Object paramObject) {
    return delegate().count(paramObject);
  }
  
  protected abstract Multiset<E> delegate();
  
  public Set<E> elementSet() {
    return delegate().elementSet();
  }
  
  public Set<Multiset.Entry<E>> entrySet() {
    return delegate().entrySet();
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return (paramObject == this || delegate().equals(paramObject));
  }
  
  public int hashCode() {
    return delegate().hashCode();
  }
  
  @CanIgnoreReturnValue
  public int remove(Object paramObject, int paramInt) {
    return delegate().remove(paramObject, paramInt);
  }
  
  @CanIgnoreReturnValue
  public int setCount(E paramE, int paramInt) {
    return delegate().setCount(paramE, paramInt);
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(E paramE, int paramInt1, int paramInt2) {
    return delegate().setCount(paramE, paramInt1, paramInt2);
  }
  
  protected boolean standardAdd(E paramE) {
    add(paramE, 1);
    return true;
  }
  
  @Beta
  protected boolean standardAddAll(Collection<? extends E> paramCollection) {
    return Multisets.addAllImpl(this, paramCollection);
  }
  
  protected void standardClear() {
    Iterators.clear(entrySet().iterator());
  }
  
  protected boolean standardContains(@Nullable Object paramObject) {
    boolean bool;
    if (count(paramObject) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Beta
  protected int standardCount(@Nullable Object paramObject) {
    for (Multiset.Entry<E> entry : entrySet()) {
      if (Objects.equal(entry.getElement(), paramObject))
        return entry.getCount(); 
    } 
    return 0;
  }
  
  protected boolean standardEquals(@Nullable Object paramObject) {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  protected int standardHashCode() {
    return entrySet().hashCode();
  }
  
  protected Iterator<E> standardIterator() {
    return Multisets.iteratorImpl(this);
  }
  
  protected boolean standardRemove(Object paramObject) {
    boolean bool = true;
    if (remove(paramObject, 1) <= 0)
      bool = false; 
    return bool;
  }
  
  protected boolean standardRemoveAll(Collection<?> paramCollection) {
    return Multisets.removeAllImpl(this, paramCollection);
  }
  
  protected boolean standardRetainAll(Collection<?> paramCollection) {
    return Multisets.retainAllImpl(this, paramCollection);
  }
  
  protected int standardSetCount(E paramE, int paramInt) {
    return Multisets.setCountImpl(this, paramE, paramInt);
  }
  
  protected boolean standardSetCount(E paramE, int paramInt1, int paramInt2) {
    return Multisets.setCountImpl(this, paramE, paramInt1, paramInt2);
  }
  
  protected int standardSize() {
    return Multisets.sizeImpl(this);
  }
  
  protected String standardToString() {
    return entrySet().toString();
  }
  
  @Beta
  protected class StandardElementSet extends Multisets.ElementSet<E> {
    Multiset<E> multiset() {
      return ForwardingMultiset.this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */