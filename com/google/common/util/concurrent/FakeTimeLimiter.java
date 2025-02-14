package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
@GwtIncompatible
@CanIgnoreReturnValue
public final class FakeTimeLimiter implements TimeLimiter {
  public <T> T callWithTimeout(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean) throws Exception {
    Preconditions.checkNotNull(paramTimeUnit);
    return paramCallable.call();
  }
  
  public <T> T newProxy(T paramT, Class<T> paramClass, long paramLong, TimeUnit paramTimeUnit) {
    Preconditions.checkNotNull(paramT);
    Preconditions.checkNotNull(paramClass);
    Preconditions.checkNotNull(paramTimeUnit);
    return paramT;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\FakeTimeLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */