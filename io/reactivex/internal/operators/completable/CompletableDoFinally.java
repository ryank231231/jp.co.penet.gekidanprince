package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

@Experimental
public final class CompletableDoFinally extends Completable {
  final Action onFinally;
  
  final CompletableSource source;
  
  public CompletableDoFinally(CompletableSource paramCompletableSource, Action paramAction) {
    this.source = paramCompletableSource;
    this.onFinally = paramAction;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new DoFinallyObserver(paramCompletableObserver, this.onFinally));
  }
  
  static final class DoFinallyObserver extends AtomicInteger implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    
    final CompletableObserver actual;
    
    Disposable d;
    
    final Action onFinally;
    
    DoFinallyObserver(CompletableObserver param1CompletableObserver, Action param1Action) {
      this.actual = param1CompletableObserver;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */