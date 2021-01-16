package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
  protected abstract Map.Entry<K, V> delegate();
  
  public boolean equals(@Nullable Object paramObject) {
    return delegate().equals(paramObject);
  }
  
  public K getKey() {
    return delegate().getKey();
  }
  
  public V getValue() {
    return delegate().getValue();
  }
  
  public int hashCode() {
    return delegate().hashCode();
  }
  
  public V setValue(V paramV) {
    return delegate().setValue(paramV);
  }
  
  protected boolean standardEquals(@Nullable Object paramObject) {
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
  
  protected int standardHashCode() {
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
  
  @Beta
  protected String standardToString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getKey());
    stringBuilder.append("=");
    stringBuilder.append(getValue());
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */