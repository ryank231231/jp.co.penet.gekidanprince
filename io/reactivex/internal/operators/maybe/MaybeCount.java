package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {
  final MaybeSource<T> source;
  
  public MaybeCount(MaybeSource<T> paramMaybeSource) {
    this.source = paramMaybeSource;
  }
  
  public MaybeSource<T> source() {
    return this.source;
  }
  
  protected void subscribeActual(SingleObserver<? super Long> paramSingleObserver) {
    this.source.subscribe(new CountMaybeObserver(paramSingleObserver));
  }
  
  static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {
    final SingleObserver<? super Long> actual;
    
    Disposable d;
    
    CountMaybeObserver(SingleObserver<? super Long> param1SingleObserver) {
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
      this.actual.onSuccess(Long.valueOf(0L));
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
    
    public void onSuccess(Object param1Object) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onSuccess(Long.valueOf(1L));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */