package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
  private transient Map<K, Collection<V>> asMap;
  
  private transient Collection<Map.Entry<K, V>> entries;
  
  private transient Set<K> keySet;
  
  private transient Multiset<K> keys;
  
  private transient Collection<V> values;
  
  public Map<K, Collection<V>> asMap() {
    Map<K, Collection<V>> map1 = this.asMap;
    Map<K, Collection<V>> map2 = map1;
    if (map1 == null) {
      map2 = createAsMap();
      this.asMap = map2;
    } 
    return map2;
  }
  
  public boolean containsEntry(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    boolean bool;
    paramObject1 = asMap().get(paramObject1);
    if (paramObject1 != null && paramObject1.contains(paramObject2)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    Iterator<Collection> iterator = asMap().values().iterator();
    while (iterator.hasNext()) {
      if (((Collection)iterator.next()).contains(paramObject))
        return true; 
    } 
    return false;
  }
  
  abstract Map<K, Collection<V>> createAsMap();
  
  Collection<Map.Entry<K, V>> createEntries() {
    return (this instanceof SetMultimap) ? new EntrySet() : new Entries();
  }
  
  Set<K> createKeySet() {
    return new Maps.KeySet<K, Collection<V>>(asMap());
  }
  
  Multiset<K> createKeys() {
    return new Multimaps.Keys<K, Object>(this);
  }
  
  Collection<V> createValues() {
    return new Values();
  }
  
  public Collection<Map.Entry<K, V>> entries() {
    Collection<Map.Entry<K, V>> collection1 = this.entries;
    Collection<Map.Entry<K, V>> collection2 = collection1;
    if (collection1 == null) {
      collection2 = createEntries();
      this.entries = collection2;
    } 
    return collection2;
  }
  
  abstract Iterator<Map.Entry<K, V>> entryIterator();
  
  public boolean equals(@Nullable Object paramObject) {
    return Multimaps.equalsImpl(this, paramObject);
  }
  
  public int hashCode() {
    return asMap().hashCode();
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
  
  public Set<K> keySet() {
    Set<K> set1 = this.keySet;
    Set<K> set2 = set1;
    if (set1 == null) {
      set2 = createKeySet();
      this.keySet = set2;
    } 
    return set2;
  }
  
  public Multiset<K> keys() {
    Multiset<K> multiset1 = this.keys;
    Multiset<K> multiset2 = multiset1;
    if (multiset1 == null) {
      multiset2 = createKeys();
      this.keys = multiset2;
    } 
    return multiset2;
  }
  
  @CanIgnoreReturnValue
  public boolean put(@Nullable K paramK, @Nullable V paramV) {
    return get(paramK).add(paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap) {
    Iterator<Map.Entry> iterator = paramMultimap.entries().iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool |= put((K)entry.getKey(), (V)entry.getValue()))
      Map.Entry entry = iterator.next(); 
    return bool;
  }
  
  @CanIgnoreReturnValue
  public boolean putAll(@Nullable K paramK, Iterable<? extends V> paramIterable) {
    Preconditions.checkNotNull(paramIterable);
    boolean bool = paramIterable instanceof Collection;
    boolean bool1 = true;
    boolean bool2 = true;
    if (bool) {
      paramIterable = paramIterable;
      if (paramIterable.isEmpty() || !get(paramK).addAll((Collection<? extends V>)paramIterable))
        bool2 = false; 
      return bool2;
    } 
    Iterator<? extends V> iterator = paramIterable.iterator();
    if (iterator.hasNext() && Iterators.addAll(get(paramK), iterator)) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    return bool2;
  }
  
  @CanIgnoreReturnValue
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    boolean bool;
    paramObject1 = asMap().get(paramObject1);
    if (paramObject1 != null && paramObject1.remove(paramObject2)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @CanIgnoreReturnValue
  public Collection<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable) {
    Preconditions.checkNotNull(paramIterable);
    Collection<V> collection = removeAll(paramK);
    putAll(paramK, paramIterable);
    return collection;
  }
  
  public String toString() {
    return asMap().toString();
  }
  
  Iterator<V> valueIterator() {
    return Maps.valueIterator(entries().iterator());
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
  
  private class Entries extends Multimaps.Entries<K, V> {
    private Entries() {}
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return AbstractMultimap.this.entryIterator();
    }
    
    Multimap<K, V> multimap() {
      return AbstractMultimap.this;
    }
  }
  
  private class EntrySet extends Entries implements Set<Map.Entry<K, V>> {
    private EntrySet() {}
    
    public boolean equals(@Nullable Object param1Object) {
      return Sets.equalsImpl(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.hashCodeImpl(this);
    }
  }
  
  class Values extends AbstractCollection<V> {
    public void clear() {
      AbstractMultimap.this.clear();
    }
    
    public boolean contains(@Nullable Object param1Object) {
      return AbstractMultimap.this.containsValue(param1Object);
    }
    
    public Iterator<V> iterator() {
      return AbstractMultimap.this.valueIterator();
    }
    
    public int size() {
      return AbstractMultimap.this.size();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */