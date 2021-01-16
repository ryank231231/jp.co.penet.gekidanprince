package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface SingleTransformer<Upstream, Downstream> {
  @NonNull
  SingleSource<Downstream> apply(@NonNull Single<Upstream> paramSingle);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\SingleTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */