package io.grpc.internal;

import io.grpc.Status;
import java.util.concurrent.ScheduledExecutorService;

public interface ServerTransport extends Instrumented<Channelz.SocketStats> {
  ScheduledExecutorService getScheduledExecutorService();
  
  void shutdown();
  
  void shutdownNow(Status paramStatus);
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\ServerTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */