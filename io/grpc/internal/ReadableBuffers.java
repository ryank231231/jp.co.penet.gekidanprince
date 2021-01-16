package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.grpc.KnownLength;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class ReadableBuffers {
  private static final ReadableBuffer EMPTY_BUFFER = new ByteArrayWrapper(new byte[0]);
  
  public static ReadableBuffer empty() {
    return EMPTY_BUFFER;
  }
  
  public static ReadableBuffer ignoreClose(ReadableBuffer paramReadableBuffer) {
    return new ForwardingReadableBuffer(paramReadableBuffer) {
        public void close() {}
      };
  }
  
  public static InputStream openStream(ReadableBuffer paramReadableBuffer, boolean paramBoolean) {
    if (!paramBoolean)
      paramReadableBuffer = ignoreClose(paramReadableBuffer); 
    return new BufferInputStream(paramReadableBuffer);
  }
  
  public static byte[] readArray(ReadableBuffer paramReadableBuffer) {
    Preconditions.checkNotNull(paramReadableBuffer, "buffer");
    int i = paramReadableBuffer.readableBytes();
    byte[] arrayOfByte = new byte[i];
    paramReadableBuffer.readBytes(arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static String readAsString(ReadableBuffer paramReadableBuffer, Charset paramCharset) {
    Preconditions.checkNotNull(paramCharset, "charset");
    return new String(readArray(paramReadableBuffer), paramCharset);
  }
  
  public static String readAsStringUtf8(ReadableBuffer paramReadableBuffer) {
    return readAsString(paramReadableBuffer, Charsets.UTF_8);
  }
  
  public static ReadableBuffer wrap(ByteBuffer paramByteBuffer) {
    return new ByteReadableBufferWrapper(paramByteBuffer);
  }
  
  public static ReadableBuffer wrap(byte[] paramArrayOfbyte) {
    return new ByteArrayWrapper(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static ReadableBuffer wrap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return new ByteArrayWrapper(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  private static final class BufferInputStream extends InputStream implements KnownLength {
    final ReadableBuffer buffer;
    
    public BufferInputStream(ReadableBuffer param1ReadableBuffer) {
      this.buffer = (ReadableBuffer)Preconditions.checkNotNull(param1ReadableBuffer, "buffer");
    }
    
    public int available() throws IOException {
      return this.buffer.readableBytes();
    }
    
    public void close() throws IOException {
      this.buffer.close();
    }
    
    public int read() {
      return (this.buffer.readableBytes() == 0) ? -1 : this.buffer.readUnsignedByte();
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      if (this.buffer.readableBytes() == 0)
        return -1; 
      param1Int2 = Math.min(this.buffer.readableBytes(), param1Int2);
      this.buffer.readBytes(param1ArrayOfbyte, param1Int1, param1Int2);
      return param1Int2;
    }
  }
  
  private static class ByteArrayWrapper extends AbstractReadableBuffer {
    final byte[] bytes;
    
    final int end;
    
    int offset;
    
    ByteArrayWrapper(byte[] param1ArrayOfbyte) {
      this(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    ByteArrayWrapper(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      boolean bool2;
      boolean bool1 = true;
      if (param1Int1 >= 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "offset must be >= 0");
      if (param1Int2 >= 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "length must be >= 0");
      param1Int2 += param1Int1;
      if (param1Int2 <= param1ArrayOfbyte.length) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "offset + length exceeds array boundary");
      this.bytes = (byte[])Preconditions.checkNotNull(param1ArrayOfbyte, "bytes");
      this.offset = param1Int1;
      this.end = param1Int2;
    }
    
    public byte[] array() {
      return this.bytes;
    }
    
    public int arrayOffset() {
      return this.offset;
    }
    
    public boolean hasArray() {
      return true;
    }
    
    public ByteArrayWrapper readBytes(int param1Int) {
      checkReadable(param1Int);
      int i = this.offset;
      this.offset = i + param1Int;
      return new ByteArrayWrapper(this.bytes, i, param1Int);
    }
    
    public void readBytes(OutputStream param1OutputStream, int param1Int) throws IOException {
      checkReadable(param1Int);
      param1OutputStream.write(this.bytes, this.offset, param1Int);
      this.offset += param1Int;
    }
    
    public void readBytes(ByteBuffer param1ByteBuffer) {
      Preconditions.checkNotNull(param1ByteBuffer, "dest");
      int i = param1ByteBuffer.remaining();
      checkReadable(i);
      param1ByteBuffer.put(this.bytes, this.offset, i);
      this.offset += i;
    }
    
    public void readBytes(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      System.arraycopy(this.bytes, this.offset, param1ArrayOfbyte, param1Int1, param1Int2);
      this.offset += param1Int2;
    }
    
    public int readUnsignedByte() {
      checkReadable(1);
      byte[] arrayOfByte = this.bytes;
      int i = this.offset;
      this.offset = i + 1;
      return arrayOfByte[i] & 0xFF;
    }
    
    public int readableBytes() {
      return this.end - this.offset;
    }
    
    public void skipBytes(int param1Int) {
      checkReadable(param1Int);
      this.offset += param1Int;
    }
  }
  
  private static class ByteReadableBufferWrapper extends AbstractReadableBuffer {
    final ByteBuffer bytes;
    
    ByteReadableBufferWrapper(ByteBuffer param1ByteBuffer) {
      this.bytes = (ByteBuffer)Preconditions.checkNotNull(param1ByteBuffer, "bytes");
    }
    
    public byte[] array() {
      return this.bytes.array();
    }
    
    public int arrayOffset() {
      return this.bytes.arrayOffset() + this.bytes.position();
    }
    
    public boolean hasArray() {
      return this.bytes.hasArray();
    }
    
    public ByteReadableBufferWrapper readBytes(int param1Int) {
      checkReadable(param1Int);
      ByteBuffer byteBuffer1 = this.bytes.duplicate();
      byteBuffer1.limit(this.bytes.position() + param1Int);
      ByteBuffer byteBuffer2 = this.bytes;
      byteBuffer2.position(byteBuffer2.position() + param1Int);
      return new ByteReadableBufferWrapper(byteBuffer1);
    }
    
    public void readBytes(OutputStream param1OutputStream, int param1Int) throws IOException {
      ByteBuffer byteBuffer;
      checkReadable(param1Int);
      if (hasArray()) {
        param1OutputStream.write(array(), arrayOffset(), param1Int);
        byteBuffer = this.bytes;
        byteBuffer.position(byteBuffer.position() + param1Int);
      } else {
        byte[] arrayOfByte = new byte[param1Int];
        this.bytes.get(arrayOfByte);
        byteBuffer.write(arrayOfByte);
      } 
    }
    
    public void readBytes(ByteBuffer param1ByteBuffer) {
      Preconditions.checkNotNull(param1ByteBuffer, "dest");
      int i = param1ByteBuffer.remaining();
      checkReadable(i);
      int j = this.bytes.limit();
      ByteBuffer byteBuffer = this.bytes;
      byteBuffer.limit(byteBuffer.position() + i);
      param1ByteBuffer.put(this.bytes);
      this.bytes.limit(j);
    }
    
    public void readBytes(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      checkReadable(param1Int2);
      this.bytes.get(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public int readUnsignedByte() {
      checkReadable(1);
      return this.bytes.get() & 0xFF;
    }
    
    public int readableBytes() {
      return this.bytes.remaining();
    }
    
    public void skipBytes(int param1Int) {
      checkReadable(param1Int);
      ByteBuffer byteBuffer = this.bytes;
      byteBuffer.position(byteBuffer.position() + param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ReadableBuffers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */