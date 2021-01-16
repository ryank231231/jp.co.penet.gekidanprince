package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
  private static final long serialVersionUID = 4943102778943297569L;
  
  final BiConsumer<? super T, ? super Throwable> onCallback;
  
  public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> paramBiConsumer) {
    this.onCallback = paramBiConsumer;
  }
  
  public void dispose() {
    DisposableHelper.dispose(this);
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
    try {
      lazySet((Disposable)DisposableHelper.DISPOSED);
      this.onCallback.accept(null, paramThrowable);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { paramThrowable, throwable }));
    } 
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    DisposableHelper.setOnce(this, paramDisposable);
  }
  
  public void onSuccess(T paramT) {
    try {
      lazySet((Disposable)DisposableHelper.DISPOSED);
      this.onCallback.accept(paramT, null);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\BiConsumerSingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */