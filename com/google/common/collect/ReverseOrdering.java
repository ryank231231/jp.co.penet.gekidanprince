package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  final Ordering<? super T> forwardOrder;
  
  ReverseOrdering(Ordering<? super T> paramOrdering) {
    this.forwardOrder = (Ordering<? super T>)Preconditions.checkNotNull(paramOrdering);
  }
  
  public int compare(T paramT1, T paramT2) {
    return this.forwardOrder.compare(paramT2, paramT1);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ReverseOrdering) {
      paramObject = paramObject;
      return this.forwardOrder.equals(((ReverseOrdering)paramObject).forwardOrder);
    } 
    return false;
  }
  
  public int hashCode() {
    return -this.forwardOrder.hashCode();
  }
  
  public <E extends T> E max(Iterable<E> paramIterable) {
    return this.forwardOrder.min(paramIterable);
  }
  
  public <E extends T> E max(E paramE1, E paramE2) {
    return this.forwardOrder.min(paramE1, paramE2);
  }
  
  public <E extends T> E max(E paramE1, E paramE2, E paramE3, E... paramVarArgs) {
    return this.forwardOrder.min(paramE1, paramE2, paramE3, paramVarArgs);
  }
  
  public <E extends T> E max(Iterator<E> paramIterator) {
    return this.forwardOrder.min(paramIterator);
  }
  
  public <E extends T> E min(Iterable<E> paramIterable) {
    return this.forwardOrder.max(paramIterable);
  }
  
  public <E extends T> E min(E paramE1, E paramE2) {
    return this.forwardOrder.max(paramE1, paramE2);
  }
  
  public <E extends T> E min(E paramE1, E paramE2, E paramE3, E... paramVarArgs) {
    return this.forwardOrder.max(paramE1, paramE2, paramE3, paramVarArgs);
  }
  
  public <E extends T> E min(Iterator<E> paramIterator) {
    return this.forwardOrder.max(paramIterator);
  }
  
  public <S extends T> Ordering<S> reverse() {
    return (Ordering)this.forwardOrder;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.forwardOrder);
    stringBuilder.append(".reverse()");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ReverseOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */