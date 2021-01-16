package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Deprecated
@Beta
@GwtCompatible
public final class MapConstraints {
  private static <K, V> Map<K, V> checkMap(Map<? extends K, ? extends V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint) {
    LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<K, V>(paramMap);
    for (Map.Entry<K, V> entry : linkedHashMap.entrySet())
      paramMapConstraint.checkKeyValue((K)entry.getKey(), (V)entry.getValue()); 
    return linkedHashMap;
  }
  
  private static <K, V> Collection<V> checkValues(K paramK, Iterable<? extends V> paramIterable, MapConstraint<? super K, ? super V> paramMapConstraint) {
    ArrayList<V> arrayList = Lists.newArrayList(paramIterable);
    Iterator<V> iterator = arrayList.iterator();
    while (iterator.hasNext())
      paramMapConstraint.checkKeyValue(paramK, iterator.next()); 
    return arrayList;
  }
  
  private static <K, V> Set<Map.Entry<K, Collection<V>>> constrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint) {
    return new ConstrainedAsMapEntries<K, V>(paramSet, paramMapConstraint);
  }
  
  private static <K, V> Map.Entry<K, Collection<V>> constrainedAsMapEntry(final Map.Entry<K, Collection<V>> entry, final MapConstraint<? super K, ? super V> constraint) {
    Preconditions.checkNotNull(entry);
    Preconditions.checkNotNull(constraint);
    return (Map.Entry)new ForwardingMapEntry<K, Collection<Collection<V>>>() {
        protected Map.Entry<K, Collection<V>> delegate() {
          return entry;
        }
        
        public Collection<V> getValue() {
          return Constraints.constrainedTypePreservingCollection((Collection<V>)entry.getValue(), new Constraint() {
                public V checkElement(V param2V) {
                  constraint.checkKeyValue(MapConstraints.null.this.getKey(), param2V);
                  return param2V;
                }
              });
        }
      };
  }
  
  private static <K, V> Collection<Map.Entry<K, V>> constrainedEntries(Collection<Map.Entry<K, V>> paramCollection, MapConstraint<? super K, ? super V> paramMapConstraint) {
    return (Collection<Map.Entry<K, V>>)((paramCollection instanceof Set) ? constrainedEntrySet((Set<Map.Entry<K, V>>)paramCollection, paramMapConstraint) : new ConstrainedEntries<K, V>(paramCollection, paramMapConstraint));
  }
  
  private static <K, V> Map.Entry<K, V> constrainedEntry(final Map.Entry<K, V> entry, final MapConstraint<? super K, ? super V> constraint) {
    Preconditions.checkNotNull(entry);
    Preconditions.checkNotNull(constraint);
    return new ForwardingMapEntry<K, V>() {
        protected Map.Entry<K, V> delegate() {
          return entry;
        }
        
        public V setValue(V param1V) {
          constraint.checkKeyValue(getKey(), param1V);
          return (V)entry.setValue(param1V);
        }
      };
  }
  
  private static <K, V> Set<Map.Entry<K, V>> constrainedEntrySet(Set<Map.Entry<K, V>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint) {
    return new ConstrainedEntrySet<K, V>(paramSet, paramMapConstraint);
  }
  
  public static <K, V> ListMultimap<K, V> constrainedListMultimap(ListMultimap<K, V> paramListMultimap, MapConstraint<? super K, ? super V> paramMapConstraint) {
    return new ConstrainedListMultimap<K, V>(paramListMultimap, paramMapConstraint);
  }
  
  public static <K, V> Map<K, V> constrainedMap(Map<K, V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint) {
    return new ConstrainedMap<K, V>(paramMap, paramMapConstraint);
  }
  
  static class ConstrainedAsMapEntries<K, V> extends ForwardingSet<Map.Entry<K, Collection<V>>> {
    private final MapConstraint<? super K, ? super V> constraint;
    
    private final Set<Map.Entry<K, Collection<V>>> entries;
    
    ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> param1Set, MapConstraint<? super K, ? super V> param1MapConstraint) {
      this.entries = param1Set;
      this.constraint = param1MapConstraint;
    }
    
    public boolean contains(Object param1Object) {
      return Maps.containsEntryImpl(delegate(), param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return standardContainsAll(param1Collection);
    }
    
    protected Set<Map.Entry<K, Collection<V>>> delegate() {
      return this.entries;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      return standardEquals(param1Object);
    }
    
    public int hashCode() {
      return standardHashCode();
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(this.entries.iterator()) {
          Map.Entry<K, Collection<V>> transform(Map.Entry<K, Collection<V>> param2Entry) {
            return MapConstraints.constrainedAsMapEntry(param2Entry, MapConstraints.ConstrainedAsMapEntries.this.constraint);
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      return Maps.removeEntryImpl(delegate(), param1Object);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return standardRemoveAll(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return standardRetainAll(param1Collection);
    }
    
    public Object[] toArray() {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])standardToArray((Object[])param1ArrayOfT);
    }
  }
  
  class null extends TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {
    null(Iterator<? extends Map.Entry<K, Collection<V>>> param1Iterator) {
      super(param1Iterator);
    }
    
    Map.Entry<K, Collection<V>> transform(Map.Entry<K, Collection<V>> param1Entry) {
      return MapConstraints.constrainedAsMapEntry(param1Entry, this.this$0.constraint);
    }
  }
  
  private static class ConstrainedAsMapValues<K, V> extends ForwardingCollection<Collection<V>> {
    final Collection<Collection<V>> delegate;
    
    final Set<Map.Entry<K, Collection<V>>> entrySet;
    
    ConstrainedAsMapValues(Collection<Collection<V>> param1Collection, Set<Map.Entry<K, Collection<V>>> param1Set) {
      this.delegate = param1Collection;
      this.entrySet = param1Set;
    }
    
    public boolean contains(Object param1Object) {
      return standardContains(param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return standardContainsAll(param1Collection);
    }
    
    protected Collection<Collection<V>> delegate() {
      return this.delegate;
    }
    
    public Iterator<Collection<V>> iterator() {
      return new Iterator<Collection<V>>() {
          public boolean hasNext() {
            return iterator.hasNext();
          }
          
          public Collection<V> next() {
            return (Collection<V>)((Map.Entry)iterator.next()).getValue();
          }
          
          public void remove() {
            iterator.remove();
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      return standardRemove(param1Object);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return standardRemoveAll(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return standardRetainAll(param1Collection);
    }
    
    public Object[] toArray() {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])standardToArray((Object[])param1ArrayOfT);
    }
  }
  
  class null implements Iterator<Collection<V>> {
    public boolean hasNext() {
      return iterator.hasNext();
    }
    
    public Collection<V> next() {
      return (Collection<V>)((Map.Entry)iterator.next()).getValue();
    }
    
    public void remove() {
      iterator.remove();
    }
  }
  
  private static class ConstrainedEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
    final MapConstraint<? super K, ? super V> constraint;
    
    final Collection<Map.Entry<K, V>> entries;
    
    ConstrainedEntries(Collection<Map.Entry<K, V>> param1Collection, MapConstraint<? super K, ? super V> param1MapConstraint) {
      this.entries = param1Collection;
      this.constraint = param1MapConstraint;
    }
    
    public boolean contains(Object param1Object) {
      return Maps.containsEntryImpl(delegate(), param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return standardContainsAll(param1Collection);
    }
    
    protected Collection<Map.Entry<K, V>> delegate() {
      return this.entries;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>(this.entries.iterator()) {
          Map.Entry<K, V> transform(Map.Entry<K, V> param2Entry) {
            return MapConstraints.constrainedEntry(param2Entry, MapConstraints.ConstrainedEntries.this.constraint);
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      return Maps.removeEntryImpl(delegate(), param1Object);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return standardRemoveAll(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return standardRetainAll(param1Collection);
    }
    
    public Object[] toArray() {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])standardToArray((Object[])param1ArrayOfT);
    }
  }
  
  class null extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>> {
    null(Iterator<? extends Map.Entry<K, V>> param1Iterator) {
      super(param1Iterator);
    }
    
    Map.Entry<K, V> transform(Map.Entry<K, V> param1Entry) {
      return MapConstraints.constrainedEntry(param1Entry, this.this$0.constraint);
    }
  }
  
  static class ConstrainedEntrySet<K, V> extends ConstrainedEntries<K, V> implements Set<Map.Entry<K, V>> {
    ConstrainedEntrySet(Set<Map.Entry<K, V>> param1Set, MapConstraint<? super K, ? super V> param1MapConstraint) {
      super(param1Set, param1MapConstraint);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      return Sets.equalsImpl(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.hashCodeImpl(this);
    }
  }
  
  private static class ConstrainedListMultimap<K, V> extends ConstrainedMultimap<K, V> implements ListMultimap<K, V> {
    ConstrainedListMultimap(ListMultimap<K, V> param1ListMultimap, MapConstraint<? super K, ? super V> param1MapConstraint) {
      super(param1ListMultimap, param1MapConstraint);
    }
    
    public List<V> get(K param1K) {
      return (List<V>)super.get(param1K);
    }
    
    public List<V> removeAll(Object param1Object) {
      return (List<V>)super.removeAll(param1Object);
    }
    
    public List<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      return (List<V>)super.replaceValues(param1K, param1Iterable);
    }
  }
  
  static class ConstrainedMap<K, V> extends ForwardingMap<K, V> {
    final MapConstraint<? super K, ? super V> constraint;
    
    private final Map<K, V> delegate;
    
    private transient Set<Map.Entry<K, V>> entrySet;
    
    ConstrainedMap(Map<K, V> param1Map, MapConstraint<? super K, ? super V> param1MapConstraint) {
      this.delegate = (Map<K, V>)Preconditions.checkNotNull(param1Map);
      this.constraint = (MapConstraint<? super K, ? super V>)Preconditions.checkNotNull(param1MapConstraint);
    }
    
    protected Map<K, V> delegate() {
      return this.delegate;
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      Set<Map.Entry<K, V>> set1 = this.entrySet;
      Set<Map.Entry<K, V>> set2 = set1;
      if (set1 == null) {
        set2 = MapConstraints.constrainedEntrySet(this.delegate.entrySet(), this.constraint);
        this.entrySet = set2;
      } 
      return set2;
    }
    
    @CanIgnoreReturnValue
    public V put(K param1K, V param1V) {
      this.constraint.checkKeyValue(param1K, param1V);
      return this.delegate.put(param1K, param1V);
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      this.delegate.putAll(MapConstraints.checkMap(param1Map, this.constraint));
    }
  }
  
  private static class ConstrainedMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
    transient Map<K, Collection<V>> asMap;
    
    final MapConstraint<? super K, ? super V> constraint;
    
    final Multimap<K, V> delegate;
    
    transient Collection<Map.Entry<K, V>> entries;
    
    public ConstrainedMultimap(Multimap<K, V> param1Multimap, MapConstraint<? super K, ? super V> param1MapConstraint) {
      this.delegate = (Multimap<K, V>)Preconditions.checkNotNull(param1Multimap);
      this.constraint = (MapConstraint<? super K, ? super V>)Preconditions.checkNotNull(param1MapConstraint);
    }
    
    public Map<K, Collection<V>> asMap() {
      Map<K, Collection<V>> map1 = this.asMap;
      Map<K, Collection<V>> map2 = map1;
      if (map1 == null) {
        class AsMap extends ForwardingMap<K, Collection<V>> {
          Set<Map.Entry<K, Collection<V>>> entrySet;
          
          Collection<Collection<V>> values;
          
          public boolean containsValue(Object param2Object) {
            return values().contains(param2Object);
          }
          
          protected Map<K, Collection<V>> delegate() {
            return asMapDelegate;
          }
          
          public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set1 = this.entrySet;
            Set<Map.Entry<K, Collection<V>>> set2 = set1;
            if (set1 == null) {
              set2 = MapConstraints.constrainedAsMapEntries(asMapDelegate.entrySet(), MapConstraints.ConstrainedMultimap.this.constraint);
              this.entrySet = set2;
            } 
            return set2;
          }
          
          public Collection<V> get(Object param2Object) {
            try {
              param2Object = MapConstraints.ConstrainedMultimap.this.get(param2Object);
              boolean bool = param2Object.isEmpty();
              if (bool)
                param2Object = null; 
              return (Collection<V>)param2Object;
            } catch (ClassCastException classCastException) {
              return null;
            } 
          }
          
          public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection1 = this.values;
            Collection<Collection<V>> collection2 = collection1;
            if (collection1 == null) {
              collection2 = new MapConstraints.ConstrainedAsMapValues<K, V>(delegate().values(), entrySet());
              this.values = collection2;
            } 
            return collection2;
          }
        };
        map2 = new AsMap();
        this.asMap = map2;
      } 
      return map2;
    }
    
    protected Multimap<K, V> delegate() {
      return this.delegate;
    }
    
    public Collection<Map.Entry<K, V>> entries() {
      Collection<Map.Entry<K, V>> collection1 = this.entries;
      Collection<Map.Entry<K, V>> collection2 = collection1;
      if (collection1 == null) {
        collection2 = MapConstraints.constrainedEntries(this.delegate.entries(), this.constraint);
        this.entries = collection2;
      } 
      return collection2;
    }
    
    public Collection<V> get(final K key) {
      return Constraints.constrainedTypePreservingCollection(this.delegate.get(key), new Constraint<V>() {
            public V checkElement(V param2V) {
              MapConstraints.ConstrainedMultimap.this.constraint.checkKeyValue(key, param2V);
              return param2V;
            }
          });
    }
    
    public boolean put(K param1K, V param1V) {
      this.constraint.checkKeyValue(param1K, param1V);
      return this.delegate.put(param1K, param1V);
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> param1Multimap) {
      Iterator<Map.Entry> iterator = param1Multimap.entries().iterator();
      boolean bool;
      for (bool = false; iterator.hasNext(); bool |= put((K)entry.getKey(), (V)entry.getValue()))
        Map.Entry entry = iterator.next(); 
      return bool;
    }
    
    public boolean putAll(K param1K, Iterable<? extends V> param1Iterable) {
      return this.delegate.putAll(param1K, MapConstraints.checkValues(param1K, param1Iterable, this.constraint));
    }
    
    public Collection<V> replaceValues(K param1K, Iterable<? extends V> param1Iterable) {
      return this.delegate.replaceValues(param1K, MapConstraints.checkValues(param1K, param1Iterable, this.constraint));
    }
  }
  
  class null implements Constraint<V> {
    public V checkElement(V param1V) {
      this.this$0.constraint.checkKeyValue(key, param1V);
      return param1V;
    }
  }
  
  class AsMap extends ForwardingMap<K, Collection<V>> {
    Set<Map.Entry<K, Collection<V>>> entrySet;
    
    Collection<Collection<V>> values;
    
    public boolean containsValue(Object param1Object) {
      return values().contains(param1Object);
    }
    
    protected Map<K, Collection<V>> delegate() {
      return asMapDelegate;
    }
    
    public Set<Map.Entry<K, Collection<V>>> entrySet() {
      Set<Map.Entry<K, Collection<V>>> set1 = this.entrySet;
      Set<Map.Entry<K, Collection<V>>> set2 = set1;
      if (set1 == null) {
        set2 = MapConstraints.constrainedAsMapEntries(asMapDelegate.entrySet(), this.this$0.constraint);
        this.entrySet = set2;
      } 
      return set2;
    }
    
    public Collection<V> get(Object param1Object) {
      try {
        param1Object = this.this$0.get(param1Object);
        boolean bool = param1Object.isEmpty();
        if (bool)
          param1Object = null; 
        return (Collection<V>)param1Object;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    public Collection<Collection<V>> values() {
      Collection<Collection<V>> collection1 = this.values;
      Collection<Collection<V>> collection2 = collection1;
      if (collection1 == null) {
        collection2 = new MapConstraints.ConstrainedAsMapValues<K, V>(delegate().values(), entrySet());
        this.values = collection2;
      } 
      return collection2;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MapConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */