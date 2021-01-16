package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;

public interface ServerTransportListener {
  void streamCreated(ServerStream paramServerStream, String paramString, Metadata paramMetadata);
  
  Attributes transportReady(Attributes paramAttributes);
  
  void transportTerminated();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ServerTransportListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */