package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeFilterSingle<T> extends Maybe<T> {
  final Predicate<? super T> predicate;
  
  final SingleSource<T> source;
  
  public MaybeFilterSingle(SingleSource<T> paramSingleSource, Predicate<? super T> paramPredicate) {
    this.source = paramSingleSource;
    this.predicate = paramPredicate;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new FilterMaybeObserver<T>(paramMaybeObserver, this.predicate));
  }
  
  static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    final Predicate<? super T> predicate;
    
    FilterMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, Predicate<? super T> param1Predicate) {
      this.actual = param1MaybeObserver;
      this.predicate = param1Predicate;
    }
    
    public void dispose() {
      Disposable disposable = this.d;
      this.d = (Disposable)DisposableHelper.DISPOSED;
      disposable.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      try {
        boolean bool = this.predicate.test(param1T);
        if (bool) {
          this.actual.onSuccess(param1T);
        } else {
          this.actual.onComplete();
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFilterSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */