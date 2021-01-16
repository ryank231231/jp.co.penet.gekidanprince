package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer extends Completable {
  final long delay;
  
  final Scheduler scheduler;
  
  final TimeUnit unit;
  
  public CompletableTimer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {
    this.delay = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    TimerDisposable timerDisposable = new TimerDisposable(paramCompletableObserver);
    paramCompletableObserver.onSubscribe(timerDisposable);
    timerDisposable.setFuture(this.scheduler.scheduleDirect(timerDisposable, this.delay, this.unit));
  }
  
  static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
    private static final long serialVersionUID = 3167244060586201109L;
    
    final CompletableObserver actual;
    
    TimerDisposable(CompletableObserver param1CompletableObserver) {
      this.actual = param1CompletableObserver;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void run() {
      this.actual.onComplete();
    }
    
    void setFuture(Disposable param1Disposable) {
      DisposableHelper.replace(this, param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */