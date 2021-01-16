package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {
  private transient Set<Range<C>> asDescendingSetOfRanges;
  
  private transient Set<Range<C>> asRanges;
  
  private transient RangeSet<C> complement;
  
  @VisibleForTesting
  final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
  
  private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> paramNavigableMap) {
    this.rangesByLowerBound = paramNavigableMap;
  }
  
  public static <C extends Comparable<?>> TreeRangeSet<C> create() {
    return new TreeRangeSet<C>(new TreeMap<Cut<C>, Range<C>>());
  }
  
  public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> paramRangeSet) {
    TreeRangeSet<Comparable<?>> treeRangeSet = create();
    treeRangeSet.addAll(paramRangeSet);
    return (TreeRangeSet)treeRangeSet;
  }
  
  @Nullable
  private Range<C> rangeEnclosing(Range<C> paramRange) {
    Preconditions.checkNotNull(paramRange);
    Map.Entry<Cut<C>, Range<C>> entry = this.rangesByLowerBound.floorEntry(paramRange.lowerBound);
    if (entry != null && ((Range)entry.getValue()).encloses(paramRange)) {
      paramRange = entry.getValue();
    } else {
      paramRange = null;
    } 
    return paramRange;
  }
  
  private void replaceRangeWithSameLowerBound(Range<C> paramRange) {
    if (paramRange.isEmpty()) {
      this.rangesByLowerBound.remove(paramRange.lowerBound);
    } else {
      this.rangesByLowerBound.put(paramRange.lowerBound, paramRange);
    } 
  }
  
  public void add(Range<C> paramRange) {
    Preconditions.checkNotNull(paramRange);
    if (paramRange.isEmpty())
      return; 
    Cut<C> cut2 = paramRange.lowerBound;
    Cut<C> cut3 = paramRange.upperBound;
    Map.Entry<Cut<C>, Range<C>> entry2 = this.rangesByLowerBound.lowerEntry(cut2);
    Cut<C> cut4 = cut2;
    Cut<C> cut1 = cut3;
    if (entry2 != null) {
      Range range = entry2.getValue();
      cut4 = cut2;
      cut1 = cut3;
      if (range.upperBound.compareTo(cut2) >= 0) {
        cut1 = cut3;
        if (range.upperBound.compareTo(cut3) >= 0)
          cut1 = range.upperBound; 
        cut4 = range.lowerBound;
      } 
    } 
    Map.Entry<Cut<C>, Range<C>> entry1 = this.rangesByLowerBound.floorEntry(cut1);
    cut3 = cut1;
    if (entry1 != null) {
      Range range = entry1.getValue();
      cut3 = cut1;
      if (range.upperBound.compareTo(cut1) >= 0)
        cut3 = range.upperBound; 
    } 
    this.rangesByLowerBound.subMap(cut4, cut3).clear();
    replaceRangeWithSameLowerBound(Range.create(cut4, cut3));
  }
  
  public Set<Range<C>> asDescendingSetOfRanges() {
    Set<Range<C>> set1 = this.asDescendingSetOfRanges;
    Set<Range<C>> set2 = set1;
    if (set1 == null) {
      set2 = new AsRanges(this.rangesByLowerBound.descendingMap().values());
      this.asDescendingSetOfRanges = set2;
    } 
    return set2;
  }
  
  public Set<Range<C>> asRanges() {
    Set<Range<C>> set1 = this.asRanges;
    Set<Range<C>> set2 = set1;
    if (set1 == null) {
      set2 = new AsRanges(this.rangesByLowerBound.values());
      this.asRanges = set2;
    } 
    return set2;
  }
  
  public RangeSet<C> complement() {
    RangeSet<C> rangeSet1 = this.complement;
    RangeSet<C> rangeSet2 = rangeSet1;
    if (rangeSet1 == null) {
      rangeSet2 = new Complement();
      this.complement = rangeSet2;
    } 
    return rangeSet2;
  }
  
  public boolean encloses(Range<C> paramRange) {
    boolean bool;
    Preconditions.checkNotNull(paramRange);
    Map.Entry<Cut<C>, Range<C>> entry = this.rangesByLowerBound.floorEntry(paramRange.lowerBound);
    if (entry != null && ((Range)entry.getValue()).encloses(paramRange)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean intersects(Range<C> paramRange) {
    Preconditions.checkNotNull(paramRange);
    Map.Entry<Cut<C>, Range<C>> entry = this.rangesByLowerBound.ceilingEntry(paramRange.lowerBound);
    boolean bool = true;
    if (entry != null && ((Range)entry.getValue()).isConnected(paramRange) && !((Range)entry.getValue()).intersection(paramRange).isEmpty())
      return true; 
    entry = this.rangesByLowerBound.lowerEntry(paramRange.lowerBound);
    if (entry == null || !((Range)entry.getValue()).isConnected(paramRange) || ((Range)entry.getValue()).intersection(paramRange).isEmpty())
      bool = false; 
    return bool;
  }
  
  @Nullable
  public Range<C> rangeContaining(C paramC) {
    Preconditions.checkNotNull(paramC);
    Map.Entry<Cut<C>, Range<C>> entry = this.rangesByLowerBound.floorEntry((Cut)Cut.belowValue((Comparable)paramC));
    return (entry != null && ((Range)entry.getValue()).contains(paramC)) ? entry.getValue() : null;
  }
  
  public void remove(Range<C> paramRange) {
    Preconditions.checkNotNull(paramRange);
    if (paramRange.isEmpty())
      return; 
    Map.Entry<Cut<C>, Range<C>> entry = this.rangesByLowerBound.lowerEntry(paramRange.lowerBound);
    if (entry != null) {
      Range range = entry.getValue();
      if (range.upperBound.compareTo(paramRange.lowerBound) >= 0) {
        if (paramRange.hasUpperBound() && range.upperBound.compareTo(paramRange.upperBound) >= 0)
          replaceRangeWithSameLowerBound(Range.create(paramRange.upperBound, range.upperBound)); 
        replaceRangeWithSameLowerBound(Range.create(range.lowerBound, paramRange.lowerBound));
      } 
    } 
    entry = this.rangesByLowerBound.floorEntry(paramRange.upperBound);
    if (entry != null) {
      Range range = entry.getValue();
      if (paramRange.hasUpperBound() && range.upperBound.compareTo(paramRange.upperBound) >= 0)
        replaceRangeWithSameLowerBound(Range.create(paramRange.upperBound, range.upperBound)); 
    } 
    this.rangesByLowerBound.subMap(paramRange.lowerBound, paramRange.upperBound).clear();
  }
  
  public Range<C> span() {
    Map.Entry<Cut<C>, Range<C>> entry1 = this.rangesByLowerBound.firstEntry();
    Map.Entry<Cut<C>, Range<C>> entry2 = this.rangesByLowerBound.lastEntry();
    if (entry1 != null)
      return Range.create(((Range)entry1.getValue()).lowerBound, ((Range)entry2.getValue()).upperBound); 
    throw new NoSuchElementException();
  }
  
  public RangeSet<C> subRangeSet(Range<C> paramRange) {
    TreeRangeSet<C> treeRangeSet;
    if (paramRange.equals(Range.all())) {
      treeRangeSet = this;
    } else {
      treeRangeSet = new SubRangeSet((Range<C>)treeRangeSet);
    } 
    return treeRangeSet;
  }
  
  final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {
    final Collection<Range<C>> delegate;
    
    AsRanges(Collection<Range<C>> param1Collection) {
      this.delegate = param1Collection;
    }
    
    protected Collection<Range<C>> delegate() {
      return this.delegate;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      return Sets.equalsImpl(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.hashCodeImpl(this);
    }
  }
  
  private final class Complement extends TreeRangeSet<C> {
    Complement() {
      super(new TreeRangeSet.ComplementRangesByLowerBound<Comparable<?>>(TreeRangeSet.this.rangesByLowerBound));
    }
    
    public void add(Range<C> param1Range) {
      TreeRangeSet.this.remove(param1Range);
    }
    
    public RangeSet<C> complement() {
      return TreeRangeSet.this;
    }
    
    public boolean contains(C param1C) {
      return TreeRangeSet.this.contains((Comparable)param1C) ^ true;
    }
    
    public void remove(Range<C> param1Range) {
      TreeRangeSet.this.add(param1Range);
    }
  }
  
  private static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
    private final Range<Cut<C>> complementLowerBoundWindow;
    
    private final NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound;
    
    private final NavigableMap<Cut<C>, Range<C>> positiveRangesByUpperBound;
    
    ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> param1NavigableMap) {
      this(param1NavigableMap, Range.all());
    }
    
    private ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> param1NavigableMap, Range<Cut<C>> param1Range) {
      this.positiveRangesByLowerBound = param1NavigableMap;
      this.positiveRangesByUpperBound = new TreeRangeSet.RangesByUpperBound<C>(param1NavigableMap);
      this.complementLowerBoundWindow = param1Range;
    }
    
    private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> param1Range) {
      if (!this.complementLowerBoundWindow.isConnected(param1Range))
        return ImmutableSortedMap.of(); 
      param1Range = param1Range.intersection(this.complementLowerBoundWindow);
      return new ComplementRangesByLowerBound(this.positiveRangesByLowerBound, param1Range);
    }
    
    public Comparator<? super Cut<C>> comparator() {
      return Ordering.natural();
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
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
      Cut<Comparable> cut;
      boolean bool;
      if (this.complementLowerBoundWindow.hasUpperBound()) {
        cut = this.complementLowerBoundWindow.upperEndpoint();
      } else {
        cut = Cut.aboveAll();
      } 
      if (this.complementLowerBoundWindow.hasUpperBound() && this.complementLowerBoundWindow.upperBoundType() == BoundType.CLOSED) {
        bool = true;
      } else {
        bool = false;
      } 
      final PeekingIterator<?> positiveItr = Iterators.peekingIterator(this.positiveRangesByUpperBound.headMap(cut, bool).descendingMap().values().iterator());
      if (peekingIterator.hasNext()) {
        if (((Range)peekingIterator.peek()).upperBound == Cut.aboveAll()) {
          cut = ((Range)peekingIterator.next()).lowerBound;
        } else {
          cut = (Cut<Comparable>)this.positiveRangesByLowerBound.higherKey(((Range)peekingIterator.peek()).upperBound);
        } 
      } else {
        if (!this.complementLowerBoundWindow.contains((Cut)Cut.belowAll()) || this.positiveRangesByLowerBound.containsKey(Cut.belowAll()))
          return Iterators.emptyIterator(); 
        cut = (Cut<Comparable>)this.positiveRangesByLowerBound.higherKey(Cut.belowAll());
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
          Cut<C> nextComplementRangeUpperBound = firstComplementRangeUpperBound;
          
          protected Map.Entry<Cut<C>, Range<C>> computeNext() {
            if (this.nextComplementRangeUpperBound == Cut.belowAll())
              return endOfData(); 
            if (positiveItr.hasNext()) {
              Range range = positiveItr.next();
              Range<C> range1 = Range.create(range.upperBound, this.nextComplementRangeUpperBound);
              this.nextComplementRangeUpperBound = range.lowerBound;
              if (TreeRangeSet.ComplementRangesByLowerBound.this.complementLowerBoundWindow.lowerBound.isLessThan(range1.lowerBound))
                return Maps.immutableEntry(range1.lowerBound, range1); 
            } else if (TreeRangeSet.ComplementRangesByLowerBound.this.complementLowerBoundWindow.lowerBound.isLessThan(Cut.belowAll())) {
              Range<C> range = Range.create((Cut)Cut.belowAll(), this.nextComplementRangeUpperBound);
              this.nextComplementRangeUpperBound = Cut.belowAll();
              return Maps.immutableEntry((Cut)Cut.belowAll(), range);
            } 
            return endOfData();
          }
        };
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
      Collection<Range<C>> collection;
      final Cut firstComplementRangeLowerBound;
      if (this.complementLowerBoundWindow.hasLowerBound()) {
        boolean bool;
        NavigableMap<Cut<C>, Range<C>> navigableMap = this.positiveRangesByUpperBound;
        Cut cut1 = (Cut)this.complementLowerBoundWindow.lowerEndpoint();
        if (this.complementLowerBoundWindow.lowerBoundType() == BoundType.CLOSED) {
          bool = true;
        } else {
          bool = false;
        } 
        collection = navigableMap.tailMap(cut1, bool).values();
      } else {
        collection = this.positiveRangesByUpperBound.values();
      } 
      final PeekingIterator<?> positiveItr = Iterators.peekingIterator(collection.iterator());
      if (this.complementLowerBoundWindow.contains((Cut)Cut.belowAll()) && (!peekingIterator.hasNext() || ((Range)peekingIterator.peek()).lowerBound != Cut.belowAll())) {
        cut = Cut.belowAll();
      } else {
        if (peekingIterator.hasNext()) {
          cut = ((Range)peekingIterator.next()).upperBound;
          return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
              Cut<C> nextComplementRangeLowerBound = firstComplementRangeLowerBound;
              
              protected Map.Entry<Cut<C>, Range<C>> computeNext() {
                Range<C> range;
                if (TreeRangeSet.ComplementRangesByLowerBound.this.complementLowerBoundWindow.upperBound.isLessThan(this.nextComplementRangeLowerBound) || this.nextComplementRangeLowerBound == Cut.aboveAll())
                  return endOfData(); 
                if (positiveItr.hasNext()) {
                  Range range1 = positiveItr.next();
                  range = Range.create(this.nextComplementRangeLowerBound, range1.lowerBound);
                  this.nextComplementRangeLowerBound = range1.upperBound;
                } else {
                  range = Range.create(this.nextComplementRangeLowerBound, (Cut)Cut.aboveAll());
                  this.nextComplementRangeLowerBound = Cut.aboveAll();
                } 
                return Maps.immutableEntry(range.lowerBound, range);
              }
            };
        } 
        return Iterators.emptyIterator();
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
          Cut<C> nextComplementRangeLowerBound = firstComplementRangeLowerBound;
          
          protected Map.Entry<Cut<C>, Range<C>> computeNext() {
            Range<C> range;
            if (TreeRangeSet.ComplementRangesByLowerBound.this.complementLowerBoundWindow.upperBound.isLessThan(this.nextComplementRangeLowerBound) || this.nextComplementRangeLowerBound == Cut.aboveAll())
              return endOfData(); 
            if (positiveItr.hasNext()) {
              Range range1 = positiveItr.next();
              range = Range.create(this.nextComplementRangeLowerBound, range1.lowerBound);
              this.nextComplementRangeLowerBound = range1.upperBound;
            } else {
              range = Range.create(this.nextComplementRangeLowerBound, (Cut)Cut.aboveAll());
              this.nextComplementRangeLowerBound = Cut.aboveAll();
            } 
            return Maps.immutableEntry(range.lowerBound, range);
          }
        };
    }
    
    @Nullable
    public Range<C> get(Object<Cut<C>, Range<C>> param1Object) {
      if (param1Object instanceof Cut)
        try {
          Cut<C> cut = (Cut)param1Object;
          param1Object = (Object<Cut<C>, Range<C>>)tailMap(cut, true).firstEntry();
          if (param1Object != null && ((Cut)param1Object.getKey()).equals(cut))
            return param1Object.getValue(); 
        } catch (ClassCastException classCastException) {
          return null;
        }  
      return null;
    }
    
    public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> param1Cut, boolean param1Boolean) {
      return subMap(Range.upTo(param1Cut, BoundType.forBoolean(param1Boolean)));
    }
    
    public int size() {
      return Iterators.size(entryIterator());
    }
    
    public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> param1Cut1, boolean param1Boolean1, Cut<C> param1Cut2, boolean param1Boolean2) {
      return subMap(Range.range(param1Cut1, BoundType.forBoolean(param1Boolean1), param1Cut2, BoundType.forBoolean(param1Boolean2)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> param1Cut, boolean param1Boolean) {
      return subMap(Range.downTo(param1Cut, BoundType.forBoolean(param1Boolean)));
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    Cut<C> nextComplementRangeLowerBound = firstComplementRangeLowerBound;
    
    protected Map.Entry<Cut<C>, Range<C>> computeNext() {
      Range<C> range;
      if (this.this$0.complementLowerBoundWindow.upperBound.isLessThan(this.nextComplementRangeLowerBound) || this.nextComplementRangeLowerBound == Cut.aboveAll())
        return endOfData(); 
      if (positiveItr.hasNext()) {
        Range range1 = positiveItr.next();
        range = Range.create(this.nextComplementRangeLowerBound, range1.lowerBound);
        this.nextComplementRangeLowerBound = range1.upperBound;
      } else {
        range = Range.create(this.nextComplementRangeLowerBound, (Cut)Cut.aboveAll());
        this.nextComplementRangeLowerBound = Cut.aboveAll();
      } 
      return Maps.immutableEntry(range.lowerBound, range);
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    Cut<C> nextComplementRangeUpperBound = firstComplementRangeUpperBound;
    
    protected Map.Entry<Cut<C>, Range<C>> computeNext() {
      if (this.nextComplementRangeUpperBound == Cut.belowAll())
        return endOfData(); 
      if (positiveItr.hasNext()) {
        Range range = positiveItr.next();
        Range<C> range1 = Range.create(range.upperBound, this.nextComplementRangeUpperBound);
        this.nextComplementRangeUpperBound = range.lowerBound;
        if (this.this$0.complementLowerBoundWindow.lowerBound.isLessThan(range1.lowerBound))
          return Maps.immutableEntry(range1.lowerBound, range1); 
      } else if (this.this$0.complementLowerBoundWindow.lowerBound.isLessThan(Cut.belowAll())) {
        Range<C> range = Range.create((Cut)Cut.belowAll(), this.nextComplementRangeUpperBound);
        this.nextComplementRangeUpperBound = Cut.belowAll();
        return Maps.immutableEntry((Cut)Cut.belowAll(), range);
      } 
      return endOfData();
    }
  }
  
  @VisibleForTesting
  static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
    private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
    
    private final Range<Cut<C>> upperBoundWindow;
    
    RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> param1NavigableMap) {
      this.rangesByLowerBound = param1NavigableMap;
      this.upperBoundWindow = Range.all();
    }
    
    private RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> param1NavigableMap, Range<Cut<C>> param1Range) {
      this.rangesByLowerBound = param1NavigableMap;
      this.upperBoundWindow = param1Range;
    }
    
    private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> param1Range) {
      return (NavigableMap<Cut<C>, Range<C>>)(param1Range.isConnected(this.upperBoundWindow) ? new RangesByUpperBound(this.rangesByLowerBound, param1Range.intersection(this.upperBoundWindow)) : ImmutableSortedMap.of());
    }
    
    public Comparator<? super Cut<C>> comparator() {
      return Ordering.natural();
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
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
      Collection<?> collection;
      if (this.upperBoundWindow.hasUpperBound()) {
        collection = this.rangesByLowerBound.headMap(this.upperBoundWindow.upperEndpoint(), false).descendingMap().values();
      } else {
        collection = this.rangesByLowerBound.descendingMap().values();
      } 
      final PeekingIterator<?> backingItr = Iterators.peekingIterator(collection.iterator());
      if (peekingIterator.hasNext() && this.upperBoundWindow.upperBound.isLessThan(((Range)peekingIterator.peek()).upperBound))
        peekingIterator.next(); 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
          protected Map.Entry<Cut<C>, Range<C>> computeNext() {
            Map.Entry<Cut<C>, Range<C>> entry;
            if (!backingItr.hasNext())
              return endOfData(); 
            Range range = backingItr.next();
            if (TreeRangeSet.RangesByUpperBound.this.upperBoundWindow.lowerBound.isLessThan(range.upperBound)) {
              Map.Entry<Cut, Range> entry1 = Maps.immutableEntry(range.upperBound, range);
            } else {
              entry = endOfData();
            } 
            return entry;
          }
        };
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
      final Iterator backingItr;
      if (!this.upperBoundWindow.hasLowerBound()) {
        iterator = this.rangesByLowerBound.values().iterator();
      } else {
        Map.Entry<Cut<C>, Range<C>> entry = this.rangesByLowerBound.lowerEntry(this.upperBoundWindow.lowerEndpoint());
        if (entry == null) {
          iterator = this.rangesByLowerBound.values().iterator();
        } else if (this.upperBoundWindow.lowerBound.isLessThan(((Range)iterator.getValue()).upperBound)) {
          iterator = this.rangesByLowerBound.tailMap((Cut<C>)iterator.getKey(), true).values().iterator();
        } else {
          iterator = this.rangesByLowerBound.tailMap(this.upperBoundWindow.lowerEndpoint(), true).values().iterator();
        } 
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
          protected Map.Entry<Cut<C>, Range<C>> computeNext() {
            if (!backingItr.hasNext())
              return endOfData(); 
            Range<C> range = backingItr.next();
            return TreeRangeSet.RangesByUpperBound.this.upperBoundWindow.upperBound.isLessThan(range.upperBound) ? endOfData() : Maps.immutableEntry(range.upperBound, range);
          }
        };
    }
    
    public Range<C> get(@Nullable Object<Cut<C>, Range<C>> param1Object) {
      if (param1Object instanceof Cut)
        try {
          Cut<C> cut = (Cut)param1Object;
          if (!this.upperBoundWindow.contains(cut))
            return null; 
          param1Object = (Object<Cut<C>, Range<C>>)this.rangesByLowerBound.lowerEntry(cut);
          if (param1Object != null && ((Range)param1Object.getValue()).upperBound.equals(cut))
            return param1Object.getValue(); 
        } catch (ClassCastException classCastException) {
          return null;
        }  
      return null;
    }
    
    public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> param1Cut, boolean param1Boolean) {
      return subMap(Range.upTo(param1Cut, BoundType.forBoolean(param1Boolean)));
    }
    
    public boolean isEmpty() {
      boolean bool;
      if (this.upperBoundWindow.equals(Range.all())) {
        bool = this.rangesByLowerBound.isEmpty();
      } else if (!entryIterator().hasNext()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int size() {
      return this.upperBoundWindow.equals(Range.all()) ? this.rangesByLowerBound.size() : Iterators.size(entryIterator());
    }
    
    public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> param1Cut1, boolean param1Boolean1, Cut<C> param1Cut2, boolean param1Boolean2) {
      return subMap(Range.range(param1Cut1, BoundType.forBoolean(param1Boolean1), param1Cut2, BoundType.forBoolean(param1Boolean2)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> param1Cut, boolean param1Boolean) {
      return subMap(Range.downTo(param1Cut, BoundType.forBoolean(param1Boolean)));
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    protected Map.Entry<Cut<C>, Range<C>> computeNext() {
      if (!backingItr.hasNext())
        return endOfData(); 
      Range<C> range = backingItr.next();
      return this.this$0.upperBoundWindow.upperBound.isLessThan(range.upperBound) ? endOfData() : Maps.immutableEntry(range.upperBound, range);
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    protected Map.Entry<Cut<C>, Range<C>> computeNext() {
      Map.Entry<Cut<C>, Range<C>> entry;
      if (!backingItr.hasNext())
        return endOfData(); 
      Range range = backingItr.next();
      if (this.this$0.upperBoundWindow.lowerBound.isLessThan(range.upperBound)) {
        Map.Entry<Cut, Range> entry1 = Maps.immutableEntry(range.upperBound, range);
      } else {
        entry = endOfData();
      } 
      return entry;
    }
  }
  
  private final class SubRangeSet extends TreeRangeSet<C> {
    private final Range<C> restriction;
    
    SubRangeSet(Range<C> param1Range) {
      super(new TreeRangeSet.SubRangeSetRangesByLowerBound<Comparable<?>>(Range.all(), param1Range, TreeRangeSet.this.rangesByLowerBound, null));
      this.restriction = param1Range;
    }
    
    public void add(Range<C> param1Range) {
      Preconditions.checkArgument(this.restriction.encloses(param1Range), "Cannot add range %s to subRangeSet(%s)", param1Range, this.restriction);
      super.add(param1Range);
    }
    
    public void clear() {
      TreeRangeSet.this.remove(this.restriction);
    }
    
    public boolean contains(C param1C) {
      boolean bool;
      if (this.restriction.contains(param1C) && TreeRangeSet.this.contains((Comparable)param1C)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean encloses(Range<C> param1Range) {
      boolean bool = this.restriction.isEmpty();
      boolean bool1 = false;
      if (!bool && this.restriction.encloses(param1Range)) {
        param1Range = TreeRangeSet.this.rangeEnclosing(param1Range);
        bool = bool1;
        if (param1Range != null) {
          bool = bool1;
          if (!param1Range.intersection(this.restriction).isEmpty())
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    @Nullable
    public Range<C> rangeContaining(C param1C) {
      boolean bool = this.restriction.contains(param1C);
      Range range1 = null;
      if (!bool)
        return null; 
      Range<C> range = TreeRangeSet.this.rangeContaining(param1C);
      if (range == null) {
        range = range1;
      } else {
        range = range.intersection(this.restriction);
      } 
      return range;
    }
    
    public void remove(Range<C> param1Range) {
      if (param1Range.isConnected(this.restriction))
        TreeRangeSet.this.remove(param1Range.intersection(this.restriction)); 
    }
    
    public RangeSet<C> subRangeSet(Range<C> param1Range) {
      return (RangeSet<C>)(param1Range.encloses(this.restriction) ? this : (param1Range.isConnected(this.restriction) ? new SubRangeSet(this.restriction.intersection(param1Range)) : ImmutableRangeSet.of()));
    }
  }
  
  private static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
    private final Range<Cut<C>> lowerBoundWindow;
    
    private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
    
    private final NavigableMap<Cut<C>, Range<C>> rangesByUpperBound;
    
    private final Range<C> restriction;
    
    private SubRangeSetRangesByLowerBound(Range<Cut<C>> param1Range, Range<C> param1Range1, NavigableMap<Cut<C>, Range<C>> param1NavigableMap) {
      this.lowerBoundWindow = (Range<Cut<C>>)Preconditions.checkNotNull(param1Range);
      this.restriction = (Range<C>)Preconditions.checkNotNull(param1Range1);
      this.rangesByLowerBound = (NavigableMap<Cut<C>, Range<C>>)Preconditions.checkNotNull(param1NavigableMap);
      this.rangesByUpperBound = new TreeRangeSet.RangesByUpperBound<C>(param1NavigableMap);
    }
    
    private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> param1Range) {
      return (NavigableMap<Cut<C>, Range<C>>)(!param1Range.isConnected(this.lowerBoundWindow) ? ImmutableSortedMap.of() : new SubRangeSetRangesByLowerBound(this.lowerBoundWindow.intersection(param1Range), this.restriction, this.rangesByLowerBound));
    }
    
    public Comparator<? super Cut<C>> comparator() {
      return Ordering.natural();
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
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
      boolean bool;
      if (this.restriction.isEmpty())
        return Iterators.emptyIterator(); 
      Cut<Object> cut = (Cut)Ordering.<Comparable>natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
      NavigableMap<Cut<C>, Range<C>> navigableMap = this.rangesByLowerBound;
      Cut cut1 = (Cut)cut.endpoint();
      if (cut.typeAsUpperBound() == BoundType.CLOSED) {
        bool = true;
      } else {
        bool = false;
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
          protected Map.Entry<Cut<C>, Range<C>> computeNext() {
            if (!completeRangeItr.hasNext())
              return endOfData(); 
            Range<C> range = completeRangeItr.next();
            if (TreeRangeSet.SubRangeSetRangesByLowerBound.this.restriction.lowerBound.compareTo(range.upperBound) >= 0)
              return endOfData(); 
            range = range.intersection(TreeRangeSet.SubRangeSetRangesByLowerBound.this.restriction);
            return TreeRangeSet.SubRangeSetRangesByLowerBound.this.lowerBoundWindow.contains(range.lowerBound) ? Maps.immutableEntry(range.lowerBound, range) : endOfData();
          }
        };
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
      final Iterator completeRangeItr;
      if (this.restriction.isEmpty())
        return Iterators.emptyIterator(); 
      if (this.lowerBoundWindow.upperBound.isLessThan(this.restriction.lowerBound))
        return Iterators.emptyIterator(); 
      boolean bool = this.lowerBoundWindow.lowerBound.isLessThan(this.restriction.lowerBound);
      boolean bool1 = false;
      if (bool) {
        iterator = this.rangesByUpperBound.tailMap(this.restriction.lowerBound, false).values().iterator();
      } else {
        NavigableMap<Cut<C>, Range<C>> navigableMap = this.rangesByLowerBound;
        Cut cut = (Cut)this.lowerBoundWindow.lowerBound.endpoint();
        if (this.lowerBoundWindow.lowerBoundType() == BoundType.CLOSED)
          bool1 = true; 
        iterator = navigableMap.tailMap(cut, bool1).values().iterator();
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
          protected Map.Entry<Cut<C>, Range<C>> computeNext() {
            if (!completeRangeItr.hasNext())
              return endOfData(); 
            Range<C> range = completeRangeItr.next();
            if (upperBoundOnLowerBounds.isLessThan(range.lowerBound))
              return endOfData(); 
            range = range.intersection(TreeRangeSet.SubRangeSetRangesByLowerBound.this.restriction);
            return Maps.immutableEntry(range.lowerBound, range);
          }
        };
    }
    
    @Nullable
    public Range<C> get(@Nullable Object param1Object) {
      if (param1Object instanceof Cut)
        try {
          param1Object = param1Object;
          if (!this.lowerBoundWindow.contains(param1Object) || param1Object.compareTo(this.restriction.lowerBound) < 0 || param1Object.compareTo(this.restriction.upperBound) >= 0)
            return null; 
          if (param1Object.equals(this.restriction.lowerBound)) {
            param1Object = Maps.<Range>valueOrNull((Map.Entry)this.rangesByLowerBound.floorEntry(param1Object));
            if (param1Object != null && ((Range)param1Object).upperBound.compareTo(this.restriction.lowerBound) > 0)
              return param1Object.intersection(this.restriction); 
          } else {
            param1Object = this.rangesByLowerBound.get(param1Object);
            if (param1Object != null)
              return param1Object.intersection(this.restriction); 
          } 
        } catch (ClassCastException classCastException) {
          return null;
        }  
      return null;
    }
    
    public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> param1Cut, boolean param1Boolean) {
      return subMap(Range.upTo(param1Cut, BoundType.forBoolean(param1Boolean)));
    }
    
    public int size() {
      return Iterators.size(entryIterator());
    }
    
    public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> param1Cut1, boolean param1Boolean1, Cut<C> param1Cut2, boolean param1Boolean2) {
      return subMap(Range.range(param1Cut1, BoundType.forBoolean(param1Boolean1), param1Cut2, BoundType.forBoolean(param1Boolean2)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> param1Cut, boolean param1Boolean) {
      return subMap(Range.downTo(param1Cut, BoundType.forBoolean(param1Boolean)));
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    protected Map.Entry<Cut<C>, Range<C>> computeNext() {
      if (!completeRangeItr.hasNext())
        return endOfData(); 
      Range<C> range = completeRangeItr.next();
      if (upperBoundOnLowerBounds.isLessThan(range.lowerBound))
        return endOfData(); 
      range = range.intersection(this.this$0.restriction);
      return Maps.immutableEntry(range.lowerBound, range);
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    protected Map.Entry<Cut<C>, Range<C>> computeNext() {
      if (!completeRangeItr.hasNext())
        return endOfData(); 
      Range<C> range = completeRangeItr.next();
      if (this.this$0.restriction.lowerBound.compareTo(range.upperBound) >= 0)
        return endOfData(); 
      range = range.intersection(this.this$0.restriction);
      return this.this$0.lowerBoundWindow.contains(range.lowerBound) ? Maps.immutableEntry(range.lowerBound, range) : endOfData();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\TreeRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */