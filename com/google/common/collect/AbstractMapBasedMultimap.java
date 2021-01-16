package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
  private static final long serialVersionUID = 2447537837011683357L;
  
  private transient Map<K, Collection<V>> map;
  
  private transient int totalSize;
  
  protected AbstractMapBasedMultimap(Map<K, Collection<V>> paramMap) {
    Preconditions.checkArgument(paramMap.isEmpty());
    this.map = paramMap;
  }
  
  private Collection<V> getOrCreateCollection(@Nullable K paramK) {
    Collection<V> collection1 = this.map.get(paramK);
    Collection<V> collection2 = collection1;
    if (collection1 == null) {
      collection2 = createCollection(paramK);
      this.map.put(paramK, collection2);
    } 
    return collection2;
  }
  
  private Iterator<V> iteratorOrListIterator(Collection<V> paramCollection) {
    Iterator<V> iterator;
    if (paramCollection instanceof List) {
      iterator = ((List)paramCollection).listIterator();
    } else {
      iterator = iterator.iterator();
    } 
    return iterator;
  }
  
  private void removeValuesForKey(Object paramObject) {
    paramObject = Maps.<Collection>safeRemove((Map)this.map, paramObject);
    if (paramObject != null) {
      int i = paramObject.size();
      paramObject.clear();
      this.totalSize -= i;
    } 
  }
  
  private List<V> wrapList(@Nullable K paramK, List<V> paramList, @Nullable WrappedCollection paramWrappedCollection) {
    WrappedList wrappedList;
    if (paramList instanceof RandomAccess) {
      wrappedList = new RandomAccessWrappedList(paramK, paramList, paramWrappedCollection);
    } else {
      wrappedList = new WrappedList((K)wrappedList, paramList, paramWrappedCollection);
    } 
    return wrappedList;
  }
  
  Map<K, Collection<V>> backingMap() {
    return this.map;
  }
  
  public void clear() {
    Iterator<Collection> iterator = this.map.values().iterator();
    while (iterator.hasNext())
      ((Collection)iterator.next()).clear(); 
    this.map.clear();
    this.totalSize = 0;
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    return this.map.containsKey(paramObject);
  }
  
  Map<K, Collection<V>> createAsMap() {
    Map<K, Collection<V>> map = this.map;
    if (map instanceof SortedMap) {
      map = new SortedAsMap((SortedMap<K, Collection<V>>)map);
    } else {
      map = new AsMap(map);
    } 
    return map;
  }
  
  abstract Collection<V> createCollection();
  
  Collection<V> createCollection(@Nullable K paramK) {
    return createCollection();
  }
  
  Set<K> createKeySet() {
    KeySet keySet;
    Map<K, Collection<V>> map = this.map;
    if (map instanceof SortedMap) {
      keySet = new SortedKeySet((SortedMap<K, Collection<V>>)map);
    } else {
      keySet = new KeySet((Map<K, Collection<V>>)keySet);
    } 
    return keySet;
  }
  
  Collection<V> createUnmodifiableEmptyCollection() {
    return unmodifiableCollectionSubclass(createCollection());
  }
  
  public Collection<Map.Entry<K, V>> entries() {
    return super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator() {
    return new Itr<Map.Entry<K, V>>() {
        Map.Entry<K, V> output(K param1K, V param1V) {
          return Maps.immutableEntry(param1K, param1V);
        }
      };
  }
  
  public Collection<V> get(@Nullable K paramK) {
    Collection<V> collection1 = this.map.get(paramK);
    Collection<V> collection2 = collection1;
    if (collection1 == null)
      collection2 = createCollection(paramK); 
    return wrapCollection(paramK, collection2);
  }
  
  public boolean put(@Nullable K paramK, @Nullable V paramV) {
    Collection<V> collection = this.map.get(paramK);
    if (collection == null) {
      collection = createCollection(paramK);
      if (collection.add(paramV)) {
        this.totalSize++;
        this.map.put(paramK, collection);
        return true;
      } 
      throw new AssertionError("New Collection violated the Collection spec");
    } 
    if (collection.add(paramV)) {
      this.totalSize++;
      return true;
    } 
    return false;
  }
  
  public Collection<V> removeAll(@Nullable Object<V> paramObject) {
    Collection<? extends V> collection = this.map.remove(paramObject);
    if (collection == null)
      return createUnmodifiableEmptyCollection(); 
    paramObject = (Object<V>)createCollection();
    paramObject.addAll(collection);
    this.totalSize -= collection.size();
    collection.clear();
    return unmodifiableCollectionSubclass((Collection<V>)paramObject);
  }
  
  public Collection<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable) {
    Iterator<? extends V> iterator = paramIterable.iterator();
    if (!iterator.hasNext())
      return removeAll(paramK); 
    Collection<V> collection2 = getOrCreateCollection(paramK);
    Collection<V> collection1 = createCollection();
    collection1.addAll(collection2);
    this.totalSize -= collection2.size();
    collection2.clear();
    while (iterator.hasNext()) {
      if (collection2.add(iterator.next()))
        this.totalSize++; 
    } 
    return unmodifiableCollectionSubclass(collection1);
  }
  
  final void setMap(Map<K, Collection<V>> paramMap) {
    this.map = paramMap;
    this.totalSize = 0;
    for (Collection<V> collection : paramMap.values()) {
      Preconditions.checkArgument(collection.isEmpty() ^ true);
      this.totalSize += collection.size();
    } 
  }
  
  public int size() {
    return this.totalSize;
  }
  
  Collection<V> unmodifiableCollectionSubclass(Collection<V> paramCollection) {
    return (paramCollection instanceof SortedSet) ? Collections.unmodifiableSortedSet((SortedSet<V>)paramCollection) : ((paramCollection instanceof Set) ? Collections.unmodifiableSet((Set<? extends V>)paramCollection) : ((paramCollection instanceof List) ? Collections.unmodifiableList((List<? extends V>)paramCollection) : Collections.unmodifiableCollection(paramCollection)));
  }
  
  Iterator<V> valueIterator() {
    return new Itr<V>() {
        V output(K param1K, V param1V) {
          return param1V;
        }
      };
  }
  
  public Collection<V> values() {
    return super.values();
  }
  
  Collection<V> wrapCollection(@Nullable K paramK, Collection<V> paramCollection) {
    return (Collection<V>)((paramCollection instanceof SortedSet) ? new WrappedSortedSet(paramK, (SortedSet<V>)paramCollection, null) : ((paramCollection instanceof Set) ? new WrappedSet(paramK, (Set<V>)paramCollection) : ((paramCollection instanceof List) ? wrapList(paramK, (List<V>)paramCollection, null) : new WrappedCollection(paramK, paramCollection, null))));
  }
  
  private class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
    final transient Map<K, Collection<V>> submap;
    
    AsMap(Map<K, Collection<V>> param1Map) {
      this.submap = param1Map;
    }
    
    public void clear() {
      if (this.submap == AbstractMapBasedMultimap.this.map) {
        AbstractMapBasedMultimap.this.clear();
      } else {
        Iterators.clear(new AsMapIterator());
      } 
    }
    
    public boolean containsKey(Object param1Object) {
      return Maps.safeContainsKey(this.submap, param1Object);
    }
    
    protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
      return new AsMapEntries();
    }
    
    public boolean equals(@Nullable Object param1Object) {
      return (this == param1Object || this.submap.equals(param1Object));
    }
    
    public Collection<V> get(Object param1Object) {
      Collection<V> collection = Maps.<Collection>safeGet((Map)this.submap, param1Object);
      return (collection == null) ? null : AbstractMapBasedMultimap.this.wrapCollection(param1Object, collection);
    }
    
    public int hashCode() {
      return this.submap.hashCode();
    }
    
    public Set<K> keySet() {
      return AbstractMapBasedMultimap.this.keySet();
    }
    
    public Collection<V> remove(Object param1Object) {
      param1Object = this.submap.remove(param1Object);
      if (param1Object == null)
        return null; 
      Collection<V> collection = AbstractMapBasedMultimap.this.createCollection();
      collection.addAll((Collection)param1Object);
      AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, param1Object.size());
      param1Object.clear();
      return collection;
    }
    
    public int size() {
      return this.submap.size();
    }
    
    public String toString() {
      return this.submap.toString();
    }
    
    Map.Entry<K, Collection<V>> wrapEntry(Map.Entry<K, Collection<V>> param1Entry) {
      K k = param1Entry.getKey();
      return Maps.immutableEntry(k, AbstractMapBasedMultimap.this.wrapCollection(k, param1Entry.getValue()));
    }
    
    class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
      public boolean contains(Object param2Object) {
        return Collections2.safeContains(AbstractMapBasedMultimap.AsMap.this.submap.entrySet(), param2Object);
      }
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator() {
        return new AbstractMapBasedMultimap.AsMap.AsMapIterator();
      }
      
      Map<K, Collection<V>> map() {
        return AbstractMapBasedMultimap.AsMap.this;
      }
      
      public boolean remove(Object param2Object) {
        if (!contains(param2Object))
          return false; 
        param2Object = param2Object;
        AbstractMapBasedMultimap.this.removeValuesForKey(param2Object.getKey());
        return true;
      }
    }
    
    class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {
      Collection<V> collection;
      
      final Iterator<Map.Entry<K, Collection<V>>> delegateIterator = AbstractMapBasedMultimap.AsMap.this.submap.entrySet().iterator();
      
      public boolean hasNext() {
        return this.delegateIterator.hasNext();
      }
      
      public Map.Entry<K, Collection<V>> next() {
        Map.Entry<K, Collection<V>> entry = this.delegateIterator.next();
        this.collection = (Collection<V>)entry.getValue();
        return AbstractMapBasedMultimap.AsMap.this.wrapEntry(entry);
      }
      
      public void remove() {
        this.delegateIterator.remove();
        AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.collection.size());
        this.collection.clear();
      }
    }
  }
  
  class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
    public boolean contains(Object param1Object) {
      return Collections2.safeContains(this.this$1.submap.entrySet(), param1Object);
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return new AbstractMapBasedMultimap.AsMap.AsMapIterator();
    }
    
    Map<K, Collection<V>> map() {
      return this.this$1;
    }
    
    public boolean remove(Object param1Object) {
      if (!contains(param1Object))
        return false; 
      param1Object = param1Object;
      AbstractMapBasedMultimap.this.removeValuesForKey(param1Object.getKey());
      return true;
    }
  }
  
  class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {
    Collection<V> collection;
    
    final Iterator<Map.Entry<K, Collection<V>>> delegateIterator = this.this$1.submap.entrySet().iterator();
    
    public boolean hasNext() {
      return this.delegateIterator.hasNext();
    }
    
    public Map.Entry<K, Collection<V>> next() {
      Map.Entry<K, Collection<V>> entry = this.delegateIterator.next();
      this.collection = (Collection<V>)entry.getValue();
      return this.this$1.wrapEntry(entry);
    }
    
    public void remove() {
      this.delegateIterator.remove();
      AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.collection.size());
      this.collection.clear();
    }
  }
  
  private abstract class Itr<T> implements Iterator<T> {
    Collection<V> collection = null;
    
    K key = null;
    
    final Iterator<Map.Entry<K, Collection<V>>> keyIterator = AbstractMapBasedMultimap.this.map.entrySet().iterator();
    
    Iterator<V> valueIterator = Iterators.emptyModifiableIterator();
    
    public boolean hasNext() {
      return (this.keyIterator.hasNext() || this.valueIterator.hasNext());
    }
    
    public T next() {
      if (!this.valueIterator.hasNext()) {
        Map.Entry entry = this.keyIterator.next();
        this.key = (K)entry.getKey();
        this.collection = (Collection<V>)entry.getValue();
        this.valueIterator = this.collection.iterator();
      } 
      return output(this.key, this.valueIterator.next());
    }
    
    abstract T output(K param1K, V param1V);
    
    public void remove() {
      this.valueIterator.remove();
      if (this.collection.isEmpty())
        this.keyIterator.remove(); 
      AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
    }
  }
  
  private class KeySet extends Maps.KeySet<K, Collection<V>> {
    KeySet(Map<K, Collection<V>> param1Map) {
      super(param1Map);
    }
    
    public void clear() {
      Iterators.clear(iterator());
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return map().keySet().containsAll(param1Collection);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      return (this == param1Object || map().keySet().equals(param1Object));
    }
    
    public int hashCode() {
      return map().keySet().hashCode();
    }
    
    public Iterator<K> iterator() {
      return new Iterator<K>() {
          Map.Entry<K, Collection<V>> entry;
          
          public boolean hasNext() {
            return entryIterator.hasNext();
          }
          
          public K next() {
            this.entry = entryIterator.next();
            return this.entry.getKey();
          }
          
          public void remove() {
            boolean bool;
            if (this.entry != null) {
              bool = true;
            } else {
              bool = false;
            } 
            CollectPreconditions.checkRemove(bool);
            Collection collection = this.entry.getValue();
            entryIterator.remove();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
            collection.clear();
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      boolean bool2;
      param1Object = map().remove(param1Object);
      boolean bool1 = false;
      if (param1Object != null) {
        bool2 = param1Object.size();
        param1Object.clear();
        AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, bool2);
      } else {
        bool2 = false;
      } 
      if (bool2)
        bool1 = true; 
      return bool1;
    }
  }
  
  class null implements Iterator<K> {
    Map.Entry<K, Collection<V>> entry;
    
    public boolean hasNext() {
      return entryIterator.hasNext();
    }
    
    public K next() {
      this.entry = entryIterator.next();
      return this.entry.getKey();
    }
    
    public void remove() {
      boolean bool;
      if (this.entry != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.checkRemove(bool);
      Collection collection = this.entry.getValue();
      entryIterator.remove();
      AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
      collection.clear();
    }
  }
  
  @GwtIncompatible
  class NavigableAsMap extends SortedAsMap implements NavigableMap<K, Collection<V>> {
    NavigableAsMap(NavigableMap<K, Collection<V>> param1NavigableMap) {
      super(param1NavigableMap);
    }
    
    public Map.Entry<K, Collection<V>> ceilingEntry(K param1K) {
      Map.Entry<K, Collection<V>> entry = sortedMap().ceilingEntry(param1K);
      if (entry == null) {
        entry = null;
      } else {
        entry = wrapEntry(entry);
      } 
      return entry;
    }
    
    public K ceilingKey(K param1K) {
      return sortedMap().ceilingKey(param1K);
    }
    
    NavigableSet<K> createKeySet() {
      return new AbstractMapBasedMultimap.NavigableKeySet(sortedMap());
    }
    
    public NavigableSet<K> descendingKeySet() {
      return descendingMap().navigableKeySet();
    }
    
    public NavigableMap<K, Collection<V>> descendingMap() {
      return new NavigableAsMap(sortedMap().descendingMap());
    }
    
    public Map.Entry<K, Collection<V>> firstEntry() {
      Map.Entry<K, Collection<V>> entry = sortedMap().firstEntry();
      if (entry == null) {
        entry = null;
      } else {
        entry = wrapEntry(entry);
      } 
      return entry;
    }
    
    public Map.Entry<K, Collection<V>> floorEntry(K param1K) {
      Map.Entry<K, Collection<V>> entry = sortedMap().floorEntry(param1K);
      if (entry == null) {
        entry = null;
      } else {
        entry = wrapEntry(entry);
      } 
      return entry;
    }
    
    public K floorKey(K param1K) {
      return sortedMap().floorKey(param1K);
    }
    
    public NavigableMap<K, Collection<V>> headMap(K param1K) {
      return headMap(param1K, false);
    }
    
    public NavigableMap<K, Collection<V>> headMap(K param1K, boolean param1Boolean) {
      return new NavigableAsMap(sortedMap().headMap(param1K, param1Boolean));
    }
    
    public Map.Entry<K, Collection<V>> higherEntry(K param1K) {
      Map.Entry<K, Collection<V>> entry = sortedMap().higherEntry(param1K);
      if (entry == null) {
        entry = null;
      } else {
        entry = wrapEntry(entry);
      } 
      return entry;
    }
    
    public K higherKey(K param1K) {
      return sortedMap().higherKey(param1K);
    }
    
    public NavigableSet<K> keySet() {
      return (NavigableSet<K>)super.keySet();
    }
    
    public Map.Entry<K, Collection<V>> lastEntry() {
      Map.Entry<K, Collection<V>> entry = sortedMap().lastEntry();
      if (entry == null) {
        entry = null;
      } else {
        entry = wrapEntry(entry);
      } 
      return entry;
    }
    
    public Map.Entry<K, Collection<V>> lowerEntry(K param1K) {
      Map.Entry<K, Collection<V>> entry = sortedMap().lowerEntry(param1K);
      if (entry == null) {
        entry = null;
      } else {
        entry = wrapEntry(entry);
      } 
      return entry;
    }
    
    public K lowerKey(K param1K) {
      return sortedMap().lowerKey(param1K);
    }
    
    public NavigableSet<K> navigableKeySet() {
      return keySet();
    }
    
    Map.Entry<K, Collection<V>> pollAsMapEntry(Iterator<Map.Entry<K, Collection<V>>> param1Iterator) {
      if (!param1Iterator.hasNext())
        return null; 
      Map.Entry entry = param1Iterator.next();
      Collection collection = AbstractMapBasedMultimap.this.createCollection();
      collection.addAll((Collection)entry.getValue());
      param1Iterator.remove();
      return Maps.immutableEntry((K)entry.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(collection));
    }
    
    public Map.Entry<K, Collection<V>> pollFirstEntry() {
      return pollAsMapEntry(entrySet().iterator());
    }
    
    public Map.Entry<K, Collection<V>> pollLastEntry() {
      return pollAsMapEntry(descendingMap().entrySet().iterator());
    }
    
    NavigableMap<K, Collection<V>> sortedMap() {
      return (NavigableMap<K, Collection<V>>)super.sortedMap();
    }
    
    public NavigableMap<K, Collection<V>> subMap(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, Collection<V>> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return new NavigableAsMap(sortedMap().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2));
    }
    
    public NavigableMap<K, Collection<V>> tailMap(K param1K) {
      return tailMap(param1K, true);
    }
    
    public NavigableMap<K, Collection<V>> tailMap(K param1K, boolean param1Boolean) {
      return new NavigableAsMap(sortedMap().tailMap(param1K, param1Boolean));
    }
  }
  
  @GwtIncompatible
  class NavigableKeySet extends SortedKeySet implements NavigableSet<K> {
    NavigableKeySet(NavigableMap<K, Collection<V>> param1NavigableMap) {
      super(param1NavigableMap);
    }
    
    public K ceiling(K param1K) {
      return sortedMap().ceilingKey(param1K);
    }
    
    public Iterator<K> descendingIterator() {
      return descendingSet().iterator();
    }
    
    public NavigableSet<K> descendingSet() {
      return new NavigableKeySet(sortedMap().descendingMap());
    }
    
    public K floor(K param1K) {
      return sortedMap().floorKey(param1K);
    }
    
    public NavigableSet<K> headSet(K param1K) {
      return headSet(param1K, false);
    }
    
    public NavigableSet<K> headSet(K param1K, boolean param1Boolean) {
      return new NavigableKeySet(sortedMap().headMap(param1K, param1Boolean));
    }
    
    public K higher(K param1K) {
      return sortedMap().higherKey(param1K);
    }
    
    public K lower(K param1K) {
      return sortedMap().lowerKey(param1K);
    }
    
    public K pollFirst() {
      return Iterators.pollNext(iterator());
    }
    
    public K pollLast() {
      return Iterators.pollNext(descendingIterator());
    }
    
    NavigableMap<K, Collection<V>> sortedMap() {
      return (NavigableMap<K, Collection<V>>)super.sortedMap();
    }
    
    public NavigableSet<K> subSet(K param1K1, K param1K2) {
      return subSet(param1K1, true, param1K2, false);
    }
    
    public NavigableSet<K> subSet(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return new NavigableKeySet(sortedMap().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2));
    }
    
    public NavigableSet<K> tailSet(K param1K) {
      return tailSet(param1K, true);
    }
    
    public NavigableSet<K> tailSet(K param1K, boolean param1Boolean) {
      return new NavigableKeySet(sortedMap().tailMap(param1K, param1Boolean));
    }
  }
  
  private class RandomAccessWrappedList extends WrappedList implements RandomAccess {
    RandomAccessWrappedList(K param1K, @Nullable List<V> param1List, AbstractMapBasedMultimap<K, V>.WrappedCollection param1WrappedCollection) {
      super(param1K, param1List, param1WrappedCollection);
    }
  }
  
  private class SortedAsMap extends AsMap implements SortedMap<K, Collection<V>> {
    SortedSet<K> sortedKeySet;
    
    SortedAsMap(SortedMap<K, Collection<V>> param1SortedMap) {
      super(param1SortedMap);
    }
    
    public Comparator<? super K> comparator() {
      return sortedMap().comparator();
    }
    
    SortedSet<K> createKeySet() {
      return new AbstractMapBasedMultimap.SortedKeySet(sortedMap());
    }
    
    public K firstKey() {
      return sortedMap().firstKey();
    }
    
    public SortedMap<K, Collection<V>> headMap(K param1K) {
      return new SortedAsMap(sortedMap().headMap(param1K));
    }
    
    public SortedSet<K> keySet() {
      SortedSet<K> sortedSet1 = this.sortedKeySet;
      SortedSet<K> sortedSet2 = sortedSet1;
      if (sortedSet1 == null) {
        sortedSet2 = createKeySet();
        this.sortedKeySet = sortedSet2;
      } 
      return sortedSet2;
    }
    
    public K lastKey() {
      return sortedMap().lastKey();
    }
    
    SortedMap<K, Collection<V>> sortedMap() {
      return (SortedMap<K, Collection<V>>)this.submap;
    }
    
    public SortedMap<K, Collection<V>> subMap(K param1K1, K param1K2) {
      return new SortedAsMap(sortedMap().subMap(param1K1, param1K2));
    }
    
    public SortedMap<K, Collection<V>> tailMap(K param1K) {
      return new SortedAsMap(sortedMap().tailMap(param1K));
    }
  }
  
  private class SortedKeySet extends KeySet implements SortedSet<K> {
    SortedKeySet(SortedMap<K, Collection<V>> param1SortedMap) {
      super(param1SortedMap);
    }
    
    public Comparator<? super K> comparator() {
      return sortedMap().comparator();
    }
    
    public K first() {
      return sortedMap().firstKey();
    }
    
    public SortedSet<K> headSet(K param1K) {
      return new SortedKeySet(sortedMap().headMap(param1K));
    }
    
    public K last() {
      return sortedMap().lastKey();
    }
    
    SortedMap<K, Collection<V>> sortedMap() {
      return (SortedMap<K, Collection<V>>)map();
    }
    
    public SortedSet<K> subSet(K param1K1, K param1K2) {
      return new SortedKeySet(sortedMap().subMap(param1K1, param1K2));
    }
    
    public SortedSet<K> tailSet(K param1K) {
      return new SortedKeySet(sortedMap().tailMap(param1K));
    }
  }
  
  private class WrappedCollection extends AbstractCollection<V> {
    final WrappedCollection ancestor;
    
    final Collection<V> ancestorDelegate;
    
    Collection<V> delegate;
    
    final K key;
    
    WrappedCollection(K param1K, @Nullable Collection<V> param1Collection, WrappedCollection param1WrappedCollection) {
      Collection<V> collection;
      this.key = param1K;
      this.delegate = param1Collection;
      this.ancestor = param1WrappedCollection;
      if (param1WrappedCollection == null) {
        AbstractMapBasedMultimap.this = null;
      } else {
        collection = param1WrappedCollection.getDelegate();
      } 
      this.ancestorDelegate = collection;
    }
    
    public boolean add(V param1V) {
      refreshIfEmpty();
      boolean bool1 = this.delegate.isEmpty();
      boolean bool2 = this.delegate.add(param1V);
      if (bool2) {
        AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
        if (bool1)
          addToMap(); 
      } 
      return bool2;
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      if (param1Collection.isEmpty())
        return false; 
      int i = size();
      boolean bool = this.delegate.addAll(param1Collection);
      if (bool) {
        int j = this.delegate.size();
        AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, j - i);
        if (i == 0)
          addToMap(); 
      } 
      return bool;
    }
    
    void addToMap() {
      WrappedCollection wrappedCollection = this.ancestor;
      if (wrappedCollection != null) {
        wrappedCollection.addToMap();
      } else {
        AbstractMapBasedMultimap.this.map.put(this.key, this.delegate);
      } 
    }
    
    public void clear() {
      int i = size();
      if (i == 0)
        return; 
      this.delegate.clear();
      AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, i);
      removeIfEmpty();
    }
    
    public boolean contains(Object param1Object) {
      refreshIfEmpty();
      return this.delegate.contains(param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      refreshIfEmpty();
      return this.delegate.containsAll(param1Collection);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      refreshIfEmpty();
      return this.delegate.equals(param1Object);
    }
    
    WrappedCollection getAncestor() {
      return this.ancestor;
    }
    
    Collection<V> getDelegate() {
      return this.delegate;
    }
    
    K getKey() {
      return this.key;
    }
    
    public int hashCode() {
      refreshIfEmpty();
      return this.delegate.hashCode();
    }
    
    public Iterator<V> iterator() {
      refreshIfEmpty();
      return new WrappedIterator();
    }
    
    void refreshIfEmpty() {
      WrappedCollection wrappedCollection = this.ancestor;
      if (wrappedCollection != null) {
        wrappedCollection.refreshIfEmpty();
        if (this.ancestor.getDelegate() != this.ancestorDelegate)
          throw new ConcurrentModificationException(); 
      } else if (this.delegate.isEmpty()) {
        Collection<V> collection = (Collection)AbstractMapBasedMultimap.this.map.get(this.key);
        if (collection != null)
          this.delegate = collection; 
      } 
    }
    
    public boolean remove(Object param1Object) {
      refreshIfEmpty();
      boolean bool = this.delegate.remove(param1Object);
      if (bool) {
        AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        removeIfEmpty();
      } 
      return bool;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      if (param1Collection.isEmpty())
        return false; 
      int i = size();
      boolean bool = this.delegate.removeAll(param1Collection);
      if (bool) {
        int j = this.delegate.size();
        AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, j - i);
        removeIfEmpty();
      } 
      return bool;
    }
    
    void removeIfEmpty() {
      WrappedCollection wrappedCollection = this.ancestor;
      if (wrappedCollection != null) {
        wrappedCollection.removeIfEmpty();
      } else if (this.delegate.isEmpty()) {
        AbstractMapBasedMultimap.this.map.remove(this.key);
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      int i = size();
      boolean bool = this.delegate.retainAll(param1Collection);
      if (bool) {
        int j = this.delegate.size();
        AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, j - i);
        removeIfEmpty();
      } 
      return bool;
    }
    
    public int size() {
      refreshIfEmpty();
      return this.delegate.size();
    }
    
    public String toString() {
      refreshIfEmpty();
      return this.delegate.toString();
    }
    
    class WrappedIterator implements Iterator<V> {
      final Iterator<V> delegateIterator = AbstractMapBasedMultimap.this.iteratorOrListIterator(AbstractMapBasedMultimap.WrappedCollection.this.delegate);
      
      final Collection<V> originalDelegate = AbstractMapBasedMultimap.WrappedCollection.this.delegate;
      
      WrappedIterator() {}
      
      WrappedIterator(Iterator<V> param2Iterator) {}
      
      Iterator<V> getDelegateIterator() {
        validateIterator();
        return this.delegateIterator;
      }
      
      public boolean hasNext() {
        validateIterator();
        return this.delegateIterator.hasNext();
      }
      
      public V next() {
        validateIterator();
        return this.delegateIterator.next();
      }
      
      public void remove() {
        this.delegateIterator.remove();
        AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        AbstractMapBasedMultimap.WrappedCollection.this.removeIfEmpty();
      }
      
      void validateIterator() {
        AbstractMapBasedMultimap.WrappedCollection.this.refreshIfEmpty();
        if (AbstractMapBasedMultimap.WrappedCollection.this.delegate == this.originalDelegate)
          return; 
        throw new ConcurrentModificationException();
      }
    }
  }
  
  class WrappedIterator implements Iterator<V> {
    final Iterator<V> delegateIterator = AbstractMapBasedMultimap.this.iteratorOrListIterator(((AbstractMapBasedMultimap.WrappedCollection)AbstractMapBasedMultimap.this).delegate);
    
    final Collection<V> originalDelegate = this.this$1.delegate;
    
    WrappedIterator() {}
    
    WrappedIterator(Iterator<V> param1Iterator) {}
    
    Iterator<V> getDelegateIterator() {
      validateIterator();
      return this.delegateIterator;
    }
    
    public boolean hasNext() {
      validateIterator();
      return this.delegateIterator.hasNext();
    }
    
    public V next() {
      validateIterator();
      return this.delegateIterator.next();
    }
    
    public void remove() {
      this.delegateIterator.remove();
      AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
      this.this$1.removeIfEmpty();
    }
    
    void validateIterator() {
      this.this$1.refreshIfEmpty();
      if (this.this$1.delegate == this.originalDelegate)
        return; 
      throw new ConcurrentModificationException();
    }
  }
  
  private class WrappedList extends WrappedCollection implements List<V> {
    WrappedList(K param1K, @Nullable List<V> param1List, AbstractMapBasedMultimap<K, V>.WrappedCollection param1WrappedCollection) {
      super(param1K, param1List, param1WrappedCollection);
    }
    
    public void add(int param1Int, V param1V) {
      refreshIfEmpty();
      boolean bool = getDelegate().isEmpty();
      getListDelegate().add(param1Int, param1V);
      AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
      if (bool)
        addToMap(); 
    }
    
    public boolean addAll(int param1Int, Collection<? extends V> param1Collection) {
      if (param1Collection.isEmpty())
        return false; 
      int i = size();
      boolean bool = getListDelegate().addAll(param1Int, param1Collection);
      if (bool) {
        param1Int = getDelegate().size();
        AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, param1Int - i);
        if (i == 0)
          addToMap(); 
      } 
      return bool;
    }
    
    public V get(int param1Int) {
      refreshIfEmpty();
      return getListDelegate().get(param1Int);
    }
    
    List<V> getListDelegate() {
      return (List<V>)getDelegate();
    }
    
    public int indexOf(Object param1Object) {
      refreshIfEmpty();
      return getListDelegate().indexOf(param1Object);
    }
    
    public int lastIndexOf(Object param1Object) {
      refreshIfEmpty();
      return getListDelegate().lastIndexOf(param1Object);
    }
    
    public ListIterator<V> listIterator() {
      refreshIfEmpty();
      return new WrappedListIterator();
    }
    
    public ListIterator<V> listIterator(int param1Int) {
      refreshIfEmpty();
      return new WrappedListIterator(param1Int);
    }
    
    public V remove(int param1Int) {
      refreshIfEmpty();
      V v = getListDelegate().remove(param1Int);
      AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
      removeIfEmpty();
      return v;
    }
    
    public V set(int param1Int, V param1V) {
      refreshIfEmpty();
      return getListDelegate().set(param1Int, param1V);
    }
    
    public List<V> subList(int param1Int1, int param1Int2) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      refreshIfEmpty();
      AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      K k = getKey();
      List<V> list = getListDelegate().subList(param1Int1, param1Int2);
      if (getAncestor() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = getAncestor();
      } 
      return abstractMapBasedMultimap.wrapList(k, list, wrappedCollection);
    }
    
    private class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator implements ListIterator<V> {
      WrappedListIterator() {}
      
      public WrappedListIterator(int param2Int) {
        super(AbstractMapBasedMultimap.WrappedList.this.getListDelegate().listIterator(param2Int));
      }
      
      private ListIterator<V> getDelegateListIterator() {
        return (ListIterator<V>)getDelegateIterator();
      }
      
      public void add(V param2V) {
        boolean bool = AbstractMapBasedMultimap.WrappedList.this.isEmpty();
        getDelegateListIterator().add(param2V);
        AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
        if (bool)
          AbstractMapBasedMultimap.WrappedList.this.addToMap(); 
      }
      
      public boolean hasPrevious() {
        return getDelegateListIterator().hasPrevious();
      }
      
      public int nextIndex() {
        return getDelegateListIterator().nextIndex();
      }
      
      public V previous() {
        return getDelegateListIterator().previous();
      }
      
      public int previousIndex() {
        return getDelegateListIterator().previousIndex();
      }
      
      public void set(V param2V) {
        getDelegateListIterator().set(param2V);
      }
    }
  }
  
  private class WrappedListIterator extends WrappedCollection.WrappedIterator implements ListIterator<V> {
    WrappedListIterator() {
      super((AbstractMapBasedMultimap.WrappedCollection)AbstractMapBasedMultimap.this);
    }
    
    public WrappedListIterator(int param1Int) {
      super((AbstractMapBasedMultimap.WrappedCollection)AbstractMapBasedMultimap.this, AbstractMapBasedMultimap.this.getListDelegate().listIterator(param1Int));
    }
    
    private ListIterator<V> getDelegateListIterator() {
      return (ListIterator<V>)getDelegateIterator();
    }
    
    public void add(V param1V) {
      boolean bool = this.this$1.isEmpty();
      getDelegateListIterator().add(param1V);
      AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
      if (bool)
        this.this$1.addToMap(); 
    }
    
    public boolean hasPrevious() {
      return getDelegateListIterator().hasPrevious();
    }
    
    public int nextIndex() {
      return getDelegateListIterator().nextIndex();
    }
    
    public V previous() {
      return getDelegateListIterator().previous();
    }
    
    public int previousIndex() {
      return getDelegateListIterator().previousIndex();
    }
    
    public void set(V param1V) {
      getDelegateListIterator().set(param1V);
    }
  }
  
  @GwtIncompatible
  class WrappedNavigableSet extends WrappedSortedSet implements NavigableSet<V> {
    WrappedNavigableSet(K param1K, @Nullable NavigableSet<V> param1NavigableSet, AbstractMapBasedMultimap<K, V>.WrappedCollection param1WrappedCollection) {
      super(param1K, param1NavigableSet, param1WrappedCollection);
    }
    
    private NavigableSet<V> wrap(NavigableSet<V> param1NavigableSet) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      K k = this.key;
      if (getAncestor() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = getAncestor();
      } 
      return new WrappedNavigableSet(k, param1NavigableSet, wrappedCollection);
    }
    
    public V ceiling(V param1V) {
      return getSortedSetDelegate().ceiling(param1V);
    }
    
    public Iterator<V> descendingIterator() {
      return new AbstractMapBasedMultimap.WrappedCollection.WrappedIterator(getSortedSetDelegate().descendingIterator());
    }
    
    public NavigableSet<V> descendingSet() {
      return wrap(getSortedSetDelegate().descendingSet());
    }
    
    public V floor(V param1V) {
      return getSortedSetDelegate().floor(param1V);
    }
    
    NavigableSet<V> getSortedSetDelegate() {
      return (NavigableSet<V>)super.getSortedSetDelegate();
    }
    
    public NavigableSet<V> headSet(V param1V, boolean param1Boolean) {
      return wrap(getSortedSetDelegate().headSet(param1V, param1Boolean));
    }
    
    public V higher(V param1V) {
      return getSortedSetDelegate().higher(param1V);
    }
    
    public V lower(V param1V) {
      return getSortedSetDelegate().lower(param1V);
    }
    
    public V pollFirst() {
      return Iterators.pollNext(iterator());
    }
    
    public V pollLast() {
      return Iterators.pollNext(descendingIterator());
    }
    
    public NavigableSet<V> subSet(V param1V1, boolean param1Boolean1, V param1V2, boolean param1Boolean2) {
      return wrap(getSortedSetDelegate().subSet(param1V1, param1Boolean1, param1V2, param1Boolean2));
    }
    
    public NavigableSet<V> tailSet(V param1V, boolean param1Boolean) {
      return wrap(getSortedSetDelegate().tailSet(param1V, param1Boolean));
    }
  }
  
  private class WrappedSet extends WrappedCollection implements Set<V> {
    WrappedSet(K param1K, Set<V> param1Set) {
      super(param1K, param1Set, null);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      if (param1Collection.isEmpty())
        return false; 
      int i = size();
      boolean bool = Sets.removeAllImpl((Set)this.delegate, param1Collection);
      if (bool) {
        int j = this.delegate.size();
        AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, j - i);
        removeIfEmpty();
      } 
      return bool;
    }
  }
  
  private class WrappedSortedSet extends WrappedCollection implements SortedSet<V> {
    WrappedSortedSet(K param1K, @Nullable SortedSet<V> param1SortedSet, AbstractMapBasedMultimap<K, V>.WrappedCollection param1WrappedCollection) {
      super(param1K, param1SortedSet, param1WrappedCollection);
    }
    
    public Comparator<? super V> comparator() {
      return getSortedSetDelegate().comparator();
    }
    
    public V first() {
      refreshIfEmpty();
      return getSortedSetDelegate().first();
    }
    
    SortedSet<V> getSortedSetDelegate() {
      return (SortedSet<V>)getDelegate();
    }
    
    public SortedSet<V> headSet(V param1V) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      refreshIfEmpty();
      AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      K k = getKey();
      SortedSet<V> sortedSet = getSortedSetDelegate().headSet(param1V);
      if (getAncestor() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = getAncestor();
      } 
      return new WrappedSortedSet(k, sortedSet, wrappedCollection);
    }
    
    public V last() {
      refreshIfEmpty();
      return getSortedSetDelegate().last();
    }
    
    public SortedSet<V> subSet(V param1V1, V param1V2) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      refreshIfEmpty();
      AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      K k = getKey();
      SortedSet<V> sortedSet = getSortedSetDelegate().subSet(param1V1, param1V2);
      if (getAncestor() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = getAncestor();
      } 
      return new WrappedSortedSet(k, sortedSet, wrappedCollection);
    }
    
    public SortedSet<V> tailSet(V param1V) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      refreshIfEmpty();
      AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      K k = getKey();
      SortedSet<V> sortedSet = getSortedSetDelegate().tailSet(param1V);
      if (getAncestor() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = getAncestor();
      } 
      return new WrappedSortedSet(k, sortedSet, wrappedCollection);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractMapBasedMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */