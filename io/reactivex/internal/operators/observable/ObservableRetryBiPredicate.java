package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {
  final BiPredicate<? super Integer, ? super Throwable> predicate;
  
  public ObservableRetryBiPredicate(Observable<T> paramObservable, BiPredicate<? super Integer, ? super Throwable> paramBiPredicate) {
    super((ObservableSource<T>)paramObservable);
    this.predicate = paramBiPredicate;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    SequentialDisposable sequentialDisposable = new SequentialDisposable();
    paramObserver.onSubscribe((Disposable)sequentialDisposable);
    (new RetryBiObserver(paramObserver, this.predicate, sequentialDisposable, this.source)).subscribeNext();
  }
  
  static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    
    final Observer<? super T> actual;
    
    final BiPredicate<? super Integer, ? super Throwable> predicate;
    
    int retries;
    
    final SequentialDisposable sa;
    
    final ObservableSource<? extends T> source;
    
    RetryBiObserver(Observer<? super T> param1Observer, BiPredicate<? super Integer, ? super Throwable> param1BiPredicate, SequentialDisposable param1SequentialDisposable, ObservableSource<? extends T> param1ObservableSource) {
      this.actual = param1Observer;
      this.sa = param1SequentialDisposable;
      this.source = param1ObservableSource;
      this.predicate = param1BiPredicate;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        BiPredicate<? super Integer, ? super Throwable> biPredicate = this.predicate;
        int i = this.retries + 1;
        this.retries = i;
        boolean bool = biPredicate.test(Integer.valueOf(i), param1Throwable);
        if (!bool) {
          this.actual.onError(param1Throwable);
          return;
        } 
        subscribeNext();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.sa.update(param1Disposable);
    }
    
    void subscribeNext() {
      if (getAndIncrement() == 0) {
        int j;
        int i = 1;
        do {
          if (this.sa.isDisposed())
            return; 
          this.source.subscribe(this);
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRetryBiPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */