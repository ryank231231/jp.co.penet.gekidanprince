package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {
  public MaybeDetach(MaybeSource<T> paramMaybeSource) {
    super(paramMaybeSource);
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new DetachMaybeObserver<T>(paramMaybeObserver));
  }
  
  static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    MaybeObserver<? super T> actual;
    
    Disposable d;
    
    DetachMaybeObserver(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
    }
    
    public void dispose() {
      this.actual = null;
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      MaybeObserver<? super T> maybeObserver = this.actual;
      if (maybeObserver != null) {
        this.actual = null;
        maybeObserver.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      MaybeObserver<? super T> maybeObserver = this.actual;
      if (maybeObserver != null) {
        this.actual = null;
        maybeObserver.onError(param1Throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      MaybeObserver<? super T> maybeObserver = this.actual;
      if (maybeObserver != null) {
        this.actual = null;
        maybeObserver.onSuccess(param1T);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDetach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */