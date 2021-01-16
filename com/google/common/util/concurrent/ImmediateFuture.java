package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class ImmediateFuture<V> implements ListenableFuture<V> {
  private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    Preconditions.checkNotNull(paramRunnable, "Runnable was null.");
    Preconditions.checkNotNull(paramExecutor, "Executor was null.");
    try {
      paramExecutor.execute(paramRunnable);
    } catch (RuntimeException runtimeException) {
      Logger logger = log;
      Level level = Level.SEVERE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RuntimeException while executing runnable ");
      stringBuilder.append(paramRunnable);
      stringBuilder.append(" with executor ");
      stringBuilder.append(paramExecutor);
      logger.log(level, stringBuilder.toString(), runtimeException);
    } 
  }
  
  public boolean cancel(boolean paramBoolean) {
    return false;
  }
  
  public abstract V get() throws ExecutionException;
  
  public V get(long paramLong, TimeUnit paramTimeUnit) throws ExecutionException {
    Preconditions.checkNotNull(paramTimeUnit);
    return get();
  }
  
  public boolean isCancelled() {
    return false;
  }
  
  public boolean isDone() {
    return true;
  }
  
  static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
    ImmediateCancelledFuture() {
      cancel(false);
    }
  }
  
  @GwtIncompatible
  static class ImmediateFailedCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
    private final X thrown;
    
    ImmediateFailedCheckedFuture(X param1X) {
      this.thrown = param1X;
    }
    
    public V checkedGet() throws X {
      throw this.thrown;
    }
    
    public V checkedGet(long param1Long, TimeUnit param1TimeUnit) throws X {
      Preconditions.checkNotNull(param1TimeUnit);
      throw this.thrown;
    }
    
    public V get() throws ExecutionException {
      throw new ExecutionException(this.thrown);
    }
  }
  
  static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
    ImmediateFailedFuture(Throwable param1Throwable) {
      setException(param1Throwable);
    }
  }
  
  @GwtIncompatible
  static class ImmediateSuccessfulCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
    @Nullable
    private final V value;
    
    ImmediateSuccessfulCheckedFuture(@Nullable V param1V) {
      this.value = param1V;
    }
    
    public V checkedGet() {
      return this.value;
    }
    
    public V checkedGet(long param1Long, TimeUnit param1TimeUnit) {
      Preconditions.checkNotNull(param1TimeUnit);
      return this.value;
    }
    
    public V get() {
      return this.value;
    }
  }
  
  static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
    static final ImmediateSuccessfulFuture<Object> NULL = new ImmediateSuccessfulFuture(null);
    
    @Nullable
    private final V value;
    
    ImmediateSuccessfulFuture(@Nullable V param1V) {
      this.value = param1V;
    }
    
    public V get() {
      return this.value;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ImmediateFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */