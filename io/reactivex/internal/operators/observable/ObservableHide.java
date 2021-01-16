package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {
  public ObservableHide(ObservableSource<T> paramObservableSource) {
    super(paramObservableSource);
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new HideDisposable<T>(paramObserver));
  }
  
  static final class HideDisposable<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    
    Disposable d;
    
    HideDisposable(Observer<? super T> param1Observer) {
      this.actual = param1Observer;
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
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableHide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */