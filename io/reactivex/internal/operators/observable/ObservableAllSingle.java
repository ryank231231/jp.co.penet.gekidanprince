package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
  final Predicate<? super T> predicate;
  
  final ObservableSource<T> source;
  
  public ObservableAllSingle(ObservableSource<T> paramObservableSource, Predicate<? super T> paramPredicate) {
    this.source = paramObservableSource;
    this.predicate = paramPredicate;
  }
  
  public Observable<Boolean> fuseToObservable() {
    return RxJavaPlugins.onAssembly(new ObservableAll<T>(this.source, this.predicate));
  }
  
  protected void subscribeActual(SingleObserver<? super Boolean> paramSingleObserver) {
    this.source.subscribe(new AllObserver<T>(paramSingleObserver, this.predicate));
  }
  
  static final class AllObserver<T> implements Observer<T>, Disposable {
    final SingleObserver<? super Boolean> actual;
    
    boolean done;
    
    final Predicate<? super T> predicate;
    
    Disposable s;
    
    AllObserver(SingleObserver<? super Boolean> param1SingleObserver, Predicate<? super T> param1Predicate) {
      this.actual = param1SingleObserver;
      this.predicate = param1Predicate;
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
      this.actual.onSuccess(Boolean.valueOf(true));
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      try {
        boolean bool = this.predicate.test(param1T);
        if (!bool) {
          this.done = true;
          this.s.dispose();
          this.actual.onSuccess(Boolean.valueOf(false));
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.dispose();
        onError(throwable);
        return;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableAllSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */