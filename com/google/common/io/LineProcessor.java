package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@Beta
@GwtIncompatible
public interface LineProcessor<T> {
  T getResult();
  
  @CanIgnoreReturnValue
  boolean processLine(String paramString) throws IOException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\LineProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */