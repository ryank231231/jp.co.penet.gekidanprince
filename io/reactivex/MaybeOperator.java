package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface MaybeOperator<Downstream, Upstream> {
  @NonNull
  MaybeObserver<? super Upstream> apply(@NonNull MaybeObserver<? super Downstream> paramMaybeObserver) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\MaybeOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */