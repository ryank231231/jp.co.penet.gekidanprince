package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatIterable extends Completable {
  final Iterable<? extends CompletableSource> sources;
  
  public CompletableConcatIterable(Iterable<? extends CompletableSource> paramIterable) {
    this.sources = paramIterable;
  }
  
  public void subscribeActual(CompletableObserver paramCompletableObserver) {
    try {
      Iterator<? extends CompletableSource> iterator = (Iterator)ObjectHelper.requireNonNull(this.sources.iterator(), "The iterator returned is null");
      ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(paramCompletableObserver, iterator);
      paramCompletableObserver.onSubscribe((Disposable)concatInnerObserver.sd);
      concatInnerObserver.next();
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramCompletableObserver);
      return;
    } 
  }
  
  static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
    private static final long serialVersionUID = -7965400327305809232L;
    
    final CompletableObserver actual;
    
    final SequentialDisposable sd;
    
    final Iterator<? extends CompletableSource> sources;
    
    ConcatInnerObserver(CompletableObserver param1CompletableObserver, Iterator<? extends CompletableSource> param1Iterator) {
      this.actual = param1CompletableObserver;
      this.sources = param1Iterator;
      this.sd = new SequentialDisposable();
    }
    
    void next() {
      if (this.sd.isDisposed())
        return; 
      if (getAndIncrement() != 0)
        return; 
      Iterator<? extends CompletableSource> iterator = this.sources;
      while (true) {
        if (this.sd.isDisposed())
          return; 
        try {
          boolean bool = iterator.hasNext();
          if (!bool) {
            this.actual.onComplete();
            return;
          } 
          try {
            CompletableSource completableSource = (CompletableSource)ObjectHelper.requireNonNull(iterator.next(), "The CompletableSource returned is null");
            completableSource.subscribe(this);
            if (decrementAndGet() == 0)
              return; 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.actual.onError(throwable);
            return;
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.actual.onError(throwable);
          break;
        } 
      } 
    }
    
    public void onComplete() {
      next();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.sd.replace(param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableConcatIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */