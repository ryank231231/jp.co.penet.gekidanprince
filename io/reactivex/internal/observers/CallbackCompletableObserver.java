package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Consumer<Throwable>, LambdaConsumerIntrospection {
  private static final long serialVersionUID = -4361286194466301354L;
  
  final Action onComplete;
  
  final Consumer<? super Throwable> onError = this;
  
  public CallbackCompletableObserver(Action paramAction) {
    this.onComplete = paramAction;
  }
  
  public CallbackCompletableObserver(Consumer<? super Throwable> paramConsumer, Action paramAction) {
    this.onComplete = paramAction;
  }
  
  public void accept(Throwable paramThrowable) {
    RxJavaPlugins.onError((Throwable)new OnErrorNotImplementedException(paramThrowable));
  }
  
  public void dispose() {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError() {
    boolean bool;
    if (this.onError != this) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isDisposed() {
    boolean bool;
    if (get() == DisposableHelper.DISPOSED) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onComplete() {
    try {
      this.onComplete.run();
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
    lazySet((Disposable)DisposableHelper.DISPOSED);
  }
  
  public void onError(Throwable paramThrowable) {
    try {
      this.onError.accept(paramThrowable);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
    lazySet((Disposable)DisposableHelper.DISPOSED);
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    DisposableHelper.setOnce(this, paramDisposable);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\CallbackCompletableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */