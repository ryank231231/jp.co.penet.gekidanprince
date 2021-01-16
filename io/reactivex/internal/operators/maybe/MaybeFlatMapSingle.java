package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingle<T, R> extends Single<R> {
  final Function<? super T, ? extends SingleSource<? extends R>> mapper;
  
  final MaybeSource<T> source;
  
  public MaybeFlatMapSingle(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends SingleSource<? extends R>> paramFunction) {
    this.source = paramMaybeSource;
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(SingleObserver<? super R> paramSingleObserver) {
    this.source.subscribe(new FlatMapMaybeObserver<T, R>(paramSingleObserver, this.mapper));
  }
  
  static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 4827726964688405508L;
    
    final SingleObserver<? super R> actual;
    
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    
    FlatMapMaybeObserver(SingleObserver<? super R> param1SingleObserver, Function<? super T, ? extends SingleSource<? extends R>> param1Function) {
      this.actual = param1SingleObserver;
      this.mapper = param1Function;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      this.actual.onError(new NoSuchElementException());
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
        if (!isDisposed())
          singleSource.subscribe(new MaybeFlatMapSingle.FlatMapSingleObserver<R>(this, this.actual)); 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onError(throwable);
        return;
      } 
    }
  }
  
  static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
    final SingleObserver<? super R> actual;
    
    final AtomicReference<Disposable> parent;
    
    FlatMapSingleObserver(AtomicReference<Disposable> param1AtomicReference, SingleObserver<? super R> param1SingleObserver) {
      this.parent = param1AtomicReference;
      this.actual = param1SingleObserver;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */