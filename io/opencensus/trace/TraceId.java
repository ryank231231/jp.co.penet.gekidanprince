package io.opencensus.trace;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.util.Arrays;
import java.util.Random;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class TraceId implements Comparable<TraceId> {
  public static final TraceId INVALID = new TraceId(new byte[16]);
  
  public static final int SIZE = 16;
  
  private final byte[] bytes;
  
  private TraceId(byte[] paramArrayOfbyte) {
    this.bytes = paramArrayOfbyte;
  }
  
  public static TraceId fromBytes(byte[] paramArrayOfbyte) {
    boolean bool;
    Preconditions.checkNotNull(paramArrayOfbyte, "buffer");
    if (paramArrayOfbyte.length == 16) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Invalid size: expected %s, got %s", new Object[] { Integer.valueOf(16), Integer.valueOf(paramArrayOfbyte.length) });
    return new TraceId(Arrays.copyOf(paramArrayOfbyte, 16));
  }
  
  public static TraceId fromBytes(byte[] paramArrayOfbyte, int paramInt) {
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(paramArrayOfbyte, paramInt, arrayOfByte, 0, 16);
    return new TraceId(arrayOfByte);
  }
  
  public static TraceId fromLowerBase16(CharSequence paramCharSequence) {
    boolean bool;
    if (paramCharSequence.length() == 32) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Invalid size: expected %s, got %s", new Object[] { Integer.valueOf(32), Integer.valueOf(paramCharSequence.length()) });
    return new TraceId(BaseEncoding.base16().lowerCase().decode(paramCharSequence));
  }
  
  public static TraceId generateRandomId(Random paramRandom) {
    byte[] arrayOfByte = new byte[16];
    while (true) {
      paramRandom.nextBytes(arrayOfByte);
      if (!Arrays.equals(arrayOfByte, INVALID.bytes))
        return new TraceId(arrayOfByte); 
    } 
  }
  
  public int compareTo(TraceId paramTraceId) {
    for (byte b = 0; b < 16; b++) {
      byte[] arrayOfByte1 = this.bytes;
      byte b1 = arrayOfByte1[b];
      byte[] arrayOfByte2 = paramTraceId.bytes;
      if (b1 != arrayOfByte2[b]) {
        if (arrayOfByte1[b] < arrayOfByte2[b]) {
          b = -1;
        } else {
          b = 1;
        } 
        return b;
      } 
    } 
    return 0;
  }
  
  public void copyBytesTo(byte[] paramArrayOfbyte, int paramInt) {
    System.arraycopy(this.bytes, 0, paramArrayOfbyte, paramInt, 16);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof TraceId))
      return false; 
    paramObject = paramObject;
    return Arrays.equals(this.bytes, ((TraceId)paramObject).bytes);
  }
  
  public byte[] getBytes() {
    return Arrays.copyOf(this.bytes, 16);
  }
  
  public long getLowerLong() {
    byte b = 0;
    long l = 0L;
    while (b < 8) {
      l = l << 8L | (this.bytes[b] & 0xFF);
      b++;
    } 
    return (l < 0L) ? -l : l;
  }
  
  public int hashCode() {
    return Arrays.hashCode(this.bytes);
  }
  
  public boolean isValid() {
    return Arrays.equals(this.bytes, INVALID.bytes) ^ true;
  }
  
  public String toLowerBase16() {
    return BaseEncoding.base16().lowerCase().encode(this.bytes);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("traceId", BaseEncoding.base16().lowerCase().encode(this.bytes)).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\TraceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */