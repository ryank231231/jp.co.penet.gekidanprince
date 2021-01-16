package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {
  final Function<? super T, ? extends R> mapper;
  
  public MaybeMap(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends R> paramFunction) {
    super(paramMaybeSource);
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(MaybeObserver<? super R> paramMaybeObserver) {
    this.source.subscribe(new MapMaybeObserver<T, R>(paramMaybeObserver, this.mapper));
  }
  
  static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {
    final MaybeObserver<? super R> actual;
    
    Disposable d;
    
    final Function<? super T, ? extends R> mapper;
    
    MapMaybeObserver(MaybeObserver<? super R> param1MaybeObserver, Function<? super T, ? extends R> param1Function) {
      this.actual = param1MaybeObserver;
      this.mapper = param1Function;
    }
    
    public void dispose() {
      Disposable disposable = this.d;
      this.d = (Disposable)DisposableHelper.DISPOSED;
      disposable.dispose();
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
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null item");
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */