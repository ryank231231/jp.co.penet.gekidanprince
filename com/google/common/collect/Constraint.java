package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
interface Constraint<E> {
  @CanIgnoreReturnValue
  E checkElement(E paramE);
  
  String toString();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Constraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */