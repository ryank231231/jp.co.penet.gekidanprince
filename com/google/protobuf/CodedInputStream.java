package com.google.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public final class CodedInputStream {
  private static final int BUFFER_SIZE = 4096;
  
  private static final int DEFAULT_RECURSION_LIMIT = 100;
  
  private static final int DEFAULT_SIZE_LIMIT = 67108864;
  
  private final byte[] buffer;
  
  private final boolean bufferIsImmutable;
  
  private int bufferPos;
  
  private int bufferSize;
  
  private int bufferSizeAfterLimit;
  
  private int currentLimit = Integer.MAX_VALUE;
  
  private boolean enableAliasing = false;
  
  private final InputStream input;
  
  private int lastTag;
  
  private int recursionDepth;
  
  private int recursionLimit = 100;
  
  private RefillCallback refillCallback = null;
  
  private int sizeLimit = 67108864;
  
  private int totalBytesRetired;
  
  private CodedInputStream(InputStream paramInputStream, int paramInt) {
    this.buffer = new byte[paramInt];
    this.bufferPos = 0;
    this.totalBytesRetired = 0;
    this.input = paramInputStream;
    this.bufferIsImmutable = false;
  }
  
  private CodedInputStream(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    this.buffer = paramArrayOfbyte;
    this.bufferSize = paramInt2 + paramInt1;
    this.bufferPos = paramInt1;
    this.totalBytesRetired = -paramInt1;
    this.input = null;
    this.bufferIsImmutable = paramBoolean;
  }
  
  public static int decodeZigZag32(int paramInt) {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public static long decodeZigZag64(long paramLong) {
    return -(paramLong & 0x1L) ^ paramLong >>> 1L;
  }
  
  public static CodedInputStream newInstance(InputStream paramInputStream) {
    return new CodedInputStream(paramInputStream, 4096);
  }
  
  static CodedInputStream newInstance(InputStream paramInputStream, int paramInt) {
    return new CodedInputStream(paramInputStream, paramInt);
  }
  
  public static CodedInputStream newInstance(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.hasArray())
      return newInstance(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()); 
    ByteBuffer byteBuffer = paramByteBuffer.duplicate();
    byte[] arrayOfByte = new byte[byteBuffer.remaining()];
    byteBuffer.get(arrayOfByte);
    return newInstance(arrayOfByte);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfbyte) {
    return newInstance(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return newInstance(paramArrayOfbyte, paramInt1, paramInt2, false);
  }
  
  static CodedInputStream newInstance(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    CodedInputStream codedInputStream = new CodedInputStream(paramArrayOfbyte, paramInt1, paramInt2, paramBoolean);
    try {
      codedInputStream.pushLimit(paramInt2);
      return codedInputStream;
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw new IllegalArgumentException(invalidProtocolBufferException);
    } 
  }
  
  private byte[] readRawBytesSlowPath(int paramInt) throws IOException {
    if (paramInt <= 0) {
      if (paramInt == 0)
        return Internal.EMPTY_BYTE_ARRAY; 
      throw InvalidProtocolBufferException.negativeSize();
    } 
    int i = this.totalBytesRetired;
    int j = this.bufferPos;
    int k = i + j + paramInt;
    if (k <= this.sizeLimit) {
      int m = this.currentLimit;
      if (k <= m) {
        InputStream inputStream = this.input;
        if (inputStream != null) {
          k = this.bufferSize;
          m = k - j;
          this.totalBytesRetired = i + k;
          this.bufferPos = 0;
          this.bufferSize = 0;
          i = paramInt - m;
          if (i < 4096 || i <= inputStream.available()) {
            byte[] arrayOfByte1 = new byte[paramInt];
            System.arraycopy(this.buffer, j, arrayOfByte1, 0, m);
            while (m < arrayOfByte1.length) {
              i = this.input.read(arrayOfByte1, m, paramInt - m);
              if (i != -1) {
                this.totalBytesRetired += i;
                m += i;
                continue;
              } 
              throw InvalidProtocolBufferException.truncatedMessage();
            } 
            return arrayOfByte1;
          } 
          ArrayList<byte[]> arrayList = new ArrayList();
          while (i > 0) {
            byte[] arrayOfByte1 = new byte[Math.min(i, 4096)];
            k = 0;
            while (k < arrayOfByte1.length) {
              int n = this.input.read(arrayOfByte1, k, arrayOfByte1.length - k);
              if (n != -1) {
                this.totalBytesRetired += n;
                k += n;
                continue;
              } 
              throw InvalidProtocolBufferException.truncatedMessage();
            } 
            i -= arrayOfByte1.length;
            arrayList.add(arrayOfByte1);
          } 
          byte[] arrayOfByte = new byte[paramInt];
          System.arraycopy(this.buffer, j, arrayOfByte, 0, m);
          for (byte[] arrayOfByte1 : arrayList) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte, m, arrayOfByte1.length);
            m += arrayOfByte1.length;
          } 
          return arrayOfByte;
        } 
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      skipRawBytes(m - i - j);
      throw InvalidProtocolBufferException.truncatedMessage();
    } 
    throw InvalidProtocolBufferException.sizeLimitExceeded();
  }
  
  public static int readRawVarint32(int paramInt, InputStream paramInputStream) throws IOException {
    int j;
    if ((paramInt & 0x80) == 0)
      return paramInt; 
    int i = paramInt & 0x7F;
    paramInt = 7;
    while (true) {
      j = paramInt;
      if (paramInt < 32) {
        j = paramInputStream.read();
        if (j != -1) {
          i |= (j & 0x7F) << paramInt;
          if ((j & 0x80) == 0)
            return i; 
          paramInt += 7;
          continue;
        } 
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      break;
    } 
    while (j < 64) {
      paramInt = paramInputStream.read();
      if (paramInt != -1) {
        if ((paramInt & 0x80) == 0)
          return i; 
        j += 7;
        continue;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    } 
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  static int readRawVarint32(InputStream paramInputStream) throws IOException {
    int i = paramInputStream.read();
    if (i != -1)
      return readRawVarint32(i, paramInputStream); 
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private void recomputeBufferSizeAfterLimit() {
    this.bufferSize += this.bufferSizeAfterLimit;
    int i = this.totalBytesRetired;
    int j = this.bufferSize;
    i += j;
    int k = this.currentLimit;
    if (i > k) {
      this.bufferSizeAfterLimit = i - k;
      this.bufferSize = j - this.bufferSizeAfterLimit;
    } else {
      this.bufferSizeAfterLimit = 0;
    } 
  }
  
  private void refillBuffer(int paramInt) throws IOException {
    if (tryRefillBuffer(paramInt))
      return; 
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private void skipRawBytesSlowPath(int paramInt) throws IOException {
    if (paramInt >= 0) {
      int i = this.totalBytesRetired;
      int j = this.bufferPos;
      int k = this.currentLimit;
      if (i + j + paramInt <= k) {
        i = this.bufferSize;
        j = i - j;
        this.bufferPos = i;
        refillBuffer(1);
        while (true) {
          k = paramInt - j;
          i = this.bufferSize;
          if (k > i) {
            j += i;
            this.bufferPos = i;
            refillBuffer(1);
            continue;
          } 
          this.bufferPos = k;
          return;
        } 
      } 
      skipRawBytes(k - i - j);
      throw InvalidProtocolBufferException.truncatedMessage();
    } 
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  private void skipRawVarint() throws IOException {
    int i = this.bufferSize;
    int j = this.bufferPos;
    if (i - j >= 10) {
      byte[] arrayOfByte = this.buffer;
      i = 0;
      while (i < 10) {
        int k = j + 1;
        if (arrayOfByte[j] >= 0) {
          this.bufferPos = k;
          return;
        } 
        i++;
        j = k;
      } 
    } 
    skipRawVarintSlowPath();
  }
  
  private void skipRawVarintSlowPath() throws IOException {
    for (byte b = 0; b < 10; b++) {
      if (readRawByte() >= 0)
        return; 
    } 
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  private boolean tryRefillBuffer(int paramInt) throws IOException {
    int i = this.bufferPos;
    if (i + paramInt > this.bufferSize) {
      if (this.totalBytesRetired + i + paramInt > this.currentLimit)
        return false; 
      RefillCallback refillCallback = this.refillCallback;
      if (refillCallback != null)
        refillCallback.onRefill(); 
      if (this.input != null) {
        int j = this.bufferPos;
        if (j > 0) {
          i = this.bufferSize;
          if (i > j) {
            byte[] arrayOfByte1 = this.buffer;
            System.arraycopy(arrayOfByte1, j, arrayOfByte1, 0, i - j);
          } 
          this.totalBytesRetired += j;
          this.bufferSize -= j;
          this.bufferPos = 0;
        } 
        InputStream inputStream = this.input;
        byte[] arrayOfByte = this.buffer;
        i = this.bufferSize;
        i = inputStream.read(arrayOfByte, i, arrayOfByte.length - i);
        if (i != 0 && i >= -1 && i <= this.buffer.length) {
          if (i > 0) {
            this.bufferSize += i;
            if (this.totalBytesRetired + paramInt - this.sizeLimit <= 0) {
              boolean bool;
              recomputeBufferSizeAfterLimit();
              if (this.bufferSize >= paramInt) {
                bool = true;
              } else {
                bool = tryRefillBuffer(paramInt);
              } 
              return bool;
            } 
            throw InvalidProtocolBufferException.sizeLimitExceeded();
          } 
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("InputStream#read(byte[]) returned invalid result: ");
          stringBuilder1.append(i);
          stringBuilder1.append("\nThe InputStream implementation is buggy.");
          throw new IllegalStateException(stringBuilder1.toString());
        } 
      } 
      return false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("refillBuffer() called when ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" bytes were already available in buffer");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void checkLastTagWas(int paramInt) throws InvalidProtocolBufferException {
    if (this.lastTag == paramInt)
      return; 
    throw InvalidProtocolBufferException.invalidEndTag();
  }
  
  public void enableAliasing(boolean paramBoolean) {
    this.enableAliasing = paramBoolean;
  }
  
  public int getBytesUntilLimit() {
    int i = this.currentLimit;
    return (i == Integer.MAX_VALUE) ? -1 : (i - this.totalBytesRetired + this.bufferPos);
  }
  
  public int getLastTag() {
    return this.lastTag;
  }
  
  public int getTotalBytesRead() {
    return this.totalBytesRetired + this.bufferPos;
  }
  
  public boolean isAtEnd() throws IOException {
    int i = this.bufferPos;
    int j = this.bufferSize;
    boolean bool = true;
    if (i != j || tryRefillBuffer(1))
      bool = false; 
    return bool;
  }
  
  public void popLimit(int paramInt) {
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }
  
  public int pushLimit(int paramInt) throws InvalidProtocolBufferException {
    if (paramInt >= 0) {
      paramInt += this.totalBytesRetired + this.bufferPos;
      int i = this.currentLimit;
      if (paramInt <= i) {
        this.currentLimit = paramInt;
        recomputeBufferSizeAfterLimit();
        return i;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    } 
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  public boolean readBool() throws IOException {
    boolean bool;
    if (readRawVarint64() != 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public byte[] readByteArray() throws IOException {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if (i <= j - k && i > 0) {
      byte[] arrayOfByte = Arrays.copyOfRange(this.buffer, k, k + i);
      this.bufferPos += i;
      return arrayOfByte;
    } 
    return readRawBytesSlowPath(i);
  }
  
  public ByteBuffer readByteBuffer() throws IOException {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if (i <= j - k && i > 0) {
      ByteBuffer byteBuffer;
      if (this.input == null && !this.bufferIsImmutable && this.enableAliasing) {
        byteBuffer = ByteBuffer.wrap(this.buffer, k, i).slice();
      } else {
        byte[] arrayOfByte = this.buffer;
        j = this.bufferPos;
        byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(arrayOfByte, j, j + i));
      } 
      this.bufferPos += i;
      return byteBuffer;
    } 
    return (i == 0) ? Internal.EMPTY_BYTE_BUFFER : ByteBuffer.wrap(readRawBytesSlowPath(i));
  }
  
  public ByteString readBytes() throws IOException {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if (i <= j - k && i > 0) {
      ByteString byteString;
      if (this.bufferIsImmutable && this.enableAliasing) {
        byteString = ByteString.wrap(this.buffer, k, i);
      } else {
        byteString = ByteString.copyFrom(this.buffer, this.bufferPos, i);
      } 
      this.bufferPos += i;
      return byteString;
    } 
    return (i == 0) ? ByteString.EMPTY : ByteString.wrap(readRawBytesSlowPath(i));
  }
  
  public double readDouble() throws IOException {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public int readEnum() throws IOException {
    return readRawVarint32();
  }
  
  public int readFixed32() throws IOException {
    return readRawLittleEndian32();
  }
  
  public long readFixed64() throws IOException {
    return readRawLittleEndian64();
  }
  
  public float readFloat() throws IOException {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public <T extends MessageLite> T readGroup(int paramInt, Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    int i = this.recursionDepth;
    if (i < this.recursionLimit) {
      this.recursionDepth = i + 1;
      MessageLite messageLite = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(WireFormat.makeTag(paramInt, 4));
      this.recursionDepth--;
      return (T)messageLite;
    } 
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public void readGroup(int paramInt, MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    int i = this.recursionDepth;
    if (i < this.recursionLimit) {
      this.recursionDepth = i + 1;
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(WireFormat.makeTag(paramInt, 4));
      this.recursionDepth--;
      return;
    } 
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public int readInt32() throws IOException {
    return readRawVarint32();
  }
  
  public long readInt64() throws IOException {
    return readRawVarint64();
  }
  
  public <T extends MessageLite> T readMessage(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    int i = readRawVarint32();
    if (this.recursionDepth < this.recursionLimit) {
      i = pushLimit(i);
      this.recursionDepth++;
      MessageLite messageLite = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(0);
      this.recursionDepth--;
      popLimit(i);
      return (T)messageLite;
    } 
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public void readMessage(MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    int i = readRawVarint32();
    if (this.recursionDepth < this.recursionLimit) {
      i = pushLimit(i);
      this.recursionDepth++;
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(0);
      this.recursionDepth--;
      popLimit(i);
      return;
    } 
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public byte readRawByte() throws IOException {
    if (this.bufferPos == this.bufferSize)
      refillBuffer(1); 
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = i + 1;
    return arrayOfByte[i];
  }
  
  public byte[] readRawBytes(int paramInt) throws IOException {
    int i = this.bufferPos;
    if (paramInt <= this.bufferSize - i && paramInt > 0) {
      paramInt += i;
      this.bufferPos = paramInt;
      return Arrays.copyOfRange(this.buffer, i, paramInt);
    } 
    return readRawBytesSlowPath(paramInt);
  }
  
  public int readRawLittleEndian32() throws IOException {
    int i = this.bufferPos;
    int j = i;
    if (this.bufferSize - i < 4) {
      refillBuffer(4);
      j = this.bufferPos;
    } 
    byte[] arrayOfByte = this.buffer;
    this.bufferPos = j + 4;
    byte b1 = arrayOfByte[j];
    byte b2 = arrayOfByte[j + 1];
    i = arrayOfByte[j + 2];
    return (arrayOfByte[j + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (i & 0xFF) << 16;
  }
  
  public long readRawLittleEndian64() throws IOException {
    int i = this.bufferPos;
    int j = i;
    if (this.bufferSize - i < 8) {
      refillBuffer(8);
      j = this.bufferPos;
    } 
    byte[] arrayOfByte = this.buffer;
    this.bufferPos = j + 8;
    long l1 = arrayOfByte[j];
    long l2 = arrayOfByte[j + 1];
    long l3 = arrayOfByte[j + 2];
    long l4 = arrayOfByte[j + 3];
    long l5 = arrayOfByte[j + 4];
    long l6 = arrayOfByte[j + 5];
    long l7 = arrayOfByte[j + 6];
    return (arrayOfByte[j + 7] & 0xFFL) << 56L | l1 & 0xFFL | (l2 & 0xFFL) << 8L | (l3 & 0xFFL) << 16L | (l4 & 0xFFL) << 24L | (l5 & 0xFFL) << 32L | (l6 & 0xFFL) << 40L | (l7 & 0xFFL) << 48L;
  }
  
  public int readRawVarint32() throws IOException {
    int i = this.bufferPos;
    int j = this.bufferSize;
    if (j == i)
      return (int)readRawVarint64SlowPath(); 
    byte[] arrayOfByte = this.buffer;
    int k = i + 1;
    i = arrayOfByte[i];
    if (i >= 0) {
      this.bufferPos = k;
      return i;
    } 
    if (j - k < 9)
      return (int)readRawVarint64SlowPath(); 
    j = k + 1;
    i ^= arrayOfByte[k] << 7;
    if (i < 0) {
      k = i ^ 0xFFFFFF80;
    } else {
      k = j + 1;
      i ^= arrayOfByte[j] << 14;
      if (i >= 0) {
        i ^= 0x3F80;
        j = k;
        k = i;
      } else {
        j = k + 1;
        i ^= arrayOfByte[k] << 21;
        if (i < 0) {
          k = i ^ 0xFFE03F80;
        } else {
          int m = j + 1;
          k = arrayOfByte[j];
          i = i ^ k << 28 ^ 0xFE03F80;
          j = m;
          if (k < 0) {
            int n = m + 1;
            k = i;
            j = n;
            if (arrayOfByte[m] < 0) {
              m = n + 1;
              j = m;
              if (arrayOfByte[n] < 0) {
                n = m + 1;
                k = i;
                j = n;
                if (arrayOfByte[m] < 0) {
                  m = n + 1;
                  j = m;
                  if (arrayOfByte[n] < 0) {
                    j = m + 1;
                    k = i;
                    if (arrayOfByte[m] < 0)
                      return (int)readRawVarint64SlowPath(); 
                    this.bufferPos = j;
                    return k;
                  } 
                } else {
                  this.bufferPos = j;
                  return k;
                } 
              } 
            } else {
              this.bufferPos = j;
              return k;
            } 
          } 
          k = i;
        } 
      } 
    } 
    this.bufferPos = j;
    return k;
  }
  
  public long readRawVarint64() throws IOException {
    int i = this.bufferPos;
    int j = this.bufferSize;
    if (j != i) {
      byte[] arrayOfByte = this.buffer;
      int k = i + 1;
      i = arrayOfByte[i];
      if (i >= 0) {
        this.bufferPos = k;
        return i;
      } 
      if (j - k >= 9) {
        long l;
        j = k + 1;
        i ^= arrayOfByte[k] << 7;
        if (i < 0) {
          l = (i ^ 0xFFFFFF80);
        } else {
          k = j + 1;
          i ^= arrayOfByte[j] << 14;
          if (i >= 0) {
            l = (i ^ 0x3F80);
            j = k;
          } else {
            j = k + 1;
            k = i ^ arrayOfByte[k] << 21;
            if (k < 0) {
              l = (k ^ 0xFFE03F80);
            } else {
              l = k;
              k = j + 1;
              l ^= arrayOfByte[j] << 28L;
              if (l >= 0L) {
                l = 0xFE03F80L ^ l;
                j = k;
              } else {
                i = k + 1;
                l ^= arrayOfByte[k] << 35L;
                if (l < 0L) {
                  l ^= 0xFFFFFFF80FE03F80L;
                  j = i;
                } else {
                  j = i + 1;
                  l ^= arrayOfByte[i] << 42L;
                  if (l >= 0L) {
                    l = 0x3F80FE03F80L ^ l;
                  } else {
                    i = j + 1;
                    l ^= arrayOfByte[j] << 49L;
                    if (l < 0L) {
                      l ^= 0xFFFE03F80FE03F80L;
                      j = i;
                    } else {
                      k = i + 1;
                      l = l ^ arrayOfByte[i] << 56L ^ 0xFE03F80FE03F80L;
                      if (l < 0L) {
                        j = k + 1;
                        if (arrayOfByte[k] < 0L)
                          return readRawVarint64SlowPath(); 
                      } else {
                        j = k;
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
        this.bufferPos = j;
        return l;
      } 
    } 
    return readRawVarint64SlowPath();
  }
  
  long readRawVarint64SlowPath() throws IOException {
    long l = 0L;
    for (byte b = 0; b < 64; b += 7) {
      byte b1 = readRawByte();
      l |= (b1 & Byte.MAX_VALUE) << b;
      if ((b1 & 0x80) == 0)
        return l; 
    } 
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public int readSFixed32() throws IOException {
    return readRawLittleEndian32();
  }
  
  public long readSFixed64() throws IOException {
    return readRawLittleEndian64();
  }
  
  public int readSInt32() throws IOException {
    return decodeZigZag32(readRawVarint32());
  }
  
  public long readSInt64() throws IOException {
    return decodeZigZag64(readRawVarint64());
  }
  
  public String readString() throws IOException {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if (i <= j - k && i > 0) {
      String str = new String(this.buffer, k, i, Internal.UTF_8);
      this.bufferPos += i;
      return str;
    } 
    if (i == 0)
      return ""; 
    if (i <= this.bufferSize) {
      refillBuffer(i);
      String str = new String(this.buffer, this.bufferPos, i, Internal.UTF_8);
      this.bufferPos += i;
      return str;
    } 
    return new String(readRawBytesSlowPath(i), Internal.UTF_8);
  }
  
  public String readStringRequireUtf8() throws IOException {
    byte[] arrayOfByte;
    int i = readRawVarint32();
    int j = this.bufferPos;
    int k = this.bufferSize;
    boolean bool = false;
    if (i <= k - j && i > 0) {
      arrayOfByte = this.buffer;
      this.bufferPos = j + i;
    } else {
      if (i == 0)
        return ""; 
      if (i <= this.bufferSize) {
        refillBuffer(i);
        arrayOfByte = this.buffer;
        this.bufferPos = i + 0;
        j = bool;
      } else {
        arrayOfByte = readRawBytesSlowPath(i);
        j = bool;
      } 
    } 
    if (Utf8.isValidUtf8(arrayOfByte, j, j + i))
      return new String(arrayOfByte, j, i, Internal.UTF_8); 
    throw InvalidProtocolBufferException.invalidUtf8();
  }
  
  public int readTag() throws IOException {
    if (isAtEnd()) {
      this.lastTag = 0;
      return 0;
    } 
    this.lastTag = readRawVarint32();
    if (WireFormat.getTagFieldNumber(this.lastTag) != 0)
      return this.lastTag; 
    throw InvalidProtocolBufferException.invalidTag();
  }
  
  public int readUInt32() throws IOException {
    return readRawVarint32();
  }
  
  public long readUInt64() throws IOException {
    return readRawVarint64();
  }
  
  @Deprecated
  public void readUnknownGroup(int paramInt, MessageLite.Builder paramBuilder) throws IOException {
    readGroup(paramInt, paramBuilder, (ExtensionRegistryLite)null);
  }
  
  public void resetSizeCounter() {
    this.totalBytesRetired = -this.bufferPos;
  }
  
  public int setRecursionLimit(int paramInt) {
    if (paramInt >= 0) {
      int i = this.recursionLimit;
      this.recursionLimit = paramInt;
      return i;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Recursion limit cannot be negative: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public int setSizeLimit(int paramInt) {
    if (paramInt >= 0) {
      int i = this.sizeLimit;
      this.sizeLimit = paramInt;
      return i;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Size limit cannot be negative: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean skipField(int paramInt) throws IOException {
    switch (WireFormat.getTagWireType(paramInt)) {
      default:
        throw InvalidProtocolBufferException.invalidWireType();
      case 5:
        skipRawBytes(4);
        return true;
      case 4:
        return false;
      case 3:
        skipMessage();
        checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4));
        return true;
      case 2:
        skipRawBytes(readRawVarint32());
        return true;
      case 1:
        skipRawBytes(8);
        return true;
      case 0:
        break;
    } 
    skipRawVarint();
    return true;
  }
  
  public boolean skipField(int paramInt, CodedOutputStream paramCodedOutputStream) throws IOException {
    int i;
    ByteString byteString;
    switch (WireFormat.getTagWireType(paramInt)) {
      default:
        throw InvalidProtocolBufferException.invalidWireType();
      case 5:
        i = readRawLittleEndian32();
        paramCodedOutputStream.writeRawVarint32(paramInt);
        paramCodedOutputStream.writeFixed32NoTag(i);
        return true;
      case 4:
        return false;
      case 3:
        paramCodedOutputStream.writeRawVarint32(paramInt);
        skipMessage(paramCodedOutputStream);
        paramInt = WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4);
        checkLastTagWas(paramInt);
        paramCodedOutputStream.writeRawVarint32(paramInt);
        return true;
      case 2:
        byteString = readBytes();
        paramCodedOutputStream.writeRawVarint32(paramInt);
        paramCodedOutputStream.writeBytesNoTag(byteString);
        return true;
      case 1:
        l = readRawLittleEndian64();
        paramCodedOutputStream.writeRawVarint32(paramInt);
        paramCodedOutputStream.writeFixed64NoTag(l);
        return true;
      case 0:
        break;
    } 
    long l = readInt64();
    paramCodedOutputStream.writeRawVarint32(paramInt);
    paramCodedOutputStream.writeUInt64NoTag(l);
    return true;
  }
  
  public void skipMessage() throws IOException {
    int i;
    do {
      i = readTag();
    } while (i != 0 && skipField(i));
  }
  
  public void skipMessage(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i;
    do {
      i = readTag();
    } while (i != 0 && skipField(i, paramCodedOutputStream));
  }
  
  public void skipRawBytes(int paramInt) throws IOException {
    int i = this.bufferSize;
    int j = this.bufferPos;
    if (paramInt <= i - j && paramInt >= 0) {
      this.bufferPos = j + paramInt;
    } else {
      skipRawBytesSlowPath(paramInt);
    } 
  }
  
  private static interface RefillCallback {
    void onRefill();
  }
  
  private class SkippedDataSink implements RefillCallback {
    private ByteArrayOutputStream byteArrayStream;
    
    private int lastPos = CodedInputStream.this.bufferPos;
    
    ByteBuffer getSkippedData() {
      ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
      if (byteArrayOutputStream == null)
        return ByteBuffer.wrap(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos); 
      byteArrayOutputStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos);
      return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
    }
    
    public void onRefill() {
      if (this.byteArrayStream == null)
        this.byteArrayStream = new ByteArrayOutputStream(); 
      this.byteArrayStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
      this.lastPos = 0;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\CodedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */