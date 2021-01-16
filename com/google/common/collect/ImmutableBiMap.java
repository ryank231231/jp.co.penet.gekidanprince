package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {
  public static <K, V> Builder<K, V> builder() {
    return new Builder<K, V>();
  }
  
  @Beta
  public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
    Map.Entry entry;
    Map.Entry[] arrayOfEntry = Iterables.<Map.Entry>toArray((Iterable)paramIterable, (Map.Entry[])EMPTY_ENTRY_ARRAY);
    switch (arrayOfEntry.length) {
      default:
        return RegularImmutableBiMap.fromEntries((Map.Entry<K, V>[])arrayOfEntry);
      case 1:
        entry = arrayOfEntry[0];
        return of((K)entry.getKey(), (V)entry.getValue());
      case 0:
        break;
    } 
    return of();
  }
  
  public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap) {
    if (paramMap instanceof ImmutableBiMap) {
      ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap)paramMap;
      if (!immutableBiMap.isPartialView())
        return immutableBiMap; 
    } 
    return copyOf(paramMap.entrySet());
  }
  
  public static <K, V> ImmutableBiMap<K, V> of() {
    return (ImmutableBiMap)RegularImmutableBiMap.EMPTY;
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK, V paramV) {
    return new SingletonImmutableBiMap<K, V>(paramK, paramV);
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2) {
    return RegularImmutableBiMap.fromEntries((Map.Entry<K, V>[])new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
    return RegularImmutableBiMap.fromEntries((Map.Entry<K, V>[])new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
    return RegularImmutableBiMap.fromEntries((Map.Entry<K, V>[])new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
    return RegularImmutableBiMap.fromEntries((Map.Entry<K, V>[])new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4), entryOf(paramK5, paramV5) });
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public V forcePut(K paramK, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  public abstract ImmutableBiMap<V, K> inverse();
  
  public ImmutableSet<V> values() {
    return inverse().keySet();
  }
  
  Object writeReplace() {
    return new SerializedForm(this);
  }
  
  public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
    public Builder() {}
    
    Builder(int param1Int) {
      super(param1Int);
    }
    
    public ImmutableBiMap<K, V> build() {
      int i = this.size;
      boolean bool = false;
      switch (i) {
        default:
          if (this.valueComparator != null) {
            if (this.entriesUsed)
              this.entries = ObjectArrays.<ImmutableMapEntry<K, V>>arraysCopyOf(this.entries, this.size); 
            Arrays.sort(this.entries, 0, this.size, Ordering.<V>from(this.valueComparator).onResultOf(Maps.valueFunction()));
            if (this.size == this.entries.length)
              bool = true; 
            this.entriesUsed = bool;
            return RegularImmutableBiMap.fromEntryArray(this.size, (Map.Entry<K, V>[])this.entries);
          } 
          break;
        case 1:
          return ImmutableBiMap.of(this.entries[0].getKey(), this.entries[0].getValue());
        case 0:
          return ImmutableBiMap.of();
      } 
      if (this.size == this.entries.length)
        bool = true; 
      this.entriesUsed = bool;
      return RegularImmutableBiMap.fromEntryArray(this.size, (Map.Entry<K, V>[])this.entries);
    }
    
    @Beta
    @CanIgnoreReturnValue
    public Builder<K, V> orderEntriesByValue(Comparator<? super V> param1Comparator) {
      super.orderEntriesByValue(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(K param1K, V param1V) {
      super.put(param1K, param1V);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> param1Entry) {
      super.put(param1Entry);
      return this;
    }
    
    @Beta
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
      super.putAll(param1Iterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Map<? extends K, ? extends V> param1Map) {
      super.putAll(param1Map);
      return this;
    }
  }
  
  private static class SerializedForm extends ImmutableMap.SerializedForm {
    private static final long serialVersionUID = 0L;
    
    SerializedForm(ImmutableBiMap<?, ?> param1ImmutableBiMap) {
      super(param1ImmutableBiMap);
    }
    
    Object readResolve() {
      return createMap(new ImmutableBiMap.Builder<Object, Object>());
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */