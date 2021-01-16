package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamSingleSource;

public final class MaybeFromSingle<T> extends Maybe<T> implements HasUpstreamSingleSource<T> {
  final SingleSource<T> source;
  
  public MaybeFromSingle(SingleSource<T> paramSingleSource) {
    this.source = paramSingleSource;
  }
  
  public SingleSource<T> source() {
    return this.source;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new FromSingleObserver<T>(paramMaybeObserver));
  }
  
  static final class FromSingleObserver<T> implements SingleObserver<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    FromSingleObserver(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
    }
    
    public void dispose() {
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
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
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFromSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */