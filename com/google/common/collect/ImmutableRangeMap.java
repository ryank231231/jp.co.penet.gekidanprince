package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
  private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
  
  private static final long serialVersionUID = 0L;
  
  private final transient ImmutableList<Range<K>> ranges;
  
  private final transient ImmutableList<V> values;
  
  ImmutableRangeMap(ImmutableList<Range<K>> paramImmutableList, ImmutableList<V> paramImmutableList1) {
    this.ranges = paramImmutableList;
    this.values = paramImmutableList1;
  }
  
  public static <K extends Comparable<?>, V> Builder<K, V> builder() {
    return new Builder<K, V>();
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> paramRangeMap) {
    if (paramRangeMap instanceof ImmutableRangeMap)
      return (ImmutableRangeMap)paramRangeMap; 
    Map<Range<K>, ? extends V> map = paramRangeMap.asMapOfRanges();
    ImmutableList.Builder<Range<K>> builder1 = new ImmutableList.Builder(map.size());
    ImmutableList.Builder<V> builder = new ImmutableList.Builder(map.size());
    for (Map.Entry<Range<K>, ? extends V> entry : map.entrySet()) {
      builder1.add(entry.getKey());
      builder.add(entry.getValue());
    } 
    return new ImmutableRangeMap<K, V>(builder1.build(), builder.build());
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
    return (ImmutableRangeMap)EMPTY;
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> paramRange, V paramV) {
    return new ImmutableRangeMap<K, V>(ImmutableList.of(paramRange), ImmutableList.of(paramV));
  }
  
  public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
    return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap<Range<K>, V>(new RegularImmutableSortedSet<Range<K>>(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse()), this.values.reverse());
  }
  
  public ImmutableMap<Range<K>, V> asMapOfRanges() {
    return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap<Range<K>, V>((RegularImmutableSortedSet)new RegularImmutableSortedSet<Range<?>>(this.ranges, Range.RANGE_LEX_ORDERING), this.values);
  }
  
  @Deprecated
  public void clear() {
    throw new UnsupportedOperationException();
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
    int i = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), Cut.belowValue(paramK), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    V v = null;
    if (i == -1)
      return null; 
    if (((Range<K>)this.ranges.get(i)).contains(paramK))
      v = this.values.get(i); 
    return v;
  }
  
  @Nullable
  public Map.Entry<Range<K>, V> getEntry(K paramK) {
    int i = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), Cut.belowValue(paramK), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    Map.Entry<Range<K>, ?> entry = null;
    if (i == -1)
      return null; 
    Range<K> range = this.ranges.get(i);
    if (range.contains(paramK))
      entry = Maps.immutableEntry(range, this.values.get(i)); 
    return (Map.Entry)entry;
  }
  
  public int hashCode() {
    return asMapOfRanges().hashCode();
  }
  
  @Deprecated
  public void put(Range<K> paramRange, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void putAll(RangeMap<K, V> paramRangeMap) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void remove(Range<K> paramRange) {
    throw new UnsupportedOperationException();
  }
  
  public Range<K> span() {
    if (!this.ranges.isEmpty()) {
      Range range1 = this.ranges.get(0);
      ImmutableList<Range<K>> immutableList = this.ranges;
      Range range2 = immutableList.get(immutableList.size() - 1);
      return Range.create(range1.lowerBound, range2.upperBound);
    } 
    throw new NoSuchElementException();
  }
  
  public ImmutableRangeMap<K, V> subRangeMap(final Range<K> range) {
    if (((Range)Preconditions.checkNotNull(range)).isEmpty())
      return of(); 
    if (this.ranges.isEmpty() || range.encloses(span()))
      return this; 
    final int off = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    int j = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    return (i >= j) ? of() : new ImmutableRangeMap<K, V>(new ImmutableList<Range<K>>() {
          public Range<K> get(int param1Int) {
            Preconditions.checkElementIndex(param1Int, len);
            return (param1Int == 0 || param1Int == len - 1) ? ((Range<K>)ImmutableRangeMap.this.ranges.get(param1Int + off)).intersection(range) : ImmutableRangeMap.this.ranges.get(param1Int + off);
          }
          
          boolean isPartialView() {
            return true;
          }
          
          public int size() {
            return len;
          }
        }this.values.subList(i, j)) {
        public ImmutableRangeMap<K, V> subRangeMap(Range<K> param1Range) {
          return range.isConnected(param1Range) ? outer.subRangeMap(param1Range.intersection(range)) : ImmutableRangeMap.of();
        }
      };
  }
  
  public String toString() {
    return asMapOfRanges().toString();
  }
  
  Object writeReplace() {
    return new SerializedForm<K, V>(asMapOfRanges());
  }
  
  public static final class Builder<K extends Comparable<?>, V> {
    private final RangeSet<K> keyRanges = TreeRangeSet.create();
    
    private final RangeMap<K, V> rangeMap = (RangeMap)TreeRangeMap.create();
    
    public ImmutableRangeMap<K, V> build() {
      Map<Range<K>, V> map = this.rangeMap.asMapOfRanges();
      ImmutableList.Builder<Range<K>> builder = new ImmutableList.Builder(map.size());
      ImmutableList.Builder<V> builder1 = new ImmutableList.Builder(map.size());
      for (Map.Entry<Range<K>, V> entry : map.entrySet()) {
        builder.add(entry.getKey());
        builder1.add(entry.getValue());
      } 
      return new ImmutableRangeMap<K, V>(builder.build(), builder1.build());
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(Range<K> param1Range, V param1V) {
      StringBuilder stringBuilder;
      Preconditions.checkNotNull(param1Range);
      Preconditions.checkNotNull(param1V);
      Preconditions.checkArgument(param1Range.isEmpty() ^ true, "Range must not be empty, but was %s", param1Range);
      if (!this.keyRanges.complement().encloses(param1Range))
        for (Map.Entry entry : this.rangeMap.asMapOfRanges().entrySet()) {
          Range<K> range = (Range)entry.getKey();
          if (!range.isConnected(param1Range) || range.intersection(param1Range).isEmpty())
            continue; 
          stringBuilder = new StringBuilder();
          stringBuilder.append("Overlapping ranges: range ");
          stringBuilder.append(param1Range);
          stringBuilder.append(" overlaps with entry ");
          stringBuilder.append(entry);
          throw new IllegalArgumentException(stringBuilder.toString());
        }  
      this.keyRanges.add(param1Range);
      this.rangeMap.put(param1Range, (V)stringBuilder);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(RangeMap<K, ? extends V> param1RangeMap) {
      for (Map.Entry entry : param1RangeMap.asMapOfRanges().entrySet())
        put((Range<K>)entry.getKey(), (V)entry.getValue()); 
      return this;
    }
  }
  
  private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final ImmutableMap<Range<K>, V> mapOfRanges;
    
    SerializedForm(ImmutableMap<Range<K>, V> param1ImmutableMap) {
      this.mapOfRanges = param1ImmutableMap;
    }
    
    Object createRangeMap() {
      ImmutableRangeMap.Builder<Comparable<?>, Object> builder = new ImmutableRangeMap.Builder<Comparable<?>, Object>();
      for (Map.Entry<Range<K>, V> entry : this.mapOfRanges.entrySet())
        builder.put((Range<Comparable<?>>)entry.getKey(), entry.getValue()); 
      return builder.build();
    }
    
    Object readResolve() {
      return this.mapOfRanges.isEmpty() ? ImmutableRangeMap.of() : createRangeMap();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableRangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */