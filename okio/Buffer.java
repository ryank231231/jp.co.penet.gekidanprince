package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable {
  private static final byte[] DIGITS = new byte[] { 
      48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
      97, 98, 99, 100, 101, 102 };
  
  static final int REPLACEMENT_CHARACTER = 65533;
  
  @Nullable
  Segment head;
  
  long size;
  
  private ByteString digest(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(paramString);
      if (this.head != null) {
        messageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
        Segment segment = this.head;
        while (true) {
          segment = segment.next;
          if (segment != this.head) {
            messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
            continue;
          } 
          break;
        } 
      } 
      return ByteString.of(messageDigest.digest());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError();
    } 
  }
  
  private ByteString hmac(String paramString, ByteString paramByteString) {
    try {
      Mac mac = Mac.getInstance(paramString);
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramByteString.toByteArray(), paramString);
      mac.init(secretKeySpec);
      if (this.head != null) {
        mac.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
        Segment segment = this.head;
        while (true) {
          segment = segment.next;
          if (segment != this.head) {
            mac.update(segment.data, segment.pos, segment.limit - segment.pos);
            continue;
          } 
          break;
        } 
      } 
      return ByteString.of(mac.doFinal());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError();
    } catch (InvalidKeyException invalidKeyException) {
      throw new IllegalArgumentException(invalidKeyException);
    } 
  }
  
  private boolean rangeEquals(Segment paramSegment, int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3) {
    int i = paramSegment.limit;
    byte[] arrayOfByte = paramSegment.data;
    for (Segment segment = paramSegment; paramInt2 < paramInt3; segment = paramSegment) {
      int j = i;
      paramSegment = segment;
      int k = paramInt1;
      if (paramInt1 == i) {
        paramSegment = segment.next;
        byte[] arrayOfByte1 = paramSegment.data;
        k = paramSegment.pos;
        j = paramSegment.limit;
        arrayOfByte = arrayOfByte1;
      } 
      if (arrayOfByte[k] != paramByteString.getByte(paramInt2))
        return false; 
      paramInt1 = k + 1;
      paramInt2++;
      i = j;
    } 
    return true;
  }
  
  private void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean) throws IOException {
    if (paramInputStream != null)
      while (true) {
        if (paramLong > 0L || paramBoolean) {
          Segment segment = writableSegment(1);
          int i = (int)Math.min(paramLong, (8192 - segment.limit));
          i = paramInputStream.read(segment.data, segment.limit, i);
          if (i == -1) {
            if (paramBoolean)
              return; 
            throw new EOFException();
          } 
          segment.limit += i;
          long l1 = this.size;
          long l2 = i;
          this.size = l1 + l2;
          paramLong -= l2;
          continue;
        } 
        return;
      }  
    throw new IllegalArgumentException("in == null");
  }
  
  public Buffer buffer() {
    return this;
  }
  
  public void clear() {
    try {
      skip(this.size);
      return;
    } catch (EOFException eOFException) {
      throw new AssertionError(eOFException);
    } 
  }
  
  public Buffer clone() {
    Buffer buffer = new Buffer();
    if (this.size == 0L)
      return buffer; 
    buffer.head = new Segment(this.head);
    Segment segment = buffer.head;
    segment.prev = segment;
    segment.next = segment;
    segment = this.head;
    while (true) {
      segment = segment.next;
      if (segment != this.head) {
        buffer.head.prev.push(new Segment(segment));
        continue;
      } 
      buffer.size = this.size;
      return buffer;
    } 
  }
  
  public void close() {}
  
  public long completeSegmentByteCount() {
    long l1 = this.size;
    if (l1 == 0L)
      return 0L; 
    Segment segment = this.head.prev;
    long l2 = l1;
    if (segment.limit < 8192) {
      l2 = l1;
      if (segment.owner)
        l2 = l1 - (segment.limit - segment.pos); 
    } 
    return l2;
  }
  
  public Buffer copyTo(OutputStream paramOutputStream) throws IOException {
    return copyTo(paramOutputStream, 0L, this.size);
  }
  
  public Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2) throws IOException {
    if (paramOutputStream != null) {
      Segment segment2;
      long l1;
      long l2;
      Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
      if (paramLong2 == 0L)
        return this; 
      Segment segment1 = this.head;
      while (true) {
        segment2 = segment1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 >= (segment1.limit - segment1.pos)) {
          paramLong1 -= (segment1.limit - segment1.pos);
          segment1 = segment1.next;
          continue;
        } 
        break;
      } 
      while (l2 > 0L) {
        int i = (int)(segment2.pos + l1);
        int j = (int)Math.min((segment2.limit - i), l2);
        paramOutputStream.write(segment2.data, i, j);
        l2 -= j;
        segment2 = segment2.next;
        l1 = 0L;
      } 
      return this;
    } 
    throw new IllegalArgumentException("out == null");
  }
  
  public Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2) {
    if (paramBuffer != null) {
      Segment segment2;
      long l1;
      long l2;
      Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
      if (paramLong2 == 0L)
        return this; 
      paramBuffer.size += paramLong2;
      Segment segment1 = this.head;
      while (true) {
        segment2 = segment1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 >= (segment1.limit - segment1.pos)) {
          paramLong1 -= (segment1.limit - segment1.pos);
          segment1 = segment1.next;
          continue;
        } 
        break;
      } 
      while (l2 > 0L) {
        segment1 = new Segment(segment2);
        segment1.pos = (int)(segment1.pos + l1);
        segment1.limit = Math.min(segment1.pos + (int)l2, segment1.limit);
        Segment segment = paramBuffer.head;
        if (segment == null) {
          segment1.prev = segment1;
          segment1.next = segment1;
          paramBuffer.head = segment1;
        } else {
          segment.prev.push(segment1);
        } 
        l2 -= (segment1.limit - segment1.pos);
        segment2 = segment2.next;
        l1 = 0L;
      } 
      return this;
    } 
    throw new IllegalArgumentException("out == null");
  }
  
  public BufferedSink emit() {
    return this;
  }
  
  public Buffer emitCompleteSegments() {
    return this;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof Buffer))
      return false; 
    paramObject = paramObject;
    long l1 = this.size;
    if (l1 != ((Buffer)paramObject).size)
      return false; 
    long l2 = 0L;
    if (l1 == 0L)
      return true; 
    Segment segment = this.head;
    paramObject = ((Buffer)paramObject).head;
    int i = segment.pos;
    int j = ((Segment)paramObject).pos;
    while (l2 < this.size) {
      l1 = Math.min(segment.limit - i, ((Segment)paramObject).limit - j);
      byte b = 0;
      while (b < l1) {
        if (segment.data[i] != ((Segment)paramObject).data[j])
          return false; 
        b++;
        i++;
        j++;
      } 
      if (i == segment.limit) {
        segment = segment.next;
        i = segment.pos;
      } 
      if (j == ((Segment)paramObject).limit) {
        paramObject = ((Segment)paramObject).next;
        j = ((Segment)paramObject).pos;
      } 
      l2 += l1;
    } 
    return true;
  }
  
  public boolean exhausted() {
    boolean bool;
    if (this.size == 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void flush() {}
  
  public byte getByte(long paramLong) {
    Util.checkOffsetAndCount(this.size, paramLong, 1L);
    for (Segment segment = this.head;; segment = segment.next) {
      long l = (segment.limit - segment.pos);
      if (paramLong < l)
        return segment.data[segment.pos + (int)paramLong]; 
      paramLong -= l;
    } 
  }
  
  public int hashCode() {
    Segment segment = this.head;
    if (segment == null)
      return 0; 
    int i = 1;
    while (true) {
      int j = segment.pos;
      int k = segment.limit;
      int m = i;
      while (j < k) {
        m = m * 31 + segment.data[j];
        j++;
      } 
      Segment segment1 = segment.next;
      segment = segment1;
      i = m;
      if (segment1 == this.head)
        return m; 
    } 
  }
  
  public ByteString hmacSha1(ByteString paramByteString) {
    return hmac("HmacSHA1", paramByteString);
  }
  
  public ByteString hmacSha256(ByteString paramByteString) {
    return hmac("HmacSHA256", paramByteString);
  }
  
  public ByteString hmacSha512(ByteString paramByteString) {
    return hmac("HmacSHA512", paramByteString);
  }
  
  public long indexOf(byte paramByte) {
    return indexOf(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong) {
    return indexOf(paramByte, paramLong, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong1, long paramLong2) {
    if (paramLong1 >= 0L && paramLong2 >= paramLong1) {
      long l = this.size;
      if (paramLong2 <= l)
        l = paramLong2; 
      if (paramLong1 == l)
        return -1L; 
      Segment segment = this.head;
      if (segment == null)
        return -1L; 
      paramLong2 = this.size;
      if (paramLong2 - paramLong1 < paramLong1) {
        while (paramLong2 > paramLong1) {
          segment = segment.prev;
          paramLong2 -= (segment.limit - segment.pos);
        } 
      } else {
        paramLong2 = 0L;
        while (true) {
          long l1 = (segment.limit - segment.pos) + paramLong2;
          if (l1 < paramLong1) {
            segment = segment.next;
            paramLong2 = l1;
            continue;
          } 
          break;
        } 
      } 
      while (paramLong2 < l) {
        byte[] arrayOfByte = segment.data;
        int i = (int)Math.min(segment.limit, segment.pos + l - paramLong2);
        for (int j = (int)(segment.pos + paramLong1 - paramLong2); j < i; j++) {
          if (arrayOfByte[j] == paramByte)
            return (j - segment.pos) + paramLong2; 
        } 
        paramLong1 = (segment.limit - segment.pos) + paramLong2;
        segment = segment.next;
        paramLong2 = paramLong1;
      } 
      return -1L;
    } 
    throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.size), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public long indexOf(ByteString paramByteString) throws IOException {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong) throws IOException {
    if (paramByteString.size() != 0) {
      if (paramLong >= 0L) {
        Segment segment2;
        long l2;
        Segment segment1 = this.head;
        if (segment1 == null)
          return -1L; 
        long l1 = this.size;
        if (l1 - paramLong < paramLong) {
          while (true) {
            segment2 = segment1;
            l2 = l1;
            if (l1 > paramLong) {
              segment1 = segment1.prev;
              l1 -= (segment1.limit - segment1.pos);
              continue;
            } 
            break;
          } 
        } else {
          l2 = 0L;
          while (true) {
            l1 = (segment1.limit - segment1.pos) + l2;
            segment2 = segment1;
            if (l1 < paramLong) {
              segment1 = segment1.next;
              l2 = l1;
              continue;
            } 
            break;
          } 
        } 
        byte b = paramByteString.getByte(0);
        int i = paramByteString.size();
        l1 = 1L + this.size - i;
        while (l2 < l1) {
          byte[] arrayOfByte2 = segment2.data;
          int j = (int)Math.min(segment2.limit, segment2.pos + l1 - l2);
          int k = (int)(segment2.pos + paramLong - l2);
          segment1 = segment2;
          byte[] arrayOfByte1 = arrayOfByte2;
          while (k < j) {
            if (arrayOfByte1[k] == b && rangeEquals(segment1, k + 1, paramByteString, 1, i))
              return (k - segment1.pos) + l2; 
            k++;
          } 
          paramLong = (segment1.limit - segment1.pos) + l2;
          Segment segment = segment1.next;
          l2 = paramLong;
        } 
        return -1L;
      } 
      throw new IllegalArgumentException("fromIndex < 0");
    } 
    throw new IllegalArgumentException("bytes is empty");
  }
  
  public long indexOfElement(ByteString paramByteString) {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong) {
    if (paramLong >= 0L) {
      byte[] arrayOfByte;
      Segment segment2;
      long l2;
      Segment segment1 = this.head;
      if (segment1 == null)
        return -1L; 
      long l1 = this.size;
      if (l1 - paramLong < paramLong) {
        while (true) {
          segment2 = segment1;
          l2 = l1;
          if (l1 > paramLong) {
            segment1 = segment1.prev;
            l1 -= (segment1.limit - segment1.pos);
            continue;
          } 
          break;
        } 
      } else {
        l2 = 0L;
        while (true) {
          l1 = (segment1.limit - segment1.pos) + l2;
          segment2 = segment1;
          if (l1 < paramLong) {
            segment1 = segment1.next;
            l2 = l1;
            continue;
          } 
          break;
        } 
      } 
      if (paramByteString.size() == 2) {
        byte b1 = paramByteString.getByte(0);
        byte b2 = paramByteString.getByte(1);
        while (l2 < this.size) {
          arrayOfByte = segment2.data;
          int i = (int)(segment2.pos + paramLong - l2);
          int j = segment2.limit;
          while (i < j) {
            byte b = arrayOfByte[i];
            if (b == b1 || b == b2)
              return (i - segment2.pos) + l2; 
            i++;
          } 
          paramLong = (segment2.limit - segment2.pos) + l2;
          segment2 = segment2.next;
          l2 = paramLong;
        } 
      } else {
        arrayOfByte = arrayOfByte.internalArray();
        while (l2 < this.size) {
          byte[] arrayOfByte1 = segment2.data;
          int i = (int)(segment2.pos + paramLong - l2);
          int j = segment2.limit;
          while (i < j) {
            byte b1 = arrayOfByte1[i];
            int k = arrayOfByte.length;
            for (byte b = 0; b < k; b++) {
              if (b1 == arrayOfByte[b])
                return (i - segment2.pos) + l2; 
            } 
            i++;
          } 
          paramLong = (segment2.limit - segment2.pos) + l2;
          segment2 = segment2.next;
          l2 = paramLong;
        } 
      } 
      return -1L;
    } 
    throw new IllegalArgumentException("fromIndex < 0");
  }
  
  public InputStream inputStream() {
    return new InputStream() {
        public int available() {
          return (int)Math.min(Buffer.this.size, 2147483647L);
        }
        
        public void close() {}
        
        public int read() {
          return (Buffer.this.size > 0L) ? (Buffer.this.readByte() & 0xFF) : -1;
        }
        
        public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
          return Buffer.this.read(param1ArrayOfbyte, param1Int1, param1Int2);
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(Buffer.this);
          stringBuilder.append(".inputStream()");
          return stringBuilder.toString();
        }
      };
  }
  
  public ByteString md5() {
    return digest("MD5");
  }
  
  public OutputStream outputStream() {
    return new OutputStream() {
        public void close() {}
        
        public void flush() {}
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(Buffer.this);
          stringBuilder.append(".outputStream()");
          return stringBuilder.toString();
        }
        
        public void write(int param1Int) {
          Buffer.this.writeByte((byte)param1Int);
        }
        
        public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
          Buffer.this.write(param1ArrayOfbyte, param1Int1, param1Int2);
        }
      };
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString) {
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2) {
    if (paramLong < 0L || paramInt1 < 0 || paramInt2 < 0 || this.size - paramLong < paramInt2 || paramByteString.size() - paramInt1 < paramInt2)
      return false; 
    for (byte b = 0; b < paramInt2; b++) {
      if (getByte(b + paramLong) != paramByteString.getByte(paramInt1 + b))
        return false; 
    } 
    return true;
  }
  
  public int read(byte[] paramArrayOfbyte) {
    return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Util.checkOffsetAndCount(paramArrayOfbyte.length, paramInt1, paramInt2);
    Segment segment = this.head;
    if (segment == null)
      return -1; 
    paramInt2 = Math.min(paramInt2, segment.limit - segment.pos);
    System.arraycopy(segment.data, segment.pos, paramArrayOfbyte, paramInt1, paramInt2);
    segment.pos += paramInt2;
    this.size -= paramInt2;
    if (segment.pos == segment.limit) {
      this.head = segment.pop();
      SegmentPool.recycle(segment);
    } 
    return paramInt2;
  }
  
  public long read(Buffer paramBuffer, long paramLong) {
    if (paramBuffer != null) {
      if (paramLong >= 0L) {
        long l1 = this.size;
        if (l1 == 0L)
          return -1L; 
        long l2 = paramLong;
        if (paramLong > l1)
          l2 = l1; 
        paramBuffer.write(this, l2);
        return l2;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(paramLong);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("sink == null");
  }
  
  public long readAll(Sink paramSink) throws IOException {
    long l = this.size;
    if (l > 0L)
      paramSink.write(this, l); 
    return l;
  }
  
  public byte readByte() {
    if (this.size != 0L) {
      Segment segment = this.head;
      int i = segment.pos;
      int j = segment.limit;
      byte[] arrayOfByte = segment.data;
      int k = i + 1;
      byte b = arrayOfByte[i];
      this.size--;
      if (k == j) {
        this.head = segment.pop();
        SegmentPool.recycle(segment);
      } else {
        segment.pos = k;
      } 
      return b;
    } 
    throw new IllegalStateException("size == 0");
  }
  
  public byte[] readByteArray() {
    try {
      return readByteArray(this.size);
    } catch (EOFException eOFException) {
      throw new AssertionError(eOFException);
    } 
  }
  
  public byte[] readByteArray(long paramLong) throws EOFException {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramLong <= 2147483647L) {
      byte[] arrayOfByte = new byte[(int)paramLong];
      readFully(arrayOfByte);
      return arrayOfByte;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public ByteString readByteString() {
    return new ByteString(readByteArray());
  }
  
  public ByteString readByteString(long paramLong) throws EOFException {
    return new ByteString(readByteArray(paramLong));
  }
  
  public long readDecimalLong() {
    long l1 = this.size;
    long l2 = 0L;
    if (l1 != 0L) {
      byte b3;
      int j;
      byte b1 = 0;
      long l = -7L;
      int i = 0;
      byte b2 = 0;
      while (true) {
        StringBuilder stringBuilder;
        Segment segment = this.head;
        byte[] arrayOfByte = segment.data;
        int k = segment.pos;
        int m = segment.limit;
        b3 = b1;
        j = i;
        l1 = l2;
        while (true) {
          b1 = b2;
          if (k < m) {
            b1 = arrayOfByte[k];
            if (b1 >= 48 && b1 <= 57) {
              i = 48 - b1;
              if (l1 < -922337203685477580L || (l1 == -922337203685477580L && i < l)) {
                Buffer buffer = (new Buffer()).writeDecimalLong(l1).writeByte(b1);
                if (j == 0)
                  buffer.readByte(); 
                stringBuilder = new StringBuilder();
                stringBuilder.append("Number too large: ");
                stringBuilder.append(buffer.readUtf8());
                throw new NumberFormatException(stringBuilder.toString());
              } 
              l1 = l1 * 10L + i;
            } else if (b1 == 45 && b3 == 0) {
              l--;
              j = 1;
            } else {
              if (b3 != 0) {
                b1 = 1;
                break;
              } 
              stringBuilder = new StringBuilder();
              stringBuilder.append("Expected leading [0-9] or '-' character but was 0x");
              stringBuilder.append(Integer.toHexString(b1));
              throw new NumberFormatException(stringBuilder.toString());
            } 
            k++;
            b3++;
            continue;
          } 
          break;
        } 
        if (k == m) {
          this.head = stringBuilder.pop();
          SegmentPool.recycle((Segment)stringBuilder);
        } else {
          ((Segment)stringBuilder).pos = k;
        } 
        if (b1 == 0) {
          l2 = l1;
          i = j;
          b2 = b1;
          b1 = b3;
          if (this.head == null)
            break; 
          continue;
        } 
        break;
      } 
      this.size -= b3;
      if (j == 0)
        l1 = -l1; 
      return l1;
    } 
    throw new IllegalStateException("size == 0");
  }
  
  public Buffer readFrom(InputStream paramInputStream) throws IOException {
    readFrom(paramInputStream, Long.MAX_VALUE, true);
    return this;
  }
  
  public Buffer readFrom(InputStream paramInputStream, long paramLong) throws IOException {
    if (paramLong >= 0L) {
      readFrom(paramInputStream, paramLong, false);
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("byteCount < 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void readFully(Buffer paramBuffer, long paramLong) throws EOFException {
    long l = this.size;
    if (l >= paramLong) {
      paramBuffer.write(this, paramLong);
      return;
    } 
    paramBuffer.write(this, l);
    throw new EOFException();
  }
  
  public void readFully(byte[] paramArrayOfbyte) throws EOFException {
    int i = 0;
    while (i < paramArrayOfbyte.length) {
      int j = read(paramArrayOfbyte, i, paramArrayOfbyte.length - i);
      if (j != -1) {
        i += j;
        continue;
      } 
      throw new EOFException();
    } 
  }
  
  public long readHexadecimalUnsignedLong() {
    if (this.size != 0L) {
      long l2;
      int k;
      int i = 0;
      long l1 = 0L;
      int j = 0;
      while (true) {
        StringBuilder stringBuilder;
        Segment segment = this.head;
        byte[] arrayOfByte = segment.data;
        int m = segment.pos;
        int n = segment.limit;
        l2 = l1;
        k = j;
        while (true) {
          j = i;
          if (m < n) {
            byte b = arrayOfByte[m];
            if (b >= 48 && b <= 57) {
              j = b - 48;
            } else if (b >= 97 && b <= 102) {
              j = b - 97 + 10;
            } else if (b >= 65 && b <= 70) {
              j = b - 65 + 10;
            } else {
              if (k != 0) {
                j = 1;
                break;
              } 
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Expected leading [0-9a-fA-F] character but was 0x");
              stringBuilder1.append(Integer.toHexString(b));
              throw new NumberFormatException(stringBuilder1.toString());
            } 
            if ((0xF000000000000000L & l2) == 0L) {
              l2 = l2 << 4L | j;
              m++;
              k++;
              continue;
            } 
            Buffer buffer = (new Buffer()).writeHexadecimalUnsignedLong(l2).writeByte(b);
            stringBuilder = new StringBuilder();
            stringBuilder.append("Number too large: ");
            stringBuilder.append(buffer.readUtf8());
            throw new NumberFormatException(stringBuilder.toString());
          } 
          break;
        } 
        if (m == n) {
          this.head = stringBuilder.pop();
          SegmentPool.recycle((Segment)stringBuilder);
        } else {
          ((Segment)stringBuilder).pos = m;
        } 
        if (j == 0) {
          i = j;
          j = k;
          l1 = l2;
          if (this.head == null)
            break; 
          continue;
        } 
        break;
      } 
      this.size -= k;
      return l2;
    } 
    throw new IllegalStateException("size == 0");
  }
  
  public int readInt() {
    if (this.size >= 4L) {
      Segment segment = this.head;
      int i = segment.pos;
      int j = segment.limit;
      if (j - i < 4)
        return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF; 
      byte[] arrayOfByte = segment.data;
      int k = i + 1;
      i = arrayOfByte[i];
      int m = k + 1;
      k = arrayOfByte[k];
      int n = m + 1;
      m = arrayOfByte[m];
      int i1 = n + 1;
      n = arrayOfByte[n];
      this.size -= 4L;
      if (i1 == j) {
        this.head = segment.pop();
        SegmentPool.recycle(segment);
      } else {
        segment.pos = i1;
      } 
      return (i & 0xFF) << 24 | (k & 0xFF) << 16 | (m & 0xFF) << 8 | n & 0xFF;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size < 4: ");
    stringBuilder.append(this.size);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public int readIntLe() {
    return Util.reverseBytesInt(readInt());
  }
  
  public long readLong() {
    if (this.size >= 8L) {
      Segment segment = this.head;
      int i = segment.pos;
      int j = segment.limit;
      if (j - i < 8)
        return (readInt() & 0xFFFFFFFFL) << 32L | 0xFFFFFFFFL & readInt(); 
      byte[] arrayOfByte = segment.data;
      int k = i + 1;
      long l1 = arrayOfByte[i];
      i = k + 1;
      long l2 = arrayOfByte[k];
      k = i + 1;
      long l3 = arrayOfByte[i];
      i = k + 1;
      long l4 = arrayOfByte[k];
      k = i + 1;
      long l5 = arrayOfByte[i];
      i = k + 1;
      long l6 = arrayOfByte[k];
      k = i + 1;
      long l7 = arrayOfByte[i];
      i = k + 1;
      long l8 = arrayOfByte[k];
      this.size -= 8L;
      if (i == j) {
        this.head = segment.pop();
        SegmentPool.recycle(segment);
      } else {
        segment.pos = i;
      } 
      return l8 & 0xFFL | (l7 & 0xFFL) << 8L | (l1 & 0xFFL) << 56L | (l2 & 0xFFL) << 48L | (l3 & 0xFFL) << 40L | (l4 & 0xFFL) << 32L | (l5 & 0xFFL) << 24L | (l6 & 0xFFL) << 16L;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size < 8: ");
    stringBuilder.append(this.size);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public long readLongLe() {
    return Util.reverseBytesLong(readLong());
  }
  
  public short readShort() {
    if (this.size >= 2L) {
      Segment segment = this.head;
      int i = segment.pos;
      int j = segment.limit;
      if (j - i < 2)
        return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF); 
      byte[] arrayOfByte = segment.data;
      int k = i + 1;
      byte b = arrayOfByte[i];
      i = k + 1;
      k = arrayOfByte[k];
      this.size -= 2L;
      if (i == j) {
        this.head = segment.pop();
        SegmentPool.recycle(segment);
      } else {
        segment.pos = i;
      } 
      return (short)((b & 0xFF) << 8 | k & 0xFF);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size < 2: ");
    stringBuilder.append(this.size);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public short readShortLe() {
    return Util.reverseBytesShort(readShort());
  }
  
  public String readString(long paramLong, Charset paramCharset) throws EOFException {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramCharset != null) {
      if (paramLong <= 2147483647L) {
        if (paramLong == 0L)
          return ""; 
        Segment segment = this.head;
        if (segment.pos + paramLong > segment.limit)
          return new String(readByteArray(paramLong), paramCharset); 
        String str = new String(segment.data, segment.pos, (int)paramLong, paramCharset);
        segment.pos = (int)(segment.pos + paramLong);
        this.size -= paramLong;
        if (segment.pos == segment.limit) {
          this.head = segment.pop();
          SegmentPool.recycle(segment);
        } 
        return str;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
      stringBuilder.append(paramLong);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("charset == null");
  }
  
  public String readString(Charset paramCharset) {
    try {
      return readString(this.size, paramCharset);
    } catch (EOFException eOFException) {
      throw new AssertionError(eOFException);
    } 
  }
  
  public String readUtf8() {
    try {
      return readString(this.size, Util.UTF_8);
    } catch (EOFException eOFException) {
      throw new AssertionError(eOFException);
    } 
  }
  
  public String readUtf8(long paramLong) throws EOFException {
    return readString(paramLong, Util.UTF_8);
  }
  
  public int readUtf8CodePoint() throws EOFException {
    if (this.size != 0L) {
      int i;
      byte b2;
      int j;
      byte b = getByte(0L);
      byte b1 = 1;
      if ((b & 0x80) == 0) {
        i = b & Byte.MAX_VALUE;
        b2 = 1;
        j = 0;
      } else if ((b & 0xE0) == 192) {
        i = b & 0x1F;
        b2 = 2;
        j = 128;
      } else if ((b & 0xF0) == 224) {
        i = b & 0xF;
        b2 = 3;
        j = 2048;
      } else if ((b & 0xF8) == 240) {
        i = b & 0x7;
        b2 = 4;
        j = 65536;
      } else {
        skip(1L);
        return 65533;
      } 
      long l1 = this.size;
      long l2 = b2;
      if (l1 >= l2) {
        while (b1 < b2) {
          l1 = b1;
          b = getByte(l1);
          if ((b & 0xC0) == 128) {
            i = i << 6 | b & 0x3F;
            b1++;
            continue;
          } 
          skip(l1);
          return 65533;
        } 
        skip(l2);
        return (i > 1114111) ? 65533 : ((i >= 55296 && i <= 57343) ? 65533 : ((i < j) ? 65533 : i));
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("size < ");
      stringBuilder.append(b2);
      stringBuilder.append(": ");
      stringBuilder.append(this.size);
      stringBuilder.append(" (to read code point prefixed 0x");
      stringBuilder.append(Integer.toHexString(b));
      stringBuilder.append(")");
      throw new EOFException(stringBuilder.toString());
    } 
    throw new EOFException();
  }
  
  @Nullable
  public String readUtf8Line() throws EOFException {
    long l = indexOf((byte)10);
    if (l == -1L) {
      String str;
      l = this.size;
      if (l != 0L) {
        str = readUtf8(l);
      } else {
        str = null;
      } 
      return str;
    } 
    return readUtf8Line(l);
  }
  
  String readUtf8Line(long paramLong) throws EOFException {
    if (paramLong > 0L) {
      long l = paramLong - 1L;
      if (getByte(l) == 13) {
        String str1 = readUtf8(l);
        skip(2L);
        return str1;
      } 
    } 
    String str = readUtf8(paramLong);
    skip(1L);
    return str;
  }
  
  public String readUtf8LineStrict() throws EOFException {
    return readUtf8LineStrict(Long.MAX_VALUE);
  }
  
  public String readUtf8LineStrict(long paramLong) throws EOFException {
    if (paramLong >= 0L) {
      long l1 = Long.MAX_VALUE;
      if (paramLong != Long.MAX_VALUE)
        l1 = paramLong + 1L; 
      long l2 = indexOf((byte)10, 0L, l1);
      if (l2 != -1L)
        return readUtf8Line(l2); 
      if (l1 < size() && getByte(l1 - 1L) == 13 && getByte(l1) == 10)
        return readUtf8Line(l1); 
      Buffer buffer = new Buffer();
      copyTo(buffer, 0L, Math.min(32L, size()));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\\n not found: limit=");
      stringBuilder1.append(Math.min(size(), paramLong));
      stringBuilder1.append(" content=");
      stringBuilder1.append(buffer.readByteString().hex());
      stringBuilder1.append('…');
      throw new EOFException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("limit < 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean request(long paramLong) {
    boolean bool;
    if (this.size >= paramLong) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void require(long paramLong) throws EOFException {
    if (this.size >= paramLong)
      return; 
    throw new EOFException();
  }
  
  List<Integer> segmentSizes() {
    if (this.head == null)
      return Collections.emptyList(); 
    ArrayList<Integer> arrayList = new ArrayList();
    arrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
    Segment segment = this.head;
    while (true) {
      segment = segment.next;
      if (segment != this.head) {
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        continue;
      } 
      return arrayList;
    } 
  }
  
  public int select(Options paramOptions) {
    Segment segment = this.head;
    if (segment == null)
      return paramOptions.indexOf(ByteString.EMPTY); 
    for (ByteString byteString : paramOptions.byteStrings) {
      if (this.size >= byteString.size() && rangeEquals(segment, segment.pos, byteString, 0, byteString.size()))
        try {
          skip(byteString.size());
          return null;
        } catch (EOFException eOFException) {
          throw new AssertionError(eOFException);
        }  
    } 
    return -1;
  }
  
  int selectPrefix(Options paramOptions) {
    Segment segment = this.head;
    for (ByteString byteString : paramOptions.byteStrings) {
      int i = (int)Math.min(this.size, byteString.size());
      if (i == 0 || rangeEquals(segment, segment.pos, byteString, 0, i))
        return null; 
    } 
    return -1;
  }
  
  public ByteString sha1() {
    return digest("SHA-1");
  }
  
  public ByteString sha256() {
    return digest("SHA-256");
  }
  
  public ByteString sha512() {
    return digest("SHA-512");
  }
  
  public long size() {
    return this.size;
  }
  
  public void skip(long paramLong) throws EOFException {
    while (paramLong > 0L) {
      Segment segment = this.head;
      if (segment != null) {
        int i = (int)Math.min(paramLong, (segment.limit - this.head.pos));
        long l1 = this.size;
        long l2 = i;
        this.size = l1 - l2;
        l2 = paramLong - l2;
        segment = this.head;
        segment.pos += i;
        paramLong = l2;
        if (this.head.pos == this.head.limit) {
          segment = this.head;
          this.head = segment.pop();
          SegmentPool.recycle(segment);
          paramLong = l2;
        } 
        continue;
      } 
      throw new EOFException();
    } 
  }
  
  public ByteString snapshot() {
    long l = this.size;
    if (l <= 2147483647L)
      return snapshot((int)l); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size > Integer.MAX_VALUE: ");
    stringBuilder.append(this.size);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public ByteString snapshot(int paramInt) {
    return (paramInt == 0) ? ByteString.EMPTY : new SegmentedByteString(this, paramInt);
  }
  
  public Timeout timeout() {
    return Timeout.NONE;
  }
  
  public String toString() {
    return snapshot().toString();
  }
  
  Segment writableSegment(int paramInt) {
    Segment segment;
    if (paramInt >= 1 && paramInt <= 8192) {
      Segment segment1 = this.head;
      if (segment1 == null) {
        this.head = SegmentPool.take();
        segment1 = this.head;
        segment1.prev = segment1;
        segment1.next = segment1;
        return segment1;
      } 
      segment = segment1.prev;
      if (segment.limit + paramInt <= 8192) {
        segment1 = segment;
        return !segment.owner ? segment.push(SegmentPool.take()) : segment1;
      } 
    } else {
      throw new IllegalArgumentException();
    } 
    return segment.push(SegmentPool.take());
  }
  
  public Buffer write(ByteString paramByteString) {
    if (paramByteString != null) {
      paramByteString.write(this);
      return this;
    } 
    throw new IllegalArgumentException("byteString == null");
  }
  
  public Buffer write(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      return write(paramArrayOfbyte, 0, paramArrayOfbyte.length); 
    throw new IllegalArgumentException("source == null");
  }
  
  public Buffer write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      long l1 = paramArrayOfbyte.length;
      long l2 = paramInt1;
      long l3 = paramInt2;
      Util.checkOffsetAndCount(l1, l2, l3);
      paramInt2 += paramInt1;
      while (paramInt1 < paramInt2) {
        Segment segment = writableSegment(1);
        int i = Math.min(paramInt2 - paramInt1, 8192 - segment.limit);
        System.arraycopy(paramArrayOfbyte, paramInt1, segment.data, segment.limit, i);
        paramInt1 += i;
        segment.limit += i;
      } 
      this.size += l3;
      return this;
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  public BufferedSink write(Source paramSource, long paramLong) throws IOException {
    while (paramLong > 0L) {
      long l = paramSource.read(this, paramLong);
      if (l != -1L) {
        paramLong -= l;
        continue;
      } 
      throw new EOFException();
    } 
    return this;
  }
  
  public void write(Buffer paramBuffer, long paramLong) {
    if (paramBuffer != null) {
      if (paramBuffer != this) {
        Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
        while (paramLong > 0L) {
          if (paramLong < (paramBuffer.head.limit - paramBuffer.head.pos)) {
            Segment segment = this.head;
            if (segment != null) {
              segment = segment.prev;
            } else {
              segment = null;
            } 
            if (segment != null && segment.owner) {
              int i;
              long l1 = segment.limit;
              if (segment.shared) {
                i = 0;
              } else {
                i = segment.pos;
              } 
              if (l1 + paramLong - i <= 8192L) {
                paramBuffer.head.writeTo(segment, (int)paramLong);
                paramBuffer.size -= paramLong;
                this.size += paramLong;
                return;
              } 
            } 
            paramBuffer.head = paramBuffer.head.split((int)paramLong);
          } 
          Segment segment2 = paramBuffer.head;
          long l = (segment2.limit - segment2.pos);
          paramBuffer.head = segment2.pop();
          Segment segment1 = this.head;
          if (segment1 == null) {
            this.head = segment2;
            segment1 = this.head;
            segment1.prev = segment1;
            segment1.next = segment1;
          } else {
            segment1.prev.push(segment2).compact();
          } 
          paramBuffer.size -= l;
          this.size += l;
          paramLong -= l;
        } 
        return;
      } 
      throw new IllegalArgumentException("source == this");
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  public long writeAll(Source paramSource) throws IOException {
    if (paramSource != null) {
      long l = 0L;
      while (true) {
        long l1 = paramSource.read(this, 8192L);
        if (l1 != -1L) {
          l += l1;
          continue;
        } 
        return l;
      } 
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  public Buffer writeByte(int paramInt) {
    Segment segment = writableSegment(1);
    byte[] arrayOfByte = segment.data;
    int i = segment.limit;
    segment.limit = i + 1;
    arrayOfByte[i] = (byte)(byte)paramInt;
    this.size++;
    return this;
  }
  
  public Buffer writeDecimalLong(long paramLong) {
    if (paramLong == 0L)
      return writeByte(48); 
    boolean bool = false;
    int i = 1;
    long l = paramLong;
    if (paramLong < 0L) {
      l = -paramLong;
      if (l < 0L)
        return writeUtf8("-9223372036854775808"); 
      bool = true;
    } 
    if (l < 100000000L) {
      if (l < 10000L) {
        if (l < 100L) {
          if (l >= 10L)
            i = 2; 
        } else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        } 
      } else if (l < 1000000L) {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        } 
      } else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      } 
    } else if (l < 1000000000000L) {
      if (l < 10000000000L) {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        } 
      } else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      } 
    } else if (l < 1000000000000000L) {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      } 
    } else if (l < 100000000000000000L) {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      } 
    } else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    } 
    int j = i;
    if (bool)
      j = i + 1; 
    Segment segment = writableSegment(j);
    byte[] arrayOfByte = segment.data;
    i = segment.limit + j;
    while (l != 0L) {
      int k = (int)(l % 10L);
      arrayOfByte[--i] = (byte)DIGITS[k];
      l /= 10L;
    } 
    if (bool)
      arrayOfByte[i - 1] = (byte)45; 
    segment.limit += j;
    this.size += j;
    return this;
  }
  
  public Buffer writeHexadecimalUnsignedLong(long paramLong) {
    if (paramLong == 0L)
      return writeByte(48); 
    int i = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    Segment segment = writableSegment(i);
    byte[] arrayOfByte = segment.data;
    int j = segment.limit + i - 1;
    int k = segment.limit;
    while (j >= k) {
      arrayOfByte[j] = (byte)DIGITS[(int)(0xFL & paramLong)];
      paramLong >>>= 4L;
      j--;
    } 
    segment.limit += i;
    this.size += i;
    return this;
  }
  
  public Buffer writeInt(int paramInt) {
    Segment segment = writableSegment(4);
    byte[] arrayOfByte = segment.data;
    int i = segment.limit;
    int j = i + 1;
    arrayOfByte[i] = (byte)(byte)(paramInt >>> 24 & 0xFF);
    i = j + 1;
    arrayOfByte[j] = (byte)(byte)(paramInt >>> 16 & 0xFF);
    j = i + 1;
    arrayOfByte[i] = (byte)(byte)(paramInt >>> 8 & 0xFF);
    arrayOfByte[j] = (byte)(byte)(paramInt & 0xFF);
    segment.limit = j + 1;
    this.size += 4L;
    return this;
  }
  
  public Buffer writeIntLe(int paramInt) {
    return writeInt(Util.reverseBytesInt(paramInt));
  }
  
  public Buffer writeLong(long paramLong) {
    Segment segment = writableSegment(8);
    byte[] arrayOfByte = segment.data;
    int i = segment.limit;
    int j = i + 1;
    arrayOfByte[i] = (byte)(byte)(int)(paramLong >>> 56L & 0xFFL);
    i = j + 1;
    arrayOfByte[j] = (byte)(byte)(int)(paramLong >>> 48L & 0xFFL);
    j = i + 1;
    arrayOfByte[i] = (byte)(byte)(int)(paramLong >>> 40L & 0xFFL);
    int k = j + 1;
    arrayOfByte[j] = (byte)(byte)(int)(paramLong >>> 32L & 0xFFL);
    i = k + 1;
    arrayOfByte[k] = (byte)(byte)(int)(paramLong >>> 24L & 0xFFL);
    j = i + 1;
    arrayOfByte[i] = (byte)(byte)(int)(paramLong >>> 16L & 0xFFL);
    i = j + 1;
    arrayOfByte[j] = (byte)(byte)(int)(paramLong >>> 8L & 0xFFL);
    arrayOfByte[i] = (byte)(byte)(int)(paramLong & 0xFFL);
    segment.limit = i + 1;
    this.size += 8L;
    return this;
  }
  
  public Buffer writeLongLe(long paramLong) {
    return writeLong(Util.reverseBytesLong(paramLong));
  }
  
  public Buffer writeShort(int paramInt) {
    Segment segment = writableSegment(2);
    byte[] arrayOfByte = segment.data;
    int i = segment.limit;
    int j = i + 1;
    arrayOfByte[i] = (byte)(byte)(paramInt >>> 8 & 0xFF);
    arrayOfByte[j] = (byte)(byte)(paramInt & 0xFF);
    segment.limit = j + 1;
    this.size += 2L;
    return this;
  }
  
  public Buffer writeShortLe(int paramInt) {
    return writeShort(Util.reverseBytesShort((short)paramInt));
  }
  
  public Buffer writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset) {
    if (paramString != null) {
      if (paramInt1 >= 0) {
        if (paramInt2 >= paramInt1) {
          byte[] arrayOfByte;
          if (paramInt2 <= paramString.length()) {
            if (paramCharset != null) {
              if (paramCharset.equals(Util.UTF_8))
                return writeUtf8(paramString, paramInt1, paramInt2); 
              arrayOfByte = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
              return write(arrayOfByte, 0, arrayOfByte.length);
            } 
            throw new IllegalArgumentException("charset == null");
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("endIndex > string.length: ");
          stringBuilder2.append(paramInt2);
          stringBuilder2.append(" > ");
          stringBuilder2.append(arrayOfByte.length());
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("endIndex < beginIndex: ");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" < ");
        stringBuilder1.append(paramInt1);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("beginIndex < 0: ");
      stringBuilder.append(paramInt1);
      throw new IllegalAccessError(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("string == null");
  }
  
  public Buffer writeString(String paramString, Charset paramCharset) {
    return writeString(paramString, 0, paramString.length(), paramCharset);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream) throws IOException {
    return writeTo(paramOutputStream, this.size);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream, long paramLong) throws IOException {
    if (paramOutputStream != null) {
      Util.checkOffsetAndCount(this.size, 0L, paramLong);
      Segment segment = this.head;
      while (paramLong > 0L) {
        int i = (int)Math.min(paramLong, (segment.limit - segment.pos));
        paramOutputStream.write(segment.data, segment.pos, i);
        segment.pos += i;
        long l1 = this.size;
        long l2 = i;
        this.size = l1 - l2;
        l1 = paramLong - l2;
        paramLong = l1;
        if (segment.pos == segment.limit) {
          Segment segment1 = segment.pop();
          this.head = segment1;
          SegmentPool.recycle(segment);
          segment = segment1;
          paramLong = l1;
        } 
      } 
      return this;
    } 
    throw new IllegalArgumentException("out == null");
  }
  
  public Buffer writeUtf8(String paramString) {
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  public Buffer writeUtf8(String paramString, int paramInt1, int paramInt2) {
    if (paramString != null) {
      if (paramInt1 >= 0) {
        if (paramInt2 >= paramInt1) {
          if (paramInt2 <= paramString.length()) {
            while (paramInt1 < paramInt2) {
              char c = paramString.charAt(paramInt1);
              if (c < '') {
                Segment segment = writableSegment(1);
                byte[] arrayOfByte = segment.data;
                int k = segment.limit - paramInt1;
                int m = Math.min(paramInt2, 8192 - k);
                j = paramInt1 + 1;
                arrayOfByte[paramInt1 + k] = (byte)(byte)c;
                for (paramInt1 = j; paramInt1 < m; paramInt1++) {
                  j = paramString.charAt(paramInt1);
                  if (j >= 128)
                    break; 
                  arrayOfByte[paramInt1 + k] = (byte)(byte)j;
                } 
                j = k + paramInt1 - segment.limit;
                segment.limit += j;
                this.size += j;
                continue;
              } 
              if (c < 'ࠀ') {
                writeByte(c >> 6 | 0xC0);
                writeByte(c & 0x3F | 0x80);
                paramInt1++;
                continue;
              } 
              if (c < '?' || c > '?') {
                writeByte(c >> 12 | 0xE0);
                writeByte(c >> 6 & 0x3F | 0x80);
                writeByte(c & 0x3F | 0x80);
                paramInt1++;
                continue;
              } 
              int i = paramInt1 + 1;
              if (i < paramInt2) {
                j = paramString.charAt(i);
              } else {
                j = 0;
              } 
              if (c > '?' || j < 56320 || j > 57343) {
                writeByte(63);
                paramInt1 = i;
                continue;
              } 
              int j = ((c & 0xFFFF27FF) << 10 | 0xFFFF23FF & j) + 65536;
              writeByte(j >> 18 | 0xF0);
              writeByte(j >> 12 & 0x3F | 0x80);
              writeByte(j >> 6 & 0x3F | 0x80);
              writeByte(j & 0x3F | 0x80);
              paramInt1 += 2;
            } 
            return this;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("endIndex > string.length: ");
          stringBuilder2.append(paramInt2);
          stringBuilder2.append(" > ");
          stringBuilder2.append(paramString.length());
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("endIndex < beginIndex: ");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" < ");
        stringBuilder1.append(paramInt1);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("beginIndex < 0: ");
      stringBuilder.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("string == null");
  }
  
  public Buffer writeUtf8CodePoint(int paramInt) {
    if (paramInt < 128) {
      writeByte(paramInt);
    } else if (paramInt < 2048) {
      writeByte(paramInt >> 6 | 0xC0);
      writeByte(paramInt & 0x3F | 0x80);
    } else if (paramInt < 65536) {
      if (paramInt >= 55296 && paramInt <= 57343) {
        writeByte(63);
      } else {
        writeByte(paramInt >> 12 | 0xE0);
        writeByte(paramInt >> 6 & 0x3F | 0x80);
        writeByte(paramInt & 0x3F | 0x80);
      } 
    } else {
      if (paramInt <= 1114111) {
        writeByte(paramInt >> 18 | 0xF0);
        writeByte(paramInt >> 12 & 0x3F | 0x80);
        writeByte(paramInt >> 6 & 0x3F | 0x80);
        writeByte(paramInt & 0x3F | 0x80);
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected code point: ");
      stringBuilder.append(Integer.toHexString(paramInt));
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return this;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\Buffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */