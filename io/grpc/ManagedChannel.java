package io.grpc;

import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class ManagedChannel extends Channel {
  public abstract boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException;
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4056")
  public void enterIdle() {}
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4359")
  public ConnectivityState getState(boolean paramBoolean) {
    throw new UnsupportedOperationException("Not implemented");
  }
  
  public abstract boolean isShutdown();
  
  public abstract boolean isTerminated();
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4359")
  public void notifyWhenStateChanged(ConnectivityState paramConnectivityState, Runnable paramRunnable) {
    throw new UnsupportedOperationException("Not implemented");
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4056")
  public void resetConnectBackoff() {}
  
  public abstract ManagedChannel shutdown();
  
  public abstract ManagedChannel shutdownNow();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ManagedChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */