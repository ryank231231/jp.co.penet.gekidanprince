package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class Closer implements Closeable {
  private static final Suppressor SUPPRESSOR;
  
  private final Deque<Closeable> stack = new ArrayDeque<Closeable>(4);
  
  @VisibleForTesting
  final Suppressor suppressor;
  
  private Throwable thrown;
  
  static {
    LoggingSuppressor loggingSuppressor;
    if (SuppressingSuppressor.isAvailable()) {
      SuppressingSuppressor suppressingSuppressor = SuppressingSuppressor.INSTANCE;
    } else {
      loggingSuppressor = LoggingSuppressor.INSTANCE;
    } 
    SUPPRESSOR = loggingSuppressor;
  }
  
  @VisibleForTesting
  Closer(Suppressor paramSuppressor) {
    this.suppressor = (Suppressor)Preconditions.checkNotNull(paramSuppressor);
  }
  
  public static Closer create() {
    return new Closer(SUPPRESSOR);
  }
  
  public void close() throws IOException {
    Throwable throwable = this.thrown;
    while (!this.stack.isEmpty()) {
      Closeable closeable = this.stack.removeFirst();
      try {
        closeable.close();
      } catch (Throwable throwable1) {
        if (throwable == null) {
          throwable = throwable1;
          continue;
        } 
        this.suppressor.suppress(closeable, throwable, throwable1);
      } 
    } 
    if (this.thrown != null || throwable == null)
      return; 
    Throwables.propagateIfPossible(throwable, IOException.class);
    throw new AssertionError(throwable);
  }
  
  @CanIgnoreReturnValue
  public <C extends Closeable> C register(@Nullable C paramC) {
    if (paramC != null)
      this.stack.addFirst((Closeable)paramC); 
    return paramC;
  }
  
  public RuntimeException rethrow(Throwable paramThrowable) throws IOException {
    Preconditions.checkNotNull(paramThrowable);
    this.thrown = paramThrowable;
    Throwables.propagateIfPossible(paramThrowable, IOException.class);
    throw new RuntimeException(paramThrowable);
  }
  
  public <X extends Exception> RuntimeException rethrow(Throwable paramThrowable, Class<X> paramClass) throws IOException, X {
    Preconditions.checkNotNull(paramThrowable);
    this.thrown = paramThrowable;
    Throwables.propagateIfPossible(paramThrowable, IOException.class);
    Throwables.propagateIfPossible(paramThrowable, paramClass);
    throw new RuntimeException(paramThrowable);
  }
  
  public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable paramThrowable, Class<X1> paramClass, Class<X2> paramClass1) throws IOException, X1, X2 {
    Preconditions.checkNotNull(paramThrowable);
    this.thrown = paramThrowable;
    Throwables.propagateIfPossible(paramThrowable, IOException.class);
    Throwables.propagateIfPossible(paramThrowable, paramClass, paramClass1);
    throw new RuntimeException(paramThrowable);
  }
  
  @VisibleForTesting
  static final class LoggingSuppressor implements Suppressor {
    static final LoggingSuppressor INSTANCE = new LoggingSuppressor();
    
    public void suppress(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2) {
      Logger logger = Closeables.logger;
      Level level = Level.WARNING;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppressing exception thrown when closing ");
      stringBuilder.append(param1Closeable);
      logger.log(level, stringBuilder.toString(), param1Throwable2);
    }
  }
  
  @VisibleForTesting
  static final class SuppressingSuppressor implements Suppressor {
    static final SuppressingSuppressor INSTANCE = new SuppressingSuppressor();
    
    static final Method addSuppressed = getAddSuppressed();
    
    private static Method getAddSuppressed() {
      try {
        return Throwable.class.getMethod("addSuppressed", new Class[] { Throwable.class });
      } catch (Throwable throwable) {
        return null;
      } 
    }
    
    static boolean isAvailable() {
      boolean bool;
      if (addSuppressed != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void suppress(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2) {
      if (param1Throwable1 == param1Throwable2)
        return; 
      try {
        addSuppressed.invoke(param1Throwable1, new Object[] { param1Throwable2 });
      } catch (Throwable throwable) {
        Closer.LoggingSuppressor.INSTANCE.suppress(param1Closeable, param1Throwable1, param1Throwable2);
      } 
    }
  }
  
  @VisibleForTesting
  static interface Suppressor {
    void suppress(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\Closer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */