package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

public final class SingleMap<T, R> extends Single<R> {
  final Function<? super T, ? extends R> mapper;
  
  final SingleSource<? extends T> source;
  
  public SingleMap(SingleSource<? extends T> paramSingleSource, Function<? super T, ? extends R> paramFunction) {
    this.source = paramSingleSource;
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(SingleObserver<? super R> paramSingleObserver) {
    this.source.subscribe(new MapSingleObserver<T, R>(paramSingleObserver, this.mapper));
  }
  
  static final class MapSingleObserver<T, R> implements SingleObserver<T> {
    final Function<? super T, ? extends R> mapper;
    
    final SingleObserver<? super R> t;
    
    MapSingleObserver(SingleObserver<? super R> param1SingleObserver, Function<? super T, ? extends R> param1Function) {
      this.t = param1SingleObserver;
      this.mapper = param1Function;
    }
    
    public void onError(Throwable param1Throwable) {
      this.t.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.t.onSubscribe(param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper function returned a null value.");
        this.t.onSuccess(param1T);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */