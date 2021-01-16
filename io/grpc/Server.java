package io.grpc;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class Server {
  public abstract void awaitTermination() throws InterruptedException;
  
  public abstract boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException;
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
  public List<ServerServiceDefinition> getImmutableServices() {
    return Collections.emptyList();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
  public List<ServerServiceDefinition> getMutableServices() {
    return Collections.emptyList();
  }
  
  public int getPort() {
    return -1;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
  public List<ServerServiceDefinition> getServices() {
    return Collections.emptyList();
  }
  
  public abstract boolean isShutdown();
  
  public abstract boolean isTerminated();
  
  public abstract Server shutdown();
  
  public abstract Server shutdownNow();
  
  public abstract Server start() throws IOException;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Server.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */