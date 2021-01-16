package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {
  final Scheduler scheduler;
  
  final TimeUnit unit;
  
  public ObservableTimeInterval(ObservableSource<T> paramObservableSource, TimeUnit paramTimeUnit, Scheduler paramScheduler) {
    super(paramObservableSource);
    this.scheduler = paramScheduler;
    this.unit = paramTimeUnit;
  }
  
  public void subscribeActual(Observer<? super Timed<T>> paramObserver) {
    this.source.subscribe(new TimeIntervalObserver<T>(paramObserver, this.unit, this.scheduler));
  }
  
  static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {
    final Observer<? super Timed<T>> actual;
    
    long lastTime;
    
    Disposable s;
    
    final Scheduler scheduler;
    
    final TimeUnit unit;
    
    TimeIntervalObserver(Observer<? super Timed<T>> param1Observer, TimeUnit param1TimeUnit, Scheduler param1Scheduler) {
      this.actual = param1Observer;
      this.scheduler = param1Scheduler;
      this.unit = param1TimeUnit;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      long l1 = this.scheduler.now(this.unit);
      long l2 = this.lastTime;
      this.lastTime = l1;
      this.actual.onNext(new Timed(param1T, l1 - l2, this.unit));
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.lastTime = this.scheduler.now(this.unit);
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTimeInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */