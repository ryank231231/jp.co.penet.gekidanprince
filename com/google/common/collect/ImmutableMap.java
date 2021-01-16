package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
  static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = (Map.Entry<?, ?>[])new Map.Entry[0];
  
  @LazyInit
  private transient ImmutableSet<Map.Entry<K, V>> entrySet;
  
  @LazyInit
  private transient ImmutableSet<K> keySet;
  
  @LazyInit
  private transient ImmutableSetMultimap<K, V> multimapView;
  
  @LazyInit
  private transient ImmutableCollection<V> values;
  
  public static <K, V> Builder<K, V> builder() {
    return new Builder<K, V>();
  }
  
  static void checkNoConflict(boolean paramBoolean, String paramString, Map.Entry<?, ?> paramEntry1, Map.Entry<?, ?> paramEntry2) {
    if (paramBoolean)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Multiple entries with same ");
    stringBuilder.append(paramString);
    stringBuilder.append(": ");
    stringBuilder.append(paramEntry1);
    stringBuilder.append(" and ");
    stringBuilder.append(paramEntry2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  @Beta
  public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
    Map.Entry entry;
    Map.Entry[] arrayOfEntry = Iterables.<Map.Entry>toArray((Iterable)paramIterable, (Map.Entry[])EMPTY_ENTRY_ARRAY);
    switch (arrayOfEntry.length) {
      default:
        return RegularImmutableMap.fromEntries((Map.Entry<K, V>[])arrayOfEntry);
      case 1:
        entry = arrayOfEntry[0];
        return of((K)entry.getKey(), (V)entry.getValue());
      case 0:
        break;
    } 
    return of();
  }
  
  public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap) {
    if (paramMap instanceof ImmutableMap && !(paramMap instanceof ImmutableSortedMap)) {
      ImmutableMap<K, V> immutableMap = (ImmutableMap)paramMap;
      if (!immutableMap.isPartialView())
        return immutableMap; 
    } else if (paramMap instanceof EnumMap) {
      return (ImmutableMap)copyOfEnumMap((EnumMap)paramMap);
    } 
    return copyOf(paramMap.entrySet());
  }
  
  private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(EnumMap<K, ? extends V> paramEnumMap) {
    EnumMap<K, V> enumMap = new EnumMap<K, V>(paramEnumMap);
    for (Map.Entry<K, V> entry : enumMap.entrySet())
      CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue()); 
    return ImmutableEnumMap.asImmutable(enumMap);
  }
  
  static <K, V> ImmutableMapEntry<K, V> entryOf(K paramK, V paramV) {
    return new ImmutableMapEntry<K, V>(paramK, paramV);
  }
  
  public static <K, V> ImmutableMap<K, V> of() {
    return ImmutableBiMap.of();
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK, V paramV) {
    return ImmutableBiMap.of(paramK, paramV);
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2) {
    return RegularImmutableMap.fromEntries((Map.Entry<K, V>[])new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
    return RegularImmutableMap.fromEntries((Map.Entry<K, V>[])new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
    return RegularImmutableMap.fromEntries((Map.Entry<K, V>[])new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
    return RegularImmutableMap.fromEntries((Map.Entry<K, V>[])new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4), entryOf(paramK5, paramV5) });
  }
  
  public ImmutableSetMultimap<K, V> asMultimap() {
    if (isEmpty())
      return ImmutableSetMultimap.of(); 
    ImmutableSetMultimap<K, V> immutableSetMultimap1 = this.multimapView;
    ImmutableSetMultimap<K, V> immutableSetMultimap2 = immutableSetMultimap1;
    if (immutableSetMultimap1 == null) {
      immutableSetMultimap2 = new ImmutableSetMultimap<K, V>(new MapViewOfValuesAsSingletonSets(), size(), null);
      this.multimapView = immutableSetMultimap2;
    } 
    return immutableSetMultimap2;
  }
  
  @Deprecated
  public final void clear() {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    boolean bool;
    if (get(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    return values().contains(paramObject);
  }
  
  abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();
  
  ImmutableSet<K> createKeySet() {
    ImmutableSet<?> immutableSet;
    if (isEmpty()) {
      immutableSet = ImmutableSet.of();
    } else {
      immutableSet = new ImmutableMapKeySet<Object, Object>(this);
    } 
    return (ImmutableSet)immutableSet;
  }
  
  ImmutableCollection<V> createValues() {
    return new ImmutableMapValues<Object, V>(this);
  }
  
  public ImmutableSet<Map.Entry<K, V>> entrySet() {
    ImmutableSet<Map.Entry<K, V>> immutableSet1 = this.entrySet;
    ImmutableSet<Map.Entry<K, V>> immutableSet2 = immutableSet1;
    if (immutableSet1 == null) {
      immutableSet2 = createEntrySet();
      this.entrySet = immutableSet2;
    } 
    return immutableSet2;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return Maps.equalsImpl(this, paramObject);
  }
  
  public abstract V get(@Nullable Object paramObject);
  
  public int hashCode() {
    return Sets.hashCodeImpl(entrySet());
  }
  
  public boolean isEmpty() {
    boolean bool;
    if (size() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean isHashCodeFast() {
    return false;
  }
  
  abstract boolean isPartialView();
  
  UnmodifiableIterator<K> keyIterator() {
    return new UnmodifiableIterator<K>() {
        public boolean hasNext() {
          return entryIterator.hasNext();
        }
        
        public K next() {
          return (K)((Map.Entry)entryIterator.next()).getKey();
        }
      };
  }
  
  public ImmutableSet<K> keySet() {
    ImmutableSet<K> immutableSet1 = this.keySet;
    ImmutableSet<K> immutableSet2 = immutableSet1;
    if (immutableSet1 == null) {
      immutableSet2 = createKeySet();
      this.keySet = immutableSet2;
    } 
    return immutableSet2;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final V put(K paramK, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map<? extends K, ? extends V> paramMap) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final V remove(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public String toString() {
    return Maps.toStringImpl(this);
  }
  
  public ImmutableCollection<V> values() {
    ImmutableCollection<V> immutableCollection1 = this.values;
    ImmutableCollection<V> immutableCollection2 = immutableCollection1;
    if (immutableCollection1 == null) {
      immutableCollection2 = createValues();
      this.values = immutableCollection2;
    } 
    return immutableCollection2;
  }
  
  Object writeReplace() {
    return new SerializedForm(this);
  }
  
  public static class Builder<K, V> {
    ImmutableMapEntry<K, V>[] entries;
    
    boolean entriesUsed;
    
    int size;
    
    Comparator<? super V> valueComparator;
    
    public Builder() {
      this(4);
    }
    
    Builder(int param1Int) {
      this.entries = (ImmutableMapEntry<K, V>[])new ImmutableMapEntry[param1Int];
      this.size = 0;
      this.entriesUsed = false;
    }
    
    private void ensureCapacity(int param1Int) {
      ImmutableMapEntry<K, V>[] arrayOfImmutableMapEntry = this.entries;
      if (param1Int > arrayOfImmutableMapEntry.length) {
        this.entries = ObjectArrays.<ImmutableMapEntry<K, V>>arraysCopyOf(arrayOfImmutableMapEntry, ImmutableCollection.Builder.expandedCapacity(arrayOfImmutableMapEntry.length, param1Int));
        this.entriesUsed = false;
      } 
    }
    
    public ImmutableMap<K, V> build() {
      int i = this.size;
      boolean bool = false;
      switch (i) {
        default:
          if (this.valueComparator != null) {
            if (this.entriesUsed)
              this.entries = ObjectArrays.<ImmutableMapEntry<K, V>>arraysCopyOf(this.entries, i); 
            Arrays.sort(this.entries, 0, this.size, Ordering.<V>from(this.valueComparator).onResultOf(Maps.valueFunction()));
            if (this.size == this.entries.length)
              bool = true; 
            this.entriesUsed = bool;
            return RegularImmutableMap.fromEntryArray(this.size, (Map.Entry<K, V>[])this.entries);
          } 
          break;
        case 1:
          return ImmutableMap.of(this.entries[0].getKey(), this.entries[0].getValue());
        case 0:
          return ImmutableMap.of();
      } 
      if (this.size == this.entries.length)
        bool = true; 
      this.entriesUsed = bool;
      return RegularImmutableMap.fromEntryArray(this.size, (Map.Entry<K, V>[])this.entries);
    }
    
    @Beta
    @CanIgnoreReturnValue
    public Builder<K, V> orderEntriesByValue(Comparator<? super V> param1Comparator) {
      boolean bool;
      if (this.valueComparator == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "valueComparator was already set");
      this.valueComparator = (Comparator<? super V>)Preconditions.checkNotNull(param1Comparator, "valueComparator");
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(K param1K, V param1V) {
      ensureCapacity(this.size + 1);
      ImmutableMapEntry<K, V> immutableMapEntry = ImmutableMap.entryOf(param1K, param1V);
      ImmutableMapEntry<K, V>[] arrayOfImmutableMapEntry = this.entries;
      int i = this.size;
      this.size = i + 1;
      arrayOfImmutableMapEntry[i] = immutableMapEntry;
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> param1Entry) {
      return put(param1Entry.getKey(), param1Entry.getValue());
    }
    
    @Beta
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
      if (param1Iterable instanceof Collection)
        ensureCapacity(this.size + ((Collection)param1Iterable).size()); 
      Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        put(iterator.next()); 
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Map<? extends K, ? extends V> param1Map) {
      return putAll(param1Map.entrySet());
    }
  }
  
  static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
      class EntrySetImpl extends ImmutableMapEntrySet<K, V> {
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
          return ImmutableMap.IteratorBasedImmutableMap.this.entryIterator();
        }
        
        ImmutableMap<K, V> map() {
          return ImmutableMap.IteratorBasedImmutableMap.this;
        }
      };
      return new EntrySetImpl();
    }
    
    abstract UnmodifiableIterator<Map.Entry<K, V>> entryIterator();
  }
  
  class EntrySetImpl extends ImmutableMapEntrySet<K, V> {
    public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
      return this.this$0.entryIterator();
    }
    
    ImmutableMap<K, V> map() {
      return this.this$0;
    }
  }
  
  private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
    private MapViewOfValuesAsSingletonSets() {}
    
    public boolean containsKey(@Nullable Object param1Object) {
      return ImmutableMap.this.containsKey(param1Object);
    }
    
    UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
      return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>() {
          public boolean hasNext() {
            return backingIterator.hasNext();
          }
          
          public Map.Entry<K, ImmutableSet<V>> next() {
            return (Map.Entry)new AbstractMapEntry<K, ImmutableSet<ImmutableSet<V>>>() {
                public K getKey() {
                  return (K)backingEntry.getKey();
                }
                
                public ImmutableSet<V> getValue() {
                  return ImmutableSet.of((V)backingEntry.getValue());
                }
              };
          }
        };
    }
    
    public ImmutableSet<V> get(@Nullable Object param1Object) {
      param1Object = ImmutableMap.this.get(param1Object);
      if (param1Object == null) {
        param1Object = null;
      } else {
        param1Object = ImmutableSet.of(param1Object);
      } 
      return (ImmutableSet<V>)param1Object;
    }
    
    public int hashCode() {
      return ImmutableMap.this.hashCode();
    }
    
    boolean isHashCodeFast() {
      return ImmutableMap.this.isHashCodeFast();
    }
    
    boolean isPartialView() {
      return ImmutableMap.this.isPartialView();
    }
    
    public ImmutableSet<K> keySet() {
      return ImmutableMap.this.keySet();
    }
    
    public int size() {
      return ImmutableMap.this.size();
    }
  }
  
  class null extends UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> {
    public boolean hasNext() {
      return backingIterator.hasNext();
    }
    
    public Map.Entry<K, ImmutableSet<V>> next() {
      return (Map.Entry)new AbstractMapEntry<K, ImmutableSet<ImmutableSet<V>>>() {
          public K getKey() {
            return (K)backingEntry.getKey();
          }
          
          public ImmutableSet<V> getValue() {
            return ImmutableSet.of((V)backingEntry.getValue());
          }
        };
    }
  }
  
  class null extends AbstractMapEntry<K, ImmutableSet<V>> {
    public K getKey() {
      return (K)backingEntry.getKey();
    }
    
    public ImmutableSet<V> getValue() {
      return ImmutableSet.of((V)backingEntry.getValue());
    }
  }
  
  static class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Object[] keys;
    
    private final Object[] values;
    
    SerializedForm(ImmutableMap<?, ?> param1ImmutableMap) {
      this.keys = new Object[param1ImmutableMap.size()];
      this.values = new Object[param1ImmutableMap.size()];
      Iterator<Map.Entry> iterator = param1ImmutableMap.entrySet().iterator();
      for (byte b = 0; iterator.hasNext(); b++) {
        Map.Entry entry = iterator.next();
        this.keys[b] = entry.getKey();
        this.values[b] = entry.getValue();
      } 
    }
    
    Object createMap(ImmutableMap.Builder<Object, Object> param1Builder) {
      byte b = 0;
      while (true) {
        Object[] arrayOfObject = this.keys;
        if (b < arrayOfObject.length) {
          param1Builder.put(arrayOfObject[b], this.values[b]);
          b++;
          continue;
        } 
        return param1Builder.build();
      } 
    }
    
    Object readResolve() {
      return createMap(new ImmutableMap.Builder<Object, Object>(this.keys.length));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */