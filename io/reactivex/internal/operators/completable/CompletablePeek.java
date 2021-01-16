package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletablePeek extends Completable {
  final Action onAfterTerminate;
  
  final Action onComplete;
  
  final Action onDispose;
  
  final Consumer<? super Throwable> onError;
  
  final Consumer<? super Disposable> onSubscribe;
  
  final Action onTerminate;
  
  final CompletableSource source;
  
  public CompletablePeek(CompletableSource paramCompletableSource, Consumer<? super Disposable> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4) {
    this.source = paramCompletableSource;
    this.onSubscribe = paramConsumer;
    this.onError = paramConsumer1;
    this.onComplete = paramAction1;
    this.onTerminate = paramAction2;
    this.onAfterTerminate = paramAction3;
    this.onDispose = paramAction4;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new CompletableObserverImplementation(paramCompletableObserver));
  }
  
  final class CompletableObserverImplementation implements CompletableObserver, Disposable {
    final CompletableObserver actual;
    
    Disposable d;
    
    CompletableObserverImplementation(CompletableObserver param1CompletableObserver) {
      this.actual = param1CompletableObserver;
    }
    
    public void dispose() {
      try {
        CompletablePeek.this.onDispose.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
      this.d.dispose();
    }
    
    void doAfter() {
      try {
        CompletablePeek.this.onAfterTerminate.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      if (this.d == DisposableHelper.DISPOSED)
        return; 
      try {
        CompletablePeek.this.onComplete.run();
        CompletablePeek.this.onTerminate.run();
        this.actual.onComplete();
        doAfter();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      CompositeException compositeException;
      if (this.d == DisposableHelper.DISPOSED) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      try {
        CompletablePeek.this.onError.accept(param1Throwable);
        CompletablePeek.this.onTerminate.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        compositeException = new CompositeException(new Throwable[] { param1Throwable, throwable });
      } 
      this.actual.onError((Throwable)compositeException);
      doAfter();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      try {
        CompletablePeek.this.onSubscribe.accept(param1Disposable);
        if (DisposableHelper.validate(this.d, param1Disposable)) {
          this.d = param1Disposable;
          this.actual.onSubscribe(this);
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        param1Disposable.dispose();
        this.d = (Disposable)DisposableHelper.DISPOSED;
        EmptyDisposable.error(throwable, this.actual);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletablePeek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */