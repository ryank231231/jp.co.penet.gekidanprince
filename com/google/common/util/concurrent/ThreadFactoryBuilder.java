package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckReturnValue;

@GwtIncompatible
@CanIgnoreReturnValue
public final class ThreadFactoryBuilder {
  private ThreadFactory backingThreadFactory = null;
  
  private Boolean daemon = null;
  
  private String nameFormat = null;
  
  private Integer priority = null;
  
  private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
  
  private static ThreadFactory build(ThreadFactoryBuilder paramThreadFactoryBuilder) {
    final AtomicLong count;
    final String nameFormat = paramThreadFactoryBuilder.nameFormat;
    final Boolean daemon = paramThreadFactoryBuilder.daemon;
    final Integer priority = paramThreadFactoryBuilder.priority;
    final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = paramThreadFactoryBuilder.uncaughtExceptionHandler;
    final ThreadFactory backingThreadFactory = paramThreadFactoryBuilder.backingThreadFactory;
    if (threadFactory == null)
      threadFactory = Executors.defaultThreadFactory(); 
    if (str != null) {
      atomicLong = new AtomicLong(0L);
    } else {
      atomicLong = null;
    } 
    return new ThreadFactory() {
        public Thread newThread(Runnable param1Runnable) {
          param1Runnable = backingThreadFactory.newThread(param1Runnable);
          String str = nameFormat;
          if (str != null)
            param1Runnable.setName(ThreadFactoryBuilder.format(str, new Object[] { Long.valueOf(this.val$count.getAndIncrement()) })); 
          Boolean bool = daemon;
          if (bool != null)
            param1Runnable.setDaemon(bool.booleanValue()); 
          Integer integer = priority;
          if (integer != null)
            param1Runnable.setPriority(integer.intValue()); 
          Thread.UncaughtExceptionHandler uncaughtExceptionHandler = uncaughtExceptionHandler;
          if (uncaughtExceptionHandler != null)
            param1Runnable.setUncaughtExceptionHandler(uncaughtExceptionHandler); 
          return (Thread)param1Runnable;
        }
      };
  }
  
  private static String format(String paramString, Object... paramVarArgs) {
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  @CheckReturnValue
  public ThreadFactory build() {
    return build(this);
  }
  
  public ThreadFactoryBuilder setDaemon(boolean paramBoolean) {
    this.daemon = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public ThreadFactoryBuilder setNameFormat(String paramString) {
    format(paramString, new Object[] { Integer.valueOf(0) });
    this.nameFormat = paramString;
    return this;
  }
  
  public ThreadFactoryBuilder setPriority(int paramInt) {
    boolean bool1 = false;
    if (paramInt >= 1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Thread priority (%s) must be >= %s", paramInt, 1);
    boolean bool2 = bool1;
    if (paramInt <= 10)
      bool2 = true; 
    Preconditions.checkArgument(bool2, "Thread priority (%s) must be <= %s", paramInt, 10);
    this.priority = Integer.valueOf(paramInt);
    return this;
  }
  
  public ThreadFactoryBuilder setThreadFactory(ThreadFactory paramThreadFactory) {
    this.backingThreadFactory = (ThreadFactory)Preconditions.checkNotNull(paramThreadFactory);
    return this;
  }
  
  public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
    this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler)Preconditions.checkNotNull(paramUncaughtExceptionHandler);
    return this;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ThreadFactoryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */