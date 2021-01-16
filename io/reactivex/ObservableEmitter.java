package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

public interface ObservableEmitter<T> extends Emitter<T> {
  boolean isDisposed();
  
  @NonNull
  ObservableEmitter<T> serialize();
  
  void setCancellable(@Nullable Cancellable paramCancellable);
  
  void setDisposable(@Nullable Disposable paramDisposable);
  
  @Experimental
  boolean tryOnError(@NonNull Throwable paramThrowable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\ObservableEmitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */