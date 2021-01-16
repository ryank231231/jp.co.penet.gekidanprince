package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
public final class MaybeFlatMapSingleElement<T, R> extends Maybe<R> {
  final Function<? super T, ? extends SingleSource<? extends R>> mapper;
  
  final MaybeSource<T> source;
  
  public MaybeFlatMapSingleElement(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends SingleSource<? extends R>> paramFunction) {
    this.source = paramMaybeSource;
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(MaybeObserver<? super R> paramMaybeObserver) {
    this.source.subscribe(new FlatMapMaybeObserver<T, R>(paramMaybeObserver, this.mapper));
  }
  
  static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 4827726964688405508L;
    
    final MaybeObserver<? super R> actual;
    
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    
    FlatMapMaybeObserver(MaybeObserver<? super R> param1MaybeObserver, Function<? super T, ? extends SingleSource<? extends R>> param1Function) {
      this.actual = param1MaybeObserver;
      this.mapper = param1Function;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable))
        this.actual.onSubscribe(this); 
    }
    
    public void onSuccess(T param1T) {
      try {
        SingleSource singleSource = (SingleSource)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null SingleSource");
        singleSource.subscribe(new MaybeFlatMapSingleElement.FlatMapSingleObserver<R>(this, this.actual));
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onError(throwable);
        return;
      } 
    }
  }
  
  static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
    final MaybeObserver<? super R> actual;
    
    final AtomicReference<Disposable> parent;
    
    FlatMapSingleObserver(AtomicReference<Disposable> param1AtomicReference, MaybeObserver<? super R> param1MaybeObserver) {
      this.parent = param1AtomicReference;
      this.actual = param1MaybeObserver;
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.replace(this.parent, param1Disposable);
    }
    
    public void onSuccess(R param1R) {
      this.actual.onSuccess(param1R);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapSingleElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */