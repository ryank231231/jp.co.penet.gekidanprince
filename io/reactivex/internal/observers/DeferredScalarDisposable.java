package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.plugins.RxJavaPlugins;

public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
  static final int DISPOSED = 4;
  
  static final int FUSED_CONSUMED = 32;
  
  static final int FUSED_EMPTY = 8;
  
  static final int FUSED_READY = 16;
  
  static final int TERMINATED = 2;
  
  private static final long serialVersionUID = -5502432239815349361L;
  
  protected final Observer<? super T> actual;
  
  protected T value;
  
  public DeferredScalarDisposable(Observer<? super T> paramObserver) {
    this.actual = paramObserver;
  }
  
  public final void clear() {
    lazySet(32);
    this.value = null;
  }
  
  public final void complete() {
    if ((get() & 0x36) != 0)
      return; 
    lazySet(2);
    this.actual.onComplete();
  }
  
  public final void complete(T paramT) {
    int i = get();
    if ((i & 0x36) != 0)
      return; 
    Observer<? super T> observer = this.actual;
    if (i == 8) {
      this.value = paramT;
      lazySet(16);
      observer.onNext(null);
    } else {
      lazySet(2);
      observer.onNext(paramT);
    } 
    if (get() != 4)
      observer.onComplete(); 
  }
  
  public void dispose() {
    set(4);
    this.value = null;
  }
  
  public final void error(Throwable paramThrowable) {
    if ((get() & 0x36) != 0) {
      RxJavaPlugins.onError(paramThrowable);
      return;
    } 
    lazySet(2);
    this.actual.onError(paramThrowable);
  }
  
  public final boolean isDisposed() {
    boolean bool;
    if (get() == 4) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean isEmpty() {
    boolean bool;
    if (get() != 16) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Nullable
  public final T poll() throws Exception {
    if (get() == 16) {
      T t = this.value;
      this.value = null;
      lazySet(32);
      return t;
    } 
    return null;
  }
  
  public final int requestFusion(int paramInt) {
    if ((paramInt & 0x2) != 0) {
      lazySet(8);
      return 2;
    } 
    return 0;
  }
  
  public final boolean tryDispose() {
    boolean bool;
    if (getAndSet(4) != 4) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\DeferredScalarDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */