package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtCompatible
@CanIgnoreReturnValue
public interface CheckedFuture<V, X extends Exception> extends ListenableFuture<V> {
  V checkedGet() throws X;
  
  V checkedGet(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException, X;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\CheckedFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */