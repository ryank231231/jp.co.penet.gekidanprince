package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class MaybeFromFuture<T> extends Maybe<T> {
  final Future<? extends T> future;
  
  final long timeout;
  
  final TimeUnit unit;
  
  public MaybeFromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit) {
    this.future = paramFuture;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    Disposable disposable = Disposables.empty();
    paramMaybeObserver.onSubscribe(disposable);
    if (!disposable.isDisposed())
      try {
        T t;
        if (this.timeout <= 0L) {
          T t1 = this.future.get();
        } else {
          t = this.future.get(this.timeout, this.unit);
        } 
        if (!disposable.isDisposed())
          if (t == null) {
            paramMaybeObserver.onComplete();
          } else {
            paramMaybeObserver.onSuccess(t);
          }  
      } catch (Throwable throwable1) {
        Throwable throwable2 = throwable1;
        if (throwable1 instanceof java.util.concurrent.ExecutionException)
          throwable2 = throwable1.getCause(); 
        Exceptions.throwIfFatal(throwable2);
        if (!disposable.isDisposed())
          paramMaybeObserver.onError(throwable2); 
        return;
      }  
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFromFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */