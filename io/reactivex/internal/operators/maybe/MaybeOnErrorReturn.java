package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeOnErrorReturn<T> extends AbstractMaybeWithUpstream<T, T> {
  final Function<? super Throwable, ? extends T> valueSupplier;
  
  public MaybeOnErrorReturn(MaybeSource<T> paramMaybeSource, Function<? super Throwable, ? extends T> paramFunction) {
    super(paramMaybeSource);
    this.valueSupplier = paramFunction;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new OnErrorReturnMaybeObserver<T>(paramMaybeObserver, this.valueSupplier));
  }
  
  static final class OnErrorReturnMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    final Function<? super Throwable, ? extends T> valueSupplier;
    
    OnErrorReturnMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, Function<? super Throwable, ? extends T> param1Function) {
      this.actual = param1MaybeObserver;
      this.valueSupplier = param1Function;
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
      try {
        Object object = ObjectHelper.requireNonNull(this.valueSupplier.apply(param1Throwable), "The valueSupplier returned a null value");
        this.actual.onSuccess(object);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeOnErrorReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */