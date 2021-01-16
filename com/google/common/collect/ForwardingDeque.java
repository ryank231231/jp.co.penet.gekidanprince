package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

@GwtIncompatible
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
  public void addFirst(E paramE) {
    delegate().addFirst(paramE);
  }
  
  public void addLast(E paramE) {
    delegate().addLast(paramE);
  }
  
  protected abstract Deque<E> delegate();
  
  public Iterator<E> descendingIterator() {
    return delegate().descendingIterator();
  }
  
  public E getFirst() {
    return delegate().getFirst();
  }
  
  public E getLast() {
    return delegate().getLast();
  }
  
  @CanIgnoreReturnValue
  public boolean offerFirst(E paramE) {
    return delegate().offerFirst(paramE);
  }
  
  @CanIgnoreReturnValue
  public boolean offerLast(E paramE) {
    return delegate().offerLast(paramE);
  }
  
  public E peekFirst() {
    return delegate().peekFirst();
  }
  
  public E peekLast() {
    return delegate().peekLast();
  }
  
  @CanIgnoreReturnValue
  public E pollFirst() {
    return delegate().pollFirst();
  }
  
  @CanIgnoreReturnValue
  public E pollLast() {
    return delegate().pollLast();
  }
  
  @CanIgnoreReturnValue
  public E pop() {
    return delegate().pop();
  }
  
  public void push(E paramE) {
    delegate().push(paramE);
  }
  
  @CanIgnoreReturnValue
  public E removeFirst() {
    return delegate().removeFirst();
  }
  
  @CanIgnoreReturnValue
  public boolean removeFirstOccurrence(Object paramObject) {
    return delegate().removeFirstOccurrence(paramObject);
  }
  
  @CanIgnoreReturnValue
  public E removeLast() {
    return delegate().removeLast();
  }
  
  @CanIgnoreReturnValue
  public boolean removeLastOccurrence(Object paramObject) {
    return delegate().removeLastOccurrence(paramObject);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */