package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ByteString implements Serializable, Comparable<ByteString> {
  public static final ByteString EMPTY;
  
  static final char[] HEX_DIGITS = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final long serialVersionUID = 1L;
  
  final byte[] data;
  
  transient int hashCode;
  
  transient String utf8;
  
  static {
    EMPTY = of(new byte[0]);
  }
  
  ByteString(byte[] paramArrayOfbyte) {
    this.data = paramArrayOfbyte;
  }
  
  static int codePointIndexToCharIndex(String paramString, int paramInt) {
    int i = paramString.length();
    int j = 0;
    int k = 0;
    while (j < i) {
      if (k == paramInt)
        return j; 
      int m = paramString.codePointAt(j);
      if ((Character.isISOControl(m) && m != 10 && m != 13) || m == 65533)
        return -1; 
      k++;
      j += Character.charCount(m);
    } 
    return paramString.length();
  }
  
  @Nullable
  public static ByteString decodeBase64(String paramString) {
    if (paramString != null) {
      byte[] arrayOfByte = Base64.decode(paramString);
      if (arrayOfByte != null) {
        ByteString byteString = new ByteString(arrayOfByte);
      } else {
        arrayOfByte = null;
      } 
      return (ByteString)arrayOfByte;
    } 
    throw new IllegalArgumentException("base64 == null");
  }
  
  public static ByteString decodeHex(String paramString) {
    if (paramString != null) {
      if (paramString.length() % 2 == 0) {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        for (byte b = 0; b < arrayOfByte.length; b++) {
          int i = b * 2;
          arrayOfByte[b] = (byte)(byte)((decodeHexDigit(paramString.charAt(i)) << 4) + decodeHexDigit(paramString.charAt(i + 1)));
        } 
        return of(arrayOfByte);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected hex string: ");
      stringBuilder.append(paramString);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("hex == null");
  }
  
  private static int decodeHexDigit(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    if (paramChar >= 'a' && paramChar <= 'f')
      return paramChar - 97 + 10; 
    if (paramChar >= 'A' && paramChar <= 'F')
      return paramChar - 65 + 10; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected hex digit: ");
    stringBuilder.append(paramChar);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private ByteString digest(String paramString) {
    try {
      return of(MessageDigest.getInstance(paramString).digest(this.data));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } 
  }
  
  public static ByteString encodeString(String paramString, Charset paramCharset) {
    if (paramString != null) {
      if (paramCharset != null)
        return new ByteString(paramString.getBytes(paramCharset)); 
      throw new IllegalArgumentException("charset == null");
    } 
    throw new IllegalArgumentException("s == null");
  }
  
  public static ByteString encodeUtf8(String paramString) {
    if (paramString != null) {
      ByteString byteString = new ByteString(paramString.getBytes(Util.UTF_8));
      byteString.utf8 = paramString;
      return byteString;
    } 
    throw new IllegalArgumentException("s == null");
  }
  
  private ByteString hmac(String paramString, ByteString paramByteString) {
    try {
      Mac mac = Mac.getInstance(paramString);
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramByteString.toByteArray(), paramString);
      mac.init(secretKeySpec);
      return of(mac.doFinal(this.data));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } catch (InvalidKeyException invalidKeyException) {
      throw new IllegalArgumentException(invalidKeyException);
    } 
  }
  
  public static ByteString of(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer != null) {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte);
      return new ByteString(arrayOfByte);
    } 
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString of(byte... paramVarArgs) {
    if (paramVarArgs != null)
      return new ByteString((byte[])paramVarArgs.clone()); 
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString of(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      Util.checkOffsetAndCount(paramArrayOfbyte.length, paramInt1, paramInt2);
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
      return new ByteString(arrayOfByte);
    } 
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString read(InputStream paramInputStream, int paramInt) throws IOException {
    if (paramInputStream != null) {
      if (paramInt >= 0) {
        byte[] arrayOfByte = new byte[paramInt];
        int i = 0;
        while (i < paramInt) {
          int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
          if (j != -1) {
            i += j;
            continue;
          } 
          throw new EOFException();
        } 
        return new ByteString(arrayOfByte);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(paramInt);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("in == null");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException {
    ByteString byteString = read(paramObjectInputStream, paramObjectInputStream.readInt());
    try {
      Field field = ByteString.class.getDeclaredField("data");
      field.setAccessible(true);
      field.set(this, byteString.data);
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      throw new AssertionError();
    } catch (IllegalAccessException illegalAccessException) {
      throw new AssertionError();
    } 
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.writeInt(this.data.length);
    paramObjectOutputStream.write(this.data);
  }
  
  public ByteBuffer asByteBuffer() {
    return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
  }
  
  public String base64() {
    return Base64.encode(this.data);
  }
  
  public String base64Url() {
    return Base64.encodeUrl(this.data);
  }
  
  public int compareTo(ByteString paramByteString) {
    int i = size();
    int j = paramByteString.size();
    int k = Math.min(i, j);
    byte b = 0;
    while (true) {
      byte b1 = -1;
      if (b < k) {
        int m = getByte(b) & 0xFF;
        int n = paramByteString.getByte(b) & 0xFF;
        if (m == n) {
          b++;
          continue;
        } 
        if (m >= n)
          b1 = 1; 
        return b1;
      } 
      if (i == j)
        return 0; 
      if (i >= j)
        b1 = 1; 
      return b1;
    } 
  }
  
  public final boolean endsWith(ByteString paramByteString) {
    return rangeEquals(size() - paramByteString.size(), paramByteString, 0, paramByteString.size());
  }
  
  public final boolean endsWith(byte[] paramArrayOfbyte) {
    return rangeEquals(size() - paramArrayOfbyte.length, paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public boolean equals(Object paramObject) {
    null = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ByteString) {
      paramObject = paramObject;
      int i = paramObject.size();
      byte[] arrayOfByte = this.data;
      if (i == arrayOfByte.length && paramObject.rangeEquals(0, arrayOfByte, 0, arrayOfByte.length))
        return null; 
    } 
    return false;
  }
  
  public byte getByte(int paramInt) {
    return this.data[paramInt];
  }
  
  public int hashCode() {
    int i = this.hashCode;
    if (i == 0) {
      i = Arrays.hashCode(this.data);
      this.hashCode = i;
    } 
    return i;
  }
  
  public String hex() {
    byte[] arrayOfByte = this.data;
    char[] arrayOfChar = new char[arrayOfByte.length * 2];
    int i = arrayOfByte.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      byte b1 = arrayOfByte[b];
      int k = j + 1;
      char[] arrayOfChar1 = HEX_DIGITS;
      arrayOfChar[j] = (char)arrayOfChar1[b1 >> 4 & 0xF];
      j = k + 1;
      arrayOfChar[k] = (char)arrayOfChar1[b1 & 0xF];
      b++;
    } 
    return new String(arrayOfChar);
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
  
  public final int indexOf(ByteString paramByteString) {
    return indexOf(paramByteString.internalArray(), 0);
  }
  
  public final int indexOf(ByteString paramByteString, int paramInt) {
    return indexOf(paramByteString.internalArray(), paramInt);
  }
  
  public final int indexOf(byte[] paramArrayOfbyte) {
    return indexOf(paramArrayOfbyte, 0);
  }
  
  public int indexOf(byte[] paramArrayOfbyte, int paramInt) {
    paramInt = Math.max(paramInt, 0);
    int i = this.data.length;
    int j = paramArrayOfbyte.length;
    while (paramInt <= i - j) {
      if (Util.arrayRangeEquals(this.data, paramInt, paramArrayOfbyte, 0, paramArrayOfbyte.length))
        return paramInt; 
      paramInt++;
    } 
    return -1;
  }
  
  byte[] internalArray() {
    return this.data;
  }
  
  public final int lastIndexOf(ByteString paramByteString) {
    return lastIndexOf(paramByteString.internalArray(), size());
  }
  
  public final int lastIndexOf(ByteString paramByteString, int paramInt) {
    return lastIndexOf(paramByteString.internalArray(), paramInt);
  }
  
  public final int lastIndexOf(byte[] paramArrayOfbyte) {
    return lastIndexOf(paramArrayOfbyte, size());
  }
  
  public int lastIndexOf(byte[] paramArrayOfbyte, int paramInt) {
    for (paramInt = Math.min(paramInt, this.data.length - paramArrayOfbyte.length); paramInt >= 0; paramInt--) {
      if (Util.arrayRangeEquals(this.data, paramInt, paramArrayOfbyte, 0, paramArrayOfbyte.length))
        return paramInt; 
    } 
    return -1;
  }
  
  public ByteString md5() {
    return digest("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3) {
    return paramByteString.rangeEquals(paramInt2, this.data, paramInt1, paramInt3);
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    if (paramInt1 >= 0) {
      byte[] arrayOfByte = this.data;
      if (paramInt1 <= arrayOfByte.length - paramInt3 && paramInt2 >= 0 && paramInt2 <= paramArrayOfbyte.length - paramInt3 && Util.arrayRangeEquals(arrayOfByte, paramInt1, paramArrayOfbyte, paramInt2, paramInt3))
        return true; 
    } 
    return false;
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
  
  public int size() {
    return this.data.length;
  }
  
  public final boolean startsWith(ByteString paramByteString) {
    return rangeEquals(0, paramByteString, 0, paramByteString.size());
  }
  
  public final boolean startsWith(byte[] paramArrayOfbyte) {
    return rangeEquals(0, paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public String string(Charset paramCharset) {
    if (paramCharset != null)
      return new String(this.data, paramCharset); 
    throw new IllegalArgumentException("charset == null");
  }
  
  public ByteString substring(int paramInt) {
    return substring(paramInt, this.data.length);
  }
  
  public ByteString substring(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      byte[] arrayOfByte = this.data;
      if (paramInt2 <= arrayOfByte.length) {
        int i = paramInt2 - paramInt1;
        if (i >= 0) {
          if (paramInt1 == 0 && paramInt2 == arrayOfByte.length)
            return this; 
          arrayOfByte = new byte[i];
          System.arraycopy(this.data, paramInt1, arrayOfByte, 0, i);
          return new ByteString(arrayOfByte);
        } 
        throw new IllegalArgumentException("endIndex < beginIndex");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("endIndex > length(");
      stringBuilder.append(this.data.length);
      stringBuilder.append(")");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("beginIndex < 0");
  }
  
  public ByteString toAsciiLowercase() {
    int i = 0;
    while (true) {
      byte[] arrayOfByte = this.data;
      if (i < arrayOfByte.length) {
        byte b = arrayOfByte[i];
        if (b < 65 || b > 90) {
          i++;
          continue;
        } 
        arrayOfByte = (byte[])arrayOfByte.clone();
        int j = i + 1;
        arrayOfByte[i] = (byte)(byte)(b + 32);
        for (i = j; i < arrayOfByte.length; i++) {
          j = arrayOfByte[i];
          if (j >= 65 && j <= 90)
            arrayOfByte[i] = (byte)(byte)(j + 32); 
        } 
        return new ByteString(arrayOfByte);
      } 
      return this;
    } 
  }
  
  public ByteString toAsciiUppercase() {
    int i = 0;
    while (true) {
      byte[] arrayOfByte = this.data;
      if (i < arrayOfByte.length) {
        byte b = arrayOfByte[i];
        if (b < 97 || b > 122) {
          i++;
          continue;
        } 
        arrayOfByte = (byte[])arrayOfByte.clone();
        int j = i + 1;
        arrayOfByte[i] = (byte)(byte)(b - 32);
        for (i = j; i < arrayOfByte.length; i++) {
          j = arrayOfByte[i];
          if (j >= 97 && j <= 122)
            arrayOfByte[i] = (byte)(byte)(j - 32); 
        } 
        return new ByteString(arrayOfByte);
      } 
      return this;
    } 
  }
  
  public byte[] toByteArray() {
    return (byte[])this.data.clone();
  }
  
  public String toString() {
    if (this.data.length == 0)
      return "[size=0]"; 
    String str1 = utf8();
    int i = codePointIndexToCharIndex(str1, 64);
    if (i == -1) {
      String str;
      if (this.data.length <= 64) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[hex=");
        stringBuilder.append(hex());
        stringBuilder.append("]");
        str = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[size=");
        stringBuilder.append(this.data.length);
        stringBuilder.append(" hex=");
        stringBuilder.append(substring(0, 64).hex());
        stringBuilder.append("…]");
        str = stringBuilder.toString();
      } 
      return str;
    } 
    String str2 = str1.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < str1.length()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[size=");
      stringBuilder.append(this.data.length);
      stringBuilder.append(" text=");
      stringBuilder.append(str2);
      stringBuilder.append("…]");
      str2 = stringBuilder.toString();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[text=");
      stringBuilder.append(str2);
      stringBuilder.append("]");
      str2 = stringBuilder.toString();
    } 
    return str2;
  }
  
  public String utf8() {
    String str = this.utf8;
    if (str == null) {
      str = new String(this.data, Util.UTF_8);
      this.utf8 = str;
    } 
    return str;
  }
  
  public void write(OutputStream paramOutputStream) throws IOException {
    if (paramOutputStream != null) {
      paramOutputStream.write(this.data);
      return;
    } 
    throw new IllegalArgumentException("out == null");
  }
  
  void write(Buffer paramBuffer) {
    byte[] arrayOfByte = this.data;
    paramBuffer.write(arrayOfByte, 0, arrayOfByte.length);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\ByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */