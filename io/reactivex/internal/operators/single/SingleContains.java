package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

public final class SingleContains<T> extends Single<Boolean> {
  final BiPredicate<Object, Object> comparer;
  
  final SingleSource<T> source;
  
  final Object value;
  
  public SingleContains(SingleSource<T> paramSingleSource, Object paramObject, BiPredicate<Object, Object> paramBiPredicate) {
    this.source = paramSingleSource;
    this.value = paramObject;
    this.comparer = paramBiPredicate;
  }
  
  protected void subscribeActual(SingleObserver<? super Boolean> paramSingleObserver) {
    this.source.subscribe(new Single(paramSingleObserver));
  }
  
  final class Single implements SingleObserver<T> {
    private final SingleObserver<? super Boolean> s;
    
    Single(SingleObserver<? super Boolean> param1SingleObserver) {
      this.s = param1SingleObserver;
    }
    
    public void onError(Throwable param1Throwable) {
      this.s.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.s.onSubscribe(param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      try {
        boolean bool = SingleContains.this.comparer.test(param1T, SingleContains.this.value);
        this.s.onSuccess(Boolean.valueOf(bool));
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleContains.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */