package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {
  final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
  
  final SingleSource<? extends T> source;
  
  public SingleFlatMapMaybe(SingleSource<? extends T> paramSingleSource, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction) {
    this.mapper = paramFunction;
    this.source = paramSingleSource;
  }
  
  protected void subscribeActual(MaybeObserver<? super R> paramMaybeObserver) {
    this.source.subscribe(new FlatMapSingleObserver<T, R>(paramMaybeObserver, this.mapper));
  }
  
  static final class FlatMapMaybeObserver<R> implements MaybeObserver<R> {
    final MaybeObserver<? super R> actual;
    
    final AtomicReference<Disposable> parent;
    
    FlatMapMaybeObserver(AtomicReference<Disposable> param1AtomicReference, MaybeObserver<? super R> param1MaybeObserver) {
      this.parent = param1AtomicReference;
      this.actual = param1MaybeObserver;
    }
    
    public void onComplete() {
      this.actual.onComplete();
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
  
  static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = -5843758257109742742L;
    
    final MaybeObserver<? super R> actual;
    
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    
    FlatMapSingleObserver(MaybeObserver<? super R> param1MaybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> param1Function) {
      this.actual = param1MaybeObserver;
      this.mapper = param1Function;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
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
        MaybeSource maybeSource = (MaybeSource)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null MaybeSource");
        if (!isDisposed())
          maybeSource.subscribe(new SingleFlatMapMaybe.FlatMapMaybeObserver<R>(this, this.actual)); 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFlatMapMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */