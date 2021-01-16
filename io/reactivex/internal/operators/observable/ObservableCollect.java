package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {
  final BiConsumer<? super U, ? super T> collector;
  
  final Callable<? extends U> initialSupplier;
  
  public ObservableCollect(ObservableSource<T> paramObservableSource, Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer) {
    super(paramObservableSource);
    this.initialSupplier = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  protected void subscribeActual(Observer<? super U> paramObserver) {
    try {
      Object object = ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value");
      this.source.subscribe(new CollectObserver<T, U>(paramObserver, (U)object, this.collector));
      return;
    } catch (Throwable throwable) {
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
  
  static final class CollectObserver<T, U> implements Observer<T>, Disposable {
    final Observer<? super U> actual;
    
    final BiConsumer<? super U, ? super T> collector;
    
    boolean done;
    
    Disposable s;
    
    final U u;
    
    CollectObserver(Observer<? super U> param1Observer, U param1U, BiConsumer<? super U, ? super T> param1BiConsumer) {
      this.actual = param1Observer;
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
      this.actual.onNext(this.u);
      this.actual.onComplete();
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */