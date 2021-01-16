package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

@Beta
@CanIgnoreReturnValue
public interface PrimitiveSink {
  PrimitiveSink putBoolean(boolean paramBoolean);
  
  PrimitiveSink putByte(byte paramByte);
  
  PrimitiveSink putBytes(byte[] paramArrayOfbyte);
  
  PrimitiveSink putBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  PrimitiveSink putChar(char paramChar);
  
  PrimitiveSink putDouble(double paramDouble);
  
  PrimitiveSink putFloat(float paramFloat);
  
  PrimitiveSink putInt(int paramInt);
  
  PrimitiveSink putLong(long paramLong);
  
  PrimitiveSink putShort(short paramShort);
  
  PrimitiveSink putString(CharSequence paramCharSequence, Charset paramCharset);
  
  PrimitiveSink putUnencodedChars(CharSequence paramCharSequence);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\PrimitiveSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */