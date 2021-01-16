package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn extends Completable {
  final Scheduler scheduler;
  
  final CompletableSource source;
  
  public CompletableSubscribeOn(CompletableSource paramCompletableSource, Scheduler paramScheduler) {
    this.source = paramCompletableSource;
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(paramCompletableObserver, this.source);
    paramCompletableObserver.onSubscribe(subscribeOnObserver);
    Disposable disposable = this.scheduler.scheduleDirect(subscribeOnObserver);
    subscribeOnObserver.task.replace(disposable);
  }
  
  static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    
    final CompletableObserver actual;
    
    final CompletableSource source;
    
    final SequentialDisposable task;
    
    SubscribeOnObserver(CompletableObserver param1CompletableObserver, CompletableSource param1CompletableSource) {
      this.actual = param1CompletableObserver;
      this.source = param1CompletableSource;
      this.task = new SequentialDisposable();
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
      this.task.dispose();
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
    
    public void run() {
      this.source.subscribe(this);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableSubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */