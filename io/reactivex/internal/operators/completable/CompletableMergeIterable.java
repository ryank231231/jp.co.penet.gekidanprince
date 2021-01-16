package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable extends Completable {
  final Iterable<? extends CompletableSource> sources;
  
  public CompletableMergeIterable(Iterable<? extends CompletableSource> paramIterable) {
    this.sources = paramIterable;
  }
  
  public void subscribeActual(CompletableObserver paramCompletableObserver) {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    paramCompletableObserver.onSubscribe((Disposable)compositeDisposable);
    try {
      Iterator iterator = (Iterator)ObjectHelper.requireNonNull(this.sources.iterator(), "The source iterator returned is null");
      AtomicInteger atomicInteger = new AtomicInteger(1);
      paramCompletableObserver = new MergeCompletableObserver(paramCompletableObserver, compositeDisposable, atomicInteger);
      while (true) {
        if (compositeDisposable.isDisposed())
          return; 
        try {
          boolean bool = iterator.hasNext();
          if (!bool) {
            paramCompletableObserver.onComplete();
            return;
          } 
          if (compositeDisposable.isDisposed())
            return; 
          try {
            CompletableSource completableSource = (CompletableSource)ObjectHelper.requireNonNull(iterator.next(), "The iterator returned a null CompletableSource");
            if (compositeDisposable.isDisposed())
              return; 
            atomicInteger.getAndIncrement();
            completableSource.subscribe(paramCompletableObserver);
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            compositeDisposable.dispose();
            paramCompletableObserver.onError(throwable);
            return;
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          compositeDisposable.dispose();
          paramCompletableObserver.onError(throwable);
          break;
        } 
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      paramCompletableObserver.onError(throwable);
      return;
    } 
  }
  
  static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
    private static final long serialVersionUID = -7730517613164279224L;
    
    final CompletableObserver actual;
    
    final CompositeDisposable set;
    
    final AtomicInteger wip;
    
    MergeCompletableObserver(CompletableObserver param1CompletableObserver, CompositeDisposable param1CompositeDisposable, AtomicInteger param1AtomicInteger) {
      this.actual = param1CompletableObserver;
      this.set = param1CompositeDisposable;
      this.wip = param1AtomicInteger;
    }
    
    public void onComplete() {
      if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true))
        this.actual.onComplete(); 
    }
    
    public void onError(Throwable param1Throwable) {
      this.set.dispose();
      if (compareAndSet(false, true)) {
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.set.add(param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableMergeIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */