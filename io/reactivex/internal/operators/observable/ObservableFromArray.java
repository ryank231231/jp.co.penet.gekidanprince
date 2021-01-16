package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class ObservableFromArray<T> extends Observable<T> {
  final T[] array;
  
  public ObservableFromArray(T[] paramArrayOfT) {
    this.array = paramArrayOfT;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    FromArrayDisposable<T> fromArrayDisposable = new FromArrayDisposable<T>(paramObserver, this.array);
    paramObserver.onSubscribe((Disposable)fromArrayDisposable);
    if (fromArrayDisposable.fusionMode)
      return; 
    fromArrayDisposable.run();
  }
  
  static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {
    final Observer<? super T> actual;
    
    final T[] array;
    
    volatile boolean disposed;
    
    boolean fusionMode;
    
    int index;
    
    FromArrayDisposable(Observer<? super T> param1Observer, T[] param1ArrayOfT) {
      this.actual = param1Observer;
      this.array = param1ArrayOfT;
    }
    
    public void clear() {
      this.index = this.array.length;
    }
    
    public void dispose() {
      this.disposed = true;
    }
    
    public boolean isDisposed() {
      return this.disposed;
    }
    
    public boolean isEmpty() {
      boolean bool;
      if (this.index == this.array.length) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    @Nullable
    public T poll() {
      int i = this.index;
      T[] arrayOfT = this.array;
      if (i != arrayOfT.length) {
        this.index = i + 1;
        return (T)ObjectHelper.requireNonNull(arrayOfT[i], "The array element is null");
      } 
      return null;
    }
    
    public int requestFusion(int param1Int) {
      if ((param1Int & 0x1) != 0) {
        this.fusionMode = true;
        return 1;
      } 
      return 0;
    }
    
    void run() {
      T[] arrayOfT = this.array;
      int i = arrayOfT.length;
      for (byte b = 0; b < i && !isDisposed(); b++) {
        Observer<? super T> observer;
        T t = arrayOfT[b];
        if (t == null) {
          observer = this.actual;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("The ");
          stringBuilder.append(b);
          stringBuilder.append("th element is null");
          observer.onError(new NullPointerException(stringBuilder.toString()));
          return;
        } 
        this.actual.onNext(observer);
      } 
      if (!isDisposed())
        this.actual.onComplete(); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFromArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */