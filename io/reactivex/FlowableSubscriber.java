package io.reactivex;

import io.reactivex.annotations.Beta;
import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Beta
public interface FlowableSubscriber<T> extends Subscriber<T> {
  void onSubscribe(@NonNull Subscription paramSubscription);
}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\FlowableSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */