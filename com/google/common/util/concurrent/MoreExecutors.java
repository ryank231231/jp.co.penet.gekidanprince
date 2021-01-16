package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

@GwtCompatible(emulated = true)
public final class MoreExecutors {
  @Beta
  @GwtIncompatible
  public static void addDelayedShutdownHook(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {
    (new Application()).addDelayedShutdownHook(paramExecutorService, paramLong, paramTimeUnit);
  }
  
  public static Executor directExecutor() {
    return DirectExecutor.INSTANCE;
  }
  
  @Beta
  @GwtIncompatible
  public static ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor) {
    return (new Application()).getExitingExecutorService(paramThreadPoolExecutor);
  }
  
  @Beta
  @GwtIncompatible
  public static ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit) {
    return (new Application()).getExitingExecutorService(paramThreadPoolExecutor, paramLong, paramTimeUnit);
  }
  
  @Beta
  @GwtIncompatible
  public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor) {
    return (new Application()).getExitingScheduledExecutorService(paramScheduledThreadPoolExecutor);
  }
  
  @Beta
  @GwtIncompatible
  public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit) {
    return (new Application()).getExitingScheduledExecutorService(paramScheduledThreadPoolExecutor, paramLong, paramTimeUnit);
  }
  
  @GwtIncompatible
  static <T> T invokeAnyImpl(ListeningExecutorService paramListeningExecutorService, Collection<? extends Callable<T>> paramCollection, boolean paramBoolean, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    boolean bool;
    Preconditions.checkNotNull(paramListeningExecutorService);
    Preconditions.checkNotNull(paramTimeUnit);
    int i = paramCollection.size();
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    ArrayList arrayList = Lists.newArrayListWithCapacity(i);
    LinkedBlockingQueue<Future<?>> linkedBlockingQueue = Queues.newLinkedBlockingQueue();
    long l = paramTimeUnit.toNanos(paramLong);
    if (paramBoolean) {
      try {
        paramLong = System.nanoTime();
      } finally {}
    } else {
      paramLong = 0L;
    } 
    Iterator<? extends Callable<T>> iterator = paramCollection.iterator();
    arrayList.add(submitAndAddQueueListener(paramListeningExecutorService, iterator.next(), linkedBlockingQueue));
    i--;
    paramCollection = null;
    int j;
    for (j = 1;; j = k) {
      Future<Collection<? extends Callable<T>>> future = (Future)linkedBlockingQueue.poll();
      if (future == null)
        if (i > 0) {
          arrayList.add(submitAndAddQueueListener(paramListeningExecutorService, iterator.next(), linkedBlockingQueue));
          j++;
          i--;
        } else {
          if (j == 0) {
            ExecutionException executionException;
            Collection<? extends Callable<T>> collection = paramCollection;
            if (paramCollection == null) {
              executionException = new ExecutionException();
              this((Throwable)null);
            } 
            throw executionException;
          } 
          if (paramBoolean) {
            future = (Future)linkedBlockingQueue.poll(l, TimeUnit.NANOSECONDS);
            if (future != null) {
              long l1 = System.nanoTime();
              l -= l1 - paramLong;
              paramLong = l1;
            } else {
              TimeoutException timeoutException = new TimeoutException();
              this();
              throw timeoutException;
            } 
          } else {
            future = (Future)linkedBlockingQueue.take();
          } 
        }  
      int k = j;
      if (future != null) {
        k = j - 1;
        try {
          paramCollection = future.get();
          Iterator<Future> iterator1 = arrayList.iterator();
          while (iterator1.hasNext())
            ((Future)iterator1.next()).cancel(true); 
          return (T)paramCollection;
        } catch (ExecutionException executionException) {
        
        } catch (RuntimeException runtimeException) {
          ExecutionException executionException = new ExecutionException(runtimeException);
        } 
      } 
    } 
  }
  
  @GwtIncompatible
  private static boolean isAppEngine() {
    String str = System.getProperty("com.google.appengine.runtime.environment");
    boolean bool = false;
    if (str == null)
      return false; 
    try {
      Object object = Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]);
      if (object != null)
        bool = true; 
      return bool;
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } catch (InvocationTargetException invocationTargetException) {
      return false;
    } catch (IllegalAccessException illegalAccessException) {
      return false;
    } catch (NoSuchMethodException noSuchMethodException) {
      return false;
    } 
  }
  
  @GwtIncompatible
  public static ListeningExecutorService listeningDecorator(ExecutorService paramExecutorService) {
    if (paramExecutorService instanceof ListeningExecutorService) {
      paramExecutorService = paramExecutorService;
    } else if (paramExecutorService instanceof ScheduledExecutorService) {
      paramExecutorService = new ScheduledListeningDecorator((ScheduledExecutorService)paramExecutorService);
    } else {
      paramExecutorService = new ListeningDecorator(paramExecutorService);
    } 
    return (ListeningExecutorService)paramExecutorService;
  }
  
  @GwtIncompatible
  public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService paramScheduledExecutorService) {
    if (paramScheduledExecutorService instanceof ListeningScheduledExecutorService) {
      paramScheduledExecutorService = paramScheduledExecutorService;
    } else {
      paramScheduledExecutorService = new ScheduledListeningDecorator(paramScheduledExecutorService);
    } 
    return (ListeningScheduledExecutorService)paramScheduledExecutorService;
  }
  
  @GwtIncompatible
  public static ListeningExecutorService newDirectExecutorService() {
    return new DirectExecutorService();
  }
  
  @GwtIncompatible
  static Thread newThread(String paramString, Runnable paramRunnable) {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramRunnable);
    paramRunnable = platformThreadFactory().newThread(paramRunnable);
    try {
      paramRunnable.setName(paramString);
    } catch (SecurityException securityException) {}
    return (Thread)paramRunnable;
  }
  
  @Beta
  @GwtIncompatible
  public static ThreadFactory platformThreadFactory() {
    if (!isAppEngine())
      return Executors.defaultThreadFactory(); 
    try {
      return (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", illegalAccessException);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", classNotFoundException);
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", noSuchMethodException);
    } catch (InvocationTargetException invocationTargetException) {
      throw Throwables.propagate(invocationTargetException.getCause());
    } 
  }
  
  static Executor rejectionPropagatingExecutor(final Executor delegate, final AbstractFuture<?> future) {
    Preconditions.checkNotNull(delegate);
    Preconditions.checkNotNull(future);
    return (delegate == directExecutor()) ? delegate : new Executor() {
        volatile boolean thrownFromDelegate = true;
        
        public void execute(Runnable param1Runnable) {
          try {
            Executor executor = delegate;
            Runnable runnable = new Runnable() {
                public void run() {
                  MoreExecutors.null.this.thrownFromDelegate = false;
                  command.run();
                }
              };
            super(this, param1Runnable);
            executor.execute(runnable);
          } catch (RejectedExecutionException rejectedExecutionException) {
            if (this.thrownFromDelegate)
              future.setException(rejectedExecutionException); 
          } 
        }
      };
  }
  
  @GwtIncompatible
  static Executor renamingDecorator(final Executor executor, final Supplier<String> nameSupplier) {
    Preconditions.checkNotNull(executor);
    Preconditions.checkNotNull(nameSupplier);
    return isAppEngine() ? executor : new Executor() {
        public void execute(Runnable param1Runnable) {
          executor.execute(Callables.threadRenaming(param1Runnable, nameSupplier));
        }
      };
  }
  
  @GwtIncompatible
  static ExecutorService renamingDecorator(ExecutorService paramExecutorService, final Supplier<String> nameSupplier) {
    Preconditions.checkNotNull(paramExecutorService);
    Preconditions.checkNotNull(nameSupplier);
    return isAppEngine() ? paramExecutorService : new WrappingExecutorService(paramExecutorService) {
        protected Runnable wrapTask(Runnable param1Runnable) {
          return Callables.threadRenaming(param1Runnable, nameSupplier);
        }
        
        protected <T> Callable<T> wrapTask(Callable<T> param1Callable) {
          return Callables.threadRenaming(param1Callable, nameSupplier);
        }
      };
  }
  
  @GwtIncompatible
  static ScheduledExecutorService renamingDecorator(ScheduledExecutorService paramScheduledExecutorService, final Supplier<String> nameSupplier) {
    Preconditions.checkNotNull(paramScheduledExecutorService);
    Preconditions.checkNotNull(nameSupplier);
    return isAppEngine() ? paramScheduledExecutorService : new WrappingScheduledExecutorService(paramScheduledExecutorService) {
        protected Runnable wrapTask(Runnable param1Runnable) {
          return Callables.threadRenaming(param1Runnable, nameSupplier);
        }
        
        protected <T> Callable<T> wrapTask(Callable<T> param1Callable) {
          return Callables.threadRenaming(param1Callable, nameSupplier);
        }
      };
  }
  
  @Deprecated
  @GwtIncompatible
  public static ListeningExecutorService sameThreadExecutor() {
    return new DirectExecutorService();
  }
  
  @Beta
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static boolean shutdownAndAwaitTermination(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {
    paramLong = paramTimeUnit.toNanos(paramLong) / 2L;
    paramExecutorService.shutdown();
    try {
      if (!paramExecutorService.awaitTermination(paramLong, TimeUnit.NANOSECONDS)) {
        paramExecutorService.shutdownNow();
        paramExecutorService.awaitTermination(paramLong, TimeUnit.NANOSECONDS);
      } 
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      paramExecutorService.shutdownNow();
    } 
    return paramExecutorService.isTerminated();
  }
  
  @GwtIncompatible
  private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService paramListeningExecutorService, Callable<T> paramCallable, final BlockingQueue<Future<T>> queue) {
    final ListenableFuture<T> future = paramListeningExecutorService.submit(paramCallable);
    listenableFuture.addListener(new Runnable() {
          public void run() {
            queue.add(future);
          }
        },  directExecutor());
    return listenableFuture;
  }
  
  @GwtIncompatible
  private static void useDaemonThreadFactory(ThreadPoolExecutor paramThreadPoolExecutor) {
    paramThreadPoolExecutor.setThreadFactory((new ThreadFactoryBuilder()).setDaemon(true).setThreadFactory(paramThreadPoolExecutor.getThreadFactory()).build());
  }
  
  @GwtIncompatible
  @VisibleForTesting
  static class Application {
    final void addDelayedShutdownHook(final ExecutorService service, final long terminationTimeout, final TimeUnit timeUnit) {
      Preconditions.checkNotNull(service);
      Preconditions.checkNotNull(timeUnit);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DelayedShutdownHook-for-");
      stringBuilder.append(service);
      addShutdownHook(MoreExecutors.newThread(stringBuilder.toString(), new Runnable() {
              public void run() {
                try {
                  service.shutdown();
                  service.awaitTermination(terminationTimeout, timeUnit);
                } catch (InterruptedException interruptedException) {}
              }
            }));
    }
    
    @VisibleForTesting
    void addShutdownHook(Thread param1Thread) {
      Runtime.getRuntime().addShutdownHook(param1Thread);
    }
    
    final ExecutorService getExitingExecutorService(ThreadPoolExecutor param1ThreadPoolExecutor) {
      return getExitingExecutorService(param1ThreadPoolExecutor, 120L, TimeUnit.SECONDS);
    }
    
    final ExecutorService getExitingExecutorService(ThreadPoolExecutor param1ThreadPoolExecutor, long param1Long, TimeUnit param1TimeUnit) {
      MoreExecutors.useDaemonThreadFactory(param1ThreadPoolExecutor);
      ExecutorService executorService = Executors.unconfigurableExecutorService(param1ThreadPoolExecutor);
      addDelayedShutdownHook(executorService, param1Long, param1TimeUnit);
      return executorService;
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor param1ScheduledThreadPoolExecutor) {
      return getExitingScheduledExecutorService(param1ScheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor param1ScheduledThreadPoolExecutor, long param1Long, TimeUnit param1TimeUnit) {
      MoreExecutors.useDaemonThreadFactory(param1ScheduledThreadPoolExecutor);
      ScheduledExecutorService scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(param1ScheduledThreadPoolExecutor);
      addDelayedShutdownHook(scheduledExecutorService, param1Long, param1TimeUnit);
      return scheduledExecutorService;
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        service.shutdown();
        service.awaitTermination(terminationTimeout, timeUnit);
      } catch (InterruptedException interruptedException) {}
    }
  }
  
  private enum DirectExecutor implements Executor {
    INSTANCE;
    
    static {
    
    }
    
    public void execute(Runnable param1Runnable) {
      param1Runnable.run();
    }
    
    public String toString() {
      return "MoreExecutors.directExecutor()";
    }
  }
  
  @GwtIncompatible
  private static final class DirectExecutorService extends AbstractListeningExecutorService {
    private final Object lock = new Object();
    
    @GuardedBy("lock")
    private int runningTasks = 0;
    
    @GuardedBy("lock")
    private boolean shutdown = false;
    
    private DirectExecutorService() {}
    
    private void endTask() {
      synchronized (this.lock) {
        int i = this.runningTasks - 1;
        this.runningTasks = i;
        if (i == 0)
          this.lock.notifyAll(); 
        return;
      } 
    }
    
    private void startTask() {
      synchronized (this.lock) {
        if (!this.shutdown) {
          this.runningTasks++;
          return;
        } 
        RejectedExecutionException rejectedExecutionException = new RejectedExecutionException();
        this("Executor already shutdown");
        throw rejectedExecutionException;
      } 
    }
    
    public boolean awaitTermination(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      param1Long = param1TimeUnit.toNanos(param1Long);
      synchronized (this.lock) {
        while (true) {
          if (this.shutdown && this.runningTasks == 0)
            return true; 
          if (param1Long <= 0L)
            return false; 
          long l = System.nanoTime();
          TimeUnit.NANOSECONDS.timedWait(this.lock, param1Long);
          param1Long -= System.nanoTime() - l;
        } 
      } 
    }
    
    public void execute(Runnable param1Runnable) {
      startTask();
      try {
        param1Runnable.run();
        return;
      } finally {
        endTask();
      } 
    }
    
    public boolean isShutdown() {
      synchronized (this.lock) {
        return this.shutdown;
      } 
    }
    
    public boolean isTerminated() {
      synchronized (this.lock) {
        boolean bool;
        if (this.shutdown && this.runningTasks == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      } 
    }
    
    public void shutdown() {
      synchronized (this.lock) {
        this.shutdown = true;
        if (this.runningTasks == 0)
          this.lock.notifyAll(); 
        return;
      } 
    }
    
    public List<Runnable> shutdownNow() {
      shutdown();
      return Collections.emptyList();
    }
  }
  
  @GwtIncompatible
  private static class ListeningDecorator extends AbstractListeningExecutorService {
    private final ExecutorService delegate;
    
    ListeningDecorator(ExecutorService param1ExecutorService) {
      this.delegate = (ExecutorService)Preconditions.checkNotNull(param1ExecutorService);
    }
    
    public final boolean awaitTermination(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      return this.delegate.awaitTermination(param1Long, param1TimeUnit);
    }
    
    public final void execute(Runnable param1Runnable) {
      this.delegate.execute(param1Runnable);
    }
    
    public final boolean isShutdown() {
      return this.delegate.isShutdown();
    }
    
    public final boolean isTerminated() {
      return this.delegate.isTerminated();
    }
    
    public final void shutdown() {
      this.delegate.shutdown();
    }
    
    public final List<Runnable> shutdownNow() {
      return this.delegate.shutdownNow();
    }
  }
  
  @GwtIncompatible
  private static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
    final ScheduledExecutorService delegate;
    
    ScheduledListeningDecorator(ScheduledExecutorService param1ScheduledExecutorService) {
      super(param1ScheduledExecutorService);
      this.delegate = (ScheduledExecutorService)Preconditions.checkNotNull(param1ScheduledExecutorService);
    }
    
    public ListenableScheduledFuture<?> schedule(Runnable<?> param1Runnable, long param1Long, TimeUnit param1TimeUnit) {
      param1Runnable = TrustedListenableFutureTask.create(param1Runnable, null);
      return new ListenableScheduledTask((ListenableFuture<?>)param1Runnable, this.delegate.schedule(param1Runnable, param1Long, param1TimeUnit));
    }
    
    public <V> ListenableScheduledFuture<V> schedule(Callable<V> param1Callable, long param1Long, TimeUnit param1TimeUnit) {
      TrustedListenableFutureTask<V> trustedListenableFutureTask = TrustedListenableFutureTask.create(param1Callable);
      return new ListenableScheduledTask<V>(trustedListenableFutureTask, this.delegate.schedule(trustedListenableFutureTask, param1Long, param1TimeUnit));
    }
    
    public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable param1Runnable, long param1Long1, long param1Long2, TimeUnit param1TimeUnit) {
      param1Runnable = new NeverSuccessfulListenableFutureTask(param1Runnable);
      return new ListenableScheduledTask((ListenableFuture<?>)param1Runnable, this.delegate.scheduleAtFixedRate(param1Runnable, param1Long1, param1Long2, param1TimeUnit));
    }
    
    public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable param1Runnable, long param1Long1, long param1Long2, TimeUnit param1TimeUnit) {
      param1Runnable = new NeverSuccessfulListenableFutureTask(param1Runnable);
      return new ListenableScheduledTask((ListenableFuture<?>)param1Runnable, this.delegate.scheduleWithFixedDelay(param1Runnable, param1Long1, param1Long2, param1TimeUnit));
    }
    
    private static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
      private final ScheduledFuture<?> scheduledDelegate;
      
      public ListenableScheduledTask(ListenableFuture<V> param2ListenableFuture, ScheduledFuture<?> param2ScheduledFuture) {
        super(param2ListenableFuture);
        this.scheduledDelegate = param2ScheduledFuture;
      }
      
      public boolean cancel(boolean param2Boolean) {
        boolean bool = super.cancel(param2Boolean);
        if (bool)
          this.scheduledDelegate.cancel(param2Boolean); 
        return bool;
      }
      
      public int compareTo(Delayed param2Delayed) {
        return this.scheduledDelegate.compareTo(param2Delayed);
      }
      
      public long getDelay(TimeUnit param2TimeUnit) {
        return this.scheduledDelegate.getDelay(param2TimeUnit);
      }
    }
    
    @GwtIncompatible
    private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture<Void> implements Runnable {
      private final Runnable delegate;
      
      public NeverSuccessfulListenableFutureTask(Runnable param2Runnable) {
        this.delegate = (Runnable)Preconditions.checkNotNull(param2Runnable);
      }
      
      public void run() {
        try {
          this.delegate.run();
          return;
        } catch (Throwable throwable) {
          setException(throwable);
          throw Throwables.propagate(throwable);
        } 
      }
    }
  }
  
  private static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
    private final ScheduledFuture<?> scheduledDelegate;
    
    public ListenableScheduledTask(ListenableFuture<V> param1ListenableFuture, ScheduledFuture<?> param1ScheduledFuture) {
      super(param1ListenableFuture);
      this.scheduledDelegate = param1ScheduledFuture;
    }
    
    public boolean cancel(boolean param1Boolean) {
      boolean bool = super.cancel(param1Boolean);
      if (bool)
        this.scheduledDelegate.cancel(param1Boolean); 
      return bool;
    }
    
    public int compareTo(Delayed param1Delayed) {
      return this.scheduledDelegate.compareTo(param1Delayed);
    }
    
    public long getDelay(TimeUnit param1TimeUnit) {
      return this.scheduledDelegate.getDelay(param1TimeUnit);
    }
  }
  
  @GwtIncompatible
  private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture<Void> implements Runnable {
    private final Runnable delegate;
    
    public NeverSuccessfulListenableFutureTask(Runnable param1Runnable) {
      this.delegate = (Runnable)Preconditions.checkNotNull(param1Runnable);
    }
    
    public void run() {
      try {
        this.delegate.run();
        return;
      } catch (Throwable throwable) {
        setException(throwable);
        throw Throwables.propagate(throwable);
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\MoreExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */