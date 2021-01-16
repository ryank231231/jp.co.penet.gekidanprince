package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {
  public ObservableCount(ObservableSource<T> paramObservableSource) {
    super(paramObservableSource);
  }
  
  public void subscribeActual(Observer<? super Long> paramObserver) {
    this.source.subscribe(new CountObserver(paramObserver));
  }
  
  static final class CountObserver implements Observer<Object>, Disposable {
    final Observer<? super Long> actual;
    
    long count;
    
    Disposable s;
    
    CountObserver(Observer<? super Long> param1Observer) {
      this.actual = param1Observer;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onNext(Long.valueOf(this.count));
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(Object param1Object) {
      this.count++;
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */