package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
  final Publisher<U> other;
  
  public MaybeDelayOtherPublisher(MaybeSource<T> paramMaybeSource, Publisher<U> paramPublisher) {
    super(paramMaybeSource);
    this.other = paramPublisher;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new DelayMaybeObserver<T, U>(paramMaybeObserver, this.other));
  }
  
  static final class DelayMaybeObserver<T, U> implements MaybeObserver<T>, Disposable {
    Disposable d;
    
    final MaybeDelayOtherPublisher.OtherSubscriber<T> other;
    
    final Publisher<U> otherSource;
    
    DelayMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, Publisher<U> param1Publisher) {
      this.other = new MaybeDelayOtherPublisher.OtherSubscriber<T>(param1MaybeObserver);
      this.otherSource = param1Publisher;
    }
    
    public void dispose() {
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
      SubscriptionHelper.cancel(this.other);
    }
    
    public boolean isDisposed() {
      return SubscriptionHelper.isCancelled(this.other.get());
    }
    
    public void onComplete() {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      subscribeNext();
    }
    
    public void onError(Throwable param1Throwable) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.other.error = param1Throwable;
      subscribeNext();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.other.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.other.value = param1T;
      subscribeNext();
    }
    
    void subscribeNext() {
      this.otherSource.subscribe((Subscriber)this.other);
    }
  }
  
  static final class OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = -1215060610805418006L;
    
    final MaybeObserver<? super T> actual;
    
    Throwable error;
    
    T value;
    
    OtherSubscriber(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
    }
    
    public void onComplete() {
      Throwable throwable = this.error;
      if (throwable != null) {
        this.actual.onError(throwable);
      } else {
        T t = this.value;
        if (t != null) {
          this.actual.onSuccess(t);
        } else {
          this.actual.onComplete();
        } 
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      Throwable throwable = this.error;
      if (throwable == null) {
        this.actual.onError(param1Throwable);
      } else {
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { throwable, param1Throwable }));
      } 
    }
    
    public void onNext(Object param1Object) {
      param1Object = get();
      if (param1Object != SubscriptionHelper.CANCELLED) {
        lazySet((Subscription)SubscriptionHelper.CANCELLED);
        param1Object.cancel();
        onComplete();
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      SubscriptionHelper.setOnce(this, param1Subscription, Long.MAX_VALUE);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDelayOtherPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */