package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

@Experimental
public final class MaybeDoAfterSuccess<T> extends AbstractMaybeWithUpstream<T, T> {
  final Consumer<? super T> onAfterSuccess;
  
  public MaybeDoAfterSuccess(MaybeSource<T> paramMaybeSource, Consumer<? super T> paramConsumer) {
    super(paramMaybeSource);
    this.onAfterSuccess = paramConsumer;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new DoAfterObserver<T>(paramMaybeObserver, this.onAfterSuccess));
  }
  
  static final class DoAfterObserver<T> implements MaybeObserver<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    final Consumer<? super T> onAfterSuccess;
    
    DoAfterObserver(MaybeObserver<? super T> param1MaybeObserver, Consumer<? super T> param1Consumer) {
      this.actual = param1MaybeObserver;
      this.onAfterSuccess = param1Consumer;
    }
    
    public void dispose() {
      this.d.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
      try {
        this.onAfterSuccess.accept(param1T);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDoAfterSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */