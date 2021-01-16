package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
abstract class AbstractHasher implements Hasher {
  public final Hasher putBoolean(boolean paramBoolean) {
    return putByte(paramBoolean);
  }
  
  public final Hasher putDouble(double paramDouble) {
    return putLong(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final Hasher putFloat(float paramFloat) {
    return putInt(Float.floatToRawIntBits(paramFloat));
  }
  
  public Hasher putString(CharSequence paramCharSequence, Charset paramCharset) {
    return putBytes(paramCharSequence.toString().getBytes(paramCharset));
  }
  
  public Hasher putUnencodedChars(CharSequence paramCharSequence) {
    int i = paramCharSequence.length();
    for (byte b = 0; b < i; b++)
      putChar(paramCharSequence.charAt(b)); 
    return this;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\AbstractHasher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */