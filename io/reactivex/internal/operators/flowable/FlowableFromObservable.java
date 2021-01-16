package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
  private final Observable<T> upstream;
  
  public FlowableFromObservable(Observable<T> paramObservable) {
    this.upstream = paramObservable;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.upstream.subscribe(new SubscriberObserver<T>(paramSubscriber));
  }
  
  static class SubscriberObserver<T> implements Observer<T>, Subscription {
    private Disposable d;
    
    private final Subscriber<? super T> s;
    
    SubscriberObserver(Subscriber<? super T> param1Subscriber) {
      this.s = param1Subscriber;
    }
    
    public void cancel() {
      this.d.dispose();
    }
    
    public void onComplete() {
      this.s.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.s.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.s.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.d = param1Disposable;
      this.s.onSubscribe(this);
    }
    
    public void request(long param1Long) {}
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFromObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */