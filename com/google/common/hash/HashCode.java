package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
public abstract class HashCode {
  private static final char[] hexDigits = "0123456789abcdef".toCharArray();
  
  private static int decode(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    if (paramChar >= 'a' && paramChar <= 'f')
      return paramChar - 97 + 10; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal hexadecimal character: ");
    stringBuilder.append(paramChar);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static HashCode fromBytes(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    boolean bool = true;
    if (i < 1)
      bool = false; 
    Preconditions.checkArgument(bool, "A HashCode must contain at least 1 byte.");
    return fromBytesNoCopy((byte[])paramArrayOfbyte.clone());
  }
  
  static HashCode fromBytesNoCopy(byte[] paramArrayOfbyte) {
    return new BytesHashCode(paramArrayOfbyte);
  }
  
  public static HashCode fromInt(int paramInt) {
    return new IntHashCode(paramInt);
  }
  
  public static HashCode fromLong(long paramLong) {
    return new LongHashCode(paramLong);
  }
  
  public static HashCode fromString(String paramString) {
    boolean bool2;
    int i = paramString.length();
    boolean bool1 = true;
    byte b = 0;
    if (i >= 2) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "input string (%s) must have at least 2 characters", paramString);
    if (paramString.length() % 2 == 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "input string (%s) must have an even number of characters", paramString);
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    while (b < paramString.length()) {
      i = decode(paramString.charAt(b));
      int j = decode(paramString.charAt(b + 1));
      arrayOfByte[b / 2] = (byte)(byte)((i << 4) + j);
      b += 2;
    } 
    return fromBytesNoCopy(arrayOfByte);
  }
  
  public abstract byte[] asBytes();
  
  public abstract int asInt();
  
  public abstract long asLong();
  
  public abstract int bits();
  
  public final boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof HashCode;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (bits() == paramObject.bits()) {
        bool = bool1;
        if (equalsSameBits((HashCode)paramObject))
          bool = true; 
      } 
      return bool;
    } 
    return false;
  }
  
  abstract boolean equalsSameBits(HashCode paramHashCode);
  
  byte[] getBytesInternal() {
    return asBytes();
  }
  
  public final int hashCode() {
    if (bits() >= 32)
      return asInt(); 
    byte[] arrayOfByte = getBytesInternal();
    int i = arrayOfByte[0] & 0xFF;
    for (byte b = 1; b < arrayOfByte.length; b++)
      i |= (arrayOfByte[b] & 0xFF) << b * 8; 
    return i;
  }
  
  public abstract long padToLong();
  
  public final String toString() {
    byte[] arrayOfByte = getBytesInternal();
    StringBuilder stringBuilder = new StringBuilder(arrayOfByte.length * 2);
    int i = arrayOfByte.length;
    for (byte b = 0; b < i; b++) {
      byte b1 = arrayOfByte[b];
      stringBuilder.append(hexDigits[b1 >> 4 & 0xF]);
      stringBuilder.append(hexDigits[b1 & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  @CanIgnoreReturnValue
  public int writeBytesTo(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramInt2 = Ints.min(new int[] { paramInt2, bits() / 8 });
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    writeBytesToImpl(paramArrayOfbyte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  abstract void writeBytesToImpl(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  private static final class BytesHashCode extends HashCode implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final byte[] bytes;
    
    BytesHashCode(byte[] param1ArrayOfbyte) {
      this.bytes = (byte[])Preconditions.checkNotNull(param1ArrayOfbyte);
    }
    
    public byte[] asBytes() {
      return (byte[])this.bytes.clone();
    }
    
    public int asInt() {
      boolean bool;
      if (this.bytes.length >= 4) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
      byte[] arrayOfByte = this.bytes;
      byte b1 = arrayOfByte[0];
      byte b2 = arrayOfByte[1];
      byte b3 = arrayOfByte[2];
      return (arrayOfByte[3] & 0xFF) << 24 | (b2 & 0xFF) << 8 | b1 & 0xFF | (b3 & 0xFF) << 16;
    }
    
    public long asLong() {
      boolean bool;
      if (this.bytes.length >= 8) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
      return padToLong();
    }
    
    public int bits() {
      return this.bytes.length * 8;
    }
    
    boolean equalsSameBits(HashCode param1HashCode) {
      if (this.bytes.length != (param1HashCode.getBytesInternal()).length)
        return false; 
      byte b = 0;
      int i = 1;
      while (true) {
        byte[] arrayOfByte = this.bytes;
        if (b < arrayOfByte.length) {
          byte b1;
          if (arrayOfByte[b] == param1HashCode.getBytesInternal()[b]) {
            b1 = 1;
          } else {
            b1 = 0;
          } 
          i &= b1;
          b++;
          continue;
        } 
        return i;
      } 
    }
    
    byte[] getBytesInternal() {
      return this.bytes;
    }
    
    public long padToLong() {
      long l = (this.bytes[0] & 0xFF);
      for (byte b = 1; b < Math.min(this.bytes.length, 8); b++)
        l |= (this.bytes[b] & 0xFFL) << b * 8; 
      return l;
    }
    
    void writeBytesToImpl(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      System.arraycopy(this.bytes, 0, param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
  
  private static final class IntHashCode extends HashCode implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final int hash;
    
    IntHashCode(int param1Int) {
      this.hash = param1Int;
    }
    
    public byte[] asBytes() {
      int i = this.hash;
      return new byte[] { (byte)i, (byte)(i >> 8), (byte)(i >> 16), (byte)(i >> 24) };
    }
    
    public int asInt() {
      return this.hash;
    }
    
    public long asLong() {
      throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
    }
    
    public int bits() {
      return 32;
    }
    
    boolean equalsSameBits(HashCode param1HashCode) {
      boolean bool;
      if (this.hash == param1HashCode.asInt()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public long padToLong() {
      return UnsignedInts.toLong(this.hash);
    }
    
    void writeBytesToImpl(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      for (byte b = 0; b < param1Int2; b++)
        param1ArrayOfbyte[param1Int1 + b] = (byte)(byte)(this.hash >> b * 8); 
    }
  }
  
  private static final class LongHashCode extends HashCode implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final long hash;
    
    LongHashCode(long param1Long) {
      this.hash = param1Long;
    }
    
    public byte[] asBytes() {
      long l = this.hash;
      return new byte[] { (byte)(int)l, (byte)(int)(l >> 8L), (byte)(int)(l >> 16L), (byte)(int)(l >> 24L), (byte)(int)(l >> 32L), (byte)(int)(l >> 40L), (byte)(int)(l >> 48L), (byte)(int)(l >> 56L) };
    }
    
    public int asInt() {
      return (int)this.hash;
    }
    
    public long asLong() {
      return this.hash;
    }
    
    public int bits() {
      return 64;
    }
    
    boolean equalsSameBits(HashCode param1HashCode) {
      boolean bool;
      if (this.hash == param1HashCode.asLong()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public long padToLong() {
      return this.hash;
    }
    
    void writeBytesToImpl(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      for (byte b = 0; b < param1Int2; b++)
        param1ArrayOfbyte[param1Int1 + b] = (byte)(byte)(int)(this.hash >> b * 8); 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\HashCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */