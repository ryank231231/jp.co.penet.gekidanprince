package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeIsEmpty<T> extends AbstractMaybeWithUpstream<T, Boolean> {
  public MaybeIsEmpty(MaybeSource<T> paramMaybeSource) {
    super(paramMaybeSource);
  }
  
  protected void subscribeActual(MaybeObserver<? super Boolean> paramMaybeObserver) {
    this.source.subscribe(new IsEmptyMaybeObserver(paramMaybeObserver));
  }
  
  static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    final MaybeObserver<? super Boolean> actual;
    
    Disposable d;
    
    IsEmptyMaybeObserver(MaybeObserver<? super Boolean> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
    }
    
    public void dispose() {
      this.d.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onSuccess(Boolean.valueOf(true));
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
      this.actual.onSuccess(Boolean.valueOf(false));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeIsEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */