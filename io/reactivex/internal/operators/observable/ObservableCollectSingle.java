package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {
  final BiConsumer<? super U, ? super T> collector;
  
  final Callable<? extends U> initialSupplier;
  
  final ObservableSource<T> source;
  
  public ObservableCollectSingle(ObservableSource<T> paramObservableSource, Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer) {
    this.source = paramObservableSource;
    this.initialSupplier = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  public Observable<U> fuseToObservable() {
    return RxJavaPlugins.onAssembly(new ObservableCollect<T, U>(this.source, this.initialSupplier, this.collector));
  }
  
  protected void subscribeActual(SingleObserver<? super U> paramSingleObserver) {
    try {
      Object object = ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value");
      this.source.subscribe(new CollectObserver<T, U>(paramSingleObserver, (U)object, this.collector));
      return;
    } catch (Throwable throwable) {
      EmptyDisposable.error(throwable, paramSingleObserver);
      return;
    } 
  }
  
  static final class CollectObserver<T, U> implements Observer<T>, Disposable {
    final SingleObserver<? super U> actual;
    
    final BiConsumer<? super U, ? super T> collector;
    
    boolean done;
    
    Disposable s;
    
    final U u;
    
    CollectObserver(SingleObserver<? super U> param1SingleObserver, U param1U, BiConsumer<? super U, ? super T> param1BiConsumer) {
      this.actual = param1SingleObserver;
      this.collector = param1BiConsumer;
      this.u = param1U;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      this.actual.onSuccess(this.u);
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      try {
        this.collector.accept(this.u, param1T);
      } catch (Throwable throwable) {
        this.s.dispose();
        onError(throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCollectSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */