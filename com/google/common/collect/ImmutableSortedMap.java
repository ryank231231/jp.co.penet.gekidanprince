package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
  private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP;
  
  private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
  
  private static final long serialVersionUID = 0L;
  
  private transient ImmutableSortedMap<K, V> descendingMap;
  
  private final transient RegularImmutableSortedSet<K> keySet;
  
  private final transient ImmutableList<V> valueList;
  
  static {
    NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
  }
  
  ImmutableSortedMap(RegularImmutableSortedSet<K> paramRegularImmutableSortedSet, ImmutableList<V> paramImmutableList) {
    this(paramRegularImmutableSortedSet, paramImmutableList, (ImmutableSortedMap<K, V>)null);
  }
  
  ImmutableSortedMap(RegularImmutableSortedSet<K> paramRegularImmutableSortedSet, ImmutableList<V> paramImmutableList, ImmutableSortedMap<K, V> paramImmutableSortedMap) {
    this.keySet = paramRegularImmutableSortedSet;
    this.valueList = paramImmutableList;
    this.descendingMap = paramImmutableSortedMap;
  }
  
  @Beta
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
    return copyOf(paramIterable, (Ordering)NATURAL_ORDER);
  }
  
  @Beta
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable, Comparator<? super K> paramComparator) {
    return fromEntries((Comparator<? super K>)Preconditions.checkNotNull(paramComparator), false, paramIterable);
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap) {
    return copyOfInternal(paramMap, (Ordering)NATURAL_ORDER);
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator) {
    return copyOfInternal(paramMap, (Comparator<? super K>)Preconditions.checkNotNull(paramComparator));
  }
  
  private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator) {
    boolean bool1 = paramMap instanceof SortedMap;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1) {
      Comparator comparator = ((SortedMap)paramMap).comparator();
      if (comparator == null) {
        bool3 = bool2;
        if (paramComparator == NATURAL_ORDER)
          bool3 = true; 
      } else {
        bool3 = paramComparator.equals(comparator);
      } 
    } 
    if (bool3 && paramMap instanceof ImmutableSortedMap) {
      ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap)paramMap;
      if (!immutableSortedMap.isPartialView())
        return immutableSortedMap; 
    } 
    return fromEntries(paramComparator, bool3, paramMap.entrySet());
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> paramSortedMap) {
    Comparator<Comparable> comparator;
    Comparator<? super K> comparator1 = paramSortedMap.comparator();
    Comparator<? super K> comparator2 = comparator1;
    if (comparator1 == null)
      comparator = NATURAL_ORDER; 
    if (paramSortedMap instanceof ImmutableSortedMap) {
      ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap)paramSortedMap;
      if (!immutableSortedMap.isPartialView())
        return immutableSortedMap; 
    } 
    return fromEntries((Comparator)comparator, true, paramSortedMap.entrySet());
  }
  
  static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> paramComparator) {
    return Ordering.<Comparable>natural().equals(paramComparator) ? of() : new ImmutableSortedMap<K, V>(ImmutableSortedSet.emptySet(paramComparator), ImmutableList.of());
  }
  
  private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> paramComparator, boolean paramBoolean, Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
    Map.Entry[] arrayOfEntry = Iterables.<Map.Entry>toArray((Iterable)paramIterable, (Map.Entry[])EMPTY_ENTRY_ARRAY);
    return fromEntries(paramComparator, paramBoolean, (Map.Entry<K, V>[])arrayOfEntry, arrayOfEntry.length);
  }
  
  private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> paramComparator, boolean paramBoolean, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt) {
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    byte b = 0;
    switch (paramInt) {
      default:
        arrayOfObject1 = new Object[paramInt];
        arrayOfObject2 = new Object[paramInt];
        if (paramBoolean) {
          while (b < paramInt) {
            K k1 = paramArrayOfEntry[b].getKey();
            V v = paramArrayOfEntry[b].getValue();
            CollectPreconditions.checkEntryNotNull(k1, v);
            arrayOfObject1[b] = k1;
            arrayOfObject2[b] = v;
            b++;
          } 
          return new ImmutableSortedMap<K, V>(new RegularImmutableSortedSet<K>(new RegularImmutableList<K>(arrayOfObject1), paramComparator), new RegularImmutableList<V>(arrayOfObject2));
        } 
        break;
      case 1:
        return of(paramComparator, paramArrayOfEntry[0].getKey(), paramArrayOfEntry[0].getValue());
      case 0:
        return emptyMap(paramComparator);
    } 
    Arrays.sort(paramArrayOfEntry, 0, paramInt, Ordering.<K>from(paramComparator).onKeys());
    K k = paramArrayOfEntry[0].getKey();
    arrayOfObject1[0] = k;
    arrayOfObject2[0] = paramArrayOfEntry[0].getValue();
    b = 1;
    while (b < paramInt) {
      K k1 = paramArrayOfEntry[b].getKey();
      V v = paramArrayOfEntry[b].getValue();
      CollectPreconditions.checkEntryNotNull(k1, v);
      arrayOfObject1[b] = k1;
      arrayOfObject2[b] = v;
      if (paramComparator.compare(k, k1) != 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      checkNoConflict(paramBoolean, "key", paramArrayOfEntry[b - 1], paramArrayOfEntry[b]);
      b++;
      K k2 = k1;
    } 
    return new ImmutableSortedMap<K, V>(new RegularImmutableSortedSet<K>(new RegularImmutableList<K>(arrayOfObject1), paramComparator), new RegularImmutableList<V>(arrayOfObject2));
  }
  
  private ImmutableSortedMap<K, V> getSubMap(int paramInt1, int paramInt2) {
    return (paramInt1 == 0 && paramInt2 == size()) ? this : ((paramInt1 == paramInt2) ? emptyMap(comparator()) : new ImmutableSortedMap(this.keySet.getSubSet(paramInt1, paramInt2), this.valueList.subList(paramInt1, paramInt2)));
  }
  
  public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
    return new Builder<K, V>(Ordering.natural());
  }
  
  public static <K, V> ImmutableSortedMap<K, V> of() {
    return (ImmutableSortedMap)NATURAL_EMPTY_MAP;
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK, V paramV) {
    return of(Ordering.natural(), paramK, paramV);
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2) {
    return ofEntries((ImmutableMapEntry<K, V>[])new ImmutableMapEntry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
    return ofEntries((ImmutableMapEntry<K, V>[])new ImmutableMapEntry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
    return ofEntries((ImmutableMapEntry<K, V>[])new ImmutableMapEntry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
    return ofEntries((ImmutableMapEntry<K, V>[])new ImmutableMapEntry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4), entryOf(paramK5, paramV5) });
  }
  
  private static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> paramComparator, K paramK, V paramV) {
    return new ImmutableSortedMap<K, V>(new RegularImmutableSortedSet<K>(ImmutableList.of(paramK), (Comparator<? super K>)Preconditions.checkNotNull(paramComparator)), ImmutableList.of(paramV));
  }
  
  private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> ofEntries(ImmutableMapEntry<K, V>... paramVarArgs) {
    return fromEntries(Ordering.natural(), false, (Map.Entry<K, V>[])paramVarArgs, paramVarArgs.length);
  }
  
  public static <K, V> Builder<K, V> orderedBy(Comparator<K> paramComparator) {
    return new Builder<K, V>(paramComparator);
  }
  
  public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
    return new Builder<K, V>(Ordering.<Comparable>natural().reverse());
  }
  
  public Map.Entry<K, V> ceilingEntry(K paramK) {
    return tailMap(paramK, true).firstEntry();
  }
  
  public K ceilingKey(K paramK) {
    return Maps.keyOrNull(ceilingEntry(paramK));
  }
  
  public Comparator<? super K> comparator() {
    return keySet().comparator();
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet() {
    ImmutableSet<?> immutableSet;
    if (isEmpty()) {
      immutableSet = ImmutableSet.of();
    } else {
      class EntrySet extends ImmutableMapEntrySet<K, V> {
        ImmutableList<Map.Entry<K, V>> createAsList() {
          return new ImmutableAsList<Map.Entry<K, V>>() {
              ImmutableCollection<Map.Entry<K, V>> delegateCollection() {
                return ImmutableSortedMap.EntrySet.this;
              }
              
              public Map.Entry<K, V> get(int param2Int) {
                return Maps.immutableEntry(ImmutableSortedMap.this.keySet.asList().get(param2Int), (V)ImmutableSortedMap.this.valueList.get(param2Int));
              }
            };
        }
        
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
          return asList().iterator();
        }
        
        ImmutableMap<K, V> map() {
          return ImmutableSortedMap.this;
        }
      };
      immutableSet = new EntrySet();
    } 
    return (ImmutableSet)immutableSet;
  }
  
  public ImmutableSortedSet<K> descendingKeySet() {
    return this.keySet.descendingSet();
  }
  
  public ImmutableSortedMap<K, V> descendingMap() {
    ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
    return (immutableSortedMap == null) ? (isEmpty() ? emptyMap(Ordering.<K>from(comparator()).reverse()) : new ImmutableSortedMap((RegularImmutableSortedSet<K>)this.keySet.descendingSet(), this.valueList.reverse(), this)) : immutableSortedMap;
  }
  
  public ImmutableSet<Map.Entry<K, V>> entrySet() {
    return super.entrySet();
  }
  
  public Map.Entry<K, V> firstEntry() {
    Map.Entry<K, V> entry;
    if (isEmpty()) {
      entry = null;
    } else {
      entry = entrySet().asList().get(0);
    } 
    return entry;
  }
  
  public K firstKey() {
    return keySet().first();
  }
  
  public Map.Entry<K, V> floorEntry(K paramK) {
    return headMap(paramK, true).lastEntry();
  }
  
  public K floorKey(K paramK) {
    return Maps.keyOrNull(floorEntry(paramK));
  }
  
  public V get(@Nullable Object paramObject) {
    int i = this.keySet.indexOf(paramObject);
    if (i == -1) {
      paramObject = null;
    } else {
      paramObject = this.valueList.get(i);
    } 
    return (V)paramObject;
  }
  
  public ImmutableSortedMap<K, V> headMap(K paramK) {
    return headMap(paramK, false);
  }
  
  public ImmutableSortedMap<K, V> headMap(K paramK, boolean paramBoolean) {
    return getSubMap(0, this.keySet.headIndex((K)Preconditions.checkNotNull(paramK), paramBoolean));
  }
  
  public Map.Entry<K, V> higherEntry(K paramK) {
    return tailMap(paramK, false).firstEntry();
  }
  
  public K higherKey(K paramK) {
    return Maps.keyOrNull(higherEntry(paramK));
  }
  
  boolean isPartialView() {
    return (this.keySet.isPartialView() || this.valueList.isPartialView());
  }
  
  public ImmutableSortedSet<K> keySet() {
    return this.keySet;
  }
  
  public Map.Entry<K, V> lastEntry() {
    Map.Entry<K, V> entry;
    if (isEmpty()) {
      entry = null;
    } else {
      entry = entrySet().asList().get(size() - 1);
    } 
    return entry;
  }
  
  public K lastKey() {
    return keySet().last();
  }
  
  public Map.Entry<K, V> lowerEntry(K paramK) {
    return headMap(paramK, false).lastEntry();
  }
  
  public K lowerKey(K paramK) {
    return Maps.keyOrNull(lowerEntry(paramK));
  }
  
  public ImmutableSortedSet<K> navigableKeySet() {
    return this.keySet;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final Map.Entry<K, V> pollFirstEntry() {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final Map.Entry<K, V> pollLastEntry() {
    throw new UnsupportedOperationException();
  }
  
  public int size() {
    return this.valueList.size();
  }
  
  public ImmutableSortedMap<K, V> subMap(K paramK1, K paramK2) {
    return subMap(paramK1, true, paramK2, false);
  }
  
  public ImmutableSortedMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2) {
    boolean bool;
    Preconditions.checkNotNull(paramK1);
    Preconditions.checkNotNull(paramK2);
    if (comparator().compare(paramK1, paramK2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "expected fromKey <= toKey but %s > %s", paramK1, paramK2);
    return headMap(paramK2, paramBoolean2).tailMap(paramK1, paramBoolean1);
  }
  
  public ImmutableSortedMap<K, V> tailMap(K paramK) {
    return tailMap(paramK, true);
  }
  
  public ImmutableSortedMap<K, V> tailMap(K paramK, boolean paramBoolean) {
    return getSubMap(this.keySet.tailIndex((K)Preconditions.checkNotNull(paramK), paramBoolean), size());
  }
  
  public ImmutableCollection<V> values() {
    return this.valueList;
  }
  
  Object writeReplace() {
    return new SerializedForm(this);
  }
  
  public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
    private final Comparator<? super K> comparator;
    
    public Builder(Comparator<? super K> param1Comparator) {
      this.comparator = (Comparator<? super K>)Preconditions.checkNotNull(param1Comparator);
    }
    
    public ImmutableSortedMap<K, V> build() {
      switch (this.size) {
        default:
          return ImmutableSortedMap.fromEntries(this.comparator, false, (Map.Entry<K, V>[])this.entries, this.size);
        case 1:
          return ImmutableSortedMap.of(this.comparator, this.entries[0].getKey(), this.entries[0].getValue());
        case 0:
          break;
      } 
      return ImmutableSortedMap.emptyMap(this.comparator);
    }
    
    @Deprecated
    @Beta
    @CanIgnoreReturnValue
    public Builder<K, V> orderEntriesByValue(Comparator<? super V> param1Comparator) {
      throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
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
    
    private final Comparator<Object> comparator;
    
    SerializedForm(ImmutableSortedMap<?, ?> param1ImmutableSortedMap) {
      super(param1ImmutableSortedMap);
      this.comparator = (Comparator)param1ImmutableSortedMap.comparator();
    }
    
    Object readResolve() {
      return createMap(new ImmutableSortedMap.Builder<Object, Object>(this.comparator));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */