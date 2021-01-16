package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class CompletableHide extends Completable {
  final CompletableSource source;
  
  public CompletableHide(CompletableSource paramCompletableSource) {
    this.source = paramCompletableSource;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new HideCompletableObserver(paramCompletableObserver));
  }
  
  static final class HideCompletableObserver implements CompletableObserver, Disposable {
    final CompletableObserver actual;
    
    Disposable d;
    
    HideCompletableObserver(CompletableObserver param1CompletableObserver) {
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
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableHide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */