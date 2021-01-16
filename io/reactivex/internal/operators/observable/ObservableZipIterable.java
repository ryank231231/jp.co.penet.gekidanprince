package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

public final class ObservableZipIterable<T, U, V> extends Observable<V> {
  final Iterable<U> other;
  
  final Observable<? extends T> source;
  
  final BiFunction<? super T, ? super U, ? extends V> zipper;
  
  public ObservableZipIterable(Observable<? extends T> paramObservable, Iterable<U> paramIterable, BiFunction<? super T, ? super U, ? extends V> paramBiFunction) {
    this.source = paramObservable;
    this.other = paramIterable;
    this.zipper = paramBiFunction;
  }
  
  public void subscribeActual(Observer<? super V> paramObserver) {
    try {
      Iterator<U> iterator = (Iterator)ObjectHelper.requireNonNull(this.other.iterator(), "The iterator returned by other is null");
      try {
        boolean bool = iterator.hasNext();
        if (!bool) {
          EmptyDisposable.complete(paramObserver);
          return;
        } 
        this.source.subscribe(new ZipIterableObserver<T, U, V>(paramObserver, iterator, this.zipper));
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramObserver);
        return;
      } 
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
  
  static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {
    final Observer<? super V> actual;
    
    boolean done;
    
    final Iterator<U> iterator;
    
    Disposable s;
    
    final BiFunction<? super T, ? super U, ? extends V> zipper;
    
    ZipIterableObserver(Observer<? super V> param1Observer, Iterator<U> param1Iterator, BiFunction<? super T, ? super U, ? extends V> param1BiFunction) {
      this.actual = param1Observer;
      this.iterator = param1Iterator;
      this.zipper = param1BiFunction;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    void error(Throwable param1Throwable) {
      this.done = true;
      this.s.dispose();
      this.actual.onError(param1Throwable);
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      this.actual.onComplete();
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
        Object object = ObjectHelper.requireNonNull(this.iterator.next(), "The iterator returned a null value");
        try {
          param1T = (T)ObjectHelper.requireNonNull(this.zipper.apply(param1T, object), "The zipper function returned a null value");
          this.actual.onNext(param1T);
          try {
            boolean bool = this.iterator.hasNext();
            if (!bool) {
              this.done = true;
              this.s.dispose();
              this.actual.onComplete();
            } 
            return;
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            error(throwable);
            return;
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          error(throwable);
          return;
        } 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        error(throwable);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableZipIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */