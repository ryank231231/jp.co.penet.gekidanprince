package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {
  final BooleanSupplier until;
  
  public ObservableRepeatUntil(Observable<T> paramObservable, BooleanSupplier paramBooleanSupplier) {
    super((ObservableSource<T>)paramObservable);
    this.until = paramBooleanSupplier;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    SequentialDisposable sequentialDisposable = new SequentialDisposable();
    paramObserver.onSubscribe((Disposable)sequentialDisposable);
    (new RepeatUntilObserver(paramObserver, this.until, sequentialDisposable, this.source)).subscribeNext();
  }
  
  static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    
    final Observer<? super T> actual;
    
    final SequentialDisposable sd;
    
    final ObservableSource<? extends T> source;
    
    final BooleanSupplier stop;
    
    RepeatUntilObserver(Observer<? super T> param1Observer, BooleanSupplier param1BooleanSupplier, SequentialDisposable param1SequentialDisposable, ObservableSource<? extends T> param1ObservableSource) {
      this.actual = param1Observer;
      this.sd = param1SequentialDisposable;
      this.source = param1ObservableSource;
      this.stop = param1BooleanSupplier;
    }
    
    public void onComplete() {
      try {
        boolean bool = this.stop.getAsBoolean();
        if (bool) {
          this.actual.onComplete();
        } else {
          subscribeNext();
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.sd.replace(param1Disposable);
    }
    
    void subscribeNext() {
      if (getAndIncrement() == 0) {
        int j;
        int i = 1;
        do {
          this.source.subscribe(this);
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRepeatUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */