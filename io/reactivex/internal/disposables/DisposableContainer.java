package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

public interface DisposableContainer {
  boolean add(Disposable paramDisposable);
  
  boolean delete(Disposable paramDisposable);
  
  boolean remove(Disposable paramDisposable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\disposables\DisposableContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */