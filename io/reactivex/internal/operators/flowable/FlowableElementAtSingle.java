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

public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {
  final T defaultValue;
  
  final long index;
  
  final Flowable<T> source;
  
  public FlowableElementAtSingle(Flowable<T> paramFlowable, long paramLong, T paramT) {
    this.source = paramFlowable;
    this.index = paramLong;
    this.defaultValue = paramT;
  }
  
  public Flowable<T> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableElementAt<T>(this.source, this.index, this.defaultValue, true));
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new ElementAtSubscriber<T>(paramSingleObserver, this.index, this.defaultValue));
  }
  
  static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    long count;
    
    final T defaultValue;
    
    boolean done;
    
    final long index;
    
    Subscription s;
    
    ElementAtSubscriber(SingleObserver<? super T> param1SingleObserver, long param1Long, T param1T) {
      this.actual = param1SingleObserver;
      this.index = param1Long;
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
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      if (!this.done) {
        this.done = true;
        T t = this.defaultValue;
        if (t != null) {
          this.actual.onSuccess(t);
        } else {
          this.actual.onError(new NoSuchElementException());
        } 
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableElementAtSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */