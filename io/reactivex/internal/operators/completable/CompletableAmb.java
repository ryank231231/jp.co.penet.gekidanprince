package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableAmb extends Completable {
  private final CompletableSource[] sources;
  
  private final Iterable<? extends CompletableSource> sourcesIterable;
  
  public CompletableAmb(CompletableSource[] paramArrayOfCompletableSource, Iterable<? extends CompletableSource> paramIterable) {
    this.sources = paramArrayOfCompletableSource;
    this.sourcesIterable = paramIterable;
  }
  
  public void subscribeActual(CompletableObserver paramCompletableObserver) {
    int i;
    CompletableSource[] arrayOfCompletableSource = this.sources;
    if (arrayOfCompletableSource == null) {
      CompletableSource[] arrayOfCompletableSource1 = new CompletableSource[8];
      try {
        Iterator<? extends CompletableSource> iterator = this.sourcesIterable.iterator();
        byte b1 = 0;
        while (true) {
          arrayOfCompletableSource = arrayOfCompletableSource1;
          i = b1;
          if (iterator.hasNext()) {
            NullPointerException nullPointerException2;
            CompletableSource completableSource = iterator.next();
            if (completableSource == null) {
              nullPointerException2 = new NullPointerException();
              this("One of the sources is null");
              EmptyDisposable.error(nullPointerException2, paramCompletableObserver);
              return;
            } 
            NullPointerException nullPointerException1 = nullPointerException2;
            if (b1 == nullPointerException2.length) {
              arrayOfCompletableSource = new CompletableSource[(b1 >> 2) + b1];
              System.arraycopy(nullPointerException2, 0, arrayOfCompletableSource, 0, b1);
            } 
            arrayOfCompletableSource[b1] = completableSource;
            b1++;
            CompletableSource[] arrayOfCompletableSource2 = arrayOfCompletableSource;
            continue;
          } 
          break;
        } 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramCompletableObserver);
        return;
      } 
    } else {
      i = arrayOfCompletableSource.length;
    } 
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    paramCompletableObserver.onSubscribe((Disposable)compositeDisposable);
    AtomicBoolean atomicBoolean = new AtomicBoolean();
    Amb amb = new Amb(atomicBoolean, compositeDisposable, paramCompletableObserver);
    for (byte b = 0; b < i; b++) {
      CompletableSource completableSource = arrayOfCompletableSource[b];
      if (compositeDisposable.isDisposed())
        return; 
      if (completableSource == null) {
        NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
        if (atomicBoolean.compareAndSet(false, true)) {
          compositeDisposable.dispose();
          paramCompletableObserver.onError(nullPointerException);
        } else {
          RxJavaPlugins.onError(nullPointerException);
        } 
        return;
      } 
      completableSource.subscribe(amb);
    } 
    if (i == 0)
      paramCompletableObserver.onComplete(); 
  }
  
  static final class Amb implements CompletableObserver {
    private final AtomicBoolean once;
    
    private final CompletableObserver s;
    
    private final CompositeDisposable set;
    
    Amb(AtomicBoolean param1AtomicBoolean, CompositeDisposable param1CompositeDisposable, CompletableObserver param1CompletableObserver) {
      this.once = param1AtomicBoolean;
      this.set = param1CompositeDisposable;
      this.s = param1CompletableObserver;
    }
    
    public void onComplete() {
      if (this.once.compareAndSet(false, true)) {
        this.set.dispose();
        this.s.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.once.compareAndSet(false, true)) {
        this.set.dispose();
        this.s.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.set.add(param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */