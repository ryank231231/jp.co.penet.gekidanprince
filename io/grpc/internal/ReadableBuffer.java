package io.grpc.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public interface ReadableBuffer extends Closeable {
  byte[] array();
  
  int arrayOffset();
  
  void close();
  
  boolean hasArray();
  
  ReadableBuffer readBytes(int paramInt);
  
  void readBytes(OutputStream paramOutputStream, int paramInt) throws IOException;
  
  void readBytes(ByteBuffer paramByteBuffer);
  
  void readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  int readInt();
  
  int readUnsignedByte();
  
  int readableBytes();
  
  void skipBytes(int paramInt);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ReadableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */