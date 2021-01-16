package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import java.io.InputStream;

abstract class ForwardingClientStream implements ClientStream {
  public void cancel(Status paramStatus) {
    delegate().cancel(paramStatus);
  }
  
  protected abstract ClientStream delegate();
  
  public void flush() {
    delegate().flush();
  }
  
  public Attributes getAttributes() {
    return delegate().getAttributes();
  }
  
  public void halfClose() {
    delegate().halfClose();
  }
  
  public boolean isReady() {
    return delegate().isReady();
  }
  
  public void request(int paramInt) {
    delegate().request(paramInt);
  }
  
  public void setAuthority(String paramString) {
    delegate().setAuthority(paramString);
  }
  
  public void setCompressor(Compressor paramCompressor) {
    delegate().setCompressor(paramCompressor);
  }
  
  public void setDecompressorRegistry(DecompressorRegistry paramDecompressorRegistry) {
    delegate().setDecompressorRegistry(paramDecompressorRegistry);
  }
  
  public void setFullStreamDecompression(boolean paramBoolean) {
    delegate().setFullStreamDecompression(paramBoolean);
  }
  
  public void setMaxInboundMessageSize(int paramInt) {
    delegate().setMaxInboundMessageSize(paramInt);
  }
  
  public void setMaxOutboundMessageSize(int paramInt) {
    delegate().setMaxOutboundMessageSize(paramInt);
  }
  
  public void setMessageCompression(boolean paramBoolean) {
    delegate().setMessageCompression(paramBoolean);
  }
  
  public void start(ClientStreamListener paramClientStreamListener) {
    delegate().start(paramClientStreamListener);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
  }
  
  public void writeMessage(InputStream paramInputStream) {
    delegate().writeMessage(paramInputStream);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ForwardingClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */