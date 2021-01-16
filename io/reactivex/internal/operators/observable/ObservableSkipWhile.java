package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {
  final Predicate<? super T> predicate;
  
  public ObservableSkipWhile(ObservableSource<T> paramObservableSource, Predicate<? super T> paramPredicate) {
    super(paramObservableSource);
    this.predicate = paramPredicate;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new SkipWhileObserver<T>(paramObserver, this.predicate));
  }
  
  static final class SkipWhileObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    
    boolean notSkipping;
    
    final Predicate<? super T> predicate;
    
    Disposable s;
    
    SkipWhileObserver(Observer<? super T> param1Observer, Predicate<? super T> param1Predicate) {
      this.actual = param1Observer;
      this.predicate = param1Predicate;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.notSkipping) {
        this.actual.onNext(param1T);
      } else {
        try {
          boolean bool = this.predicate.test(param1T);
          if (!bool) {
            this.notSkipping = true;
            this.actual.onNext(param1T);
          } 
          return;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.s.dispose();
          this.actual.onError(throwable);
          return;
        } 
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSkipWhile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */