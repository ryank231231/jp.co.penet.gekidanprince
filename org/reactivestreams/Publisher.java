package org.reactivestreams;

public interface Publisher<T> {
  void subscribe(Subscriber<? super T> paramSubscriber);
}


/* Location:              Y:\classes-dex2jar.jar!\org\reactivestreams\Publisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */