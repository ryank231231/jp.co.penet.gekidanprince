package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
  final long limit;
  
  public ObservableTake(ObservableSource<T> paramObservableSource, long paramLong) {
    super(paramObservableSource);
    this.limit = paramLong;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new TakeObserver<T>(paramObserver, this.limit));
  }
  
  static final class TakeObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    
    boolean done;
    
    long remaining;
    
    Disposable subscription;
    
    TakeObserver(Observer<? super T> param1Observer, long param1Long) {
      this.actual = param1Observer;
      this.remaining = param1Long;
    }
    
    public void dispose() {
      this.subscription.dispose();
    }
    
    public boolean isDisposed() {
      return this.subscription.isDisposed();
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        this.subscription.dispose();
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.subscription.dispose();
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (!this.done) {
        long l = this.remaining;
        this.remaining = l - 1L;
        if (l > 0L) {
          boolean bool;
          if (this.remaining == 0L) {
            bool = true;
          } else {
            bool = false;
          } 
          this.actual.onNext(param1T);
          if (bool)
            onComplete(); 
        } 
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.subscription, param1Disposable)) {
        this.subscription = param1Disposable;
        if (this.remaining == 0L) {
          this.done = true;
          param1Disposable.dispose();
          EmptyDisposable.complete(this.actual);
        } else {
          this.actual.onSubscribe(this);
        } 
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */