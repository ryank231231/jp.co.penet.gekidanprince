package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils {
  private static final int MAX_BUFFER_LENGTH = 16384;
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramOutputStream);
    byte[] arrayOfByte = new byte[16384];
    for (long l = 0L;; l += i) {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l; 
      paramOutputStream.write(arrayOfByte, 0, i);
    } 
  }
  
  public static byte[] toByteArray(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\IoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */