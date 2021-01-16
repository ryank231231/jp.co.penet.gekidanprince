package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

final class MessageDigestHashFunction extends AbstractStreamingHashFunction implements Serializable {
  private final int bytes;
  
  private final MessageDigest prototype;
  
  private final boolean supportsClone;
  
  private final String toString;
  
  MessageDigestHashFunction(String paramString1, int paramInt, String paramString2) {
    boolean bool;
    this.toString = (String)Preconditions.checkNotNull(paramString2);
    this.prototype = getMessageDigest(paramString1);
    int i = this.prototype.getDigestLength();
    if (paramInt >= 4 && paramInt <= i) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "bytes (%s) must be >= 4 and < %s", paramInt, i);
    this.bytes = paramInt;
    this.supportsClone = supportsClone(this.prototype);
  }
  
  MessageDigestHashFunction(String paramString1, String paramString2) {
    this.prototype = getMessageDigest(paramString1);
    this.bytes = this.prototype.getDigestLength();
    this.toString = (String)Preconditions.checkNotNull(paramString2);
    this.supportsClone = supportsClone(this.prototype);
  }
  
  private static MessageDigest getMessageDigest(String paramString) {
    try {
      return MessageDigest.getInstance(paramString);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } 
  }
  
  private static boolean supportsClone(MessageDigest paramMessageDigest) {
    try {
      paramMessageDigest.clone();
      return true;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return false;
    } 
  }
  
  public int bits() {
    return this.bytes * 8;
  }
  
  public Hasher newHasher() {
    if (this.supportsClone)
      try {
        return new MessageDigestHasher((MessageDigest)this.prototype.clone(), this.bytes);
      } catch (CloneNotSupportedException cloneNotSupportedException) {} 
    return new MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes);
  }
  
  public String toString() {
    return this.toString;
  }
  
  Object writeReplace() {
    return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
  }
  
  private static final class MessageDigestHasher extends AbstractByteHasher {
    private final int bytes;
    
    private final MessageDigest digest;
    
    private boolean done;
    
    private MessageDigestHasher(MessageDigest param1MessageDigest, int param1Int) {
      this.digest = param1MessageDigest;
      this.bytes = param1Int;
    }
    
    private void checkNotDone() {
      Preconditions.checkState(this.done ^ true, "Cannot re-use a Hasher after calling hash() on it");
    }
    
    public HashCode hash() {
      byte[] arrayOfByte;
      checkNotDone();
      this.done = true;
      if (this.bytes == this.digest.getDigestLength()) {
        arrayOfByte = this.digest.digest();
      } else {
        arrayOfByte = Arrays.copyOf(this.digest.digest(), this.bytes);
      } 
      return HashCode.fromBytesNoCopy(arrayOfByte);
    }
    
    protected void update(byte param1Byte) {
      checkNotDone();
      this.digest.update(param1Byte);
    }
    
    protected void update(byte[] param1ArrayOfbyte) {
      checkNotDone();
      this.digest.update(param1ArrayOfbyte);
    }
    
    protected void update(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      checkNotDone();
      this.digest.update(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
  
  private static final class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final String algorithmName;
    
    private final int bytes;
    
    private final String toString;
    
    private SerializedForm(String param1String1, int param1Int, String param1String2) {
      this.algorithmName = param1String1;
      this.bytes = param1Int;
      this.toString = param1String2;
    }
    
    private Object readResolve() {
      return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\MessageDigestHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */