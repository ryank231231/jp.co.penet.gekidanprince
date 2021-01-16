package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {
  final BiFunction<R, ? super T, R> accumulator;
  
  final Callable<R> seedSupplier;
  
  public ObservableScanSeed(ObservableSource<T> paramObservableSource, Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction) {
    super(paramObservableSource);
    this.accumulator = paramBiFunction;
    this.seedSupplier = paramCallable;
  }
  
  public void subscribeActual(Observer<? super R> paramObserver) {
    try {
      Object object = ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seed supplied is null");
      this.source.subscribe(new ScanSeedObserver<T, R>(paramObserver, this.accumulator, (R)object));
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
  
  static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {
    final BiFunction<R, ? super T, R> accumulator;
    
    final Observer<? super R> actual;
    
    boolean done;
    
    Disposable s;
    
    R value;
    
    ScanSeedObserver(Observer<? super R> param1Observer, BiFunction<R, ? super T, R> param1BiFunction, R param1R) {
      this.actual = param1Observer;
      this.accumulator = param1BiFunction;
      this.value = param1R;
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
      R r = this.value;
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.accumulator.apply(r, param1T), "The accumulator returned a null value");
        this.value = (R)param1T;
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.dispose();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
        this.actual.onNext(this.value);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableScanSeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */