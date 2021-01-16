package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements RowSortedTable<R, C, V> {
  private static final long serialVersionUID = 0L;
  
  StandardRowSortedTable(SortedMap<R, Map<C, V>> paramSortedMap, Supplier<? extends Map<C, V>> paramSupplier) {
    super(paramSortedMap, paramSupplier);
  }
  
  private SortedMap<R, Map<C, V>> sortedBackingMap() {
    return (SortedMap<R, Map<C, V>>)this.backingMap;
  }
  
  SortedMap<R, Map<C, V>> createRowMap() {
    return new RowSortedMap();
  }
  
  public SortedSet<R> rowKeySet() {
    return (SortedSet<R>)rowMap().keySet();
  }
  
  public SortedMap<R, Map<C, V>> rowMap() {
    return (SortedMap<R, Map<C, V>>)super.rowMap();
  }
  
  private class RowSortedMap extends StandardTable<R, C, V>.RowMap implements SortedMap<R, Map<C, V>> {
    private RowSortedMap() {}
    
    public Comparator<? super R> comparator() {
      return StandardRowSortedTable.this.sortedBackingMap().comparator();
    }
    
    SortedSet<R> createKeySet() {
      return new Maps.SortedKeySet<R, Object>(this);
    }
    
    public R firstKey() {
      return (R)StandardRowSortedTable.this.sortedBackingMap().firstKey();
    }
    
    public SortedMap<R, Map<C, V>> headMap(R param1R) {
      Preconditions.checkNotNull(param1R);
      return (new StandardRowSortedTable<R, C, V>(StandardRowSortedTable.this.sortedBackingMap().headMap(param1R), StandardRowSortedTable.this.factory)).rowMap();
    }
    
    public SortedSet<R> keySet() {
      return (SortedSet<R>)super.keySet();
    }
    
    public R lastKey() {
      return (R)StandardRowSortedTable.this.sortedBackingMap().lastKey();
    }
    
    public SortedMap<R, Map<C, V>> subMap(R param1R1, R param1R2) {
      Preconditions.checkNotNull(param1R1);
      Preconditions.checkNotNull(param1R2);
      return (new StandardRowSortedTable<R, C, V>(StandardRowSortedTable.this.sortedBackingMap().subMap(param1R1, param1R2), StandardRowSortedTable.this.factory)).rowMap();
    }
    
    public SortedMap<R, Map<C, V>> tailMap(R param1R) {
      Preconditions.checkNotNull(param1R);
      return (new StandardRowSortedTable<R, C, V>(StandardRowSortedTable.this.sortedBackingMap().tailMap(param1R), StandardRowSortedTable.this.factory)).rowMap();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\StandardRowSortedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */