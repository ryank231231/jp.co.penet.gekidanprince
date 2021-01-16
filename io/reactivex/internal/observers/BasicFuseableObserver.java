package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
  protected final Observer<? super R> actual;
  
  protected boolean done;
  
  protected QueueDisposable<T> qs;
  
  protected Disposable s;
  
  protected int sourceMode;
  
  public BasicFuseableObserver(Observer<? super R> paramObserver) {
    this.actual = paramObserver;
  }
  
  protected void afterDownstream() {}
  
  protected boolean beforeDownstream() {
    return true;
  }
  
  public void clear() {
    this.qs.clear();
  }
  
  public void dispose() {
    this.s.dispose();
  }
  
  protected final void fail(Throwable paramThrowable) {
    Exceptions.throwIfFatal(paramThrowable);
    this.s.dispose();
    onError(paramThrowable);
  }
  
  public boolean isDisposed() {
    return this.s.isDisposed();
  }
  
  public boolean isEmpty() {
    return this.qs.isEmpty();
  }
  
  public final boolean offer(R paramR) {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public final boolean offer(R paramR1, R paramR2) {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public void onComplete() {
    if (this.done)
      return; 
    this.done = true;
    this.actual.onComplete();
  }
  
  public void onError(Throwable paramThrowable) {
    if (this.done) {
      RxJavaPlugins.onError(paramThrowable);
      return;
    } 
    this.done = true;
    this.actual.onError(paramThrowable);
  }
  
  public final void onSubscribe(Disposable paramDisposable) {
    if (DisposableHelper.validate(this.s, paramDisposable)) {
      this.s = paramDisposable;
      if (paramDisposable instanceof QueueDisposable)
        this.qs = (QueueDisposable<T>)paramDisposable; 
      if (beforeDownstream()) {
        this.actual.onSubscribe((Disposable)this);
        afterDownstream();
      } 
    } 
  }
  
  protected final int transitiveBoundaryFusion(int paramInt) {
    QueueDisposable<T> queueDisposable = this.qs;
    if (queueDisposable != null && (paramInt & 0x4) == 0) {
      paramInt = queueDisposable.requestFusion(paramInt);
      if (paramInt != 0)
        this.sourceMode = paramInt; 
      return paramInt;
    } 
    return 0;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\BasicFuseableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */