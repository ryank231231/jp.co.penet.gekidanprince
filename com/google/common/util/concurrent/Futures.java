package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated = true)
public final class Futures extends GwtFuturesCatchingSpecialization {
  private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER = new AsyncFunction<ListenableFuture<Object>, Object>() {
      public ListenableFuture<Object> apply(ListenableFuture<Object> param1ListenableFuture) {
        return param1ListenableFuture;
      }
    };
  
  public static <V> void addCallback(ListenableFuture<V> paramListenableFuture, FutureCallback<? super V> paramFutureCallback) {
    addCallback(paramListenableFuture, paramFutureCallback, MoreExecutors.directExecutor());
  }
  
  public static <V> void addCallback(final ListenableFuture<V> future, final FutureCallback<? super V> callback, Executor paramExecutor) {
    Preconditions.checkNotNull(callback);
    future.addListener(new Runnable() {
          public void run() {
            try {
              Object object = Futures.getDone(future);
              callback.onSuccess(object);
              return;
            } catch (ExecutionException executionException) {
              callback.onFailure(executionException.getCause());
              return;
            } catch (RuntimeException runtimeException) {
              callback.onFailure(runtimeException);
              return;
            } catch (Error error) {
              callback.onFailure(error);
              return;
            } 
          }
        },  paramExecutor);
  }
  
  @Beta
  public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> paramIterable) {
    return new CollectionFuture.ListFuture<V>((ImmutableCollection<? extends ListenableFuture<? extends V>>)ImmutableList.copyOf(paramIterable), true);
  }
  
  @SafeVarargs
  @Beta
  public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... paramVarArgs) {
    return new CollectionFuture.ListFuture<V>((ImmutableCollection<? extends ListenableFuture<? extends V>>)ImmutableList.copyOf((Object[])paramVarArgs), true);
  }
  
  @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction) {
    return AbstractCatchingFuture.create(paramListenableFuture, paramClass, paramFunction);
  }
  
  @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction, Executor paramExecutor) {
    return AbstractCatchingFuture.create(paramListenableFuture, paramClass, paramFunction, paramExecutor);
  }
  
  @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  @CanIgnoreReturnValue
  public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction) {
    return AbstractCatchingFuture.create(paramListenableFuture, paramClass, paramAsyncFunction);
  }
  
  @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  @CanIgnoreReturnValue
  public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction, Executor paramExecutor) {
    return AbstractCatchingFuture.create(paramListenableFuture, paramClass, paramAsyncFunction, paramExecutor);
  }
  
  public static <V> ListenableFuture<V> dereference(ListenableFuture<? extends ListenableFuture<? extends V>> paramListenableFuture) {
    return transformAsync(paramListenableFuture, (AsyncFunction)DEREFERENCER);
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass) throws X {
    return FuturesGetChecked.getChecked(paramFuture, paramClass);
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass, long paramLong, TimeUnit paramTimeUnit) throws X {
    return FuturesGetChecked.getChecked(paramFuture, paramClass, paramLong, paramTimeUnit);
  }
  
  @CanIgnoreReturnValue
  public static <V> V getDone(Future<V> paramFuture) throws ExecutionException {
    Preconditions.checkState(paramFuture.isDone(), "Future was expected to be done: %s", paramFuture);
    return Uninterruptibles.getUninterruptibly(paramFuture);
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <V> V getUnchecked(Future<V> paramFuture) {
    Preconditions.checkNotNull(paramFuture);
    try {
      return (V)Uninterruptibles.getUninterruptibly((Future)paramFuture);
    } catch (ExecutionException executionException) {
      wrapAndThrowUnchecked(executionException.getCause());
      throw new AssertionError();
    } 
  }
  
  public static <V> ListenableFuture<V> immediateCancelledFuture() {
    return new ImmediateFuture.ImmediateCancelledFuture<V>();
  }
  
  @GwtIncompatible
  public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable V paramV) {
    return new ImmediateFuture.ImmediateSuccessfulCheckedFuture<V, X>(paramV);
  }
  
  @GwtIncompatible
  public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X paramX) {
    Preconditions.checkNotNull(paramX);
    return new ImmediateFuture.ImmediateFailedCheckedFuture<V, X>(paramX);
  }
  
  public static <V> ListenableFuture<V> immediateFailedFuture(Throwable paramThrowable) {
    Preconditions.checkNotNull(paramThrowable);
    return new ImmediateFuture.ImmediateFailedFuture<V>(paramThrowable);
  }
  
  public static <V> ListenableFuture<V> immediateFuture(@Nullable V paramV) {
    return (ListenableFuture<V>)((paramV == null) ? ImmediateFuture.ImmediateSuccessfulFuture.NULL : new ImmediateFuture.ImmediateSuccessfulFuture<V>(paramV));
  }
  
  @Beta
  @GwtIncompatible
  public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> paramIterable) {
    final ConcurrentLinkedQueue<SettableFuture<?>> delegates = Queues.newConcurrentLinkedQueue();
    ImmutableList.Builder builder = ImmutableList.builder();
    SerializingExecutor serializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
    for (ListenableFuture<? extends T> listenableFuture : paramIterable) {
      SettableFuture<?> settableFuture = SettableFuture.create();
      concurrentLinkedQueue.add(settableFuture);
      listenableFuture.addListener(new Runnable() {
            public void run() {
              ((SettableFuture)delegates.remove()).setFuture(future);
            }
          },  serializingExecutor);
      builder.add(settableFuture);
    } 
    return builder.build();
  }
  
  @GwtIncompatible
  public static <I, O> Future<O> lazyTransform(final Future<I> input, final Function<? super I, ? extends O> function) {
    Preconditions.checkNotNull(input);
    Preconditions.checkNotNull(function);
    return new Future<O>() {
        private O applyTransformation(I param1I) throws ExecutionException {
          try {
            return (O)function.apply(param1I);
          } catch (Throwable throwable) {
            throw new ExecutionException(throwable);
          } 
        }
        
        public boolean cancel(boolean param1Boolean) {
          return input.cancel(param1Boolean);
        }
        
        public O get() throws InterruptedException, ExecutionException {
          return applyTransformation(input.get());
        }
        
        public O get(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
          return applyTransformation(input.get(param1Long, param1TimeUnit));
        }
        
        public boolean isCancelled() {
          return input.isCancelled();
        }
        
        public boolean isDone() {
          return input.isDone();
        }
      };
  }
  
  @GwtIncompatible
  public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> paramListenableFuture, Function<? super Exception, X> paramFunction) {
    return new MappingCheckedFuture<V, X>((ListenableFuture<V>)Preconditions.checkNotNull(paramListenableFuture), paramFunction);
  }
  
  public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> paramListenableFuture) {
    return new NonCancellationPropagatingFuture<V>(paramListenableFuture);
  }
  
  @Beta
  public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> paramIterable) {
    return new CollectionFuture.ListFuture<V>((ImmutableCollection<? extends ListenableFuture<? extends V>>)ImmutableList.copyOf(paramIterable), false);
  }
  
  @SafeVarargs
  @Beta
  public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... paramVarArgs) {
    return new CollectionFuture.ListFuture<V>((ImmutableCollection<? extends ListenableFuture<? extends V>>)ImmutableList.copyOf((Object[])paramVarArgs), false);
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction) {
    return AbstractTransformFuture.create(paramListenableFuture, paramFunction);
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor) {
    return AbstractTransformFuture.create(paramListenableFuture, paramFunction, paramExecutor);
  }
  
  public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction) {
    return AbstractTransformFuture.create(paramListenableFuture, paramAsyncFunction);
  }
  
  public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction, Executor paramExecutor) {
    return AbstractTransformFuture.create(paramListenableFuture, paramAsyncFunction, paramExecutor);
  }
  
  public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> paramIterable) {
    return new FutureCombiner<V>(false, ImmutableList.copyOf(paramIterable));
  }
  
  @SafeVarargs
  public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... paramVarArgs) {
    return new FutureCombiner<V>(false, ImmutableList.copyOf((Object[])paramVarArgs));
  }
  
  public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> paramIterable) {
    return new FutureCombiner<V>(true, ImmutableList.copyOf(paramIterable));
  }
  
  @SafeVarargs
  public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... paramVarArgs) {
    return new FutureCombiner<V>(true, ImmutableList.copyOf((Object[])paramVarArgs));
  }
  
  @GwtIncompatible
  public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> paramListenableFuture, long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService) {
    return TimeoutFuture.create(paramListenableFuture, paramLong, paramTimeUnit, paramScheduledExecutorService);
  }
  
  @GwtIncompatible
  private static void wrapAndThrowUnchecked(Throwable paramThrowable) {
    if (paramThrowable instanceof Error)
      throw new ExecutionError((Error)paramThrowable); 
    throw new UncheckedExecutionException(paramThrowable);
  }
  
  @Beta
  @GwtCompatible
  @CanIgnoreReturnValue
  public static final class FutureCombiner<V> {
    private final boolean allMustSucceed;
    
    private final ImmutableList<ListenableFuture<? extends V>> futures;
    
    private FutureCombiner(boolean param1Boolean, ImmutableList<ListenableFuture<? extends V>> param1ImmutableList) {
      this.allMustSucceed = param1Boolean;
      this.futures = param1ImmutableList;
    }
    
    @CanIgnoreReturnValue
    public <C> ListenableFuture<C> call(Callable<C> param1Callable) {
      return call(param1Callable, MoreExecutors.directExecutor());
    }
    
    @CanIgnoreReturnValue
    public <C> ListenableFuture<C> call(Callable<C> param1Callable, Executor param1Executor) {
      return new CombinedFuture<C>((ImmutableCollection<? extends ListenableFuture<?>>)this.futures, this.allMustSucceed, param1Executor, param1Callable);
    }
    
    public <C> ListenableFuture<C> callAsync(AsyncCallable<C> param1AsyncCallable) {
      return callAsync(param1AsyncCallable, MoreExecutors.directExecutor());
    }
    
    public <C> ListenableFuture<C> callAsync(AsyncCallable<C> param1AsyncCallable, Executor param1Executor) {
      return new CombinedFuture<C>((ImmutableCollection<? extends ListenableFuture<?>>)this.futures, this.allMustSucceed, param1Executor, param1AsyncCallable);
    }
  }
  
  @GwtIncompatible
  private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X> {
    final Function<? super Exception, X> mapper;
    
    MappingCheckedFuture(ListenableFuture<V> param1ListenableFuture, Function<? super Exception, X> param1Function) {
      super(param1ListenableFuture);
      this.mapper = (Function<? super Exception, X>)Preconditions.checkNotNull(param1Function);
    }
    
    protected X mapException(Exception param1Exception) {
      return (X)this.mapper.apply(param1Exception);
    }
  }
  
  private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> {
    NonCancellationPropagatingFuture(final ListenableFuture<V> delegate) {
      delegate.addListener(new Runnable() {
            public void run() {
              Futures.NonCancellationPropagatingFuture.this.setFuture(delegate);
            }
          },  MoreExecutors.directExecutor());
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.setFuture(delegate);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Futures.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */