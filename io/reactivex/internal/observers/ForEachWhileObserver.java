package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
  private static final long serialVersionUID = -4403180040475402120L;
  
  boolean done;
  
  final Action onComplete;
  
  final Consumer<? super Throwable> onError;
  
  final Predicate<? super T> onNext;
  
  public ForEachWhileObserver(Predicate<? super T> paramPredicate, Consumer<? super Throwable> paramConsumer, Action paramAction) {
    this.onNext = paramPredicate;
    this.onError = paramConsumer;
    this.onComplete = paramAction;
  }
  
  public void dispose() {
    DisposableHelper.dispose(this);
  }
  
  public boolean isDisposed() {
    return DisposableHelper.isDisposed(get());
  }
  
  public void onComplete() {
    if (this.done)
      return; 
    this.done = true;
    try {
      this.onComplete.run();
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
  }
  
  public void onError(Throwable paramThrowable) {
    if (this.done) {
      RxJavaPlugins.onError(paramThrowable);
      return;
    } 
    this.done = true;
    try {
      this.onError.accept(paramThrowable);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { paramThrowable, throwable }));
    } 
  }
  
  public void onNext(T paramT) {
    if (this.done)
      return; 
    try {
      boolean bool = this.onNext.test(paramT);
      if (!bool) {
        dispose();
        onComplete();
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      dispose();
      onError(throwable);
      return;
    } 
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    DisposableHelper.setOnce(this, paramDisposable);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\ForEachWhileObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */