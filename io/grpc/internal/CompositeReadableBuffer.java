package io.grpc.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

public class CompositeReadableBuffer extends AbstractReadableBuffer {
  private final Queue<ReadableBuffer> buffers = new ArrayDeque<ReadableBuffer>();
  
  private int readableBytes;
  
  private void advanceBufferIfNecessary() {
    if (((ReadableBuffer)this.buffers.peek()).readableBytes() == 0)
      ((ReadableBuffer)this.buffers.remove()).close(); 
  }
  
  private void execute(ReadOperation paramReadOperation, int paramInt) {
    checkReadable(paramInt);
    int i = paramInt;
    if (!this.buffers.isEmpty()) {
      advanceBufferIfNecessary();
      i = paramInt;
    } 
    while (i > 0 && !this.buffers.isEmpty()) {
      ReadableBuffer readableBuffer = this.buffers.peek();
      paramInt = Math.min(i, readableBuffer.readableBytes());
      paramReadOperation.read(readableBuffer, paramInt);
      if (paramReadOperation.isError())
        return; 
      i -= paramInt;
      this.readableBytes -= paramInt;
      advanceBufferIfNecessary();
    } 
    if (i <= 0)
      return; 
    throw new AssertionError("Failed executing read operation");
  }
  
  public void addBuffer(ReadableBuffer paramReadableBuffer) {
    if (!(paramReadableBuffer instanceof CompositeReadableBuffer)) {
      this.buffers.add(paramReadableBuffer);
      this.readableBytes += paramReadableBuffer.readableBytes();
      return;
    } 
    paramReadableBuffer = paramReadableBuffer;
    while (!((CompositeReadableBuffer)paramReadableBuffer).buffers.isEmpty()) {
      ReadableBuffer readableBuffer = ((CompositeReadableBuffer)paramReadableBuffer).buffers.remove();
      this.buffers.add(readableBuffer);
    } 
    this.readableBytes += ((CompositeReadableBuffer)paramReadableBuffer).readableBytes;
    ((CompositeReadableBuffer)paramReadableBuffer).readableBytes = 0;
    paramReadableBuffer.close();
  }
  
  public void close() {
    while (!this.buffers.isEmpty())
      ((ReadableBuffer)this.buffers.remove()).close(); 
  }
  
  public CompositeReadableBuffer readBytes(int paramInt) {
    checkReadable(paramInt);
    this.readableBytes -= paramInt;
    CompositeReadableBuffer compositeReadableBuffer = new CompositeReadableBuffer();
    while (paramInt > 0) {
      ReadableBuffer readableBuffer = this.buffers.peek();
      if (readableBuffer.readableBytes() > paramInt) {
        compositeReadableBuffer.addBuffer(readableBuffer.readBytes(paramInt));
        paramInt = 0;
        continue;
      } 
      compositeReadableBuffer.addBuffer(this.buffers.poll());
      paramInt -= readableBuffer.readableBytes();
    } 
    return compositeReadableBuffer;
  }
  
  public void readBytes(final OutputStream dest, int paramInt) throws IOException {
    ReadOperation readOperation = new ReadOperation() {
        public int readInternal(ReadableBuffer param1ReadableBuffer, int param1Int) throws IOException {
          param1ReadableBuffer.readBytes(dest, param1Int);
          return 0;
        }
      };
    execute(readOperation, paramInt);
    if (!readOperation.isError())
      return; 
    throw readOperation.ex;
  }
  
  public void readBytes(final ByteBuffer dest) {
    execute(new ReadOperation() {
          public int readInternal(ReadableBuffer param1ReadableBuffer, int param1Int) {
            int i = dest.limit();
            ByteBuffer byteBuffer = dest;
            byteBuffer.limit(byteBuffer.position() + param1Int);
            param1ReadableBuffer.readBytes(dest);
            dest.limit(i);
            return 0;
          }
        },  dest.remaining());
  }
  
  public void readBytes(final byte[] dest, final int destOffset, int paramInt2) {
    execute(new ReadOperation() {
          int currentOffset = destOffset;
          
          public int readInternal(ReadableBuffer param1ReadableBuffer, int param1Int) {
            param1ReadableBuffer.readBytes(dest, this.currentOffset, param1Int);
            this.currentOffset += param1Int;
            return 0;
          }
        }paramInt2);
  }
  
  public int readUnsignedByte() {
    ReadOperation readOperation = new ReadOperation() {
        int readInternal(ReadableBuffer param1ReadableBuffer, int param1Int) {
          return param1ReadableBuffer.readUnsignedByte();
        }
      };
    execute(readOperation, 1);
    return readOperation.value;
  }
  
  public int readableBytes() {
    return this.readableBytes;
  }
  
  public void skipBytes(int paramInt) {
    execute(new ReadOperation() {
          public int readInternal(ReadableBuffer param1ReadableBuffer, int param1Int) {
            param1ReadableBuffer.skipBytes(param1Int);
            return 0;
          }
        },  paramInt);
  }
  
  private static abstract class ReadOperation {
    IOException ex;
    
    int value;
    
    private ReadOperation() {}
    
    final boolean isError() {
      boolean bool;
      if (this.ex != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    final void read(ReadableBuffer param1ReadableBuffer, int param1Int) {
      try {
        this.value = readInternal(param1ReadableBuffer, param1Int);
      } catch (IOException iOException) {
        this.ex = iOException;
      } 
    }
    
    abstract int readInternal(ReadableBuffer param1ReadableBuffer, int param1Int) throws IOException;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\CompositeReadableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */