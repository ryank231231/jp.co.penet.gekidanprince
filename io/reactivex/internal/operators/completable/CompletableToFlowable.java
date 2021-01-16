package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import org.reactivestreams.Subscriber;

public final class CompletableToFlowable<T> extends Flowable<T> {
  final CompletableSource source;
  
  public CompletableToFlowable(CompletableSource paramCompletableSource) {
    this.source = paramCompletableSource;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    SubscriberCompletableObserver subscriberCompletableObserver = new SubscriberCompletableObserver(paramSubscriber);
    this.source.subscribe((CompletableObserver)subscriberCompletableObserver);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableToFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */