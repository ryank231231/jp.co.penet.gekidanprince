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
import java.util.NoSuchElementException;

public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {
  final T defaultValue;
  
  final long index;
  
  final ObservableSource<T> source;
  
  public ObservableElementAtSingle(ObservableSource<T> paramObservableSource, long paramLong, T paramT) {
    this.source = paramObservableSource;
    this.index = paramLong;
    this.defaultValue = paramT;
  }
  
  public Observable<T> fuseToObservable() {
    return RxJavaPlugins.onAssembly(new ObservableElementAt<T>(this.source, this.index, this.defaultValue, true));
  }
  
  public void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new ElementAtObserver<T>(paramSingleObserver, this.index, this.defaultValue));
  }
  
  static final class ElementAtObserver<T> implements Observer<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    long count;
    
    final T defaultValue;
    
    boolean done;
    
    final long index;
    
    Disposable s;
    
    ElementAtObserver(SingleObserver<? super T> param1SingleObserver, long param1Long, T param1T) {
      this.actual = param1SingleObserver;
      this.index = param1Long;
      this.defaultValue = param1T;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        T t = this.defaultValue;
        if (t != null) {
          this.actual.onSuccess(t);
        } else {
          this.actual.onError(new NoSuchElementException());
        } 
      } 
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
      long l = this.count;
      if (l == this.index) {
        this.done = true;
        this.s.dispose();
        this.actual.onSuccess(param1T);
        return;
      } 
      this.count = l + 1L;
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableElementAtSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */