package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible
final class SerializingExecutor implements Executor {
  private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
  
  private final Executor executor;
  
  private final Object internalLock = new Object();
  
  @GuardedBy("internalLock")
  private boolean isWorkerRunning = false;
  
  @GuardedBy("internalLock")
  private final Deque<Runnable> queue = new ArrayDeque<Runnable>();
  
  @GuardedBy("internalLock")
  private int suspensions = 0;
  
  public SerializingExecutor(Executor paramExecutor) {
    this.executor = (Executor)Preconditions.checkNotNull(paramExecutor);
  }
  
  private void startQueueWorker() {
    synchronized (this.internalLock) {
      if (this.queue.peek() == null)
        return; 
      if (this.suspensions > 0)
        return; 
      if (this.isWorkerRunning)
        return; 
      this.isWorkerRunning = true;
      try {
        Executor executor = this.executor;
        null = new QueueWorker();
        super(this);
        return;
      } finally {
        null = null;
      } 
    } 
  }
  
  public void execute(Runnable paramRunnable) {
    synchronized (this.internalLock) {
      this.queue.add(paramRunnable);
      startQueueWorker();
      return;
    } 
  }
  
  public void executeFirst(Runnable paramRunnable) {
    synchronized (this.internalLock) {
      this.queue.addFirst(paramRunnable);
      startQueueWorker();
      return;
    } 
  }
  
  public void resume() {
    synchronized (this.internalLock) {
      boolean bool;
      if (this.suspensions > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      this.suspensions--;
      startQueueWorker();
      return;
    } 
  }
  
  public void suspend() {
    synchronized (this.internalLock) {
      this.suspensions++;
      return;
    } 
  }
  
  private final class QueueWorker implements Runnable {
    private QueueWorker() {}
    
    private void workOnQueue() {
      while (true) {
        null = null;
        synchronized (SerializingExecutor.this.internalLock) {
          if (SerializingExecutor.this.suspensions == 0)
            null = SerializingExecutor.this.queue.poll(); 
          if (null == null) {
            SerializingExecutor.access$202(SerializingExecutor.this, false);
            return;
          } 
          try {
            null.run();
          } catch (RuntimeException runtimeException) {
            Logger logger = SerializingExecutor.log;
            null = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception while executing runnable ");
            stringBuilder.append(null);
            logger.log((Level)null, stringBuilder.toString(), runtimeException);
          } 
        } 
      } 
    }
    
    public void run() {
      try {
        workOnQueue();
        return;
      } catch (Error null) {
        synchronized (SerializingExecutor.this.internalLock) {
          SerializingExecutor.access$202(SerializingExecutor.this, false);
          throw null;
        } 
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\SerializingExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */