package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractTable<R, C, V> implements Table<R, C, V> {
  private transient Set<Table.Cell<R, C, V>> cellSet;
  
  private transient Collection<V> values;
  
  abstract Iterator<Table.Cell<R, C, V>> cellIterator();
  
  public Set<Table.Cell<R, C, V>> cellSet() {
    Set<Table.Cell<R, C, V>> set1 = this.cellSet;
    Set<Table.Cell<R, C, V>> set2 = set1;
    if (set1 == null) {
      set2 = createCellSet();
      this.cellSet = set2;
    } 
    return set2;
  }
  
  public void clear() {
    Iterators.clear(cellSet().iterator());
  }
  
  public Set<C> columnKeySet() {
    return columnMap().keySet();
  }
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    boolean bool;
    paramObject1 = Maps.<Map>safeGet((Map)rowMap(), paramObject1);
    if (paramObject1 != null && Maps.safeContainsKey((Map<?, ?>)paramObject1, paramObject2)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsColumn(@Nullable Object paramObject) {
    return Maps.safeContainsKey(columnMap(), paramObject);
  }
  
  public boolean containsRow(@Nullable Object paramObject) {
    return Maps.safeContainsKey(rowMap(), paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    Iterator<Map> iterator = rowMap().values().iterator();
    while (iterator.hasNext()) {
      if (((Map)iterator.next()).containsValue(paramObject))
        return true; 
    } 
    return false;
  }
  
  Set<Table.Cell<R, C, V>> createCellSet() {
    return new CellSet();
  }
  
  Collection<V> createValues() {
    return new Values();
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return Tables.equalsImpl(this, paramObject);
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    paramObject1 = Maps.<Map>safeGet((Map)rowMap(), paramObject1);
    if (paramObject1 == null) {
      paramObject1 = null;
    } else {
      paramObject1 = Maps.safeGet((Map<?, ?>)paramObject1, paramObject2);
    } 
    return (V)paramObject1;
  }
  
  public int hashCode() {
    return cellSet().hashCode();
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
  
  @CanIgnoreReturnValue
  public V put(R paramR, C paramC, V paramV) {
    return row(paramR).put(paramC, paramV);
  }
  
  public void putAll(Table<? extends R, ? extends C, ? extends V> paramTable) {
    for (Table.Cell<? extends R, ? extends C, ? extends V> cell : paramTable.cellSet())
      put((R)cell.getRowKey(), (C)cell.getColumnKey(), (V)cell.getValue()); 
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    paramObject1 = Maps.<Map>safeGet((Map)rowMap(), paramObject1);
    if (paramObject1 == null) {
      paramObject1 = null;
    } else {
      paramObject1 = Maps.safeRemove((Map<?, ?>)paramObject1, paramObject2);
    } 
    return (V)paramObject1;
  }
  
  public Set<R> rowKeySet() {
    return rowMap().keySet();
  }
  
  public String toString() {
    return rowMap().toString();
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
  
  Iterator<V> valuesIterator() {
    return new TransformedIterator<Table.Cell<R, C, V>, V>(cellSet().iterator()) {
        V transform(Table.Cell<R, C, V> param1Cell) {
          return param1Cell.getValue();
        }
      };
  }
  
  class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
    public void clear() {
      AbstractTable.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Table.Cell;
      boolean bool1 = false;
      if (bool) {
        Table.Cell cell = (Table.Cell)param1Object;
        param1Object = Maps.<Map>safeGet(AbstractTable.this.rowMap(), cell.getRowKey());
        bool = bool1;
        if (param1Object != null) {
          bool = bool1;
          if (Collections2.safeContains(param1Object.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue())))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public Iterator<Table.Cell<R, C, V>> iterator() {
      return AbstractTable.this.cellIterator();
    }
    
    public boolean remove(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof Table.Cell;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        Map map = Maps.<Map>safeGet(AbstractTable.this.rowMap(), param1Object.getRowKey());
        bool = bool1;
        if (map != null) {
          bool = bool1;
          if (Collections2.safeRemove(map.entrySet(), Maps.immutableEntry(param1Object.getColumnKey(), param1Object.getValue())))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int size() {
      return AbstractTable.this.size();
    }
  }
  
  class Values extends AbstractCollection<V> {
    public void clear() {
      AbstractTable.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      return AbstractTable.this.containsValue(param1Object);
    }
    
    public Iterator<V> iterator() {
      return AbstractTable.this.valuesIterator();
    }
    
    public int size() {
      return AbstractTable.this.size();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */