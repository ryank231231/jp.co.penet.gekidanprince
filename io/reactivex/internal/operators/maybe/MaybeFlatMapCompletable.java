package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapCompletable<T> extends Completable {
  final Function<? super T, ? extends CompletableSource> mapper;
  
  final MaybeSource<T> source;
  
  public MaybeFlatMapCompletable(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends CompletableSource> paramFunction) {
    this.source = paramMaybeSource;
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    FlatMapCompletableObserver<T> flatMapCompletableObserver = new FlatMapCompletableObserver<T>(paramCompletableObserver, this.mapper);
    paramCompletableObserver.onSubscribe(flatMapCompletableObserver);
    this.source.subscribe(flatMapCompletableObserver);
  }
  
  static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, CompletableObserver, Disposable {
    private static final long serialVersionUID = -2177128922851101253L;
    
    final CompletableObserver actual;
    
    final Function<? super T, ? extends CompletableSource> mapper;
    
    FlatMapCompletableObserver(CompletableObserver param1CompletableObserver, Function<? super T, ? extends CompletableSource> param1Function) {
      this.actual = param1CompletableObserver;
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
      DisposableHelper.replace(this, param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      try {
        CompletableSource completableSource = (CompletableSource)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null CompletableSource");
        if (!isDisposed())
          completableSource.subscribe(this); 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */