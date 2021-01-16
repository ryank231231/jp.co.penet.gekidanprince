package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
  final Scheduler scheduler;
  
  public ObservableSubscribeOn(ObservableSource<T> paramObservableSource, Scheduler paramScheduler) {
    super(paramObservableSource);
    this.scheduler = paramScheduler;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    SubscribeOnObserver<T> subscribeOnObserver = new SubscribeOnObserver<T>(paramObserver);
    paramObserver.onSubscribe(subscribeOnObserver);
    subscribeOnObserver.setDisposable(this.scheduler.scheduleDirect(new SubscribeTask(subscribeOnObserver)));
  }
  
  static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = 8094547886072529208L;
    
    final Observer<? super T> actual;
    
    final AtomicReference<Disposable> s;
    
    SubscribeOnObserver(Observer<? super T> param1Observer) {
      this.actual = param1Observer;
      this.s = new AtomicReference<Disposable>();
    }
    
    public void dispose() {
      DisposableHelper.dispose(this.s);
      DisposableHelper.dispose(this);
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
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this.s, param1Disposable);
    }
    
    void setDisposable(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
  }
  
  final class SubscribeTask implements Runnable {
    private final ObservableSubscribeOn.SubscribeOnObserver<T> parent;
    
    SubscribeTask(ObservableSubscribeOn.SubscribeOnObserver<T> param1SubscribeOnObserver) {
      this.parent = param1SubscribeOnObserver;
    }
    
    public void run() {
      ObservableSubscribeOn.this.source.subscribe(this.parent);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */