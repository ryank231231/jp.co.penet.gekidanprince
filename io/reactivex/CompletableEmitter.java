package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

public interface CompletableEmitter {
  boolean isDisposed();
  
  void onComplete();
  
  void onError(@NonNull Throwable paramThrowable);
  
  void setCancellable(@Nullable Cancellable paramCancellable);
  
  void setDisposable(@Nullable Disposable paramDisposable);
  
  @Experimental
  boolean tryOnError(@NonNull Throwable paramThrowable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\CompletableEmitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */