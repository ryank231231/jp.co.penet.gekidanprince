package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
  final ObservableSource<? extends U> other;
  
  public ObservableTakeUntil(ObservableSource<T> paramObservableSource, ObservableSource<? extends U> paramObservableSource1) {
    super(paramObservableSource);
    this.other = paramObservableSource1;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    SerializedObserver<T> serializedObserver = new SerializedObserver(paramObserver);
    ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
    TakeUntilObserver takeUntilObserver = new TakeUntilObserver((Observer<?>)serializedObserver, arrayCompositeDisposable);
    paramObserver.onSubscribe((Disposable)arrayCompositeDisposable);
    this.other.subscribe(new TakeUntil(arrayCompositeDisposable, serializedObserver));
    this.source.subscribe(takeUntilObserver);
  }
  
  final class TakeUntil implements Observer<U> {
    private final ArrayCompositeDisposable frc;
    
    private final SerializedObserver<T> serial;
    
    TakeUntil(ArrayCompositeDisposable param1ArrayCompositeDisposable, SerializedObserver<T> param1SerializedObserver) {
      this.frc = param1ArrayCompositeDisposable;
      this.serial = param1SerializedObserver;
    }
    
    public void onComplete() {
      this.frc.dispose();
      this.serial.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.frc.dispose();
      this.serial.onError(param1Throwable);
    }
    
    public void onNext(U param1U) {
      this.frc.dispose();
      this.serial.onComplete();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.frc.setResource(1, param1Disposable);
    }
  }
  
  static final class TakeUntilObserver<T> extends AtomicBoolean implements Observer<T> {
    private static final long serialVersionUID = 3451719290311127173L;
    
    final Observer<? super T> actual;
    
    final ArrayCompositeDisposable frc;
    
    Disposable s;
    
    TakeUntilObserver(Observer<? super T> param1Observer, ArrayCompositeDisposable param1ArrayCompositeDisposable) {
      this.actual = param1Observer;
      this.frc = param1ArrayCompositeDisposable;
    }
    
    public void onComplete() {
      this.frc.dispose();
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.frc.dispose();
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.frc.setResource(0, param1Disposable);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTakeUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */