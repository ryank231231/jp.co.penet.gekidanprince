package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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

public final class MaybeUsing<T, D> extends Maybe<T> {
  final boolean eager;
  
  final Consumer<? super D> resourceDisposer;
  
  final Callable<? extends D> resourceSupplier;
  
  final Function<? super D, ? extends MaybeSource<? extends T>> sourceSupplier;
  
  public MaybeUsing(Callable<? extends D> paramCallable, Function<? super D, ? extends MaybeSource<? extends T>> paramFunction, Consumer<? super D> paramConsumer, boolean paramBoolean) {
    this.resourceSupplier = paramCallable;
    this.sourceSupplier = paramFunction;
    this.resourceDisposer = paramConsumer;
    this.eager = paramBoolean;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    try {
      D d = this.resourceSupplier.call();
      try {
        MaybeSource maybeSource = (MaybeSource)ObjectHelper.requireNonNull(this.sourceSupplier.apply(d), "The sourceSupplier returned a null MaybeSource");
        maybeSource.subscribe(new UsingObserver<T, D>(paramMaybeObserver, d, this.resourceDisposer, this.eager));
        return;
      } catch (Throwable throwable2) {
        Exceptions.throwIfFatal(throwable2);
        if (this.eager)
          try {
            this.resourceDisposer.accept(d);
          } catch (Throwable throwable1) {
            Exceptions.throwIfFatal(throwable1);
            EmptyDisposable.error((Throwable)new CompositeException(new Throwable[] { throwable2, throwable1 }, ), paramMaybeObserver);
            return;
          }  
        EmptyDisposable.error(throwable2, paramMaybeObserver);
        if (!this.eager)
          try {
            this.resourceDisposer.accept(throwable1);
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            RxJavaPlugins.onError(throwable);
          }  
        return;
      } 
    } catch (Throwable throwable1) {
      Exceptions.throwIfFatal(throwable1);
      EmptyDisposable.error(throwable1, (MaybeObserver)throwable);
      return;
    } 
  }
  
  static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = -674404550052917487L;
    
    final MaybeObserver<? super T> actual;
    
    Disposable d;
    
    final Consumer<? super D> disposer;
    
    final boolean eager;
    
    UsingObserver(MaybeObserver<? super T> param1MaybeObserver, D param1D, Consumer<? super D> param1Consumer, boolean param1Boolean) {
      super(param1D);
      this.actual = param1MaybeObserver;
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
    
    public void onSuccess(T param1T) {
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
      this.actual.onSuccess(throwable);
      if (!this.eager)
        disposeResourceAfter(); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */