package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
  final BiFunction<T, T, T> accumulator;
  
  public ObservableScan(ObservableSource<T> paramObservableSource, BiFunction<T, T, T> paramBiFunction) {
    super(paramObservableSource);
    this.accumulator = paramBiFunction;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new ScanObserver<T>(paramObserver, this.accumulator));
  }
  
  static final class ScanObserver<T> implements Observer<T>, Disposable {
    final BiFunction<T, T, T> accumulator;
    
    final Observer<? super T> actual;
    
    boolean done;
    
    Disposable s;
    
    T value;
    
    ScanObserver(Observer<? super T> param1Observer, BiFunction<T, T, T> param1BiFunction) {
      this.actual = param1Observer;
      this.accumulator = param1BiFunction;
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
      this.actual.onComplete();
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
      Observer<? super T> observer = this.actual;
      T t = this.value;
      if (t == null) {
        this.value = param1T;
        observer.onNext(param1T);
      } else {
        try {
          param1T = (T)ObjectHelper.requireNonNull(this.accumulator.apply(t, param1T), "The value returned by the accumulator is null");
          this.value = param1T;
          observer.onNext(param1T);
          return;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.s.dispose();
          onError(throwable);
          return;
        } 
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */