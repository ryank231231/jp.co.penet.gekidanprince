package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {
  final ObservableSource<T> source;
  
  public ObservableIgnoreElementsCompletable(ObservableSource<T> paramObservableSource) {
    this.source = paramObservableSource;
  }
  
  public Observable<T> fuseToObservable() {
    return RxJavaPlugins.onAssembly(new ObservableIgnoreElements<T>(this.source));
  }
  
  public void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new IgnoreObservable(paramCompletableObserver));
  }
  
  static final class IgnoreObservable<T> implements Observer<T>, Disposable {
    final CompletableObserver actual;
    
    Disposable d;
    
    IgnoreObservable(CompletableObserver param1CompletableObserver) {
      this.actual = param1CompletableObserver;
    }
    
    public void dispose() {
      this.d.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {}
    
    public void onSubscribe(Disposable param1Disposable) {
      this.d = param1Disposable;
      this.actual.onSubscribe(this);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableIgnoreElementsCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */