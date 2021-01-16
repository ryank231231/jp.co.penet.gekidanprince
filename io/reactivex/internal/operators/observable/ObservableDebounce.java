package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
  final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
  
  public ObservableDebounce(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<U>> paramFunction) {
    super(paramObservableSource);
    this.debounceSelector = paramFunction;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new DebounceObserver<T, U>((Observer<? super T>)new SerializedObserver(paramObserver), this.debounceSelector));
  }
  
  static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    
    final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
    
    final AtomicReference<Disposable> debouncer = new AtomicReference<Disposable>();
    
    boolean done;
    
    volatile long index;
    
    Disposable s;
    
    DebounceObserver(Observer<? super T> param1Observer, Function<? super T, ? extends ObservableSource<U>> param1Function) {
      this.actual = param1Observer;
      this.debounceSelector = param1Function;
    }
    
    public void dispose() {
      this.s.dispose();
      DisposableHelper.dispose(this.debouncer);
    }
    
    void emit(long param1Long, T param1T) {
      if (param1Long == this.index)
        this.actual.onNext(param1T); 
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      Disposable disposable = this.debouncer.get();
      if (disposable != DisposableHelper.DISPOSED) {
        ((DebounceInnerObserver)disposable).emit();
        DisposableHelper.dispose(this.debouncer);
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      DisposableHelper.dispose(this.debouncer);
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      long l = this.index + 1L;
      this.index = l;
      Disposable disposable = this.debouncer.get();
      if (disposable != null)
        disposable.dispose(); 
      try {
        ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.debounceSelector.apply(param1T), "The ObservableSource supplied is null");
        DebounceInnerObserver<T, Object> debounceInnerObserver = new DebounceInnerObserver<T, Object>(this, l, param1T);
        if (this.debouncer.compareAndSet(disposable, debounceInnerObserver))
          observableSource.subscribe((Observer)debounceInnerObserver); 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        dispose();
        this.actual.onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
      boolean done;
      
      final long index;
      
      final AtomicBoolean once = new AtomicBoolean();
      
      final ObservableDebounce.DebounceObserver<T, U> parent;
      
      final T value;
      
      DebounceInnerObserver(ObservableDebounce.DebounceObserver<T, U> param2DebounceObserver, long param2Long, T param2T) {
        this.parent = param2DebounceObserver;
        this.index = param2Long;
        this.value = param2T;
      }
      
      void emit() {
        if (this.once.compareAndSet(false, true))
          this.parent.emit(this.index, this.value); 
      }
      
      public void onComplete() {
        if (this.done)
          return; 
        this.done = true;
        emit();
      }
      
      public void onError(Throwable param2Throwable) {
        if (this.done) {
          RxJavaPlugins.onError(param2Throwable);
          return;
        } 
        this.done = true;
        this.parent.onError(param2Throwable);
      }
      
      public void onNext(U param2U) {
        if (this.done)
          return; 
        this.done = true;
        dispose();
        emit();
      }
    }
  }
  
  static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
    boolean done;
    
    final long index;
    
    final AtomicBoolean once = new AtomicBoolean();
    
    final ObservableDebounce.DebounceObserver<T, U> parent;
    
    final T value;
    
    DebounceInnerObserver(ObservableDebounce.DebounceObserver<T, U> param1DebounceObserver, long param1Long, T param1T) {
      this.parent = param1DebounceObserver;
      this.index = param1Long;
      this.value = param1T;
    }
    
    void emit() {
      if (this.once.compareAndSet(false, true))
        this.parent.emit(this.index, this.value); 
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      emit();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.parent.onError(param1Throwable);
    }
    
    public void onNext(U param1U) {
      if (this.done)
        return; 
      this.done = true;
      dispose();
      emit();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDebounce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */