package io.grpc.okhttp;

import io.grpc.internal.AbstractReadableBuffer;
import io.grpc.internal.ReadableBuffer;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import okio.Buffer;

class OkHttpReadableBuffer extends AbstractReadableBuffer {
  private final Buffer buffer;
  
  OkHttpReadableBuffer(Buffer paramBuffer) {
    this.buffer = paramBuffer;
  }
  
  public void close() {
    this.buffer.clear();
  }
  
  public ReadableBuffer readBytes(int paramInt) {
    Buffer buffer = new Buffer();
    buffer.write(this.buffer, paramInt);
    return (ReadableBuffer)new OkHttpReadableBuffer(buffer);
  }
  
  public void readBytes(OutputStream paramOutputStream, int paramInt) throws IOException {
    this.buffer.writeTo(paramOutputStream, paramInt);
  }
  
  public void readBytes(ByteBuffer paramByteBuffer) {
    throw new UnsupportedOperationException();
  }
  
  public void readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    while (paramInt2 > 0) {
      int i = this.buffer.read(paramArrayOfbyte, paramInt1, paramInt2);
      if (i != -1) {
        paramInt2 -= i;
        paramInt1 += i;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("EOF trying to read ");
      stringBuilder.append(paramInt2);
      stringBuilder.append(" bytes");
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    } 
  }
  
  public int readUnsignedByte() {
    return this.buffer.readByte() & 0xFF;
  }
  
  public int readableBytes() {
    return (int)this.buffer.size();
  }
  
  public void skipBytes(int paramInt) {
    try {
      this.buffer.skip(paramInt);
      return;
    } catch (EOFException eOFException) {
      throw new IndexOutOfBoundsException(eOFException.getMessage());
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpReadableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */