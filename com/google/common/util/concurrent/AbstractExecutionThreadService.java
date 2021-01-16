package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
public abstract class AbstractExecutionThreadService implements Service {
  private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
  
  private final Service delegate = new AbstractService() {
      protected final void doStart() {
        MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), new Supplier<String>() {
              public String get() {
                return AbstractExecutionThreadService.this.serviceName();
              }
            }).execute(new Runnable() {
              public void run() {
                try {
                  AbstractExecutionThreadService.this.startUp();
                  AbstractExecutionThreadService.null.this.notifyStarted();
                  boolean bool = AbstractExecutionThreadService.null.this.isRunning();
                  if (bool)
                    try {
                      AbstractExecutionThreadService.this.run();
                    } catch (Throwable throwable) {
                      try {
                        AbstractExecutionThreadService.this.shutDown();
                      } catch (Exception exception) {
                        AbstractExecutionThreadService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
                      } 
                      AbstractExecutionThreadService.null.this.notifyFailed(throwable);
                      return;
                    }  
                  AbstractExecutionThreadService.this.shutDown();
                  AbstractExecutionThreadService.null.this.notifyStopped();
                } catch (Throwable throwable) {
                  AbstractExecutionThreadService.null.this.notifyFailed(throwable);
                } 
              }
            });
      }
      
      protected void doStop() {
        AbstractExecutionThreadService.this.triggerShutdown();
      }
      
      public String toString() {
        return AbstractExecutionThreadService.this.toString();
      }
    };
  
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
          MoreExecutors.newThread(AbstractExecutionThreadService.this.serviceName(), param1Runnable).start();
        }
      };
  }
  
  public final Throwable failureCause() {
    return this.delegate.failureCause();
  }
  
  public final boolean isRunning() {
    return this.delegate.isRunning();
  }
  
  protected abstract void run() throws Exception;
  
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
  
  protected void triggerShutdown() {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractExecutionThreadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */