package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class CompletableDoOnEvent extends Completable {
  final Consumer<? super Throwable> onEvent;
  
  final CompletableSource source;
  
  public CompletableDoOnEvent(CompletableSource paramCompletableSource, Consumer<? super Throwable> paramConsumer) {
    this.source = paramCompletableSource;
    this.onEvent = paramConsumer;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new DoOnEvent(paramCompletableObserver));
  }
  
  final class DoOnEvent implements CompletableObserver {
    private final CompletableObserver observer;
    
    DoOnEvent(CompletableObserver param1CompletableObserver) {
      this.observer = param1CompletableObserver;
    }
    
    public void onComplete() {
      try {
        CompletableDoOnEvent.this.onEvent.accept(null);
        this.observer.onComplete();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.observer.onError(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      CompositeException compositeException;
      try {
        CompletableDoOnEvent.this.onEvent.accept(param1Throwable);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        compositeException = new CompositeException(new Throwable[] { param1Throwable, throwable });
      } 
      this.observer.onError((Throwable)compositeException);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.observer.onSubscribe(param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDoOnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */