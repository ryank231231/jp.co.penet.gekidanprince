package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {
  final Callable<U> collectionSupplier;
  
  final ObservableSource<T> source;
  
  public ObservableToListSingle(ObservableSource<T> paramObservableSource, int paramInt) {
    this.source = paramObservableSource;
    this.collectionSupplier = Functions.createArrayList(paramInt);
  }
  
  public ObservableToListSingle(ObservableSource<T> paramObservableSource, Callable<U> paramCallable) {
    this.source = paramObservableSource;
    this.collectionSupplier = paramCallable;
  }
  
  public Observable<U> fuseToObservable() {
    return RxJavaPlugins.onAssembly(new ObservableToList<T, U>(this.source, this.collectionSupplier));
  }
  
  public void subscribeActual(SingleObserver<? super U> paramSingleObserver) {
    try {
      Collection collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.source.subscribe(new ToListObserver<Object, U>(paramSingleObserver, (U)collection));
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramSingleObserver);
      return;
    } 
  }
  
  static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
    final SingleObserver<? super U> actual;
    
    U collection;
    
    Disposable s;
    
    ToListObserver(SingleObserver<? super U> param1SingleObserver, U param1U) {
      this.actual = param1SingleObserver;
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
      this.actual.onSuccess(u);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableToListSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */