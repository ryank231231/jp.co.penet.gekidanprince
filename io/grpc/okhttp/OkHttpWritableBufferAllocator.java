package io.grpc.okhttp;

import io.grpc.internal.WritableBuffer;
import io.grpc.internal.WritableBufferAllocator;
import okio.Buffer;

class OkHttpWritableBufferAllocator implements WritableBufferAllocator {
  private static final int MAX_BUFFER = 1048576;
  
  private static final int MIN_BUFFER = 4096;
  
  public WritableBuffer allocate(int paramInt) {
    paramInt = Math.min(1048576, Math.max(4096, paramInt));
    return new OkHttpWritableBuffer(new Buffer(), paramInt);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpWritableBufferAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */