package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class SegmentedByteString extends ByteString {
  final transient int[] directory;
  
  final transient byte[][] segments;
  
  SegmentedByteString(Buffer paramBuffer, int paramInt) {
    super(null);
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramInt);
    Segment segment2 = paramBuffer.head;
    int i = 0;
    int j = 0;
    int k = 0;
    while (j < paramInt) {
      if (segment2.limit != segment2.pos) {
        j += segment2.limit - segment2.pos;
        k++;
        segment2 = segment2.next;
        continue;
      } 
      throw new AssertionError("s.limit == s.pos");
    } 
    this.segments = new byte[k][];
    this.directory = new int[k * 2];
    Segment segment1 = paramBuffer.head;
    j = 0;
    k = i;
    while (k < paramInt) {
      this.segments[j] = segment1.data;
      i = k + segment1.limit - segment1.pos;
      k = i;
      if (i > paramInt)
        k = paramInt; 
      int[] arrayOfInt = this.directory;
      arrayOfInt[j] = k;
      arrayOfInt[this.segments.length + j] = segment1.pos;
      segment1.shared = true;
      j++;
      segment1 = segment1.next;
    } 
  }
  
  private int segment(int paramInt) {
    paramInt = Arrays.binarySearch(this.directory, 0, this.segments.length, paramInt + 1);
    if (paramInt < 0)
      paramInt ^= 0xFFFFFFFF; 
    return paramInt;
  }
  
  private ByteString toByteString() {
    return new ByteString(toByteArray());
  }
  
  private Object writeReplace() {
    return toByteString();
  }
  
  public ByteBuffer asByteBuffer() {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public String base64() {
    return toByteString().base64();
  }
  
  public String base64Url() {
    return toByteString().base64Url();
  }
  
  public boolean equals(Object paramObject) {
    null = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ByteString) {
      paramObject = paramObject;
      if (paramObject.size() == size() && rangeEquals(0, (ByteString)paramObject, 0, size()))
        return null; 
    } 
    return false;
  }
  
  public byte getByte(int paramInt) {
    int j;
    Util.checkOffsetAndCount(this.directory[this.segments.length - 1], paramInt, 1L);
    int i = segment(paramInt);
    if (i == 0) {
      j = 0;
    } else {
      j = this.directory[i - 1];
    } 
    int[] arrayOfInt = this.directory;
    byte[][] arrayOfByte = this.segments;
    int k = arrayOfInt[arrayOfByte.length + i];
    return arrayOfByte[i][paramInt - j + k];
  }
  
  public int hashCode() {
    int i = this.hashCode;
    if (i != 0)
      return i; 
    int j = this.segments.length;
    byte b = 0;
    int k = 1;
    int m;
    for (m = 0; b < j; m = i1) {
      byte[] arrayOfByte = this.segments[b];
      int[] arrayOfInt = this.directory;
      int n = arrayOfInt[j + b];
      int i1 = arrayOfInt[b];
      for (i = n; i < i1 - m + n; i++)
        k = k * 31 + arrayOfByte[i]; 
      b++;
    } 
    this.hashCode = k;
    return k;
  }
  
  public String hex() {
    return toByteString().hex();
  }
  
  public ByteString hmacSha1(ByteString paramByteString) {
    return toByteString().hmacSha1(paramByteString);
  }
  
  public ByteString hmacSha256(ByteString paramByteString) {
    return toByteString().hmacSha256(paramByteString);
  }
  
  public int indexOf(byte[] paramArrayOfbyte, int paramInt) {
    return toByteString().indexOf(paramArrayOfbyte, paramInt);
  }
  
  byte[] internalArray() {
    return toByteArray();
  }
  
  public int lastIndexOf(byte[] paramArrayOfbyte, int paramInt) {
    return toByteString().lastIndexOf(paramArrayOfbyte, paramInt);
  }
  
  public ByteString md5() {
    return toByteString().md5();
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3) {
    if (paramInt1 < 0 || paramInt1 > size() - paramInt3)
      return false; 
    int i = segment(paramInt1);
    int j = paramInt1;
    for (paramInt1 = i; paramInt3 > 0; paramInt1++) {
      if (paramInt1 == 0) {
        i = 0;
      } else {
        i = this.directory[paramInt1 - 1];
      } 
      int k = Math.min(paramInt3, this.directory[paramInt1] - i + i - j);
      int[] arrayOfInt = this.directory;
      byte[][] arrayOfByte = this.segments;
      int m = arrayOfInt[arrayOfByte.length + paramInt1];
      if (!paramByteString.rangeEquals(paramInt2, arrayOfByte[paramInt1], j - i + m, k))
        return false; 
      j += k;
      paramInt2 += k;
      paramInt3 -= k;
    } 
    return true;
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    if (paramInt1 < 0 || paramInt1 > size() - paramInt3 || paramInt2 < 0 || paramInt2 > paramArrayOfbyte.length - paramInt3)
      return false; 
    int i = segment(paramInt1);
    int j = paramInt1;
    for (paramInt1 = i; paramInt3 > 0; paramInt1++) {
      if (paramInt1 == 0) {
        i = 0;
      } else {
        i = this.directory[paramInt1 - 1];
      } 
      int k = Math.min(paramInt3, this.directory[paramInt1] - i + i - j);
      int[] arrayOfInt = this.directory;
      byte[][] arrayOfByte = this.segments;
      int m = arrayOfInt[arrayOfByte.length + paramInt1];
      if (!Util.arrayRangeEquals(arrayOfByte[paramInt1], j - i + m, paramArrayOfbyte, paramInt2, k))
        return false; 
      j += k;
      paramInt2 += k;
      paramInt3 -= k;
    } 
    return true;
  }
  
  public ByteString sha1() {
    return toByteString().sha1();
  }
  
  public ByteString sha256() {
    return toByteString().sha256();
  }
  
  public int size() {
    return this.directory[this.segments.length - 1];
  }
  
  public String string(Charset paramCharset) {
    return toByteString().string(paramCharset);
  }
  
  public ByteString substring(int paramInt) {
    return toByteString().substring(paramInt);
  }
  
  public ByteString substring(int paramInt1, int paramInt2) {
    return toByteString().substring(paramInt1, paramInt2);
  }
  
  public ByteString toAsciiLowercase() {
    return toByteString().toAsciiLowercase();
  }
  
  public ByteString toAsciiUppercase() {
    return toByteString().toAsciiUppercase();
  }
  
  public byte[] toByteArray() {
    int[] arrayOfInt = this.directory;
    byte[][] arrayOfByte1 = this.segments;
    byte[] arrayOfByte = new byte[arrayOfInt[arrayOfByte1.length - 1]];
    int i = arrayOfByte1.length;
    byte b = 0;
    int j;
    for (j = 0; b < i; j = m) {
      int[] arrayOfInt1 = this.directory;
      int k = arrayOfInt1[i + b];
      int m = arrayOfInt1[b];
      System.arraycopy(this.segments[b], k, arrayOfByte, j, m - j);
      b++;
    } 
    return arrayOfByte;
  }
  
  public String toString() {
    return toByteString().toString();
  }
  
  public String utf8() {
    return toByteString().utf8();
  }
  
  public void write(OutputStream paramOutputStream) throws IOException {
    if (paramOutputStream != null) {
      int i = this.segments.length;
      byte b = 0;
      int j;
      for (j = 0; b < i; j = m) {
        int[] arrayOfInt = this.directory;
        int k = arrayOfInt[i + b];
        int m = arrayOfInt[b];
        paramOutputStream.write(this.segments[b], k, m - j);
        b++;
      } 
      return;
    } 
    throw new IllegalArgumentException("out == null");
  }
  
  void write(Buffer paramBuffer) {
    int i = this.segments.length;
    byte b = 0;
    int j;
    for (j = 0; b < i; j = m) {
      int[] arrayOfInt = this.directory;
      int k = arrayOfInt[i + b];
      int m = arrayOfInt[b];
      Segment segment = new Segment(this.segments[b], k, k + m - j);
      if (paramBuffer.head == null) {
        segment.prev = segment;
        segment.next = segment;
        paramBuffer.head = segment;
      } else {
        paramBuffer.head.prev.push(segment);
      } 
      b++;
    } 
    paramBuffer.size += j;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\SegmentedByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */