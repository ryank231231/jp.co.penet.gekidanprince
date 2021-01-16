package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDematerialize<T> extends AbstractObservableWithUpstream<Notification<T>, T> {
  public ObservableDematerialize(ObservableSource<Notification<T>> paramObservableSource) {
    super(paramObservableSource);
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new DematerializeObserver<T>(paramObserver));
  }
  
  static final class DematerializeObserver<T> implements Observer<Notification<T>>, Disposable {
    final Observer<? super T> actual;
    
    boolean done;
    
    Disposable s;
    
    DematerializeObserver(Observer<? super T> param1Observer) {
      this.actual = param1Observer;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(Notification<T> param1Notification) {
      if (this.done) {
        if (param1Notification.isOnError())
          RxJavaPlugins.onError(param1Notification.getError()); 
        return;
      } 
      if (param1Notification.isOnError()) {
        this.s.dispose();
        onError(param1Notification.getError());
      } else if (param1Notification.isOnComplete()) {
        this.s.dispose();
        onComplete();
      } else {
        this.actual.onNext(param1Notification.getValue());
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDematerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */