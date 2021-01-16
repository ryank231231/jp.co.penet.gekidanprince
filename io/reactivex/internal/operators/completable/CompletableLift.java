package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableLift extends Completable {
  final CompletableOperator onLift;
  
  final CompletableSource source;
  
  public CompletableLift(CompletableSource paramCompletableSource, CompletableOperator paramCompletableOperator) {
    this.source = paramCompletableSource;
    this.onLift = paramCompletableOperator;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    try {
      paramCompletableObserver = this.onLift.apply(paramCompletableObserver);
      this.source.subscribe(paramCompletableObserver);
      return;
    } catch (NullPointerException nullPointerException) {
      throw nullPointerException;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */