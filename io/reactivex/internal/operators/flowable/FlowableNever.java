package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableNever extends Flowable<Object> {
  public static final Flowable<Object> INSTANCE = new FlowableNever();
  
  public void subscribeActual(Subscriber<? super Object> paramSubscriber) {
    paramSubscriber.onSubscribe((Subscription)EmptySubscription.INSTANCE);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableNever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */