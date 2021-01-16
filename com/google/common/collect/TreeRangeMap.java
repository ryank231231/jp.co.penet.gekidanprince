package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
  private static final RangeMap EMPTY_SUB_RANGE_MAP = new RangeMap<Comparable, Object>() {
      public Map<Range, Object> asDescendingMapOfRanges() {
        return Collections.emptyMap();
      }
      
      public Map<Range, Object> asMapOfRanges() {
        return Collections.emptyMap();
      }
      
      public void clear() {}
      
      @Nullable
      public Object get(Comparable param1Comparable) {
        return null;
      }
      
      @Nullable
      public Map.Entry<Range, Object> getEntry(Comparable param1Comparable) {
        return null;
      }
      
      public void put(Range param1Range, Object param1Object) {
        Preconditions.checkNotNull(param1Range);
        param1Object = new StringBuilder();
        param1Object.append("Cannot insert range ");
        param1Object.append(param1Range);
        param1Object.append(" into an empty subRangeMap");
        throw new IllegalArgumentException(param1Object.toString());
      }
      
      public void putAll(RangeMap param1RangeMap) {
        if (param1RangeMap.asMapOfRanges().isEmpty())
          return; 
        throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
      }
      
      public void remove(Range param1Range) {
        Preconditions.checkNotNull(param1Range);
      }
      
      public Range span() {
        throw new NoSuchElementException();
      }
      
      public RangeMap subRangeMap(Range param1Range) {
        Preconditions.checkNotNull(param1Range);
        return this;
      }
    };
  
  private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound = Maps.newTreeMap();
  
  public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
    return new TreeRangeMap<K, V>();
  }
  
  private RangeMap<K, V> emptySubRangeMap() {
    return EMPTY_SUB_RANGE_MAP;
  }
  
  private void putRangeMapEntry(Cut<K> paramCut1, Cut<K> paramCut2, V paramV) {
    this.entriesByLowerBound.put(paramCut1, new RangeMapEntry<K, V>(paramCut1, paramCut2, paramV));
  }
  
  public Map<Range<K>, V> asDescendingMapOfRanges() {
    return new AsMapOfRanges(this.entriesByLowerBound.descendingMap().values());
  }
  
  public Map<Range<K>, V> asMapOfRanges() {
    return new AsMapOfRanges(this.entriesByLowerBound.values());
  }
  
  public void clear() {
    this.entriesByLowerBound.clear();
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject instanceof RangeMap) {
      paramObject = paramObject;
      return asMapOfRanges().equals(paramObject.asMapOfRanges());
    } 
    return false;
  }
  
  @Nullable
  public V get(K paramK) {
    Map.Entry<Range<K>, V> entry = getEntry(paramK);
    if (entry == null) {
      entry = null;
    } else {
      entry = (Map.Entry<Range<K>, V>)entry.getValue();
    } 
    return (V)entry;
  }
  
  @Nullable
  public Map.Entry<Range<K>, V> getEntry(K paramK) {
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry = this.entriesByLowerBound.floorEntry(Cut.belowValue(paramK));
    return (entry != null && ((RangeMapEntry)entry.getValue()).contains(paramK)) ? entry.getValue() : null;
  }
  
  public int hashCode() {
    return asMapOfRanges().hashCode();
  }
  
  public void put(Range<K> paramRange, V paramV) {
    if (!paramRange.isEmpty()) {
      Preconditions.checkNotNull(paramV);
      remove(paramRange);
      this.entriesByLowerBound.put(paramRange.lowerBound, new RangeMapEntry<K, V>(paramRange, paramV));
    } 
  }
  
  public void putAll(RangeMap<K, V> paramRangeMap) {
    for (Map.Entry entry : paramRangeMap.asMapOfRanges().entrySet())
      put((Range<K>)entry.getKey(), (V)entry.getValue()); 
  }
  
  public void remove(Range<K> paramRange) {
    if (paramRange.isEmpty())
      return; 
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry1 = this.entriesByLowerBound.lowerEntry(paramRange.lowerBound);
    if (entry1 != null) {
      RangeMapEntry rangeMapEntry = entry1.getValue();
      if (rangeMapEntry.getUpperBound().compareTo(paramRange.lowerBound) > 0) {
        if (rangeMapEntry.getUpperBound().compareTo(paramRange.upperBound) > 0)
          putRangeMapEntry(paramRange.upperBound, rangeMapEntry.getUpperBound(), (V)((RangeMapEntry)entry1.getValue()).getValue()); 
        putRangeMapEntry(rangeMapEntry.getLowerBound(), paramRange.lowerBound, (V)((RangeMapEntry)entry1.getValue()).getValue());
      } 
    } 
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry2 = this.entriesByLowerBound.lowerEntry(paramRange.upperBound);
    if (entry2 != null) {
      entry1 = (RangeMapEntry)entry2.getValue();
      if (entry1.getUpperBound().compareTo(paramRange.upperBound) > 0) {
        putRangeMapEntry(paramRange.upperBound, (Cut)entry1.getUpperBound(), (V)((RangeMapEntry)entry2.getValue()).getValue());
        this.entriesByLowerBound.remove(paramRange.lowerBound);
      } 
    } 
    this.entriesByLowerBound.subMap(paramRange.lowerBound, paramRange.upperBound).clear();
  }
  
  public Range<K> span() {
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry1 = this.entriesByLowerBound.firstEntry();
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry2 = this.entriesByLowerBound.lastEntry();
    if (entry1 != null)
      return Range.create((((RangeMapEntry)entry1.getValue()).getKey()).lowerBound, (((RangeMapEntry)entry2.getValue()).getKey()).upperBound); 
    throw new NoSuchElementException();
  }
  
  public RangeMap<K, V> subRangeMap(Range<K> paramRange) {
    return (RangeMap<K, V>)(paramRange.equals(Range.all()) ? this : new SubRangeMap(paramRange));
  }
  
  public String toString() {
    return this.entriesByLowerBound.values().toString();
  }
  
  private final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {
    final Iterable<Map.Entry<Range<K>, V>> entryIterable;
    
    AsMapOfRanges(Iterable<TreeRangeMap.RangeMapEntry<K, V>> param1Iterable) {
      this.entryIterable = (Iterable)param1Iterable;
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
    
    Iterator<Map.Entry<Range<K>, V>> entryIterator() {
      return this.entryIterable.iterator();
    }
    
    public V get(@Nullable Object param1Object) {
      if (param1Object instanceof Range) {
        Range range = (Range)param1Object;
        param1Object = TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
        if (param1Object != null && param1Object.getKey().equals(range))
          return (V)param1Object.getValue(); 
      } 
      return null;
    }
    
    public int size() {
      return TreeRangeMap.this.entriesByLowerBound.size();
    }
  }
  
  private static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
    private final Range<K> range;
    
    private final V value;
    
    RangeMapEntry(Cut<K> param1Cut1, Cut<K> param1Cut2, V param1V) {
      this(Range.create(param1Cut1, param1Cut2), param1V);
    }
    
    RangeMapEntry(Range<K> param1Range, V param1V) {
      this.range = param1Range;
      this.value = param1V;
    }
    
    public boolean contains(K param1K) {
      return this.range.contains(param1K);
    }
    
    public Range<K> getKey() {
      return this.range;
    }
    
    Cut<K> getLowerBound() {
      return this.range.lowerBound;
    }
    
    Cut<K> getUpperBound() {
      return this.range.upperBound;
    }
    
    public V getValue() {
      return this.value;
    }
  }
  
  private class SubRangeMap implements RangeMap<K, V> {
    private final Range<K> subRange;
    
    SubRangeMap(Range<K> param1Range) {
      this.subRange = param1Range;
    }
    
    public Map<Range<K>, V> asDescendingMapOfRanges() {
      return new SubRangeMapAsMap() {
          Iterator<Map.Entry<Range<K>, V>> entryIterator() {
            return TreeRangeMap.SubRangeMap.this.subRange.isEmpty() ? Iterators.emptyIterator() : new AbstractIterator<Map.Entry<Range<K>, V>>() {
                protected Map.Entry<Range<K>, V> computeNext() {
                  if (backingItr.hasNext()) {
                    TreeRangeMap.RangeMapEntry rangeMapEntry = backingItr.next();
                    return (rangeMapEntry.getUpperBound().compareTo(TreeRangeMap.SubRangeMap.this.subRange.lowerBound) <= 0) ? endOfData() : Maps.immutableEntry(rangeMapEntry.getKey().intersection(TreeRangeMap.SubRangeMap.this.subRange), (V)rangeMapEntry.getValue());
                  } 
                  return endOfData();
                }
              };
          }
        };
    }
    
    public Map<Range<K>, V> asMapOfRanges() {
      return new SubRangeMapAsMap();
    }
    
    public void clear() {
      TreeRangeMap.this.remove(this.subRange);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof RangeMap) {
        param1Object = param1Object;
        return asMapOfRanges().equals(param1Object.asMapOfRanges());
      } 
      return false;
    }
    
    @Nullable
    public V get(K param1K) {
      if (this.subRange.contains(param1K)) {
        param1K = (K)TreeRangeMap.this.get(param1K);
      } else {
        param1K = null;
      } 
      return (V)param1K;
    }
    
    @Nullable
    public Map.Entry<Range<K>, V> getEntry(K param1K) {
      if (this.subRange.contains(param1K)) {
        Map.Entry entry = TreeRangeMap.this.getEntry(param1K);
        if (entry != null)
          return Maps.immutableEntry(((Range<K>)entry.getKey()).intersection(this.subRange), (V)entry.getValue()); 
      } 
      return null;
    }
    
    public int hashCode() {
      return asMapOfRanges().hashCode();
    }
    
    public void put(Range<K> param1Range, V param1V) {
      Preconditions.checkArgument(this.subRange.encloses(param1Range), "Cannot put range %s into a subRangeMap(%s)", param1Range, this.subRange);
      TreeRangeMap.this.put(param1Range, param1V);
    }
    
    public void putAll(RangeMap<K, V> param1RangeMap) {
      if (param1RangeMap.asMapOfRanges().isEmpty())
        return; 
      Range<K> range = param1RangeMap.span();
      Preconditions.checkArgument(this.subRange.encloses(range), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", range, this.subRange);
      TreeRangeMap.this.putAll(param1RangeMap);
    }
    
    public void remove(Range<K> param1Range) {
      if (param1Range.isConnected(this.subRange))
        TreeRangeMap.this.remove(param1Range.intersection(this.subRange)); 
    }
    
    public Range<K> span() {
      Cut<K> cut;
      Map.Entry entry1 = TreeRangeMap.this.entriesByLowerBound.floorEntry(this.subRange.lowerBound);
      if (entry1 != null && ((TreeRangeMap.RangeMapEntry)entry1.getValue()).getUpperBound().compareTo(this.subRange.lowerBound) > 0) {
        cut = this.subRange.lowerBound;
      } else {
        cut = (Cut)TreeRangeMap.this.entriesByLowerBound.ceilingKey(this.subRange.lowerBound);
        if (cut == null || cut.compareTo(this.subRange.upperBound) >= 0)
          throw new NoSuchElementException(); 
      } 
      Map.Entry entry2 = TreeRangeMap.this.entriesByLowerBound.lowerEntry(this.subRange.upperBound);
      if (entry2 != null) {
        Cut<K> cut1;
        if (((TreeRangeMap.RangeMapEntry)entry2.getValue()).getUpperBound().compareTo(this.subRange.upperBound) >= 0) {
          cut1 = this.subRange.upperBound;
        } else {
          cut1 = ((TreeRangeMap.RangeMapEntry)cut1.getValue()).getUpperBound();
        } 
        return Range.create(cut, cut1);
      } 
      throw new NoSuchElementException();
    }
    
    public RangeMap<K, V> subRangeMap(Range<K> param1Range) {
      return !param1Range.isConnected(this.subRange) ? TreeRangeMap.this.emptySubRangeMap() : TreeRangeMap.this.subRangeMap(param1Range.intersection(this.subRange));
    }
    
    public String toString() {
      return asMapOfRanges().toString();
    }
    
    class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
      private boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> param2Predicate) {
        ArrayList<?> arrayList = Lists.newArrayList();
        for (Map.Entry<Range<K>, V> entry : entrySet()) {
          if (param2Predicate.apply(entry))
            arrayList.add(entry.getKey()); 
        } 
        for (Predicate<? super Map.Entry<Range<K>, V>> param2Predicate : arrayList)
          TreeRangeMap.this.remove((Range)param2Predicate); 
        return arrayList.isEmpty() ^ true;
      }
      
      public void clear() {
        TreeRangeMap.SubRangeMap.this.clear();
      }
      
      public boolean containsKey(Object param2Object) {
        boolean bool;
        if (get(param2Object) != null) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      Iterator<Map.Entry<Range<K>, V>> entryIterator() {
        if (TreeRangeMap.SubRangeMap.this.subRange.isEmpty())
          return Iterators.emptyIterator(); 
        Cut cut = (Cut)MoreObjects.firstNonNull(TreeRangeMap.this.entriesByLowerBound.floorKey(TreeRangeMap.SubRangeMap.this.subRange.lowerBound), TreeRangeMap.SubRangeMap.this.subRange.lowerBound);
        return new AbstractIterator<Map.Entry<Range<K>, V>>() {
            protected Map.Entry<Range<K>, V> computeNext() {
              while (backingItr.hasNext()) {
                TreeRangeMap.RangeMapEntry rangeMapEntry = backingItr.next();
                if (rangeMapEntry.getLowerBound().compareTo(TreeRangeMap.SubRangeMap.this.subRange.upperBound) >= 0)
                  return endOfData(); 
                if (rangeMapEntry.getUpperBound().compareTo(TreeRangeMap.SubRangeMap.this.subRange.lowerBound) > 0)
                  return Maps.immutableEntry(rangeMapEntry.getKey().intersection(TreeRangeMap.SubRangeMap.this.subRange), (V)rangeMapEntry.getValue()); 
              } 
              return endOfData();
            }
          };
      }
      
      public Set<Map.Entry<Range<K>, V>> entrySet() {
        return (Set)new Maps.EntrySet<Range<Range<K>>, V>() {
            public boolean isEmpty() {
              return iterator().hasNext() ^ true;
            }
            
            public Iterator<Map.Entry<Range<K>, V>> iterator() {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.entryIterator();
            }
            
            Map<Range<K>, V> map() {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this;
            }
            
            public boolean retainAll(Collection<?> param3Collection) {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.not(Predicates.in(param3Collection)));
            }
            
            public int size() {
              return Iterators.size(iterator());
            }
          };
      }
      
      public V get(Object param2Object) {
        try {
          if (param2Object instanceof Range) {
            Range range = (Range)param2Object;
            if (!TreeRangeMap.SubRangeMap.this.subRange.encloses(range) || range.isEmpty())
              return null; 
            if (range.lowerBound.compareTo(TreeRangeMap.SubRangeMap.this.subRange.lowerBound) == 0) {
              param2Object = TreeRangeMap.this.entriesByLowerBound.floorEntry(range.lowerBound);
              if (param2Object != null) {
                param2Object = param2Object.getValue();
              } else {
                param2Object = null;
              } 
            } else {
              param2Object = TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
            } 
            if (param2Object != null && param2Object.getKey().isConnected(TreeRangeMap.SubRangeMap.this.subRange) && param2Object.getKey().intersection(TreeRangeMap.SubRangeMap.this.subRange).equals(range))
              return (V)param2Object.getValue(); 
          } 
          return null;
        } catch (ClassCastException classCastException) {
          return null;
        } 
      }
      
      public Set<Range<K>> keySet() {
        return (Set)new Maps.KeySet<Range<Range<K>>, V>(this) {
            public boolean remove(@Nullable Object param3Object) {
              boolean bool;
              if (TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.remove(param3Object) != null) {
                bool = true;
              } else {
                bool = false;
              } 
              return bool;
            }
            
            public boolean retainAll(Collection<?> param3Collection) {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(param3Collection)), Maps.keyFunction()));
            }
          };
      }
      
      public V remove(Object param2Object) {
        V v = get(param2Object);
        if (v != null) {
          param2Object = param2Object;
          TreeRangeMap.this.remove((Range)param2Object);
          return v;
        } 
        return null;
      }
      
      public Collection<V> values() {
        return new Maps.Values<Range<Range<K>>, V>(this) {
            public boolean removeAll(Collection<?> param3Collection) {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.in(param3Collection), Maps.valueFunction()));
            }
            
            public boolean retainAll(Collection<?> param3Collection) {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(param3Collection)), Maps.valueFunction()));
            }
          };
      }
    }
    
    class null extends Maps.KeySet<Range<K>, V> {
      null(Map<Range<K>, V> param2Map) {
        super(param2Map);
      }
      
      public boolean remove(@Nullable Object param2Object) {
        boolean bool;
        if (this.this$2.remove(param2Object) != null) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return this.this$2.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(param2Collection)), Maps.keyFunction()));
      }
    }
    
    class null extends Maps.EntrySet<Range<K>, V> {
      public boolean isEmpty() {
        return iterator().hasNext() ^ true;
      }
      
      public Iterator<Map.Entry<Range<K>, V>> iterator() {
        return this.this$2.entryIterator();
      }
      
      Map<Range<K>, V> map() {
        return this.this$2;
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return this.this$2.removeEntryIf(Predicates.not(Predicates.in(param2Collection)));
      }
      
      public int size() {
        return Iterators.size(iterator());
      }
    }
    
    class null extends AbstractIterator<Map.Entry<Range<K>, V>> {
      protected Map.Entry<Range<K>, V> computeNext() {
        while (backingItr.hasNext()) {
          TreeRangeMap.RangeMapEntry rangeMapEntry = backingItr.next();
          if (rangeMapEntry.getLowerBound().compareTo(TreeRangeMap.SubRangeMap.this.subRange.upperBound) >= 0)
            return endOfData(); 
          if (rangeMapEntry.getUpperBound().compareTo(TreeRangeMap.SubRangeMap.this.subRange.lowerBound) > 0)
            return Maps.immutableEntry(rangeMapEntry.getKey().intersection(TreeRangeMap.SubRangeMap.this.subRange), (V)rangeMapEntry.getValue()); 
        } 
        return endOfData();
      }
    }
    
    class null extends Maps.Values<Range<K>, V> {
      null(Map<Range<K>, V> param2Map) {
        super(param2Map);
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        return this.this$2.removeEntryIf(Predicates.compose(Predicates.in(param2Collection), Maps.valueFunction()));
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return this.this$2.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(param2Collection)), Maps.valueFunction()));
      }
    }
  }
  
  class null extends SubRangeMap.SubRangeMapAsMap {
    null() {
      super((TreeRangeMap.SubRangeMap)TreeRangeMap.this);
    }
    
    Iterator<Map.Entry<Range<K>, V>> entryIterator() {
      return this.this$1.subRange.isEmpty() ? Iterators.emptyIterator() : new AbstractIterator<Map.Entry<Range<K>, V>>() {
          protected Map.Entry<Range<K>, V> computeNext() {
            if (backingItr.hasNext()) {
              TreeRangeMap.RangeMapEntry rangeMapEntry = backingItr.next();
              return (rangeMapEntry.getUpperBound().compareTo(this.this$2.this$1.subRange.lowerBound) <= 0) ? endOfData() : Maps.immutableEntry(rangeMapEntry.getKey().intersection(this.this$2.this$1.subRange), (V)rangeMapEntry.getValue());
            } 
            return endOfData();
          }
        };
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Range<K>, V>> {
    protected Map.Entry<Range<K>, V> computeNext() {
      if (backingItr.hasNext()) {
        TreeRangeMap.RangeMapEntry rangeMapEntry = backingItr.next();
        return (rangeMapEntry.getUpperBound().compareTo(this.this$2.this$1.subRange.lowerBound) <= 0) ? endOfData() : Maps.immutableEntry(rangeMapEntry.getKey().intersection(this.this$2.this$1.subRange), (V)rangeMapEntry.getValue());
      } 
      return endOfData();
    }
  }
  
  class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
    private boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> param1Predicate) {
      ArrayList<?> arrayList = Lists.newArrayList();
      for (Map.Entry<Range<K>, V> entry : entrySet()) {
        if (param1Predicate.apply(entry))
          arrayList.add(entry.getKey()); 
      } 
      for (Predicate<? super Map.Entry<Range<K>, V>> param1Predicate : arrayList)
        TreeRangeMap.this.remove((Range)param1Predicate); 
      return arrayList.isEmpty() ^ true;
    }
    
    public void clear() {
      this.this$1.clear();
    }
    
    public boolean containsKey(Object param1Object) {
      boolean bool;
      if (get(param1Object) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    Iterator<Map.Entry<Range<K>, V>> entryIterator() {
      if (this.this$1.subRange.isEmpty())
        return Iterators.emptyIterator(); 
      Cut cut = (Cut)MoreObjects.firstNonNull(TreeRangeMap.this.entriesByLowerBound.floorKey(this.this$1.subRange.lowerBound), this.this$1.subRange.lowerBound);
      return new AbstractIterator<Map.Entry<Range<K>, V>>() {
          protected Map.Entry<Range<K>, V> computeNext() {
            while (backingItr.hasNext()) {
              TreeRangeMap.RangeMapEntry rangeMapEntry = backingItr.next();
              if (rangeMapEntry.getLowerBound().compareTo(this.this$2.this$1.subRange.upperBound) >= 0)
                return endOfData(); 
              if (rangeMapEntry.getUpperBound().compareTo(this.this$2.this$1.subRange.lowerBound) > 0)
                return Maps.immutableEntry(rangeMapEntry.getKey().intersection(this.this$2.this$1.subRange), (V)rangeMapEntry.getValue()); 
            } 
            return endOfData();
          }
        };
    }
    
    public Set<Map.Entry<Range<K>, V>> entrySet() {
      return (Set)new Maps.EntrySet<Range<Range<K>>, V>() {
          public boolean isEmpty() {
            return iterator().hasNext() ^ true;
          }
          
          public Iterator<Map.Entry<Range<K>, V>> iterator() {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.entryIterator();
          }
          
          Map<Range<K>, V> map() {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this;
          }
          
          public boolean retainAll(Collection<?> param3Collection) {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.not(Predicates.in(param3Collection)));
          }
          
          public int size() {
            return Iterators.size(iterator());
          }
        };
    }
    
    public V get(Object param1Object) {
      try {
        if (param1Object instanceof Range) {
          Range range = (Range)param1Object;
          if (!this.this$1.subRange.encloses(range) || range.isEmpty())
            return null; 
          if (range.lowerBound.compareTo(this.this$1.subRange.lowerBound) == 0) {
            param1Object = TreeRangeMap.this.entriesByLowerBound.floorEntry(range.lowerBound);
            if (param1Object != null) {
              param1Object = param1Object.getValue();
            } else {
              param1Object = null;
            } 
          } else {
            param1Object = TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
          } 
          if (param1Object != null && param1Object.getKey().isConnected(this.this$1.subRange) && param1Object.getKey().intersection(this.this$1.subRange).equals(range))
            return (V)param1Object.getValue(); 
        } 
        return null;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    public Set<Range<K>> keySet() {
      return (Set)new Maps.KeySet<Range<Range<K>>, V>(this) {
          public boolean remove(@Nullable Object param3Object) {
            boolean bool;
            if (TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.remove(param3Object) != null) {
              bool = true;
            } else {
              bool = false;
            } 
            return bool;
          }
          
          public boolean retainAll(Collection<?> param3Collection) {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(param3Collection)), Maps.keyFunction()));
          }
        };
    }
    
    public V remove(Object param1Object) {
      V v = get(param1Object);
      if (v != null) {
        param1Object = param1Object;
        TreeRangeMap.this.remove((Range)param1Object);
        return v;
      } 
      return null;
    }
    
    public Collection<V> values() {
      return new Maps.Values<Range<Range<K>>, V>(this) {
          public boolean removeAll(Collection<?> param3Collection) {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.in(param3Collection), Maps.valueFunction()));
          }
          
          public boolean retainAll(Collection<?> param3Collection) {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(param3Collection)), Maps.valueFunction()));
          }
        };
    }
  }
  
  class null extends Maps.KeySet<Range<K>, V> {
    null(Map<Range<K>, V> param1Map) {
      super(param1Map);
    }
    
    public boolean remove(@Nullable Object param1Object) {
      boolean bool;
      if (this.this$2.remove(param1Object) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.this$2.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(param1Collection)), Maps.keyFunction()));
    }
  }
  
  class null extends Maps.EntrySet<Range<K>, V> {
    public boolean isEmpty() {
      return iterator().hasNext() ^ true;
    }
    
    public Iterator<Map.Entry<Range<K>, V>> iterator() {
      return this.this$2.entryIterator();
    }
    
    Map<Range<K>, V> map() {
      return this.this$2;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.this$2.removeEntryIf(Predicates.not(Predicates.in(param1Collection)));
    }
    
    public int size() {
      return Iterators.size(iterator());
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Range<K>, V>> {
    protected Map.Entry<Range<K>, V> computeNext() {
      while (backingItr.hasNext()) {
        TreeRangeMap.RangeMapEntry rangeMapEntry = backingItr.next();
        if (rangeMapEntry.getLowerBound().compareTo(this.this$2.this$1.subRange.upperBound) >= 0)
          return endOfData(); 
        if (rangeMapEntry.getUpperBound().compareTo(this.this$2.this$1.subRange.lowerBound) > 0)
          return Maps.immutableEntry(rangeMapEntry.getKey().intersection(this.this$2.this$1.subRange), (V)rangeMapEntry.getValue()); 
      } 
      return endOfData();
    }
  }
  
  class null extends Maps.Values<Range<K>, V> {
    null(Map<Range<K>, V> param1Map) {
      super(param1Map);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return this.this$2.removeEntryIf(Predicates.compose(Predicates.in(param1Collection), Maps.valueFunction()));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.this$2.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(param1Collection)), Maps.valueFunction()));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\TreeRangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */