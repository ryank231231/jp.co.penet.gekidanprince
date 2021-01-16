package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory {
  static final Map<ScheduledThreadPoolExecutor, Object> POOLS;
  
  public static final boolean PURGE_ENABLED;
  
  static final String PURGE_ENABLED_KEY = "rx2.purge-enabled";
  
  public static final int PURGE_PERIOD_SECONDS;
  
  static final String PURGE_PERIOD_SECONDS_KEY = "rx2.purge-period-seconds";
  
  static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = new AtomicReference<ScheduledExecutorService>();
  
  static {
    POOLS = new ConcurrentHashMap<ScheduledThreadPoolExecutor, Object>();
    Properties properties = System.getProperties();
    PurgeProperties purgeProperties = new PurgeProperties();
    purgeProperties.load(properties);
    PURGE_ENABLED = purgeProperties.purgeEnable;
    PURGE_PERIOD_SECONDS = purgeProperties.purgePeriod;
    start();
  }
  
  private SchedulerPoolFactory() {
    throw new IllegalStateException("No instances!");
  }
  
  public static ScheduledExecutorService create(ThreadFactory paramThreadFactory) {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1, paramThreadFactory);
    tryPutIntoPool(PURGE_ENABLED, scheduledExecutorService);
    return scheduledExecutorService;
  }
  
  public static void shutdown() {
    ScheduledExecutorService scheduledExecutorService = PURGE_THREAD.getAndSet(null);
    if (scheduledExecutorService != null)
      scheduledExecutorService.shutdownNow(); 
    POOLS.clear();
  }
  
  public static void start() {
    tryStart(PURGE_ENABLED);
  }
  
  static void tryPutIntoPool(boolean paramBoolean, ScheduledExecutorService paramScheduledExecutorService) {
    if (paramBoolean && paramScheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
      ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)paramScheduledExecutorService;
      POOLS.put(scheduledThreadPoolExecutor, paramScheduledExecutorService);
    } 
  }
  
  static void tryStart(boolean paramBoolean) {
    if (paramBoolean)
      while (true) {
        ScheduledExecutorService scheduledExecutorService1 = PURGE_THREAD.get();
        if (scheduledExecutorService1 != null)
          return; 
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
        if (PURGE_THREAD.compareAndSet(scheduledExecutorService1, scheduledExecutorService2)) {
          ScheduledTask scheduledTask = new ScheduledTask();
          int i = PURGE_PERIOD_SECONDS;
          scheduledExecutorService2.scheduleAtFixedRate(scheduledTask, i, i, TimeUnit.SECONDS);
          return;
        } 
        scheduledExecutorService2.shutdownNow();
      }  
  }
  
  static final class PurgeProperties {
    boolean purgeEnable;
    
    int purgePeriod;
    
    void load(Properties param1Properties) {
      if (param1Properties.containsKey("rx2.purge-enabled")) {
        this.purgeEnable = Boolean.parseBoolean(param1Properties.getProperty("rx2.purge-enabled"));
      } else {
        this.purgeEnable = true;
      } 
      if (this.purgeEnable && param1Properties.containsKey("rx2.purge-period-seconds")) {
        try {
          this.purgePeriod = Integer.parseInt(param1Properties.getProperty("rx2.purge-period-seconds"));
        } catch (NumberFormatException numberFormatException) {
          this.purgePeriod = 1;
        } 
      } else {
        this.purgePeriod = 1;
      } 
    }
  }
  
  static final class ScheduledTask implements Runnable {
    public void run() {
      for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(SchedulerPoolFactory.POOLS.keySet())) {
        if (scheduledThreadPoolExecutor.isShutdown()) {
          SchedulerPoolFactory.POOLS.remove(scheduledThreadPoolExecutor);
          continue;
        } 
        scheduledThreadPoolExecutor.purge();
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\schedulers\SchedulerPoolFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */