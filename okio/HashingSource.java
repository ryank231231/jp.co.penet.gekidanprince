package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource extends ForwardingSource {
  private final Mac mac;
  
  private final MessageDigest messageDigest;
  
  private HashingSource(Source paramSource, String paramString) {
    super(paramSource);
    try {
      this.messageDigest = MessageDigest.getInstance(paramString);
      this.mac = null;
      return;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError();
    } 
  }
  
  private HashingSource(Source paramSource, ByteString paramByteString, String paramString) {
    super(paramSource);
    try {
      this.mac = Mac.getInstance(paramString);
      Mac mac = this.mac;
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramByteString.toByteArray(), paramString);
      mac.init(secretKeySpec);
      this.messageDigest = null;
      return;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError();
    } catch (InvalidKeyException invalidKeyException) {
      throw new IllegalArgumentException(invalidKeyException);
    } 
  }
  
  public static HashingSource hmacSha1(Source paramSource, ByteString paramByteString) {
    return new HashingSource(paramSource, paramByteString, "HmacSHA1");
  }
  
  public static HashingSource hmacSha256(Source paramSource, ByteString paramByteString) {
    return new HashingSource(paramSource, paramByteString, "HmacSHA256");
  }
  
  public static HashingSource md5(Source paramSource) {
    return new HashingSource(paramSource, "MD5");
  }
  
  public static HashingSource sha1(Source paramSource) {
    return new HashingSource(paramSource, "SHA-1");
  }
  
  public static HashingSource sha256(Source paramSource) {
    return new HashingSource(paramSource, "SHA-256");
  }
  
  public ByteString hash() {
    byte[] arrayOfByte;
    MessageDigest messageDigest = this.messageDigest;
    if (messageDigest != null) {
      arrayOfByte = messageDigest.digest();
    } else {
      arrayOfByte = this.mac.doFinal();
    } 
    return ByteString.of(arrayOfByte);
  }
  
  public long read(Buffer paramBuffer, long paramLong) throws IOException {
    long l = super.read(paramBuffer, paramLong);
    if (l != -1L) {
      long l2;
      long l3;
      Segment segment2;
      long l1 = paramBuffer.size - l;
      paramLong = paramBuffer.size;
      Segment segment1 = paramBuffer.head;
      while (true) {
        l2 = l1;
        l3 = paramLong;
        segment2 = segment1;
        if (paramLong > l1) {
          segment1 = segment1.prev;
          paramLong -= (segment1.limit - segment1.pos);
          continue;
        } 
        break;
      } 
      while (l3 < paramBuffer.size) {
        int i = (int)(segment2.pos + l2 - l3);
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
          messageDigest.update(segment2.data, i, segment2.limit - i);
        } else {
          this.mac.update(segment2.data, i, segment2.limit - i);
        } 
        l2 = (segment2.limit - segment2.pos) + l3;
        segment2 = segment2.next;
        l3 = l2;
      } 
    } 
    return l;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\HashingSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */