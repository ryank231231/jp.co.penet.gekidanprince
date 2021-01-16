package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
  @NonNull
  final Function<? super Object[], R> combiner;
  
  @Nullable
  final ObservableSource<?>[] otherArray = null;
  
  @Nullable
  final Iterable<? extends ObservableSource<?>> otherIterable;
  
  public ObservableWithLatestFromMany(@NonNull ObservableSource<T> paramObservableSource, @NonNull Iterable<? extends ObservableSource<?>> paramIterable, @NonNull Function<? super Object[], R> paramFunction) {
    super(paramObservableSource);
    this.otherIterable = paramIterable;
    this.combiner = paramFunction;
  }
  
  public ObservableWithLatestFromMany(@NonNull ObservableSource<T> paramObservableSource, @NonNull ObservableSource<?>[] paramArrayOfObservableSource, @NonNull Function<? super Object[], R> paramFunction) {
    super(paramObservableSource);
    this.otherIterable = null;
    this.combiner = paramFunction;
  }
  
  protected void subscribeActual(Observer<? super R> paramObserver) {
    ObservableSource[] arrayOfObservableSource;
    int i;
    ObservableSource<?>[] arrayOfObservableSource1 = this.otherArray;
    if (arrayOfObservableSource1 == null) {
      ObservableSource[] arrayOfObservableSource2 = new ObservableSource[8];
      try {
        Iterator<? extends ObservableSource<?>> iterator = this.otherIterable.iterator();
        byte b = 0;
        while (true) {
          arrayOfObservableSource = arrayOfObservableSource2;
          i = b;
          if (iterator.hasNext()) {
            ObservableSource observableSource = iterator.next();
            arrayOfObservableSource = arrayOfObservableSource2;
            if (b == arrayOfObservableSource2.length)
              arrayOfObservableSource = Arrays.<ObservableSource>copyOf(arrayOfObservableSource2, (b >> 1) + b); 
            arrayOfObservableSource[b] = observableSource;
            b++;
            arrayOfObservableSource2 = arrayOfObservableSource;
            continue;
          } 
          break;
        } 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramObserver);
        return;
      } 
    } else {
      i = arrayOfObservableSource.length;
    } 
    if (i == 0) {
      (new ObservableMap<Object, R>(this.source, new SingletonArrayFunc())).subscribeActual(paramObserver);
      return;
    } 
    WithLatestFromObserver<Object, R> withLatestFromObserver = new WithLatestFromObserver<Object, R>(paramObserver, this.combiner, i);
    paramObserver.onSubscribe(withLatestFromObserver);
    withLatestFromObserver.subscribe((ObservableSource<?>[])arrayOfObservableSource, i);
    this.source.subscribe(withLatestFromObserver);
  }
  
  final class SingletonArrayFunc implements Function<T, R> {
    public R apply(T param1T) throws Exception {
      return (R)ObjectHelper.requireNonNull(ObservableWithLatestFromMany.this.combiner.apply(new Object[] { param1T }, ), "The combiner returned a null value");
    }
  }
  
  static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 1577321883966341961L;
    
    final Observer<? super R> actual;
    
    final Function<? super Object[], R> combiner;
    
    final AtomicReference<Disposable> d;
    
    volatile boolean done;
    
    final AtomicThrowable error;
    
    final ObservableWithLatestFromMany.WithLatestInnerObserver[] observers;
    
    final AtomicReferenceArray<Object> values;
    
    WithLatestFromObserver(Observer<? super R> param1Observer, Function<? super Object[], R> param1Function, int param1Int) {
      this.actual = param1Observer;
      this.combiner = param1Function;
      ObservableWithLatestFromMany.WithLatestInnerObserver[] arrayOfWithLatestInnerObserver = new ObservableWithLatestFromMany.WithLatestInnerObserver[param1Int];
      for (byte b = 0; b < param1Int; b++)
        arrayOfWithLatestInnerObserver[b] = new ObservableWithLatestFromMany.WithLatestInnerObserver(this, b); 
      this.observers = arrayOfWithLatestInnerObserver;
      this.values = new AtomicReferenceArray(param1Int);
      this.d = new AtomicReference<Disposable>();
      this.error = new AtomicThrowable();
    }
    
    void cancelAllBut(int param1Int) {
      ObservableWithLatestFromMany.WithLatestInnerObserver[] arrayOfWithLatestInnerObserver = this.observers;
      for (byte b = 0; b < arrayOfWithLatestInnerObserver.length; b++) {
        if (b != param1Int)
          arrayOfWithLatestInnerObserver[b].dispose(); 
      } 
    }
    
    public void dispose() {
      DisposableHelper.dispose(this.d);
      ObservableWithLatestFromMany.WithLatestInnerObserver[] arrayOfWithLatestInnerObserver = this.observers;
      int i = arrayOfWithLatestInnerObserver.length;
      for (byte b = 0; b < i; b++)
        arrayOfWithLatestInnerObserver[b].dispose(); 
    }
    
    void innerComplete(int param1Int, boolean param1Boolean) {
      if (!param1Boolean) {
        this.done = true;
        cancelAllBut(param1Int);
        HalfSerializer.onComplete(this.actual, this, this.error);
      } 
    }
    
    void innerError(int param1Int, Throwable param1Throwable) {
      this.done = true;
      DisposableHelper.dispose(this.d);
      cancelAllBut(param1Int);
      HalfSerializer.onError(this.actual, param1Throwable, this, this.error);
    }
    
    void innerNext(int param1Int, Object param1Object) {
      this.values.set(param1Int, param1Object);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(this.d.get());
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        cancelAllBut(-1);
        HalfSerializer.onComplete(this.actual, this, this.error);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      cancelAllBut(-1);
      HalfSerializer.onError(this.actual, param1Throwable, this, this.error);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      AtomicReferenceArray<Object> atomicReferenceArray = this.values;
      int i = atomicReferenceArray.length();
      Object[] arrayOfObject = new Object[i + 1];
      byte b = 0;
      arrayOfObject[0] = param1T;
      while (b < i) {
        param1T = (T)atomicReferenceArray.get(b);
        if (param1T == null)
          return; 
        arrayOfObject[++b] = param1T;
      } 
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.combiner.apply(arrayOfObject), "combiner returned a null value");
        HalfSerializer.onNext(this.actual, param1T, this, this.error);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        dispose();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this.d, param1Disposable);
    }
    
    void subscribe(ObservableSource<?>[] param1ArrayOfObservableSource, int param1Int) {
      ObservableWithLatestFromMany.WithLatestInnerObserver[] arrayOfWithLatestInnerObserver = this.observers;
      AtomicReference<Disposable> atomicReference = this.d;
      for (byte b = 0; b < param1Int; b++) {
        if (DisposableHelper.isDisposed(atomicReference.get()) || this.done)
          return; 
        param1ArrayOfObservableSource[b].subscribe(arrayOfWithLatestInnerObserver[b]);
      } 
    }
  }
  
  static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
    private static final long serialVersionUID = 3256684027868224024L;
    
    boolean hasValue;
    
    final int index;
    
    final ObservableWithLatestFromMany.WithLatestFromObserver<?, ?> parent;
    
    WithLatestInnerObserver(ObservableWithLatestFromMany.WithLatestFromObserver<?, ?> param1WithLatestFromObserver, int param1Int) {
      this.parent = param1WithLatestFromObserver;
      this.index = param1Int;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete() {
      this.parent.innerComplete(this.index, this.hasValue);
    }
    
    public void onError(Throwable param1Throwable) {
      this.parent.innerError(this.index, param1Throwable);
    }
    
    public void onNext(Object param1Object) {
      if (!this.hasValue)
        this.hasValue = true; 
      this.parent.innerNext(this.index, param1Object);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWithLatestFromMany.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */