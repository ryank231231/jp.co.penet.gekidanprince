package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
  private final Action onCancel;
  
  private final LongConsumer onRequest;
  
  private final Consumer<? super Subscription> onSubscribe;
  
  public FlowableDoOnLifecycle(Flowable<T> paramFlowable, Consumer<? super Subscription> paramConsumer, LongConsumer paramLongConsumer, Action paramAction) {
    super(paramFlowable);
    this.onSubscribe = paramConsumer;
    this.onRequest = paramLongConsumer;
    this.onCancel = paramAction;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new SubscriptionLambdaSubscriber<T>(paramSubscriber, this.onSubscribe, this.onRequest, this.onCancel));
  }
  
  static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> actual;
    
    final Action onCancel;
    
    final LongConsumer onRequest;
    
    final Consumer<? super Subscription> onSubscribe;
    
    Subscription s;
    
    SubscriptionLambdaSubscriber(Subscriber<? super T> param1Subscriber, Consumer<? super Subscription> param1Consumer, LongConsumer param1LongConsumer, Action param1Action) {
      this.actual = param1Subscriber;
      this.onSubscribe = param1Consumer;
      this.onCancel = param1Action;
      this.onRequest = param1LongConsumer;
    }
    
    public void cancel() {
      try {
        this.onCancel.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.s != SubscriptionHelper.CANCELLED)
        this.actual.onComplete(); 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.s != SubscriptionHelper.CANCELLED) {
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      try {
        this.onSubscribe.accept(param1Subscription);
        if (SubscriptionHelper.validate(this.s, param1Subscription)) {
          this.s = param1Subscription;
          this.actual.onSubscribe(this);
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        param1Subscription.cancel();
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        EmptySubscription.error(throwable, this.actual);
        return;
      } 
    }
    
    public void request(long param1Long) {
      try {
        this.onRequest.accept(param1Long);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
      this.s.request(param1Long);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDoOnLifecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */