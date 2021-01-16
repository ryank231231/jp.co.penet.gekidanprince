package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
  final T defaultValue;
  
  final boolean errorOnFewer;
  
  final long index;
  
  public ObservableElementAt(ObservableSource<T> paramObservableSource, long paramLong, T paramT, boolean paramBoolean) {
    super(paramObservableSource);
    this.index = paramLong;
    this.defaultValue = paramT;
    this.errorOnFewer = paramBoolean;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(new ElementAtObserver<T>(paramObserver, this.index, this.defaultValue, this.errorOnFewer));
  }
  
  static final class ElementAtObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    
    long count;
    
    final T defaultValue;
    
    boolean done;
    
    final boolean errorOnFewer;
    
    final long index;
    
    Disposable s;
    
    ElementAtObserver(Observer<? super T> param1Observer, long param1Long, T param1T, boolean param1Boolean) {
      this.actual = param1Observer;
      this.index = param1Long;
      this.defaultValue = param1T;
      this.errorOnFewer = param1Boolean;
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        T t = this.defaultValue;
        if (t == null && this.errorOnFewer) {
          this.actual.onError(new NoSuchElementException());
        } else {
          if (t != null)
            this.actual.onNext(t); 
          this.actual.onComplete();
        } 
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      long l = this.count;
      if (l == this.index) {
        this.done = true;
        this.s.dispose();
        this.actual.onNext(param1T);
        this.actual.onComplete();
        return;
      } 
      this.count = l + 1L;
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableElementAt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */