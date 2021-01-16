package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface CompletableTransformer {
  @NonNull
  CompletableSource apply(@NonNull Completable paramCompletable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\CompletableTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */