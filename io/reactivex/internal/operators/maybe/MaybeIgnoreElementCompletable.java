package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {
  final MaybeSource<T> source;
  
  public MaybeIgnoreElementCompletable(MaybeSource<T> paramMaybeSource) {
    this.source = paramMaybeSource;
  }
  
  public Maybe<T> fuseToMaybe() {
    return RxJavaPlugins.onAssembly(new MaybeIgnoreElement<T>(this.source));
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new IgnoreMaybeObserver(paramCompletableObserver));
  }
  
  static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    final CompletableObserver actual;
    
    Disposable d;
    
    IgnoreMaybeObserver(CompletableObserver param1CompletableObserver) {
      this.actual = param1CompletableObserver;
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
      this.actual.onComplete();
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
      this.actual.onComplete();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeIgnoreElementCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */