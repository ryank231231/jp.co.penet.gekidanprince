package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

abstract class AbstractStreamingHashFunction implements HashFunction {
  public HashCode hashBytes(byte[] paramArrayOfbyte) {
    return newHasher().putBytes(paramArrayOfbyte).hash();
  }
  
  public HashCode hashBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return newHasher().putBytes(paramArrayOfbyte, paramInt1, paramInt2).hash();
  }
  
  public HashCode hashInt(int paramInt) {
    return newHasher().putInt(paramInt).hash();
  }
  
  public HashCode hashLong(long paramLong) {
    return newHasher().putLong(paramLong).hash();
  }
  
  public <T> HashCode hashObject(T paramT, Funnel<? super T> paramFunnel) {
    return newHasher().<T>putObject(paramT, paramFunnel).hash();
  }
  
  public HashCode hashString(CharSequence paramCharSequence, Charset paramCharset) {
    return newHasher().putString(paramCharSequence, paramCharset).hash();
  }
  
  public HashCode hashUnencodedChars(CharSequence paramCharSequence) {
    return newHasher().putUnencodedChars(paramCharSequence).hash();
  }
  
  public Hasher newHasher(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return newHasher();
  }
  
  @CanIgnoreReturnValue
  protected static abstract class AbstractStreamingHasher extends AbstractHasher {
    private final ByteBuffer buffer;
    
    private final int bufferSize;
    
    private final int chunkSize;
    
    protected AbstractStreamingHasher(int param1Int) {
      this(param1Int, param1Int);
    }
    
    protected AbstractStreamingHasher(int param1Int1, int param1Int2) {
      boolean bool;
      if (param1Int2 % param1Int1 == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      this.buffer = ByteBuffer.allocate(param1Int2 + 7).order(ByteOrder.LITTLE_ENDIAN);
      this.bufferSize = param1Int2;
      this.chunkSize = param1Int1;
    }
    
    private void munch() {
      this.buffer.flip();
      while (this.buffer.remaining() >= this.chunkSize)
        process(this.buffer); 
      this.buffer.compact();
    }
    
    private void munchIfFull() {
      if (this.buffer.remaining() < 8)
        munch(); 
    }
    
    private Hasher putBytes(ByteBuffer param1ByteBuffer) {
      if (param1ByteBuffer.remaining() <= this.buffer.remaining()) {
        this.buffer.put(param1ByteBuffer);
        munchIfFull();
        return this;
      } 
      int i = this.bufferSize;
      int j = this.buffer.position();
      for (byte b = 0; b < i - j; b++)
        this.buffer.put(param1ByteBuffer.get()); 
      munch();
      while (param1ByteBuffer.remaining() >= this.chunkSize)
        process(param1ByteBuffer); 
      this.buffer.put(param1ByteBuffer);
      return this;
    }
    
    public final HashCode hash() {
      munch();
      this.buffer.flip();
      if (this.buffer.remaining() > 0)
        processRemaining(this.buffer); 
      return makeHash();
    }
    
    abstract HashCode makeHash();
    
    protected abstract void process(ByteBuffer param1ByteBuffer);
    
    protected void processRemaining(ByteBuffer param1ByteBuffer) {
      param1ByteBuffer.position(param1ByteBuffer.limit());
      param1ByteBuffer.limit(this.chunkSize + 7);
      while (true) {
        int i = param1ByteBuffer.position();
        int j = this.chunkSize;
        if (i < j) {
          param1ByteBuffer.putLong(0L);
          continue;
        } 
        param1ByteBuffer.limit(j);
        param1ByteBuffer.flip();
        process(param1ByteBuffer);
        return;
      } 
    }
    
    public final Hasher putByte(byte param1Byte) {
      this.buffer.put(param1Byte);
      munchIfFull();
      return this;
    }
    
    public final Hasher putBytes(byte[] param1ArrayOfbyte) {
      return putBytes(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    public final Hasher putBytes(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      return putBytes(ByteBuffer.wrap(param1ArrayOfbyte, param1Int1, param1Int2).order(ByteOrder.LITTLE_ENDIAN));
    }
    
    public final Hasher putChar(char param1Char) {
      this.buffer.putChar(param1Char);
      munchIfFull();
      return this;
    }
    
    public final Hasher putInt(int param1Int) {
      this.buffer.putInt(param1Int);
      munchIfFull();
      return this;
    }
    
    public final Hasher putLong(long param1Long) {
      this.buffer.putLong(param1Long);
      munchIfFull();
      return this;
    }
    
    public final <T> Hasher putObject(T param1T, Funnel<? super T> param1Funnel) {
      param1Funnel.funnel(param1T, this);
      return this;
    }
    
    public final Hasher putShort(short param1Short) {
      this.buffer.putShort(param1Short);
      munchIfFull();
      return this;
    }
    
    public final Hasher putUnencodedChars(CharSequence param1CharSequence) {
      for (byte b = 0; b < param1CharSequence.length(); b++)
        putChar(param1CharSequence.charAt(b)); 
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\AbstractStreamingHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */