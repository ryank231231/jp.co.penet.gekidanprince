package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleDoAfterTerminate<T> extends Single<T> {
  final Action onAfterTerminate;
  
  final SingleSource<T> source;
  
  public SingleDoAfterTerminate(SingleSource<T> paramSingleSource, Action paramAction) {
    this.source = paramSingleSource;
    this.onAfterTerminate = paramAction;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new DoAfterTerminateObserver<T>(paramSingleObserver, this.onAfterTerminate));
  }
  
  static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    Disposable d;
    
    final Action onAfterTerminate;
    
    DoAfterTerminateObserver(SingleObserver<? super T> param1SingleObserver, Action param1Action) {
      this.actual = param1SingleObserver;
      this.onAfterTerminate = param1Action;
    }
    
    private void onAfterTerminate() {
      try {
        this.onAfterTerminate.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
    
    public void dispose() {
      this.d.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
      onAfterTerminate();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
      onAfterTerminate();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoAfterTerminate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */