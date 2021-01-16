package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
  final long index;
  
  final Flowable<T> source;
  
  public FlowableElementAtMaybe(Flowable<T> paramFlowable, long paramLong) {
    this.source = paramFlowable;
    this.index = paramLong;
  }
  
  public Flowable<T> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableElementAt<T>(this.source, this.index, null, false));
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new ElementAtSubscriber<T>(paramMaybeObserver, this.index));
  }
  
  static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    long count;
    
    boolean done;
    
    final long index;
    
    Subscription s;
    
    ElementAtSubscriber(MaybeObserver<? super T> param1MaybeObserver, long param1Long) {
      this.actual = param1MaybeObserver;
      this.index = param1Long;
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
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      if (!this.done) {
        this.done = true;
        this.actual.onComplete();
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
      long l = this.count;
      if (l == this.index) {
        this.done = true;
        this.s.cancel();
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        this.actual.onSuccess(param1T);
        return;
      } 
      this.count = l + 1L;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableElementAtMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */