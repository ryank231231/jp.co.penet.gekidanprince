package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
  final Callable<U> collectionSupplier;
  
  public ObservableToList(ObservableSource<T> paramObservableSource, int paramInt) {
    super(paramObservableSource);
    this.collectionSupplier = Functions.createArrayList(paramInt);
  }
  
  public ObservableToList(ObservableSource<T> paramObservableSource, Callable<U> paramCallable) {
    super(paramObservableSource);
    this.collectionSupplier = paramCallable;
  }
  
  public void subscribeActual(Observer<? super U> paramObserver) {
    try {
      Collection collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.source.subscribe(new ToListObserver<Object, U>(paramObserver, (U)collection));
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
  
  static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
    final Observer<? super U> actual;
    
    U collection;
    
    Disposable s;
    
    ToListObserver(Observer<? super U> param1Observer, U param1U) {
      this.actual = param1Observer;
      this.collection = param1U;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      U u = this.collection;
      this.collection = null;
      this.actual.onNext(u);
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.collection = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.collection.add(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableToList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */