package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MaybeAmb<T> extends Maybe<T> {
  private final MaybeSource<? extends T>[] sources;
  
  private final Iterable<? extends MaybeSource<? extends T>> sourcesIterable;
  
  public MaybeAmb(MaybeSource<? extends T>[] paramArrayOfMaybeSource, Iterable<? extends MaybeSource<? extends T>> paramIterable) {
    this.sources = paramArrayOfMaybeSource;
    this.sourcesIterable = paramIterable;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    MaybeSource[] arrayOfMaybeSource;
    int i;
    MaybeSource<? extends T>[] arrayOfMaybeSource1 = this.sources;
    byte b1 = 0;
    if (arrayOfMaybeSource1 == null) {
      MaybeSource[] arrayOfMaybeSource2 = new MaybeSource[8];
      try {
        Iterator<? extends MaybeSource<? extends T>> iterator = this.sourcesIterable.iterator();
        byte b = 0;
        while (true) {
          arrayOfMaybeSource = arrayOfMaybeSource2;
          i = b;
          if (iterator.hasNext()) {
            NullPointerException nullPointerException2;
            MaybeSource maybeSource = iterator.next();
            if (maybeSource == null) {
              nullPointerException2 = new NullPointerException();
              this("One of the sources is null");
              EmptyDisposable.error(nullPointerException2, paramMaybeObserver);
              return;
            } 
            NullPointerException nullPointerException1 = nullPointerException2;
            if (b == nullPointerException2.length) {
              arrayOfMaybeSource = new MaybeSource[(b >> 2) + b];
              System.arraycopy(nullPointerException2, 0, arrayOfMaybeSource, 0, b);
            } 
            arrayOfMaybeSource[b] = maybeSource;
            b++;
            MaybeSource[] arrayOfMaybeSource3 = arrayOfMaybeSource;
            continue;
          } 
          break;
        } 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramMaybeObserver);
        return;
      } 
    } else {
      i = arrayOfMaybeSource.length;
    } 
    AmbMaybeObserver<T> ambMaybeObserver = new AmbMaybeObserver<T>(paramMaybeObserver);
    paramMaybeObserver.onSubscribe(ambMaybeObserver);
    for (byte b2 = b1; b2 < i; b2++) {
      MaybeSource maybeSource = arrayOfMaybeSource[b2];
      if (ambMaybeObserver.isDisposed())
        return; 
      if (maybeSource == null) {
        ambMaybeObserver.onError(new NullPointerException("One of the MaybeSources is null"));
        return;
      } 
      maybeSource.subscribe(ambMaybeObserver);
    } 
    if (i == 0)
      paramMaybeObserver.onComplete(); 
  }
  
  static final class AmbMaybeObserver<T> extends AtomicBoolean implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = -7044685185359438206L;
    
    final MaybeObserver<? super T> actual;
    
    final CompositeDisposable set;
    
    AmbMaybeObserver(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
      this.set = new CompositeDisposable();
    }
    
    public void dispose() {
      if (compareAndSet(false, true))
        this.set.dispose(); 
    }
    
    public boolean isDisposed() {
      return get();
    }
    
    public void onComplete() {
      if (compareAndSet(false, true)) {
        this.set.dispose();
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (compareAndSet(false, true)) {
        this.set.dispose();
        this.actual.onError(param1Throwable);
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
        this.actual.onSuccess(param1T);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */