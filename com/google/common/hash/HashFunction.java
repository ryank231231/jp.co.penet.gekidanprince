package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.nio.charset.Charset;

@Beta
public interface HashFunction {
  int bits();
  
  HashCode hashBytes(byte[] paramArrayOfbyte);
  
  HashCode hashBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  HashCode hashInt(int paramInt);
  
  HashCode hashLong(long paramLong);
  
  <T> HashCode hashObject(T paramT, Funnel<? super T> paramFunnel);
  
  HashCode hashString(CharSequence paramCharSequence, Charset paramCharset);
  
  HashCode hashUnencodedChars(CharSequence paramCharSequence);
  
  Hasher newHasher();
  
  Hasher newHasher(int paramInt);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\HashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */