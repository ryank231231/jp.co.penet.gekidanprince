package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
  final Publisher<U> other;
  
  public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> paramMaybeSource, Publisher<U> paramPublisher) {
    super(paramMaybeSource);
    this.other = paramPublisher;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.other.subscribe((Subscriber)new OtherSubscriber<T>(paramMaybeObserver, this.source));
  }
  
  static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
    private static final long serialVersionUID = 706635022205076709L;
    
    final MaybeObserver<? super T> actual;
    
    DelayMaybeObserver(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
  
  static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {
    final MaybeDelaySubscriptionOtherPublisher.DelayMaybeObserver<T> main;
    
    Subscription s;
    
    MaybeSource<T> source;
    
    OtherSubscriber(MaybeObserver<? super T> param1MaybeObserver, MaybeSource<T> param1MaybeSource) {
      this.main = new MaybeDelaySubscriptionOtherPublisher.DelayMaybeObserver<T>(param1MaybeObserver);
      this.source = param1MaybeSource;
    }
    
    public void dispose() {
      this.s.cancel();
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      DisposableHelper.dispose(this.main);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(this.main.get());
    }
    
    public void onComplete() {
      if (this.s != SubscriptionHelper.CANCELLED) {
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        subscribeNext();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.s != SubscriptionHelper.CANCELLED) {
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        this.main.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(Object param1Object) {
      if (this.s != SubscriptionHelper.CANCELLED) {
        this.s.cancel();
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        subscribeNext();
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.main.actual.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
    
    void subscribeNext() {
      MaybeSource<T> maybeSource = this.source;
      this.source = null;
      maybeSource.subscribe(this.main);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDelaySubscriptionOtherPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */