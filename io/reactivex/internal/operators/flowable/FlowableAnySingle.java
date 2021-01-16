package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableAnySingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
  final Predicate<? super T> predicate;
  
  final Flowable<T> source;
  
  public FlowableAnySingle(Flowable<T> paramFlowable, Predicate<? super T> paramPredicate) {
    this.source = paramFlowable;
    this.predicate = paramPredicate;
  }
  
  public Flowable<Boolean> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableAny<T>(this.source, this.predicate));
  }
  
  protected void subscribeActual(SingleObserver<? super Boolean> paramSingleObserver) {
    this.source.subscribe(new AnySubscriber<T>(paramSingleObserver, this.predicate));
  }
  
  static final class AnySubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final SingleObserver<? super Boolean> actual;
    
    boolean done;
    
    final Predicate<? super T> predicate;
    
    Subscription s;
    
    AnySubscriber(SingleObserver<? super Boolean> param1SingleObserver, Predicate<? super T> param1Predicate) {
      this.actual = param1SingleObserver;
      this.predicate = param1Predicate;
    }
    
    public void dispose() {
      this.s.cancel();
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (this.s == SubscriptionHelper.CANCELLED) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        this.actual.onSuccess(Boolean.valueOf(false));
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      try {
        boolean bool = this.predicate.test(param1T);
        if (bool) {
          this.done = true;
          this.s.cancel();
          this.s = (Subscription)SubscriptionHelper.CANCELLED;
          this.actual.onSuccess(Boolean.valueOf(true));
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.cancel();
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        onError(throwable);
        return;
      } 
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableAnySingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */