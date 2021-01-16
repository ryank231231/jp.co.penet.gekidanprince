package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public final class CompletableDelay extends Completable {
  final long delay;
  
  final boolean delayError;
  
  final Scheduler scheduler;
  
  final CompletableSource source;
  
  final TimeUnit unit;
  
  public CompletableDelay(CompletableSource paramCompletableSource, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean) {
    this.source = paramCompletableSource;
    this.delay = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    this.source.subscribe(new Delay(compositeDisposable, paramCompletableObserver));
  }
  
  final class Delay implements CompletableObserver {
    final CompletableObserver s;
    
    private final CompositeDisposable set;
    
    Delay(CompositeDisposable param1CompositeDisposable, CompletableObserver param1CompletableObserver) {
      this.set = param1CompositeDisposable;
      this.s = param1CompletableObserver;
    }
    
    public void onComplete() {
      this.set.add(CompletableDelay.this.scheduler.scheduleDirect(new OnComplete(), CompletableDelay.this.delay, CompletableDelay.this.unit));
    }
    
    public void onError(Throwable param1Throwable) {
      long l;
      CompositeDisposable compositeDisposable = this.set;
      Scheduler scheduler = CompletableDelay.this.scheduler;
      OnError onError = new OnError(param1Throwable);
      if (CompletableDelay.this.delayError) {
        l = CompletableDelay.this.delay;
      } else {
        l = 0L;
      } 
      compositeDisposable.add(scheduler.scheduleDirect(onError, l, CompletableDelay.this.unit));
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.set.add(param1Disposable);
      this.s.onSubscribe((Disposable)this.set);
    }
    
    final class OnComplete implements Runnable {
      public void run() {
        CompletableDelay.Delay.this.s.onComplete();
      }
    }
    
    final class OnError implements Runnable {
      private final Throwable e;
      
      OnError(Throwable param2Throwable) {
        this.e = param2Throwable;
      }
      
      public void run() {
        CompletableDelay.Delay.this.s.onError(this.e);
      }
    }
  }
  
  final class OnComplete implements Runnable {
    public void run() {
      this.this$1.s.onComplete();
    }
  }
  
  final class OnError implements Runnable {
    private final Throwable e;
    
    OnError(Throwable param1Throwable) {
      this.e = param1Throwable;
    }
    
    public void run() {
      this.this$1.s.onError(this.e);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */