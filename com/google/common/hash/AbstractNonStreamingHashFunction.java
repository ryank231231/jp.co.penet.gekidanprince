package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

abstract class AbstractNonStreamingHashFunction implements HashFunction {
  public HashCode hashBytes(byte[] paramArrayOfbyte) {
    return hashBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public HashCode hashInt(int paramInt) {
    return newHasher(4).putInt(paramInt).hash();
  }
  
  public HashCode hashLong(long paramLong) {
    return newHasher(8).putLong(paramLong).hash();
  }
  
  public <T> HashCode hashObject(T paramT, Funnel<? super T> paramFunnel) {
    return newHasher().<T>putObject(paramT, paramFunnel).hash();
  }
  
  public HashCode hashString(CharSequence paramCharSequence, Charset paramCharset) {
    return hashBytes(paramCharSequence.toString().getBytes(paramCharset));
  }
  
  public HashCode hashUnencodedChars(CharSequence paramCharSequence) {
    int i = paramCharSequence.length();
    Hasher hasher = newHasher(i * 2);
    for (byte b = 0; b < i; b++)
      hasher.putChar(paramCharSequence.charAt(b)); 
    return hasher.hash();
  }
  
  public Hasher newHasher() {
    return new BufferingHasher(32);
  }
  
  public Hasher newHasher(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return new BufferingHasher(paramInt);
  }
  
  private final class BufferingHasher extends AbstractHasher {
    static final int BOTTOM_BYTE = 255;
    
    final AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream stream;
    
    BufferingHasher(int param1Int) {
      this.stream = new AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream(param1Int);
    }
    
    public HashCode hash() {
      return AbstractNonStreamingHashFunction.this.hashBytes(this.stream.byteArray(), 0, this.stream.length());
    }
    
    public Hasher putByte(byte param1Byte) {
      this.stream.write(param1Byte);
      return this;
    }
    
    public Hasher putBytes(byte[] param1ArrayOfbyte) {
      try {
        this.stream.write(param1ArrayOfbyte);
        return this;
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    }
    
    public Hasher putBytes(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.stream.write(param1ArrayOfbyte, param1Int1, param1Int2);
      return this;
    }
    
    public Hasher putChar(char param1Char) {
      this.stream.write(param1Char & 0xFF);
      this.stream.write(param1Char >>> 8 & 0xFF);
      return this;
    }
    
    public Hasher putInt(int param1Int) {
      this.stream.write(param1Int & 0xFF);
      this.stream.write(param1Int >>> 8 & 0xFF);
      this.stream.write(param1Int >>> 16 & 0xFF);
      this.stream.write(param1Int >>> 24 & 0xFF);
      return this;
    }
    
    public Hasher putLong(long param1Long) {
      for (byte b = 0; b < 64; b += 8)
        this.stream.write((byte)(int)(param1Long >>> b & 0xFFL)); 
      return this;
    }
    
    public <T> Hasher putObject(T param1T, Funnel<? super T> param1Funnel) {
      param1Funnel.funnel(param1T, this);
      return this;
    }
    
    public Hasher putShort(short param1Short) {
      this.stream.write(param1Short & 0xFF);
      this.stream.write(param1Short >>> 8 & 0xFF);
      return this;
    }
  }
  
  private static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
    ExposedByteArrayOutputStream(int param1Int) {
      super(param1Int);
    }
    
    byte[] byteArray() {
      return this.buf;
    }
    
    int length() {
      return this.count;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\AbstractNonStreamingHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */