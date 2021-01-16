package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

public final class UnsafeByteOperations {
  public static ByteString unsafeWrap(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.hasArray()) {
      int i = paramByteBuffer.arrayOffset();
      return ByteString.wrap(paramByteBuffer.array(), i + paramByteBuffer.position(), paramByteBuffer.remaining());
    } 
    return new NioByteString(paramByteBuffer);
  }
  
  public static void unsafeWriteTo(ByteString paramByteString, ByteOutput paramByteOutput) throws IOException {
    paramByteString.writeTo(paramByteOutput);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\UnsafeByteOperations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */