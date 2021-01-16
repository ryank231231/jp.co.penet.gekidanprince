package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface SingleOperator<Downstream, Upstream> {
  @NonNull
  SingleObserver<? super Upstream> apply(@NonNull SingleObserver<? super Downstream> paramSingleObserver) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\SingleOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */