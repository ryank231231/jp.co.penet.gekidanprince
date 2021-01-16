package io.grpc.okhttp;

import io.grpc.internal.WritableBuffer;
import okio.Buffer;

class OkHttpWritableBuffer implements WritableBuffer {
  private final Buffer buffer;
  
  private int readableBytes;
  
  private int writableBytes;
  
  OkHttpWritableBuffer(Buffer paramBuffer, int paramInt) {
    this.buffer = paramBuffer;
    this.writableBytes = paramInt;
  }
  
  Buffer buffer() {
    return this.buffer;
  }
  
  public int readableBytes() {
    return this.readableBytes;
  }
  
  public void release() {}
  
  public int writableBytes() {
    return this.writableBytes;
  }
  
  public void write(byte paramByte) {
    this.buffer.writeByte(paramByte);
    this.writableBytes--;
    this.readableBytes++;
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.buffer.write(paramArrayOfbyte, paramInt1, paramInt2);
    this.writableBytes -= paramInt2;
    this.readableBytes += paramInt2;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpWritableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */