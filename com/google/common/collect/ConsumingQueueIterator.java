package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

@GwtCompatible
class ConsumingQueueIterator<T> extends AbstractIterator<T> {
  private final Queue<T> queue;
  
  ConsumingQueueIterator(Queue<T> paramQueue) {
    this.queue = (Queue<T>)Preconditions.checkNotNull(paramQueue);
  }
  
  ConsumingQueueIterator(T... paramVarArgs) {
    this.queue = new ArrayDeque<T>(paramVarArgs.length);
    Collections.addAll(this.queue, paramVarArgs);
  }
  
  public T computeNext() {
    T t;
    if (this.queue.isEmpty()) {
      T t1 = endOfData();
    } else {
      t = this.queue.remove();
    } 
    return t;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ConsumingQueueIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */