package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
public interface ParallelTransformer<Upstream, Downstream> {
  @NonNull
  ParallelFlowable<Downstream> apply(@NonNull ParallelFlowable<Upstream> paramParallelFlowable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\parallel\ParallelTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */