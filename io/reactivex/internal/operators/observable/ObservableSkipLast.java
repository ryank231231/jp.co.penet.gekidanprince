package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {
  final int skip;
  
  public ObservableSkipLast(ObservableSource<T> paramObservableSource, int paramInt) {
    super(paramObservableSource);
    this.skip = paramInt;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new SkipLastObserver<T>(paramObserver, this.skip));
  }
  
  static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -3807491841935125653L;
    
    final Observer<? super T> actual;
    
    Disposable s;
    
    final int skip;
    
    SkipLastObserver(Observer<? super T> param1Observer, int param1Int) {
      super(param1Int);
      this.actual = param1Observer;
      this.skip = param1Int;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.skip == size())
        this.actual.onNext(poll()); 
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSkipLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */