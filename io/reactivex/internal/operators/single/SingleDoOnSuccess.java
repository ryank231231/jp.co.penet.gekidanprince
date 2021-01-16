package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnSuccess<T> extends Single<T> {
  final Consumer<? super T> onSuccess;
  
  final SingleSource<T> source;
  
  public SingleDoOnSuccess(SingleSource<T> paramSingleSource, Consumer<? super T> paramConsumer) {
    this.source = paramSingleSource;
    this.onSuccess = paramConsumer;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new DoOnSuccess(paramSingleObserver));
  }
  
  final class DoOnSuccess implements SingleObserver<T> {
    private final SingleObserver<? super T> s;
    
    DoOnSuccess(SingleObserver<? super T> param1SingleObserver) {
      this.s = param1SingleObserver;
    }
    
    public void onError(Throwable param1Throwable) {
      this.s.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.s.onSubscribe(param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      try {
        SingleDoOnSuccess.this.onSuccess.accept(param1T);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */