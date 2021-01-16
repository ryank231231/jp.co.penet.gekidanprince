package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

final class Murmur3_32HashFunction extends AbstractStreamingHashFunction implements Serializable {
  private static final int C1 = -862048943;
  
  private static final int C2 = 461845907;
  
  private static final long serialVersionUID = 0L;
  
  private final int seed;
  
  Murmur3_32HashFunction(int paramInt) {
    this.seed = paramInt;
  }
  
  private static HashCode fmix(int paramInt1, int paramInt2) {
    paramInt1 ^= paramInt2;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 16) * -2048144789;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 13) * -1028477387;
    return HashCode.fromInt(paramInt1 ^ paramInt1 >>> 16);
  }
  
  private static int mixH1(int paramInt1, int paramInt2) {
    return Integer.rotateLeft(paramInt1 ^ paramInt2, 13) * 5 - 430675100;
  }
  
  private static int mixK1(int paramInt) {
    return Integer.rotateLeft(paramInt * -862048943, 15) * 461845907;
  }
  
  public int bits() {
    return 32;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof Murmur3_32HashFunction;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      if (this.seed == ((Murmur3_32HashFunction)paramObject).seed)
        bool1 = true; 
      return bool1;
    } 
    return false;
  }
  
  public int hashCode() {
    return getClass().hashCode() ^ this.seed;
  }
  
  public HashCode hashInt(int paramInt) {
    paramInt = mixK1(paramInt);
    return fmix(mixH1(this.seed, paramInt), 4);
  }
  
  public HashCode hashLong(long paramLong) {
    int i = (int)paramLong;
    int j = (int)(paramLong >>> 32L);
    i = mixK1(i);
    return fmix(mixH1(mixH1(this.seed, i), mixK1(j)), 8);
  }
  
  public HashCode hashUnencodedChars(CharSequence paramCharSequence) {
    int i = this.seed;
    int j;
    for (j = 1; j < paramCharSequence.length(); j += 2)
      i = mixH1(i, mixK1(paramCharSequence.charAt(j - 1) | paramCharSequence.charAt(j) << 16)); 
    j = i;
    if ((paramCharSequence.length() & 0x1) == 1)
      j = i ^ mixK1(paramCharSequence.charAt(paramCharSequence.length() - 1)); 
    return fmix(j, paramCharSequence.length() * 2);
  }
  
  public Hasher newHasher() {
    return new Murmur3_32Hasher(this.seed);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Hashing.murmur3_32(");
    stringBuilder.append(this.seed);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  private static final class Murmur3_32Hasher extends AbstractStreamingHashFunction.AbstractStreamingHasher {
    private static final int CHUNK_SIZE = 4;
    
    private int h1;
    
    private int length;
    
    Murmur3_32Hasher(int param1Int) {
      super(4);
      this.h1 = param1Int;
      this.length = 0;
    }
    
    public HashCode makeHash() {
      return Murmur3_32HashFunction.fmix(this.h1, this.length);
    }
    
    protected void process(ByteBuffer param1ByteBuffer) {
      int i = Murmur3_32HashFunction.mixK1(param1ByteBuffer.getInt());
      this.h1 = Murmur3_32HashFunction.mixH1(this.h1, i);
      this.length += 4;
    }
    
    protected void processRemaining(ByteBuffer param1ByteBuffer) {
      this.length += param1ByteBuffer.remaining();
      int i = 0;
      for (byte b = 0; param1ByteBuffer.hasRemaining(); b += 8)
        i ^= UnsignedBytes.toInt(param1ByteBuffer.get()) << b; 
      this.h1 ^= Murmur3_32HashFunction.mixK1(i);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\Murmur3_32HashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */