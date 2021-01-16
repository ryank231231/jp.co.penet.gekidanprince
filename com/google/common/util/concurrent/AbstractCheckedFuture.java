package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
public abstract class AbstractCheckedFuture<V, X extends Exception> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements CheckedFuture<V, X> {
  protected AbstractCheckedFuture(ListenableFuture<V> paramListenableFuture) {
    super(paramListenableFuture);
  }
  
  @CanIgnoreReturnValue
  public V checkedGet() throws X {
    try {
      return get();
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw mapException(interruptedException);
    } catch (CancellationException cancellationException) {
      throw mapException(cancellationException);
    } catch (ExecutionException executionException) {
      throw mapException(executionException);
    } 
  }
  
  @CanIgnoreReturnValue
  public V checkedGet(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException, X {
    try {
      return get(paramLong, paramTimeUnit);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw mapException(interruptedException);
    } catch (CancellationException cancellationException) {
      throw mapException(cancellationException);
    } catch (ExecutionException executionException) {
      throw mapException(executionException);
    } 
  }
  
  protected abstract X mapException(Exception paramException);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractCheckedFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */