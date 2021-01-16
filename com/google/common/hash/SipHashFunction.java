package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

final class SipHashFunction extends AbstractStreamingHashFunction implements Serializable {
  private static final long serialVersionUID = 0L;
  
  private final int c;
  
  private final int d;
  
  private final long k0;
  
  private final long k1;
  
  SipHashFunction(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
    boolean bool2;
    boolean bool1 = true;
    if (paramInt1 > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "The number of SipRound iterations (c=%s) during Compression must be positive.", paramInt1);
    if (paramInt2 > 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "The number of SipRound iterations (d=%s) during Finalization must be positive.", paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    this.k0 = paramLong1;
    this.k1 = paramLong2;
  }
  
  public int bits() {
    return 64;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof SipHashFunction;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (this.c == ((SipHashFunction)paramObject).c) {
        bool = bool1;
        if (this.d == ((SipHashFunction)paramObject).d) {
          bool = bool1;
          if (this.k0 == ((SipHashFunction)paramObject).k0) {
            bool = bool1;
            if (this.k1 == ((SipHashFunction)paramObject).k1)
              bool = true; 
          } 
        } 
      } 
      return bool;
    } 
    return false;
  }
  
  public int hashCode() {
    return (int)((getClass().hashCode() ^ this.c ^ this.d) ^ this.k0 ^ this.k1);
  }
  
  public Hasher newHasher() {
    return new SipHasher(this.c, this.d, this.k0, this.k1);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Hashing.sipHash");
    stringBuilder.append(this.c);
    stringBuilder.append("");
    stringBuilder.append(this.d);
    stringBuilder.append("(");
    stringBuilder.append(this.k0);
    stringBuilder.append(", ");
    stringBuilder.append(this.k1);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  private static final class SipHasher extends AbstractStreamingHashFunction.AbstractStreamingHasher {
    private static final int CHUNK_SIZE = 8;
    
    private long b = 0L;
    
    private final int c;
    
    private final int d;
    
    private long finalM = 0L;
    
    private long v0 = 8317987319222330741L;
    
    private long v1 = 7237128888997146477L;
    
    private long v2 = 7816392313619706465L;
    
    private long v3 = 8387220255154660723L;
    
    SipHasher(int param1Int1, int param1Int2, long param1Long1, long param1Long2) {
      super(8);
      this.c = param1Int1;
      this.d = param1Int2;
      this.v0 ^= param1Long1;
      this.v1 ^= param1Long2;
      this.v2 ^= param1Long1;
      this.v3 ^= param1Long2;
    }
    
    private void processM(long param1Long) {
      this.v3 ^= param1Long;
      sipRound(this.c);
      this.v0 = param1Long ^ this.v0;
    }
    
    private void sipRound(int param1Int) {
      for (byte b = 0; b < param1Int; b++) {
        long l1 = this.v0;
        long l2 = this.v1;
        this.v0 = l1 + l2;
        this.v2 += this.v3;
        this.v1 = Long.rotateLeft(l2, 13);
        this.v3 = Long.rotateLeft(this.v3, 16);
        l1 = this.v1;
        l2 = this.v0;
        this.v1 = l1 ^ l2;
        this.v3 ^= this.v2;
        this.v0 = Long.rotateLeft(l2, 32);
        l1 = this.v2;
        l2 = this.v1;
        this.v2 = l1 + l2;
        this.v0 += this.v3;
        this.v1 = Long.rotateLeft(l2, 17);
        this.v3 = Long.rotateLeft(this.v3, 21);
        l2 = this.v1;
        l1 = this.v2;
        this.v1 = l2 ^ l1;
        this.v3 ^= this.v0;
        this.v2 = Long.rotateLeft(l1, 32);
      } 
    }
    
    public HashCode makeHash() {
      this.finalM ^= this.b << 56L;
      processM(this.finalM);
      this.v2 ^= 0xFFL;
      sipRound(this.d);
      return HashCode.fromLong(this.v0 ^ this.v1 ^ this.v2 ^ this.v3);
    }
    
    protected void process(ByteBuffer param1ByteBuffer) {
      this.b += 8L;
      processM(param1ByteBuffer.getLong());
    }
    
    protected void processRemaining(ByteBuffer param1ByteBuffer) {
      this.b += param1ByteBuffer.remaining();
      for (boolean bool = false; param1ByteBuffer.hasRemaining(); bool += true)
        this.finalM ^= (param1ByteBuffer.get() & 0xFFL) << bool; 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\SipHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */