package io.opencensus.trace;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.util.Arrays;
import java.util.Random;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class SpanId implements Comparable<SpanId> {
  public static final SpanId INVALID = new SpanId(new byte[8]);
  
  public static final int SIZE = 8;
  
  private final byte[] bytes;
  
  private SpanId(byte[] paramArrayOfbyte) {
    this.bytes = paramArrayOfbyte;
  }
  
  public static SpanId fromBytes(byte[] paramArrayOfbyte) {
    boolean bool;
    Preconditions.checkNotNull(paramArrayOfbyte, "buffer");
    if (paramArrayOfbyte.length == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Invalid size: expected %s, got %s", new Object[] { Integer.valueOf(8), Integer.valueOf(paramArrayOfbyte.length) });
    return new SpanId(Arrays.copyOf(paramArrayOfbyte, 8));
  }
  
  public static SpanId fromBytes(byte[] paramArrayOfbyte, int paramInt) {
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfbyte, paramInt, arrayOfByte, 0, 8);
    return new SpanId(arrayOfByte);
  }
  
  public static SpanId fromLowerBase16(CharSequence paramCharSequence) {
    boolean bool;
    if (paramCharSequence.length() == 16) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Invalid size: expected %s, got %s", new Object[] { Integer.valueOf(16), Integer.valueOf(paramCharSequence.length()) });
    return new SpanId(BaseEncoding.base16().lowerCase().decode(paramCharSequence));
  }
  
  public static SpanId generateRandomId(Random paramRandom) {
    byte[] arrayOfByte = new byte[8];
    while (true) {
      paramRandom.nextBytes(arrayOfByte);
      if (!Arrays.equals(arrayOfByte, INVALID.bytes))
        return new SpanId(arrayOfByte); 
    } 
  }
  
  public int compareTo(SpanId paramSpanId) {
    for (byte b = 0; b < 8; b++) {
      byte[] arrayOfByte1 = this.bytes;
      byte b1 = arrayOfByte1[b];
      byte[] arrayOfByte2 = paramSpanId.bytes;
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
    System.arraycopy(this.bytes, 0, paramArrayOfbyte, paramInt, 8);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SpanId))
      return false; 
    paramObject = paramObject;
    return Arrays.equals(this.bytes, ((SpanId)paramObject).bytes);
  }
  
  public byte[] getBytes() {
    return Arrays.copyOf(this.bytes, 8);
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
    return MoreObjects.toStringHelper(this).add("spanId", BaseEncoding.base16().lowerCase().encode(this.bytes)).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\SpanId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */