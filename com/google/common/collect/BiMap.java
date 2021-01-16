package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface BiMap<K, V> extends Map<K, V> {
  @Nullable
  @CanIgnoreReturnValue
  V forcePut(@Nullable K paramK, @Nullable V paramV);
  
  BiMap<V, K> inverse();
  
  @Nullable
  @CanIgnoreReturnValue
  V put(@Nullable K paramK, @Nullable V paramV);
  
  void putAll(Map<? extends K, ? extends V> paramMap);
  
  Set<V> values();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\BiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */