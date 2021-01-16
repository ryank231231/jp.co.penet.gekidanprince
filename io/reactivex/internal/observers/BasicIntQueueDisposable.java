package io.reactivex.internal.observers;

import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements QueueDisposable<T> {
  private static final long serialVersionUID = -1001730202384742097L;
  
  public final boolean offer(T paramT) {
    throw new UnsupportedOperationException("Should not be called");
  }
  
  public final boolean offer(T paramT1, T paramT2) {
    throw new UnsupportedOperationException("Should not be called");
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\BasicIntQueueDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */