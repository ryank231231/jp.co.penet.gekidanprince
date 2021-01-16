package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T>, FuseToMaybe<Boolean> {
  final MaybeSource<T> source;
  
  public MaybeIsEmptySingle(MaybeSource<T> paramMaybeSource) {
    this.source = paramMaybeSource;
  }
  
  public Maybe<Boolean> fuseToMaybe() {
    return RxJavaPlugins.onAssembly(new MaybeIsEmpty<T>(this.source));
  }
  
  public MaybeSource<T> source() {
    return this.source;
  }
  
  protected void subscribeActual(SingleObserver<? super Boolean> paramSingleObserver) {
    this.source.subscribe(new IsEmptyMaybeObserver(paramSingleObserver));
  }
  
  static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    final SingleObserver<? super Boolean> actual;
    
    Disposable d;
    
    IsEmptyMaybeObserver(SingleObserver<? super Boolean> param1SingleObserver) {
      this.actual = param1SingleObserver;
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
      this.actual.onSuccess(Boolean.valueOf(true));
    }
    
    public void onError(Throwable param1Throwable) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onSuccess(Boolean.valueOf(false));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeIsEmptySingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */