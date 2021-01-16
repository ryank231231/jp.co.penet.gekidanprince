package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
  private Disposable s;
  
  protected final void cancel() {
    Disposable disposable = this.s;
    this.s = (Disposable)DisposableHelper.DISPOSED;
    disposable.dispose();
  }
  
  protected void onStart() {}
  
  public final void onSubscribe(@NonNull Disposable paramDisposable) {
    if (EndConsumerHelper.validate(this.s, paramDisposable, getClass())) {
      this.s = paramDisposable;
      onStart();
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\observers\DefaultObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */