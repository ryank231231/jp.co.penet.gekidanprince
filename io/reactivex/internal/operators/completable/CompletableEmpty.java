package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class CompletableEmpty extends Completable {
  public static final Completable INSTANCE = new CompletableEmpty();
  
  public void subscribeActual(CompletableObserver paramCompletableObserver) {
    EmptyDisposable.complete(paramCompletableObserver);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */