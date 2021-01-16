package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SingleFromPublisher<T> extends Single<T> {
  final Publisher<? extends T> publisher;
  
  public SingleFromPublisher(Publisher<? extends T> paramPublisher) {
    this.publisher = paramPublisher;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.publisher.subscribe((Subscriber)new ToSingleObserver<T>(paramSingleObserver));
  }
  
  static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    volatile boolean disposed;
    
    boolean done;
    
    Subscription s;
    
    T value;
    
    ToSingleObserver(SingleObserver<? super T> param1SingleObserver) {
      this.actual = param1SingleObserver;
    }
    
    public void dispose() {
      this.disposed = true;
      this.s.cancel();
    }
    
    public boolean isDisposed() {
      return this.disposed;
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      T t = this.value;
      this.value = null;
      if (t == null) {
        this.actual.onError(new NoSuchElementException("The source Publisher is empty"));
      } else {
        this.actual.onSuccess(t);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.value = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.value != null) {
        this.s.cancel();
        this.done = true;
        this.value = null;
        this.actual.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
      } else {
        this.value = param1T;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFromPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */