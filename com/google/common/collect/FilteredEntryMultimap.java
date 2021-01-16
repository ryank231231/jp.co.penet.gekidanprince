package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
  final Predicate<? super Map.Entry<K, V>> predicate;
  
  final Multimap<K, V> unfiltered;
  
  FilteredEntryMultimap(Multimap<K, V> paramMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    this.unfiltered = (Multimap<K, V>)Preconditions.checkNotNull(paramMultimap);
    this.predicate = (Predicate<? super Map.Entry<K, V>>)Preconditions.checkNotNull(paramPredicate);
  }
  
  static <E> Collection<E> filterCollection(Collection<E> paramCollection, Predicate<? super E> paramPredicate) {
    return (paramCollection instanceof Set) ? Sets.filter((Set<E>)paramCollection, paramPredicate) : Collections2.filter(paramCollection, paramPredicate);
  }
  
  private boolean satisfies(K paramK, V paramV) {
    return this.predicate.apply(Maps.immutableEntry(paramK, paramV));
  }
  
  public void clear() {
    entries().clear();
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    boolean bool;
    if (asMap().get(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  Map<K, Collection<V>> createAsMap() {
    return new AsMap();
  }
  
  Collection<Map.Entry<K, V>> createEntries() {
    return filterCollection(this.unfiltered.entries(), this.predicate);
  }
  
  Multiset<K> createKeys() {
    return new Keys();
  }
  
  Collection<V> createValues() {
    return new FilteredMultimapValues<Object, V>(this);
  }
  
  Iterator<Map.Entry<K, V>> entryIterator() {
    throw new AssertionError("should never be called");
  }
  
  public Predicate<? super Map.Entry<K, V>> entryPredicate() {
    return this.predicate;
  }
  
  public Collection<V> get(K paramK) {
    return filterCollection(this.unfiltered.get(paramK), new ValuePredicate(paramK));
  }
  
  public Set<K> keySet() {
    return asMap().keySet();
  }
  
  public Collection<V> removeAll(@Nullable Object paramObject) {
    return (Collection<V>)MoreObjects.firstNonNull(asMap().remove(paramObject), unmodifiableEmptyCollection());
  }
  
  boolean removeEntriesIf(Predicate<? super Map.Entry<K, Collection<V>>> paramPredicate) {
    Iterator<Map.Entry> iterator = this.unfiltered.asMap().entrySet().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Object object = entry.getKey();
      Collection<?> collection = filterCollection((Collection)entry.getValue(), new ValuePredicate((K)object));
      if (!collection.isEmpty() && paramPredicate.apply(Maps.immutableEntry(object, collection))) {
        if (collection.size() == ((Collection)entry.getValue()).size()) {
          iterator.remove();
        } else {
          collection.clear();
        } 
        bool = true;
      } 
    } 
    return bool;
  }
  
  public int size() {
    return entries().size();
  }
  
  public Multimap<K, V> unfiltered() {
    return this.unfiltered;
  }
  
  Collection<V> unmodifiableEmptyCollection() {
    List<?> list;
    if (this.unfiltered instanceof SetMultimap) {
      Set<?> set = Collections.emptySet();
    } else {
      list = Collections.emptyList();
    } 
    return (Collection)list;
  }
  
  class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
    public void clear() {
      FilteredEntryMultimap.this.clear();
    }
    
    public boolean containsKey(@Nullable Object param1Object) {
      boolean bool;
      if (get(param1Object) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    Set<Map.Entry<K, Collection<V>>> createEntrySet() {
      class EntrySetImpl extends Maps.EntrySet<K, Collection<V>> {
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
          return new AbstractIterator<Map.Entry<K, Collection<V>>>() {
              final Iterator<Map.Entry<K, Collection<V>>> backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
              
              protected Map.Entry<K, Collection<V>> computeNext() {
                while (this.backingIterator.hasNext()) {
                  Map.Entry entry = this.backingIterator.next();
                  Object object = entry.getKey();
                  Collection<?> collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate((K)object));
                  if (!collection.isEmpty())
                    return (Map.Entry)Maps.immutableEntry((K)object, collection); 
                } 
                return endOfData();
              }
            };
        }
        
        Map<K, Collection<V>> map() {
          return FilteredEntryMultimap.AsMap.this;
        }
        
        public boolean removeAll(Collection<?> param2Collection) {
          return FilteredEntryMultimap.this.removeEntriesIf(Predicates.in(param2Collection));
        }
        
        public boolean retainAll(Collection<?> param2Collection) {
          return FilteredEntryMultimap.this.removeEntriesIf(Predicates.not(Predicates.in(param2Collection)));
        }
        
        public int size() {
          return Iterators.size(iterator());
        }
      };
      return new EntrySetImpl();
    }
    
    Set<K> createKeySet() {
      class KeySetImpl extends Maps.KeySet<K, Collection<V>> {
        KeySetImpl() {
          super(FilteredEntryMultimap.AsMap.this);
        }
        
        public boolean remove(@Nullable Object param2Object) {
          boolean bool;
          if (FilteredEntryMultimap.AsMap.this.remove(param2Object) != null) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public boolean removeAll(Collection<?> param2Collection) {
          return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(param2Collection)));
        }
        
        public boolean retainAll(Collection<?> param2Collection) {
          return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(param2Collection))));
        }
      };
      return new KeySetImpl();
    }
    
    Collection<Collection<V>> createValues() {
      class ValuesImpl extends Maps.Values<K, Collection<V>> {
        ValuesImpl() {
          super(FilteredEntryMultimap.AsMap.this);
        }
        
        public boolean remove(@Nullable Object param2Object) {
          if (param2Object instanceof Collection) {
            param2Object = param2Object;
            Iterator<Map.Entry> iterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
            while (iterator.hasNext()) {
              Map.Entry entry = iterator.next();
              Object<?> object = (Object<?>)entry.getKey();
              object = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate((K)object));
              if (!object.isEmpty() && param2Object.equals(object)) {
                if (object.size() == ((Collection)entry.getValue()).size()) {
                  iterator.remove();
                } else {
                  object.clear();
                } 
                return true;
              } 
            } 
          } 
          return false;
        }
        
        public boolean removeAll(Collection<?> param2Collection) {
          return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(param2Collection)));
        }
        
        public boolean retainAll(Collection<?> param2Collection) {
          return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(param2Collection))));
        }
      };
      return new ValuesImpl();
    }
    
    public Collection<V> get(@Nullable Object<?> param1Object) {
      Collection<?> collection = (Collection)FilteredEntryMultimap.this.unfiltered.asMap().get(param1Object);
      if (collection == null)
        return null; 
      collection = FilteredEntryMultimap.filterCollection(collection, new FilteredEntryMultimap.ValuePredicate((K)param1Object));
      param1Object = (Object<?>)collection;
      if (collection.isEmpty())
        param1Object = null; 
      return (Collection)param1Object;
    }
    
    public Collection<V> remove(@Nullable Object param1Object) {
      Collection collection = (Collection)FilteredEntryMultimap.this.unfiltered.asMap().get(param1Object);
      if (collection == null)
        return null; 
      ArrayList<?> arrayList = Lists.newArrayList();
      Iterator<Collection> iterator = collection.iterator();
      while (iterator.hasNext()) {
        collection = iterator.next();
        if (FilteredEntryMultimap.this.satisfies((K)param1Object, (V)collection)) {
          iterator.remove();
          arrayList.add(collection);
        } 
      } 
      return (Collection<V>)(arrayList.isEmpty() ? null : ((FilteredEntryMultimap.this.unfiltered instanceof SetMultimap) ? Collections.unmodifiableSet(Sets.newLinkedHashSet((Iterable)arrayList)) : Collections.unmodifiableList((List)arrayList)));
    }
  }
  
  class EntrySetImpl extends Maps.EntrySet<K, Collection<V>> {
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return new AbstractIterator<Map.Entry<K, Collection<V>>>() {
          final Iterator<Map.Entry<K, Collection<V>>> backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
          
          protected Map.Entry<K, Collection<V>> computeNext() {
            while (this.backingIterator.hasNext()) {
              Map.Entry entry = this.backingIterator.next();
              Object object = entry.getKey();
              Collection<?> collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate((K)object));
              if (!collection.isEmpty())
                return (Map.Entry)Maps.immutableEntry((K)object, collection); 
            } 
            return endOfData();
          }
        };
    }
    
    Map<K, Collection<V>> map() {
      return this.this$1;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return FilteredEntryMultimap.this.removeEntriesIf(Predicates.in(param1Collection));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return FilteredEntryMultimap.this.removeEntriesIf(Predicates.not(Predicates.in(param1Collection)));
    }
    
    public int size() {
      return Iterators.size(iterator());
    }
  }
  
  class null extends AbstractIterator<Map.Entry<K, Collection<V>>> {
    final Iterator<Map.Entry<K, Collection<V>>> backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
    
    protected Map.Entry<K, Collection<V>> computeNext() {
      while (this.backingIterator.hasNext()) {
        Map.Entry entry = this.backingIterator.next();
        Object object = entry.getKey();
        Collection<?> collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate((K)object));
        if (!collection.isEmpty())
          return (Map.Entry)Maps.immutableEntry((K)object, collection); 
      } 
      return endOfData();
    }
  }
  
  class KeySetImpl extends Maps.KeySet<K, Collection<V>> {
    KeySetImpl() {
      super((Map<K, Collection<V>>)FilteredEntryMultimap.this);
    }
    
    public boolean remove(@Nullable Object param1Object) {
      boolean bool;
      if (this.this$1.remove(param1Object) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(param1Collection)));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(param1Collection))));
    }
  }
  
  class ValuesImpl extends Maps.Values<K, Collection<V>> {
    ValuesImpl() {
      super((Map<K, Collection<V>>)FilteredEntryMultimap.this);
    }
    
    public boolean remove(@Nullable Object param1Object) {
      if (param1Object instanceof Collection) {
        param1Object = param1Object;
        Iterator<Map.Entry> iterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
        while (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          Object<?> object = (Object<?>)entry.getKey();
          object = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate((K)object));
          if (!object.isEmpty() && param1Object.equals(object)) {
            if (object.size() == ((Collection)entry.getValue()).size()) {
              iterator.remove();
            } else {
              object.clear();
            } 
            return true;
          } 
        } 
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(param1Collection)));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(param1Collection))));
    }
  }
  
  class Keys extends Multimaps.Keys<K, V> {
    Keys() {
      super(FilteredEntryMultimap.this);
    }
    
    public Set<Multiset.Entry<K>> entrySet() {
      return new Multisets.EntrySet<K>() {
          private boolean removeEntriesIf(final Predicate<? super Multiset.Entry<K>> predicate) {
            return FilteredEntryMultimap.this.removeEntriesIf(new Predicate<Map.Entry<K, Collection<V>>>() {
                  public boolean apply(Map.Entry<K, Collection<V>> param3Entry) {
                    return predicate.apply(Multisets.immutableEntry(param3Entry.getKey(), ((Collection)param3Entry.getValue()).size()));
                  }
                });
          }
          
          public Iterator<Multiset.Entry<K>> iterator() {
            return FilteredEntryMultimap.Keys.this.entryIterator();
          }
          
          Multiset<K> multiset() {
            return FilteredEntryMultimap.Keys.this;
          }
          
          public boolean removeAll(Collection<?> param2Collection) {
            return removeEntriesIf(Predicates.in(param2Collection));
          }
          
          public boolean retainAll(Collection<?> param2Collection) {
            return removeEntriesIf(Predicates.not(Predicates.in(param2Collection)));
          }
          
          public int size() {
            return FilteredEntryMultimap.this.keySet().size();
          }
        };
    }
    
    public int remove(@Nullable Object param1Object, int param1Int) {
      CollectPreconditions.checkNonnegative(param1Int, "occurrences");
      if (param1Int == 0)
        return count(param1Object); 
      Collection collection = (Collection)FilteredEntryMultimap.this.unfiltered.asMap().get(param1Object);
      int i = 0;
      if (collection == null)
        return 0; 
      Iterator<Object> iterator = collection.iterator();
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (FilteredEntryMultimap.this.satisfies((K)param1Object, (V)object)) {
          int j = i + 1;
          i = j;
          if (j <= param1Int) {
            iterator.remove();
            i = j;
          } 
        } 
      } 
      return i;
    }
  }
  
  class null extends Multisets.EntrySet<K> {
    private boolean removeEntriesIf(final Predicate<? super Multiset.Entry<K>> predicate) {
      return FilteredEntryMultimap.this.removeEntriesIf(new Predicate<Map.Entry<K, Collection<V>>>() {
            public boolean apply(Map.Entry<K, Collection<V>> param3Entry) {
              return predicate.apply(Multisets.immutableEntry(param3Entry.getKey(), ((Collection)param3Entry.getValue()).size()));
            }
          });
    }
    
    public Iterator<Multiset.Entry<K>> iterator() {
      return this.this$1.entryIterator();
    }
    
    Multiset<K> multiset() {
      return this.this$1;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return removeEntriesIf(Predicates.in(param1Collection));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return removeEntriesIf(Predicates.not(Predicates.in(param1Collection)));
    }
    
    public int size() {
      return FilteredEntryMultimap.this.keySet().size();
    }
  }
  
  class null implements Predicate<Map.Entry<K, Collection<V>>> {
    public boolean apply(Map.Entry<K, Collection<V>> param1Entry) {
      return predicate.apply(Multisets.immutableEntry(param1Entry.getKey(), ((Collection)param1Entry.getValue()).size()));
    }
  }
  
  final class ValuePredicate implements Predicate<V> {
    private final K key;
    
    ValuePredicate(K param1K) {
      this.key = param1K;
    }
    
    public boolean apply(@Nullable V param1V) {
      return FilteredEntryMultimap.this.satisfies(this.key, param1V);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\FilteredEntryMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */