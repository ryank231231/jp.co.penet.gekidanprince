package io.grpc.internal;

import io.grpc.Status;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ManagedClientTransport extends ClientTransport {
  void shutdown(Status paramStatus);
  
  void shutdownNow(Status paramStatus);
  
  @CheckReturnValue
  @Nullable
  Runnable start(Listener paramListener);
  
  class ManagedClientTransport {}
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\ManagedClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */