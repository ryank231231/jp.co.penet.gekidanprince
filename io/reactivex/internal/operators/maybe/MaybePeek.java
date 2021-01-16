package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
  final Action onAfterTerminate;
  
  final Action onCompleteCall;
  
  final Action onDisposeCall;
  
  final Consumer<? super Throwable> onErrorCall;
  
  final Consumer<? super Disposable> onSubscribeCall;
  
  final Consumer<? super T> onSuccessCall;
  
  public MaybePeek(MaybeSource<T> paramMaybeSource, Consumer<? super Disposable> paramConsumer, Consumer<? super T> paramConsumer1, Consumer<? super Throwable> paramConsumer2, Action paramAction1, Action paramAction2, Action paramAction3) {
    super(paramMaybeSource);
    this.onSubscribeCall = paramConsumer;
    this.onSuccessCall = paramConsumer1;
    this.onErrorCall = paramConsumer2;
    this.onCompleteCall = paramAction1;
    this.onAfterTerminate = paramAction2;
    this.onDisposeCall = paramAction3;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new MaybePeekObserver<T>(paramMaybeObserver, this));
  }
  
  static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    final MaybePeek<T> parent;
    
    MaybePeekObserver(MaybeObserver<? super T> param1MaybeObserver, MaybePeek<T> param1MaybePeek) {
      this.actual = param1MaybeObserver;
      this.parent = param1MaybePeek;
    }
    
    public void dispose() {
      try {
        this.parent.onDisposeCall.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    void onAfterTerminate() {
      try {
        this.parent.onAfterTerminate.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
    
    public void onComplete() {
      if (this.d == DisposableHelper.DISPOSED)
        return; 
      try {
        this.parent.onCompleteCall.run();
        this.d = (Disposable)DisposableHelper.DISPOSED;
        this.actual.onComplete();
        onAfterTerminate();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onErrorInner(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.d == DisposableHelper.DISPOSED) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      onErrorInner(param1Throwable);
    }
    
    void onErrorInner(Throwable param1Throwable) {
      CompositeException compositeException;
      try {
        this.parent.onErrorCall.accept(param1Throwable);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        compositeException = new CompositeException(new Throwable[] { param1Throwable, throwable });
      } 
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onError((Throwable)compositeException);
      onAfterTerminate();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable))
        try {
          this.parent.onSubscribeCall.accept(param1Disposable);
          this.d = param1Disposable;
          this.actual.onSubscribe(this);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          param1Disposable.dispose();
          this.d = (Disposable)DisposableHelper.DISPOSED;
          EmptyDisposable.error(throwable, this.actual);
          return;
        }  
    }
    
    public void onSuccess(T param1T) {
      if (this.d == DisposableHelper.DISPOSED)
        return; 
      try {
        this.parent.onSuccessCall.accept(param1T);
        this.d = (Disposable)DisposableHelper.DISPOSED;
        this.actual.onSuccess(param1T);
        onAfterTerminate();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onErrorInner(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybePeek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */