package io.grpc.internal;

import io.grpc.Compressor;
import java.io.InputStream;

public interface Stream {
  void flush();
  
  boolean isReady();
  
  void request(int paramInt);
  
  void setCompressor(Compressor paramCompressor);
  
  void setMessageCompression(boolean paramBoolean);
  
  void writeMessage(InputStream paramInputStream);
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\Stream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */