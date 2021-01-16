package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.ManagedChannel;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

final class ManagedChannelOrphanWrapper extends ForwardingManagedChannel {
  private static final Logger logger;
  
  private static final ReferenceQueue<ManagedChannelOrphanWrapper> refqueue = new ReferenceQueue<ManagedChannelOrphanWrapper>();
  
  private static final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs = new ConcurrentHashMap<ManagedChannelReference, ManagedChannelReference>();
  
  private final ManagedChannelReference phantom;
  
  static {
    logger = Logger.getLogger(ManagedChannelOrphanWrapper.class.getName());
  }
  
  ManagedChannelOrphanWrapper(ManagedChannel paramManagedChannel) {
    this(paramManagedChannel, refqueue, refs);
  }
  
  @VisibleForTesting
  ManagedChannelOrphanWrapper(ManagedChannel paramManagedChannel, ReferenceQueue<ManagedChannelOrphanWrapper> paramReferenceQueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> paramConcurrentMap) {
    super(paramManagedChannel);
    this.phantom = new ManagedChannelReference(this, paramManagedChannel, paramReferenceQueue, paramConcurrentMap);
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    boolean bool = super.awaitTermination(paramLong, paramTimeUnit);
    if (bool)
      this.phantom.clear(); 
    return bool;
  }
  
  public ManagedChannel shutdown() {
    ManagedChannelReference.access$002(this.phantom, true);
    return super.shutdown();
  }
  
  public ManagedChannel shutdownNow() {
    ManagedChannelReference.access$102(this.phantom, true);
    return super.shutdownNow();
  }
  
  @VisibleForTesting
  static final class ManagedChannelReference extends WeakReference<ManagedChannelOrphanWrapper> {
    private static final String ALLOCATION_SITE_PROPERTY_NAME = "io.grpc.ManagedChannel.enableAllocationTracking";
    
    private static final boolean ENABLE_ALLOCATION_TRACKING = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));
    
    private static final RuntimeException missingCallSite = missingCallSite();
    
    private final Reference<RuntimeException> allocationSite;
    
    private final ManagedChannel channel;
    
    private final ReferenceQueue<ManagedChannelOrphanWrapper> refqueue;
    
    private final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs;
    
    private volatile boolean shutdown;
    
    private volatile boolean shutdownNow;
    
    ManagedChannelReference(ManagedChannelOrphanWrapper param1ManagedChannelOrphanWrapper, ManagedChannel param1ManagedChannel, ReferenceQueue<ManagedChannelOrphanWrapper> param1ReferenceQueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> param1ConcurrentMap) {
      super(param1ManagedChannelOrphanWrapper, param1ReferenceQueue);
      RuntimeException runtimeException;
      if (ENABLE_ALLOCATION_TRACKING) {
        runtimeException = new RuntimeException("ManagedChannel allocation site");
      } else {
        runtimeException = missingCallSite;
      } 
      this.allocationSite = new SoftReference<RuntimeException>(runtimeException);
      this.channel = param1ManagedChannel;
      this.refqueue = param1ReferenceQueue;
      this.refs = param1ConcurrentMap;
      this.refs.put(this, this);
      cleanQueue(param1ReferenceQueue);
    }
    
    @VisibleForTesting
    static int cleanQueue(ReferenceQueue<ManagedChannelOrphanWrapper> param1ReferenceQueue) {
      int i = 0;
      while (true) {
        ManagedChannelReference managedChannelReference = (ManagedChannelReference)param1ReferenceQueue.poll();
        if (managedChannelReference != null) {
          RuntimeException runtimeException = managedChannelReference.allocationSite.get();
          managedChannelReference.clearInternal();
          if (!managedChannelReference.shutdown || !managedChannelReference.channel.isTerminated()) {
            Level level;
            int j = i + 1;
            if (managedChannelReference.shutdownNow) {
              level = Level.FINE;
            } else {
              level = Level.SEVERE;
            } 
            i = j;
            if (ManagedChannelOrphanWrapper.logger.isLoggable(level)) {
              String str;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("*~*~*~ Channel {0} was not ");
              if (!managedChannelReference.shutdown) {
                str = "shutdown";
              } else {
                str = "terminated";
              } 
              stringBuilder.append(str);
              stringBuilder.append(" properly!!! ~*~*~*");
              stringBuilder.append(System.getProperty("line.separator"));
              stringBuilder.append("    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
              LogRecord logRecord = new LogRecord(level, stringBuilder.toString());
              logRecord.setLoggerName(ManagedChannelOrphanWrapper.logger.getName());
              logRecord.setParameters(new Object[] { managedChannelReference.channel.toString() });
              logRecord.setThrown(runtimeException);
              ManagedChannelOrphanWrapper.logger.log(logRecord);
              i = j;
            } 
          } 
          continue;
        } 
        return i;
      } 
    }
    
    private void clearInternal() {
      super.clear();
      this.refs.remove(this);
      this.allocationSite.clear();
    }
    
    private static RuntimeException missingCallSite() {
      RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
      runtimeException.setStackTrace(new StackTraceElement[0]);
      return runtimeException;
    }
    
    public void clear() {
      clearInternal();
      cleanQueue(this.refqueue);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ManagedChannelOrphanWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */