package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleAmb<T> extends Single<T> {
  private final SingleSource<? extends T>[] sources;
  
  private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;
  
  public SingleAmb(SingleSource<? extends T>[] paramArrayOfSingleSource, Iterable<? extends SingleSource<? extends T>> paramIterable) {
    this.sources = paramArrayOfSingleSource;
    this.sourcesIterable = paramIterable;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    SingleSource[] arrayOfSingleSource;
    int i;
    SingleSource<? extends T>[] arrayOfSingleSource1 = this.sources;
    if (arrayOfSingleSource1 == null) {
      SingleSource[] arrayOfSingleSource2 = new SingleSource[8];
      try {
        Iterator<? extends SingleSource<? extends T>> iterator = this.sourcesIterable.iterator();
        byte b1 = 0;
        while (true) {
          arrayOfSingleSource = arrayOfSingleSource2;
          i = b1;
          if (iterator.hasNext()) {
            NullPointerException nullPointerException2;
            SingleSource singleSource = iterator.next();
            if (singleSource == null) {
              nullPointerException2 = new NullPointerException();
              this("One of the sources is null");
              EmptyDisposable.error(nullPointerException2, paramSingleObserver);
              return;
            } 
            NullPointerException nullPointerException1 = nullPointerException2;
            if (b1 == nullPointerException2.length) {
              arrayOfSingleSource = new SingleSource[(b1 >> 2) + b1];
              System.arraycopy(nullPointerException2, 0, arrayOfSingleSource, 0, b1);
            } 
            arrayOfSingleSource[b1] = singleSource;
            b1++;
            SingleSource[] arrayOfSingleSource3 = arrayOfSingleSource;
            continue;
          } 
          break;
        } 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramSingleObserver);
        return;
      } 
    } else {
      i = arrayOfSingleSource.length;
    } 
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    AmbSingleObserver<T> ambSingleObserver = new AmbSingleObserver<T>(paramSingleObserver, compositeDisposable);
    paramSingleObserver.onSubscribe((Disposable)compositeDisposable);
    for (byte b = 0; b < i; b++) {
      SingleSource singleSource = arrayOfSingleSource[b];
      if (ambSingleObserver.get())
        return; 
      if (singleSource == null) {
        compositeDisposable.dispose();
        NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
        if (ambSingleObserver.compareAndSet(false, true)) {
          paramSingleObserver.onError(nullPointerException);
        } else {
          RxJavaPlugins.onError(nullPointerException);
        } 
        return;
      } 
      singleSource.subscribe(ambSingleObserver);
    } 
  }
  
  static final class AmbSingleObserver<T> extends AtomicBoolean implements SingleObserver<T> {
    private static final long serialVersionUID = -1944085461036028108L;
    
    final SingleObserver<? super T> s;
    
    final CompositeDisposable set;
    
    AmbSingleObserver(SingleObserver<? super T> param1SingleObserver, CompositeDisposable param1CompositeDisposable) {
      this.s = param1SingleObserver;
      this.set = param1CompositeDisposable;
    }
    
    public void onError(Throwable param1Throwable) {
      if (compareAndSet(false, true)) {
        this.set.dispose();
        this.s.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.set.add(param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      if (compareAndSet(false, true)) {
        this.set.dispose();
        this.s.onSuccess(param1T);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */