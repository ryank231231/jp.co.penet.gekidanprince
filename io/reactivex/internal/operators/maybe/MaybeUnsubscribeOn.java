package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUnsubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {
  final Scheduler scheduler;
  
  public MaybeUnsubscribeOn(MaybeSource<T> paramMaybeSource, Scheduler paramScheduler) {
    super(paramMaybeSource);
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new UnsubscribeOnMaybeObserver<T>(paramMaybeObserver, this.scheduler));
  }
  
  static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    
    final MaybeObserver<? super T> actual;
    
    Disposable ds;
    
    final Scheduler scheduler;
    
    UnsubscribeOnMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, Scheduler param1Scheduler) {
      this.actual = param1MaybeObserver;
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
    
    public void onComplete() {
      this.actual.onComplete();
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeUnsubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */