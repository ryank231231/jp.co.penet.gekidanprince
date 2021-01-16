package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {
  final BiConsumer<? super T, ? super Throwable> onEvent;
  
  public MaybeDoOnEvent(MaybeSource<T> paramMaybeSource, BiConsumer<? super T, ? super Throwable> paramBiConsumer) {
    super(paramMaybeSource);
    this.onEvent = paramBiConsumer;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new DoOnEventMaybeObserver<T>(paramMaybeObserver, this.onEvent));
  }
  
  static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    final BiConsumer<? super T, ? super Throwable> onEvent;
    
    DoOnEventMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, BiConsumer<? super T, ? super Throwable> param1BiConsumer) {
      this.actual = param1MaybeObserver;
      this.onEvent = param1BiConsumer;
    }
    
    public void dispose() {
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      try {
        this.onEvent.accept(null, null);
        this.actual.onComplete();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      CompositeException compositeException;
      this.d = (Disposable)DisposableHelper.DISPOSED;
      try {
        this.onEvent.accept(null, param1Throwable);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        compositeException = new CompositeException(new Throwable[] { param1Throwable, throwable });
      } 
      this.actual.onError((Throwable)compositeException);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      try {
        this.onEvent.accept(param1T, null);
        this.actual.onSuccess(param1T);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDoOnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */