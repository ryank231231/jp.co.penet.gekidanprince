package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {
  final int count;
  
  public ObservableTakeLast(ObservableSource<T> paramObservableSource, int paramInt) {
    super(paramObservableSource);
    this.count = paramInt;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new TakeLastObserver<T>(paramObserver, this.count));
  }
  
  static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
    private static final long serialVersionUID = 7240042530241604978L;
    
    final Observer<? super T> actual;
    
    volatile boolean cancelled;
    
    final int count;
    
    Disposable s;
    
    TakeLastObserver(Observer<? super T> param1Observer, int param1Int) {
      this.actual = param1Observer;
      this.count = param1Int;
    }
    
    public void dispose() {
      if (!this.cancelled) {
        this.cancelled = true;
        this.s.dispose();
      } 
    }
    
    public boolean isDisposed() {
      return this.cancelled;
    }
    
    public void onComplete() {
      Observer<? super T> observer = this.actual;
      while (true) {
        if (this.cancelled)
          return; 
        T t = poll();
        if (t == null) {
          if (!this.cancelled)
            observer.onComplete(); 
          return;
        } 
        observer.onNext(t);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.count == size())
        poll(); 
      offer(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTakeLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */