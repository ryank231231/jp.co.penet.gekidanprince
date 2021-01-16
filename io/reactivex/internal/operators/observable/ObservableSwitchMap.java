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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
  final int bufferSize;
  
  final boolean delayErrors;
  
  final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
  
  public ObservableSwitchMap(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt, boolean paramBoolean) {
    super(paramObservableSource);
    this.mapper = paramFunction;
    this.bufferSize = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  public void subscribeActual(Observer<? super R> paramObserver) {
    if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, paramObserver, this.mapper))
      return; 
    this.source.subscribe(new SwitchMapObserver<T, R>(paramObserver, this.mapper, this.bufferSize, this.delayErrors));
  }
  
  static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    
    final int bufferSize;
    
    volatile boolean done;
    
    final long index;
    
    final ObservableSwitchMap.SwitchMapObserver<T, R> parent;
    
    volatile SimpleQueue<R> queue;
    
    SwitchMapInnerObserver(ObservableSwitchMap.SwitchMapObserver<T, R> param1SwitchMapObserver, long param1Long, int param1Int) {
      this.parent = param1SwitchMapObserver;
      this.index = param1Long;
      this.bufferSize = param1Int;
    }
    
    public void cancel() {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete() {
      if (this.index == this.parent.unique) {
        this.done = true;
        this.parent.drain();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.parent.innerError(this, param1Throwable);
    }
    
    public void onNext(R param1R) {
      if (this.index == this.parent.unique) {
        if (param1R != null)
          this.queue.offer(param1R); 
        this.parent.drain();
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable)) {
        if (param1Disposable instanceof QueueDisposable) {
          QueueDisposable queueDisposable = (QueueDisposable)param1Disposable;
          int i = queueDisposable.requestFusion(7);
          if (i == 1) {
            this.queue = (SimpleQueue<R>)queueDisposable;
            this.done = true;
            this.parent.drain();
            return;
          } 
          if (i == 2) {
            this.queue = (SimpleQueue<R>)queueDisposable;
            return;
          } 
        } 
        this.queue = (SimpleQueue<R>)new SpscLinkedArrayQueue(this.bufferSize);
      } 
    }
  }
  
  static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
    static final ObservableSwitchMap.SwitchMapInnerObserver<Object, Object> CANCELLED = new ObservableSwitchMap.SwitchMapInnerObserver<Object, Object>(null, -1L, 1);
    
    private static final long serialVersionUID = -3491074160481096299L;
    
    final AtomicReference<ObservableSwitchMap.SwitchMapInnerObserver<T, R>> active = new AtomicReference<ObservableSwitchMap.SwitchMapInnerObserver<T, R>>();
    
    final Observer<? super R> actual;
    
    final int bufferSize;
    
    volatile boolean cancelled;
    
    final boolean delayErrors;
    
    volatile boolean done;
    
    final AtomicThrowable errors;
    
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    
    Disposable s;
    
    volatile long unique;
    
    static {
      CANCELLED.cancel();
    }
    
    SwitchMapObserver(Observer<? super R> param1Observer, Function<? super T, ? extends ObservableSource<? extends R>> param1Function, int param1Int, boolean param1Boolean) {
      this.actual = param1Observer;
      this.mapper = param1Function;
      this.bufferSize = param1Int;
      this.delayErrors = param1Boolean;
      this.errors = new AtomicThrowable();
    }
    
    public void dispose() {
      if (!this.cancelled) {
        this.cancelled = true;
        this.s.dispose();
        disposeInner();
      } 
    }
    
    void disposeInner() {
      ObservableSwitchMap.SwitchMapInnerObserver<Object, Object> switchMapInnerObserver1 = (ObservableSwitchMap.SwitchMapInnerObserver)this.active.get();
      ObservableSwitchMap.SwitchMapInnerObserver<Object, Object> switchMapInnerObserver2 = CANCELLED;
      if (switchMapInnerObserver1 != switchMapInnerObserver2) {
        switchMapInnerObserver1 = (ObservableSwitchMap.SwitchMapInnerObserver<Object, Object>)this.active.getAndSet(switchMapInnerObserver2);
        if (switchMapInnerObserver1 != CANCELLED && switchMapInnerObserver1 != null)
          switchMapInnerObserver1.cancel(); 
      } 
    }
    
    void drain() {
      if (getAndIncrement() != 0)
        return; 
      Observer<? super R> observer = this.actual;
      AtomicReference<ObservableSwitchMap.SwitchMapInnerObserver<T, R>> atomicReference = this.active;
      boolean bool = this.delayErrors;
      int i = 1;
      label79: while (true) {
        if (this.cancelled)
          return; 
        if (this.done) {
          boolean bool1;
          if (atomicReference.get() == null) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (bool) {
            if (bool1) {
              Throwable throwable = (Throwable)this.errors.get();
              if (throwable != null) {
                observer.onError(throwable);
              } else {
                observer.onComplete();
              } 
              return;
            } 
          } else {
            if ((Throwable)this.errors.get() != null) {
              observer.onError(this.errors.terminate());
              return;
            } 
            if (bool1) {
              observer.onComplete();
              return;
            } 
          } 
        } 
        ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver = atomicReference.get();
        if (switchMapInnerObserver != null) {
          SimpleQueue simpleQueue = switchMapInnerObserver.queue;
          if (simpleQueue != null) {
            if (switchMapInnerObserver.done) {
              boolean bool2 = simpleQueue.isEmpty();
              if (bool) {
                if (bool2) {
                  atomicReference.compareAndSet(switchMapInnerObserver, null);
                  continue;
                } 
              } else {
                if ((Throwable)this.errors.get() != null) {
                  observer.onError(this.errors.terminate());
                  return;
                } 
                if (bool2) {
                  atomicReference.compareAndSet(switchMapInnerObserver, null);
                  continue;
                } 
              } 
            } 
            boolean bool1 = false;
            while (true) {
              if (this.cancelled)
                return; 
              if (switchMapInnerObserver != atomicReference.get()) {
                bool1 = true;
              } else {
                boolean bool3;
                if (!bool && (Throwable)this.errors.get() != null) {
                  observer.onError(this.errors.terminate());
                  return;
                } 
                boolean bool2 = switchMapInnerObserver.done;
                try {
                  object = simpleQueue.poll();
                } catch (Throwable object) {
                  Exceptions.throwIfFatal((Throwable)object);
                  this.errors.addThrowable((Throwable)object);
                  atomicReference.compareAndSet(switchMapInnerObserver, null);
                  if (!bool) {
                    disposeInner();
                    this.s.dispose();
                    this.done = true;
                  } else {
                    switchMapInnerObserver.cancel();
                  } 
                  object = null;
                  bool1 = true;
                } 
                if (object == null) {
                  bool3 = true;
                } else {
                  bool3 = false;
                } 
                if (bool2 && bool3) {
                  atomicReference.compareAndSet(switchMapInnerObserver, null);
                  bool1 = true;
                } else if (!bool3) {
                  observer.onNext(object);
                  continue;
                } 
              } 
              if (bool1)
                continue label79; 
              break;
            } 
          } 
        } 
        int j = addAndGet(-i);
        i = j;
        if (j == 0)
          break; 
      } 
    }
    
    void innerError(ObservableSwitchMap.SwitchMapInnerObserver<T, R> param1SwitchMapInnerObserver, Throwable param1Throwable) {
      if (param1SwitchMapInnerObserver.index == this.unique && this.errors.addThrowable(param1Throwable)) {
        if (!this.delayErrors)
          this.s.dispose(); 
        param1SwitchMapInnerObserver.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public boolean isDisposed() {
      return this.cancelled;
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        drain();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (!this.done && this.errors.addThrowable(param1Throwable)) {
        if (!this.delayErrors)
          disposeInner(); 
        this.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      long l = this.unique + 1L;
      this.unique = l;
      ObservableSwitchMap.SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = (ObservableSwitchMap.SwitchMapInnerObserver)this.active.get();
      if (switchMapInnerObserver != null)
        switchMapInnerObserver.cancel(); 
      try {
        ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The ObservableSource returned is null");
        ObservableSwitchMap.SwitchMapInnerObserver<Object, Object> switchMapInnerObserver1 = new ObservableSwitchMap.SwitchMapInnerObserver<Object, Object>(this, l, this.bufferSize);
        while (true) {
          switchMapInnerObserver = (ObservableSwitchMap.SwitchMapInnerObserver)this.active.get();
          if (switchMapInnerObserver == CANCELLED)
            break; 
          if (this.active.compareAndSet(switchMapInnerObserver, switchMapInnerObserver1)) {
            observableSource.subscribe(switchMapInnerObserver1);
            break;
          } 
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.dispose();
        onError(throwable);
        return;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSwitchMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */