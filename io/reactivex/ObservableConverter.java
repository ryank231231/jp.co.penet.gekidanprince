package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
public interface ObservableConverter<T, R> {
  @NonNull
  R apply(@NonNull Observable<T> paramObservable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\ObservableConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */