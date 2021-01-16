package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
public abstract class AbstractIdleService implements Service {
  private final Service delegate = new DelegateService();
  
  private final Supplier<String> threadNameSupplier = new ThreadNameSupplier();
  
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
  
  protected Executor executor() {
    return new Executor() {
        public void execute(Runnable param1Runnable) {
          MoreExecutors.newThread((String)AbstractIdleService.this.threadNameSupplier.get(), param1Runnable).start();
        }
      };
  }
  
  public final Throwable failureCause() {
    return this.delegate.failureCause();
  }
  
  public final boolean isRunning() {
    return this.delegate.isRunning();
  }
  
  protected String serviceName() {
    return getClass().getSimpleName();
  }
  
  protected abstract void shutDown() throws Exception;
  
  @CanIgnoreReturnValue
  public final Service startAsync() {
    this.delegate.startAsync();
    return this;
  }
  
  protected abstract void startUp() throws Exception;
  
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
  
  private final class DelegateService extends AbstractService {
    private DelegateService() {}
    
    protected final void doStart() {
      MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new Runnable() {
            public void run() {
              try {
                AbstractIdleService.this.startUp();
                AbstractIdleService.DelegateService.this.notifyStarted();
              } catch (Throwable throwable) {
                AbstractIdleService.DelegateService.this.notifyFailed(throwable);
              } 
            }
          });
    }
    
    protected final void doStop() {
      MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new Runnable() {
            public void run() {
              try {
                AbstractIdleService.this.shutDown();
                AbstractIdleService.DelegateService.this.notifyStopped();
              } catch (Throwable throwable) {
                AbstractIdleService.DelegateService.this.notifyFailed(throwable);
              } 
            }
          });
    }
    
    public String toString() {
      return AbstractIdleService.this.toString();
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        AbstractIdleService.this.startUp();
        this.this$1.notifyStarted();
      } catch (Throwable throwable) {
        this.this$1.notifyFailed(throwable);
      } 
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        AbstractIdleService.this.shutDown();
        this.this$1.notifyStopped();
      } catch (Throwable throwable) {
        this.this$1.notifyFailed(throwable);
      } 
    }
  }
  
  private final class ThreadNameSupplier implements Supplier<String> {
    private ThreadNameSupplier() {}
    
    public String get() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(AbstractIdleService.this.serviceName());
      stringBuilder.append(" ");
      stringBuilder.append(AbstractIdleService.this.state());
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractIdleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */