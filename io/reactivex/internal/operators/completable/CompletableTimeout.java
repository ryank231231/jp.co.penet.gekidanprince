package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableTimeout extends Completable {
  final CompletableSource other;
  
  final Scheduler scheduler;
  
  final CompletableSource source;
  
  final long timeout;
  
  final TimeUnit unit;
  
  public CompletableTimeout(CompletableSource paramCompletableSource1, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, CompletableSource paramCompletableSource2) {
    this.source = paramCompletableSource1;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.other = paramCompletableSource2;
  }
  
  public void subscribeActual(CompletableObserver paramCompletableObserver) {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    paramCompletableObserver.onSubscribe((Disposable)compositeDisposable);
    AtomicBoolean atomicBoolean = new AtomicBoolean();
    compositeDisposable.add(this.scheduler.scheduleDirect(new DisposeTask(atomicBoolean, compositeDisposable, paramCompletableObserver), this.timeout, this.unit));
    this.source.subscribe(new TimeOutObserver(compositeDisposable, atomicBoolean, paramCompletableObserver));
  }
  
  final class DisposeTask implements Runnable {
    private final AtomicBoolean once;
    
    final CompletableObserver s;
    
    final CompositeDisposable set;
    
    DisposeTask(AtomicBoolean param1AtomicBoolean, CompositeDisposable param1CompositeDisposable, CompletableObserver param1CompletableObserver) {
      this.once = param1AtomicBoolean;
      this.set = param1CompositeDisposable;
      this.s = param1CompletableObserver;
    }
    
    public void run() {
      if (this.once.compareAndSet(false, true)) {
        this.set.clear();
        if (CompletableTimeout.this.other == null) {
          this.s.onError(new TimeoutException());
        } else {
          CompletableTimeout.this.other.subscribe(new DisposeObserver());
        } 
      } 
    }
    
    final class DisposeObserver implements CompletableObserver {
      public void onComplete() {
        CompletableTimeout.DisposeTask.this.set.dispose();
        CompletableTimeout.DisposeTask.this.s.onComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        CompletableTimeout.DisposeTask.this.set.dispose();
        CompletableTimeout.DisposeTask.this.s.onError(param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        CompletableTimeout.DisposeTask.this.set.add(param2Disposable);
      }
    }
  }
  
  final class DisposeObserver implements CompletableObserver {
    public void onComplete() {
      this.this$1.set.dispose();
      this.this$1.s.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.this$1.set.dispose();
      this.this$1.s.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.this$1.set.add(param1Disposable);
    }
  }
  
  static final class TimeOutObserver implements CompletableObserver {
    private final AtomicBoolean once;
    
    private final CompletableObserver s;
    
    private final CompositeDisposable set;
    
    TimeOutObserver(CompositeDisposable param1CompositeDisposable, AtomicBoolean param1AtomicBoolean, CompletableObserver param1CompletableObserver) {
      this.set = param1CompositeDisposable;
      this.once = param1AtomicBoolean;
      this.s = param1CompletableObserver;
    }
    
    public void onComplete() {
      if (this.once.compareAndSet(false, true)) {
        this.set.dispose();
        this.s.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.once.compareAndSet(false, true)) {
        this.set.dispose();
        this.s.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.set.add(param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */