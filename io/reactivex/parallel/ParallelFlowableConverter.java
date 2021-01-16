package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
public interface ParallelFlowableConverter<T, R> {
  @NonNull
  R apply(@NonNull ParallelFlowable<T> paramParallelFlowable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\parallel\ParallelFlowableConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */