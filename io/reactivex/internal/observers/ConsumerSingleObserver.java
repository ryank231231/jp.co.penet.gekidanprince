package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, LambdaConsumerIntrospection {
  private static final long serialVersionUID = -7012088219455310787L;
  
  final Consumer<? super Throwable> onError;
  
  final Consumer<? super T> onSuccess;
  
  public ConsumerSingleObserver(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1) {
    this.onSuccess = paramConsumer;
    this.onError = paramConsumer1;
  }
  
  public void dispose() {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError() {
    boolean bool;
    if (this.onError != Functions.ON_ERROR_MISSING) {
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
  
  public void onError(Throwable paramThrowable) {
    lazySet((Disposable)DisposableHelper.DISPOSED);
    try {
      this.onError.accept(paramThrowable);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { paramThrowable, throwable }));
    } 
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    DisposableHelper.setOnce(this, paramDisposable);
  }
  
  public void onSuccess(T paramT) {
    lazySet((Disposable)DisposableHelper.DISPOSED);
    try {
      this.onSuccess.accept(paramT);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\ConsumerSingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */