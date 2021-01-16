package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamCompletableSource;

public final class MaybeFromCompletable<T> extends Maybe<T> implements HasUpstreamCompletableSource {
  final CompletableSource source;
  
  public MaybeFromCompletable(CompletableSource paramCompletableSource) {
    this.source = paramCompletableSource;
  }
  
  public CompletableSource source() {
    return this.source;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new FromCompletableObserver<T>(paramMaybeObserver));
  }
  
  static final class FromCompletableObserver<T> implements CompletableObserver, Disposable {
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    FromCompletableObserver(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
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
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFromCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */