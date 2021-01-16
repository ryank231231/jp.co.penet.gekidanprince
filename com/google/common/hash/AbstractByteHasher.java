package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@CanIgnoreReturnValue
abstract class AbstractByteHasher extends AbstractHasher {
  private final ByteBuffer scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
  
  private Hasher update(int paramInt) {
    try {
      update(this.scratch.array(), 0, paramInt);
      return this;
    } finally {
      this.scratch.clear();
    } 
  }
  
  public Hasher putByte(byte paramByte) {
    update(paramByte);
    return this;
  }
  
  public Hasher putBytes(byte[] paramArrayOfbyte) {
    Preconditions.checkNotNull(paramArrayOfbyte);
    update(paramArrayOfbyte);
    return this;
  }
  
  public Hasher putBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    update(paramArrayOfbyte, paramInt1, paramInt2);
    return this;
  }
  
  public Hasher putChar(char paramChar) {
    this.scratch.putChar(paramChar);
    return update(2);
  }
  
  public Hasher putInt(int paramInt) {
    this.scratch.putInt(paramInt);
    return update(4);
  }
  
  public Hasher putLong(long paramLong) {
    this.scratch.putLong(paramLong);
    return update(8);
  }
  
  public <T> Hasher putObject(T paramT, Funnel<? super T> paramFunnel) {
    paramFunnel.funnel(paramT, this);
    return this;
  }
  
  public Hasher putShort(short paramShort) {
    this.scratch.putShort(paramShort);
    return update(2);
  }
  
  protected abstract void update(byte paramByte);
  
  protected void update(byte[] paramArrayOfbyte) {
    update(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  protected void update(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++)
      update(paramArrayOfbyte[i]); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\AbstractByteHasher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */