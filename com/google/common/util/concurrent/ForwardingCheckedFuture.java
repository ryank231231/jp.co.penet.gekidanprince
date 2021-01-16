package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
public abstract class ForwardingCheckedFuture<V, X extends Exception> extends ForwardingListenableFuture<V> implements CheckedFuture<V, X> {
  @CanIgnoreReturnValue
  public V checkedGet() throws X {
    return delegate().checkedGet();
  }
  
  @CanIgnoreReturnValue
  public V checkedGet(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException, X {
    return delegate().checkedGet(paramLong, paramTimeUnit);
  }
  
  protected abstract CheckedFuture<V, X> delegate();
  
  @Beta
  public static abstract class SimpleForwardingCheckedFuture<V, X extends Exception> extends ForwardingCheckedFuture<V, X> {
    private final CheckedFuture<V, X> delegate;
    
    protected SimpleForwardingCheckedFuture(CheckedFuture<V, X> param1CheckedFuture) {
      this.delegate = (CheckedFuture<V, X>)Preconditions.checkNotNull(param1CheckedFuture);
    }
    
    protected final CheckedFuture<V, X> delegate() {
      return this.delegate;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingCheckedFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */