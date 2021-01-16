package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface ObservableTransformer<Upstream, Downstream> {
  @NonNull
  ObservableSource<Downstream> apply(@NonNull Observable<Upstream> paramObservable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\ObservableTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */