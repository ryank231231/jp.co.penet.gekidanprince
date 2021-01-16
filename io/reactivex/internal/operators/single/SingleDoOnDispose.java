package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDoOnDispose<T> extends Single<T> {
  final Action onDispose;
  
  final SingleSource<T> source;
  
  public SingleDoOnDispose(SingleSource<T> paramSingleSource, Action paramAction) {
    this.source = paramSingleSource;
    this.onDispose = paramAction;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new DoOnDisposeObserver<T>(paramSingleObserver, this.onDispose));
  }
  
  static final class DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = -8583764624474935784L;
    
    final SingleObserver<? super T> actual;
    
    Disposable d;
    
    DoOnDisposeObserver(SingleObserver<? super T> param1SingleObserver, Action param1Action) {
      this.actual = param1SingleObserver;
      lazySet(param1Action);
    }
    
    public void dispose() {
      Action action = getAndSet(null);
      if (action != null) {
        try {
          action.run();
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        } 
        this.d.dispose();
      } 
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnDispose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */