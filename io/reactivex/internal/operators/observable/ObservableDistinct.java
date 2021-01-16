package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {
  final Callable<? extends Collection<? super K>> collectionSupplier;
  
  final Function<? super T, K> keySelector;
  
  public ObservableDistinct(ObservableSource<T> paramObservableSource, Function<? super T, K> paramFunction, Callable<? extends Collection<? super K>> paramCallable) {
    super(paramObservableSource);
    this.keySelector = paramFunction;
    this.collectionSupplier = paramCallable;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    try {
      Collection<? super K> collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.source.subscribe((Observer)new DistinctObserver<T, K>(paramObserver, this.keySelector, collection));
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
  
  static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {
    final Collection<? super K> collection;
    
    final Function<? super T, K> keySelector;
    
    DistinctObserver(Observer<? super T> param1Observer, Function<? super T, K> param1Function, Collection<? super K> param1Collection) {
      super(param1Observer);
      this.keySelector = param1Function;
      this.collection = param1Collection;
    }
    
    public void clear() {
      this.collection.clear();
      super.clear();
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        this.collection.clear();
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
      } else {
        this.done = true;
        this.collection.clear();
        this.actual.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.sourceMode == 0) {
        try {
          Object object = ObjectHelper.requireNonNull(this.keySelector.apply(param1T), "The keySelector returned a null key");
          boolean bool = this.collection.add((K)object);
          if (bool)
            this.actual.onNext(param1T); 
        } catch (Throwable throwable) {
          fail(throwable);
          return;
        } 
      } else {
        this.actual.onNext(null);
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      Object object;
      do {
        object = this.qs.poll();
      } while (object != null && !this.collection.add((K)ObjectHelper.requireNonNull(this.keySelector.apply(object), "The keySelector returned a null key")));
      return (T)object;
    }
    
    public int requestFusion(int param1Int) {
      return transitiveBoundaryFusion(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDistinct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */