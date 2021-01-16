package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
  private static final long serialVersionUID = 6537757548749041217L;
  
  ReferenceDisposable(T paramT) {
    super((T)ObjectHelper.requireNonNull(paramT, "value is null"));
  }
  
  public final void dispose() {
    if (get() != null) {
      T t = getAndSet(null);
      if (t != null)
        onDisposed(t); 
    } 
  }
  
  public final boolean isDisposed() {
    boolean bool;
    if (get() == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  protected abstract void onDisposed(@NonNull T paramT);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\disposables\ReferenceDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */