package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap {
  private ObservableScalarXMap() {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T, U> Observable<U> scalarXMap(T paramT, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction) {
    return RxJavaPlugins.onAssembly(new ScalarXMapObservable<T, U>(paramT, paramFunction));
  }
  
  public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> paramObservableSource, Observer<? super R> paramObserver, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction) {
    if (paramObservableSource instanceof Callable)
      try {
        paramObservableSource = ((Callable)paramObservableSource).call();
        if (paramObservableSource == null) {
          EmptyDisposable.complete(paramObserver);
          return true;
        } 
        try {
          paramObservableSource = (ObservableSource<T>)ObjectHelper.requireNonNull(paramFunction.apply(paramObservableSource), "The mapper returned a null ObservableSource");
          if (paramObservableSource instanceof Callable) {
            try {
              paramObservableSource = ((Callable)paramObservableSource).call();
              if (paramObservableSource == null) {
                EmptyDisposable.complete(paramObserver);
                return true;
              } 
              ScalarDisposable<R> scalarDisposable = new ScalarDisposable<R>(paramObserver, (R)paramObservableSource);
              paramObserver.onSubscribe((Disposable)scalarDisposable);
              scalarDisposable.run();
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              EmptyDisposable.error(throwable, paramObserver);
              return true;
            } 
          } else {
            throwable.subscribe(paramObserver);
          } 
          return true;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          EmptyDisposable.error(throwable, paramObserver);
          return true;
        } 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramObserver);
        return true;
      }  
    return false;
  }
  
  public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
    static final int FUSED = 1;
    
    static final int ON_COMPLETE = 3;
    
    static final int ON_NEXT = 2;
    
    static final int START = 0;
    
    private static final long serialVersionUID = 3880992722410194083L;
    
    final Observer<? super T> observer;
    
    final T value;
    
    public ScalarDisposable(Observer<? super T> param1Observer, T param1T) {
      this.observer = param1Observer;
      this.value = param1T;
    }
    
    public void clear() {
      lazySet(3);
    }
    
    public void dispose() {
      set(3);
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (get() == 3) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean isEmpty() {
      int i = get();
      boolean bool = true;
      if (i == 1)
        bool = false; 
      return bool;
    }
    
    public boolean offer(T param1T) {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public boolean offer(T param1T1, T param1T2) {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    @Nullable
    public T poll() throws Exception {
      if (get() == 1) {
        lazySet(3);
        return this.value;
      } 
      return null;
    }
    
    public int requestFusion(int param1Int) {
      if ((param1Int & 0x1) != 0) {
        lazySet(1);
        return 1;
      } 
      return 0;
    }
    
    public void run() {
      if (get() == 0 && compareAndSet(0, 2)) {
        this.observer.onNext(this.value);
        if (get() == 2) {
          lazySet(3);
          this.observer.onComplete();
        } 
      } 
    }
  }
  
  static final class ScalarXMapObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    
    final T value;
    
    ScalarXMapObservable(T param1T, Function<? super T, ? extends ObservableSource<? extends R>> param1Function) {
      this.value = param1T;
      this.mapper = param1Function;
    }
    
    public void subscribeActual(Observer<? super R> param1Observer) {
      try {
        ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null ObservableSource");
        if (observableSource instanceof Callable) {
          try {
            observableSource = ((Callable<ObservableSource>)observableSource).call();
            if (observableSource == null) {
              EmptyDisposable.complete(param1Observer);
              return;
            } 
            ObservableScalarXMap.ScalarDisposable<R> scalarDisposable = new ObservableScalarXMap.ScalarDisposable<R>(param1Observer, (R)observableSource);
            param1Observer.onSubscribe((Disposable)scalarDisposable);
            scalarDisposable.run();
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            EmptyDisposable.error(throwable, param1Observer);
            return;
          } 
        } else {
          throwable.subscribe(param1Observer);
        } 
        return;
      } catch (Throwable throwable) {
        EmptyDisposable.error(throwable, param1Observer);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableScalarXMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */