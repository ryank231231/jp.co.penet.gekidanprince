package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

final class MacHashFunction extends AbstractStreamingHashFunction {
  private final int bits;
  
  private final Key key;
  
  private final Mac prototype;
  
  private final boolean supportsClone;
  
  private final String toString;
  
  MacHashFunction(String paramString1, Key paramKey, String paramString2) {
    this.prototype = getMac(paramString1, paramKey);
    this.key = (Key)Preconditions.checkNotNull(paramKey);
    this.toString = (String)Preconditions.checkNotNull(paramString2);
    this.bits = this.prototype.getMacLength() * 8;
    this.supportsClone = supportsClone(this.prototype);
  }
  
  private static Mac getMac(String paramString, Key paramKey) {
    try {
      Mac mac = Mac.getInstance(paramString);
      mac.init(paramKey);
      return mac;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new IllegalStateException(noSuchAlgorithmException);
    } catch (InvalidKeyException invalidKeyException) {
      throw new IllegalArgumentException(invalidKeyException);
    } 
  }
  
  private static boolean supportsClone(Mac paramMac) {
    try {
      paramMac.clone();
      return true;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return false;
    } 
  }
  
  public int bits() {
    return this.bits;
  }
  
  public Hasher newHasher() {
    if (this.supportsClone)
      try {
        return new MacHasher((Mac)this.prototype.clone());
      } catch (CloneNotSupportedException cloneNotSupportedException) {} 
    return new MacHasher(getMac(this.prototype.getAlgorithm(), this.key));
  }
  
  public String toString() {
    return this.toString;
  }
  
  private static final class MacHasher extends AbstractByteHasher {
    private boolean done;
    
    private final Mac mac;
    
    private MacHasher(Mac param1Mac) {
      this.mac = param1Mac;
    }
    
    private void checkNotDone() {
      Preconditions.checkState(this.done ^ true, "Cannot re-use a Hasher after calling hash() on it");
    }
    
    public HashCode hash() {
      checkNotDone();
      this.done = true;
      return HashCode.fromBytesNoCopy(this.mac.doFinal());
    }
    
    protected void update(byte param1Byte) {
      checkNotDone();
      this.mac.update(param1Byte);
    }
    
    protected void update(byte[] param1ArrayOfbyte) {
      checkNotDone();
      this.mac.update(param1ArrayOfbyte);
    }
    
    protected void update(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      checkNotDone();
      this.mac.update(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\MacHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */