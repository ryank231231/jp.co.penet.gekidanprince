package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeDelayErrorIterable extends Completable {
  final Iterable<? extends CompletableSource> sources;
  
  public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> paramIterable) {
    this.sources = paramIterable;
  }
  
  public void subscribeActual(CompletableObserver paramCompletableObserver) {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    paramCompletableObserver.onSubscribe((Disposable)compositeDisposable);
    try {
      Iterator iterator = (Iterator)ObjectHelper.requireNonNull(this.sources.iterator(), "The source iterator returned is null");
      AtomicInteger atomicInteger = new AtomicInteger(1);
      AtomicThrowable atomicThrowable = new AtomicThrowable();
      while (true) {
        if (compositeDisposable.isDisposed())
          return; 
        try {
          boolean bool = iterator.hasNext();
          if (!bool)
            break; 
          if (compositeDisposable.isDisposed())
            return; 
          try {
            CompletableSource completableSource = (CompletableSource)ObjectHelper.requireNonNull(iterator.next(), "The iterator returned a null CompletableSource");
            if (compositeDisposable.isDisposed())
              return; 
            atomicInteger.getAndIncrement();
            completableSource.subscribe(new CompletableMergeDelayErrorArray.MergeInnerCompletableObserver(paramCompletableObserver, compositeDisposable, atomicThrowable, atomicInteger));
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            atomicThrowable.addThrowable(throwable);
            break;
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          atomicThrowable.addThrowable(throwable);
          break;
        } 
      } 
      if (atomicInteger.decrementAndGet() == 0) {
        Throwable throwable = atomicThrowable.terminate();
        if (throwable == null) {
          paramCompletableObserver.onComplete();
        } else {
          paramCompletableObserver.onError(throwable);
        } 
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      paramCompletableObserver.onError(throwable);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableMergeDelayErrorIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */