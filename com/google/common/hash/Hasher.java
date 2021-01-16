package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

@Beta
@CanIgnoreReturnValue
public interface Hasher extends PrimitiveSink {
  HashCode hash();
  
  @Deprecated
  int hashCode();
  
  Hasher putBoolean(boolean paramBoolean);
  
  Hasher putByte(byte paramByte);
  
  Hasher putBytes(byte[] paramArrayOfbyte);
  
  Hasher putBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  Hasher putChar(char paramChar);
  
  Hasher putDouble(double paramDouble);
  
  Hasher putFloat(float paramFloat);
  
  Hasher putInt(int paramInt);
  
  Hasher putLong(long paramLong);
  
  <T> Hasher putObject(T paramT, Funnel<? super T> paramFunnel);
  
  Hasher putShort(short paramShort);
  
  Hasher putString(CharSequence paramCharSequence, Charset paramCharset);
  
  Hasher putUnencodedChars(CharSequence paramCharSequence);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\Hasher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */