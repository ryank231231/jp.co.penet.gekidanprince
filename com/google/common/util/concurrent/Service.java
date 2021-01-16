package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
public interface Service {
  void addListener(Listener paramListener, Executor paramExecutor);
  
  void awaitRunning();
  
  void awaitRunning(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException;
  
  void awaitTerminated();
  
  void awaitTerminated(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException;
  
  Throwable failureCause();
  
  boolean isRunning();
  
  @CanIgnoreReturnValue
  Service startAsync();
  
  State state();
  
  @CanIgnoreReturnValue
  Service stopAsync();
  
  @Beta
  public static abstract class Listener {
    public void failed(Service.State param1State, Throwable param1Throwable) {}
    
    public void running() {}
    
    public void starting() {}
    
    public void stopping(Service.State param1State) {}
    
    public void terminated(Service.State param1State) {}
  }
  
  @Beta
  public enum State {
    FAILED,
    NEW {
      boolean isTerminal() {
        return false;
      }
    },
    RUNNING,
    STARTING {
      boolean isTerminal() {
        return false;
      }
    },
    STOPPING,
    TERMINATED;
    
    static {
      FAILED = new null("FAILED", 5);
      $VALUES = new State[] { NEW, STARTING, RUNNING, STOPPING, TERMINATED, FAILED };
    }
    
    abstract boolean isTerminal();
  }
  
  enum null {
    boolean isTerminal() {
      return false;
    }
  }
  
  enum null {
    boolean isTerminal() {
      return false;
    }
  }
  
  enum null {
    boolean isTerminal() {
      return false;
    }
  }
  
  enum null {
    boolean isTerminal() {
      return false;
    }
  }
  
  enum null {
    boolean isTerminal() {
      return true;
    }
  }
  
  enum null {
    boolean isTerminal() {
      return true;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */