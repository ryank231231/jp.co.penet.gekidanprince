package com.google.firebase.inappmessaging.internal.vendored;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
public interface Clock {
  @CanIgnoreReturnValue
  long now();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\vendored\Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */