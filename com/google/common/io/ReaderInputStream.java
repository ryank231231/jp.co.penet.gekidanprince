package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

@GwtIncompatible
final class ReaderInputStream extends InputStream {
  private ByteBuffer byteBuffer;
  
  private CharBuffer charBuffer;
  
  private boolean doneFlushing;
  
  private boolean draining;
  
  private final CharsetEncoder encoder;
  
  private boolean endOfInput;
  
  private final Reader reader;
  
  private final byte[] singleByte;
  
  ReaderInputStream(Reader paramReader, Charset paramCharset, int paramInt) {
    this(paramReader, paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), paramInt);
  }
  
  ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder, int paramInt) {
    boolean bool = true;
    this.singleByte = new byte[1];
    this.reader = (Reader)Preconditions.checkNotNull(paramReader);
    this.encoder = (CharsetEncoder)Preconditions.checkNotNull(paramCharsetEncoder);
    if (paramInt <= 0)
      bool = false; 
    Preconditions.checkArgument(bool, "bufferSize must be positive: %s", paramInt);
    paramCharsetEncoder.reset();
    this.charBuffer = CharBuffer.allocate(paramInt);
    this.charBuffer.flip();
    this.byteBuffer = ByteBuffer.allocate(paramInt);
  }
  
  private static int availableCapacity(Buffer paramBuffer) {
    return paramBuffer.capacity() - paramBuffer.limit();
  }
  
  private int drain(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramInt2 = Math.min(paramInt2, this.byteBuffer.remaining());
    this.byteBuffer.get(paramArrayOfbyte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  private static CharBuffer grow(CharBuffer paramCharBuffer) {
    CharBuffer charBuffer = CharBuffer.wrap(Arrays.copyOf(paramCharBuffer.array(), paramCharBuffer.capacity() * 2));
    charBuffer.position(paramCharBuffer.position());
    charBuffer.limit(paramCharBuffer.limit());
    return charBuffer;
  }
  
  private void readMoreChars() throws IOException {
    if (availableCapacity(this.charBuffer) == 0)
      if (this.charBuffer.position() > 0) {
        this.charBuffer.compact().flip();
      } else {
        this.charBuffer = grow(this.charBuffer);
      }  
    int i = this.charBuffer.limit();
    int j = this.reader.read(this.charBuffer.array(), i, availableCapacity(this.charBuffer));
    if (j == -1) {
      this.endOfInput = true;
    } else {
      this.charBuffer.limit(i + j);
    } 
  }
  
  private void startDraining(boolean paramBoolean) {
    this.byteBuffer.flip();
    if (paramBoolean && this.byteBuffer.remaining() == 0) {
      this.byteBuffer = ByteBuffer.allocate(this.byteBuffer.capacity() * 2);
    } else {
      this.draining = true;
    } 
  }
  
  public void close() throws IOException {
    this.reader.close();
  }
  
  public int read() throws IOException {
    byte b;
    if (read(this.singleByte) == 1) {
      b = UnsignedBytes.toInt(this.singleByte[0]);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    if (paramInt2 == 0)
      return 0; 
    boolean bool = this.endOfInput;
    int i = 0;
    label41: while (true) {
      int j = i;
      boolean bool1 = bool;
      if (this.draining) {
        j = i + drain(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
        if (j == paramInt2 || this.doneFlushing) {
          if (j <= 0)
            j = -1; 
          return j;
        } 
        this.draining = false;
        this.byteBuffer.clear();
        bool1 = bool;
      } 
      while (true) {
        CoderResult coderResult;
        if (this.doneFlushing) {
          coderResult = CoderResult.UNDERFLOW;
        } else if (bool1) {
          coderResult = this.encoder.flush(this.byteBuffer);
        } else {
          coderResult = this.encoder.encode(this.charBuffer, this.byteBuffer, this.endOfInput);
        } 
        if (coderResult.isOverflow()) {
          startDraining(true);
          i = j;
          bool = bool1;
          continue label41;
        } 
        if (coderResult.isUnderflow()) {
          if (bool1) {
            this.doneFlushing = true;
            startDraining(false);
            i = j;
            bool = bool1;
            continue label41;
          } 
          if (this.endOfInput) {
            bool1 = true;
            continue;
          } 
          readMoreChars();
          continue;
        } 
        if (coderResult.isError()) {
          coderResult.throwException();
          return 0;
        } 
      } 
      break;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\ReaderInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */