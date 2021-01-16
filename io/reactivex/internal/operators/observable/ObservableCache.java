package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> {
  final AtomicBoolean once;
  
  final CacheState<T> state;
  
  private ObservableCache(Observable<T> paramObservable, CacheState<T> paramCacheState) {
    super((ObservableSource<T>)paramObservable);
    this.state = paramCacheState;
    this.once = new AtomicBoolean();
  }
  
  public static <T> Observable<T> from(Observable<T> paramObservable) {
    return from(paramObservable, 16);
  }
  
  public static <T> Observable<T> from(Observable<T> paramObservable, int paramInt) {
    ObjectHelper.verifyPositive(paramInt, "capacityHint");
    return RxJavaPlugins.onAssembly(new ObservableCache<T>(paramObservable, new CacheState<T>(paramObservable, paramInt)));
  }
  
  int cachedEventCount() {
    return this.state.size();
  }
  
  boolean hasObservers() {
    boolean bool;
    if (((ReplayDisposable[])this.state.observers.get()).length != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean isConnected() {
    return this.state.isConnected;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    ReplayDisposable<T> replayDisposable = new ReplayDisposable<T>(paramObserver, this.state);
    paramObserver.onSubscribe(replayDisposable);
    this.state.addChild(replayDisposable);
    if (!this.once.get() && this.once.compareAndSet(false, true))
      this.state.connect(); 
    replayDisposable.replay();
  }
  
  static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
    static final ObservableCache.ReplayDisposable[] EMPTY = new ObservableCache.ReplayDisposable[0];
    
    static final ObservableCache.ReplayDisposable[] TERMINATED = new ObservableCache.ReplayDisposable[0];
    
    final SequentialDisposable connection;
    
    volatile boolean isConnected;
    
    final AtomicReference<ObservableCache.ReplayDisposable<T>[]> observers;
    
    final Observable<? extends T> source;
    
    boolean sourceDone;
    
    CacheState(Observable<? extends T> param1Observable, int param1Int) {
      super(param1Int);
      this.source = param1Observable;
      this.observers = new AtomicReference(EMPTY);
      this.connection = new SequentialDisposable();
    }
    
    public boolean addChild(ObservableCache.ReplayDisposable<T> param1ReplayDisposable) {
      while (true) {
        ObservableCache.ReplayDisposable[] arrayOfReplayDisposable1 = (ObservableCache.ReplayDisposable[])this.observers.get();
        if (arrayOfReplayDisposable1 == TERMINATED)
          return false; 
        int i = arrayOfReplayDisposable1.length;
        ObservableCache.ReplayDisposable[] arrayOfReplayDisposable2 = new ObservableCache.ReplayDisposable[i + 1];
        System.arraycopy(arrayOfReplayDisposable1, 0, arrayOfReplayDisposable2, 0, i);
        arrayOfReplayDisposable2[i] = param1ReplayDisposable;
        if (this.observers.compareAndSet(arrayOfReplayDisposable1, arrayOfReplayDisposable2))
          return true; 
      } 
    }
    
    public void connect() {
      this.source.subscribe(this);
      this.isConnected = true;
    }
    
    public void onComplete() {
      if (!this.sourceDone) {
        this.sourceDone = true;
        add(NotificationLite.complete());
        this.connection.dispose();
        ObservableCache.ReplayDisposable[] arrayOfReplayDisposable = (ObservableCache.ReplayDisposable[])this.observers.getAndSet(TERMINATED);
        int i = arrayOfReplayDisposable.length;
        for (byte b = 0; b < i; b++)
          arrayOfReplayDisposable[b].replay(); 
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (!this.sourceDone) {
        this.sourceDone = true;
        add(NotificationLite.error(param1Throwable));
        this.connection.dispose();
        ObservableCache.ReplayDisposable[] arrayOfReplayDisposable = (ObservableCache.ReplayDisposable[])this.observers.getAndSet(TERMINATED);
        int i = arrayOfReplayDisposable.length;
        for (byte b = 0; b < i; b++)
          arrayOfReplayDisposable[b].replay(); 
      } 
    }
    
    public void onNext(T param1T) {
      if (!this.sourceDone) {
        add(NotificationLite.next(param1T));
        ObservableCache.ReplayDisposable[] arrayOfReplayDisposable = (ObservableCache.ReplayDisposable[])this.observers.get();
        int i = arrayOfReplayDisposable.length;
        for (byte b = 0; b < i; b++)
          arrayOfReplayDisposable[b].replay(); 
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.connection.update(param1Disposable);
    }
    
    public void removeChild(ObservableCache.ReplayDisposable<T> param1ReplayDisposable) {
      ObservableCache.ReplayDisposable[] arrayOfReplayDisposable1;
      ObservableCache.ReplayDisposable[] arrayOfReplayDisposable2;
      do {
        byte b2;
        arrayOfReplayDisposable1 = (ObservableCache.ReplayDisposable[])this.observers.get();
        int i = arrayOfReplayDisposable1.length;
        if (i == 0)
          return; 
        byte b1 = -1;
        byte b = 0;
        while (true) {
          b2 = b1;
          if (b < i) {
            if (arrayOfReplayDisposable1[b].equals(param1ReplayDisposable)) {
              b2 = b;
              break;
            } 
            b++;
            continue;
          } 
          break;
        } 
        if (b2 < 0)
          return; 
        if (i == 1) {
          arrayOfReplayDisposable2 = EMPTY;
        } else {
          arrayOfReplayDisposable2 = new ObservableCache.ReplayDisposable[i - 1];
          System.arraycopy(arrayOfReplayDisposable1, 0, arrayOfReplayDisposable2, 0, b2);
          System.arraycopy(arrayOfReplayDisposable1, b2 + 1, arrayOfReplayDisposable2, b2, i - b2 - 1);
        } 
      } while (!this.observers.compareAndSet(arrayOfReplayDisposable1, arrayOfReplayDisposable2));
    }
  }
  
  static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 7058506693698832024L;
    
    volatile boolean cancelled;
    
    final Observer<? super T> child;
    
    Object[] currentBuffer;
    
    int currentIndexInBuffer;
    
    int index;
    
    final ObservableCache.CacheState<T> state;
    
    ReplayDisposable(Observer<? super T> param1Observer, ObservableCache.CacheState<T> param1CacheState) {
      this.child = param1Observer;
      this.state = param1CacheState;
    }
    
    public void dispose() {
      if (!this.cancelled) {
        this.cancelled = true;
        this.state.removeChild(this);
      } 
    }
    
    public boolean isDisposed() {
      return this.cancelled;
    }
    
    public void replay() {
      int j;
      if (getAndIncrement() != 0)
        return; 
      Observer<? super T> observer = this.child;
      int i = 1;
      do {
        if (this.cancelled)
          return; 
        int k = this.state.size();
        if (k != 0) {
          Object[] arrayOfObject1 = this.currentBuffer;
          Object[] arrayOfObject2 = arrayOfObject1;
          if (arrayOfObject1 == null) {
            arrayOfObject2 = this.state.head();
            this.currentBuffer = arrayOfObject2;
          } 
          int m = arrayOfObject2.length - 1;
          int n = this.index;
          int i1 = this.currentIndexInBuffer;
          while (n < k) {
            if (this.cancelled)
              return; 
            arrayOfObject1 = arrayOfObject2;
            int i2 = i1;
            if (i1 == m) {
              arrayOfObject1 = (Object[])arrayOfObject2[m];
              i2 = 0;
            } 
            if (NotificationLite.accept(arrayOfObject1[i2], observer))
              return; 
            i1 = i2 + 1;
            n++;
            arrayOfObject2 = arrayOfObject1;
          } 
          if (this.cancelled)
            return; 
          this.index = n;
          this.currentIndexInBuffer = i1;
          this.currentBuffer = arrayOfObject2;
        } 
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */