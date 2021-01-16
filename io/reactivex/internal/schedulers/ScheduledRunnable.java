package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
  static final Object ASYNC_DISPOSED;
  
  static final Object DONE;
  
  static final int FUTURE_INDEX = 1;
  
  static final Object PARENT_DISPOSED = new Object();
  
  static final int PARENT_INDEX = 0;
  
  static final Object SYNC_DISPOSED = new Object();
  
  static final int THREAD_INDEX = 2;
  
  private static final long serialVersionUID = -6120223772001106981L;
  
  final Runnable actual;
  
  static {
    ASYNC_DISPOSED = new Object();
    DONE = new Object();
  }
  
  public ScheduledRunnable(Runnable paramRunnable, DisposableContainer paramDisposableContainer) {
    super(3);
    this.actual = paramRunnable;
    lazySet(0, paramDisposableContainer);
  }
  
  public Object call() {
    run();
    return null;
  }
  
  public void dispose() {
    while (true) {
      boolean bool;
      Object object2;
      Object object1 = get(1);
      if (object1 == DONE || object1 == SYNC_DISPOSED || object1 == ASYNC_DISPOSED)
        break; 
      if (get(2) != Thread.currentThread()) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        object2 = ASYNC_DISPOSED;
      } else {
        object2 = SYNC_DISPOSED;
      } 
      if (compareAndSet(1, object1, object2)) {
        if (object1 != null)
          ((Future)object1).cancel(bool); 
        break;
      } 
    } 
    while (true) {
      Object object = get(0);
      if (object != DONE) {
        Object object1 = PARENT_DISPOSED;
        if (object == object1 || object == null)
          break; 
        if (compareAndSet(0, object, object1)) {
          ((DisposableContainer)object).delete(this);
          return;
        } 
        continue;
      } 
      break;
    } 
  }
  
  public boolean isDisposed() {
    boolean bool = false;
    Object object = get(0);
    if (object == PARENT_DISPOSED || object == DONE)
      bool = true; 
    return bool;
  }
  
  public void run() {
    lazySet(2, Thread.currentThread());
    try {
      this.actual.run();
    } catch (Throwable throwable) {
      RxJavaPlugins.onError(throwable);
    } finally {
      Exception exception;
    } 
    lazySet(2, null);
    Object object = get(0);
    if (object != PARENT_DISPOSED && compareAndSet(0, object, DONE) && object != null)
      ((DisposableContainer)object).delete(this); 
    do {
      object = get(1);
    } while (object != SYNC_DISPOSED && object != ASYNC_DISPOSED && !compareAndSet(1, object, DONE));
  }
  
  public void setFuture(Future<?> paramFuture) {
    Object object;
    do {
      object = get(1);
      if (object == DONE)
        return; 
      if (object == SYNC_DISPOSED) {
        paramFuture.cancel(false);
        return;
      } 
      if (object == ASYNC_DISPOSED) {
        paramFuture.cancel(true);
        return;
      } 
    } while (!compareAndSet(1, object, paramFuture));
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\schedulers\ScheduledRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */