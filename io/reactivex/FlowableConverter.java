package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
public interface FlowableConverter<T, R> {
  @NonNull
  R apply(@NonNull Flowable<T> paramFlowable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\FlowableConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */