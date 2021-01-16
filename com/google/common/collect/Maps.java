package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Maps {
  static final Joiner.MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
  
  @Beta
  public static <A, B> Converter<A, B> asConverter(BiMap<A, B> paramBiMap) {
    return new BiMapConverter<A, B>(paramBiMap);
  }
  
  static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(final EntryTransformer<? super K, ? super V1, V2> transformer) {
    Preconditions.checkNotNull(transformer);
    return new Function<Map.Entry<K, V1>, Map.Entry<K, V2>>() {
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> param1Entry) {
          return Maps.transformEntry(transformer, param1Entry);
        }
      };
  }
  
  static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(final EntryTransformer<? super K, ? super V1, V2> transformer) {
    Preconditions.checkNotNull(transformer);
    return new Function<Map.Entry<K, V1>, V2>() {
        public V2 apply(Map.Entry<K, V1> param1Entry) {
          return (V2)transformer.transformEntry(param1Entry.getKey(), param1Entry.getValue());
        }
      };
  }
  
  static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(final Function<? super V1, V2> function) {
    Preconditions.checkNotNull(function);
    return new EntryTransformer<K, V1, V2>() {
        public V2 transformEntry(K param1K, V1 param1V1) {
          return (V2)function.apply(param1V1);
        }
      };
  }
  
  public static <K, V> Map<K, V> asMap(Set<K> paramSet, Function<? super K, V> paramFunction) {
    return new AsMapView<K, V>(paramSet, paramFunction);
  }
  
  @GwtIncompatible
  public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> paramNavigableSet, Function<? super K, V> paramFunction) {
    return new NavigableAsMapView<K, V>(paramNavigableSet, paramFunction);
  }
  
  public static <K, V> SortedMap<K, V> asMap(SortedSet<K> paramSortedSet, Function<? super K, V> paramFunction) {
    return new SortedAsMapView<K, V>(paramSortedSet, paramFunction);
  }
  
  static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> paramSet, final Function<? super K, V> function) {
    return new TransformedIterator<K, Map.Entry<K, V>>(paramSet.iterator()) {
        Map.Entry<K, V> transform(K param1K) {
          return Maps.immutableEntry(param1K, (V)function.apply(param1K));
        }
      };
  }
  
  static <K, V1, V2> Function<V1, V2> asValueToValueFunction(final EntryTransformer<? super K, V1, V2> transformer, final K key) {
    Preconditions.checkNotNull(transformer);
    return new Function<V1, V2>() {
        public V2 apply(@Nullable V1 param1V1) {
          return transformer.transformEntry(key, param1V1);
        }
      };
  }
  
  static int capacity(int paramInt) {
    if (paramInt < 3) {
      CollectPreconditions.checkNonnegative(paramInt, "expectedSize");
      return paramInt + 1;
    } 
    return (paramInt < 1073741824) ? (int)(paramInt / 0.75F + 1.0F) : Integer.MAX_VALUE;
  }
  
  static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> paramCollection, Object paramObject) {
    return !(paramObject instanceof Map.Entry) ? false : paramCollection.contains(unmodifiableEntry((Map.Entry<?, ?>)paramObject));
  }
  
  static boolean containsKeyImpl(Map<?, ?> paramMap, @Nullable Object paramObject) {
    return Iterators.contains(keyIterator(paramMap.entrySet().iterator()), paramObject);
  }
  
  static boolean containsValueImpl(Map<?, ?> paramMap, @Nullable Object paramObject) {
    return Iterators.contains(valueIterator(paramMap.entrySet().iterator()), paramObject);
  }
  
  public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2) {
    return (paramMap1 instanceof SortedMap) ? difference((SortedMap)paramMap1, paramMap2) : difference(paramMap1, paramMap2, Equivalence.equals());
  }
  
  public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2, Equivalence<? super V> paramEquivalence) {
    Preconditions.checkNotNull(paramEquivalence);
    LinkedHashMap<?, ?> linkedHashMap1 = newLinkedHashMap();
    LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<K, V>(paramMap2);
    LinkedHashMap<?, ?> linkedHashMap2 = newLinkedHashMap();
    LinkedHashMap<?, ?> linkedHashMap3 = newLinkedHashMap();
    doDifference(paramMap1, paramMap2, paramEquivalence, (Map)linkedHashMap1, linkedHashMap, (Map)linkedHashMap2, (Map)linkedHashMap3);
    return new MapDifferenceImpl<K, V>((Map)linkedHashMap1, linkedHashMap, (Map)linkedHashMap2, (Map)linkedHashMap3);
  }
  
  public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> paramSortedMap, Map<? extends K, ? extends V> paramMap) {
    Preconditions.checkNotNull(paramSortedMap);
    Preconditions.checkNotNull(paramMap);
    Comparator<?> comparator = orNaturalOrder(paramSortedMap.comparator());
    TreeMap<Object, ?> treeMap2 = newTreeMap(comparator);
    TreeMap<Object, ?> treeMap3 = newTreeMap(comparator);
    treeMap3.putAll(paramMap);
    TreeMap<Object, ?> treeMap4 = newTreeMap(comparator);
    TreeMap<Object, ?> treeMap1 = newTreeMap(comparator);
    doDifference(paramSortedMap, paramMap, Equivalence.equals(), (Map)treeMap2, (Map)treeMap3, (Map)treeMap4, (Map)treeMap1);
    return new SortedMapDifferenceImpl<K, V>((SortedMap)treeMap2, (SortedMap)treeMap3, (SortedMap)treeMap4, (SortedMap)treeMap1);
  }
  
  private static <K, V> void doDifference(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2, Equivalence<? super V> paramEquivalence, Map<K, V> paramMap3, Map<K, V> paramMap4, Map<K, V> paramMap5, Map<K, MapDifference.ValueDifference<V>> paramMap) {
    for (Map.Entry<? extends K, ? extends V> entry : paramMap1.entrySet()) {
      Object object1 = entry.getKey();
      Object object2 = entry.getValue();
      if (paramMap2.containsKey(object1)) {
        entry = (Map.Entry<? extends K, ? extends V>)paramMap4.remove(object1);
        if (paramEquivalence.equivalent(object2, entry)) {
          paramMap5.put((K)object1, (V)object2);
          continue;
        } 
        paramMap.put((K)object1, ValueDifferenceImpl.create((V)object2, (V)entry));
        continue;
      } 
      paramMap3.put((K)object1, (V)object2);
    } 
  }
  
  static boolean equalsImpl(Map<?, ?> paramMap, Object paramObject) {
    if (paramMap == paramObject)
      return true; 
    if (paramObject instanceof Map) {
      paramObject = paramObject;
      return paramMap.entrySet().equals(paramObject.entrySet());
    } 
    return false;
  }
  
  public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> paramBiMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    Preconditions.checkNotNull(paramBiMap);
    Preconditions.checkNotNull(paramPredicate);
    if (paramBiMap instanceof FilteredEntryBiMap) {
      paramBiMap = filterFiltered((FilteredEntryBiMap<K, V>)paramBiMap, paramPredicate);
    } else {
      paramBiMap = new FilteredEntryBiMap<K, V>(paramBiMap, paramPredicate);
    } 
    return paramBiMap;
  }
  
  public static <K, V> Map<K, V> filterEntries(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    if (paramMap instanceof AbstractFilteredMap) {
      paramMap = filterFiltered((AbstractFilteredMap<K, V>)paramMap, paramPredicate);
    } else {
      paramMap = new FilteredEntryMap<K, V>((Map<K, V>)Preconditions.checkNotNull(paramMap), paramPredicate);
    } 
    return paramMap;
  }
  
  @GwtIncompatible
  public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> paramNavigableMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    if (paramNavigableMap instanceof FilteredEntryNavigableMap) {
      paramNavigableMap = filterFiltered((FilteredEntryNavigableMap<K, V>)paramNavigableMap, paramPredicate);
    } else {
      paramNavigableMap = new FilteredEntryNavigableMap<K, V>((NavigableMap<K, V>)Preconditions.checkNotNull(paramNavigableMap), paramPredicate);
    } 
    return paramNavigableMap;
  }
  
  public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> paramSortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    if (paramSortedMap instanceof FilteredEntrySortedMap) {
      paramSortedMap = filterFiltered((FilteredEntrySortedMap<K, V>)paramSortedMap, paramPredicate);
    } else {
      paramSortedMap = new FilteredEntrySortedMap<K, V>((SortedMap<K, V>)Preconditions.checkNotNull(paramSortedMap), paramPredicate);
    } 
    return paramSortedMap;
  }
  
  private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> paramFilteredEntryBiMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    paramPredicate = Predicates.and(paramFilteredEntryBiMap.predicate, paramPredicate);
    return new FilteredEntryBiMap<K, V>(paramFilteredEntryBiMap.unfiltered(), paramPredicate);
  }
  
  private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> paramAbstractFilteredMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    return new FilteredEntryMap<K, V>(paramAbstractFilteredMap.unfiltered, Predicates.and(paramAbstractFilteredMap.predicate, paramPredicate));
  }
  
  @GwtIncompatible
  private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> paramFilteredEntryNavigableMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    paramPredicate = Predicates.and(paramFilteredEntryNavigableMap.entryPredicate, paramPredicate);
    return new FilteredEntryNavigableMap<K, V>(paramFilteredEntryNavigableMap.unfiltered, paramPredicate);
  }
  
  private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> paramFilteredEntrySortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    paramPredicate = Predicates.and(paramFilteredEntrySortedMap.predicate, paramPredicate);
    return new FilteredEntrySortedMap<K, V>(paramFilteredEntrySortedMap.sortedMap(), paramPredicate);
  }
  
  public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> paramBiMap, Predicate<? super K> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    return filterEntries(paramBiMap, (Predicate)keyPredicateOnEntries(paramPredicate));
  }
  
  public static <K, V> Map<K, V> filterKeys(Map<K, V> paramMap, Predicate<? super K> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    Predicate<Map.Entry<K, ?>> predicate = keyPredicateOnEntries(paramPredicate);
    if (paramMap instanceof AbstractFilteredMap) {
      paramMap = filterFiltered((AbstractFilteredMap<K, V>)paramMap, (Predicate)predicate);
    } else {
      paramMap = new FilteredKeyMap<K, V>((Map<K, V>)Preconditions.checkNotNull(paramMap), paramPredicate, (Predicate)predicate);
    } 
    return paramMap;
  }
  
  @GwtIncompatible
  public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> paramNavigableMap, Predicate<? super K> paramPredicate) {
    return filterEntries(paramNavigableMap, (Predicate)keyPredicateOnEntries(paramPredicate));
  }
  
  public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> paramSortedMap, Predicate<? super K> paramPredicate) {
    return filterEntries(paramSortedMap, (Predicate)keyPredicateOnEntries(paramPredicate));
  }
  
  public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> paramBiMap, Predicate<? super V> paramPredicate) {
    return filterEntries(paramBiMap, (Predicate)valuePredicateOnEntries(paramPredicate));
  }
  
  public static <K, V> Map<K, V> filterValues(Map<K, V> paramMap, Predicate<? super V> paramPredicate) {
    return filterEntries(paramMap, (Predicate)valuePredicateOnEntries(paramPredicate));
  }
  
  @GwtIncompatible
  public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> paramNavigableMap, Predicate<? super V> paramPredicate) {
    return filterEntries(paramNavigableMap, (Predicate)valuePredicateOnEntries(paramPredicate));
  }
  
  public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> paramSortedMap, Predicate<? super V> paramPredicate) {
    return filterEntries(paramSortedMap, (Predicate)valuePredicateOnEntries(paramPredicate));
  }
  
  @GwtIncompatible
  public static ImmutableMap<String, String> fromProperties(Properties paramProperties) {
    ImmutableMap.Builder<?, ?> builder = ImmutableMap.builder();
    Enumeration<?> enumeration = paramProperties.propertyNames();
    while (enumeration.hasMoreElements()) {
      String str = (String)enumeration.nextElement();
      builder.put(str, paramProperties.getProperty(str));
    } 
    return (ImmutableMap)builder.build();
  }
  
  @GwtCompatible(serializable = true)
  public static <K, V> Map.Entry<K, V> immutableEntry(@Nullable K paramK, @Nullable V paramV) {
    return new ImmutableEntry<K, V>(paramK, paramV);
  }
  
  @Beta
  @GwtCompatible(serializable = true)
  public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> paramMap) {
    if (paramMap instanceof ImmutableEnumMap)
      return (ImmutableEnumMap)paramMap; 
    if (paramMap.isEmpty())
      return ImmutableMap.of(); 
    for (Map.Entry<K, ? extends V> entry : paramMap.entrySet()) {
      Preconditions.checkNotNull(entry.getKey());
      Preconditions.checkNotNull(entry.getValue());
    } 
    return ImmutableEnumMap.asImmutable(new EnumMap<K, V>(paramMap));
  }
  
  static <E> ImmutableMap<E, Integer> indexMap(Collection<E> paramCollection) {
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder<Object, Object>(paramCollection.size());
    Iterator<E> iterator = paramCollection.iterator();
    for (byte b = 0; iterator.hasNext(); b++)
      builder.put(iterator.next(), Integer.valueOf(b)); 
    return (ImmutableMap)builder.build();
  }
  
  static <K> Function<Map.Entry<K, ?>, K> keyFunction() {
    return EntryFunction.KEY;
  }
  
  static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> paramIterator) {
    return Iterators.transform(paramIterator, (Function)keyFunction());
  }
  
  @Nullable
  static <K> K keyOrNull(@Nullable Map.Entry<K, ?> paramEntry) {
    if (paramEntry == null) {
      paramEntry = null;
    } else {
      paramEntry = (Map.Entry<K, ?>)paramEntry.getKey();
    } 
    return (K)paramEntry;
  }
  
  static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> paramPredicate) {
    return Predicates.compose(paramPredicate, keyFunction());
  }
  
  public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
    return (new MapMaker()).makeMap();
  }
  
  public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> paramClass) {
    return new EnumMap<K, V>((Class<K>)Preconditions.checkNotNull(paramClass));
  }
  
  public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> paramMap) {
    return new EnumMap<K, V>(paramMap);
  }
  
  public static <K, V> HashMap<K, V> newHashMap() {
    return new HashMap<K, V>();
  }
  
  public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> paramMap) {
    return new HashMap<K, V>(paramMap);
  }
  
  public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int paramInt) {
    return new HashMap<K, V>(capacity(paramInt));
  }
  
  public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
    return new IdentityHashMap<K, V>();
  }
  
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
    return new LinkedHashMap<K, V>();
  }
  
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> paramMap) {
    return new LinkedHashMap<K, V>(paramMap);
  }
  
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int paramInt) {
    return new LinkedHashMap<K, V>(capacity(paramInt));
  }
  
  public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
    return new TreeMap<K, V>();
  }
  
  public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@Nullable Comparator<C> paramComparator) {
    return new TreeMap<K, V>(paramComparator);
  }
  
  public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> paramSortedMap) {
    return new TreeMap<K, V>(paramSortedMap);
  }
  
  static <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> paramComparator) {
    return (paramComparator != null) ? paramComparator : Ordering.natural();
  }
  
  static <K, V> void putAllImpl(Map<K, V> paramMap, Map<? extends K, ? extends V> paramMap1) {
    for (Map.Entry<? extends K, ? extends V> entry : paramMap1.entrySet())
      paramMap.put((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> paramCollection, Object paramObject) {
    return !(paramObject instanceof Map.Entry) ? false : paramCollection.remove(unmodifiableEntry((Map.Entry<?, ?>)paramObject));
  }
  
  @GwtIncompatible
  private static <E> NavigableSet<E> removeOnlyNavigableSet(final NavigableSet<E> set) {
    return new ForwardingNavigableSet<E>() {
        public boolean add(E param1E) {
          throw new UnsupportedOperationException();
        }
        
        public boolean addAll(Collection<? extends E> param1Collection) {
          throw new UnsupportedOperationException();
        }
        
        protected NavigableSet<E> delegate() {
          return set;
        }
        
        public NavigableSet<E> descendingSet() {
          return Maps.removeOnlyNavigableSet(super.descendingSet());
        }
        
        public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
          return Maps.removeOnlyNavigableSet(super.headSet(param1E, param1Boolean));
        }
        
        public SortedSet<E> headSet(E param1E) {
          return Maps.removeOnlySortedSet(super.headSet(param1E));
        }
        
        public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
          return Maps.removeOnlyNavigableSet(super.subSet(param1E1, param1Boolean1, param1E2, param1Boolean2));
        }
        
        public SortedSet<E> subSet(E param1E1, E param1E2) {
          return Maps.removeOnlySortedSet(super.subSet(param1E1, param1E2));
        }
        
        public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
          return Maps.removeOnlyNavigableSet(super.tailSet(param1E, param1Boolean));
        }
        
        public SortedSet<E> tailSet(E param1E) {
          return Maps.removeOnlySortedSet(super.tailSet(param1E));
        }
      };
  }
  
  private static <E> Set<E> removeOnlySet(final Set<E> set) {
    return new ForwardingSet<E>() {
        public boolean add(E param1E) {
          throw new UnsupportedOperationException();
        }
        
        public boolean addAll(Collection<? extends E> param1Collection) {
          throw new UnsupportedOperationException();
        }
        
        protected Set<E> delegate() {
          return set;
        }
      };
  }
  
  private static <E> SortedSet<E> removeOnlySortedSet(final SortedSet<E> set) {
    return new ForwardingSortedSet<E>() {
        public boolean add(E param1E) {
          throw new UnsupportedOperationException();
        }
        
        public boolean addAll(Collection<? extends E> param1Collection) {
          throw new UnsupportedOperationException();
        }
        
        protected SortedSet<E> delegate() {
          return set;
        }
        
        public SortedSet<E> headSet(E param1E) {
          return Maps.removeOnlySortedSet(super.headSet(param1E));
        }
        
        public SortedSet<E> subSet(E param1E1, E param1E2) {
          return Maps.removeOnlySortedSet(super.subSet(param1E1, param1E2));
        }
        
        public SortedSet<E> tailSet(E param1E) {
          return Maps.removeOnlySortedSet(super.tailSet(param1E));
        }
      };
  }
  
  static boolean safeContainsKey(Map<?, ?> paramMap, Object paramObject) {
    Preconditions.checkNotNull(paramMap);
    try {
      return paramMap.containsKey(paramObject);
    } catch (ClassCastException classCastException) {
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } 
  }
  
  static <V> V safeGet(Map<?, V> paramMap, @Nullable Object paramObject) {
    Preconditions.checkNotNull(paramMap);
    try {
      return paramMap.get(paramObject);
    } catch (ClassCastException classCastException) {
      return null;
    } catch (NullPointerException nullPointerException) {
      return null;
    } 
  }
  
  static <V> V safeRemove(Map<?, V> paramMap, Object paramObject) {
    Preconditions.checkNotNull(paramMap);
    try {
      return paramMap.remove(paramObject);
    } catch (ClassCastException classCastException) {
      return null;
    } catch (NullPointerException nullPointerException) {
      return null;
    } 
  }
  
  @Beta
  @GwtIncompatible
  public static <K extends Comparable<? super K>, V> NavigableMap<K, V> subMap(NavigableMap<K, V> paramNavigableMap, Range<K> paramRange) {
    Comparator<? super K> comparator = paramNavigableMap.comparator();
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (comparator != null && paramNavigableMap.comparator() != Ordering.natural() && paramRange.hasLowerBound() && paramRange.hasUpperBound()) {
      boolean bool;
      if (paramNavigableMap.comparator().compare(paramRange.lowerEndpoint(), paramRange.upperEndpoint()) <= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "map is using a custom comparator which is inconsistent with the natural ordering.");
    } 
    if (paramRange.hasLowerBound() && paramRange.hasUpperBound()) {
      boolean bool;
      comparator = (Comparator<? super K>)paramRange.lowerEndpoint();
      if (paramRange.lowerBoundType() == BoundType.CLOSED) {
        bool = true;
      } else {
        bool = false;
      } 
      K k = paramRange.upperEndpoint();
      if (paramRange.upperBoundType() != BoundType.CLOSED)
        bool3 = false; 
      return paramNavigableMap.subMap((K)comparator, bool, k, bool3);
    } 
    if (paramRange.hasLowerBound()) {
      boolean bool;
      comparator = (Comparator<? super K>)paramRange.lowerEndpoint();
      if (paramRange.lowerBoundType() == BoundType.CLOSED) {
        bool = bool1;
      } else {
        bool = false;
      } 
      return paramNavigableMap.tailMap((K)comparator, bool);
    } 
    if (paramRange.hasUpperBound()) {
      boolean bool;
      comparator = (Comparator<? super K>)paramRange.upperEndpoint();
      if (paramRange.upperBoundType() == BoundType.CLOSED) {
        bool = bool2;
      } else {
        bool = false;
      } 
      return paramNavigableMap.headMap((K)comparator, bool);
    } 
    return (NavigableMap<K, V>)Preconditions.checkNotNull(paramNavigableMap);
  }
  
  public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> paramBiMap) {
    return Synchronized.biMap(paramBiMap, null);
  }
  
  @GwtIncompatible
  public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> paramNavigableMap) {
    return Synchronized.navigableMap(paramNavigableMap);
  }
  
  public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> paramIterable, Function<? super K, V> paramFunction) {
    return toMap(paramIterable.iterator(), paramFunction);
  }
  
  public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> paramIterator, Function<? super K, V> paramFunction) {
    Preconditions.checkNotNull(paramFunction);
    LinkedHashMap<?, ?> linkedHashMap = newLinkedHashMap();
    while (paramIterator.hasNext()) {
      K k = paramIterator.next();
      linkedHashMap.put(k, paramFunction.apply(k));
    } 
    return ImmutableMap.copyOf((Map)linkedHashMap);
  }
  
  static String toStringImpl(Map<?, ?> paramMap) {
    StringBuilder stringBuilder = Collections2.newStringBuilderForCollection(paramMap.size());
    stringBuilder.append('{');
    STANDARD_JOINER.appendTo(stringBuilder, paramMap);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> paramMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesMap<K, V1, V2>(paramMap, paramEntryTransformer);
  }
  
  @GwtIncompatible
  public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> paramNavigableMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesNavigableMap<K, V1, V2>(paramNavigableMap, paramEntryTransformer);
  }
  
  public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> paramSortedMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesSortedMap<K, V1, V2>(paramSortedMap, paramEntryTransformer);
  }
  
  static <V2, K, V1> Map.Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> transformer, final Map.Entry<K, V1> entry) {
    Preconditions.checkNotNull(transformer);
    Preconditions.checkNotNull(entry);
    return new AbstractMapEntry<K, V2>() {
        public K getKey() {
          return (K)entry.getKey();
        }
        
        public V2 getValue() {
          return (V2)transformer.transformEntry(entry.getKey(), entry.getValue());
        }
      };
  }
  
  public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> paramMap, Function<? super V1, V2> paramFunction) {
    return transformEntries(paramMap, asEntryTransformer(paramFunction));
  }
  
  @GwtIncompatible
  public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> paramNavigableMap, Function<? super V1, V2> paramFunction) {
    return transformEntries(paramNavigableMap, asEntryTransformer(paramFunction));
  }
  
  public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> paramSortedMap, Function<? super V1, V2> paramFunction) {
    return transformEntries(paramSortedMap, asEntryTransformer(paramFunction));
  }
  
  @CanIgnoreReturnValue
  public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> paramIterable, Function<? super V, K> paramFunction) {
    return uniqueIndex(paramIterable.iterator(), paramFunction);
  }
  
  @CanIgnoreReturnValue
  public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> paramIterator, Function<? super V, K> paramFunction) {
    Preconditions.checkNotNull(paramFunction);
    ImmutableMap.Builder<?, ?> builder = ImmutableMap.builder();
    while (paramIterator.hasNext()) {
      V v = paramIterator.next();
      builder.put(paramFunction.apply(v), v);
    } 
    try {
      return (ImmutableMap)builder.build();
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(illegalArgumentException.getMessage());
      stringBuilder.append(". To index multiple values under a key, use Multimaps.index.");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> paramBiMap) {
    return new UnmodifiableBiMap<K, V>(paramBiMap, null);
  }
  
  static <K, V> Map.Entry<K, V> unmodifiableEntry(final Map.Entry<? extends K, ? extends V> entry) {
    Preconditions.checkNotNull(entry);
    return new AbstractMapEntry<K, V>() {
        public K getKey() {
          return (K)entry.getKey();
        }
        
        public V getValue() {
          return (V)entry.getValue();
        }
      };
  }
  
  static <K, V> UnmodifiableIterator<Map.Entry<K, V>> unmodifiableEntryIterator(final Iterator<Map.Entry<K, V>> entryIterator) {
    return new UnmodifiableIterator<Map.Entry<K, V>>() {
        public boolean hasNext() {
          return entryIterator.hasNext();
        }
        
        public Map.Entry<K, V> next() {
          return Maps.unmodifiableEntry(entryIterator.next());
        }
      };
  }
  
  static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> paramSet) {
    return new UnmodifiableEntrySet<K, V>(Collections.unmodifiableSet(paramSet));
  }
  
  private static <K, V> Map<K, V> unmodifiableMap(Map<K, ? extends V> paramMap) {
    return (paramMap instanceof SortedMap) ? Collections.unmodifiableSortedMap((SortedMap<K, ? extends V>)paramMap) : Collections.unmodifiableMap(paramMap);
  }
  
  @GwtIncompatible
  public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> paramNavigableMap) {
    Preconditions.checkNotNull(paramNavigableMap);
    return (paramNavigableMap instanceof UnmodifiableNavigableMap) ? paramNavigableMap : new UnmodifiableNavigableMap<K, V>(paramNavigableMap);
  }
  
  @Nullable
  private static <K, V> Map.Entry<K, V> unmodifiableOrNull(@Nullable Map.Entry<K, ? extends V> paramEntry) {
    if (paramEntry == null) {
      paramEntry = null;
    } else {
      paramEntry = unmodifiableEntry(paramEntry);
    } 
    return (Map.Entry)paramEntry;
  }
  
  static <V> Function<Map.Entry<?, V>, V> valueFunction() {
    return EntryFunction.VALUE;
  }
  
  static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> paramIterator) {
    return Iterators.transform(paramIterator, (Function)valueFunction());
  }
  
  @Nullable
  static <V> V valueOrNull(@Nullable Map.Entry<?, V> paramEntry) {
    if (paramEntry == null) {
      paramEntry = null;
    } else {
      paramEntry = (Map.Entry<?, V>)paramEntry.getValue();
    } 
    return (V)paramEntry;
  }
  
  static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> paramPredicate) {
    return Predicates.compose(paramPredicate, valueFunction());
  }
  
  private static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {
    final Predicate<? super Map.Entry<K, V>> predicate;
    
    final Map<K, V> unfiltered;
    
    AbstractFilteredMap(Map<K, V> param1Map, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      this.unfiltered = param1Map;
      this.predicate = param1Predicate;
    }
    
    boolean apply(@Nullable Object param1Object, @Nullable V param1V) {
      return this.predicate.apply(Maps.immutableEntry(param1Object, param1V));
    }
    
    public boolean containsKey(Object param1Object) {
      boolean bool;
      if (this.unfiltered.containsKey(param1Object) && apply(param1Object, this.unfiltered.get(param1Object))) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    Collection<V> createValues() {
      return new Maps.FilteredMapValues<K, V>(this, this.unfiltered, this.predicate);
    }
    
    public V get(Object param1Object) {
      V v = this.unfiltered.get(param1Object);
      if (v != null && apply(param1Object, v)) {
        param1Object = v;
      } else {
        param1Object = null;
      } 
      return (V)param1Object;
    }
    
    public boolean isEmpty() {
      return entrySet().isEmpty();
    }
    
    public V put(K param1K, V param1V) {
      Preconditions.checkArgument(apply(param1K, param1V));
      return this.unfiltered.put(param1K, param1V);
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      for (Map.Entry<? extends K, ? extends V> entry : param1Map.entrySet())
        Preconditions.checkArgument(apply(entry.getKey(), (V)entry.getValue())); 
      this.unfiltered.putAll(param1Map);
    }
    
    public V remove(Object param1Object) {
      if (containsKey(param1Object)) {
        param1Object = this.unfiltered.remove(param1Object);
      } else {
        param1Object = null;
      } 
      return (V)param1Object;
    }
  }
  
  private static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {
    final Function<? super K, V> function;
    
    private final Set<K> set;
    
    AsMapView(Set<K> param1Set, Function<? super K, V> param1Function) {
      this.set = (Set<K>)Preconditions.checkNotNull(param1Set);
      this.function = (Function<? super K, V>)Preconditions.checkNotNull(param1Function);
    }
    
    Set<K> backingSet() {
      return this.set;
    }
    
    public void clear() {
      backingSet().clear();
    }
    
    public boolean containsKey(@Nullable Object param1Object) {
      return backingSet().contains(param1Object);
    }
    
    protected Set<Map.Entry<K, V>> createEntrySet() {
      class EntrySetImpl extends Maps.EntrySet<K, V> {
        public Iterator<Map.Entry<K, V>> iterator() {
          return Maps.asMapEntryIterator(Maps.AsMapView.this.backingSet(), Maps.AsMapView.this.function);
        }
        
        Map<K, V> map() {
          return Maps.AsMapView.this;
        }
      };
      return new EntrySetImpl();
    }
    
    public Set<K> createKeySet() {
      return Maps.removeOnlySet(backingSet());
    }
    
    Collection<V> createValues() {
      return Collections2.transform(this.set, this.function);
    }
    
    public V get(@Nullable Object param1Object) {
      return (V)(Collections2.safeContains(backingSet(), param1Object) ? this.function.apply(param1Object) : null);
    }
    
    public V remove(@Nullable Object param1Object) {
      return (V)(backingSet().remove(param1Object) ? this.function.apply(param1Object) : null);
    }
    
    public int size() {
      return backingSet().size();
    }
  }
  
  class EntrySetImpl extends EntrySet<K, V> {
    public Iterator<Map.Entry<K, V>> iterator() {
      return Maps.asMapEntryIterator(this.this$0.backingSet(), this.this$0.function);
    }
    
    Map<K, V> map() {
      return this.this$0;
    }
  }
  
  private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final BiMap<A, B> bimap;
    
    BiMapConverter(BiMap<A, B> param1BiMap) {
      this.bimap = (BiMap<A, B>)Preconditions.checkNotNull(param1BiMap);
    }
    
    private static <X, Y> Y convert(BiMap<X, Y> param1BiMap, X param1X) {
      boolean bool;
      param1BiMap = (BiMap<X, Y>)param1BiMap.get(param1X);
      if (param1BiMap != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "No non-null mapping present for input: %s", param1X);
      return (Y)param1BiMap;
    }
    
    protected A doBackward(B param1B) {
      return convert(this.bimap.inverse(), param1B);
    }
    
    protected B doForward(A param1A) {
      return convert(this.bimap, param1A);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof BiMapConverter) {
        param1Object = param1Object;
        return this.bimap.equals(((BiMapConverter)param1Object).bimap);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.bimap.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Maps.asConverter(");
      stringBuilder.append(this.bimap);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  @GwtIncompatible
  static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
    private transient Comparator<? super K> comparator;
    
    private transient Set<Map.Entry<K, V>> entrySet;
    
    private transient NavigableSet<K> navigableKeySet;
    
    private static <T> Ordering<T> reverse(Comparator<T> param1Comparator) {
      return Ordering.<T>from(param1Comparator).reverse();
    }
    
    public Map.Entry<K, V> ceilingEntry(K param1K) {
      return forward().floorEntry(param1K);
    }
    
    public K ceilingKey(K param1K) {
      return forward().floorKey(param1K);
    }
    
    public Comparator<? super K> comparator() {
      Comparator<? super K> comparator1 = this.comparator;
      Comparator<? super K> comparator2 = comparator1;
      if (comparator1 == null) {
        comparator1 = forward().comparator();
        comparator2 = comparator1;
        if (comparator1 == null)
          comparator2 = Ordering.natural(); 
        comparator2 = reverse(comparator2);
        this.comparator = comparator2;
      } 
      return comparator2;
    }
    
    Set<Map.Entry<K, V>> createEntrySet() {
      class EntrySetImpl extends Maps.EntrySet<K, V> {
        public Iterator<Map.Entry<K, V>> iterator() {
          return Maps.DescendingMap.this.entryIterator();
        }
        
        Map<K, V> map() {
          return Maps.DescendingMap.this;
        }
      };
      return new EntrySetImpl();
    }
    
    protected final Map<K, V> delegate() {
      return forward();
    }
    
    public NavigableSet<K> descendingKeySet() {
      return forward().navigableKeySet();
    }
    
    public NavigableMap<K, V> descendingMap() {
      return forward();
    }
    
    abstract Iterator<Map.Entry<K, V>> entryIterator();
    
    public Set<Map.Entry<K, V>> entrySet() {
      Set<Map.Entry<K, V>> set1 = this.entrySet;
      Set<Map.Entry<K, V>> set2 = set1;
      if (set1 == null) {
        set2 = createEntrySet();
        this.entrySet = set2;
      } 
      return set2;
    }
    
    public Map.Entry<K, V> firstEntry() {
      return forward().lastEntry();
    }
    
    public K firstKey() {
      return forward().lastKey();
    }
    
    public Map.Entry<K, V> floorEntry(K param1K) {
      return forward().ceilingEntry(param1K);
    }
    
    public K floorKey(K param1K) {
      return forward().ceilingKey(param1K);
    }
    
    abstract NavigableMap<K, V> forward();
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      return forward().tailMap(param1K, param1Boolean).descendingMap();
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return headMap(param1K, false);
    }
    
    public Map.Entry<K, V> higherEntry(K param1K) {
      return forward().lowerEntry(param1K);
    }
    
    public K higherKey(K param1K) {
      return forward().lowerKey(param1K);
    }
    
    public Set<K> keySet() {
      return navigableKeySet();
    }
    
    public Map.Entry<K, V> lastEntry() {
      return forward().firstEntry();
    }
    
    public K lastKey() {
      return forward().firstKey();
    }
    
    public Map.Entry<K, V> lowerEntry(K param1K) {
      return forward().higherEntry(param1K);
    }
    
    public K lowerKey(K param1K) {
      return forward().higherKey(param1K);
    }
    
    public NavigableSet<K> navigableKeySet() {
      NavigableSet<K> navigableSet1 = this.navigableKeySet;
      NavigableSet<K> navigableSet2 = navigableSet1;
      if (navigableSet1 == null) {
        navigableSet2 = new Maps.NavigableKeySet<K, Object>(this);
        this.navigableKeySet = navigableSet2;
      } 
      return navigableSet2;
    }
    
    public Map.Entry<K, V> pollFirstEntry() {
      return forward().pollLastEntry();
    }
    
    public Map.Entry<K, V> pollLastEntry() {
      return forward().pollFirstEntry();
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return forward().subMap(param1K2, param1Boolean2, param1K1, param1Boolean1).descendingMap();
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      return forward().headMap(param1K, param1Boolean).descendingMap();
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return tailMap(param1K, true);
    }
    
    public String toString() {
      return standardToString();
    }
    
    public Collection<V> values() {
      return new Maps.Values<Object, V>(this);
    }
  }
  
  class EntrySetImpl extends EntrySet<K, V> {
    public Iterator<Map.Entry<K, V>> iterator() {
      return this.this$0.entryIterator();
    }
    
    Map<K, V> map() {
      return this.this$0;
    }
  }
  
  private enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
    KEY {
      @Nullable
      public Object apply(Map.Entry<?, ?> param2Entry) {
        return param2Entry.getKey();
      }
    },
    VALUE {
      @Nullable
      public Object apply(Map.Entry<?, ?> param2Entry) {
        return param2Entry.getValue();
      }
    };
    
    static {
    
    }
  }
  
  enum null {
    @Nullable
    public Object apply(Map.Entry<?, ?> param1Entry) {
      return param1Entry.getKey();
    }
  }
  
  enum null {
    @Nullable
    public Object apply(Map.Entry<?, ?> param1Entry) {
      return param1Entry.getValue();
    }
  }
  
  static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
    public void clear() {
      map().clear();
    }
    
    public boolean contains(Object param1Object) {
      null = param1Object instanceof Map.Entry;
      boolean bool = false;
      if (null) {
        Map.Entry entry = (Map.Entry)param1Object;
        param1Object = entry.getKey();
        Object object = Maps.safeGet((Map)map(), param1Object);
        null = bool;
        if (Objects.equal(object, entry.getValue())) {
          if (object == null) {
            null = bool;
            return map().containsKey(param1Object) ? true : null;
          } 
        } else {
          return null;
        } 
      } else {
        return false;
      } 
      return true;
    }
    
    public boolean isEmpty() {
      return map().isEmpty();
    }
    
    abstract Map<K, V> map();
    
    public boolean remove(Object param1Object) {
      if (contains(param1Object)) {
        param1Object = param1Object;
        return map().keySet().remove(param1Object.getKey());
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      try {
        return super.removeAll((Collection)Preconditions.checkNotNull(param1Collection));
      } catch (UnsupportedOperationException unsupportedOperationException) {
        return Sets.removeAllImpl(this, param1Collection.iterator());
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      try {
        return super.retainAll((Collection)Preconditions.checkNotNull(param1Collection));
      } catch (UnsupportedOperationException unsupportedOperationException) {
        HashSet<?> hashSet = Sets.newHashSetWithExpectedSize(param1Collection.size());
        for (Collection<?> param1Collection : param1Collection) {
          if (contains(param1Collection))
            hashSet.add(((Map.Entry)param1Collection).getKey()); 
        } 
        return map().keySet().retainAll(hashSet);
      } 
    }
    
    public int size() {
      return map().size();
    }
  }
  
  public static interface EntryTransformer<K, V1, V2> {
    V2 transformEntry(@Nullable K param1K, @Nullable V1 param1V1);
  }
  
  static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
    @RetainedWith
    private final BiMap<V, K> inverse;
    
    FilteredEntryBiMap(BiMap<K, V> param1BiMap, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      super(param1BiMap, param1Predicate);
      this.inverse = new FilteredEntryBiMap(param1BiMap.inverse(), inversePredicate(param1Predicate), this);
    }
    
    private FilteredEntryBiMap(BiMap<K, V> param1BiMap, Predicate<? super Map.Entry<K, V>> param1Predicate, BiMap<V, K> param1BiMap1) {
      super(param1BiMap, param1Predicate);
      this.inverse = param1BiMap1;
    }
    
    private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(final Predicate<? super Map.Entry<K, V>> forwardPredicate) {
      return new Predicate<Map.Entry<V, K>>() {
          public boolean apply(Map.Entry<V, K> param2Entry) {
            return forwardPredicate.apply(Maps.immutableEntry(param2Entry.getValue(), param2Entry.getKey()));
          }
        };
    }
    
    public V forcePut(@Nullable K param1K, @Nullable V param1V) {
      Preconditions.checkArgument(apply(param1K, param1V));
      return unfiltered().forcePut(param1K, param1V);
    }
    
    public BiMap<V, K> inverse() {
      return this.inverse;
    }
    
    BiMap<K, V> unfiltered() {
      return (BiMap<K, V>)this.unfiltered;
    }
    
    public Set<V> values() {
      return this.inverse.keySet();
    }
  }
  
  static final class null implements Predicate<Map.Entry<V, K>> {
    public boolean apply(Map.Entry<V, K> param1Entry) {
      return forwardPredicate.apply(Maps.immutableEntry(param1Entry.getValue(), param1Entry.getKey()));
    }
  }
  
  static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
    final Set<Map.Entry<K, V>> filteredEntrySet;
    
    FilteredEntryMap(Map<K, V> param1Map, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      super(param1Map, param1Predicate);
      this.filteredEntrySet = Sets.filter(param1Map.entrySet(), this.predicate);
    }
    
    protected Set<Map.Entry<K, V>> createEntrySet() {
      return new EntrySet();
    }
    
    Set<K> createKeySet() {
      return new KeySet();
    }
    
    private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
      private EntrySet() {}
      
      protected Set<Map.Entry<K, V>> delegate() {
        return Maps.FilteredEntryMap.this.filteredEntrySet;
      }
      
      public Iterator<Map.Entry<K, V>> iterator() {
        return new TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>(Maps.FilteredEntryMap.this.filteredEntrySet.iterator()) {
            Map.Entry<K, V> transform(final Map.Entry<K, V> entry) {
              return new ForwardingMapEntry<K, V>() {
                  protected Map.Entry<K, V> delegate() {
                    return entry;
                  }
                  
                  public V setValue(V param4V) {
                    Preconditions.checkArgument(Maps.FilteredEntryMap.this.apply(getKey(), param4V));
                    return super.setValue(param4V);
                  }
                };
            }
          };
      }
    }
    
    class null extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>> {
      null(Iterator<? extends Map.Entry<K, V>> param2Iterator) {
        super(param2Iterator);
      }
      
      Map.Entry<K, V> transform(final Map.Entry<K, V> entry) {
        return new ForwardingMapEntry<K, V>() {
            protected Map.Entry<K, V> delegate() {
              return entry;
            }
            
            public V setValue(V param4V) {
              Preconditions.checkArgument(Maps.FilteredEntryMap.this.apply(getKey(), param4V));
              return super.setValue(param4V);
            }
          };
      }
    }
    
    class null extends ForwardingMapEntry<K, V> {
      protected Map.Entry<K, V> delegate() {
        return entry;
      }
      
      public V setValue(V param2V) {
        Preconditions.checkArgument(Maps.FilteredEntryMap.this.apply(getKey(), param2V));
        return super.setValue(param2V);
      }
    }
    
    class KeySet extends Maps.KeySet<K, V> {
      KeySet() {
        super(Maps.FilteredEntryMap.this);
      }
      
      private boolean removeIf(Predicate<? super K> param2Predicate) {
        return Iterables.removeIf(Maps.FilteredEntryMap.this.unfiltered.entrySet(), Predicates.and(Maps.FilteredEntryMap.this.predicate, Maps.keyPredicateOnEntries(param2Predicate)));
      }
      
      public boolean remove(Object param2Object) {
        if (Maps.FilteredEntryMap.this.containsKey(param2Object)) {
          Maps.FilteredEntryMap.this.unfiltered.remove(param2Object);
          return true;
        } 
        return false;
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        return removeIf(Predicates.in(param2Collection));
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return removeIf(Predicates.not(Predicates.in(param2Collection)));
      }
      
      public Object[] toArray() {
        return Lists.<K>newArrayList(iterator()).toArray();
      }
      
      public <T> T[] toArray(T[] param2ArrayOfT) {
        return (T[])Lists.<K>newArrayList(iterator()).toArray((Object[])param2ArrayOfT);
      }
    }
  }
  
  private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
    private EntrySet() {}
    
    protected Set<Map.Entry<K, V>> delegate() {
      return Maps.FilteredEntryMap.this.filteredEntrySet;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new TransformedIterator(Maps.FilteredEntryMap.this.filteredEntrySet.iterator()) {
          Map.Entry<K, V> transform(final Map.Entry<K, V> entry) {
            return new ForwardingMapEntry<K, V>() {
                protected Map.Entry<K, V> delegate() {
                  return entry;
                }
                
                public V setValue(V param4V) {
                  Preconditions.checkArgument(Maps.FilteredEntryMap.this.apply(getKey(), param4V));
                  return super.setValue(param4V);
                }
              };
          }
        };
    }
  }
  
  class null extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>> {
    null(Iterator<? extends Map.Entry<K, V>> param1Iterator) {
      super(param1Iterator);
    }
    
    Map.Entry<K, V> transform(final Map.Entry<K, V> entry) {
      return new ForwardingMapEntry<K, V>() {
          protected Map.Entry<K, V> delegate() {
            return entry;
          }
          
          public V setValue(V param4V) {
            Preconditions.checkArgument(this.this$2.this$1.this$0.apply(getKey(), param4V));
            return super.setValue(param4V);
          }
        };
    }
  }
  
  class null extends ForwardingMapEntry<K, V> {
    protected Map.Entry<K, V> delegate() {
      return entry;
    }
    
    public V setValue(V param1V) {
      Preconditions.checkArgument(this.this$2.this$1.this$0.apply(getKey(), param1V));
      return super.setValue(param1V);
    }
  }
  
  class KeySet extends KeySet<K, V> {
    private boolean removeIf(Predicate<? super K> param1Predicate) {
      return Iterables.removeIf(this.this$0.unfiltered.entrySet(), Predicates.and(this.this$0.predicate, Maps.keyPredicateOnEntries(param1Predicate)));
    }
    
    public boolean remove(Object param1Object) {
      if (this.this$0.containsKey(param1Object)) {
        this.this$0.unfiltered.remove(param1Object);
        return true;
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return removeIf(Predicates.in(param1Collection));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return removeIf(Predicates.not(Predicates.in(param1Collection)));
    }
    
    public Object[] toArray() {
      return Lists.<K>newArrayList(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])Lists.<K>newArrayList(iterator()).toArray((Object[])param1ArrayOfT);
    }
  }
  
  @GwtIncompatible
  private static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
    private final Predicate<? super Map.Entry<K, V>> entryPredicate;
    
    private final Map<K, V> filteredDelegate;
    
    private final NavigableMap<K, V> unfiltered;
    
    FilteredEntryNavigableMap(NavigableMap<K, V> param1NavigableMap, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      this.unfiltered = (NavigableMap<K, V>)Preconditions.checkNotNull(param1NavigableMap);
      this.entryPredicate = param1Predicate;
      this.filteredDelegate = new Maps.FilteredEntryMap<K, V>(param1NavigableMap, param1Predicate);
    }
    
    public void clear() {
      this.filteredDelegate.clear();
    }
    
    public Comparator<? super K> comparator() {
      return this.unfiltered.comparator();
    }
    
    public boolean containsKey(@Nullable Object param1Object) {
      return this.filteredDelegate.containsKey(param1Object);
    }
    
    Iterator<Map.Entry<K, V>> descendingEntryIterator() {
      return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
    }
    
    public NavigableMap<K, V> descendingMap() {
      return Maps.filterEntries(this.unfiltered.descendingMap(), this.entryPredicate);
    }
    
    Iterator<Map.Entry<K, V>> entryIterator() {
      return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      return this.filteredDelegate.entrySet();
    }
    
    @Nullable
    public V get(@Nullable Object param1Object) {
      return this.filteredDelegate.get(param1Object);
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      return Maps.filterEntries(this.unfiltered.headMap(param1K, param1Boolean), this.entryPredicate);
    }
    
    public boolean isEmpty() {
      return Iterables.<Map.Entry<K, V>>any(this.unfiltered.entrySet(), this.entryPredicate) ^ true;
    }
    
    public NavigableSet<K> navigableKeySet() {
      return new Maps.NavigableKeySet<K, V>(this) {
          public boolean removeAll(Collection<?> param2Collection) {
            return Iterators.removeIf(Maps.FilteredEntryNavigableMap.this.unfiltered.entrySet().iterator(), Predicates.and(Maps.FilteredEntryNavigableMap.this.entryPredicate, Maps.keyPredicateOnEntries(Predicates.in(param2Collection))));
          }
          
          public boolean retainAll(Collection<?> param2Collection) {
            return Iterators.removeIf(Maps.FilteredEntryNavigableMap.this.unfiltered.entrySet().iterator(), Predicates.and(Maps.FilteredEntryNavigableMap.this.entryPredicate, Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(param2Collection)))));
          }
        };
    }
    
    public Map.Entry<K, V> pollFirstEntry() {
      return Iterables.<Map.Entry<K, V>>removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
    }
    
    public Map.Entry<K, V> pollLastEntry() {
      return Iterables.<Map.Entry<K, V>>removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
    }
    
    public V put(K param1K, V param1V) {
      return this.filteredDelegate.put(param1K, param1V);
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      this.filteredDelegate.putAll(param1Map);
    }
    
    public V remove(@Nullable Object param1Object) {
      return this.filteredDelegate.remove(param1Object);
    }
    
    public int size() {
      return this.filteredDelegate.size();
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return Maps.filterEntries(this.unfiltered.subMap(param1K1, param1Boolean1, param1K2, param1Boolean2), this.entryPredicate);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      return Maps.filterEntries(this.unfiltered.tailMap(param1K, param1Boolean), this.entryPredicate);
    }
    
    public Collection<V> values() {
      return new Maps.FilteredMapValues<K, V>(this, this.unfiltered, this.entryPredicate);
    }
  }
  
  class null extends NavigableKeySet<K, V> {
    null(NavigableMap<K, V> param1NavigableMap) {
      super(param1NavigableMap);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return Iterators.removeIf(this.this$0.unfiltered.entrySet().iterator(), Predicates.and(this.this$0.entryPredicate, Maps.keyPredicateOnEntries(Predicates.in(param1Collection))));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return Iterators.removeIf(this.this$0.unfiltered.entrySet().iterator(), Predicates.and(this.this$0.entryPredicate, Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(param1Collection)))));
    }
  }
  
  private static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {
    FilteredEntrySortedMap(SortedMap<K, V> param1SortedMap, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      super(param1SortedMap, param1Predicate);
    }
    
    public Comparator<? super K> comparator() {
      return sortedMap().comparator();
    }
    
    SortedSet<K> createKeySet() {
      return new SortedKeySet();
    }
    
    public K firstKey() {
      return keySet().iterator().next();
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return new FilteredEntrySortedMap(sortedMap().headMap(param1K), this.predicate);
    }
    
    public SortedSet<K> keySet() {
      return (SortedSet<K>)super.keySet();
    }
    
    public K lastKey() {
      for (SortedMap<K, V> sortedMap = sortedMap();; sortedMap = sortedMap().headMap((K)sortedMap)) {
        sortedMap = (SortedMap<K, V>)sortedMap.lastKey();
        if (apply(sortedMap, this.unfiltered.get(sortedMap)))
          return (K)sortedMap; 
      } 
    }
    
    SortedMap<K, V> sortedMap() {
      return (SortedMap<K, V>)this.unfiltered;
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return new FilteredEntrySortedMap(sortedMap().subMap(param1K1, param1K2), this.predicate);
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return new FilteredEntrySortedMap(sortedMap().tailMap(param1K), this.predicate);
    }
    
    class SortedKeySet extends Maps.FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
      public Comparator<? super K> comparator() {
        return Maps.FilteredEntrySortedMap.this.sortedMap().comparator();
      }
      
      public K first() {
        return (K)Maps.FilteredEntrySortedMap.this.firstKey();
      }
      
      public SortedSet<K> headSet(K param2K) {
        return (SortedSet<K>)Maps.FilteredEntrySortedMap.this.headMap(param2K).keySet();
      }
      
      public K last() {
        return (K)Maps.FilteredEntrySortedMap.this.lastKey();
      }
      
      public SortedSet<K> subSet(K param2K1, K param2K2) {
        return (SortedSet<K>)Maps.FilteredEntrySortedMap.this.subMap(param2K1, param2K2).keySet();
      }
      
      public SortedSet<K> tailSet(K param2K) {
        return (SortedSet<K>)Maps.FilteredEntrySortedMap.this.tailMap(param2K).keySet();
      }
    }
  }
  
  class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
    SortedKeySet() {
      super((Maps.FilteredEntryMap)Maps.this);
    }
    
    public Comparator<? super K> comparator() {
      return this.this$0.sortedMap().comparator();
    }
    
    public K first() {
      return (K)this.this$0.firstKey();
    }
    
    public SortedSet<K> headSet(K param1K) {
      return (SortedSet<K>)this.this$0.headMap(param1K).keySet();
    }
    
    public K last() {
      return (K)this.this$0.lastKey();
    }
    
    public SortedSet<K> subSet(K param1K1, K param1K2) {
      return (SortedSet<K>)this.this$0.subMap(param1K1, param1K2).keySet();
    }
    
    public SortedSet<K> tailSet(K param1K) {
      return (SortedSet<K>)this.this$0.tailMap(param1K).keySet();
    }
  }
  
  private static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
    final Predicate<? super K> keyPredicate;
    
    FilteredKeyMap(Map<K, V> param1Map, Predicate<? super K> param1Predicate, Predicate<? super Map.Entry<K, V>> param1Predicate1) {
      super(param1Map, param1Predicate1);
      this.keyPredicate = param1Predicate;
    }
    
    public boolean containsKey(Object param1Object) {
      boolean bool;
      if (this.unfiltered.containsKey(param1Object) && this.keyPredicate.apply(param1Object)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    protected Set<Map.Entry<K, V>> createEntrySet() {
      return Sets.filter(this.unfiltered.entrySet(), this.predicate);
    }
    
    Set<K> createKeySet() {
      return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }
  }
  
  private static final class FilteredMapValues<K, V> extends Values<K, V> {
    final Predicate<? super Map.Entry<K, V>> predicate;
    
    final Map<K, V> unfiltered;
    
    FilteredMapValues(Map<K, V> param1Map1, Map<K, V> param1Map2, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      super(param1Map1);
      this.unfiltered = param1Map2;
      this.predicate = param1Predicate;
    }
    
    private boolean removeIf(Predicate<? super V> param1Predicate) {
      return Iterables.removeIf(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(param1Predicate)));
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (Iterables.removeFirstMatching(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(param1Object)))) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return removeIf(Predicates.in(param1Collection));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return removeIf(Predicates.not(Predicates.in(param1Collection)));
    }
    
    public Object[] toArray() {
      return Lists.<V>newArrayList(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])Lists.<V>newArrayList(iterator()).toArray((Object[])param1ArrayOfT);
    }
  }
  
  static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
    public void clear() {
      Iterators.clear(entryIterator());
    }
    
    abstract Iterator<Map.Entry<K, V>> entryIterator();
    
    public Set<Map.Entry<K, V>> entrySet() {
      return new Maps.EntrySet<K, V>() {
          public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.IteratorBasedAbstractMap.this.entryIterator();
          }
          
          Map<K, V> map() {
            return Maps.IteratorBasedAbstractMap.this;
          }
        };
    }
    
    public abstract int size();
  }
  
  class null extends EntrySet<K, V> {
    public Iterator<Map.Entry<K, V>> iterator() {
      return this.this$0.entryIterator();
    }
    
    Map<K, V> map() {
      return this.this$0;
    }
  }
  
  static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {
    @Weak
    final Map<K, V> map;
    
    KeySet(Map<K, V> param1Map) {
      this.map = (Map<K, V>)Preconditions.checkNotNull(param1Map);
    }
    
    public void clear() {
      map().clear();
    }
    
    public boolean contains(Object param1Object) {
      return map().containsKey(param1Object);
    }
    
    public boolean isEmpty() {
      return map().isEmpty();
    }
    
    public Iterator<K> iterator() {
      return Maps.keyIterator(map().entrySet().iterator());
    }
    
    Map<K, V> map() {
      return this.map;
    }
    
    public boolean remove(Object param1Object) {
      if (contains(param1Object)) {
        map().remove(param1Object);
        return true;
      } 
      return false;
    }
    
    public int size() {
      return map().size();
    }
  }
  
  static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
    final Map<K, MapDifference.ValueDifference<V>> differences;
    
    final Map<K, V> onBoth;
    
    final Map<K, V> onlyOnLeft;
    
    final Map<K, V> onlyOnRight;
    
    MapDifferenceImpl(Map<K, V> param1Map1, Map<K, V> param1Map2, Map<K, V> param1Map3, Map<K, MapDifference.ValueDifference<V>> param1Map) {
      this.onlyOnLeft = Maps.unmodifiableMap(param1Map1);
      this.onlyOnRight = Maps.unmodifiableMap(param1Map2);
      this.onBoth = Maps.unmodifiableMap(param1Map3);
      this.differences = (Map)Maps.unmodifiableMap((Map)param1Map);
    }
    
    public boolean areEqual() {
      boolean bool;
      if (this.onlyOnLeft.isEmpty() && this.onlyOnRight.isEmpty() && this.differences.isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public Map<K, MapDifference.ValueDifference<V>> entriesDiffering() {
      return this.differences;
    }
    
    public Map<K, V> entriesInCommon() {
      return this.onBoth;
    }
    
    public Map<K, V> entriesOnlyOnLeft() {
      return this.onlyOnLeft;
    }
    
    public Map<K, V> entriesOnlyOnRight() {
      return this.onlyOnRight;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = true;
      if (param1Object == this)
        return true; 
      if (param1Object instanceof MapDifference) {
        param1Object = param1Object;
        if (!entriesOnlyOnLeft().equals(param1Object.entriesOnlyOnLeft()) || !entriesOnlyOnRight().equals(param1Object.entriesOnlyOnRight()) || !entriesInCommon().equals(param1Object.entriesInCommon()) || !entriesDiffering().equals(param1Object.entriesDiffering()))
          bool = false; 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering() });
    }
    
    public String toString() {
      if (areEqual())
        return "equal"; 
      StringBuilder stringBuilder = new StringBuilder("not equal");
      if (!this.onlyOnLeft.isEmpty()) {
        stringBuilder.append(": only on left=");
        stringBuilder.append(this.onlyOnLeft);
      } 
      if (!this.onlyOnRight.isEmpty()) {
        stringBuilder.append(": only on right=");
        stringBuilder.append(this.onlyOnRight);
      } 
      if (!this.differences.isEmpty()) {
        stringBuilder.append(": value differences=");
        stringBuilder.append(this.differences);
      } 
      return stringBuilder.toString();
    }
  }
  
  @GwtIncompatible
  private static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {
    private final Function<? super K, V> function;
    
    private final NavigableSet<K> set;
    
    NavigableAsMapView(NavigableSet<K> param1NavigableSet, Function<? super K, V> param1Function) {
      this.set = (NavigableSet<K>)Preconditions.checkNotNull(param1NavigableSet);
      this.function = (Function<? super K, V>)Preconditions.checkNotNull(param1Function);
    }
    
    public void clear() {
      this.set.clear();
    }
    
    public Comparator<? super K> comparator() {
      return this.set.comparator();
    }
    
    Iterator<Map.Entry<K, V>> descendingEntryIterator() {
      return descendingMap().entrySet().iterator();
    }
    
    public NavigableMap<K, V> descendingMap() {
      return Maps.asMap(this.set.descendingSet(), this.function);
    }
    
    Iterator<Map.Entry<K, V>> entryIterator() {
      return Maps.asMapEntryIterator(this.set, this.function);
    }
    
    @Nullable
    public V get(@Nullable Object param1Object) {
      return (V)(Collections2.safeContains(this.set, param1Object) ? this.function.apply(param1Object) : null);
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      return Maps.asMap(this.set.headSet(param1K, param1Boolean), this.function);
    }
    
    public NavigableSet<K> navigableKeySet() {
      return Maps.removeOnlyNavigableSet(this.set);
    }
    
    public int size() {
      return this.set.size();
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return Maps.asMap(this.set.subSet(param1K1, param1Boolean1, param1K2, param1Boolean2), this.function);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      return Maps.asMap(this.set.tailSet(param1K, param1Boolean), this.function);
    }
  }
  
  @GwtIncompatible
  static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
    NavigableKeySet(NavigableMap<K, V> param1NavigableMap) {
      super(param1NavigableMap);
    }
    
    public K ceiling(K param1K) {
      return map().ceilingKey(param1K);
    }
    
    public Iterator<K> descendingIterator() {
      return descendingSet().iterator();
    }
    
    public NavigableSet<K> descendingSet() {
      return map().descendingKeySet();
    }
    
    public K floor(K param1K) {
      return map().floorKey(param1K);
    }
    
    public NavigableSet<K> headSet(K param1K, boolean param1Boolean) {
      return map().headMap(param1K, param1Boolean).navigableKeySet();
    }
    
    public SortedSet<K> headSet(K param1K) {
      return headSet(param1K, false);
    }
    
    public K higher(K param1K) {
      return map().higherKey(param1K);
    }
    
    public K lower(K param1K) {
      return map().lowerKey(param1K);
    }
    
    NavigableMap<K, V> map() {
      return (NavigableMap<K, V>)this.map;
    }
    
    public K pollFirst() {
      return Maps.keyOrNull(map().pollFirstEntry());
    }
    
    public K pollLast() {
      return Maps.keyOrNull(map().pollLastEntry());
    }
    
    public NavigableSet<K> subSet(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return map().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2).navigableKeySet();
    }
    
    public SortedSet<K> subSet(K param1K1, K param1K2) {
      return subSet(param1K1, true, param1K2, false);
    }
    
    public NavigableSet<K> tailSet(K param1K, boolean param1Boolean) {
      return map().tailMap(param1K, param1Boolean).navigableKeySet();
    }
    
    public SortedSet<K> tailSet(K param1K) {
      return tailSet(param1K, true);
    }
  }
  
  private static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
    SortedAsMapView(SortedSet<K> param1SortedSet, Function<? super K, V> param1Function) {
      super(param1SortedSet, param1Function);
    }
    
    SortedSet<K> backingSet() {
      return (SortedSet<K>)super.backingSet();
    }
    
    public Comparator<? super K> comparator() {
      return backingSet().comparator();
    }
    
    public K firstKey() {
      return backingSet().first();
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return Maps.asMap(backingSet().headSet(param1K), this.function);
    }
    
    public Set<K> keySet() {
      return Maps.removeOnlySortedSet(backingSet());
    }
    
    public K lastKey() {
      return backingSet().last();
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return Maps.asMap(backingSet().subSet(param1K1, param1K2), this.function);
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return Maps.asMap(backingSet().tailSet(param1K), this.function);
    }
  }
  
  static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
    SortedKeySet(SortedMap<K, V> param1SortedMap) {
      super(param1SortedMap);
    }
    
    public Comparator<? super K> comparator() {
      return map().comparator();
    }
    
    public K first() {
      return map().firstKey();
    }
    
    public SortedSet<K> headSet(K param1K) {
      return new SortedKeySet(map().headMap(param1K));
    }
    
    public K last() {
      return map().lastKey();
    }
    
    SortedMap<K, V> map() {
      return (SortedMap<K, V>)super.map();
    }
    
    public SortedSet<K> subSet(K param1K1, K param1K2) {
      return new SortedKeySet(map().subMap(param1K1, param1K2));
    }
    
    public SortedSet<K> tailSet(K param1K) {
      return new SortedKeySet(map().tailMap(param1K));
    }
  }
  
  static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
    SortedMapDifferenceImpl(SortedMap<K, V> param1SortedMap1, SortedMap<K, V> param1SortedMap2, SortedMap<K, V> param1SortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> param1SortedMap) {
      super(param1SortedMap1, param1SortedMap2, param1SortedMap3, param1SortedMap);
    }
    
    public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering() {
      return (SortedMap<K, MapDifference.ValueDifference<V>>)super.entriesDiffering();
    }
    
    public SortedMap<K, V> entriesInCommon() {
      return (SortedMap<K, V>)super.entriesInCommon();
    }
    
    public SortedMap<K, V> entriesOnlyOnLeft() {
      return (SortedMap<K, V>)super.entriesOnlyOnLeft();
    }
    
    public SortedMap<K, V> entriesOnlyOnRight() {
      return (SortedMap<K, V>)super.entriesOnlyOnRight();
    }
  }
  
  static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {
    final Map<K, V1> fromMap;
    
    final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
    
    TransformedEntriesMap(Map<K, V1> param1Map, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      this.fromMap = (Map<K, V1>)Preconditions.checkNotNull(param1Map);
      this.transformer = (Maps.EntryTransformer<? super K, ? super V1, V2>)Preconditions.checkNotNull(param1EntryTransformer);
    }
    
    public void clear() {
      this.fromMap.clear();
    }
    
    public boolean containsKey(Object param1Object) {
      return this.fromMap.containsKey(param1Object);
    }
    
    Iterator<Map.Entry<K, V2>> entryIterator() {
      return Iterators.transform(this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this.transformer));
    }
    
    public V2 get(Object param1Object) {
      V1 v1 = this.fromMap.get(param1Object);
      return (v1 != null || this.fromMap.containsKey(param1Object)) ? this.transformer.transformEntry((K)param1Object, v1) : null;
    }
    
    public Set<K> keySet() {
      return this.fromMap.keySet();
    }
    
    public V2 remove(Object param1Object) {
      if (this.fromMap.containsKey(param1Object)) {
        param1Object = this.transformer.transformEntry((K)param1Object, this.fromMap.remove(param1Object));
      } else {
        param1Object = null;
      } 
      return (V2)param1Object;
    }
    
    public int size() {
      return this.fromMap.size();
    }
    
    public Collection<V2> values() {
      return new Maps.Values<Object, V2>(this);
    }
  }
  
  @GwtIncompatible
  private static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
    TransformedEntriesNavigableMap(NavigableMap<K, V1> param1NavigableMap, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      super(param1NavigableMap, param1EntryTransformer);
    }
    
    @Nullable
    private Map.Entry<K, V2> transformEntry(@Nullable Map.Entry<K, V1> param1Entry) {
      if (param1Entry == null) {
        param1Entry = null;
      } else {
        param1Entry = Maps.transformEntry(this.transformer, param1Entry);
      } 
      return param1Entry;
    }
    
    public Map.Entry<K, V2> ceilingEntry(K param1K) {
      return transformEntry(fromMap().ceilingEntry(param1K));
    }
    
    public K ceilingKey(K param1K) {
      return fromMap().ceilingKey(param1K);
    }
    
    public NavigableSet<K> descendingKeySet() {
      return fromMap().descendingKeySet();
    }
    
    public NavigableMap<K, V2> descendingMap() {
      return Maps.transformEntries(fromMap().descendingMap(), this.transformer);
    }
    
    public Map.Entry<K, V2> firstEntry() {
      return transformEntry(fromMap().firstEntry());
    }
    
    public Map.Entry<K, V2> floorEntry(K param1K) {
      return transformEntry(fromMap().floorEntry(param1K));
    }
    
    public K floorKey(K param1K) {
      return fromMap().floorKey(param1K);
    }
    
    protected NavigableMap<K, V1> fromMap() {
      return (NavigableMap<K, V1>)super.fromMap();
    }
    
    public NavigableMap<K, V2> headMap(K param1K) {
      return headMap(param1K, false);
    }
    
    public NavigableMap<K, V2> headMap(K param1K, boolean param1Boolean) {
      return Maps.transformEntries(fromMap().headMap(param1K, param1Boolean), this.transformer);
    }
    
    public Map.Entry<K, V2> higherEntry(K param1K) {
      return transformEntry(fromMap().higherEntry(param1K));
    }
    
    public K higherKey(K param1K) {
      return fromMap().higherKey(param1K);
    }
    
    public Map.Entry<K, V2> lastEntry() {
      return transformEntry(fromMap().lastEntry());
    }
    
    public Map.Entry<K, V2> lowerEntry(K param1K) {
      return transformEntry(fromMap().lowerEntry(param1K));
    }
    
    public K lowerKey(K param1K) {
      return fromMap().lowerKey(param1K);
    }
    
    public NavigableSet<K> navigableKeySet() {
      return fromMap().navigableKeySet();
    }
    
    public Map.Entry<K, V2> pollFirstEntry() {
      return transformEntry(fromMap().pollFirstEntry());
    }
    
    public Map.Entry<K, V2> pollLastEntry() {
      return transformEntry(fromMap().pollLastEntry());
    }
    
    public NavigableMap<K, V2> subMap(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, V2> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return Maps.transformEntries(fromMap().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2), this.transformer);
    }
    
    public NavigableMap<K, V2> tailMap(K param1K) {
      return tailMap(param1K, true);
    }
    
    public NavigableMap<K, V2> tailMap(K param1K, boolean param1Boolean) {
      return Maps.transformEntries(fromMap().tailMap(param1K, param1Boolean), this.transformer);
    }
  }
  
  static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
    TransformedEntriesSortedMap(SortedMap<K, V1> param1SortedMap, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      super(param1SortedMap, param1EntryTransformer);
    }
    
    public Comparator<? super K> comparator() {
      return fromMap().comparator();
    }
    
    public K firstKey() {
      return fromMap().firstKey();
    }
    
    protected SortedMap<K, V1> fromMap() {
      return (SortedMap<K, V1>)this.fromMap;
    }
    
    public SortedMap<K, V2> headMap(K param1K) {
      return Maps.transformEntries(fromMap().headMap(param1K), this.transformer);
    }
    
    public K lastKey() {
      return fromMap().lastKey();
    }
    
    public SortedMap<K, V2> subMap(K param1K1, K param1K2) {
      return Maps.transformEntries(fromMap().subMap(param1K1, param1K2), this.transformer);
    }
    
    public SortedMap<K, V2> tailMap(K param1K) {
      return Maps.transformEntries(fromMap().tailMap(param1K), this.transformer);
    }
  }
  
  private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final BiMap<? extends K, ? extends V> delegate;
    
    @RetainedWith
    BiMap<V, K> inverse;
    
    final Map<K, V> unmodifiableMap;
    
    transient Set<V> values;
    
    UnmodifiableBiMap(BiMap<? extends K, ? extends V> param1BiMap, @Nullable BiMap<V, K> param1BiMap1) {
      this.unmodifiableMap = Collections.unmodifiableMap(param1BiMap);
      this.delegate = param1BiMap;
      this.inverse = param1BiMap1;
    }
    
    protected Map<K, V> delegate() {
      return this.unmodifiableMap;
    }
    
    public V forcePut(K param1K, V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public BiMap<V, K> inverse() {
      BiMap<V, K> biMap1 = this.inverse;
      BiMap<V, K> biMap2 = biMap1;
      if (biMap1 == null) {
        biMap2 = new UnmodifiableBiMap(this.delegate.inverse(), this);
        this.inverse = biMap2;
      } 
      return biMap2;
    }
    
    public Set<V> values() {
      Set<V> set1 = this.values;
      Set<V> set2 = set1;
      if (set1 == null) {
        set2 = Collections.unmodifiableSet(this.delegate.values());
        this.values = set2;
      } 
      return set2;
    }
  }
  
  static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
    private final Collection<Map.Entry<K, V>> entries;
    
    UnmodifiableEntries(Collection<Map.Entry<K, V>> param1Collection) {
      this.entries = param1Collection;
    }
    
    protected Collection<Map.Entry<K, V>> delegate() {
      return this.entries;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return Maps.unmodifiableEntryIterator(this.entries.iterator());
    }
    
    public Object[] toArray() {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])standardToArray((Object[])param1ArrayOfT);
    }
  }
  
  static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
    UnmodifiableEntrySet(Set<Map.Entry<K, V>> param1Set) {
      super(param1Set);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      return Sets.equalsImpl(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.hashCodeImpl(this);
    }
  }
  
  @GwtIncompatible
  static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
    private final NavigableMap<K, ? extends V> delegate;
    
    private transient UnmodifiableNavigableMap<K, V> descendingMap;
    
    UnmodifiableNavigableMap(NavigableMap<K, ? extends V> param1NavigableMap) {
      this.delegate = param1NavigableMap;
    }
    
    UnmodifiableNavigableMap(NavigableMap<K, ? extends V> param1NavigableMap, UnmodifiableNavigableMap<K, V> param1UnmodifiableNavigableMap) {
      this.delegate = param1NavigableMap;
      this.descendingMap = param1UnmodifiableNavigableMap;
    }
    
    public Map.Entry<K, V> ceilingEntry(K param1K) {
      return Maps.unmodifiableOrNull(this.delegate.ceilingEntry(param1K));
    }
    
    public K ceilingKey(K param1K) {
      return this.delegate.ceilingKey(param1K);
    }
    
    protected SortedMap<K, V> delegate() {
      return Collections.unmodifiableSortedMap(this.delegate);
    }
    
    public NavigableSet<K> descendingKeySet() {
      return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
    }
    
    public NavigableMap<K, V> descendingMap() {
      UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap1 = this.descendingMap;
      UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = unmodifiableNavigableMap1;
      if (unmodifiableNavigableMap1 == null) {
        unmodifiableNavigableMap2 = new UnmodifiableNavigableMap(this.delegate.descendingMap(), this);
        this.descendingMap = unmodifiableNavigableMap2;
      } 
      return unmodifiableNavigableMap2;
    }
    
    public Map.Entry<K, V> firstEntry() {
      return Maps.unmodifiableOrNull(this.delegate.firstEntry());
    }
    
    public Map.Entry<K, V> floorEntry(K param1K) {
      return Maps.unmodifiableOrNull(this.delegate.floorEntry(param1K));
    }
    
    public K floorKey(K param1K) {
      return this.delegate.floorKey(param1K);
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      return Maps.unmodifiableNavigableMap(this.delegate.headMap(param1K, param1Boolean));
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return headMap(param1K, false);
    }
    
    public Map.Entry<K, V> higherEntry(K param1K) {
      return Maps.unmodifiableOrNull(this.delegate.higherEntry(param1K));
    }
    
    public K higherKey(K param1K) {
      return this.delegate.higherKey(param1K);
    }
    
    public Set<K> keySet() {
      return navigableKeySet();
    }
    
    public Map.Entry<K, V> lastEntry() {
      return Maps.unmodifiableOrNull(this.delegate.lastEntry());
    }
    
    public Map.Entry<K, V> lowerEntry(K param1K) {
      return Maps.unmodifiableOrNull(this.delegate.lowerEntry(param1K));
    }
    
    public K lowerKey(K param1K) {
      return this.delegate.lowerKey(param1K);
    }
    
    public NavigableSet<K> navigableKeySet() {
      return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
    }
    
    public final Map.Entry<K, V> pollFirstEntry() {
      throw new UnsupportedOperationException();
    }
    
    public final Map.Entry<K, V> pollLastEntry() {
      throw new UnsupportedOperationException();
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return Maps.unmodifiableNavigableMap(this.delegate.subMap(param1K1, param1Boolean1, param1K2, param1Boolean2));
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      return Maps.unmodifiableNavigableMap(this.delegate.tailMap(param1K, param1Boolean));
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return tailMap(param1K, true);
    }
  }
  
  static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {
    private final V left;
    
    private final V right;
    
    private ValueDifferenceImpl(@Nullable V param1V1, @Nullable V param1V2) {
      this.left = param1V1;
      this.right = param1V2;
    }
    
    static <V> MapDifference.ValueDifference<V> create(@Nullable V param1V1, @Nullable V param1V2) {
      return new ValueDifferenceImpl<V>(param1V1, param1V2);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof MapDifference.ValueDifference;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (Objects.equal(this.left, param1Object.leftValue())) {
          bool = bool1;
          if (Objects.equal(this.right, param1Object.rightValue()))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.left, this.right });
    }
    
    public V leftValue() {
      return this.left;
    }
    
    public V rightValue() {
      return this.right;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(this.left);
      stringBuilder.append(", ");
      stringBuilder.append(this.right);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class Values<K, V> extends AbstractCollection<V> {
    @Weak
    final Map<K, V> map;
    
    Values(Map<K, V> param1Map) {
      this.map = (Map<K, V>)Preconditions.checkNotNull(param1Map);
    }
    
    public void clear() {
      map().clear();
    }
    
    public boolean contains(@Nullable Object param1Object) {
      return map().containsValue(param1Object);
    }
    
    public boolean isEmpty() {
      return map().isEmpty();
    }
    
    public Iterator<V> iterator() {
      return Maps.valueIterator(map().entrySet().iterator());
    }
    
    final Map<K, V> map() {
      return this.map;
    }
    
    public boolean remove(Object param1Object) {
      try {
        return super.remove(param1Object);
      } catch (UnsupportedOperationException unsupportedOperationException) {
        for (Map.Entry<K, V> entry : map().entrySet()) {
          if (Objects.equal(param1Object, entry.getValue())) {
            map().remove(entry.getKey());
            return true;
          } 
        } 
        return false;
      } 
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      try {
        return super.removeAll((Collection)Preconditions.checkNotNull(param1Collection));
      } catch (UnsupportedOperationException unsupportedOperationException) {
        HashSet<?> hashSet = Sets.newHashSet();
        for (Map.Entry<K, V> entry : map().entrySet()) {
          if (param1Collection.contains(entry.getValue()))
            hashSet.add(entry.getKey()); 
        } 
        return map().keySet().removeAll(hashSet);
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      try {
        return super.retainAll((Collection)Preconditions.checkNotNull(param1Collection));
      } catch (UnsupportedOperationException unsupportedOperationException) {
        HashSet<?> hashSet = Sets.newHashSet();
        for (Map.Entry<K, V> entry : map().entrySet()) {
          if (param1Collection.contains(entry.getValue()))
            hashSet.add(entry.getKey()); 
        } 
        return map().keySet().retainAll(hashSet);
      } 
    }
    
    public int size() {
      return map().size();
    }
  }
  
  @GwtCompatible
  static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {
    private transient Set<Map.Entry<K, V>> entrySet;
    
    private transient Set<K> keySet;
    
    private transient Collection<V> values;
    
    abstract Set<Map.Entry<K, V>> createEntrySet();
    
    Set<K> createKeySet() {
      return new Maps.KeySet<K, Object>(this);
    }
    
    Collection<V> createValues() {
      return new Maps.Values<Object, V>(this);
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      Set<Map.Entry<K, V>> set1 = this.entrySet;
      Set<Map.Entry<K, V>> set2 = set1;
      if (set1 == null) {
        set2 = createEntrySet();
        this.entrySet = set2;
      } 
      return set2;
    }
    
    public Set<K> keySet() {
      Set<K> set1 = this.keySet;
      Set<K> set2 = set1;
      if (set1 == null) {
        set2 = createKeySet();
        this.keySet = set2;
      } 
      return set2;
    }
    
    public Collection<V> values() {
      Collection<V> collection1 = this.values;
      Collection<V> collection2 = collection1;
      if (collection1 == null) {
        collection2 = createValues();
        this.values = collection2;
      } 
      return collection2;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Maps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */