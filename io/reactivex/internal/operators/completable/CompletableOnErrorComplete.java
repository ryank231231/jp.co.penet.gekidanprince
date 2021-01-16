package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

public final class CompletableOnErrorComplete extends Completable {
  final Predicate<? super Throwable> predicate;
  
  final CompletableSource source;
  
  public CompletableOnErrorComplete(CompletableSource paramCompletableSource, Predicate<? super Throwable> paramPredicate) {
    this.source = paramCompletableSource;
    this.predicate = paramPredicate;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new OnError(paramCompletableObserver));
  }
  
  final class OnError implements CompletableObserver {
    private final CompletableObserver s;
    
    OnError(CompletableObserver param1CompletableObserver) {
      this.s = param1CompletableObserver;
    }
    
    public void onComplete() {
      this.s.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        boolean bool = CompletableOnErrorComplete.this.predicate.test(param1Throwable);
        if (bool) {
          this.s.onComplete();
        } else {
          this.s.onError(param1Throwable);
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.s.onSubscribe(param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableOnErrorComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */