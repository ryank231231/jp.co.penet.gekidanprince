package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
  final long n;
  
  public ObservableSkip(ObservableSource<T> paramObservableSource, long paramLong) {
    super(paramObservableSource);
    this.n = paramLong;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new SkipObserver<T>(paramObserver, this.n));
  }
  
  static final class SkipObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    
    Disposable d;
    
    long remaining;
    
    SkipObserver(Observer<? super T> param1Observer, long param1Long) {
      this.actual = param1Observer;
      this.remaining = param1Long;
    }
    
    public void dispose() {
      this.d.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      long l = this.remaining;
      if (l != 0L) {
        this.remaining = l - 1L;
      } else {
        this.actual.onNext(param1T);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSkip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */