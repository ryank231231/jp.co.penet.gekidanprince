package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface Emitter<T> {
  void onComplete();
  
  void onError(@NonNull Throwable paramThrowable);
  
  void onNext(@NonNull T paramT);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\Emitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */