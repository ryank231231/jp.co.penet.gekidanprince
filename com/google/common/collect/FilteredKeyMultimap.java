package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
  final Predicate<? super K> keyPredicate;
  
  final Multimap<K, V> unfiltered;
  
  FilteredKeyMultimap(Multimap<K, V> paramMultimap, Predicate<? super K> paramPredicate) {
    this.unfiltered = (Multimap<K, V>)Preconditions.checkNotNull(paramMultimap);
    this.keyPredicate = (Predicate<? super K>)Preconditions.checkNotNull(paramPredicate);
  }
  
  public void clear() {
    keySet().clear();
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    return this.unfiltered.containsKey(paramObject) ? this.keyPredicate.apply(paramObject) : false;
  }
  
  Map<K, Collection<V>> createAsMap() {
    return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
  }
  
  Collection<Map.Entry<K, V>> createEntries() {
    return new Entries();
  }
  
  Set<K> createKeySet() {
    return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
  }
  
  Multiset<K> createKeys() {
    return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
  }
  
  Collection<V> createValues() {
    return new FilteredMultimapValues<Object, V>(this);
  }
  
  Iterator<Map.Entry<K, V>> entryIterator() {
    throw new AssertionError("should never be called");
  }
  
  public Predicate<? super Map.Entry<K, V>> entryPredicate() {
    return (Predicate)Maps.keyPredicateOnEntries(this.keyPredicate);
  }
  
  public Collection<V> get(K paramK) {
    return (Collection<V>)(this.keyPredicate.apply(paramK) ? this.unfiltered.get(paramK) : ((this.unfiltered instanceof SetMultimap) ? new AddRejectingSet<K, V>(paramK) : new AddRejectingList<K, V>(paramK)));
  }
  
  public Collection<V> removeAll(Object<V> paramObject) {
    if (containsKey(paramObject)) {
      paramObject = (Object<V>)this.unfiltered.removeAll(paramObject);
    } else {
      paramObject = (Object<V>)unmodifiableEmptyCollection();
    } 
    return (Collection<V>)paramObject;
  }
  
  public int size() {
    Iterator<Collection> iterator = asMap().values().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((Collection)iterator.next()).size());
    return i;
  }
  
  public Multimap<K, V> unfiltered() {
    return this.unfiltered;
  }
  
  Collection<V> unmodifiableEmptyCollection() {
    return (Collection<V>)((this.unfiltered instanceof SetMultimap) ? ImmutableSet.of() : ImmutableList.of());
  }
  
  static class AddRejectingList<K, V> extends ForwardingList<V> {
    final K key;
    
    AddRejectingList(K param1K) {
      this.key = param1K;
    }
    
    public void add(int param1Int, V param1V) {
      Preconditions.checkPositionIndex(param1Int, 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key does not satisfy predicate: ");
      stringBuilder.append(this.key);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public boolean add(V param1V) {
      add(0, param1V);
      return true;
    }
    
    @CanIgnoreReturnValue
    public boolean addAll(int param1Int, Collection<? extends V> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      Preconditions.checkPositionIndex(param1Int, 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key does not satisfy predicate: ");
      stringBuilder.append(this.key);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      addAll(0, param1Collection);
      return true;
    }
    
    protected List<V> delegate() {
      return Collections.emptyList();
    }
  }
  
  static class AddRejectingSet<K, V> extends ForwardingSet<V> {
    final K key;
    
    AddRejectingSet(K param1K) {
      this.key = param1K;
    }
    
    public boolean add(V param1V) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key does not satisfy predicate: ");
      stringBuilder.append(this.key);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key does not satisfy predicate: ");
      stringBuilder.append(this.key);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    protected Set<V> delegate() {
      return Collections.emptySet();
    }
  }
  
  class Entries extends ForwardingCollection<Map.Entry<K, V>> {
    protected Collection<Map.Entry<K, V>> delegate() {
      return Collections2.filter(FilteredKeyMultimap.this.unfiltered.entries(), FilteredKeyMultimap.this.entryPredicate());
    }
    
    public boolean remove(@Nullable Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        if (FilteredKeyMultimap.this.unfiltered.containsKey(param1Object.getKey()) && FilteredKeyMultimap.this.keyPredicate.apply(param1Object.getKey()))
          return FilteredKeyMultimap.this.unfiltered.remove(param1Object.getKey(), param1Object.getValue()); 
      } 
      return false;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\FilteredKeyMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */