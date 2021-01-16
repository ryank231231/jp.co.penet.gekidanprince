package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
  final int bufferSize;
  
  final ErrorMode delayErrors;
  
  final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
  
  public ObservableConcatMap(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, int paramInt, ErrorMode paramErrorMode) {
    super(paramObservableSource);
    this.mapper = paramFunction;
    this.delayErrors = paramErrorMode;
    this.bufferSize = Math.max(8, paramInt);
  }
  
  public void subscribeActual(Observer<? super U> paramObserver) {
    SerializedObserver serializedObserver;
    if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, paramObserver, this.mapper))
      return; 
    if (this.delayErrors == ErrorMode.IMMEDIATE) {
      serializedObserver = new SerializedObserver(paramObserver);
      this.source.subscribe(new SourceObserver<T, U>((Observer<? super U>)serializedObserver, this.mapper, this.bufferSize));
    } else {
      boolean bool;
      ObservableSource<T> observableSource = this.source;
      Function<? super T, ? extends ObservableSource<? extends U>> function = this.mapper;
      int i = this.bufferSize;
      if (this.delayErrors == ErrorMode.END) {
        bool = true;
      } else {
        bool = false;
      } 
      observableSource.subscribe(new ConcatMapDelayErrorObserver<T, U>((Observer<? super U>)serializedObserver, function, i, bool));
    } 
  }
  
  static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = -6951100001833242599L;
    
    volatile boolean active;
    
    final Observer<? super R> actual;
    
    final int bufferSize;
    
    volatile boolean cancelled;
    
    Disposable d;
    
    volatile boolean done;
    
    final AtomicThrowable error;
    
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    
    final DelayErrorInnerObserver<R> observer;
    
    SimpleQueue<T> queue;
    
    int sourceMode;
    
    final boolean tillTheEnd;
    
    ConcatMapDelayErrorObserver(Observer<? super R> param1Observer, Function<? super T, ? extends ObservableSource<? extends R>> param1Function, int param1Int, boolean param1Boolean) {
      this.actual = param1Observer;
      this.mapper = param1Function;
      this.bufferSize = param1Int;
      this.tillTheEnd = param1Boolean;
      this.error = new AtomicThrowable();
      this.observer = new DelayErrorInnerObserver<R>(param1Observer, this);
    }
    
    public void dispose() {
      this.cancelled = true;
      this.d.dispose();
      this.observer.dispose();
    }
    
    void drain() {
      if (getAndIncrement() != 0)
        return; 
      Observer<? super R> observer = this.actual;
      SimpleQueue<T> simpleQueue = this.queue;
      AtomicThrowable atomicThrowable = this.error;
      while (true) {
        if (!this.active) {
          Throwable throwable;
          if (this.cancelled) {
            simpleQueue.clear();
            return;
          } 
          if (!this.tillTheEnd && (Throwable)atomicThrowable.get() != null) {
            simpleQueue.clear();
            this.cancelled = true;
            observer.onError(atomicThrowable.terminate());
            return;
          } 
          boolean bool = this.done;
          try {
            boolean bool1;
            Object object = simpleQueue.poll();
            if (object == null) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (bool && bool1) {
              this.cancelled = true;
              throwable = atomicThrowable.terminate();
              if (throwable != null) {
                observer.onError(throwable);
              } else {
                observer.onComplete();
              } 
              return;
            } 
            if (!bool1)
              try {
                object = ObjectHelper.requireNonNull(this.mapper.apply(object), "The mapper returned a null ObservableSource");
                if (object instanceof Callable) {
                  try {
                    object = ((Callable)object).call();
                    if (object != null && !this.cancelled)
                      observer.onNext(object); 
                  } catch (Throwable throwable1) {
                    Exceptions.throwIfFatal(throwable1);
                    throwable.addThrowable(throwable1);
                  } 
                  continue;
                } 
                this.active = true;
                throwable1.subscribe(this.observer);
              } catch (Throwable throwable1) {
                Exceptions.throwIfFatal(throwable1);
                this.cancelled = true;
                this.d.dispose();
                simpleQueue.clear();
                throwable.addThrowable(throwable1);
                observer.onError(throwable.terminate());
                return;
              }  
          } catch (Throwable throwable1) {
            Exceptions.throwIfFatal(throwable1);
            this.cancelled = true;
            this.d.dispose();
            throwable.addThrowable(throwable1);
            observer.onError(throwable.terminate());
            return;
          } 
        } 
        if (decrementAndGet() == 0)
          break; 
      } 
    }
    
    public boolean isDisposed() {
      return this.cancelled;
    }
    
    public void onComplete() {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.error.addThrowable(param1Throwable)) {
        this.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (this.sourceMode == 0)
        this.queue.offer(param1T); 
      drain();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        if (param1Disposable instanceof QueueDisposable) {
          QueueDisposable queueDisposable = (QueueDisposable)param1Disposable;
          int i = queueDisposable.requestFusion(3);
          if (i == 1) {
            this.sourceMode = i;
            this.queue = (SimpleQueue<T>)queueDisposable;
            this.done = true;
            this.actual.onSubscribe(this);
            drain();
            return;
          } 
          if (i == 2) {
            this.sourceMode = i;
            this.queue = (SimpleQueue<T>)queueDisposable;
            this.actual.onSubscribe(this);
            return;
          } 
        } 
        this.queue = (SimpleQueue<T>)new SpscLinkedArrayQueue(this.bufferSize);
        this.actual.onSubscribe(this);
      } 
    }
    
    static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
      private static final long serialVersionUID = 2620149119579502636L;
      
      final Observer<? super R> actual;
      
      final ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> parent;
      
      DelayErrorInnerObserver(Observer<? super R> param2Observer, ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> param2ConcatMapDelayErrorObserver) {
        this.actual = param2Observer;
        this.parent = param2ConcatMapDelayErrorObserver;
      }
      
      void dispose() {
        DisposableHelper.dispose(this);
      }
      
      public void onComplete() {
        ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
        concatMapDelayErrorObserver.active = false;
        concatMapDelayErrorObserver.drain();
      }
      
      public void onError(Throwable param2Throwable) {
        ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
        if (concatMapDelayErrorObserver.error.addThrowable(param2Throwable)) {
          if (!concatMapDelayErrorObserver.tillTheEnd)
            concatMapDelayErrorObserver.d.dispose(); 
          concatMapDelayErrorObserver.active = false;
          concatMapDelayErrorObserver.drain();
        } else {
          RxJavaPlugins.onError(param2Throwable);
        } 
      }
      
      public void onNext(R param2R) {
        this.actual.onNext(param2R);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.replace(this, param2Disposable);
      }
    }
  }
  
  static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
    private static final long serialVersionUID = 2620149119579502636L;
    
    final Observer<? super R> actual;
    
    final ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> parent;
    
    DelayErrorInnerObserver(Observer<? super R> param1Observer, ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> param1ConcatMapDelayErrorObserver) {
      this.actual = param1Observer;
      this.parent = param1ConcatMapDelayErrorObserver;
    }
    
    void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete() {
      ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
      concatMapDelayErrorObserver.active = false;
      concatMapDelayErrorObserver.drain();
    }
    
    public void onError(Throwable param1Throwable) {
      ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
      if (concatMapDelayErrorObserver.error.addThrowable(param1Throwable)) {
        if (!concatMapDelayErrorObserver.tillTheEnd)
          concatMapDelayErrorObserver.d.dispose(); 
        concatMapDelayErrorObserver.active = false;
        concatMapDelayErrorObserver.drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(R param1R) {
      this.actual.onNext(param1R);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.replace(this, param1Disposable);
    }
  }
  
  static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 8828587559905699186L;
    
    volatile boolean active;
    
    final Observer<? super U> actual;
    
    final int bufferSize;
    
    volatile boolean disposed;
    
    volatile boolean done;
    
    int fusionMode;
    
    final InnerObserver<U> inner;
    
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    
    SimpleQueue<T> queue;
    
    Disposable s;
    
    SourceObserver(Observer<? super U> param1Observer, Function<? super T, ? extends ObservableSource<? extends U>> param1Function, int param1Int) {
      this.actual = param1Observer;
      this.mapper = param1Function;
      this.bufferSize = param1Int;
      this.inner = new InnerObserver<U>(param1Observer, this);
    }
    
    public void dispose() {
      this.disposed = true;
      this.inner.dispose();
      this.s.dispose();
      if (getAndIncrement() == 0)
        this.queue.clear(); 
    }
    
    void drain() {
      if (getAndIncrement() != 0)
        return; 
      do {
        if (this.disposed) {
          this.queue.clear();
          return;
        } 
        if (this.active)
          continue; 
        boolean bool = this.done;
        try {
          boolean bool1;
          Object object = this.queue.poll();
          if (object == null) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (bool && bool1) {
            this.disposed = true;
            this.actual.onComplete();
            return;
          } 
          if (!bool1)
            try {
              object = ObjectHelper.requireNonNull(this.mapper.apply(object), "The mapper returned a null ObservableSource");
              this.active = true;
              object.subscribe(this.inner);
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              dispose();
              this.queue.clear();
              this.actual.onError(throwable);
              return;
            }  
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          dispose();
          this.queue.clear();
          this.actual.onError(throwable);
          return;
        } 
      } while (decrementAndGet() != 0);
    }
    
    void innerComplete() {
      this.active = false;
      drain();
    }
    
    public boolean isDisposed() {
      return this.disposed;
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      dispose();
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.fusionMode == 0)
        this.queue.offer(param1T); 
      drain();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        if (param1Disposable instanceof QueueDisposable) {
          QueueDisposable queueDisposable = (QueueDisposable)param1Disposable;
          int i = queueDisposable.requestFusion(3);
          if (i == 1) {
            this.fusionMode = i;
            this.queue = (SimpleQueue<T>)queueDisposable;
            this.done = true;
            this.actual.onSubscribe(this);
            drain();
            return;
          } 
          if (i == 2) {
            this.fusionMode = i;
            this.queue = (SimpleQueue<T>)queueDisposable;
            this.actual.onSubscribe(this);
            return;
          } 
        } 
        this.queue = (SimpleQueue<T>)new SpscLinkedArrayQueue(this.bufferSize);
        this.actual.onSubscribe(this);
      } 
    }
    
    static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
      private static final long serialVersionUID = -7449079488798789337L;
      
      final Observer<? super U> actual;
      
      final ObservableConcatMap.SourceObserver<?, ?> parent;
      
      InnerObserver(Observer<? super U> param2Observer, ObservableConcatMap.SourceObserver<?, ?> param2SourceObserver) {
        this.actual = param2Observer;
        this.parent = param2SourceObserver;
      }
      
      void dispose() {
        DisposableHelper.dispose(this);
      }
      
      public void onComplete() {
        this.parent.innerComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        this.parent.dispose();
        this.actual.onError(param2Throwable);
      }
      
      public void onNext(U param2U) {
        this.actual.onNext(param2U);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.set(this, param2Disposable);
      }
    }
  }
  
  static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
    private static final long serialVersionUID = -7449079488798789337L;
    
    final Observer<? super U> actual;
    
    final ObservableConcatMap.SourceObserver<?, ?> parent;
    
    InnerObserver(Observer<? super U> param1Observer, ObservableConcatMap.SourceObserver<?, ?> param1SourceObserver) {
      this.actual = param1Observer;
      this.parent = param1SourceObserver;
    }
    
    void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete() {
      this.parent.innerComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.parent.dispose();
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(U param1U) {
      this.actual.onNext(param1U);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.set(this, param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableConcatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */