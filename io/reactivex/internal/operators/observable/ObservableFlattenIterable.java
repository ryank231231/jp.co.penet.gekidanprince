package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
  final Function<? super T, ? extends Iterable<? extends R>> mapper;
  
  public ObservableFlattenIterable(ObservableSource<T> paramObservableSource, Function<? super T, ? extends Iterable<? extends R>> paramFunction) {
    super(paramObservableSource);
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(Observer<? super R> paramObserver) {
    this.source.subscribe(new FlattenIterableObserver<T, R>(paramObserver, this.mapper));
  }
  
  static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
    final Observer<? super R> actual;
    
    Disposable d;
    
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    
    FlattenIterableObserver(Observer<? super R> param1Observer, Function<? super T, ? extends Iterable<? extends R>> param1Function) {
      this.actual = param1Observer;
      this.mapper = param1Function;
    }
    
    public void dispose() {
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      if (this.d == DisposableHelper.DISPOSED)
        return; 
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.d == DisposableHelper.DISPOSED) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.d == DisposableHelper.DISPOSED)
        return; 
      try {
        Iterator iterator = ((Iterable)this.mapper.apply(param1T)).iterator();
        Observer<? super R> observer = this.actual;
        try {
          while (true) {
            boolean bool = iterator.hasNext();
            if (bool) {
              try {
                param1T = (T)ObjectHelper.requireNonNull(iterator.next(), "The iterator returned a null value");
                observer.onNext(param1T);
              } catch (Throwable throwable) {
                Exceptions.throwIfFatal(throwable);
                this.d.dispose();
                onError(throwable);
                return;
              } 
              continue;
            } 
            break;
          } 
          return;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.d.dispose();
          onError(throwable);
          return;
        } 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.d.dispose();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFlattenIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */