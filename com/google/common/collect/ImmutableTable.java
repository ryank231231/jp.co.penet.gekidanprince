package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
  public static <R, C, V> Builder<R, C, V> builder() {
    return new Builder<R, C, V>();
  }
  
  static <R, C, V> Table.Cell<R, C, V> cellOf(R paramR, C paramC, V paramV) {
    return Tables.immutableCell((R)Preconditions.checkNotNull(paramR), (C)Preconditions.checkNotNull(paramC), (V)Preconditions.checkNotNull(paramV));
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> paramTable) {
    Iterator iterator;
    Table.Cell<Table.Cell> cell;
    ImmutableSet.Builder<Table.Cell<R, C, V>> builder;
    if (paramTable instanceof ImmutableTable)
      return (ImmutableTable)paramTable; 
    int i = paramTable.size();
    switch (i) {
      default:
        builder = new ImmutableSet.Builder(i);
        iterator = paramTable.cellSet().iterator();
        break;
      case 1:
        cell = Iterables.<Table.Cell>getOnlyElement(iterator.cellSet());
        return of((R)cell.getRowKey(), (C)cell.getColumnKey(), (V)cell.getValue());
      case 0:
        return of();
    } 
    while (cell.hasNext()) {
      Table.Cell cell1 = cell.next();
      builder.add(cellOf(cell1.getRowKey(), cell1.getColumnKey(), cell1.getValue()));
    } 
    return RegularImmutableTable.forCells(builder.build());
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> of() {
    return (ImmutableTable)SparseImmutableTable.EMPTY;
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> of(R paramR, C paramC, V paramV) {
    return new SingletonImmutableTable<R, C, V>(paramR, paramC, paramV);
  }
  
  final UnmodifiableIterator<Table.Cell<R, C, V>> cellIterator() {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
    return (ImmutableSet<Table.Cell<R, C, V>>)super.cellSet();
  }
  
  @Deprecated
  public final void clear() {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<R, V> column(C paramC) {
    Preconditions.checkNotNull(paramC);
    return (ImmutableMap<R, V>)MoreObjects.firstNonNull(columnMap().get(paramC), ImmutableMap.of());
  }
  
  public ImmutableSet<C> columnKeySet() {
    return columnMap().keySet();
  }
  
  public abstract ImmutableMap<C, Map<R, V>> columnMap();
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    boolean bool;
    if (get(paramObject1, paramObject2) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    return values().contains(paramObject);
  }
  
  abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();
  
  abstract SerializedForm createSerializedForm();
  
  abstract ImmutableCollection<V> createValues();
  
  @Deprecated
  @CanIgnoreReturnValue
  public final V put(R paramR, C paramC, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Table<? extends R, ? extends C, ? extends V> paramTable) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final V remove(Object paramObject1, Object paramObject2) {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<C, V> row(R paramR) {
    Preconditions.checkNotNull(paramR);
    return (ImmutableMap<C, V>)MoreObjects.firstNonNull(rowMap().get(paramR), ImmutableMap.of());
  }
  
  public ImmutableSet<R> rowKeySet() {
    return rowMap().keySet();
  }
  
  public abstract ImmutableMap<R, Map<C, V>> rowMap();
  
  public ImmutableCollection<V> values() {
    return (ImmutableCollection<V>)super.values();
  }
  
  final Iterator<V> valuesIterator() {
    throw new AssertionError("should never be called");
  }
  
  final Object writeReplace() {
    return createSerializedForm();
  }
  
  public static final class Builder<R, C, V> {
    private final List<Table.Cell<R, C, V>> cells = Lists.newArrayList();
    
    private Comparator<? super C> columnComparator;
    
    private Comparator<? super R> rowComparator;
    
    public ImmutableTable<R, C, V> build() {
      switch (this.cells.size()) {
        default:
          return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
        case 1:
          return new SingletonImmutableTable<R, C, V>(Iterables.<Table.Cell<R, C, V>>getOnlyElement(this.cells));
        case 0:
          break;
      } 
      return ImmutableTable.of();
    }
    
    @CanIgnoreReturnValue
    public Builder<R, C, V> orderColumnsBy(Comparator<? super C> param1Comparator) {
      this.columnComparator = (Comparator<? super C>)Preconditions.checkNotNull(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<R, C, V> orderRowsBy(Comparator<? super R> param1Comparator) {
      this.rowComparator = (Comparator<? super R>)Preconditions.checkNotNull(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> param1Cell) {
      if (param1Cell instanceof Tables.ImmutableCell) {
        Preconditions.checkNotNull(param1Cell.getRowKey());
        Preconditions.checkNotNull(param1Cell.getColumnKey());
        Preconditions.checkNotNull(param1Cell.getValue());
        this.cells.add(param1Cell);
      } else {
        put(param1Cell.getRowKey(), param1Cell.getColumnKey(), param1Cell.getValue());
      } 
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<R, C, V> put(R param1R, C param1C, V param1V) {
      this.cells.add(ImmutableTable.cellOf(param1R, param1C, param1V));
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> param1Table) {
      Iterator<Table.Cell<? extends R, ? extends C, ? extends V>> iterator = param1Table.cellSet().iterator();
      while (iterator.hasNext())
        put(iterator.next()); 
      return this;
    }
  }
  
  static final class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final int[] cellColumnIndices;
    
    private final int[] cellRowIndices;
    
    private final Object[] cellValues;
    
    private final Object[] columnKeys;
    
    private final Object[] rowKeys;
    
    private SerializedForm(Object[] param1ArrayOfObject1, Object[] param1ArrayOfObject2, Object[] param1ArrayOfObject3, int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      this.rowKeys = param1ArrayOfObject1;
      this.columnKeys = param1ArrayOfObject2;
      this.cellValues = param1ArrayOfObject3;
      this.cellRowIndices = param1ArrayOfint1;
      this.cellColumnIndices = param1ArrayOfint2;
    }
    
    static SerializedForm create(ImmutableTable<?, ?, ?> param1ImmutableTable, int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      return new SerializedForm(param1ImmutableTable.rowKeySet().toArray(), param1ImmutableTable.columnKeySet().toArray(), param1ImmutableTable.values().toArray(), param1ArrayOfint1, param1ArrayOfint2);
    }
    
    Object readResolve() {
      Object[] arrayOfObject = this.cellValues;
      if (arrayOfObject.length == 0)
        return ImmutableTable.of(); 
      int i = arrayOfObject.length;
      byte b = 0;
      if (i == 1)
        return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], arrayOfObject[0]); 
      ImmutableList.Builder<Table.Cell<?, ?, ?>> builder = new ImmutableList.Builder(arrayOfObject.length);
      while (true) {
        Object[] arrayOfObject1 = this.cellValues;
        if (b < arrayOfObject1.length) {
          builder.add(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[b]], this.columnKeys[this.cellColumnIndices[b]], arrayOfObject1[b]));
          b++;
          continue;
        } 
        return RegularImmutableTable.forOrderedComponents(builder.build(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */