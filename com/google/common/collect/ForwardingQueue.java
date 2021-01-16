package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
  protected abstract Queue<E> delegate();
  
  public E element() {
    return delegate().element();
  }
  
  @CanIgnoreReturnValue
  public boolean offer(E paramE) {
    return delegate().offer(paramE);
  }
  
  public E peek() {
    return delegate().peek();
  }
  
  @CanIgnoreReturnValue
  public E poll() {
    return delegate().poll();
  }
  
  @CanIgnoreReturnValue
  public E remove() {
    return delegate().remove();
  }
  
  protected boolean standardOffer(E paramE) {
    try {
      return add(paramE);
    } catch (IllegalStateException illegalStateException) {
      return false;
    } 
  }
  
  protected E standardPeek() {
    try {
      return element();
    } catch (NoSuchElementException noSuchElementException) {
      return null;
    } 
  }
  
  protected E standardPoll() {
    try {
      return remove();
    } catch (NoSuchElementException noSuchElementException) {
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */