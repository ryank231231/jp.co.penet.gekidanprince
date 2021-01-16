package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimer extends Maybe<Long> {
  final long delay;
  
  final Scheduler scheduler;
  
  final TimeUnit unit;
  
  public MaybeTimer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {
    this.delay = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(MaybeObserver<? super Long> paramMaybeObserver) {
    TimerDisposable timerDisposable = new TimerDisposable(paramMaybeObserver);
    paramMaybeObserver.onSubscribe(timerDisposable);
    timerDisposable.setFuture(this.scheduler.scheduleDirect(timerDisposable, this.delay, this.unit));
  }
  
  static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
    private static final long serialVersionUID = 2875964065294031672L;
    
    final MaybeObserver<? super Long> actual;
    
    TimerDisposable(MaybeObserver<? super Long> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void run() {
      this.actual.onSuccess(Long.valueOf(0L));
    }
    
    void setFuture(Disposable param1Disposable) {
      DisposableHelper.replace(this, param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */