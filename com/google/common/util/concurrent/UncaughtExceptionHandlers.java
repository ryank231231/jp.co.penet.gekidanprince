package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
public final class UncaughtExceptionHandlers {
  public static Thread.UncaughtExceptionHandler systemExit() {
    return new Exiter(Runtime.getRuntime());
  }
  
  @VisibleForTesting
  static final class Exiter implements Thread.UncaughtExceptionHandler {
    private static final Logger logger = Logger.getLogger(Exiter.class.getName());
    
    private final Runtime runtime;
    
    Exiter(Runtime param1Runtime) {
      this.runtime = param1Runtime;
    }
    
    public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
      try {
        logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[] { param1Thread }), param1Throwable);
      } catch (Throwable throwable) {
        System.err.println(param1Throwable.getMessage());
        System.err.println(throwable.getMessage());
      } finally {}
      this.runtime.exit(1);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\UncaughtExceptionHandlers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */