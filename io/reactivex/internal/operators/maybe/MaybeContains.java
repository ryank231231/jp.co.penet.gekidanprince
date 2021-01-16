package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {
  final MaybeSource<T> source;
  
  final Object value;
  
  public MaybeContains(MaybeSource<T> paramMaybeSource, Object paramObject) {
    this.source = paramMaybeSource;
    this.value = paramObject;
  }
  
  public MaybeSource<T> source() {
    return this.source;
  }
  
  protected void subscribeActual(SingleObserver<? super Boolean> paramSingleObserver) {
    this.source.subscribe(new ContainsMaybeObserver(paramSingleObserver, this.value));
  }
  
  static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {
    final SingleObserver<? super Boolean> actual;
    
    Disposable d;
    
    final Object value;
    
    ContainsMaybeObserver(SingleObserver<? super Boolean> param1SingleObserver, Object param1Object) {
      this.actual = param1SingleObserver;
      this.value = param1Object;
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
      this.actual.onSuccess(Boolean.valueOf(false));
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
      this.actual.onSuccess(Boolean.valueOf(ObjectHelper.equals(param1Object, this.value)));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeContains.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */