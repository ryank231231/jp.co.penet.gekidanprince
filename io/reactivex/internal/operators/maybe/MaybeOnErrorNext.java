package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {
  final boolean allowFatal;
  
  final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;
  
  public MaybeOnErrorNext(MaybeSource<T> paramMaybeSource, Function<? super Throwable, ? extends MaybeSource<? extends T>> paramFunction, boolean paramBoolean) {
    super(paramMaybeSource);
    this.resumeFunction = paramFunction;
    this.allowFatal = paramBoolean;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new OnErrorNextMaybeObserver<T>(paramMaybeObserver, this.resumeFunction, this.allowFatal));
  }
  
  static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 2026620218879969836L;
    
    final MaybeObserver<? super T> actual;
    
    final boolean allowFatal;
    
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;
    
    OnErrorNextMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> param1Function, boolean param1Boolean) {
      this.actual = param1MaybeObserver;
      this.resumeFunction = param1Function;
      this.allowFatal = param1Boolean;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      if (!this.allowFatal && !(param1Throwable instanceof Exception)) {
        this.actual.onError(param1Throwable);
        return;
      } 
      try {
        MaybeSource maybeSource = (MaybeSource)ObjectHelper.requireNonNull(this.resumeFunction.apply(param1Throwable), "The resumeFunction returned a null MaybeSource");
        DisposableHelper.replace(this, null);
        maybeSource.subscribe(new NextMaybeObserver<T>(this.actual, this));
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable))
        this.actual.onSubscribe(this); 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
    
    static final class NextMaybeObserver<T> implements MaybeObserver<T> {
      final MaybeObserver<? super T> actual;
      
      final AtomicReference<Disposable> d;
      
      NextMaybeObserver(MaybeObserver<? super T> param2MaybeObserver, AtomicReference<Disposable> param2AtomicReference) {
        this.actual = param2MaybeObserver;
        this.d = param2AtomicReference;
      }
      
      public void onComplete() {
        this.actual.onComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        this.actual.onError(param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.setOnce(this.d, param2Disposable);
      }
      
      public void onSuccess(T param2T) {
        this.actual.onSuccess(param2T);
      }
    }
  }
  
  static final class NextMaybeObserver<T> implements MaybeObserver<T> {
    final MaybeObserver<? super T> actual;
    
    final AtomicReference<Disposable> d;
    
    NextMaybeObserver(MaybeObserver<? super T> param1MaybeObserver, AtomicReference<Disposable> param1AtomicReference) {
      this.actual = param1MaybeObserver;
      this.d = param1AtomicReference;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this.d, param1Disposable);
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeOnErrorNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */