package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@Beta
@GwtIncompatible
public abstract class AbstractScheduledService implements Service {
  private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
  
  private final AbstractService delegate = new ServiceDelegate();
  
  public final void addListener(Service.Listener paramListener, Executor paramExecutor) {
    this.delegate.addListener(paramListener, paramExecutor);
  }
  
  public final void awaitRunning() {
    this.delegate.awaitRunning();
  }
  
  public final void awaitRunning(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
    this.delegate.awaitRunning(paramLong, paramTimeUnit);
  }
  
  public final void awaitTerminated() {
    this.delegate.awaitTerminated();
  }
  
  public final void awaitTerminated(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
    this.delegate.awaitTerminated(paramLong, paramTimeUnit);
  }
  
  protected ScheduledExecutorService executor() {
    class ThreadFactoryImpl implements ThreadFactory {
      public Thread newThread(Runnable param1Runnable) {
        return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), param1Runnable);
      }
    };
    final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryImpl());
    addListener(new Service.Listener() {
          public void failed(Service.State param1State, Throwable param1Throwable) {
            executor.shutdown();
          }
          
          public void terminated(Service.State param1State) {
            executor.shutdown();
          }
        },  MoreExecutors.directExecutor());
    return scheduledExecutorService;
  }
  
  public final Throwable failureCause() {
    return this.delegate.failureCause();
  }
  
  public final boolean isRunning() {
    return this.delegate.isRunning();
  }
  
  protected abstract void runOneIteration() throws Exception;
  
  protected abstract Scheduler scheduler();
  
  protected String serviceName() {
    return getClass().getSimpleName();
  }
  
  protected void shutDown() throws Exception {}
  
  @CanIgnoreReturnValue
  public final Service startAsync() {
    this.delegate.startAsync();
    return this;
  }
  
  protected void startUp() throws Exception {}
  
  public final Service.State state() {
    return this.delegate.state();
  }
  
  @CanIgnoreReturnValue
  public final Service stopAsync() {
    this.delegate.stopAsync();
    return this;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(serviceName());
    stringBuilder.append(" [");
    stringBuilder.append(state());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  @Beta
  public static abstract class CustomScheduler extends Scheduler {
    protected abstract Schedule getNextSchedule() throws Exception;
    
    final Future<?> schedule(AbstractService param1AbstractService, ScheduledExecutorService param1ScheduledExecutorService, Runnable param1Runnable) {
      ReschedulableCallable reschedulableCallable = new ReschedulableCallable(param1AbstractService, param1ScheduledExecutorService, param1Runnable);
      reschedulableCallable.reschedule();
      return reschedulableCallable;
    }
    
    private class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
      @GuardedBy("lock")
      private Future<Void> currentFuture;
      
      private final ScheduledExecutorService executor;
      
      private final ReentrantLock lock = new ReentrantLock();
      
      private final AbstractService service;
      
      private final Runnable wrappedRunnable;
      
      ReschedulableCallable(AbstractService param2AbstractService, ScheduledExecutorService param2ScheduledExecutorService, Runnable param2Runnable) {
        this.wrappedRunnable = param2Runnable;
        this.executor = param2ScheduledExecutorService;
        this.service = param2AbstractService;
      }
      
      public Void call() throws Exception {
        this.wrappedRunnable.run();
        reschedule();
        return null;
      }
      
      public boolean cancel(boolean param2Boolean) {
        this.lock.lock();
        try {
          param2Boolean = this.currentFuture.cancel(param2Boolean);
          return param2Boolean;
        } finally {
          this.lock.unlock();
        } 
      }
      
      protected Future<Void> delegate() {
        throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
      }
      
      public boolean isCancelled() {
        this.lock.lock();
        try {
          return this.currentFuture.isCancelled();
        } finally {
          this.lock.unlock();
        } 
      }
      
      public void reschedule() {
        // Byte code:
        //   0: aload_0
        //   1: getfield this$0 : Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler;
        //   4: invokevirtual getNextSchedule : ()Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;
        //   7: astore_1
        //   8: aconst_null
        //   9: astore_2
        //   10: aload_0
        //   11: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
        //   14: invokevirtual lock : ()V
        //   17: aload_0
        //   18: getfield currentFuture : Ljava/util/concurrent/Future;
        //   21: ifnull -> 38
        //   24: aload_2
        //   25: astore_3
        //   26: aload_0
        //   27: getfield currentFuture : Ljava/util/concurrent/Future;
        //   30: invokeinterface isCancelled : ()Z
        //   35: ifne -> 76
        //   38: aload_0
        //   39: aload_0
        //   40: getfield executor : Ljava/util/concurrent/ScheduledExecutorService;
        //   43: aload_0
        //   44: aload_1
        //   45: invokestatic access$800 : (Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;)J
        //   48: aload_1
        //   49: invokestatic access$900 : (Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;)Ljava/util/concurrent/TimeUnit;
        //   52: invokeinterface schedule : (Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
        //   57: putfield currentFuture : Ljava/util/concurrent/Future;
        //   60: aload_2
        //   61: astore_3
        //   62: goto -> 76
        //   65: astore_3
        //   66: aload_0
        //   67: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
        //   70: invokevirtual unlock : ()V
        //   73: aload_3
        //   74: athrow
        //   75: astore_3
        //   76: aload_0
        //   77: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
        //   80: invokevirtual unlock : ()V
        //   83: aload_3
        //   84: ifnull -> 95
        //   87: aload_0
        //   88: getfield service : Lcom/google/common/util/concurrent/AbstractService;
        //   91: aload_3
        //   92: invokevirtual notifyFailed : (Ljava/lang/Throwable;)V
        //   95: return
        //   96: astore_3
        //   97: aload_0
        //   98: getfield service : Lcom/google/common/util/concurrent/AbstractService;
        //   101: aload_3
        //   102: invokevirtual notifyFailed : (Ljava/lang/Throwable;)V
        //   105: return
        // Exception table:
        //   from	to	target	type
        //   0	8	96	java/lang/Throwable
        //   17	24	75	java/lang/Throwable
        //   17	24	65	finally
        //   26	38	75	java/lang/Throwable
        //   26	38	65	finally
        //   38	60	75	java/lang/Throwable
        //   38	60	65	finally
      }
    }
    
    @Beta
    protected static final class Schedule {
      private final long delay;
      
      private final TimeUnit unit;
      
      public Schedule(long param2Long, TimeUnit param2TimeUnit) {
        this.delay = param2Long;
        this.unit = (TimeUnit)Preconditions.checkNotNull(param2TimeUnit);
      }
    }
  }
  
  private class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
    @GuardedBy("lock")
    private Future<Void> currentFuture;
    
    private final ScheduledExecutorService executor;
    
    private final ReentrantLock lock = new ReentrantLock();
    
    private final AbstractService service;
    
    private final Runnable wrappedRunnable;
    
    ReschedulableCallable(AbstractService param1AbstractService, ScheduledExecutorService param1ScheduledExecutorService, Runnable param1Runnable) {
      this.wrappedRunnable = param1Runnable;
      this.executor = param1ScheduledExecutorService;
      this.service = param1AbstractService;
    }
    
    public Void call() throws Exception {
      this.wrappedRunnable.run();
      reschedule();
      return null;
    }
    
    public boolean cancel(boolean param1Boolean) {
      this.lock.lock();
      try {
        param1Boolean = this.currentFuture.cancel(param1Boolean);
        return param1Boolean;
      } finally {
        this.lock.unlock();
      } 
    }
    
    protected Future<Void> delegate() {
      throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
    }
    
    public boolean isCancelled() {
      this.lock.lock();
      try {
        return this.currentFuture.isCancelled();
      } finally {
        this.lock.unlock();
      } 
    }
    
    public void reschedule() {
      // Byte code:
      //   0: aload_0
      //   1: getfield this$0 : Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler;
      //   4: invokevirtual getNextSchedule : ()Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;
      //   7: astore_1
      //   8: aconst_null
      //   9: astore_2
      //   10: aload_0
      //   11: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
      //   14: invokevirtual lock : ()V
      //   17: aload_0
      //   18: getfield currentFuture : Ljava/util/concurrent/Future;
      //   21: ifnull -> 38
      //   24: aload_2
      //   25: astore_3
      //   26: aload_0
      //   27: getfield currentFuture : Ljava/util/concurrent/Future;
      //   30: invokeinterface isCancelled : ()Z
      //   35: ifne -> 76
      //   38: aload_0
      //   39: aload_0
      //   40: getfield executor : Ljava/util/concurrent/ScheduledExecutorService;
      //   43: aload_0
      //   44: aload_1
      //   45: invokestatic access$800 : (Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;)J
      //   48: aload_1
      //   49: invokestatic access$900 : (Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;)Ljava/util/concurrent/TimeUnit;
      //   52: invokeinterface schedule : (Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
      //   57: putfield currentFuture : Ljava/util/concurrent/Future;
      //   60: aload_2
      //   61: astore_3
      //   62: goto -> 76
      //   65: astore_3
      //   66: aload_0
      //   67: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
      //   70: invokevirtual unlock : ()V
      //   73: aload_3
      //   74: athrow
      //   75: astore_3
      //   76: aload_0
      //   77: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
      //   80: invokevirtual unlock : ()V
      //   83: aload_3
      //   84: ifnull -> 95
      //   87: aload_0
      //   88: getfield service : Lcom/google/common/util/concurrent/AbstractService;
      //   91: aload_3
      //   92: invokevirtual notifyFailed : (Ljava/lang/Throwable;)V
      //   95: return
      //   96: astore_3
      //   97: aload_0
      //   98: getfield service : Lcom/google/common/util/concurrent/AbstractService;
      //   101: aload_3
      //   102: invokevirtual notifyFailed : (Ljava/lang/Throwable;)V
      //   105: return
      // Exception table:
      //   from	to	target	type
      //   0	8	96	java/lang/Throwable
      //   17	24	75	java/lang/Throwable
      //   17	24	65	finally
      //   26	38	75	java/lang/Throwable
      //   26	38	65	finally
      //   38	60	75	java/lang/Throwable
      //   38	60	65	finally
    }
  }
  
  @Beta
  protected static final class Schedule {
    private final long delay;
    
    private final TimeUnit unit;
    
    public Schedule(long param1Long, TimeUnit param1TimeUnit) {
      this.delay = param1Long;
      this.unit = (TimeUnit)Preconditions.checkNotNull(param1TimeUnit);
    }
  }
  
  public static abstract class Scheduler {
    private Scheduler() {}
    
    public static Scheduler newFixedDelaySchedule(final long initialDelay, final long delay, final TimeUnit unit) {
      boolean bool;
      Preconditions.checkNotNull(unit);
      if (delay > 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "delay must be > 0, found %s", delay);
      return new Scheduler() {
          public Future<?> schedule(AbstractService param2AbstractService, ScheduledExecutorService param2ScheduledExecutorService, Runnable param2Runnable) {
            return param2ScheduledExecutorService.scheduleWithFixedDelay(param2Runnable, initialDelay, delay, unit);
          }
        };
    }
    
    public static Scheduler newFixedRateSchedule(final long initialDelay, final long period, final TimeUnit unit) {
      boolean bool;
      Preconditions.checkNotNull(unit);
      if (period > 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "period must be > 0, found %s", period);
      return new Scheduler() {
          public Future<?> schedule(AbstractService param2AbstractService, ScheduledExecutorService param2ScheduledExecutorService, Runnable param2Runnable) {
            return param2ScheduledExecutorService.scheduleAtFixedRate(param2Runnable, initialDelay, period, unit);
          }
        };
    }
    
    abstract Future<?> schedule(AbstractService param1AbstractService, ScheduledExecutorService param1ScheduledExecutorService, Runnable param1Runnable);
  }
  
  static final class null extends Scheduler {
    public Future<?> schedule(AbstractService param1AbstractService, ScheduledExecutorService param1ScheduledExecutorService, Runnable param1Runnable) {
      return param1ScheduledExecutorService.scheduleWithFixedDelay(param1Runnable, initialDelay, delay, unit);
    }
  }
  
  static final class null extends Scheduler {
    public Future<?> schedule(AbstractService param1AbstractService, ScheduledExecutorService param1ScheduledExecutorService, Runnable param1Runnable) {
      return param1ScheduledExecutorService.scheduleAtFixedRate(param1Runnable, initialDelay, period, unit);
    }
  }
  
  private final class ServiceDelegate extends AbstractService {
    private volatile ScheduledExecutorService executorService;
    
    private final ReentrantLock lock = new ReentrantLock();
    
    private volatile Future<?> runningTask;
    
    private final Runnable task = new Task();
    
    private ServiceDelegate() {}
    
    protected final void doStart() {
      this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), new Supplier<String>() {
            public String get() {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(AbstractScheduledService.this.serviceName());
              stringBuilder.append(" ");
              stringBuilder.append(AbstractScheduledService.ServiceDelegate.this.state());
              return stringBuilder.toString();
            }
          });
      this.executorService.execute(new Runnable() {
            public void run() {
              AbstractScheduledService.ServiceDelegate.this.lock.lock();
              try {
                AbstractScheduledService.this.startUp();
                AbstractScheduledService.ServiceDelegate.access$302(AbstractScheduledService.ServiceDelegate.this, AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, AbstractScheduledService.ServiceDelegate.this.executorService, AbstractScheduledService.ServiceDelegate.this.task));
                AbstractScheduledService.ServiceDelegate.this.notifyStarted();
              } catch (Throwable throwable) {
                AbstractScheduledService.ServiceDelegate.this.notifyFailed(throwable);
                if (AbstractScheduledService.ServiceDelegate.this.runningTask != null)
                  AbstractScheduledService.ServiceDelegate.this.runningTask.cancel(false); 
              } finally {
                Exception exception;
              } 
              AbstractScheduledService.ServiceDelegate.this.lock.unlock();
            }
          });
    }
    
    protected final void doStop() {
      this.runningTask.cancel(false);
      this.executorService.execute(new Runnable() {
            public void run() {
              try {
                AbstractScheduledService.ServiceDelegate.this.lock.lock();
                try {
                  Service.State state1 = AbstractScheduledService.ServiceDelegate.this.state();
                  Service.State state2 = Service.State.STOPPING;
                  if (state1 != state2)
                    return; 
                  AbstractScheduledService.this.shutDown();
                  AbstractScheduledService.ServiceDelegate.this.lock.unlock();
                } finally {
                  AbstractScheduledService.ServiceDelegate.this.lock.unlock();
                } 
              } catch (Throwable throwable) {
                AbstractScheduledService.ServiceDelegate.this.notifyFailed(throwable);
              } 
            }
          });
    }
    
    public String toString() {
      return AbstractScheduledService.this.toString();
    }
    
    class Task implements Runnable {
      public void run() {
        AbstractScheduledService.ServiceDelegate.this.lock.lock();
        try {
          boolean bool = AbstractScheduledService.ServiceDelegate.this.runningTask.isCancelled();
          if (bool) {
            AbstractScheduledService.ServiceDelegate.this.lock.unlock();
            return;
          } 
          AbstractScheduledService.this.runOneIteration();
          AbstractScheduledService.ServiceDelegate.this.lock.unlock();
        } catch (Throwable throwable) {
          try {
            AbstractScheduledService.this.shutDown();
          } catch (Exception exception) {
            AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
          } 
          AbstractScheduledService.ServiceDelegate.this.notifyFailed(throwable);
          AbstractScheduledService.ServiceDelegate.this.runningTask.cancel(false);
          AbstractScheduledService.ServiceDelegate.this.lock.unlock();
        } finally {
          Exception exception;
        } 
      }
    }
  }
  
  class null implements Supplier<String> {
    public String get() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(AbstractScheduledService.this.serviceName());
      stringBuilder.append(" ");
      stringBuilder.append(this.this$1.state());
      return stringBuilder.toString();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.lock.lock();
      try {
        AbstractScheduledService.this.startUp();
        AbstractScheduledService.ServiceDelegate.access$302(this.this$1, AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, this.this$1.executorService, this.this$1.task));
        this.this$1.notifyStarted();
      } catch (Throwable throwable) {
        this.this$1.notifyFailed(throwable);
        if (this.this$1.runningTask != null)
          this.this$1.runningTask.cancel(false); 
      } finally {
        Exception exception;
      } 
      this.this$1.lock.unlock();
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        this.this$1.lock.lock();
        try {
          Service.State state1 = this.this$1.state();
          Service.State state2 = Service.State.STOPPING;
          if (state1 != state2)
            return; 
          AbstractScheduledService.this.shutDown();
          this.this$1.lock.unlock();
        } finally {
          this.this$1.lock.unlock();
        } 
      } catch (Throwable throwable) {
        this.this$1.notifyFailed(throwable);
      } 
    }
  }
  
  class Task implements Runnable {
    public void run() {
      this.this$1.lock.lock();
      try {
        boolean bool = this.this$1.runningTask.isCancelled();
        if (bool) {
          this.this$1.lock.unlock();
          return;
        } 
        AbstractScheduledService.this.runOneIteration();
        this.this$1.lock.unlock();
      } catch (Throwable throwable) {
        try {
          AbstractScheduledService.this.shutDown();
        } catch (Exception exception) {
          AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
        } 
        this.this$1.notifyFailed(throwable);
        this.this$1.runningTask.cancel(false);
        this.this$1.lock.unlock();
      } finally {
        Exception exception;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractScheduledService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */