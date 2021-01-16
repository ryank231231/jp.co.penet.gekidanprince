package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogExceptionRunnable implements Runnable {
  private static final Logger log = Logger.getLogger(LogExceptionRunnable.class.getName());
  
  private final Runnable task;
  
  public LogExceptionRunnable(Runnable paramRunnable) {
    this.task = (Runnable)Preconditions.checkNotNull(paramRunnable, "task");
  }
  
  public void run() {
    try {
      this.task.run();
      return;
    } catch (Throwable throwable) {
      Logger logger = log;
      Level level = Level.SEVERE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception while executing runnable ");
      stringBuilder.append(this.task);
      logger.log(level, stringBuilder.toString(), throwable);
      MoreThrowables.throwIfUnchecked(throwable);
      throw new AssertionError(throwable);
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LogExceptionRunnable(");
    stringBuilder.append(this.task);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\LogExceptionRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */