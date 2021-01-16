package io.reactivex.internal.util;

import io.reactivex.Observer;

public interface ObservableQueueDrain<T, U> {
  void accept(Observer<? super U> paramObserver, T paramT);
  
  boolean cancelled();
  
  boolean done();
  
  boolean enter();
  
  Throwable error();
  
  int leave(int paramInt);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\ObservableQueueDrain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */