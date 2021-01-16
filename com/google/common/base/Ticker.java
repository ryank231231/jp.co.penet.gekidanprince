package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@GwtCompatible
public abstract class Ticker {
  private static final Ticker SYSTEM_TICKER = new Ticker() {
      public long read() {
        return Platform.systemNanoTime();
      }
    };
  
  public static Ticker systemTicker() {
    return SYSTEM_TICKER;
  }
  
  @CanIgnoreReturnValue
  public abstract long read();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Ticker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */