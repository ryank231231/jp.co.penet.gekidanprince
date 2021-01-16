package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;

public final class SingleDoOnEvent<T> extends Single<T> {
  final BiConsumer<? super T, ? super Throwable> onEvent;
  
  final SingleSource<T> source;
  
  public SingleDoOnEvent(SingleSource<T> paramSingleSource, BiConsumer<? super T, ? super Throwable> paramBiConsumer) {
    this.source = paramSingleSource;
    this.onEvent = paramBiConsumer;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new DoOnEvent(paramSingleObserver));
  }
  
  final class DoOnEvent implements SingleObserver<T> {
    private final SingleObserver<? super T> s;
    
    DoOnEvent(SingleObserver<? super T> param1SingleObserver) {
      this.s = param1SingleObserver;
    }
    
    public void onError(Throwable param1Throwable) {
      CompositeException compositeException;
      try {
        SingleDoOnEvent.this.onEvent.accept(null, param1Throwable);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        compositeException = new CompositeException(new Throwable[] { param1Throwable, throwable });
      } 
      this.s.onError((Throwable)compositeException);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.s.onSubscribe(param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      try {
        SingleDoOnEvent.this.onEvent.accept(param1T, null);
        this.s.onSuccess(param1T);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */