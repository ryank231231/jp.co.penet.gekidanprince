package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

@Experimental
public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
  final Action onFinally;
  
  public ObservableDoFinally(ObservableSource<T> paramObservableSource, Action paramAction) {
    super(paramObservableSource);
    this.onFinally = paramAction;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new DoFinallyObserver<T>(paramObserver, this.onFinally));
  }
  
  static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    
    final Observer<? super T> actual;
    
    Disposable d;
    
    final Action onFinally;
    
    QueueDisposable<T> qd;
    
    boolean syncFused;
    
    DoFinallyObserver(Observer<? super T> param1Observer, Action param1Action) {
      this.actual = param1Observer;
      this.onFinally = param1Action;
    }
    
    public void clear() {
      this.qd.clear();
    }
    
    public void dispose() {
      this.d.dispose();
      runFinally();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public boolean isEmpty() {
      return this.qd.isEmpty();
    }
    
    public void onComplete() {
      this.actual.onComplete();
      runFinally();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
      runFinally();
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        if (param1Disposable instanceof QueueDisposable)
          this.qd = (QueueDisposable<T>)param1Disposable; 
        this.actual.onSubscribe((Disposable)this);
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      Object object = this.qd.poll();
      if (object == null && this.syncFused)
        runFinally(); 
      return (T)object;
    }
    
    public int requestFusion(int param1Int) {
      QueueDisposable<T> queueDisposable = this.qd;
      if (queueDisposable != null && (param1Int & 0x4) == 0) {
        param1Int = queueDisposable.requestFusion(param1Int);
        if (param1Int != 0) {
          boolean bool = true;
          if (param1Int != 1)
            bool = false; 
          this.syncFused = bool;
        } 
        return param1Int;
      } 
      return 0;
    }
    
    void runFinally() {
      if (compareAndSet(0, 1))
        try {
          this.onFinally.run();
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        }  
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */