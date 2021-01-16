package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface ObservableOperator<Downstream, Upstream> {
  @NonNull
  Observer<? super Upstream> apply(@NonNull Observer<? super Downstream> paramObserver) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\ObservableOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */