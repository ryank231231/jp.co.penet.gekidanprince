package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {
  final T defaultItem;
  
  final ObservableSource<T> source;
  
  public ObservableLastSingle(ObservableSource<T> paramObservableSource, T paramT) {
    this.source = paramObservableSource;
    this.defaultItem = paramT;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new LastObserver<T>(paramSingleObserver, this.defaultItem));
  }
  
  static final class LastObserver<T> implements Observer<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    final T defaultItem;
    
    T item;
    
    Disposable s;
    
    LastObserver(SingleObserver<? super T> param1SingleObserver, T param1T) {
      this.actual = param1SingleObserver;
      this.defaultItem = param1T;
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
        t = this.defaultItem;
        if (t != null) {
          this.actual.onSuccess(t);
        } else {
          this.actual.onError(new NoSuchElementException());
        } 
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableLastSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */