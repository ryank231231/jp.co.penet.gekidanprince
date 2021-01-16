package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends AbstractFuture.TrustedFuture<V> implements Runnable {
  @Nullable
  Class<X> exceptionType;
  
  @Nullable
  F fallback;
  
  @Nullable
  ListenableFuture<? extends V> inputFuture;
  
  AbstractCatchingFuture(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, F paramF) {
    this.inputFuture = (ListenableFuture<? extends V>)Preconditions.checkNotNull(paramListenableFuture);
    this.exceptionType = (Class<X>)Preconditions.checkNotNull(paramClass);
    this.fallback = (F)Preconditions.checkNotNull(paramF);
  }
  
  static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction) {
    CatchingFuture<V, X> catchingFuture = new CatchingFuture<V, X>(paramListenableFuture, paramClass, paramFunction);
    paramListenableFuture.addListener(catchingFuture, MoreExecutors.directExecutor());
    return catchingFuture;
  }
  
  static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction, Executor paramExecutor) {
    CatchingFuture<V, X> catchingFuture = new CatchingFuture<V, X>(paramListenableFuture, paramClass, paramFunction);
    paramListenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(paramExecutor, catchingFuture));
    return catchingFuture;
  }
  
  static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction) {
    AsyncCatchingFuture<V, X> asyncCatchingFuture = new AsyncCatchingFuture<V, X>(paramListenableFuture, paramClass, paramAsyncFunction);
    paramListenableFuture.addListener(asyncCatchingFuture, MoreExecutors.directExecutor());
    return asyncCatchingFuture;
  }
  
  static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction, Executor paramExecutor) {
    AsyncCatchingFuture<V, X> asyncCatchingFuture = new AsyncCatchingFuture<V, X>(paramListenableFuture, paramClass, paramAsyncFunction);
    paramListenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(paramExecutor, asyncCatchingFuture));
    return asyncCatchingFuture;
  }
  
  protected final void afterDone() {
    maybePropagateCancellation(this.inputFuture);
    this.inputFuture = null;
    this.exceptionType = null;
    this.fallback = null;
  }
  
  @Nullable
  @ForOverride
  abstract T doFallback(F paramF, X paramX) throws Exception;
  
  public final void run() {
    boolean bool2;
    boolean bool3;
    ListenableFuture<? extends V> listenableFuture1 = this.inputFuture;
    Class<X> clazz = this.exceptionType;
    F f = this.fallback;
    boolean bool1 = true;
    if (listenableFuture1 == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (clazz == null) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (f != null)
      bool1 = false; 
    if ((bool1 | bool2 | bool3 | isCancelled()) != 0)
      return; 
    ListenableFuture<? extends V> listenableFuture2 = null;
    this.inputFuture = null;
    this.exceptionType = null;
    this.fallback = null;
    try {
      listenableFuture1 = Futures.getDone((Future)listenableFuture1);
      listenableFuture2 = listenableFuture1;
      listenableFuture1 = null;
    } catch (ExecutionException executionException) {
      throwable = (Throwable)Preconditions.checkNotNull(executionException.getCause());
    } catch (Throwable throwable) {}
    if (throwable == null) {
      set((V)listenableFuture2);
      return;
    } 
    if (!Platform.isInstanceOfThrowableClass(throwable, clazz)) {
      setException(throwable);
      return;
    } 
    try {
      throwable = (Throwable)doFallback(f, (X)throwable);
      setResult((T)throwable);
      return;
    } catch (Throwable throwable1) {
      setException(throwable1);
      return;
    } 
  }
  
  @ForOverride
  abstract void setResult(@Nullable T paramT);
  
  private static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
    AsyncCatchingFuture(ListenableFuture<? extends V> param1ListenableFuture, Class<X> param1Class, AsyncFunction<? super X, ? extends V> param1AsyncFunction) {
      super(param1ListenableFuture, param1Class, param1AsyncFunction);
    }
    
    ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> param1AsyncFunction, X param1X) throws Exception {
      ListenableFuture<? extends V> listenableFuture = param1AsyncFunction.apply(param1X);
      Preconditions.checkNotNull(listenableFuture, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      return listenableFuture;
    }
    
    void setResult(ListenableFuture<? extends V> param1ListenableFuture) {
      setFuture(param1ListenableFuture);
    }
  }
  
  private static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
    CatchingFuture(ListenableFuture<? extends V> param1ListenableFuture, Class<X> param1Class, Function<? super X, ? extends V> param1Function) {
      super(param1ListenableFuture, param1Class, param1Function);
    }
    
    @Nullable
    V doFallback(Function<? super X, ? extends V> param1Function, X param1X) throws Exception {
      return (V)param1Function.apply(param1X);
    }
    
    void setResult(@Nullable V param1V) {
      set(param1V);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractCatchingFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */