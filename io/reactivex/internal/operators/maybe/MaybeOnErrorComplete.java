package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeOnErrorComplete<T> extends AbstractMaybeWithUpstream<T, T> {
  final Predicate<? super Throwable> predicate;
  
  public MaybeOnErrorComplete(MaybeSource<T> paramMaybeSource, Predicate<? super Throwable> paramPredicate) {
    super(paramMaybeSource);
    this.predicate = paramPredicate;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new OnErrorCompleteMaybeObserver<T>(paramMaybeObserver, this.predicate));
  }
  
  static final class OnErrorCompleteMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    final Predicate<? super Throwable> predicate;
    
    OnErrorCompleteMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, Predicate<? super Throwable> param1Predicate) {
      this.actual = param1MaybeObserver;
      this.predicate = param1Predicate;
    }
    
    public void dispose() {
      this.d.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        boolean bool = this.predicate.test(param1Throwable);
        if (bool) {
          this.actual.onComplete();
        } else {
          this.actual.onError(param1Throwable);
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeOnErrorComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */