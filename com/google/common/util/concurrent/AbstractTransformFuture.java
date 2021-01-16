package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.ForOverride;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractTransformFuture<I, O, F, T> extends AbstractFuture.TrustedFuture<O> implements Runnable {
  @Nullable
  F function;
  
  @Nullable
  ListenableFuture<? extends I> inputFuture;
  
  AbstractTransformFuture(ListenableFuture<? extends I> paramListenableFuture, F paramF) {
    this.inputFuture = (ListenableFuture<? extends I>)Preconditions.checkNotNull(paramListenableFuture);
    this.function = (F)Preconditions.checkNotNull(paramF);
  }
  
  static <I, O> ListenableFuture<O> create(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction) {
    Preconditions.checkNotNull(paramFunction);
    TransformFuture<I, O> transformFuture = new TransformFuture<I, O>(paramListenableFuture, paramFunction);
    paramListenableFuture.addListener(transformFuture, MoreExecutors.directExecutor());
    return transformFuture;
  }
  
  static <I, O> ListenableFuture<O> create(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor) {
    Preconditions.checkNotNull(paramFunction);
    TransformFuture<I, O> transformFuture = new TransformFuture<I, O>(paramListenableFuture, paramFunction);
    paramListenableFuture.addListener(transformFuture, MoreExecutors.rejectionPropagatingExecutor(paramExecutor, transformFuture));
    return transformFuture;
  }
  
  static <I, O> ListenableFuture<O> create(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction) {
    AsyncTransformFuture<I, O> asyncTransformFuture = new AsyncTransformFuture<I, O>(paramListenableFuture, paramAsyncFunction);
    paramListenableFuture.addListener(asyncTransformFuture, MoreExecutors.directExecutor());
    return asyncTransformFuture;
  }
  
  static <I, O> ListenableFuture<O> create(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction, Executor paramExecutor) {
    Preconditions.checkNotNull(paramExecutor);
    AsyncTransformFuture<I, O> asyncTransformFuture = new AsyncTransformFuture<I, O>(paramListenableFuture, paramAsyncFunction);
    paramListenableFuture.addListener(asyncTransformFuture, MoreExecutors.rejectionPropagatingExecutor(paramExecutor, asyncTransformFuture));
    return asyncTransformFuture;
  }
  
  protected final void afterDone() {
    maybePropagateCancellation(this.inputFuture);
    this.inputFuture = null;
    this.function = null;
  }
  
  @Nullable
  @ForOverride
  abstract T doTransform(F paramF, @Nullable I paramI) throws Exception;
  
  public final void run() {
    boolean bool3;
    ListenableFuture<? extends I> listenableFuture = this.inputFuture;
    F f = this.function;
    boolean bool1 = isCancelled();
    boolean bool2 = true;
    if (listenableFuture == null) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (f != null)
      bool2 = false; 
    if (bool1 | bool3 | bool2)
      return; 
    this.inputFuture = null;
    this.function = null;
    try {
      listenableFuture = Futures.getDone((Future)listenableFuture);
      try {
        f = (F)doTransform(f, (I)listenableFuture);
        setResult((T)f);
        return;
      } catch (UndeclaredThrowableException undeclaredThrowableException) {
        setException(undeclaredThrowableException.getCause());
        return;
      } catch (Throwable throwable) {
        setException(throwable);
        return;
      } 
    } catch (CancellationException cancellationException) {
      cancel(false);
      return;
    } catch (ExecutionException executionException) {
      setException(executionException.getCause());
      return;
    } catch (RuntimeException runtimeException) {
      setException(runtimeException);
      return;
    } catch (Error error) {
      setException(error);
      return;
    } 
  }
  
  @ForOverride
  abstract void setResult(@Nullable T paramT);
  
  private static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
    AsyncTransformFuture(ListenableFuture<? extends I> param1ListenableFuture, AsyncFunction<? super I, ? extends O> param1AsyncFunction) {
      super(param1ListenableFuture, param1AsyncFunction);
    }
    
    ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> param1AsyncFunction, @Nullable I param1I) throws Exception {
      ListenableFuture<? extends O> listenableFuture = param1AsyncFunction.apply(param1I);
      Preconditions.checkNotNull(listenableFuture, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      return listenableFuture;
    }
    
    void setResult(ListenableFuture<? extends O> param1ListenableFuture) {
      setFuture(param1ListenableFuture);
    }
  }
  
  private static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
    TransformFuture(ListenableFuture<? extends I> param1ListenableFuture, Function<? super I, ? extends O> param1Function) {
      super(param1ListenableFuture, param1Function);
    }
    
    @Nullable
    O doTransform(Function<? super I, ? extends O> param1Function, @Nullable I param1I) {
      return (O)param1Function.apply(param1I);
    }
    
    void setResult(@Nullable O param1O) {
      set(param1O);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractTransformFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */