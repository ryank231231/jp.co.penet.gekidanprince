package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableObserveOn extends Completable {
  final Scheduler scheduler;
  
  final CompletableSource source;
  
  public CompletableObserveOn(CompletableSource paramCompletableSource, Scheduler paramScheduler) {
    this.source = paramCompletableSource;
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new ObserveOnCompletableObserver(paramCompletableObserver, this.scheduler));
  }
  
  static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    
    final CompletableObserver actual;
    
    Throwable error;
    
    final Scheduler scheduler;
    
    ObserveOnCompletableObserver(CompletableObserver param1CompletableObserver, Scheduler param1Scheduler) {
      this.actual = param1CompletableObserver;
      this.scheduler = param1Scheduler;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
    }
    
    public void onError(Throwable param1Throwable) {
      this.error = param1Throwable;
      DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable))
        this.actual.onSubscribe(this); 
    }
    
    public void run() {
      Throwable throwable = this.error;
      if (throwable != null) {
        this.error = null;
        this.actual.onError(throwable);
      } else {
        this.actual.onComplete();
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableObserveOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */