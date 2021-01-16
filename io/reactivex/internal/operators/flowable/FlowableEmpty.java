package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

public final class FlowableEmpty extends Flowable<Object> implements ScalarCallable<Object> {
  public static final Flowable<Object> INSTANCE = new FlowableEmpty();
  
  public Object call() {
    return null;
  }
  
  public void subscribeActual(Subscriber<? super Object> paramSubscriber) {
    EmptySubscription.complete(paramSubscriber);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */