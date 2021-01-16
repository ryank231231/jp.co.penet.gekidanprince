package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
  final int capacityHint;
  
  final long count;
  
  final long skip;
  
  public ObservableWindow(ObservableSource<T> paramObservableSource, long paramLong1, long paramLong2, int paramInt) {
    super(paramObservableSource);
    this.count = paramLong1;
    this.skip = paramLong2;
    this.capacityHint = paramInt;
  }
  
  public void subscribeActual(Observer<? super Observable<T>> paramObserver) {
    if (this.count == this.skip) {
      this.source.subscribe(new WindowExactObserver<T>(paramObserver, this.count, this.capacityHint));
    } else {
      this.source.subscribe(new WindowSkipObserver<T>(paramObserver, this.count, this.skip, this.capacityHint));
    } 
  }
  
  static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
    private static final long serialVersionUID = -7481782523886138128L;
    
    final Observer<? super Observable<T>> actual;
    
    volatile boolean cancelled;
    
    final int capacityHint;
    
    final long count;
    
    Disposable s;
    
    long size;
    
    UnicastSubject<T> window;
    
    WindowExactObserver(Observer<? super Observable<T>> param1Observer, long param1Long, int param1Int) {
      this.actual = param1Observer;
      this.count = param1Long;
      this.capacityHint = param1Int;
    }
    
    public void dispose() {
      this.cancelled = true;
    }
    
    public boolean isDisposed() {
      return this.cancelled;
    }
    
    public void onComplete() {
      UnicastSubject<T> unicastSubject = this.window;
      if (unicastSubject != null) {
        this.window = null;
        unicastSubject.onComplete();
      } 
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      UnicastSubject<T> unicastSubject = this.window;
      if (unicastSubject != null) {
        this.window = null;
        unicastSubject.onError(param1Throwable);
      } 
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      UnicastSubject<T> unicastSubject1 = this.window;
      UnicastSubject<T> unicastSubject2 = unicastSubject1;
      if (unicastSubject1 == null) {
        unicastSubject2 = unicastSubject1;
        if (!this.cancelled) {
          unicastSubject2 = UnicastSubject.create(this.capacityHint, this);
          this.window = unicastSubject2;
          this.actual.onNext(unicastSubject2);
        } 
      } 
      if (unicastSubject2 != null) {
        unicastSubject2.onNext(param1T);
        long l = this.size + 1L;
        this.size = l;
        if (l >= this.count) {
          this.size = 0L;
          this.window = null;
          unicastSubject2.onComplete();
          if (this.cancelled)
            this.s.dispose(); 
        } 
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void run() {
      if (this.cancelled)
        this.s.dispose(); 
    }
  }
  
  static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
    private static final long serialVersionUID = 3366976432059579510L;
    
    final Observer<? super Observable<T>> actual;
    
    volatile boolean cancelled;
    
    final int capacityHint;
    
    final long count;
    
    long firstEmission;
    
    long index;
    
    Disposable s;
    
    final long skip;
    
    final ArrayDeque<UnicastSubject<T>> windows;
    
    final AtomicInteger wip = new AtomicInteger();
    
    WindowSkipObserver(Observer<? super Observable<T>> param1Observer, long param1Long1, long param1Long2, int param1Int) {
      this.actual = param1Observer;
      this.count = param1Long1;
      this.skip = param1Long2;
      this.capacityHint = param1Int;
      this.windows = new ArrayDeque<UnicastSubject<T>>();
    }
    
    public void dispose() {
      this.cancelled = true;
    }
    
    public boolean isDisposed() {
      return this.cancelled;
    }
    
    public void onComplete() {
      ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
      while (!arrayDeque.isEmpty())
        ((UnicastSubject)arrayDeque.poll()).onComplete(); 
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
      while (!arrayDeque.isEmpty())
        ((UnicastSubject)arrayDeque.poll()).onError(param1Throwable); 
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
      long l1 = this.index;
      long l2 = this.skip;
      if (l1 % l2 == 0L && !this.cancelled) {
        this.wip.getAndIncrement();
        UnicastSubject<T> unicastSubject = UnicastSubject.create(this.capacityHint, this);
        arrayDeque.offer(unicastSubject);
        this.actual.onNext(unicastSubject);
      } 
      long l3 = this.firstEmission + 1L;
      Iterator<UnicastSubject<T>> iterator = arrayDeque.iterator();
      while (iterator.hasNext())
        ((UnicastSubject)iterator.next()).onNext(param1T); 
      if (l3 >= this.count) {
        ((UnicastSubject)arrayDeque.poll()).onComplete();
        if (arrayDeque.isEmpty() && this.cancelled) {
          this.s.dispose();
          return;
        } 
        this.firstEmission = l3 - l2;
      } else {
        this.firstEmission = l3;
      } 
      this.index = l1 + 1L;
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void run() {
      if (this.wip.decrementAndGet() == 0 && this.cancelled)
        this.s.dispose(); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */