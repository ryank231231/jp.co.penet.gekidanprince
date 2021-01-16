package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
  private static final long serialVersionUID = -8612022020200669122L;
  
  final Observer<? super T> actual;
  
  final AtomicReference<Disposable> subscription = new AtomicReference<Disposable>();
  
  public ObserverResourceWrapper(Observer<? super T> paramObserver) {
    this.actual = paramObserver;
  }
  
  public void dispose() {
    DisposableHelper.dispose(this.subscription);
    DisposableHelper.dispose(this);
  }
  
  public boolean isDisposed() {
    boolean bool;
    if (this.subscription.get() == DisposableHelper.DISPOSED) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onComplete() {
    dispose();
    this.actual.onComplete();
  }
  
  public void onError(Throwable paramThrowable) {
    dispose();
    this.actual.onError(paramThrowable);
  }
  
  public void onNext(T paramT) {
    this.actual.onNext(paramT);
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    if (DisposableHelper.setOnce(this.subscription, paramDisposable))
      this.actual.onSubscribe(this); 
  }
  
  public void setResource(Disposable paramDisposable) {
    DisposableHelper.set(this, paramDisposable);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObserverResourceWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */