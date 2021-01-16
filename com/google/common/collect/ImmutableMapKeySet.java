package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class ImmutableMapKeySet<K, V> extends ImmutableSet.Indexed<K> {
  @Weak
  private final ImmutableMap<K, V> map;
  
  ImmutableMapKeySet(ImmutableMap<K, V> paramImmutableMap) {
    this.map = paramImmutableMap;
  }
  
  public boolean contains(@Nullable Object paramObject) {
    return this.map.containsKey(paramObject);
  }
  
  K get(int paramInt) {
    return (K)((Map.Entry)this.map.entrySet().asList().get(paramInt)).getKey();
  }
  
  boolean isPartialView() {
    return true;
  }
  
  public UnmodifiableIterator<K> iterator() {
    return this.map.keyIterator();
  }
  
  public int size() {
    return this.map.size();
  }
  
  @GwtIncompatible
  Object writeReplace() {
    return new KeySetSerializedForm<K>(this.map);
  }
  
  @GwtIncompatible
  private static class KeySetSerializedForm<K> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final ImmutableMap<K, ?> map;
    
    KeySetSerializedForm(ImmutableMap<K, ?> param1ImmutableMap) {
      this.map = param1ImmutableMap;
    }
    
    Object readResolve() {
      return this.map.keySet();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableMapKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */