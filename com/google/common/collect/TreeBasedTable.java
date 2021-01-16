package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
  private static final long serialVersionUID = 0L;
  
  private final Comparator<? super C> columnComparator;
  
  TreeBasedTable(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1) {
    super(new TreeMap<R, Map<C, V>>(paramComparator), (Supplier)new Factory<C, Object>(paramComparator1));
    this.columnComparator = paramComparator1;
  }
  
  public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
    return new TreeBasedTable<R, C, V>(Ordering.natural(), Ordering.natural());
  }
  
  public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> paramTreeBasedTable) {
    TreeBasedTable<Object, Object, Object> treeBasedTable = new TreeBasedTable<Object, Object, Object>(paramTreeBasedTable.rowComparator(), paramTreeBasedTable.columnComparator());
    treeBasedTable.putAll(paramTreeBasedTable);
    return (TreeBasedTable)treeBasedTable;
  }
  
  public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1) {
    Preconditions.checkNotNull(paramComparator);
    Preconditions.checkNotNull(paramComparator1);
    return new TreeBasedTable<R, C, V>(paramComparator, paramComparator1);
  }
  
  public Comparator<? super C> columnComparator() {
    return this.columnComparator;
  }
  
  Iterator<C> createColumnKeyIterator() {
    final Comparator<? super C> comparator = columnComparator();
    return new AbstractIterator<C>() {
        C lastValue;
        
        protected C computeNext() {
          while (merged.hasNext()) {
            boolean bool;
            C c1 = (C)merged.next();
            C c2 = this.lastValue;
            if (c2 != null && comparator.compare(c1, c2) == 0) {
              bool = true;
            } else {
              bool = false;
            } 
            if (!bool) {
              this.lastValue = c1;
              return this.lastValue;
            } 
          } 
          this.lastValue = null;
          return endOfData();
        }
      };
  }
  
  public SortedMap<C, V> row(R paramR) {
    return new TreeRow(paramR);
  }
  
  public Comparator<? super R> rowComparator() {
    return rowKeySet().comparator();
  }
  
  public SortedSet<R> rowKeySet() {
    return super.rowKeySet();
  }
  
  public SortedMap<R, Map<C, V>> rowMap() {
    return super.rowMap();
  }
  
  private static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final Comparator<? super C> comparator;
    
    Factory(Comparator<? super C> param1Comparator) {
      this.comparator = param1Comparator;
    }
    
    public TreeMap<C, V> get() {
      return new TreeMap<C, V>(this.comparator);
    }
  }
  
  private class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {
    @Nullable
    final C lowerBound;
    
    @Nullable
    final C upperBound;
    
    transient SortedMap<C, V> wholeRow;
    
    TreeRow(R param1R) {
      this(param1R, null, null);
    }
    
    TreeRow(@Nullable R param1R, @Nullable C param1C1, C param1C2) {
      super(param1R);
      boolean bool;
      this.lowerBound = param1C1;
      this.upperBound = param1C2;
      if (param1C1 == null || param1C2 == null || compare(param1C1, param1C2) <= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
    }
    
    SortedMap<C, V> backingRowMap() {
      return (SortedMap<C, V>)super.backingRowMap();
    }
    
    public Comparator<? super C> comparator() {
      return TreeBasedTable.this.columnComparator();
    }
    
    int compare(Object param1Object1, Object param1Object2) {
      return comparator().compare((C)param1Object1, (C)param1Object2);
    }
    
    SortedMap<C, V> computeBackingRowMap() {
      SortedMap<C, V> sortedMap = wholeRow();
      if (sortedMap != null) {
        C c = this.lowerBound;
        SortedMap<C, V> sortedMap1 = sortedMap;
        if (c != null)
          sortedMap1 = sortedMap.tailMap(c); 
        c = this.upperBound;
        sortedMap = sortedMap1;
        if (c != null)
          sortedMap = sortedMap1.headMap(c); 
        return sortedMap;
      } 
      return null;
    }
    
    public boolean containsKey(Object param1Object) {
      boolean bool;
      if (rangeContains(param1Object) && super.containsKey(param1Object)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public C firstKey() {
      if (backingRowMap() != null)
        return backingRowMap().firstKey(); 
      throw new NoSuchElementException();
    }
    
    public SortedMap<C, V> headMap(C param1C) {
      Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(param1C)));
      return new TreeRow(this.rowKey, this.lowerBound, param1C);
    }
    
    public SortedSet<C> keySet() {
      return new Maps.SortedKeySet<C, Object>(this);
    }
    
    public C lastKey() {
      if (backingRowMap() != null)
        return backingRowMap().lastKey(); 
      throw new NoSuchElementException();
    }
    
    void maintainEmptyInvariant() {
      if (wholeRow() != null && this.wholeRow.isEmpty()) {
        TreeBasedTable.this.backingMap.remove(this.rowKey);
        this.wholeRow = null;
        this.backingRowMap = null;
      } 
    }
    
    public V put(C param1C, V param1V) {
      Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(param1C)));
      return super.put(param1C, param1V);
    }
    
    boolean rangeContains(@Nullable Object param1Object) {
      if (param1Object != null) {
        C c = this.lowerBound;
        if (c == null || compare(c, param1Object) <= 0) {
          c = this.upperBound;
          if (c == null || compare(c, param1Object) > 0)
            return true; 
        } 
      } 
      return false;
    }
    
    public SortedMap<C, V> subMap(C param1C1, C param1C2) {
      boolean bool;
      if (rangeContains(Preconditions.checkNotNull(param1C1)) && rangeContains(Preconditions.checkNotNull(param1C2))) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      return new TreeRow(this.rowKey, param1C1, param1C2);
    }
    
    public SortedMap<C, V> tailMap(C param1C) {
      Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(param1C)));
      return new TreeRow(this.rowKey, param1C, this.upperBound);
    }
    
    SortedMap<C, V> wholeRow() {
      SortedMap<C, V> sortedMap = this.wholeRow;
      if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.rowKey)))
        this.wholeRow = (SortedMap<C, V>)TreeBasedTable.this.backingMap.get(this.rowKey); 
      return this.wholeRow;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\TreeBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */