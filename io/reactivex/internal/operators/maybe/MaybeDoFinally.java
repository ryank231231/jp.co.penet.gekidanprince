package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

@Experimental
public final class MaybeDoFinally<T> extends AbstractMaybeWithUpstream<T, T> {
  final Action onFinally;
  
  public MaybeDoFinally(MaybeSource<T> paramMaybeSource, Action paramAction) {
    super(paramMaybeSource);
    this.onFinally = paramAction;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new DoFinallyObserver<T>(paramMaybeObserver, this.onFinally));
  }
  
  static final class DoFinallyObserver<T> extends AtomicInteger implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    final Action onFinally;
    
    DoFinallyObserver(MaybeObserver<? super T> param1MaybeObserver, Action param1Action) {
      this.actual = param1MaybeObserver;
      this.onFinally = param1Action;
    }
    
    public void dispose() {
      this.d.dispose();
      runFinally();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
      runFinally();
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */