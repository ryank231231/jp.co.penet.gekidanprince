package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;

public interface ClientStream extends Stream {
  void cancel(Status paramStatus);
  
  Attributes getAttributes();
  
  void halfClose();
  
  void setAuthority(String paramString);
  
  void setDecompressorRegistry(DecompressorRegistry paramDecompressorRegistry);
  
  void setFullStreamDecompression(boolean paramBoolean);
  
  void setMaxInboundMessageSize(int paramInt);
  
  void setMaxOutboundMessageSize(int paramInt);
  
  void start(ClientStreamListener paramClientStreamListener);
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\ClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */