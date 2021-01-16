package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

@Experimental
public final class SingleDoFinally<T> extends Single<T> {
  final Action onFinally;
  
  final SingleSource<T> source;
  
  public SingleDoFinally(SingleSource<T> paramSingleSource, Action paramAction) {
    this.source = paramSingleSource;
    this.onFinally = paramAction;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new DoFinallyObserver<T>(paramSingleObserver, this.onFinally));
  }
  
  static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    
    final SingleObserver<? super T> actual;
    
    Disposable d;
    
    final Action onFinally;
    
    DoFinallyObserver(SingleObserver<? super T> param1SingleObserver, Action param1Action) {
      this.actual = param1SingleObserver;
      this.onFinally = param1Action;
    }
    
    public void dispose() {
      this.d.dispose();
      runFinally();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
      runFinally();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
      runFinally();
    }
    
    void runFinally() {
      if (compareAndSet(0, 1))
        try {
          this.onFinally.run();
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        }  
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */