package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  final K key;
  
  final V value;
  
  ImmutableEntry(@Nullable K paramK, @Nullable V paramV) {
    this.key = paramK;
    this.value = paramV;
  }
  
  @Nullable
  public final K getKey() {
    return this.key;
  }
  
  @Nullable
  public final V getValue() {
    return this.value;
  }
  
  public final V setValue(V paramV) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */