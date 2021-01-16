package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableToList<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
  final Callable<U> collectionSupplier;
  
  public FlowableToList(Flowable<T> paramFlowable, Callable<U> paramCallable) {
    super(paramFlowable);
    this.collectionSupplier = paramCallable;
  }
  
  protected void subscribeActual(Subscriber<? super U> paramSubscriber) {
    try {
      Collection collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.source.subscribe(new ToListSubscriber<Object, U>(paramSubscriber, (U)collection));
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptySubscription.error(throwable, paramSubscriber);
      return;
    } 
  }
  
  static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -8134157938864266736L;
    
    Subscription s;
    
    ToListSubscriber(Subscriber<? super U> param1Subscriber, U param1U) {
      super(param1Subscriber);
      this.value = param1U;
    }
    
    public void cancel() {
      super.cancel();
      this.s.cancel();
    }
    
    public void onComplete() {
      complete(this.value);
    }
    
    public void onError(Throwable param1Throwable) {
      this.value = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      Collection<T> collection = (Collection)this.value;
      if (collection != null)
        collection.add(param1T); 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableToList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */