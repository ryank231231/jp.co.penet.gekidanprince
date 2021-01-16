package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceSeedSingle<T, R> extends Single<R> {
  final BiFunction<R, ? super T, R> reducer;
  
  final R seed;
  
  final ObservableSource<T> source;
  
  public ObservableReduceSeedSingle(ObservableSource<T> paramObservableSource, R paramR, BiFunction<R, ? super T, R> paramBiFunction) {
    this.source = paramObservableSource;
    this.seed = paramR;
    this.reducer = paramBiFunction;
  }
  
  protected void subscribeActual(SingleObserver<? super R> paramSingleObserver) {
    this.source.subscribe(new ReduceSeedObserver<T, R>(paramSingleObserver, this.reducer, this.seed));
  }
  
  static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
    final SingleObserver<? super R> actual;
    
    Disposable d;
    
    final BiFunction<R, ? super T, R> reducer;
    
    R value;
    
    ReduceSeedObserver(SingleObserver<? super R> param1SingleObserver, BiFunction<R, ? super T, R> param1BiFunction, R param1R) {
      this.actual = param1SingleObserver;
      this.value = param1R;
      this.reducer = param1BiFunction;
    }
    
    public void dispose() {
      this.d.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      R r = this.value;
      if (r != null) {
        this.value = null;
        this.actual.onSuccess(r);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.value != null) {
        this.value = null;
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      R r = this.value;
      if (r != null)
        try {
          this.value = (R)ObjectHelper.requireNonNull(this.reducer.apply(r, param1T), "The reducer returned a null value");
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.d.dispose();
          onError(throwable);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableReduceSeedSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */