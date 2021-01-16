package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public interface SingleObserver<T> {
  void onError(@NonNull Throwable paramThrowable);
  
  void onSubscribe(@NonNull Disposable paramDisposable);
  
  void onSuccess(@NonNull T paramT);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\SingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */