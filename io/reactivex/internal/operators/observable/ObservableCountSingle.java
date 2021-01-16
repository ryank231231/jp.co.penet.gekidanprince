package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {
  final ObservableSource<T> source;
  
  public ObservableCountSingle(ObservableSource<T> paramObservableSource) {
    this.source = paramObservableSource;
  }
  
  public Observable<Long> fuseToObservable() {
    return RxJavaPlugins.onAssembly(new ObservableCount<T>(this.source));
  }
  
  public void subscribeActual(SingleObserver<? super Long> paramSingleObserver) {
    this.source.subscribe(new CountObserver(paramSingleObserver));
  }
  
  static final class CountObserver implements Observer<Object>, Disposable {
    final SingleObserver<? super Long> actual;
    
    long count;
    
    Disposable d;
    
    CountObserver(SingleObserver<? super Long> param1SingleObserver) {
      this.actual = param1SingleObserver;
    }
    
    public void dispose() {
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onSuccess(Long.valueOf(this.count));
    }
    
    public void onError(Throwable param1Throwable) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(Object param1Object) {
      this.count++;
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCountSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */