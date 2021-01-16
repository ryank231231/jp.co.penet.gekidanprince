package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class Platform {
  private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() {
      protected char[] initialValue() {
        return new char[1024];
      }
    };
  
  static char[] charBufferFromThreadLocal() {
    return DEST_TL.get();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */