package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import java.io.InputStream;

public class NoopClientStream implements ClientStream {
  public static final NoopClientStream INSTANCE = new NoopClientStream();
  
  public void cancel(Status paramStatus) {}
  
  public void flush() {}
  
  public Attributes getAttributes() {
    return Attributes.EMPTY;
  }
  
  public void halfClose() {}
  
  public boolean isReady() {
    return false;
  }
  
  public void request(int paramInt) {}
  
  public void setAuthority(String paramString) {}
  
  public void setCompressor(Compressor paramCompressor) {}
  
  public void setDecompressorRegistry(DecompressorRegistry paramDecompressorRegistry) {}
  
  public void setFullStreamDecompression(boolean paramBoolean) {}
  
  public void setMaxInboundMessageSize(int paramInt) {}
  
  public void setMaxOutboundMessageSize(int paramInt) {}
  
  public void setMessageCompression(boolean paramBoolean) {}
  
  public void start(ClientStreamListener paramClientStreamListener) {}
  
  public void writeMessage(InputStream paramInputStream) {}
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\NoopClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */