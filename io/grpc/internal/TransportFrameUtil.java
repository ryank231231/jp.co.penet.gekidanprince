package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import java.util.Arrays;
import java.util.logging.Logger;

public final class TransportFrameUtil {
  private static final byte[] binaryHeaderSuffixBytes;
  
  private static final Logger logger = Logger.getLogger(TransportFrameUtil.class.getName());
  
  static {
    binaryHeaderSuffixBytes = "-bin".getBytes(Charsets.US_ASCII);
  }
  
  private static boolean endsWith(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    int i = paramArrayOfbyte1.length - paramArrayOfbyte2.length;
    if (i < 0)
      return false; 
    for (int j = i; j < paramArrayOfbyte1.length; j++) {
      if (paramArrayOfbyte1[j] != paramArrayOfbyte2[j - i])
        return false; 
    } 
    return true;
  }
  
  private static boolean isSpecCompliantAscii(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      byte b1 = paramArrayOfbyte[b];
      if (b1 < 32 || b1 > 126)
        return false; 
    } 
    return true;
  }
  
  public static byte[][] toHttp2Headers(Metadata paramMetadata) {
    byte[][] arrayOfByte = InternalMetadata.serialize(paramMetadata);
    if (arrayOfByte == null)
      return new byte[0][]; 
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < arrayOfByte.length) {
      byte[] arrayOfByte2 = arrayOfByte[b1];
      byte[] arrayOfByte1 = arrayOfByte[b1 + 1];
      if (endsWith(arrayOfByte2, binaryHeaderSuffixBytes)) {
        arrayOfByte[b2] = arrayOfByte2;
        arrayOfByte[b2 + 1] = BaseEncoding.base64().encode(arrayOfByte1).getBytes(Charsets.US_ASCII);
        b2 += 2;
      } else if (isSpecCompliantAscii(arrayOfByte1)) {
        arrayOfByte[b2] = arrayOfByte2;
        arrayOfByte[b2 + 1] = arrayOfByte1;
        b2 += 2;
      } else {
        String str = new String(arrayOfByte2, Charsets.US_ASCII);
        Logger logger = logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Metadata key=");
        stringBuilder.append(str);
        stringBuilder.append(", value=");
        stringBuilder.append(Arrays.toString(arrayOfByte1));
        stringBuilder.append(" contains invalid ASCII characters");
        logger.warning(stringBuilder.toString());
      } 
      b1 += 2;
    } 
    return (b2 == arrayOfByte.length) ? arrayOfByte : Arrays.<byte[]>copyOfRange(arrayOfByte, 0, b2);
  }
  
  public static byte[][] toRawSerializedHeaders(byte[][] paramArrayOfbyte) {
    for (byte b = 0; b < paramArrayOfbyte.length; b += 2) {
      byte[] arrayOfByte1 = paramArrayOfbyte[b];
      int i = b + 1;
      byte[] arrayOfByte2 = paramArrayOfbyte[i];
      paramArrayOfbyte[b] = arrayOfByte1;
      if (endsWith(arrayOfByte1, binaryHeaderSuffixBytes))
        paramArrayOfbyte[i] = BaseEncoding.base64().decode(new String(arrayOfByte2, Charsets.US_ASCII)); 
    } 
    return paramArrayOfbyte;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\TransportFrameUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */