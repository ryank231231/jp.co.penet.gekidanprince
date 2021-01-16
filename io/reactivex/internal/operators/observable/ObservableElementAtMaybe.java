package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {
  final long index;
  
  final ObservableSource<T> source;
  
  public ObservableElementAtMaybe(ObservableSource<T> paramObservableSource, long paramLong) {
    this.source = paramObservableSource;
    this.index = paramLong;
  }
  
  public Observable<T> fuseToObservable() {
    return RxJavaPlugins.onAssembly(new ObservableElementAt<T>(this.source, this.index, null, false));
  }
  
  public void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new ElementAtObserver<T>(paramMaybeObserver, this.index));
  }
  
  static final class ElementAtObserver<T> implements Observer<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    long count;
    
    boolean done;
    
    final long index;
    
    Disposable s;
    
    ElementAtObserver(MaybeObserver<? super T> param1MaybeObserver, long param1Long) {
      this.actual = param1MaybeObserver;
      this.index = param1Long;
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
        this.actual.onComplete();
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableElementAtMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */