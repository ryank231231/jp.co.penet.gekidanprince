package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableUsing<R> extends Completable {
  final Function<? super R, ? extends CompletableSource> completableFunction;
  
  final Consumer<? super R> disposer;
  
  final boolean eager;
  
  final Callable<R> resourceSupplier;
  
  public CompletableUsing(Callable<R> paramCallable, Function<? super R, ? extends CompletableSource> paramFunction, Consumer<? super R> paramConsumer, boolean paramBoolean) {
    this.resourceSupplier = paramCallable;
    this.completableFunction = paramFunction;
    this.disposer = paramConsumer;
    this.eager = paramBoolean;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    try {
      R r = this.resourceSupplier.call();
      try {
        CompletableSource completableSource = (CompletableSource)ObjectHelper.requireNonNull(this.completableFunction.apply(r), "The completableFunction returned a null CompletableSource");
        completableSource.subscribe(new UsingObserver<R>(paramCompletableObserver, r, this.disposer, this.eager));
        return;
      } catch (Throwable throwable2) {
        Exceptions.throwIfFatal(throwable2);
        if (this.eager)
          try {
            this.disposer.accept(r);
          } catch (Throwable throwable1) {
            Exceptions.throwIfFatal(throwable1);
            EmptyDisposable.error((Throwable)new CompositeException(new Throwable[] { throwable2, throwable1 }, ), paramCompletableObserver);
            return;
          }  
        EmptyDisposable.error(throwable2, paramCompletableObserver);
        if (!this.eager)
          try {
            this.disposer.accept(throwable1);
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            RxJavaPlugins.onError(throwable);
          }  
        return;
      } 
    } catch (Throwable throwable1) {
      Exceptions.throwIfFatal(throwable1);
      EmptyDisposable.error(throwable1, (CompletableObserver)throwable);
      return;
    } 
  }
  
  static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
    private static final long serialVersionUID = -674404550052917487L;
    
    final CompletableObserver actual;
    
    Disposable d;
    
    final Consumer<? super R> disposer;
    
    final boolean eager;
    
    UsingObserver(CompletableObserver param1CompletableObserver, R param1R, Consumer<? super R> param1Consumer, boolean param1Boolean) {
      super(param1R);
      this.actual = param1CompletableObserver;
      this.disposer = param1Consumer;
      this.eager = param1Boolean;
    }
    
    public void dispose() {
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
      disposeResourceAfter();
    }
    
    void disposeResourceAfter() {
      Object object = getAndSet(this);
      if (object != this)
        try {
          this.disposer.accept(object);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        }  
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      if (this.eager) {
        Object object = getAndSet(this);
        if (object != this) {
          try {
            this.disposer.accept(object);
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.actual.onError(throwable);
            return;
          } 
        } else {
          return;
        } 
      } 
      this.actual.onComplete();
      if (!this.eager)
        disposeResourceAfter(); 
    }
    
    public void onError(Throwable param1Throwable) {
      Object object;
      this.d = (Disposable)DisposableHelper.DISPOSED;
      Throwable throwable = param1Throwable;
      if (this.eager) {
        object = getAndSet(this);
        if (object != this) {
          try {
            this.disposer.accept(object);
            object = param1Throwable;
          } catch (Throwable throwable1) {
            Exceptions.throwIfFatal(throwable1);
            object = new CompositeException(new Throwable[] { param1Throwable, throwable1 });
          } 
        } else {
          return;
        } 
      } 
      this.actual.onError((Throwable)object);
      if (!this.eager)
        disposeResourceAfter(); 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */