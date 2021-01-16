package com.google.firebase.inappmessaging.internal.vendored;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible(serializable = true)
public class SystemClock implements Clock {
  @CanIgnoreReturnValue
  public long now() {
    return System.currentTimeMillis();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\vendored\SystemClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */