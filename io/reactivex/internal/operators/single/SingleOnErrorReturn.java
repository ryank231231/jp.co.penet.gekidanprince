package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

public final class SingleOnErrorReturn<T> extends Single<T> {
  final SingleSource<? extends T> source;
  
  final T value;
  
  final Function<? super Throwable, ? extends T> valueSupplier;
  
  public SingleOnErrorReturn(SingleSource<? extends T> paramSingleSource, Function<? super Throwable, ? extends T> paramFunction, T paramT) {
    this.source = paramSingleSource;
    this.valueSupplier = paramFunction;
    this.value = paramT;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new OnErrorReturn(paramSingleObserver));
  }
  
  final class OnErrorReturn implements SingleObserver<T> {
    private final SingleObserver<? super T> observer;
    
    OnErrorReturn(SingleObserver<? super T> param1SingleObserver) {
      this.observer = param1SingleObserver;
    }
    
    public void onError(Throwable param1Throwable) {
      T t;
      Throwable throwable;
      if (SingleOnErrorReturn.this.valueSupplier != null) {
        try {
          t = (T)SingleOnErrorReturn.this.valueSupplier.apply(param1Throwable);
        } catch (Throwable null) {
          Exceptions.throwIfFatal(throwable);
          this.observer.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
          return;
        } 
      } else {
        t = SingleOnErrorReturn.this.value;
      } 
      if (t == null) {
        throwable = new NullPointerException("Value supplied was null");
        throwable.initCause(param1Throwable);
        this.observer.onError(throwable);
        return;
      } 
      this.observer.onSuccess(throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.observer.onSubscribe(param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      this.observer.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleOnErrorReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */