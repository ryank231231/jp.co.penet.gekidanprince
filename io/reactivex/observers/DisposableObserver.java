package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableObserver<T> implements Observer<T>, Disposable {
  final AtomicReference<Disposable> s = new AtomicReference<Disposable>();
  
  public final void dispose() {
    DisposableHelper.dispose(this.s);
  }
  
  public final boolean isDisposed() {
    boolean bool;
    if (this.s.get() == DisposableHelper.DISPOSED) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  protected void onStart() {}
  
  public final void onSubscribe(@NonNull Disposable paramDisposable) {
    if (EndConsumerHelper.setOnce(this.s, paramDisposable, getClass()))
      onStart(); 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\observers\DisposableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */