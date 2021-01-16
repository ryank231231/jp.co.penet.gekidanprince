package io.grpc.internal;

import io.grpc.Metadata;
import io.grpc.Status;

public interface ClientStreamListener extends StreamListener {
  void closed(Status paramStatus, Metadata paramMetadata);
  
  void closed(Status paramStatus, RpcProgress paramRpcProgress, Metadata paramMetadata);
  
  void headersRead(Metadata paramMetadata);
  
  public enum RpcProgress {
    DROPPED, PROCESSED, REFUSED;
    
    static {
      $VALUES = new RpcProgress[] { PROCESSED, REFUSED, DROPPED };
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ClientStreamListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */