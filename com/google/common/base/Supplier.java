package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
public interface Supplier<T> {
  @CanIgnoreReturnValue
  T get();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Supplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */