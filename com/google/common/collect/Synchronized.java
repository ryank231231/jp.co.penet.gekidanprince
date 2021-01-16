package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class Synchronized {
  static <K, V> BiMap<K, V> biMap(BiMap<K, V> paramBiMap, @Nullable Object paramObject) {
    return (paramBiMap instanceof SynchronizedBiMap || paramBiMap instanceof ImmutableBiMap) ? paramBiMap : new SynchronizedBiMap<K, V>(paramBiMap, paramObject, null);
  }
  
  private static <E> Collection<E> collection(Collection<E> paramCollection, @Nullable Object paramObject) {
    return new SynchronizedCollection<E>(paramCollection, paramObject);
  }
  
  static <E> Deque<E> deque(Deque<E> paramDeque, @Nullable Object paramObject) {
    return new SynchronizedDeque<E>(paramDeque, paramObject);
  }
  
  private static <E> List<E> list(List<E> paramList, @Nullable Object paramObject) {
    if (paramList instanceof RandomAccess) {
      paramList = new SynchronizedRandomAccessList<E>(paramList, paramObject);
    } else {
      paramList = new SynchronizedList<E>(paramList, paramObject);
    } 
    return paramList;
  }
  
  static <K, V> ListMultimap<K, V> listMultimap(ListMultimap<K, V> paramListMultimap, @Nullable Object paramObject) {
    return (paramListMultimap instanceof SynchronizedListMultimap || paramListMultimap instanceof ImmutableListMultimap) ? paramListMultimap : new SynchronizedListMultimap<K, V>(paramListMultimap, paramObject);
  }
  
  @VisibleForTesting
  static <K, V> Map<K, V> map(Map<K, V> paramMap, @Nullable Object paramObject) {
    return new SynchronizedMap<K, V>(paramMap, paramObject);
  }
  
  static <K, V> Multimap<K, V> multimap(Multimap<K, V> paramMultimap, @Nullable Object paramObject) {
    return (paramMultimap instanceof SynchronizedMultimap || paramMultimap instanceof ImmutableMultimap) ? paramMultimap : new SynchronizedMultimap<K, V>(paramMultimap, paramObject);
  }
  
  static <E> Multiset<E> multiset(Multiset<E> paramMultiset, @Nullable Object paramObject) {
    return (paramMultiset instanceof SynchronizedMultiset || paramMultiset instanceof ImmutableMultiset) ? paramMultiset : new SynchronizedMultiset<E>(paramMultiset, paramObject);
  }
  
  @GwtIncompatible
  static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> paramNavigableMap) {
    return navigableMap(paramNavigableMap, null);
  }
  
  @GwtIncompatible
  static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> paramNavigableMap, @Nullable Object paramObject) {
    return new SynchronizedNavigableMap<K, V>(paramNavigableMap, paramObject);
  }
  
  @GwtIncompatible
  static <E> NavigableSet<E> navigableSet(NavigableSet<E> paramNavigableSet) {
    return navigableSet(paramNavigableSet, null);
  }
  
  @GwtIncompatible
  static <E> NavigableSet<E> navigableSet(NavigableSet<E> paramNavigableSet, @Nullable Object paramObject) {
    return new SynchronizedNavigableSet<E>(paramNavigableSet, paramObject);
  }
  
  @GwtIncompatible
  private static <K, V> Map.Entry<K, V> nullableSynchronizedEntry(@Nullable Map.Entry<K, V> paramEntry, @Nullable Object paramObject) {
    return (paramEntry == null) ? null : new SynchronizedEntry<K, V>(paramEntry, paramObject);
  }
  
  static <E> Queue<E> queue(Queue<E> paramQueue, @Nullable Object paramObject) {
    if (!(paramQueue instanceof SynchronizedQueue))
      paramQueue = new SynchronizedQueue<E>(paramQueue, paramObject); 
    return paramQueue;
  }
  
  @VisibleForTesting
  static <E> Set<E> set(Set<E> paramSet, @Nullable Object paramObject) {
    return new SynchronizedSet<E>(paramSet, paramObject);
  }
  
  static <K, V> SetMultimap<K, V> setMultimap(SetMultimap<K, V> paramSetMultimap, @Nullable Object paramObject) {
    return (paramSetMultimap instanceof SynchronizedSetMultimap || paramSetMultimap instanceof ImmutableSetMultimap) ? paramSetMultimap : new SynchronizedSetMultimap<K, V>(paramSetMultimap, paramObject);
  }
  
  static <K, V> SortedMap<K, V> sortedMap(SortedMap<K, V> paramSortedMap, @Nullable Object paramObject) {
    return new SynchronizedSortedMap<K, V>(paramSortedMap, paramObject);
  }
  
  private static <E> SortedSet<E> sortedSet(SortedSet<E> paramSortedSet, @Nullable Object paramObject) {
    return new SynchronizedSortedSet<E>(paramSortedSet, paramObject);
  }
  
  static <K, V> SortedSetMultimap<K, V> sortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, @Nullable Object paramObject) {
    return (paramSortedSetMultimap instanceof SynchronizedSortedSetMultimap) ? paramSortedSetMultimap : new SynchronizedSortedSetMultimap<K, V>(paramSortedSetMultimap, paramObject);
  }
  
  private static <E> Collection<E> typePreservingCollection(Collection<E> paramCollection, @Nullable Object paramObject) {
    return (paramCollection instanceof SortedSet) ? sortedSet((SortedSet<E>)paramCollection, paramObject) : ((paramCollection instanceof Set) ? set((Set<E>)paramCollection, paramObject) : ((paramCollection instanceof List) ? list((List<E>)paramCollection, paramObject) : collection(paramCollection, paramObject)));
  }
  
  private static <E> Set<E> typePreservingSet(Set<E> paramSet, @Nullable Object paramObject) {
    return (paramSet instanceof SortedSet) ? sortedSet((SortedSet<E>)paramSet, paramObject) : set(paramSet, paramObject);
  }
  
  private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
    private static final long serialVersionUID = 0L;
    
    transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
    
    transient Collection<Collection<V>> asMapValues;
    
    SynchronizedAsMap(Map<K, Collection<V>> param1Map, @Nullable Object param1Object) {
      super(param1Map, param1Object);
    }
    
    public boolean containsValue(Object param1Object) {
      return values().contains(param1Object);
    }
    
    public Set<Map.Entry<K, Collection<V>>> entrySet() {
      synchronized (this.mutex) {
        if (this.asMapEntrySet == null) {
          Synchronized.SynchronizedAsMapEntries<Object, Object> synchronizedAsMapEntries = new Synchronized.SynchronizedAsMapEntries<Object, Object>();
          this(delegate().entrySet(), this.mutex);
          this.asMapEntrySet = (Set)synchronizedAsMapEntries;
        } 
        return this.asMapEntrySet;
      } 
    }
    
    public Collection<V> get(Object param1Object) {
      synchronized (this.mutex) {
        param1Object = super.get(param1Object);
        if (param1Object == null) {
          param1Object = null;
        } else {
          param1Object = Synchronized.typePreservingCollection((Collection<E>)param1Object, this.mutex);
        } 
        return (Collection<V>)param1Object;
      } 
    }
    
    public Collection<Collection<V>> values() {
      synchronized (this.mutex) {
        if (this.asMapValues == null) {
          Synchronized.SynchronizedAsMapValues<Collection<V>> synchronizedAsMapValues = new Synchronized.SynchronizedAsMapValues();
          this(delegate().values(), this.mutex);
          this.asMapValues = (Collection<Collection<V>>)synchronizedAsMapValues;
        } 
        return this.asMapValues;
      } 
    }
  }
  
  private static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> param1Set, @Nullable Object param1Object) {
      super(param1Set, param1Object);
    }
    
    public boolean contains(Object param1Object) {
      synchronized (this.mutex) {
        return Maps.containsEntryImpl(delegate(), param1Object);
      } 
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      synchronized (this.mutex) {
        return Collections2.containsAllImpl(delegate(), param1Collection);
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.mutex) {
        return Sets.equalsImpl(delegate(), param1Object);
      } 
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(super.iterator()) {
          Map.Entry<K, Collection<V>> transform(final Map.Entry<K, Collection<V>> entry) {
            return (Map.Entry)new ForwardingMapEntry<K, Collection<Collection<V>>>() {
                protected Map.Entry<K, Collection<V>> delegate() {
                  return entry;
                }
                
                public Collection<V> getValue() {
                  return Synchronized.typePreservingCollection((Collection)entry.getValue(), Synchronized.SynchronizedAsMapEntries.this.mutex);
                }
              };
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      synchronized (this.mutex) {
        return Maps.removeEntryImpl(delegate(), param1Object);
      } 
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      synchronized (this.mutex) {
        return Iterators.removeAll(delegate().iterator(), param1Collection);
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      synchronized (this.mutex) {
        return Iterators.retainAll(delegate().iterator(), param1Collection);
      } 
    }
    
    public Object[] toArray() {
      synchronized (this.mutex) {
        return ObjectArrays.toArrayImpl(delegate());
      } 
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      synchronized (this.mutex) {
        param1ArrayOfT = ObjectArrays.toArrayImpl(delegate(), param1ArrayOfT);
        return param1ArrayOfT;
      } 
    }
  }
  
  class null extends TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {
    null(Iterator<? extends Map.Entry<K, Collection<V>>> param1Iterator) {
      super(param1Iterator);
    }
    
    Map.Entry<K, Collection<V>> transform(final Map.Entry<K, Collection<V>> entry) {
      return (Map.Entry)new ForwardingMapEntry<K, Collection<Collection<V>>>() {
          protected Map.Entry<K, Collection<V>> delegate() {
            return entry;
          }
          
          public Collection<V> getValue() {
            return Synchronized.typePreservingCollection((Collection)entry.getValue(), this.this$1.this$0.mutex);
          }
        };
    }
  }
  
  class null extends ForwardingMapEntry<K, Collection<V>> {
    protected Map.Entry<K, Collection<V>> delegate() {
      return entry;
    }
    
    public Collection<V> getValue() {
      return Synchronized.typePreservingCollection((Collection)entry.getValue(), this.this$1.this$0.mutex);
    }
  }
  
  private static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedAsMapValues(Collection<Collection<V>> param1Collection, @Nullable Object param1Object) {
      super(param1Collection, param1Object);
    }
    
    public Iterator<Collection<V>> iterator() {
      return new TransformedIterator<Collection<V>, Collection<V>>(super.iterator()) {
          Collection<V> transform(Collection<V> param2Collection) {
            return Synchronized.typePreservingCollection(param2Collection, Synchronized.SynchronizedAsMapValues.this.mutex);
          }
        };
    }
  }
  
  class null extends TransformedIterator<Collection<V>, Collection<V>> {
    null(Iterator<? extends Collection<V>> param1Iterator) {
      super(param1Iterator);
    }
    
    Collection<V> transform(Collection<V> param1Collection) {
      return Synchronized.typePreservingCollection(param1Collection, this.this$0.mutex);
    }
  }
  
  @VisibleForTesting
  static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
    private static final long serialVersionUID = 0L;
    
    @RetainedWith
    private transient BiMap<V, K> inverse;
    
    private transient Set<V> valueSet;
    
    private SynchronizedBiMap(BiMap<K, V> param1BiMap, @Nullable Object param1Object, @Nullable BiMap<V, K> param1BiMap1) {
      super(param1BiMap, param1Object);
      this.inverse = param1BiMap1;
    }
    
    BiMap<K, V> delegate() {
      return (BiMap<K, V>)super.delegate();
    }
    
    public V forcePut(K param1K, V param1V) {
      synchronized (this.mutex) {
        param1K = (K)delegate().forcePut(param1K, param1V);
        return (V)param1K;
      } 
    }
    
    public BiMap<V, K> inverse() {
      synchronized (this.mutex) {
        if (this.inverse == null) {
          SynchronizedBiMap<V, K> synchronizedBiMap = new SynchronizedBiMap();
          this(delegate().inverse(), this.mutex, this);
          this.inverse = synchronizedBiMap;
        } 
        return this.inverse;
      } 
    }
    
    public Set<V> values() {
      synchronized (this.mutex) {
        if (this.valueSet == null)
          this.valueSet = Synchronized.set(delegate().values(), this.mutex); 
        return this.valueSet;
      } 
    }
  }
  
  @VisibleForTesting
  static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
    private static final long serialVersionUID = 0L;
    
    private SynchronizedCollection(Collection<E> param1Collection, @Nullable Object param1Object) {
      super(param1Collection, param1Object);
    }
    
    public boolean add(E param1E) {
      synchronized (this.mutex) {
        return delegate().add(param1E);
      } 
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      synchronized (this.mutex) {
        return delegate().addAll(param1Collection);
      } 
    }
    
    public void clear() {
      synchronized (this.mutex) {
        delegate().clear();
        return;
      } 
    }
    
    public boolean contains(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().contains(param1Object);
      } 
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      synchronized (this.mutex) {
        return delegate().containsAll(param1Collection);
      } 
    }
    
    Collection<E> delegate() {
      return (Collection<E>)super.delegate();
    }
    
    public boolean isEmpty() {
      synchronized (this.mutex) {
        return delegate().isEmpty();
      } 
    }
    
    public Iterator<E> iterator() {
      return delegate().iterator();
    }
    
    public boolean remove(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().remove(param1Object);
      } 
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      synchronized (this.mutex) {
        return delegate().removeAll(param1Collection);
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      synchronized (this.mutex) {
        return delegate().retainAll(param1Collection);
      } 
    }
    
    public int size() {
      synchronized (this.mutex) {
        return delegate().size();
      } 
    }
    
    public Object[] toArray() {
      synchronized (this.mutex) {
        return delegate().toArray();
      } 
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      synchronized (this.mutex) {
        param1ArrayOfT = delegate().toArray(param1ArrayOfT);
        return param1ArrayOfT;
      } 
    }
  }
  
  private static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedDeque(Deque<E> param1Deque, @Nullable Object param1Object) {
      super(param1Deque, param1Object);
    }
    
    public void addFirst(E param1E) {
      synchronized (this.mutex) {
        delegate().addFirst(param1E);
        return;
      } 
    }
    
    public void addLast(E param1E) {
      synchronized (this.mutex) {
        delegate().addLast(param1E);
        return;
      } 
    }
    
    Deque<E> delegate() {
      return (Deque<E>)super.delegate();
    }
    
    public Iterator<E> descendingIterator() {
      synchronized (this.mutex) {
        return delegate().descendingIterator();
      } 
    }
    
    public E getFirst() {
      synchronized (this.mutex) {
        return delegate().getFirst();
      } 
    }
    
    public E getLast() {
      synchronized (this.mutex) {
        return delegate().getLast();
      } 
    }
    
    public boolean offerFirst(E param1E) {
      synchronized (this.mutex) {
        return delegate().offerFirst(param1E);
      } 
    }
    
    public boolean offerLast(E param1E) {
      synchronized (this.mutex) {
        return delegate().offerLast(param1E);
      } 
    }
    
    public E peekFirst() {
      synchronized (this.mutex) {
        return delegate().peekFirst();
      } 
    }
    
    public E peekLast() {
      synchronized (this.mutex) {
        return delegate().peekLast();
      } 
    }
    
    public E pollFirst() {
      synchronized (this.mutex) {
        return delegate().pollFirst();
      } 
    }
    
    public E pollLast() {
      synchronized (this.mutex) {
        return delegate().pollLast();
      } 
    }
    
    public E pop() {
      synchronized (this.mutex) {
        return delegate().pop();
      } 
    }
    
    public void push(E param1E) {
      synchronized (this.mutex) {
        delegate().push(param1E);
        return;
      } 
    }
    
    public E removeFirst() {
      synchronized (this.mutex) {
        return delegate().removeFirst();
      } 
    }
    
    public boolean removeFirstOccurrence(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().removeFirstOccurrence(param1Object);
      } 
    }
    
    public E removeLast() {
      synchronized (this.mutex) {
        return delegate().removeLast();
      } 
    }
    
    public boolean removeLastOccurrence(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().removeLastOccurrence(param1Object);
      } 
    }
  }
  
  @GwtIncompatible
  private static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedEntry(Map.Entry<K, V> param1Entry, @Nullable Object param1Object) {
      super(param1Entry, param1Object);
    }
    
    Map.Entry<K, V> delegate() {
      return (Map.Entry<K, V>)super.delegate();
    }
    
    public boolean equals(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().equals(param1Object);
      } 
    }
    
    public K getKey() {
      synchronized (this.mutex) {
        return delegate().getKey();
      } 
    }
    
    public V getValue() {
      synchronized (this.mutex) {
        return delegate().getValue();
      } 
    }
    
    public int hashCode() {
      synchronized (this.mutex) {
        return delegate().hashCode();
      } 
    }
    
    public V setValue(V param1V) {
      synchronized (this.mutex) {
        param1V = delegate().setValue(param1V);
        return param1V;
      } 
    }
  }
  
  private static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedList(List<E> param1List, @Nullable Object param1Object) {
      super(param1List, param1Object);
    }
    
    public void add(int param1Int, E param1E) {
      synchronized (this.mutex) {
        delegate().add(param1Int, param1E);
        return;
      } 
    }
    
    public boolean addAll(int param1Int, Collection<? extends E> param1Collection) {
      synchronized (this.mutex) {
        return delegate().addAll(param1Int, param1Collection);
      } 
    }
    
    List<E> delegate() {
      return (List<E>)super.delegate();
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.mutex) {
        return delegate().equals(param1Object);
      } 
    }
    
    public E get(int param1Int) {
      synchronized (this.mutex) {
        return delegate().get(param1Int);
      } 
    }
    
    public int hashCode() {
      synchronized (this.mutex) {
        return delegate().hashCode();
      } 
    }
    
    public int indexOf(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().indexOf(param1Object);
      } 
    }
    
    public int lastIndexOf(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().lastIndexOf(param1Object);
      } 
    }
    
    public ListIterator<E> listIterator() {
      return delegate().listIterator();
    }
    
    public ListIterator<E> listIterator(int param1Int) {
      return delegate().listIterator(param1Int);
    }
    
    public E remove(int param1Int) {
      synchronized (this.mutex) {
        return delegate().remove(param1Int);
      } 
    }
    
    public E set(int param1Int, E param1E) {
      synchronized (this.mutex) {
        param1E = delegate().set(param1Int, param1E);
        return param1E;
      } 
    }
    
    public List<E> subList(int param1Int1, int param1Int2) {
      synchronized (this.mutex) {
        return Synchronized.list(delegate().subList(param1Int1, param1Int2), this.mutex);
      } 
    }
  }
  
  private static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedListMultimap(ListMultimap<K, V> param1ListMultimap, @Nullable Object param1Object) {
      super(param1ListMultimap, param1Object);
    }
    
    ListMultimap<K, V> delegate() {
      return (ListMultimap<K, V>)super.delegate();
    }
    
    public List<V> get(K param1K) {
      synchronized (this.mutex) {
        return Synchronized.list(delegate().get(param1K), this.mutex);
      } 
    }
    
    public List<V> removeAll(Object<V> param1Object) {
      synchronized (this.mutex) {
        param1Object = (Object<V>)delegate().removeAll(param1Object);
        return (List<V>)param1Object;
      } 
    }
    
    public List<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      synchronized (this.mutex) {
        return delegate().replaceValues(param1K, param1Iterable);
      } 
    }
  }
  
  private static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
    private static final long serialVersionUID = 0L;
    
    transient Set<Map.Entry<K, V>> entrySet;
    
    transient Set<K> keySet;
    
    transient Collection<V> values;
    
    SynchronizedMap(Map<K, V> param1Map, @Nullable Object param1Object) {
      super(param1Map, param1Object);
    }
    
    public void clear() {
      synchronized (this.mutex) {
        delegate().clear();
        return;
      } 
    }
    
    public boolean containsKey(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().containsKey(param1Object);
      } 
    }
    
    public boolean containsValue(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().containsValue(param1Object);
      } 
    }
    
    Map<K, V> delegate() {
      return (Map<K, V>)super.delegate();
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      synchronized (this.mutex) {
        if (this.entrySet == null)
          this.entrySet = Synchronized.set(delegate().entrySet(), this.mutex); 
        return this.entrySet;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.mutex) {
        return delegate().equals(param1Object);
      } 
    }
    
    public V get(Object param1Object) {
      synchronized (this.mutex) {
        param1Object = delegate().get(param1Object);
        return (V)param1Object;
      } 
    }
    
    public int hashCode() {
      synchronized (this.mutex) {
        return delegate().hashCode();
      } 
    }
    
    public boolean isEmpty() {
      synchronized (this.mutex) {
        return delegate().isEmpty();
      } 
    }
    
    public Set<K> keySet() {
      synchronized (this.mutex) {
        if (this.keySet == null)
          this.keySet = Synchronized.set(delegate().keySet(), this.mutex); 
        return this.keySet;
      } 
    }
    
    public V put(K param1K, V param1V) {
      synchronized (this.mutex) {
        param1K = (K)delegate().put(param1K, param1V);
        return (V)param1K;
      } 
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      synchronized (this.mutex) {
        delegate().putAll(param1Map);
        return;
      } 
    }
    
    public V remove(Object param1Object) {
      synchronized (this.mutex) {
        param1Object = delegate().remove(param1Object);
        return (V)param1Object;
      } 
    }
    
    public int size() {
      synchronized (this.mutex) {
        return delegate().size();
      } 
    }
    
    public Collection<V> values() {
      synchronized (this.mutex) {
        if (this.values == null)
          this.values = Synchronized.collection(delegate().values(), this.mutex); 
        return this.values;
      } 
    }
  }
  
  private static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
    private static final long serialVersionUID = 0L;
    
    transient Map<K, Collection<V>> asMap;
    
    transient Collection<Map.Entry<K, V>> entries;
    
    transient Set<K> keySet;
    
    transient Multiset<K> keys;
    
    transient Collection<V> valuesCollection;
    
    SynchronizedMultimap(Multimap<K, V> param1Multimap, @Nullable Object param1Object) {
      super(param1Multimap, param1Object);
    }
    
    public Map<K, Collection<V>> asMap() {
      synchronized (this.mutex) {
        if (this.asMap == null) {
          Synchronized.SynchronizedAsMap<Object, Object> synchronizedAsMap = new Synchronized.SynchronizedAsMap<Object, Object>();
          this(delegate().asMap(), this.mutex);
          this.asMap = (Map)synchronizedAsMap;
        } 
        return this.asMap;
      } 
    }
    
    public void clear() {
      synchronized (this.mutex) {
        delegate().clear();
        return;
      } 
    }
    
    public boolean containsEntry(Object param1Object1, Object param1Object2) {
      synchronized (this.mutex) {
        return delegate().containsEntry(param1Object1, param1Object2);
      } 
    }
    
    public boolean containsKey(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().containsKey(param1Object);
      } 
    }
    
    public boolean containsValue(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().containsValue(param1Object);
      } 
    }
    
    Multimap<K, V> delegate() {
      return (Multimap<K, V>)super.delegate();
    }
    
    public Collection<Map.Entry<K, V>> entries() {
      synchronized (this.mutex) {
        if (this.entries == null)
          this.entries = (Collection)Synchronized.typePreservingCollection((Collection)delegate().entries(), this.mutex); 
        return this.entries;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.mutex) {
        return delegate().equals(param1Object);
      } 
    }
    
    public Collection<V> get(K param1K) {
      synchronized (this.mutex) {
        return Synchronized.typePreservingCollection(delegate().get(param1K), this.mutex);
      } 
    }
    
    public int hashCode() {
      synchronized (this.mutex) {
        return delegate().hashCode();
      } 
    }
    
    public boolean isEmpty() {
      synchronized (this.mutex) {
        return delegate().isEmpty();
      } 
    }
    
    public Set<K> keySet() {
      synchronized (this.mutex) {
        if (this.keySet == null)
          this.keySet = Synchronized.typePreservingSet(delegate().keySet(), this.mutex); 
        return this.keySet;
      } 
    }
    
    public Multiset<K> keys() {
      synchronized (this.mutex) {
        if (this.keys == null)
          this.keys = Synchronized.multiset(delegate().keys(), this.mutex); 
        return this.keys;
      } 
    }
    
    public boolean put(K param1K, V param1V) {
      synchronized (this.mutex) {
        return delegate().put(param1K, param1V);
      } 
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> param1Multimap) {
      synchronized (this.mutex) {
        return delegate().putAll(param1Multimap);
      } 
    }
    
    public boolean putAll(K param1K, Iterable<? extends V> param1Iterable) {
      synchronized (this.mutex) {
        return delegate().putAll(param1K, param1Iterable);
      } 
    }
    
    public boolean remove(Object param1Object1, Object param1Object2) {
      synchronized (this.mutex) {
        return delegate().remove(param1Object1, param1Object2);
      } 
    }
    
    public Collection<V> removeAll(Object<V> param1Object) {
      synchronized (this.mutex) {
        param1Object = (Object<V>)delegate().removeAll(param1Object);
        return (Collection<V>)param1Object;
      } 
    }
    
    public Collection<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      synchronized (this.mutex) {
        return delegate().replaceValues(param1K, param1Iterable);
      } 
    }
    
    public int size() {
      synchronized (this.mutex) {
        return delegate().size();
      } 
    }
    
    public Collection<V> values() {
      synchronized (this.mutex) {
        if (this.valuesCollection == null)
          this.valuesCollection = Synchronized.collection(delegate().values(), this.mutex); 
        return this.valuesCollection;
      } 
    }
  }
  
  private static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
    private static final long serialVersionUID = 0L;
    
    transient Set<E> elementSet;
    
    transient Set<Multiset.Entry<E>> entrySet;
    
    SynchronizedMultiset(Multiset<E> param1Multiset, @Nullable Object param1Object) {
      super(param1Multiset, param1Object);
    }
    
    public int add(E param1E, int param1Int) {
      synchronized (this.mutex) {
        param1Int = delegate().add(param1E, param1Int);
        return param1Int;
      } 
    }
    
    public int count(Object param1Object) {
      synchronized (this.mutex) {
        return delegate().count(param1Object);
      } 
    }
    
    Multiset<E> delegate() {
      return (Multiset<E>)super.delegate();
    }
    
    public Set<E> elementSet() {
      synchronized (this.mutex) {
        if (this.elementSet == null)
          this.elementSet = Synchronized.typePreservingSet(delegate().elementSet(), this.mutex); 
        return this.elementSet;
      } 
    }
    
    public Set<Multiset.Entry<E>> entrySet() {
      synchronized (this.mutex) {
        if (this.entrySet == null)
          this.entrySet = (Set)Synchronized.typePreservingSet((Set)delegate().entrySet(), this.mutex); 
        return this.entrySet;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.mutex) {
        return delegate().equals(param1Object);
      } 
    }
    
    public int hashCode() {
      synchronized (this.mutex) {
        return delegate().hashCode();
      } 
    }
    
    public int remove(Object param1Object, int param1Int) {
      synchronized (this.mutex) {
        param1Int = delegate().remove(param1Object, param1Int);
        return param1Int;
      } 
    }
    
    public int setCount(E param1E, int param1Int) {
      synchronized (this.mutex) {
        param1Int = delegate().setCount(param1E, param1Int);
        return param1Int;
      } 
    }
    
    public boolean setCount(E param1E, int param1Int1, int param1Int2) {
      synchronized (this.mutex) {
        return delegate().setCount(param1E, param1Int1, param1Int2);
      } 
    }
  }
  
  @GwtIncompatible
  @VisibleForTesting
  static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
    private static final long serialVersionUID = 0L;
    
    transient NavigableSet<K> descendingKeySet;
    
    transient NavigableMap<K, V> descendingMap;
    
    transient NavigableSet<K> navigableKeySet;
    
    SynchronizedNavigableMap(NavigableMap<K, V> param1NavigableMap, @Nullable Object param1Object) {
      super(param1NavigableMap, param1Object);
    }
    
    public Map.Entry<K, V> ceilingEntry(K param1K) {
      synchronized (this.mutex) {
        return Synchronized.nullableSynchronizedEntry(delegate().ceilingEntry(param1K), this.mutex);
      } 
    }
    
    public K ceilingKey(K param1K) {
      synchronized (this.mutex) {
        param1K = delegate().ceilingKey(param1K);
        return param1K;
      } 
    }
    
    NavigableMap<K, V> delegate() {
      return (NavigableMap<K, V>)super.delegate();
    }
    
    public NavigableSet<K> descendingKeySet() {
      synchronized (this.mutex) {
        if (this.descendingKeySet == null) {
          NavigableSet<?> navigableSet = Synchronized.navigableSet(delegate().descendingKeySet(), this.mutex);
          this.descendingKeySet = (NavigableSet)navigableSet;
          return (NavigableSet)navigableSet;
        } 
        return this.descendingKeySet;
      } 
    }
    
    public NavigableMap<K, V> descendingMap() {
      synchronized (this.mutex) {
        if (this.descendingMap == null) {
          NavigableMap<?, ?> navigableMap = Synchronized.navigableMap(delegate().descendingMap(), this.mutex);
          this.descendingMap = (NavigableMap)navigableMap;
          return (NavigableMap)navigableMap;
        } 
        return this.descendingMap;
      } 
    }
    
    public Map.Entry<K, V> firstEntry() {
      synchronized (this.mutex) {
        return Synchronized.nullableSynchronizedEntry(delegate().firstEntry(), this.mutex);
      } 
    }
    
    public Map.Entry<K, V> floorEntry(K param1K) {
      synchronized (this.mutex) {
        return Synchronized.nullableSynchronizedEntry(delegate().floorEntry(param1K), this.mutex);
      } 
    }
    
    public K floorKey(K param1K) {
      synchronized (this.mutex) {
        param1K = delegate().floorKey(param1K);
        return param1K;
      } 
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      synchronized (this.mutex) {
        return (NavigableMap)Synchronized.navigableMap(delegate().headMap(param1K, param1Boolean), this.mutex);
      } 
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return headMap(param1K, false);
    }
    
    public Map.Entry<K, V> higherEntry(K param1K) {
      synchronized (this.mutex) {
        return Synchronized.nullableSynchronizedEntry(delegate().higherEntry(param1K), this.mutex);
      } 
    }
    
    public K higherKey(K param1K) {
      synchronized (this.mutex) {
        param1K = delegate().higherKey(param1K);
        return param1K;
      } 
    }
    
    public Set<K> keySet() {
      return navigableKeySet();
    }
    
    public Map.Entry<K, V> lastEntry() {
      synchronized (this.mutex) {
        return Synchronized.nullableSynchronizedEntry(delegate().lastEntry(), this.mutex);
      } 
    }
    
    public Map.Entry<K, V> lowerEntry(K param1K) {
      synchronized (this.mutex) {
        return Synchronized.nullableSynchronizedEntry(delegate().lowerEntry(param1K), this.mutex);
      } 
    }
    
    public K lowerKey(K param1K) {
      synchronized (this.mutex) {
        param1K = delegate().lowerKey(param1K);
        return param1K;
      } 
    }
    
    public NavigableSet<K> navigableKeySet() {
      synchronized (this.mutex) {
        if (this.navigableKeySet == null) {
          NavigableSet<?> navigableSet = Synchronized.navigableSet(delegate().navigableKeySet(), this.mutex);
          this.navigableKeySet = (NavigableSet)navigableSet;
          return (NavigableSet)navigableSet;
        } 
        return this.navigableKeySet;
      } 
    }
    
    public Map.Entry<K, V> pollFirstEntry() {
      synchronized (this.mutex) {
        return Synchronized.nullableSynchronizedEntry(delegate().pollFirstEntry(), this.mutex);
      } 
    }
    
    public Map.Entry<K, V> pollLastEntry() {
      synchronized (this.mutex) {
        return Synchronized.nullableSynchronizedEntry(delegate().pollLastEntry(), this.mutex);
      } 
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      synchronized (this.mutex) {
        return (NavigableMap)Synchronized.navigableMap(delegate().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2), this.mutex);
      } 
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      synchronized (this.mutex) {
        return (NavigableMap)Synchronized.navigableMap(delegate().tailMap(param1K, param1Boolean), this.mutex);
      } 
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return tailMap(param1K, true);
    }
  }
  
  @GwtIncompatible
  @VisibleForTesting
  static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 0L;
    
    transient NavigableSet<E> descendingSet;
    
    SynchronizedNavigableSet(NavigableSet<E> param1NavigableSet, @Nullable Object param1Object) {
      super(param1NavigableSet, param1Object);
    }
    
    public E ceiling(E param1E) {
      synchronized (this.mutex) {
        param1E = delegate().ceiling(param1E);
        return param1E;
      } 
    }
    
    NavigableSet<E> delegate() {
      return (NavigableSet<E>)super.delegate();
    }
    
    public Iterator<E> descendingIterator() {
      return delegate().descendingIterator();
    }
    
    public NavigableSet<E> descendingSet() {
      synchronized (this.mutex) {
        if (this.descendingSet == null) {
          NavigableSet<?> navigableSet = Synchronized.navigableSet(delegate().descendingSet(), this.mutex);
          this.descendingSet = (NavigableSet)navigableSet;
          return (NavigableSet)navigableSet;
        } 
        return this.descendingSet;
      } 
    }
    
    public E floor(E param1E) {
      synchronized (this.mutex) {
        param1E = delegate().floor(param1E);
        return param1E;
      } 
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      synchronized (this.mutex) {
        return (NavigableSet)Synchronized.navigableSet(delegate().headSet(param1E, param1Boolean), this.mutex);
      } 
    }
    
    public SortedSet<E> headSet(E param1E) {
      return headSet(param1E, false);
    }
    
    public E higher(E param1E) {
      synchronized (this.mutex) {
        param1E = delegate().higher(param1E);
        return param1E;
      } 
    }
    
    public E lower(E param1E) {
      synchronized (this.mutex) {
        param1E = delegate().lower(param1E);
        return param1E;
      } 
    }
    
    public E pollFirst() {
      synchronized (this.mutex) {
        return delegate().pollFirst();
      } 
    }
    
    public E pollLast() {
      synchronized (this.mutex) {
        return delegate().pollLast();
      } 
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      synchronized (this.mutex) {
        return (NavigableSet)Synchronized.navigableSet(delegate().subSet(param1E1, param1Boolean1, param1E2, param1Boolean2), this.mutex);
      } 
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return subSet(param1E1, true, param1E2, false);
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      synchronized (this.mutex) {
        return (NavigableSet)Synchronized.navigableSet(delegate().tailSet(param1E, param1Boolean), this.mutex);
      } 
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return tailSet(param1E, true);
    }
  }
  
  static class SynchronizedObject implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0L;
    
    final Object delegate;
    
    final Object mutex;
    
    SynchronizedObject(Object param1Object1, @Nullable Object param1Object2) {
      this.delegate = Preconditions.checkNotNull(param1Object1);
      param1Object1 = param1Object2;
      if (param1Object2 == null)
        param1Object1 = this; 
      this.mutex = param1Object1;
    }
    
    @GwtIncompatible
    private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
      synchronized (this.mutex) {
        param1ObjectOutputStream.defaultWriteObject();
        return;
      } 
    }
    
    Object delegate() {
      return this.delegate;
    }
    
    public String toString() {
      synchronized (this.mutex) {
        return this.delegate.toString();
      } 
    }
  }
  
  private static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedQueue(Queue<E> param1Queue, @Nullable Object param1Object) {
      super(param1Queue, param1Object);
    }
    
    Queue<E> delegate() {
      return (Queue<E>)super.delegate();
    }
    
    public E element() {
      synchronized (this.mutex) {
        return delegate().element();
      } 
    }
    
    public boolean offer(E param1E) {
      synchronized (this.mutex) {
        return delegate().offer(param1E);
      } 
    }
    
    public E peek() {
      synchronized (this.mutex) {
        return delegate().peek();
      } 
    }
    
    public E poll() {
      synchronized (this.mutex) {
        return delegate().poll();
      } 
    }
    
    public E remove() {
      synchronized (this.mutex) {
        return delegate().remove();
      } 
    }
  }
  
  private static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
    private static final long serialVersionUID = 0L;
    
    SynchronizedRandomAccessList(List<E> param1List, @Nullable Object param1Object) {
      super(param1List, param1Object);
    }
  }
  
  static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedSet(Set<E> param1Set, @Nullable Object param1Object) {
      super(param1Set, param1Object);
    }
    
    Set<E> delegate() {
      return (Set<E>)super.delegate();
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.mutex) {
        return delegate().equals(param1Object);
      } 
    }
    
    public int hashCode() {
      synchronized (this.mutex) {
        return delegate().hashCode();
      } 
    }
  }
  
  private static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 0L;
    
    transient Set<Map.Entry<K, V>> entrySet;
    
    SynchronizedSetMultimap(SetMultimap<K, V> param1SetMultimap, @Nullable Object param1Object) {
      super(param1SetMultimap, param1Object);
    }
    
    SetMultimap<K, V> delegate() {
      return (SetMultimap<K, V>)super.delegate();
    }
    
    public Set<Map.Entry<K, V>> entries() {
      synchronized (this.mutex) {
        if (this.entrySet == null)
          this.entrySet = Synchronized.set(delegate().entries(), this.mutex); 
        return this.entrySet;
      } 
    }
    
    public Set<V> get(K param1K) {
      synchronized (this.mutex) {
        return (Set)Synchronized.set(delegate().get(param1K), this.mutex);
      } 
    }
    
    public Set<V> removeAll(Object<V> param1Object) {
      synchronized (this.mutex) {
        param1Object = (Object<V>)delegate().removeAll(param1Object);
        return (Set<V>)param1Object;
      } 
    }
    
    public Set<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      synchronized (this.mutex) {
        return delegate().replaceValues(param1K, param1Iterable);
      } 
    }
  }
  
  static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedSortedMap(SortedMap<K, V> param1SortedMap, @Nullable Object param1Object) {
      super(param1SortedMap, param1Object);
    }
    
    public Comparator<? super K> comparator() {
      synchronized (this.mutex) {
        return delegate().comparator();
      } 
    }
    
    SortedMap<K, V> delegate() {
      return (SortedMap<K, V>)super.delegate();
    }
    
    public K firstKey() {
      synchronized (this.mutex) {
        return delegate().firstKey();
      } 
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      synchronized (this.mutex) {
        return (SortedMap)Synchronized.sortedMap(delegate().headMap(param1K), this.mutex);
      } 
    }
    
    public K lastKey() {
      synchronized (this.mutex) {
        return delegate().lastKey();
      } 
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      synchronized (this.mutex) {
        return (SortedMap)Synchronized.sortedMap(delegate().subMap(param1K1, param1K2), this.mutex);
      } 
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      synchronized (this.mutex) {
        return (SortedMap)Synchronized.sortedMap(delegate().tailMap(param1K), this.mutex);
      } 
    }
  }
  
  static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedSortedSet(SortedSet<E> param1SortedSet, @Nullable Object param1Object) {
      super(param1SortedSet, param1Object);
    }
    
    public Comparator<? super E> comparator() {
      synchronized (this.mutex) {
        return delegate().comparator();
      } 
    }
    
    SortedSet<E> delegate() {
      return (SortedSet<E>)super.delegate();
    }
    
    public E first() {
      synchronized (this.mutex) {
        return delegate().first();
      } 
    }
    
    public SortedSet<E> headSet(E param1E) {
      synchronized (this.mutex) {
        return Synchronized.sortedSet(delegate().headSet(param1E), this.mutex);
      } 
    }
    
    public E last() {
      synchronized (this.mutex) {
        return delegate().last();
      } 
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      synchronized (this.mutex) {
        return Synchronized.sortedSet(delegate().subSet(param1E1, param1E2), this.mutex);
      } 
    }
    
    public SortedSet<E> tailSet(E param1E) {
      synchronized (this.mutex) {
        return Synchronized.sortedSet(delegate().tailSet(param1E), this.mutex);
      } 
    }
  }
  
  private static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    private static final long serialVersionUID = 0L;
    
    SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> param1SortedSetMultimap, @Nullable Object param1Object) {
      super(param1SortedSetMultimap, param1Object);
    }
    
    SortedSetMultimap<K, V> delegate() {
      return (SortedSetMultimap<K, V>)super.delegate();
    }
    
    public SortedSet<V> get(K param1K) {
      synchronized (this.mutex) {
        return Synchronized.sortedSet(delegate().get(param1K), this.mutex);
      } 
    }
    
    public SortedSet<V> removeAll(Object<V> param1Object) {
      synchronized (this.mutex) {
        param1Object = (Object<V>)delegate().removeAll(param1Object);
        return (SortedSet<V>)param1Object;
      } 
    }
    
    public SortedSet<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      synchronized (this.mutex) {
        return delegate().replaceValues(param1K, param1Iterable);
      } 
    }
    
    public Comparator<? super V> valueComparator() {
      synchronized (this.mutex) {
        return delegate().valueComparator();
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Synchronized.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */