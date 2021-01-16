package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof Map.Entry;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (Objects.equal(getKey(), paramObject.getKey())) {
        bool = bool1;
        if (Objects.equal(getValue(), paramObject.getValue()))
          bool = true; 
      } 
      return bool;
    } 
    return false;
  }
  
  public abstract K getKey();
  
  public abstract V getValue();
  
  public int hashCode() {
    int j;
    K k = getKey();
    V v = getValue();
    int i = 0;
    if (k == null) {
      j = 0;
    } else {
      j = k.hashCode();
    } 
    if (v != null)
      i = v.hashCode(); 
    return j ^ i;
  }
  
  public V setValue(V paramV) {
    throw new UnsupportedOperationException();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getKey());
    stringBuilder.append("=");
    stringBuilder.append(getValue());
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */