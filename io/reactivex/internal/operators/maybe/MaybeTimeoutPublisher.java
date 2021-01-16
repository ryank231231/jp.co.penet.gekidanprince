package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeTimeoutPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
  final MaybeSource<? extends T> fallback;
  
  final Publisher<U> other;
  
  public MaybeTimeoutPublisher(MaybeSource<T> paramMaybeSource, Publisher<U> paramPublisher, MaybeSource<? extends T> paramMaybeSource1) {
    super(paramMaybeSource);
    this.other = paramPublisher;
    this.fallback = paramMaybeSource1;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    TimeoutMainMaybeObserver<T, Object> timeoutMainMaybeObserver = new TimeoutMainMaybeObserver<T, Object>(paramMaybeObserver, this.fallback);
    paramMaybeObserver.onSubscribe(timeoutMainMaybeObserver);
    this.other.subscribe((Subscriber)timeoutMainMaybeObserver.other);
    this.source.subscribe(timeoutMainMaybeObserver);
  }
  
  static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
    private static final long serialVersionUID = 8663801314800248617L;
    
    final MaybeObserver<? super T> actual;
    
    TimeoutFallbackMaybeObserver(MaybeObserver<? super T> param1MaybeObserver) {
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
  
  static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = -5955289211445418871L;
    
    final MaybeObserver<? super T> actual;
    
    final MaybeSource<? extends T> fallback;
    
    final MaybeTimeoutPublisher.TimeoutOtherMaybeObserver<T, U> other;
    
    final MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver<T> otherObserver;
    
    TimeoutMainMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, MaybeSource<? extends T> param1MaybeSource) {
      this.actual = param1MaybeObserver;
      this.other = new MaybeTimeoutPublisher.TimeoutOtherMaybeObserver<T, U>(this);
      this.fallback = param1MaybeSource;
      if (param1MaybeSource != null) {
        param1MaybeObserver = new MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver<T>(param1MaybeObserver);
      } else {
        param1MaybeObserver = null;
      } 
      this.otherObserver = (MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver)param1MaybeObserver;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
      SubscriptionHelper.cancel(this.other);
      MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.otherObserver;
      if (timeoutFallbackMaybeObserver != null)
        DisposableHelper.dispose(timeoutFallbackMaybeObserver); 
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      SubscriptionHelper.cancel(this.other);
      if (getAndSet((Disposable)DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED)
        this.actual.onComplete(); 
    }
    
    public void onError(Throwable param1Throwable) {
      SubscriptionHelper.cancel(this.other);
      if (getAndSet((Disposable)DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      SubscriptionHelper.cancel(this.other);
      if (getAndSet((Disposable)DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED)
        this.actual.onSuccess(param1T); 
    }
    
    public void otherComplete() {
      if (DisposableHelper.dispose(this)) {
        MaybeSource<? extends T> maybeSource = this.fallback;
        if (maybeSource == null) {
          this.actual.onError(new TimeoutException());
        } else {
          maybeSource.subscribe(this.otherObserver);
        } 
      } 
    }
    
    public void otherError(Throwable param1Throwable) {
      if (DisposableHelper.dispose(this)) {
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
  }
  
  static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = 8663801314800248617L;
    
    final MaybeTimeoutPublisher.TimeoutMainMaybeObserver<T, U> parent;
    
    TimeoutOtherMaybeObserver(MaybeTimeoutPublisher.TimeoutMainMaybeObserver<T, U> param1TimeoutMainMaybeObserver) {
      this.parent = param1TimeoutMainMaybeObserver;
    }
    
    public void onComplete() {
      this.parent.otherComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.parent.otherError(param1Throwable);
    }
    
    public void onNext(Object param1Object) {
      get().cancel();
      this.parent.otherComplete();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      SubscriptionHelper.setOnce(this, param1Subscription, Long.MAX_VALUE);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeTimeoutPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */