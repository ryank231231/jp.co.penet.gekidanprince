package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
  final BiPredicate<? super K, ? super K> comparer;
  
  final Function<? super T, K> keySelector;
  
  public ObservableDistinctUntilChanged(ObservableSource<T> paramObservableSource, Function<? super T, K> paramFunction, BiPredicate<? super K, ? super K> paramBiPredicate) {
    super(paramObservableSource);
    this.keySelector = paramFunction;
    this.comparer = paramBiPredicate;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe((Observer)new DistinctUntilChangedObserver<T, K>(paramObserver, this.keySelector, this.comparer));
  }
  
  static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
    final BiPredicate<? super K, ? super K> comparer;
    
    boolean hasValue;
    
    final Function<? super T, K> keySelector;
    
    K last;
    
    DistinctUntilChangedObserver(Observer<? super T> param1Observer, Function<? super T, K> param1Function, BiPredicate<? super K, ? super K> param1BiPredicate) {
      super(param1Observer);
      this.keySelector = param1Function;
      this.comparer = param1BiPredicate;
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.sourceMode != 0) {
        this.actual.onNext(param1T);
        return;
      } 
      try {
        Object object = this.keySelector.apply(param1T);
        if (this.hasValue) {
          boolean bool = this.comparer.test(this.last, object);
          this.last = (K)object;
          if (bool)
            return; 
        } else {
          this.hasValue = true;
          this.last = (K)object;
        } 
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        fail(throwable);
        return;
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      while (true) {
        Object object1 = this.qs.poll();
        if (object1 == null)
          return null; 
        Object object2 = this.keySelector.apply(object1);
        if (!this.hasValue) {
          this.hasValue = true;
          this.last = (K)object2;
          return (T)object1;
        } 
        if (!this.comparer.test(this.last, object2)) {
          this.last = (K)object2;
          return (T)object1;
        } 
        this.last = (K)object2;
      } 
    }
    
    public int requestFusion(int param1Int) {
      return transitiveBoundaryFusion(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDistinctUntilChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */