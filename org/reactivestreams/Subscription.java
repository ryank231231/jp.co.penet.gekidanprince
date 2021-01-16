package org.reactivestreams;

public interface Subscription {
  void cancel();
  
  void request(long paramLong);
}


/* Location:              Y:\classes2-dex2jar.jar!\org\reactivestreams\Subscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */