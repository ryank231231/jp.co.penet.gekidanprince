package io.grpc.internal;

public interface WritableBuffer {
  int readableBytes();
  
  void release();
  
  int writableBytes();
  
  void write(byte paramByte);
  
  void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\WritableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */