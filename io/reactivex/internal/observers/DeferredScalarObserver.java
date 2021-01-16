package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
  private static final long serialVersionUID = -266195175408988651L;
  
  protected Disposable s;
  
  public DeferredScalarObserver(Observer<? super R> paramObserver) {
    super(paramObserver);
  }
  
  public void dispose() {
    super.dispose();
    this.s.dispose();
  }
  
  public void onComplete() {
    R r = this.value;
    if (r != null) {
      this.value = null;
      complete(r);
    } else {
      complete();
    } 
  }
  
  public void onError(Throwable paramThrowable) {
    this.value = null;
    error(paramThrowable);
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    if (DisposableHelper.validate(this.s, paramDisposable)) {
      this.s = paramDisposable;
      this.actual.onSubscribe((Disposable)this);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\DeferredScalarObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */