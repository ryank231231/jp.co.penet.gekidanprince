package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
  final BiFunction<? super T, ? super U, ? extends R> combiner;
  
  final ObservableSource<? extends U> other;
  
  public ObservableWithLatestFrom(ObservableSource<T> paramObservableSource, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, ObservableSource<? extends U> paramObservableSource1) {
    super(paramObservableSource);
    this.combiner = paramBiFunction;
    this.other = paramObservableSource1;
  }
  
  public void subscribeActual(Observer<? super R> paramObserver) {
    SerializedObserver serializedObserver = new SerializedObserver(paramObserver);
    WithLatestFromObserver<T, U, R> withLatestFromObserver = new WithLatestFromObserver<T, U, R>((Observer<? super R>)serializedObserver, this.combiner);
    serializedObserver.onSubscribe(withLatestFromObserver);
    this.other.subscribe(new WithLastFrom(withLatestFromObserver));
    this.source.subscribe(withLatestFromObserver);
  }
  
  final class WithLastFrom implements Observer<U> {
    private final ObservableWithLatestFrom.WithLatestFromObserver<T, U, R> wlf;
    
    WithLastFrom(ObservableWithLatestFrom.WithLatestFromObserver<T, U, R> param1WithLatestFromObserver) {
      this.wlf = param1WithLatestFromObserver;
    }
    
    public void onComplete() {}
    
    public void onError(Throwable param1Throwable) {
      this.wlf.otherError(param1Throwable);
    }
    
    public void onNext(U param1U) {
      this.wlf.lazySet(param1U);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.wlf.setOther(param1Disposable);
    }
  }
  
  static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -312246233408980075L;
    
    final Observer<? super R> actual;
    
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    
    final AtomicReference<Disposable> other = new AtomicReference<Disposable>();
    
    final AtomicReference<Disposable> s = new AtomicReference<Disposable>();
    
    WithLatestFromObserver(Observer<? super R> param1Observer, BiFunction<? super T, ? super U, ? extends R> param1BiFunction) {
      this.actual = param1Observer;
      this.combiner = param1BiFunction;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this.s);
      DisposableHelper.dispose(this.other);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(this.s.get());
    }
    
    public void onComplete() {
      DisposableHelper.dispose(this.other);
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      DisposableHelper.dispose(this.other);
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      U u = get();
      if (u != null)
        try {
          param1T = (T)ObjectHelper.requireNonNull(this.combiner.apply(param1T, u), "The combiner returned a null value");
          this.actual.onNext(param1T);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          dispose();
          this.actual.onError(throwable);
          return;
        }  
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this.s, param1Disposable);
    }
    
    public void otherError(Throwable param1Throwable) {
      DisposableHelper.dispose(this.s);
      this.actual.onError(param1Throwable);
    }
    
    public boolean setOther(Disposable param1Disposable) {
      return DisposableHelper.setOnce(this.other, param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWithLatestFrom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */