package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@Deprecated
@Beta
@GwtCompatible
public interface MapConstraint<K, V> {
  void checkKeyValue(@Nullable K paramK, @Nullable V paramV);
  
  String toString();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MapConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */