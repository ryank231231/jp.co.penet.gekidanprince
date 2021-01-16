package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableGenerate<T, S> extends Observable<T> {
  final Consumer<? super S> disposeState;
  
  final BiFunction<S, Emitter<T>, S> generator;
  
  final Callable<S> stateSupplier;
  
  public ObservableGenerate(Callable<S> paramCallable, BiFunction<S, Emitter<T>, S> paramBiFunction, Consumer<? super S> paramConsumer) {
    this.stateSupplier = paramCallable;
    this.generator = paramBiFunction;
    this.disposeState = paramConsumer;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    try {
      S s = this.stateSupplier.call();
      GeneratorDisposable<T, S> generatorDisposable = new GeneratorDisposable<T, S>(paramObserver, this.generator, this.disposeState, s);
      paramObserver.onSubscribe(generatorDisposable);
      generatorDisposable.run();
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
  
  static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
    final Observer<? super T> actual;
    
    volatile boolean cancelled;
    
    final Consumer<? super S> disposeState;
    
    final BiFunction<S, ? super Emitter<T>, S> generator;
    
    boolean hasNext;
    
    S state;
    
    boolean terminate;
    
    GeneratorDisposable(Observer<? super T> param1Observer, BiFunction<S, ? super Emitter<T>, S> param1BiFunction, Consumer<? super S> param1Consumer, S param1S) {
      this.actual = param1Observer;
      this.generator = param1BiFunction;
      this.disposeState = param1Consumer;
      this.state = param1S;
    }
    
    private void dispose(S param1S) {
      try {
        this.disposeState.accept(param1S);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
    
    public void dispose() {
      this.cancelled = true;
    }
    
    public boolean isDisposed() {
      return this.cancelled;
    }
    
    public void onComplete() {
      if (!this.terminate) {
        this.terminate = true;
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.terminate) {
        RxJavaPlugins.onError(param1Throwable);
      } else {
        Throwable throwable = param1Throwable;
        if (param1Throwable == null)
          throwable = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."); 
        this.terminate = true;
        this.actual.onError(throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (!this.terminate)
        if (this.hasNext) {
          onError(new IllegalStateException("onNext already called in this generate turn"));
        } else if (param1T == null) {
          onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
          this.hasNext = true;
          this.actual.onNext(param1T);
        }  
    }
    
    public void run() {
      S s = this.state;
      if (this.cancelled) {
        this.state = null;
        dispose(s);
        return;
      } 
      BiFunction<S, ? super Emitter<T>, S> biFunction = this.generator;
      while (true) {
        if (this.cancelled) {
          this.state = null;
          dispose(s);
          return;
        } 
        this.hasNext = false;
        try {
          Object object = biFunction.apply(s, this);
          s = (S)object;
          if (this.terminate) {
            this.cancelled = true;
            this.state = null;
            dispose((S)object);
            return;
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.state = null;
          this.cancelled = true;
          onError(throwable);
          dispose(s);
          break;
        } 
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableGenerate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */