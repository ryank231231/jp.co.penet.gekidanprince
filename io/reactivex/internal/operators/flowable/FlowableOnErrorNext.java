package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {
  final boolean allowFatal;
  
  final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
  
  public FlowableOnErrorNext(Flowable<T> paramFlowable, Function<? super Throwable, ? extends Publisher<? extends T>> paramFunction, boolean paramBoolean) {
    super(paramFlowable);
    this.nextSupplier = paramFunction;
    this.allowFatal = paramBoolean;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    OnErrorNextSubscriber<T> onErrorNextSubscriber = new OnErrorNextSubscriber<T>(paramSubscriber, this.nextSupplier, this.allowFatal);
    paramSubscriber.onSubscribe((Subscription)onErrorNextSubscriber.arbiter);
    this.source.subscribe(onErrorNextSubscriber);
  }
  
  static final class OnErrorNextSubscriber<T> implements FlowableSubscriber<T> {
    final Subscriber<? super T> actual;
    
    final boolean allowFatal;
    
    final SubscriptionArbiter arbiter;
    
    boolean done;
    
    final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
    
    boolean once;
    
    OnErrorNextSubscriber(Subscriber<? super T> param1Subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> param1Function, boolean param1Boolean) {
      this.actual = param1Subscriber;
      this.nextSupplier = param1Function;
      this.allowFatal = param1Boolean;
      this.arbiter = new SubscriptionArbiter();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      this.once = true;
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.once) {
        if (this.done) {
          RxJavaPlugins.onError(param1Throwable);
          return;
        } 
        this.actual.onError(param1Throwable);
        return;
      } 
      this.once = true;
      if (this.allowFatal && !(param1Throwable instanceof Exception)) {
        this.actual.onError(param1Throwable);
        return;
      } 
      try {
        NullPointerException nullPointerException;
        Publisher publisher = (Publisher)this.nextSupplier.apply(param1Throwable);
        if (publisher == null) {
          nullPointerException = new NullPointerException("Publisher is null");
          nullPointerException.initCause(param1Throwable);
          this.actual.onError(nullPointerException);
          return;
        } 
        nullPointerException.subscribe((Subscriber)this);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      this.actual.onNext(param1T);
      if (!this.once)
        this.arbiter.produced(1L); 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      this.arbiter.setSubscription(param1Subscription);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnErrorNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */