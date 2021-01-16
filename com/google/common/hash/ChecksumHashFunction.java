package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.zip.Checksum;

final class ChecksumHashFunction extends AbstractStreamingHashFunction implements Serializable {
  private static final long serialVersionUID = 0L;
  
  private final int bits;
  
  private final Supplier<? extends Checksum> checksumSupplier;
  
  private final String toString;
  
  ChecksumHashFunction(Supplier<? extends Checksum> paramSupplier, int paramInt, String paramString) {
    boolean bool;
    this.checksumSupplier = (Supplier<? extends Checksum>)Preconditions.checkNotNull(paramSupplier);
    if (paramInt == 32 || paramInt == 64) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "bits (%s) must be either 32 or 64", paramInt);
    this.bits = paramInt;
    this.toString = (String)Preconditions.checkNotNull(paramString);
  }
  
  public int bits() {
    return this.bits;
  }
  
  public Hasher newHasher() {
    return new ChecksumHasher((Checksum)this.checksumSupplier.get());
  }
  
  public String toString() {
    return this.toString;
  }
  
  private final class ChecksumHasher extends AbstractByteHasher {
    private final Checksum checksum;
    
    private ChecksumHasher(Checksum param1Checksum) {
      this.checksum = (Checksum)Preconditions.checkNotNull(param1Checksum);
    }
    
    public HashCode hash() {
      long l = this.checksum.getValue();
      return (ChecksumHashFunction.this.bits == 32) ? HashCode.fromInt((int)l) : HashCode.fromLong(l);
    }
    
    protected void update(byte param1Byte) {
      this.checksum.update(param1Byte);
    }
    
    protected void update(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.checksum.update(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\ChecksumHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */