package io.grpc.internal;

import io.grpc.Status;

public interface ServerStreamListener extends StreamListener {
  void closed(Status paramStatus);
  
  void halfClosed();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ServerStreamListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */