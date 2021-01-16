package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableLastMaybe<T> extends Maybe<T> {
  final ObservableSource<T> source;
  
  public ObservableLastMaybe(ObservableSource<T> paramObservableSource) {
    this.source = paramObservableSource;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new LastObserver<T>(paramMaybeObserver));
  }
  
  static final class LastObserver<T> implements Observer<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    T item;
    
    Disposable s;
    
    LastObserver(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
    }
    
    public void dispose() {
      this.s.dispose();
      this.s = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (this.s == DisposableHelper.DISPOSED) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onComplete() {
      this.s = (Disposable)DisposableHelper.DISPOSED;
      T t = this.item;
      if (t != null) {
        this.item = null;
        this.actual.onSuccess(t);
      } else {
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.s = (Disposable)DisposableHelper.DISPOSED;
      this.item = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.item = param1T;
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableLastMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */