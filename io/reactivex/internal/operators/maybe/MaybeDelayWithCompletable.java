package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelayWithCompletable<T> extends Maybe<T> {
  final CompletableSource other;
  
  final MaybeSource<T> source;
  
  public MaybeDelayWithCompletable(MaybeSource<T> paramMaybeSource, CompletableSource paramCompletableSource) {
    this.source = paramMaybeSource;
    this.other = paramCompletableSource;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.other.subscribe(new OtherObserver<T>(paramMaybeObserver, this.source));
  }
  
  static final class DelayWithMainObserver<T> implements MaybeObserver<T> {
    final MaybeObserver<? super T> actual;
    
    final AtomicReference<Disposable> parent;
    
    DelayWithMainObserver(AtomicReference<Disposable> param1AtomicReference, MaybeObserver<? super T> param1MaybeObserver) {
      this.parent = param1AtomicReference;
      this.actual = param1MaybeObserver;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.replace(this.parent, param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
  
  static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 703409937383992161L;
    
    final MaybeObserver<? super T> actual;
    
    final MaybeSource<T> source;
    
    OtherObserver(MaybeObserver<? super T> param1MaybeObserver, MaybeSource<T> param1MaybeSource) {
      this.actual = param1MaybeObserver;
      this.source = param1MaybeSource;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      this.source.subscribe(new MaybeDelayWithCompletable.DelayWithMainObserver<T>(this, this.actual));
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable))
        this.actual.onSubscribe(this); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDelayWithCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */