package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromAction<T> extends Maybe<T> implements Callable<T> {
  final Action action;
  
  public MaybeFromAction(Action paramAction) {
    this.action = paramAction;
  }
  
  public T call() throws Exception {
    this.action.run();
    return null;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    Disposable disposable = Disposables.empty();
    paramMaybeObserver.onSubscribe(disposable);
    if (!disposable.isDisposed())
      try {
        this.action.run();
        if (!disposable.isDisposed())
          paramMaybeObserver.onComplete(); 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        if (!disposable.isDisposed()) {
          paramMaybeObserver.onError(throwable);
        } else {
          RxJavaPlugins.onError(throwable);
        } 
        return;
      }  
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFromAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */