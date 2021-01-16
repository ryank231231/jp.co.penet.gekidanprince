package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class SingleUsing<T, U> extends Single<T> {
  final Consumer<? super U> disposer;
  
  final boolean eager;
  
  final Callable<U> resourceSupplier;
  
  final Function<? super U, ? extends SingleSource<? extends T>> singleFunction;
  
  public SingleUsing(Callable<U> paramCallable, Function<? super U, ? extends SingleSource<? extends T>> paramFunction, Consumer<? super U> paramConsumer, boolean paramBoolean) {
    this.resourceSupplier = paramCallable;
    this.singleFunction = paramFunction;
    this.disposer = paramConsumer;
    this.eager = paramBoolean;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    try {
      U u = this.resourceSupplier.call();
      try {
        SingleSource singleSource = (SingleSource)ObjectHelper.requireNonNull(this.singleFunction.apply(u), "The singleFunction returned a null SingleSource");
        singleSource.subscribe(new UsingSingleObserver<T, U>(paramSingleObserver, u, this.eager, this.disposer));
        return;
      } catch (Throwable throwable1) {
        CompositeException compositeException;
        Exceptions.throwIfFatal(throwable1);
        Throwable throwable2 = throwable1;
        if (this.eager)
          try {
            this.disposer.accept(u);
            throwable2 = throwable1;
          } catch (Throwable throwable3) {
            Exceptions.throwIfFatal(throwable3);
            compositeException = new CompositeException(new Throwable[] { throwable1, throwable3 });
          }  
        EmptyDisposable.error((Throwable)compositeException, paramSingleObserver);
        if (!this.eager)
          try {
            this.disposer.accept(u);
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            RxJavaPlugins.onError(throwable);
          }  
        return;
      } 
    } catch (Throwable throwable1) {
      Exceptions.throwIfFatal(throwable1);
      EmptyDisposable.error(throwable1, (SingleObserver)throwable);
      return;
    } 
  }
  
  static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = -5331524057054083935L;
    
    final SingleObserver<? super T> actual;
    
    Disposable d;
    
    final Consumer<? super U> disposer;
    
    final boolean eager;
    
    UsingSingleObserver(SingleObserver<? super T> param1SingleObserver, U param1U, boolean param1Boolean, Consumer<? super U> param1Consumer) {
      super(param1U);
      this.actual = param1SingleObserver;
      this.eager = param1Boolean;
      this.disposer = param1Consumer;
    }
    
    public void dispose() {
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
      disposeAfter();
    }
    
    void disposeAfter() {
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
        disposeAfter(); 
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
        disposeAfter(); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */