package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
  public boolean contains(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof Map.Entry;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      V v = map().get(paramObject.getKey());
      bool = bool1;
      if (v != null) {
        bool = bool1;
        if (v.equals(paramObject.getValue()))
          bool = true; 
      } 
      return bool;
    } 
    return false;
  }
  
  public int hashCode() {
    return map().hashCode();
  }
  
  @GwtIncompatible
  boolean isHashCodeFast() {
    return map().isHashCodeFast();
  }
  
  boolean isPartialView() {
    return map().isPartialView();
  }
  
  abstract ImmutableMap<K, V> map();
  
  public int size() {
    return map().size();
  }
  
  @GwtIncompatible
  Object writeReplace() {
    return new EntrySetSerializedForm<K, V>(map());
  }
  
  @GwtIncompatible
  private static class EntrySetSerializedForm<K, V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final ImmutableMap<K, V> map;
    
    EntrySetSerializedForm(ImmutableMap<K, V> param1ImmutableMap) {
      this.map = param1ImmutableMap;
    }
    
    Object readResolve() {
      return this.map.entrySet();
    }
  }
  
  static final class RegularEntrySet<K, V> extends ImmutableMapEntrySet<K, V> {
    private final transient Map.Entry<K, V>[] entries;
    
    @Weak
    private final transient ImmutableMap<K, V> map;
    
    RegularEntrySet(ImmutableMap<K, V> param1ImmutableMap, Map.Entry<K, V>[] param1ArrayOfEntry) {
      this.map = param1ImmutableMap;
      this.entries = param1ArrayOfEntry;
    }
    
    ImmutableList<Map.Entry<K, V>> createAsList() {
      return new RegularImmutableAsList<Map.Entry<K, V>>(this, (Object[])this.entries);
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
      return Iterators.forArray(this.entries);
    }
    
    ImmutableMap<K, V> map() {
      return this.map;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableMapEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */