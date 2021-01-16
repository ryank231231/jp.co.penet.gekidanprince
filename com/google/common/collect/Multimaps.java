package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Multimaps {
  @Beta
  public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> paramListMultimap) {
    return (Map)paramListMultimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> paramMultimap) {
    return paramMultimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> paramSetMultimap) {
    return (Map)paramSetMultimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> paramSortedSetMultimap) {
    return (Map)paramSortedSetMultimap.asMap();
  }
  
  static boolean equalsImpl(Multimap<?, ?> paramMultimap, @Nullable Object paramObject) {
    if (paramObject == paramMultimap)
      return true; 
    if (paramObject instanceof Multimap) {
      paramObject = paramObject;
      return paramMultimap.asMap().equals(paramObject.asMap());
    } 
    return false;
  }
  
  public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> paramMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    if (paramMultimap instanceof SetMultimap)
      return filterEntries((SetMultimap<K, V>)paramMultimap, paramPredicate); 
    if (paramMultimap instanceof FilteredMultimap) {
      paramMultimap = filterFiltered((FilteredMultimap<K, V>)paramMultimap, paramPredicate);
    } else {
      paramMultimap = new FilteredEntryMultimap<K, V>((Multimap<K, V>)Preconditions.checkNotNull(paramMultimap), paramPredicate);
    } 
    return paramMultimap;
  }
  
  public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> paramSetMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    if (paramSetMultimap instanceof FilteredSetMultimap) {
      paramSetMultimap = filterFiltered((FilteredSetMultimap<K, V>)paramSetMultimap, paramPredicate);
    } else {
      paramSetMultimap = new FilteredEntrySetMultimap<K, V>((SetMultimap<K, V>)Preconditions.checkNotNull(paramSetMultimap), paramPredicate);
    } 
    return paramSetMultimap;
  }
  
  private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> paramFilteredMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    paramPredicate = Predicates.and(paramFilteredMultimap.entryPredicate(), paramPredicate);
    return new FilteredEntryMultimap<K, V>(paramFilteredMultimap.unfiltered(), paramPredicate);
  }
  
  private static <K, V> SetMultimap<K, V> filterFiltered(FilteredSetMultimap<K, V> paramFilteredSetMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    paramPredicate = Predicates.and(paramFilteredSetMultimap.entryPredicate(), paramPredicate);
    return new FilteredEntrySetMultimap<K, V>(paramFilteredSetMultimap.unfiltered(), paramPredicate);
  }
  
  public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> paramListMultimap, Predicate<? super K> paramPredicate) {
    if (paramListMultimap instanceof FilteredKeyListMultimap) {
      paramListMultimap = paramListMultimap;
      return new FilteredKeyListMultimap<K, V>(paramListMultimap.unfiltered(), Predicates.and(((FilteredKeyListMultimap)paramListMultimap).keyPredicate, paramPredicate));
    } 
    return new FilteredKeyListMultimap<K, V>(paramListMultimap, paramPredicate);
  }
  
  public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> paramMultimap, Predicate<? super K> paramPredicate) {
    if (paramMultimap instanceof SetMultimap)
      return filterKeys((SetMultimap<K, V>)paramMultimap, paramPredicate); 
    if (paramMultimap instanceof ListMultimap)
      return filterKeys((ListMultimap<K, V>)paramMultimap, paramPredicate); 
    if (paramMultimap instanceof FilteredKeyMultimap) {
      paramMultimap = paramMultimap;
      return new FilteredKeyMultimap<K, V>(((FilteredKeyMultimap)paramMultimap).unfiltered, Predicates.and(((FilteredKeyMultimap)paramMultimap).keyPredicate, paramPredicate));
    } 
    return (paramMultimap instanceof FilteredMultimap) ? filterFiltered((FilteredMultimap<K, V>)paramMultimap, (Predicate)Maps.keyPredicateOnEntries(paramPredicate)) : new FilteredKeyMultimap<K, V>(paramMultimap, paramPredicate);
  }
  
  public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> paramSetMultimap, Predicate<? super K> paramPredicate) {
    if (paramSetMultimap instanceof FilteredKeySetMultimap) {
      paramSetMultimap = paramSetMultimap;
      return new FilteredKeySetMultimap<K, V>(paramSetMultimap.unfiltered(), Predicates.and(((FilteredKeySetMultimap)paramSetMultimap).keyPredicate, paramPredicate));
    } 
    return (paramSetMultimap instanceof FilteredSetMultimap) ? filterFiltered((FilteredSetMultimap<K, V>)paramSetMultimap, (Predicate)Maps.keyPredicateOnEntries(paramPredicate)) : new FilteredKeySetMultimap<K, V>(paramSetMultimap, paramPredicate);
  }
  
  public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> paramMultimap, Predicate<? super V> paramPredicate) {
    return filterEntries(paramMultimap, (Predicate)Maps.valuePredicateOnEntries(paramPredicate));
  }
  
  public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> paramSetMultimap, Predicate<? super V> paramPredicate) {
    return filterEntries(paramSetMultimap, (Predicate)Maps.valuePredicateOnEntries(paramPredicate));
  }
  
  public static <K, V> SetMultimap<K, V> forMap(Map<K, V> paramMap) {
    return new MapMultimap<K, V>(paramMap);
  }
  
  public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> paramIterable, Function<? super V, K> paramFunction) {
    return index(paramIterable.iterator(), paramFunction);
  }
  
  public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> paramIterator, Function<? super V, K> paramFunction) {
    Preconditions.checkNotNull(paramFunction);
    ImmutableListMultimap.Builder<?, ?> builder = ImmutableListMultimap.builder();
    while (paramIterator.hasNext()) {
      V v = paramIterator.next();
      Preconditions.checkNotNull(v, paramIterator);
      builder.put(paramFunction.apply(v), v);
    } 
    return (ImmutableListMultimap)builder.build();
  }
  
  @CanIgnoreReturnValue
  public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> paramMultimap, M paramM) {
    Preconditions.checkNotNull(paramM);
    for (Map.Entry<? extends V, ? extends K> entry : paramMultimap.entries())
      paramM.put(entry.getValue(), entry.getKey()); 
    return paramM;
  }
  
  public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends List<V>> paramSupplier) {
    return new CustomListMultimap<K, V>(paramMap, paramSupplier);
  }
  
  public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Collection<V>> paramSupplier) {
    return new CustomMultimap<K, V>(paramMap, paramSupplier);
  }
  
  public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Set<V>> paramSupplier) {
    return new CustomSetMultimap<K, V>(paramMap, paramSupplier);
  }
  
  public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends SortedSet<V>> paramSupplier) {
    return new CustomSortedSetMultimap<K, V>(paramMap, paramSupplier);
  }
  
  public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> paramListMultimap) {
    return Synchronized.listMultimap(paramListMultimap, null);
  }
  
  public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> paramMultimap) {
    return Synchronized.multimap(paramMultimap, null);
  }
  
  public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> paramSetMultimap) {
    return Synchronized.setMultimap(paramSetMultimap, null);
  }
  
  public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap) {
    return Synchronized.sortedSetMultimap(paramSortedSetMultimap, null);
  }
  
  public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> paramListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesListMultimap<K, V1, V2>(paramListMultimap, paramEntryTransformer);
  }
  
  public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> paramMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesMultimap<K, V1, V2>(paramMultimap, paramEntryTransformer);
  }
  
  public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> paramListMultimap, Function<? super V1, V2> paramFunction) {
    Preconditions.checkNotNull(paramFunction);
    return transformEntries(paramListMultimap, Maps.asEntryTransformer(paramFunction));
  }
  
  public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> paramMultimap, Function<? super V1, V2> paramFunction) {
    Preconditions.checkNotNull(paramFunction);
    return transformEntries(paramMultimap, Maps.asEntryTransformer(paramFunction));
  }
  
  private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> paramCollection) {
    return (Collection<Map.Entry<K, V>>)((paramCollection instanceof Set) ? Maps.unmodifiableEntrySet((Set<Map.Entry<K, V>>)paramCollection) : new Maps.UnmodifiableEntries<K, V>(Collections.unmodifiableCollection(paramCollection)));
  }
  
  @Deprecated
  public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> paramImmutableListMultimap) {
    return (ListMultimap<K, V>)Preconditions.checkNotNull(paramImmutableListMultimap);
  }
  
  public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> paramListMultimap) {
    return (paramListMultimap instanceof UnmodifiableListMultimap || paramListMultimap instanceof ImmutableListMultimap) ? paramListMultimap : new UnmodifiableListMultimap<K, V>(paramListMultimap);
  }
  
  @Deprecated
  public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> paramImmutableMultimap) {
    return (Multimap<K, V>)Preconditions.checkNotNull(paramImmutableMultimap);
  }
  
  public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> paramMultimap) {
    return (paramMultimap instanceof UnmodifiableMultimap || paramMultimap instanceof ImmutableMultimap) ? paramMultimap : new UnmodifiableMultimap<K, V>(paramMultimap);
  }
  
  @Deprecated
  public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> paramImmutableSetMultimap) {
    return (SetMultimap<K, V>)Preconditions.checkNotNull(paramImmutableSetMultimap);
  }
  
  public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> paramSetMultimap) {
    return (paramSetMultimap instanceof UnmodifiableSetMultimap || paramSetMultimap instanceof ImmutableSetMultimap) ? paramSetMultimap : new UnmodifiableSetMultimap<K, V>(paramSetMultimap);
  }
  
  public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap) {
    return (paramSortedSetMultimap instanceof UnmodifiableSortedSetMultimap) ? paramSortedSetMultimap : new UnmodifiableSortedSetMultimap<K, V>(paramSortedSetMultimap);
  }
  
  private static <V> Collection<V> unmodifiableValueCollection(Collection<V> paramCollection) {
    return (paramCollection instanceof SortedSet) ? Collections.unmodifiableSortedSet((SortedSet<V>)paramCollection) : ((paramCollection instanceof Set) ? Collections.unmodifiableSet((Set<? extends V>)paramCollection) : ((paramCollection instanceof List) ? Collections.unmodifiableList((List<? extends V>)paramCollection) : Collections.unmodifiableCollection(paramCollection)));
  }
  
  static final class AsMap<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
    @Weak
    private final Multimap<K, V> multimap;
    
    AsMap(Multimap<K, V> param1Multimap) {
      this.multimap = (Multimap<K, V>)Preconditions.checkNotNull(param1Multimap);
    }
    
    public void clear() {
      this.multimap.clear();
    }
    
    public boolean containsKey(Object param1Object) {
      return this.multimap.containsKey(param1Object);
    }
    
    protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
      return new EntrySet();
    }
    
    public Collection<V> get(Object<V> param1Object) {
      if (containsKey(param1Object)) {
        param1Object = (Object<V>)this.multimap.get((K)param1Object);
      } else {
        param1Object = null;
      } 
      return (Collection<V>)param1Object;
    }
    
    public boolean isEmpty() {
      return this.multimap.isEmpty();
    }
    
    public Set<K> keySet() {
      return this.multimap.keySet();
    }
    
    public Collection<V> remove(Object<V> param1Object) {
      if (containsKey(param1Object)) {
        param1Object = (Object<V>)this.multimap.removeAll(param1Object);
      } else {
        param1Object = null;
      } 
      return (Collection<V>)param1Object;
    }
    
    void removeValuesForKey(Object param1Object) {
      this.multimap.keySet().remove(param1Object);
    }
    
    public int size() {
      return this.multimap.keySet().size();
    }
    
    class EntrySet extends Maps.EntrySet<K, Collection<V>> {
      public Iterator<Map.Entry<K, Collection<V>>> iterator() {
        return Maps.asMapEntryIterator(Multimaps.AsMap.this.multimap.keySet(), new Function<K, Collection<V>>() {
              public Collection<V> apply(K param3K) {
                return Multimaps.AsMap.this.multimap.get(param3K);
              }
            });
      }
      
      Map<K, Collection<V>> map() {
        return Multimaps.AsMap.this;
      }
      
      public boolean remove(Object param2Object) {
        if (!contains(param2Object))
          return false; 
        param2Object = param2Object;
        Multimaps.AsMap.this.removeValuesForKey(param2Object.getKey());
        return true;
      }
    }
    
    class null implements Function<K, Collection<V>> {
      public Collection<V> apply(K param2K) {
        return Multimaps.AsMap.this.multimap.get(param2K);
      }
    }
  }
  
  class EntrySet extends Maps.EntrySet<K, Collection<V>> {
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return Maps.asMapEntryIterator(this.this$0.multimap.keySet(), new Function<K, Collection<V>>() {
            public Collection<V> apply(K param3K) {
              return this.this$1.this$0.multimap.get(param3K);
            }
          });
    }
    
    Map<K, Collection<V>> map() {
      return this.this$0;
    }
    
    public boolean remove(Object param1Object) {
      if (!contains(param1Object))
        return false; 
      param1Object = param1Object;
      this.this$0.removeValuesForKey(param1Object.getKey());
      return true;
    }
  }
  
  class null implements Function<K, Collection<V>> {
    public Collection<V> apply(K param1K) {
      return this.this$1.this$0.multimap.get(param1K);
    }
  }
  
  private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0L;
    
    transient Supplier<? extends List<V>> factory;
    
    CustomListMultimap(Map<K, Collection<V>> param1Map, Supplier<? extends List<V>> param1Supplier) {
      super(param1Map);
      this.factory = (Supplier<? extends List<V>>)Preconditions.checkNotNull(param1Supplier);
    }
    
    @GwtIncompatible
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      param1ObjectInputStream.defaultReadObject();
      this.factory = (Supplier<? extends List<V>>)param1ObjectInputStream.readObject();
      setMap((Map<K, Collection<V>>)param1ObjectInputStream.readObject());
    }
    
    @GwtIncompatible
    private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
      param1ObjectOutputStream.defaultWriteObject();
      param1ObjectOutputStream.writeObject(this.factory);
      param1ObjectOutputStream.writeObject(backingMap());
    }
    
    protected List<V> createCollection() {
      return (List<V>)this.factory.get();
    }
  }
  
  private static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0L;
    
    transient Supplier<? extends Collection<V>> factory;
    
    CustomMultimap(Map<K, Collection<V>> param1Map, Supplier<? extends Collection<V>> param1Supplier) {
      super(param1Map);
      this.factory = (Supplier<? extends Collection<V>>)Preconditions.checkNotNull(param1Supplier);
    }
    
    @GwtIncompatible
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      param1ObjectInputStream.defaultReadObject();
      this.factory = (Supplier<? extends Collection<V>>)param1ObjectInputStream.readObject();
      setMap((Map<K, Collection<V>>)param1ObjectInputStream.readObject());
    }
    
    @GwtIncompatible
    private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
      param1ObjectOutputStream.defaultWriteObject();
      param1ObjectOutputStream.writeObject(this.factory);
      param1ObjectOutputStream.writeObject(backingMap());
    }
    
    protected Collection<V> createCollection() {
      return (Collection<V>)this.factory.get();
    }
  }
  
  private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0L;
    
    transient Supplier<? extends Set<V>> factory;
    
    CustomSetMultimap(Map<K, Collection<V>> param1Map, Supplier<? extends Set<V>> param1Supplier) {
      super(param1Map);
      this.factory = (Supplier<? extends Set<V>>)Preconditions.checkNotNull(param1Supplier);
    }
    
    @GwtIncompatible
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      param1ObjectInputStream.defaultReadObject();
      this.factory = (Supplier<? extends Set<V>>)param1ObjectInputStream.readObject();
      setMap((Map<K, Collection<V>>)param1ObjectInputStream.readObject());
    }
    
    @GwtIncompatible
    private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
      param1ObjectOutputStream.defaultWriteObject();
      param1ObjectOutputStream.writeObject(this.factory);
      param1ObjectOutputStream.writeObject(backingMap());
    }
    
    protected Set<V> createCollection() {
      return (Set<V>)this.factory.get();
    }
  }
  
  private static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0L;
    
    transient Supplier<? extends SortedSet<V>> factory;
    
    transient Comparator<? super V> valueComparator;
    
    CustomSortedSetMultimap(Map<K, Collection<V>> param1Map, Supplier<? extends SortedSet<V>> param1Supplier) {
      super(param1Map);
      this.factory = (Supplier<? extends SortedSet<V>>)Preconditions.checkNotNull(param1Supplier);
      this.valueComparator = ((SortedSet<V>)param1Supplier.get()).comparator();
    }
    
    @GwtIncompatible
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      param1ObjectInputStream.defaultReadObject();
      this.factory = (Supplier<? extends SortedSet<V>>)param1ObjectInputStream.readObject();
      this.valueComparator = ((SortedSet<V>)this.factory.get()).comparator();
      setMap((Map<K, Collection<V>>)param1ObjectInputStream.readObject());
    }
    
    @GwtIncompatible
    private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
      param1ObjectOutputStream.defaultWriteObject();
      param1ObjectOutputStream.writeObject(this.factory);
      param1ObjectOutputStream.writeObject(backingMap());
    }
    
    protected SortedSet<V> createCollection() {
      return (SortedSet<V>)this.factory.get();
    }
    
    public Comparator<? super V> valueComparator() {
      return this.valueComparator;
    }
  }
  
  static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
    public void clear() {
      multimap().clear();
    }
    
    public boolean contains(@Nullable Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return multimap().containsEntry(param1Object.getKey(), param1Object.getValue());
      } 
      return false;
    }
    
    abstract Multimap<K, V> multimap();
    
    public boolean remove(@Nullable Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return multimap().remove(param1Object.getKey(), param1Object.getValue());
      } 
      return false;
    }
    
    public int size() {
      return multimap().size();
    }
  }
  
  static class Keys<K, V> extends AbstractMultiset<K> {
    @Weak
    final Multimap<K, V> multimap;
    
    Keys(Multimap<K, V> param1Multimap) {
      this.multimap = param1Multimap;
    }
    
    public void clear() {
      this.multimap.clear();
    }
    
    public boolean contains(@Nullable Object param1Object) {
      return this.multimap.containsKey(param1Object);
    }
    
    public int count(@Nullable Object param1Object) {
      int i;
      param1Object = Maps.<Collection>safeGet((Map)this.multimap.asMap(), param1Object);
      if (param1Object == null) {
        i = 0;
      } else {
        i = param1Object.size();
      } 
      return i;
    }
    
    Set<Multiset.Entry<K>> createEntrySet() {
      return new KeysEntrySet();
    }
    
    int distinctElements() {
      return this.multimap.asMap().size();
    }
    
    public Set<K> elementSet() {
      return this.multimap.keySet();
    }
    
    Iterator<Multiset.Entry<K>> entryIterator() {
      return new TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>(this.multimap.asMap().entrySet().iterator()) {
          Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> backingEntry) {
            return new Multisets.AbstractEntry<K>() {
                public int getCount() {
                  return ((Collection)backingEntry.getValue()).size();
                }
                
                public K getElement() {
                  return (K)backingEntry.getKey();
                }
              };
          }
        };
    }
    
    public Iterator<K> iterator() {
      return Maps.keyIterator(this.multimap.entries().iterator());
    }
    
    public int remove(@Nullable Object param1Object, int param1Int) {
      CollectPreconditions.checkNonnegative(param1Int, "occurrences");
      if (param1Int == 0)
        return count(param1Object); 
      param1Object = Maps.<Collection>safeGet((Map)this.multimap.asMap(), param1Object);
      byte b = 0;
      if (param1Object == null)
        return 0; 
      int i = param1Object.size();
      if (param1Int >= i) {
        param1Object.clear();
      } else {
        param1Object = param1Object.iterator();
        while (b < param1Int) {
          param1Object.next();
          param1Object.remove();
          b++;
        } 
      } 
      return i;
    }
    
    class KeysEntrySet extends Multisets.EntrySet<K> {
      public boolean contains(@Nullable Object param2Object) {
        boolean bool = param2Object instanceof Multiset.Entry;
        boolean bool1 = false;
        if (bool) {
          param2Object = param2Object;
          Collection collection = (Collection)Multimaps.Keys.this.multimap.asMap().get(param2Object.getElement());
          bool = bool1;
          if (collection != null) {
            bool = bool1;
            if (collection.size() == param2Object.getCount())
              bool = true; 
          } 
          return bool;
        } 
        return false;
      }
      
      public boolean isEmpty() {
        return Multimaps.Keys.this.multimap.isEmpty();
      }
      
      public Iterator<Multiset.Entry<K>> iterator() {
        return Multimaps.Keys.this.entryIterator();
      }
      
      Multiset<K> multiset() {
        return Multimaps.Keys.this;
      }
      
      public boolean remove(@Nullable Object param2Object) {
        if (param2Object instanceof Multiset.Entry) {
          param2Object = param2Object;
          Collection collection = (Collection)Multimaps.Keys.this.multimap.asMap().get(param2Object.getElement());
          if (collection != null && collection.size() == param2Object.getCount()) {
            collection.clear();
            return true;
          } 
        } 
        return false;
      }
      
      public int size() {
        return Multimaps.Keys.this.distinctElements();
      }
    }
  }
  
  class null extends TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>> {
    null(Iterator<? extends Map.Entry<K, Collection<V>>> param1Iterator) {
      super(param1Iterator);
    }
    
    Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> backingEntry) {
      return new Multisets.AbstractEntry() {
          public int getCount() {
            return ((Collection)backingEntry.getValue()).size();
          }
          
          public K getElement() {
            return (K)backingEntry.getKey();
          }
        };
    }
  }
  
  class null extends Multisets.AbstractEntry<K> {
    public int getCount() {
      return ((Collection)backingEntry.getValue()).size();
    }
    
    public K getElement() {
      return (K)backingEntry.getKey();
    }
  }
  
  class KeysEntrySet extends Multisets.EntrySet<K> {
    public boolean contains(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof Multiset.Entry;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        Collection collection = (Collection)this.this$0.multimap.asMap().get(param1Object.getElement());
        bool = bool1;
        if (collection != null) {
          bool = bool1;
          if (collection.size() == param1Object.getCount())
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public boolean isEmpty() {
      return this.this$0.multimap.isEmpty();
    }
    
    public Iterator<Multiset.Entry<K>> iterator() {
      return this.this$0.entryIterator();
    }
    
    Multiset<K> multiset() {
      return this.this$0;
    }
    
    public boolean remove(@Nullable Object param1Object) {
      if (param1Object instanceof Multiset.Entry) {
        param1Object = param1Object;
        Collection collection = (Collection)this.this$0.multimap.asMap().get(param1Object.getElement());
        if (collection != null && collection.size() == param1Object.getCount()) {
          collection.clear();
          return true;
        } 
      } 
      return false;
    }
    
    public int size() {
      return this.this$0.distinctElements();
    }
  }
  
  private static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {
    private static final long serialVersionUID = 7845222491160860175L;
    
    final Map<K, V> map;
    
    MapMultimap(Map<K, V> param1Map) {
      this.map = (Map<K, V>)Preconditions.checkNotNull(param1Map);
    }
    
    public void clear() {
      this.map.clear();
    }
    
    public boolean containsEntry(Object param1Object1, Object param1Object2) {
      return this.map.entrySet().contains(Maps.immutableEntry(param1Object1, param1Object2));
    }
    
    public boolean containsKey(Object param1Object) {
      return this.map.containsKey(param1Object);
    }
    
    public boolean containsValue(Object param1Object) {
      return this.map.containsValue(param1Object);
    }
    
    Map<K, Collection<V>> createAsMap() {
      return new Multimaps.AsMap<K, V>(this);
    }
    
    public Set<Map.Entry<K, V>> entries() {
      return this.map.entrySet();
    }
    
    Iterator<Map.Entry<K, V>> entryIterator() {
      return this.map.entrySet().iterator();
    }
    
    public Set<V> get(final K key) {
      return new Sets.ImprovedAbstractSet<V>() {
          public Iterator<V> iterator() {
            return new Iterator<V>() {
                int i;
                
                public boolean hasNext() {
                  boolean bool;
                  if (this.i == 0 && Multimaps.MapMultimap.this.map.containsKey(key)) {
                    bool = true;
                  } else {
                    bool = false;
                  } 
                  return bool;
                }
                
                public V next() {
                  if (hasNext()) {
                    this.i++;
                    return (V)Multimaps.MapMultimap.this.map.get(key);
                  } 
                  throw new NoSuchElementException();
                }
                
                public void remove() {
                  int i = this.i;
                  boolean bool = true;
                  if (i != 1)
                    bool = false; 
                  CollectPreconditions.checkRemove(bool);
                  this.i = -1;
                  Multimaps.MapMultimap.this.map.remove(key);
                }
              };
          }
          
          public int size() {
            return Multimaps.MapMultimap.this.map.containsKey(key);
          }
        };
    }
    
    public int hashCode() {
      return this.map.hashCode();
    }
    
    public Set<K> keySet() {
      return this.map.keySet();
    }
    
    public boolean put(K param1K, V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> param1Multimap) {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K param1K, Iterable<? extends V> param1Iterable) {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object param1Object1, Object param1Object2) {
      return this.map.entrySet().remove(Maps.immutableEntry(param1Object1, param1Object2));
    }
    
    public Set<V> removeAll(Object param1Object) {
      HashSet<V> hashSet = new HashSet(2);
      if (!this.map.containsKey(param1Object))
        return hashSet; 
      hashSet.add(this.map.remove(param1Object));
      return hashSet;
    }
    
    public Set<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      throw new UnsupportedOperationException();
    }
    
    public int size() {
      return this.map.size();
    }
    
    public Collection<V> values() {
      return this.map.values();
    }
  }
  
  class null extends Sets.ImprovedAbstractSet<V> {
    public Iterator<V> iterator() {
      return new Iterator() {
          int i;
          
          public boolean hasNext() {
            boolean bool;
            if (this.i == 0 && this.this$1.this$0.map.containsKey(key)) {
              bool = true;
            } else {
              bool = false;
            } 
            return bool;
          }
          
          public V next() {
            if (hasNext()) {
              this.i++;
              return (V)this.this$1.this$0.map.get(key);
            } 
            throw new NoSuchElementException();
          }
          
          public void remove() {
            int i = this.i;
            boolean bool = true;
            if (i != 1)
              bool = false; 
            CollectPreconditions.checkRemove(bool);
            this.i = -1;
            this.this$1.this$0.map.remove(key);
          }
        };
    }
    
    public int size() {
      return this.this$0.map.containsKey(key);
    }
  }
  
  class null implements Iterator<V> {
    int i;
    
    public boolean hasNext() {
      boolean bool;
      if (this.i == 0 && this.this$1.this$0.map.containsKey(key)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public V next() {
      if (hasNext()) {
        this.i++;
        return (V)this.this$1.this$0.map.get(key);
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      int i = this.i;
      boolean bool = true;
      if (i != 1)
        bool = false; 
      CollectPreconditions.checkRemove(bool);
      this.i = -1;
      this.this$1.this$0.map.remove(key);
    }
  }
  
  private static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {
    TransformedEntriesListMultimap(ListMultimap<K, V1> param1ListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      super(param1ListMultimap, param1EntryTransformer);
    }
    
    public List<V2> get(K param1K) {
      return transform(param1K, this.fromMultimap.get(param1K));
    }
    
    public List<V2> removeAll(Object param1Object) {
      return transform((K)param1Object, this.fromMultimap.removeAll(param1Object));
    }
    
    public List<V2> replaceValues(K param1K, Iterable<? extends V2> param1Iterable) {
      throw new UnsupportedOperationException();
    }
    
    List<V2> transform(K param1K, Collection<V1> param1Collection) {
      return Lists.transform((List)param1Collection, Maps.asValueToValueFunction(this.transformer, param1K));
    }
  }
  
  private static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2> {
    final Multimap<K, V1> fromMultimap;
    
    final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
    
    TransformedEntriesMultimap(Multimap<K, V1> param1Multimap, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      this.fromMultimap = (Multimap<K, V1>)Preconditions.checkNotNull(param1Multimap);
      this.transformer = (Maps.EntryTransformer<? super K, ? super V1, V2>)Preconditions.checkNotNull(param1EntryTransformer);
    }
    
    public void clear() {
      this.fromMultimap.clear();
    }
    
    public boolean containsKey(Object param1Object) {
      return this.fromMultimap.containsKey(param1Object);
    }
    
    Map<K, Collection<V2>> createAsMap() {
      return Maps.transformEntries(this.fromMultimap.asMap(), (Maps.EntryTransformer)new Maps.EntryTransformer<K, Collection<Collection<V1>>, Collection<Collection<V2>>>() {
            public Collection<V2> transformEntry(K param2K, Collection<V1> param2Collection) {
              return Multimaps.TransformedEntriesMultimap.this.transform(param2K, param2Collection);
            }
          });
    }
    
    Collection<V2> createValues() {
      return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
    }
    
    Iterator<Map.Entry<K, V2>> entryIterator() {
      return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
    }
    
    public Collection<V2> get(K param1K) {
      return transform(param1K, this.fromMultimap.get(param1K));
    }
    
    public boolean isEmpty() {
      return this.fromMultimap.isEmpty();
    }
    
    public Set<K> keySet() {
      return this.fromMultimap.keySet();
    }
    
    public Multiset<K> keys() {
      return this.fromMultimap.keys();
    }
    
    public boolean put(K param1K, V2 param1V2) {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V2> param1Multimap) {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K param1K, Iterable<? extends V2> param1Iterable) {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object param1Object1, Object param1Object2) {
      return get((K)param1Object1).remove(param1Object2);
    }
    
    public Collection<V2> removeAll(Object param1Object) {
      return transform((K)param1Object, this.fromMultimap.removeAll(param1Object));
    }
    
    public Collection<V2> replaceValues(K param1K, Iterable<? extends V2> param1Iterable) {
      throw new UnsupportedOperationException();
    }
    
    public int size() {
      return this.fromMultimap.size();
    }
    
    Collection<V2> transform(K param1K, Collection<V1> param1Collection) {
      Function<? super V1, V2> function = Maps.asValueToValueFunction(this.transformer, param1K);
      return (param1Collection instanceof List) ? Lists.transform((List<V1>)param1Collection, function) : Collections2.transform(param1Collection, function);
    }
  }
  
  class null implements Maps.EntryTransformer<K, Collection<V1>, Collection<V2>> {
    public Collection<V2> transformEntry(K param1K, Collection<V1> param1Collection) {
      return this.this$0.transform(param1K, param1Collection);
    }
  }
  
  private static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableListMultimap(ListMultimap<K, V> param1ListMultimap) {
      super(param1ListMultimap);
    }
    
    public ListMultimap<K, V> delegate() {
      return (ListMultimap<K, V>)super.delegate();
    }
    
    public List<V> get(K param1K) {
      return Collections.unmodifiableList(delegate().get(param1K));
    }
    
    public List<V> removeAll(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public List<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      throw new UnsupportedOperationException();
    }
  }
  
  private static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final Multimap<K, V> delegate;
    
    transient Collection<Map.Entry<K, V>> entries;
    
    transient Set<K> keySet;
    
    transient Multiset<K> keys;
    
    transient Map<K, Collection<V>> map;
    
    transient Collection<V> values;
    
    UnmodifiableMultimap(Multimap<K, V> param1Multimap) {
      this.delegate = (Multimap<K, V>)Preconditions.checkNotNull(param1Multimap);
    }
    
    public Map<K, Collection<V>> asMap() {
      Map<K, Collection<V>> map1 = this.map;
      Map<K, Collection<V>> map2 = map1;
      if (map1 == null) {
        map2 = Collections.unmodifiableMap(Maps.transformValues(this.delegate.asMap(), new Function<Collection<V>, Collection<V>>() {
                public Collection<V> apply(Collection<V> param2Collection) {
                  return Multimaps.unmodifiableValueCollection(param2Collection);
                }
              }));
        this.map = map2;
      } 
      return map2;
    }
    
    public void clear() {
      throw new UnsupportedOperationException();
    }
    
    protected Multimap<K, V> delegate() {
      return this.delegate;
    }
    
    public Collection<Map.Entry<K, V>> entries() {
      Collection<Map.Entry<K, V>> collection1 = this.entries;
      Collection<Map.Entry<K, V>> collection2 = collection1;
      if (collection1 == null) {
        collection2 = Multimaps.unmodifiableEntries(this.delegate.entries());
        this.entries = collection2;
      } 
      return collection2;
    }
    
    public Collection<V> get(K param1K) {
      return Multimaps.unmodifiableValueCollection(this.delegate.get(param1K));
    }
    
    public Set<K> keySet() {
      Set<K> set1 = this.keySet;
      Set<K> set2 = set1;
      if (set1 == null) {
        set2 = Collections.unmodifiableSet(this.delegate.keySet());
        this.keySet = set2;
      } 
      return set2;
    }
    
    public Multiset<K> keys() {
      Multiset<K> multiset1 = this.keys;
      Multiset<K> multiset2 = multiset1;
      if (multiset1 == null) {
        multiset2 = Multisets.unmodifiableMultiset(this.delegate.keys());
        this.keys = multiset2;
      } 
      return multiset2;
    }
    
    public boolean put(K param1K, V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> param1Multimap) {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K param1K, Iterable<? extends V> param1Iterable) {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object param1Object1, Object param1Object2) {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> removeAll(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> values() {
      Collection<V> collection1 = this.values;
      Collection<V> collection2 = collection1;
      if (collection1 == null) {
        collection2 = Collections.unmodifiableCollection(this.delegate.values());
        this.values = collection2;
      } 
      return collection2;
    }
  }
  
  class null implements Function<Collection<V>, Collection<V>> {
    public Collection<V> apply(Collection<V> param1Collection) {
      return Multimaps.unmodifiableValueCollection(param1Collection);
    }
  }
  
  private static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableSetMultimap(SetMultimap<K, V> param1SetMultimap) {
      super(param1SetMultimap);
    }
    
    public SetMultimap<K, V> delegate() {
      return (SetMultimap<K, V>)super.delegate();
    }
    
    public Set<Map.Entry<K, V>> entries() {
      return Maps.unmodifiableEntrySet(delegate().entries());
    }
    
    public Set<V> get(K param1K) {
      return Collections.unmodifiableSet(delegate().get(param1K));
    }
    
    public Set<V> removeAll(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public Set<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      throw new UnsupportedOperationException();
    }
  }
  
  private static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> param1SortedSetMultimap) {
      super(param1SortedSetMultimap);
    }
    
    public SortedSetMultimap<K, V> delegate() {
      return (SortedSetMultimap<K, V>)super.delegate();
    }
    
    public SortedSet<V> get(K param1K) {
      return Collections.unmodifiableSortedSet(delegate().get(param1K));
    }
    
    public SortedSet<V> removeAll(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public SortedSet<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      throw new UnsupportedOperationException();
    }
    
    public Comparator<? super V> valueComparator() {
      return delegate().valueComparator();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Multimaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */