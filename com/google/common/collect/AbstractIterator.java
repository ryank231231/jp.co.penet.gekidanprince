package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {
  private T next;
  
  private State state = State.NOT_READY;
  
  private boolean tryToComputeNext() {
    this.state = State.FAILED;
    this.next = computeNext();
    if (this.state != State.DONE) {
      this.state = State.READY;
      return true;
    } 
    return false;
  }
  
  protected abstract T computeNext();
  
  @CanIgnoreReturnValue
  protected final T endOfData() {
    this.state = State.DONE;
    return null;
  }
  
  @CanIgnoreReturnValue
  public final boolean hasNext() {
    boolean bool;
    if (this.state != State.FAILED) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    switch (this.state) {
      default:
        return tryToComputeNext();
      case READY:
        return true;
      case DONE:
        break;
    } 
    return false;
  }
  
  @CanIgnoreReturnValue
  public final T next() {
    if (hasNext()) {
      this.state = State.NOT_READY;
      T t = this.next;
      this.next = null;
      return t;
    } 
    throw new NoSuchElementException();
  }
  
  public final T peek() {
    if (hasNext())
      return this.next; 
    throw new NoSuchElementException();
  }
  
  private enum State {
    DONE, FAILED, NOT_READY, READY;
    
    static {
      DONE = new State("DONE", 2);
      FAILED = new State("FAILED", 3);
      $VALUES = new State[] { READY, NOT_READY, DONE, FAILED };
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */