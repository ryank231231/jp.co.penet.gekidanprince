package io.grpc;

import com.google.errorprone.annotations.DoNotMock;
import javax.annotation.concurrent.ThreadSafe;

@DoNotMock
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
@ThreadSafe
public abstract class StreamTracer {
  public void inboundMessage(int paramInt) {}
  
  public void inboundMessageRead(int paramInt, long paramLong1, long paramLong2) {}
  
  public void inboundUncompressedSize(long paramLong) {}
  
  public void inboundWireSize(long paramLong) {}
  
  public void outboundMessage(int paramInt) {}
  
  public void outboundMessageSent(int paramInt, long paramLong1, long paramLong2) {}
  
  public void outboundUncompressedSize(long paramLong) {}
  
  public void outboundWireSize(long paramLong) {}
  
  public void streamClosed(Status paramStatus) {}
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\StreamTracer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */