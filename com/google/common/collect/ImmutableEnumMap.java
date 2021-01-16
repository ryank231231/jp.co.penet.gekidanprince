package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
  private final transient EnumMap<K, V> delegate;
  
  private ImmutableEnumMap(EnumMap<K, V> paramEnumMap) {
    this.delegate = paramEnumMap;
    Preconditions.checkArgument(paramEnumMap.isEmpty() ^ true);
  }
  
  static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> paramEnumMap) {
    Map.Entry entry;
    switch (paramEnumMap.size()) {
      default:
        return new ImmutableEnumMap<K, V>(paramEnumMap);
      case 1:
        entry = Iterables.<Map.Entry>getOnlyElement((Iterable)paramEnumMap.entrySet());
        return ImmutableMap.of((K)entry.getKey(), (V)entry.getValue());
      case 0:
        break;
    } 
    return ImmutableMap.of();
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    return this.delegate.containsKey(paramObject);
  }
  
  UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
    return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
  }
  
  public boolean equals(Object<K, V> paramObject) {
    if (paramObject == this)
      return true; 
    Object<K, V> object = paramObject;
    if (paramObject instanceof ImmutableEnumMap)
      object = (Object<K, V>)((ImmutableEnumMap)paramObject).delegate; 
    return this.delegate.equals(object);
  }
  
  public V get(Object paramObject) {
    return this.delegate.get(paramObject);
  }
  
  boolean isPartialView() {
    return false;
  }
  
  UnmodifiableIterator<K> keyIterator() {
    return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
  }
  
  public int size() {
    return this.delegate.size();
  }
  
  Object writeReplace() {
    return new EnumSerializedForm<K, V>(this.delegate);
  }
  
  private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final EnumMap<K, V> delegate;
    
    EnumSerializedForm(EnumMap<K, V> param1EnumMap) {
      this.delegate = param1EnumMap;
    }
    
    Object readResolve() {
      return new ImmutableEnumMap<Enum, Object>(this.delegate);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableEnumMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */