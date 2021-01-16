package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
  final ObservableSource<? extends T> other;
  
  public ObservableSwitchIfEmpty(ObservableSource<T> paramObservableSource, ObservableSource<? extends T> paramObservableSource1) {
    super(paramObservableSource);
    this.other = paramObservableSource1;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    SwitchIfEmptyObserver<T> switchIfEmptyObserver = new SwitchIfEmptyObserver<T>(paramObserver, this.other);
    paramObserver.onSubscribe((Disposable)switchIfEmptyObserver.arbiter);
    this.source.subscribe(switchIfEmptyObserver);
  }
  
  static final class SwitchIfEmptyObserver<T> implements Observer<T> {
    final Observer<? super T> actual;
    
    final SequentialDisposable arbiter;
    
    boolean empty;
    
    final ObservableSource<? extends T> other;
    
    SwitchIfEmptyObserver(Observer<? super T> param1Observer, ObservableSource<? extends T> param1ObservableSource) {
      this.actual = param1Observer;
      this.other = param1ObservableSource;
      this.empty = true;
      this.arbiter = new SequentialDisposable();
    }
    
    public void onComplete() {
      if (this.empty) {
        this.empty = false;
        this.other.subscribe(this);
      } else {
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.empty)
        this.empty = false; 
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.arbiter.update(param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSwitchIfEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */