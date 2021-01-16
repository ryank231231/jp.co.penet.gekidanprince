package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty<T> extends AbstractMaybeWithUpstream<T, T> {
  final MaybeSource<? extends T> other;
  
  public MaybeSwitchIfEmpty(MaybeSource<T> paramMaybeSource, MaybeSource<? extends T> paramMaybeSource1) {
    super(paramMaybeSource);
    this.other = paramMaybeSource1;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new SwitchIfEmptyMaybeObserver<T>(paramMaybeObserver, this.other));
  }
  
  static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = -2223459372976438024L;
    
    final MaybeObserver<? super T> actual;
    
    final MaybeSource<? extends T> other;
    
    SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, MaybeSource<? extends T> param1MaybeSource) {
      this.actual = param1MaybeObserver;
      this.other = param1MaybeSource;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      Disposable disposable = get();
      if (disposable != DisposableHelper.DISPOSED && compareAndSet(disposable, null))
        this.other.subscribe(new OtherMaybeObserver<T>(this.actual, this)); 
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable))
        this.actual.onSubscribe(this); 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
    
    static final class OtherMaybeObserver<T> implements MaybeObserver<T> {
      final MaybeObserver<? super T> actual;
      
      final AtomicReference<Disposable> parent;
      
      OtherMaybeObserver(MaybeObserver<? super T> param2MaybeObserver, AtomicReference<Disposable> param2AtomicReference) {
        this.actual = param2MaybeObserver;
        this.parent = param2AtomicReference;
      }
      
      public void onComplete() {
        this.actual.onComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        this.actual.onError(param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.setOnce(this.parent, param2Disposable);
      }
      
      public void onSuccess(T param2T) {
        this.actual.onSuccess(param2T);
      }
    }
  }
  
  static final class OtherMaybeObserver<T> implements MaybeObserver<T> {
    final MaybeObserver<? super T> actual;
    
    final AtomicReference<Disposable> parent;
    
    OtherMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, AtomicReference<Disposable> param1AtomicReference) {
      this.actual = param1MaybeObserver;
      this.parent = param1AtomicReference;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this.parent, param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeSwitchIfEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */