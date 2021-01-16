package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {
  final Function<? super T, ? extends MaybeSource<? extends U>> mapper;
  
  final BiFunction<? super T, ? super U, ? extends R> resultSelector;
  
  public MaybeFlatMapBiSelector(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends MaybeSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction) {
    super(paramMaybeSource);
    this.mapper = paramFunction;
    this.resultSelector = paramBiFunction;
  }
  
  protected void subscribeActual(MaybeObserver<? super R> paramMaybeObserver) {
    this.source.subscribe(new FlatMapBiMainObserver<T, U, R>(paramMaybeObserver, this.mapper, this.resultSelector));
  }
  
  static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {
    final InnerObserver<T, U, R> inner;
    
    final Function<? super T, ? extends MaybeSource<? extends U>> mapper;
    
    FlatMapBiMainObserver(MaybeObserver<? super R> param1MaybeObserver, Function<? super T, ? extends MaybeSource<? extends U>> param1Function, BiFunction<? super T, ? super U, ? extends R> param1BiFunction) {
      this.inner = new InnerObserver<T, U, R>(param1MaybeObserver, param1BiFunction);
      this.mapper = param1Function;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this.inner);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(this.inner.get());
    }
    
    public void onComplete() {
      this.inner.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.inner.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this.inner, param1Disposable))
        this.inner.actual.onSubscribe(this); 
    }
    
    public void onSuccess(T param1T) {
      try {
        MaybeSource maybeSource = (MaybeSource)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null MaybeSource");
        if (DisposableHelper.replace(this.inner, null)) {
          InnerObserver<T, U, R> innerObserver = this.inner;
          innerObserver.value = param1T;
          maybeSource.subscribe(innerObserver);
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.inner.actual.onError(throwable);
        return;
      } 
    }
    
    static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
      private static final long serialVersionUID = -2897979525538174559L;
      
      final MaybeObserver<? super R> actual;
      
      final BiFunction<? super T, ? super U, ? extends R> resultSelector;
      
      T value;
      
      InnerObserver(MaybeObserver<? super R> param2MaybeObserver, BiFunction<? super T, ? super U, ? extends R> param2BiFunction) {
        this.actual = param2MaybeObserver;
        this.resultSelector = param2BiFunction;
      }
      
      public void onComplete() {
        this.actual.onComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        this.actual.onError(param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.setOnce(this, param2Disposable);
      }
      
      public void onSuccess(U param2U) {
        T t = this.value;
        this.value = null;
        try {
          param2U = (U)ObjectHelper.requireNonNull(this.resultSelector.apply(t, param2U), "The resultSelector returned a null value");
          this.actual.onSuccess(param2U);
          return;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.actual.onError(throwable);
          return;
        } 
      }
    }
  }
  
  static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
    private static final long serialVersionUID = -2897979525538174559L;
    
    final MaybeObserver<? super R> actual;
    
    final BiFunction<? super T, ? super U, ? extends R> resultSelector;
    
    T value;
    
    InnerObserver(MaybeObserver<? super R> param1MaybeObserver, BiFunction<? super T, ? super U, ? extends R> param1BiFunction) {
      this.actual = param1MaybeObserver;
      this.resultSelector = param1BiFunction;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
    
    public void onSuccess(U param1U) {
      T t = this.value;
      this.value = null;
      try {
        param1U = (U)ObjectHelper.requireNonNull(this.resultSelector.apply(t, param1U), "The resultSelector returned a null value");
        this.actual.onSuccess(param1U);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapBiSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */