package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
@GwtIncompatible
public interface TimeLimiter {
  @CanIgnoreReturnValue
  <T> T callWithTimeout(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean) throws Exception;
  
  <T> T newProxy(T paramT, Class<T> paramClass, long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\TimeLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */