package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {
  final Function<? super Throwable, ? extends T> valueSupplier;
  
  public ObservableOnErrorReturn(ObservableSource<T> paramObservableSource, Function<? super Throwable, ? extends T> paramFunction) {
    super(paramObservableSource);
    this.valueSupplier = paramFunction;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new OnErrorReturnObserver<T>(paramObserver, this.valueSupplier));
  }
  
  static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    
    Disposable s;
    
    final Function<? super Throwable, ? extends T> valueSupplier;
    
    OnErrorReturnObserver(Observer<? super T> param1Observer, Function<? super Throwable, ? extends T> param1Function) {
      this.actual = param1Observer;
      this.valueSupplier = param1Function;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        Object object = this.valueSupplier.apply(param1Throwable);
        if (object == null) {
          object = new NullPointerException("The supplied value is null");
          object.initCause(param1Throwable);
          this.actual.onError((Throwable)object);
          return;
        } 
        this.actual.onNext(object);
        this.actual.onComplete();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableOnErrorReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */