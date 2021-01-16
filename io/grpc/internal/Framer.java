package io.grpc.internal;

import io.grpc.Compressor;
import java.io.InputStream;

public interface Framer {
  void close();
  
  void dispose();
  
  void flush();
  
  boolean isClosed();
  
  Framer setCompressor(Compressor paramCompressor);
  
  void setMaxOutboundMessageSize(int paramInt);
  
  Framer setMessageCompression(boolean paramBoolean);
  
  void writePayload(InputStream paramInputStream);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\Framer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */