package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableSingleMaybe<T> extends Maybe<T> {
  final ObservableSource<T> source;
  
  public ObservableSingleMaybe(ObservableSource<T> paramObservableSource) {
    this.source = paramObservableSource;
  }
  
  public void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new SingleElementObserver<T>(paramMaybeObserver));
  }
  
  static final class SingleElementObserver<T> implements Observer<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    boolean done;
    
    Disposable s;
    
    T value;
    
    SingleElementObserver(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      T t = this.value;
      this.value = null;
      if (t == null) {
        this.actual.onComplete();
      } else {
        this.actual.onSuccess(t);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.value != null) {
        this.done = true;
        this.s.dispose();
        this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        return;
      } 
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSingleMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */