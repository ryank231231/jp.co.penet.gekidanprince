package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
  static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> paramIterable) {
    return forCellsInternal(paramIterable, (Comparator<? super R>)null, (Comparator<? super C>)null);
  }
  
  static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> paramList, @Nullable final Comparator<? super R> rowComparator, @Nullable final Comparator<? super C> columnComparator) {
    Preconditions.checkNotNull(paramList);
    if (rowComparator != null || columnComparator != null)
      Collections.sort(paramList, new Comparator<Table.Cell<R, C, V>>() {
            public int compare(Table.Cell<R, C, V> param1Cell1, Table.Cell<R, C, V> param1Cell2) {
              int i;
              Comparator comparator = rowComparator;
              boolean bool = false;
              if (comparator == null) {
                i = 0;
              } else {
                i = comparator.compare(param1Cell1.getRowKey(), param1Cell2.getRowKey());
              } 
              if (i != 0)
                return i; 
              comparator = columnComparator;
              if (comparator == null) {
                i = bool;
              } else {
                i = comparator.compare(param1Cell1.getColumnKey(), param1Cell2.getColumnKey());
              } 
              return i;
            }
          }); 
    return forCellsInternal(paramList, rowComparator, columnComparator);
  }
  
  private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> paramIterable, @Nullable Comparator<? super R> paramComparator, @Nullable Comparator<? super C> paramComparator1) {
    ImmutableSet<?> immutableSet;
    LinkedHashSet<? extends Table.Cell<R, C, V>> linkedHashSet = new LinkedHashSet();
    LinkedHashSet<?> linkedHashSet1 = new LinkedHashSet();
    ImmutableList<Table.Cell<R, C, V>> immutableList = ImmutableList.copyOf(paramIterable);
    for (Table.Cell<R, C, V> cell : paramIterable) {
      linkedHashSet.add(cell.getRowKey());
      linkedHashSet1.add(cell.getColumnKey());
    } 
    if (paramComparator == null) {
      paramIterable = ImmutableSet.copyOf(linkedHashSet);
    } else {
      paramIterable = ImmutableSet.copyOf(Ordering.<R>from(paramComparator).immutableSortedCopy(linkedHashSet));
    } 
    if (paramComparator1 == null) {
      immutableSet = ImmutableSet.copyOf(linkedHashSet1);
    } else {
      immutableSet = ImmutableSet.copyOf(Ordering.<C>from(paramComparator1).immutableSortedCopy(linkedHashSet1));
    } 
    return forOrderedComponents(immutableList, (ImmutableSet)paramIterable, (ImmutableSet)immutableSet);
  }
  
  static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1) {
    DenseImmutableTable<R, C, V> denseImmutableTable;
    SparseImmutableTable<R, C, Object> sparseImmutableTable;
    if (paramImmutableList.size() > paramImmutableSet.size() * paramImmutableSet1.size() / 2L) {
      denseImmutableTable = new DenseImmutableTable<R, C, V>(paramImmutableList, paramImmutableSet, paramImmutableSet1);
    } else {
      sparseImmutableTable = new SparseImmutableTable<R, C, Object>((ImmutableList)denseImmutableTable, paramImmutableSet, paramImmutableSet1);
    } 
    return (RegularImmutableTable)sparseImmutableTable;
  }
  
  final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
    ImmutableSet<?> immutableSet;
    if (isEmpty()) {
      immutableSet = ImmutableSet.of();
    } else {
      immutableSet = new CellSet();
    } 
    return (ImmutableSet)immutableSet;
  }
  
  final ImmutableCollection<V> createValues() {
    ImmutableList<?> immutableList;
    if (isEmpty()) {
      immutableList = ImmutableList.of();
    } else {
      immutableList = new Values();
    } 
    return (ImmutableCollection)immutableList;
  }
  
  abstract Table.Cell<R, C, V> getCell(int paramInt);
  
  abstract V getValue(int paramInt);
  
  private final class CellSet extends ImmutableSet.Indexed<Table.Cell<R, C, V>> {
    private CellSet() {}
    
    public boolean contains(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof Table.Cell;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        Object object = RegularImmutableTable.this.get(param1Object.getRowKey(), param1Object.getColumnKey());
        bool = bool1;
        if (object != null) {
          bool = bool1;
          if (object.equals(param1Object.getValue()))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    Table.Cell<R, C, V> get(int param1Int) {
      return RegularImmutableTable.this.getCell(param1Int);
    }
    
    boolean isPartialView() {
      return false;
    }
    
    public int size() {
      return RegularImmutableTable.this.size();
    }
  }
  
  private final class Values extends ImmutableList<V> {
    private Values() {}
    
    public V get(int param1Int) {
      return (V)RegularImmutableTable.this.getValue(param1Int);
    }
    
    boolean isPartialView() {
      return true;
    }
    
    public int size() {
      return RegularImmutableTable.this.size();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */