package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
  final Observer<? super T> actual;
  
  final Action onDispose;
  
  final Consumer<? super Disposable> onSubscribe;
  
  Disposable s;
  
  public DisposableLambdaObserver(Observer<? super T> paramObserver, Consumer<? super Disposable> paramConsumer, Action paramAction) {
    this.actual = paramObserver;
    this.onSubscribe = paramConsumer;
    this.onDispose = paramAction;
  }
  
  public void dispose() {
    try {
      this.onDispose.run();
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
    this.s.dispose();
  }
  
  public boolean isDisposed() {
    return this.s.isDisposed();
  }
  
  public void onComplete() {
    if (this.s != DisposableHelper.DISPOSED)
      this.actual.onComplete(); 
  }
  
  public void onError(Throwable paramThrowable) {
    if (this.s != DisposableHelper.DISPOSED) {
      this.actual.onError(paramThrowable);
    } else {
      RxJavaPlugins.onError(paramThrowable);
    } 
  }
  
  public void onNext(T paramT) {
    this.actual.onNext(paramT);
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    try {
      this.onSubscribe.accept(paramDisposable);
      if (DisposableHelper.validate(this.s, paramDisposable)) {
        this.s = paramDisposable;
        this.actual.onSubscribe(this);
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      paramDisposable.dispose();
      this.s = (Disposable)DisposableHelper.DISPOSED;
      EmptyDisposable.error(throwable, this.actual);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\DisposableLambdaObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */