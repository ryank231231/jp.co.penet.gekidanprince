package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableDisposeOn extends Completable {
  final Scheduler scheduler;
  
  final CompletableSource source;
  
  public CompletableDisposeOn(CompletableSource paramCompletableSource, Scheduler paramScheduler) {
    this.source = paramCompletableSource;
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new CompletableObserverImplementation(paramCompletableObserver, this.scheduler));
  }
  
  static final class CompletableObserverImplementation implements CompletableObserver, Disposable, Runnable {
    Disposable d;
    
    volatile boolean disposed;
    
    final CompletableObserver s;
    
    final Scheduler scheduler;
    
    CompletableObserverImplementation(CompletableObserver param1CompletableObserver, Scheduler param1Scheduler) {
      this.s = param1CompletableObserver;
      this.scheduler = param1Scheduler;
    }
    
    public void dispose() {
      this.disposed = true;
      this.scheduler.scheduleDirect(this);
    }
    
    public boolean isDisposed() {
      return this.disposed;
    }
    
    public void onComplete() {
      if (this.disposed)
        return; 
      this.s.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.disposed) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.s.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.s.onSubscribe(this);
      } 
    }
    
    public void run() {
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDisposeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */