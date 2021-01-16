package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
public final class CompletableDetach extends Completable {
  final CompletableSource source;
  
  public CompletableDetach(CompletableSource paramCompletableSource) {
    this.source = paramCompletableSource;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new DetachCompletableObserver(paramCompletableObserver));
  }
  
  static final class DetachCompletableObserver implements CompletableObserver, Disposable {
    CompletableObserver actual;
    
    Disposable d;
    
    DetachCompletableObserver(CompletableObserver param1CompletableObserver) {
      this.actual = param1CompletableObserver;
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
      CompletableObserver completableObserver = this.actual;
      if (completableObserver != null) {
        this.actual = null;
        completableObserver.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      CompletableObserver completableObserver = this.actual;
      if (completableObserver != null) {
        this.actual = null;
        completableObserver.onError(param1Throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDetach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */