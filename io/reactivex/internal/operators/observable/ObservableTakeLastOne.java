package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {
  public ObservableTakeLastOne(ObservableSource<T> paramObservableSource) {
    super(paramObservableSource);
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new TakeLastOneObserver<T>(paramObserver));
  }
  
  static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    
    Disposable s;
    
    T value;
    
    TakeLastOneObserver(Observer<? super T> param1Observer) {
      this.actual = param1Observer;
    }
    
    public void dispose() {
      this.value = null;
      this.s.dispose();
    }
    
    void emit() {
      T t = this.value;
      if (t != null) {
        this.value = null;
        this.actual.onNext(t);
      } 
      this.actual.onComplete();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      emit();
    }
    
    public void onError(Throwable param1Throwable) {
      this.value = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.value = param1T;
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTakeLastOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */