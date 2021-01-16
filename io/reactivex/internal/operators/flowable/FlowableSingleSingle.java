package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {
  final T defaultValue;
  
  final Flowable<T> source;
  
  public FlowableSingleSingle(Flowable<T> paramFlowable, T paramT) {
    this.source = paramFlowable;
    this.defaultValue = paramT;
  }
  
  public Flowable<T> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableSingle<T>(this.source, this.defaultValue, true));
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new SingleElementSubscriber<T>(paramSingleObserver, this.defaultValue));
  }
  
  static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    final T defaultValue;
    
    boolean done;
    
    Subscription s;
    
    T value;
    
    SingleElementSubscriber(SingleObserver<? super T> param1SingleObserver, T param1T) {
      this.actual = param1SingleObserver;
      this.defaultValue = param1T;
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
      if (this.done)
        return; 
      this.done = true;
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      T t1 = this.value;
      this.value = null;
      T t2 = t1;
      if (t1 == null)
        t2 = this.defaultValue; 
      if (t2 != null) {
        this.actual.onSuccess(t2);
      } else {
        this.actual.onError(new NoSuchElementException());
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
      if (this.value != null) {
        this.done = true;
        this.s.cancel();
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        return;
      } 
      this.value = param1T;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSingleSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */