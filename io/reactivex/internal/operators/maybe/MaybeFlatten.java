package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten<T, R> extends AbstractMaybeWithUpstream<T, R> {
  final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
  
  public MaybeFlatten(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction) {
    super(paramMaybeSource);
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(MaybeObserver<? super R> paramMaybeObserver) {
    this.source.subscribe(new FlatMapMaybeObserver<T, R>(paramMaybeObserver, this.mapper));
  }
  
  static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 4375739915521278546L;
    
    final MaybeObserver<? super R> actual;
    
    Disposable d;
    
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    
    FlatMapMaybeObserver(MaybeObserver<? super R> param1MaybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> param1Function) {
      this.actual = param1MaybeObserver;
      this.mapper = param1Function;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
      this.d.dispose();
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
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      try {
        MaybeSource maybeSource = (MaybeSource)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null MaybeSource");
        if (!isDisposed())
          maybeSource.subscribe(new InnerObserver()); 
        return;
      } catch (Exception exception) {
        Exceptions.throwIfFatal(exception);
        this.actual.onError(exception);
        return;
      } 
    }
    
    final class InnerObserver implements MaybeObserver<R> {
      public void onComplete() {
        MaybeFlatten.FlatMapMaybeObserver.this.actual.onComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        MaybeFlatten.FlatMapMaybeObserver.this.actual.onError(param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.setOnce(MaybeFlatten.FlatMapMaybeObserver.this, param2Disposable);
      }
      
      public void onSuccess(R param2R) {
        MaybeFlatten.FlatMapMaybeObserver.this.actual.onSuccess(param2R);
      }
    }
  }
  
  final class InnerObserver implements MaybeObserver<R> {
    public void onComplete() {
      this.this$0.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.this$0.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this.this$0, param1Disposable);
    }
    
    public void onSuccess(R param1R) {
      this.this$0.actual.onSuccess(param1R);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatten.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */