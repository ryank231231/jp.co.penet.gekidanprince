package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {
  final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
  
  final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
  
  final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;
  
  public ObservableMapNotification(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, Function<? super Throwable, ? extends ObservableSource<? extends R>> paramFunction1, Callable<? extends ObservableSource<? extends R>> paramCallable) {
    super(paramObservableSource);
    this.onNextMapper = paramFunction;
    this.onErrorMapper = paramFunction1;
    this.onCompleteSupplier = paramCallable;
  }
  
  public void subscribeActual(Observer<? super ObservableSource<? extends R>> paramObserver) {
    this.source.subscribe(new MapNotificationObserver<T, R>(paramObserver, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
  }
  
  static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {
    final Observer<? super ObservableSource<? extends R>> actual;
    
    final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
    
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
    
    final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;
    
    Disposable s;
    
    MapNotificationObserver(Observer<? super ObservableSource<? extends R>> param1Observer, Function<? super T, ? extends ObservableSource<? extends R>> param1Function, Function<? super Throwable, ? extends ObservableSource<? extends R>> param1Function1, Callable<? extends ObservableSource<? extends R>> param1Callable) {
      this.actual = param1Observer;
      this.onNextMapper = param1Function;
      this.onErrorMapper = param1Function1;
      this.onCompleteSupplier = param1Callable;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      try {
        ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete ObservableSource returned is null");
        this.actual.onNext(observableSource);
        this.actual.onComplete();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.onErrorMapper.apply(param1Throwable), "The onError ObservableSource returned is null");
        this.actual.onNext(observableSource);
        this.actual.onComplete();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onNext(T param1T) {
      try {
        ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.onNextMapper.apply(param1T), "The onNext ObservableSource returned is null");
        this.actual.onNext(observableSource);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableMapNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */