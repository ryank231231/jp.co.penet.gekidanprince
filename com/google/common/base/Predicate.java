package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public interface Predicate<T> {
  @CanIgnoreReturnValue
  boolean apply(@Nullable T paramT);
  
  boolean equals(@Nullable Object paramObject);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Predicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */