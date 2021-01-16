package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
public final class SimpleTimeLimiter implements TimeLimiter {
  private final ExecutorService executor;
  
  public SimpleTimeLimiter() {
    this(Executors.newCachedThreadPool());
  }
  
  public SimpleTimeLimiter(ExecutorService paramExecutorService) {
    this.executor = (ExecutorService)Preconditions.checkNotNull(paramExecutorService);
  }
  
  private static boolean declaresInterruptedEx(Method paramMethod) {
    Class[] arrayOfClass = paramMethod.getExceptionTypes();
    int i = arrayOfClass.length;
    for (byte b = 0; b < i; b++) {
      if (arrayOfClass[b] == InterruptedException.class)
        return true; 
    } 
    return false;
  }
  
  private static Set<Method> findInterruptibleMethods(Class<?> paramClass) {
    HashSet<Method> hashSet = Sets.newHashSet();
    for (Method method : paramClass.getMethods()) {
      if (declaresInterruptedEx(method))
        hashSet.add(method); 
    } 
    return hashSet;
  }
  
  private static <T> T newProxy(Class<T> paramClass, InvocationHandler paramInvocationHandler) {
    return paramClass.cast(Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramInvocationHandler));
  }
  
  private static Exception throwCause(Exception paramException, boolean paramBoolean) throws Exception {
    Throwable throwable = paramException.getCause();
    if (throwable != null) {
      if (paramBoolean)
        throwable.setStackTrace((StackTraceElement[])ObjectArrays.concat((Object[])throwable.getStackTrace(), (Object[])paramException.getStackTrace(), StackTraceElement.class)); 
      if (!(throwable instanceof Exception)) {
        if (throwable instanceof Error)
          throw (Error)throwable; 
        throw paramException;
      } 
      throw (Exception)throwable;
    } 
    throw paramException;
  }
  
  @CanIgnoreReturnValue
  public <T> T callWithTimeout(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean) throws Exception {
    boolean bool;
    Preconditions.checkNotNull(paramCallable);
    Preconditions.checkNotNull(paramTimeUnit);
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "timeout must be positive: %s", paramLong);
    Future<T> future = this.executor.submit(paramCallable);
    if (paramBoolean)
      try {
        return future.get(paramLong, paramTimeUnit);
      } catch (InterruptedException interruptedException) {
        future.cancel(true);
        throw interruptedException;
      } catch (ExecutionException executionException) {
        throw throwCause(executionException, true);
      } catch (TimeoutException null) {
        executionException.cancel(true);
        throw new UncheckedTimeoutException(null);
      }  
    return (T)Uninterruptibles.getUninterruptibly((Future<TimeoutException>)executionException, paramLong, (TimeUnit)null);
  }
  
  public <T> T newProxy(final T target, Class<T> paramClass, final long timeoutDuration, final TimeUnit timeoutUnit) {
    boolean bool;
    Preconditions.checkNotNull(target);
    Preconditions.checkNotNull(paramClass);
    Preconditions.checkNotNull(timeoutUnit);
    if (timeoutDuration > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "bad timeout: %s", timeoutDuration);
    Preconditions.checkArgument(paramClass.isInterface(), "interfaceType must be an interface type");
    return newProxy(paramClass, new InvocationHandler() {
          public Object invoke(Object<Object> param1Object, final Method method, final Object[] args) throws Throwable {
            param1Object = (Object<Object>)new Callable() {
                public Object call() throws Exception {
                  try {
                    return method.invoke(target, args);
                  } catch (InvocationTargetException invocationTargetException) {
                    throw SimpleTimeLimiter.throwCause(invocationTargetException, false);
                  } 
                }
              };
            return SimpleTimeLimiter.this.callWithTimeout((Callable)param1Object, timeoutDuration, timeoutUnit, interruptibleMethods.contains(method));
          }
        });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\SimpleTimeLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */