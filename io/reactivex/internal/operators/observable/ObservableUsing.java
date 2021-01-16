package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUsing<T, D> extends Observable<T> {
  final Consumer<? super D> disposer;
  
  final boolean eager;
  
  final Callable<? extends D> resourceSupplier;
  
  final Function<? super D, ? extends ObservableSource<? extends T>> sourceSupplier;
  
  public ObservableUsing(Callable<? extends D> paramCallable, Function<? super D, ? extends ObservableSource<? extends T>> paramFunction, Consumer<? super D> paramConsumer, boolean paramBoolean) {
    this.resourceSupplier = paramCallable;
    this.sourceSupplier = paramFunction;
    this.disposer = paramConsumer;
    this.eager = paramBoolean;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    try {
      D d = this.resourceSupplier.call();
      try {
        ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.sourceSupplier.apply(d), "The sourceSupplier returned a null ObservableSource");
        observableSource.subscribe(new UsingObserver<T, D>(paramObserver, d, this.disposer, this.eager));
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        try {
          this.disposer.accept(d);
          EmptyDisposable.error(throwable, paramObserver);
          return;
        } catch (Throwable throwable1) {
          Exceptions.throwIfFatal(throwable1);
          EmptyDisposable.error((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }, ), paramObserver);
          return;
        } 
      } 
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
  
  static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
    private static final long serialVersionUID = 5904473792286235046L;
    
    final Observer<? super T> actual;
    
    final Consumer<? super D> disposer;
    
    final boolean eager;
    
    final D resource;
    
    Disposable s;
    
    UsingObserver(Observer<? super T> param1Observer, D param1D, Consumer<? super D> param1Consumer, boolean param1Boolean) {
      this.actual = param1Observer;
      this.resource = param1D;
      this.disposer = param1Consumer;
      this.eager = param1Boolean;
    }
    
    public void dispose() {
      disposeAfter();
      this.s.dispose();
    }
    
    void disposeAfter() {
      if (compareAndSet(false, true))
        try {
          this.disposer.accept(this.resource);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        }  
    }
    
    public boolean isDisposed() {
      return get();
    }
    
    public void onComplete() {
      if (this.eager) {
        if (compareAndSet(false, true))
          try {
            this.disposer.accept(this.resource);
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.actual.onError(throwable);
            return;
          }  
        this.s.dispose();
        this.actual.onComplete();
      } else {
        this.actual.onComplete();
        this.s.dispose();
        disposeAfter();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.eager) {
        CompositeException compositeException;
        Throwable throwable = param1Throwable;
        if (compareAndSet(false, true))
          try {
            this.disposer.accept(this.resource);
            throwable = param1Throwable;
          } catch (Throwable throwable1) {
            Exceptions.throwIfFatal(throwable1);
            compositeException = new CompositeException(new Throwable[] { param1Throwable, throwable1 });
          }  
        this.s.dispose();
        this.actual.onError((Throwable)compositeException);
      } else {
        this.actual.onError(param1Throwable);
        this.s.dispose();
        disposeAfter();
      } 
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */