package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUnsubscribeOn<T> extends Single<T> {
  final Scheduler scheduler;
  
  final SingleSource<T> source;
  
  public SingleUnsubscribeOn(SingleSource<T> paramSingleSource, Scheduler paramScheduler) {
    this.source = paramSingleSource;
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new UnsubscribeOnSingleObserver<T>(paramSingleObserver, this.scheduler));
  }
  
  static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    
    final SingleObserver<? super T> actual;
    
    Disposable ds;
    
    final Scheduler scheduler;
    
    UnsubscribeOnSingleObserver(SingleObserver<? super T> param1SingleObserver, Scheduler param1Scheduler) {
      this.actual = param1SingleObserver;
      this.scheduler = param1Scheduler;
    }
    
    public void dispose() {
      Disposable disposable = getAndSet((Disposable)DisposableHelper.DISPOSED);
      if (disposable != DisposableHelper.DISPOSED) {
        this.ds = disposable;
        this.scheduler.scheduleDirect(this);
      } 
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable))
        this.actual.onSubscribe(this); 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
    
    public void run() {
      this.ds.dispose();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleUnsubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */