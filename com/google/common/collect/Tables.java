package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public final class Tables {
  private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> UNMODIFIABLE_WRAPPER = new Function<Map<Object, Object>, Map<Object, Object>>() {
      public Map<Object, Object> apply(Map<Object, Object> param1Map) {
        return Collections.unmodifiableMap(param1Map);
      }
    };
  
  static boolean equalsImpl(Table<?, ?, ?> paramTable, @Nullable Object paramObject) {
    if (paramObject == paramTable)
      return true; 
    if (paramObject instanceof Table) {
      paramObject = paramObject;
      return paramTable.cellSet().equals(paramObject.cellSet());
    } 
    return false;
  }
  
  public static <R, C, V> Table.Cell<R, C, V> immutableCell(@Nullable R paramR, @Nullable C paramC, @Nullable V paramV) {
    return new ImmutableCell<R, C, V>(paramR, paramC, paramV);
  }
  
  @Beta
  public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> paramMap, Supplier<? extends Map<C, V>> paramSupplier) {
    Preconditions.checkArgument(paramMap.isEmpty());
    Preconditions.checkNotNull(paramSupplier);
    return new StandardTable<R, C, V>(paramMap, paramSupplier);
  }
  
  @Beta
  public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> paramTable, Function<? super V1, V2> paramFunction) {
    return new TransformedTable<R, C, V1, V2>(paramTable, paramFunction);
  }
  
  public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> paramTable) {
    if (paramTable instanceof TransposeTable) {
      paramTable = ((TransposeTable)paramTable).original;
    } else {
      paramTable = new TransposeTable<R, C, V>(paramTable);
    } 
    return paramTable;
  }
  
  @Beta
  public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> paramRowSortedTable) {
    return new UnmodifiableRowSortedMap<R, C, V>(paramRowSortedTable);
  }
  
  public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> paramTable) {
    return new UnmodifiableTable<R, C, V>(paramTable);
  }
  
  private static <K, V> Function<Map<K, V>, Map<K, V>> unmodifiableWrapper() {
    return (Function)UNMODIFIABLE_WRAPPER;
  }
  
  static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
    public boolean equals(Object param1Object) {
      boolean bool = true;
      if (param1Object == this)
        return true; 
      if (param1Object instanceof Table.Cell) {
        param1Object = param1Object;
        if (!Objects.equal(getRowKey(), param1Object.getRowKey()) || !Objects.equal(getColumnKey(), param1Object.getColumnKey()) || !Objects.equal(getValue(), param1Object.getValue()))
          bool = false; 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { getRowKey(), getColumnKey(), getValue() });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(getRowKey());
      stringBuilder.append(",");
      stringBuilder.append(getColumnKey());
      stringBuilder.append(")=");
      stringBuilder.append(getValue());
      return stringBuilder.toString();
    }
  }
  
  static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final C columnKey;
    
    private final R rowKey;
    
    private final V value;
    
    ImmutableCell(@Nullable R param1R, @Nullable C param1C, @Nullable V param1V) {
      this.rowKey = param1R;
      this.columnKey = param1C;
      this.value = param1V;
    }
    
    public C getColumnKey() {
      return this.columnKey;
    }
    
    public R getRowKey() {
      return this.rowKey;
    }
    
    public V getValue() {
      return this.value;
    }
  }
  
  private static class TransformedTable<R, C, V1, V2> extends AbstractTable<R, C, V2> {
    final Table<R, C, V1> fromTable;
    
    final Function<? super V1, V2> function;
    
    TransformedTable(Table<R, C, V1> param1Table, Function<? super V1, V2> param1Function) {
      this.fromTable = (Table<R, C, V1>)Preconditions.checkNotNull(param1Table);
      this.function = (Function<? super V1, V2>)Preconditions.checkNotNull(param1Function);
    }
    
    Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> cellFunction() {
      return new Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>>() {
          public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> param2Cell) {
            return Tables.immutableCell(param2Cell.getRowKey(), param2Cell.getColumnKey(), (V2)Tables.TransformedTable.this.function.apply(param2Cell.getValue()));
          }
        };
    }
    
    Iterator<Table.Cell<R, C, V2>> cellIterator() {
      return Iterators.transform(this.fromTable.cellSet().iterator(), cellFunction());
    }
    
    public void clear() {
      this.fromTable.clear();
    }
    
    public Map<R, V2> column(C param1C) {
      return Maps.transformValues(this.fromTable.column(param1C), this.function);
    }
    
    public Set<C> columnKeySet() {
      return this.fromTable.columnKeySet();
    }
    
    public Map<C, Map<R, V2>> columnMap() {
      Function<Map<R, V1>, Map<R, V2>> function = new Function<Map<R, V1>, Map<R, V2>>() {
          public Map<R, V2> apply(Map<R, V1> param2Map) {
            return Maps.transformValues(param2Map, Tables.TransformedTable.this.function);
          }
        };
      return Maps.transformValues(this.fromTable.columnMap(), function);
    }
    
    public boolean contains(Object param1Object1, Object param1Object2) {
      return this.fromTable.contains(param1Object1, param1Object2);
    }
    
    Collection<V2> createValues() {
      return Collections2.transform(this.fromTable.values(), this.function);
    }
    
    public V2 get(Object param1Object1, Object param1Object2) {
      if (contains(param1Object1, param1Object2)) {
        param1Object1 = this.function.apply(this.fromTable.get(param1Object1, param1Object2));
      } else {
        param1Object1 = null;
      } 
      return (V2)param1Object1;
    }
    
    public V2 put(R param1R, C param1C, V2 param1V2) {
      throw new UnsupportedOperationException();
    }
    
    public void putAll(Table<? extends R, ? extends C, ? extends V2> param1Table) {
      throw new UnsupportedOperationException();
    }
    
    public V2 remove(Object param1Object1, Object param1Object2) {
      if (contains(param1Object1, param1Object2)) {
        param1Object1 = this.function.apply(this.fromTable.remove(param1Object1, param1Object2));
      } else {
        param1Object1 = null;
      } 
      return (V2)param1Object1;
    }
    
    public Map<C, V2> row(R param1R) {
      return Maps.transformValues(this.fromTable.row(param1R), this.function);
    }
    
    public Set<R> rowKeySet() {
      return this.fromTable.rowKeySet();
    }
    
    public Map<R, Map<C, V2>> rowMap() {
      Function<Map<C, V1>, Map<C, V2>> function = new Function<Map<C, V1>, Map<C, V2>>() {
          public Map<C, V2> apply(Map<C, V1> param2Map) {
            return Maps.transformValues(param2Map, Tables.TransformedTable.this.function);
          }
        };
      return Maps.transformValues(this.fromTable.rowMap(), function);
    }
    
    public int size() {
      return this.fromTable.size();
    }
  }
  
  class null implements Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> {
    public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> param1Cell) {
      return Tables.immutableCell(param1Cell.getRowKey(), param1Cell.getColumnKey(), (V2)this.this$0.function.apply(param1Cell.getValue()));
    }
  }
  
  class null implements Function<Map<C, V1>, Map<C, V2>> {
    public Map<C, V2> apply(Map<C, V1> param1Map) {
      return Maps.transformValues(param1Map, this.this$0.function);
    }
  }
  
  class null implements Function<Map<R, V1>, Map<R, V2>> {
    public Map<R, V2> apply(Map<R, V1> param1Map) {
      return Maps.transformValues(param1Map, this.this$0.function);
    }
  }
  
  private static class TransposeTable<C, R, V> extends AbstractTable<C, R, V> {
    private static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> TRANSPOSE_CELL = new Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>>() {
        public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> param2Cell) {
          return Tables.immutableCell(param2Cell.getColumnKey(), param2Cell.getRowKey(), param2Cell.getValue());
        }
      };
    
    final Table<R, C, V> original;
    
    TransposeTable(Table<R, C, V> param1Table) {
      this.original = (Table<R, C, V>)Preconditions.checkNotNull(param1Table);
    }
    
    Iterator<Table.Cell<C, R, V>> cellIterator() {
      return (Iterator)Iterators.transform(this.original.cellSet().iterator(), TRANSPOSE_CELL);
    }
    
    public void clear() {
      this.original.clear();
    }
    
    public Map<C, V> column(R param1R) {
      return this.original.row(param1R);
    }
    
    public Set<R> columnKeySet() {
      return this.original.rowKeySet();
    }
    
    public Map<R, Map<C, V>> columnMap() {
      return this.original.rowMap();
    }
    
    public boolean contains(@Nullable Object param1Object1, @Nullable Object param1Object2) {
      return this.original.contains(param1Object2, param1Object1);
    }
    
    public boolean containsColumn(@Nullable Object param1Object) {
      return this.original.containsRow(param1Object);
    }
    
    public boolean containsRow(@Nullable Object param1Object) {
      return this.original.containsColumn(param1Object);
    }
    
    public boolean containsValue(@Nullable Object param1Object) {
      return this.original.containsValue(param1Object);
    }
    
    public V get(@Nullable Object param1Object1, @Nullable Object param1Object2) {
      return this.original.get(param1Object2, param1Object1);
    }
    
    public V put(C param1C, R param1R, V param1V) {
      return this.original.put(param1R, param1C, param1V);
    }
    
    public void putAll(Table<? extends C, ? extends R, ? extends V> param1Table) {
      this.original.putAll(Tables.transpose(param1Table));
    }
    
    public V remove(@Nullable Object param1Object1, @Nullable Object param1Object2) {
      return this.original.remove(param1Object2, param1Object1);
    }
    
    public Map<R, V> row(C param1C) {
      return this.original.column(param1C);
    }
    
    public Set<C> rowKeySet() {
      return this.original.columnKeySet();
    }
    
    public Map<C, Map<R, V>> rowMap() {
      return this.original.columnMap();
    }
    
    public int size() {
      return this.original.size();
    }
    
    public Collection<V> values() {
      return this.original.values();
    }
  }
  
  static final class null implements Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> {
    public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> param1Cell) {
      return Tables.immutableCell(param1Cell.getColumnKey(), param1Cell.getRowKey(), param1Cell.getValue());
    }
  }
  
  static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0L;
    
    public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> param1RowSortedTable) {
      super(param1RowSortedTable);
    }
    
    protected RowSortedTable<R, C, V> delegate() {
      return (RowSortedTable<R, C, V>)super.delegate();
    }
    
    public SortedSet<R> rowKeySet() {
      return Collections.unmodifiableSortedSet(delegate().rowKeySet());
    }
    
    public SortedMap<R, Map<C, V>> rowMap() {
      Function<?, ? extends Map<C, V>> function = Tables.unmodifiableWrapper();
      return Collections.unmodifiableSortedMap(Maps.transformValues(delegate().rowMap(), function));
    }
  }
  
  private static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final Table<? extends R, ? extends C, ? extends V> delegate;
    
    UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> param1Table) {
      this.delegate = (Table<? extends R, ? extends C, ? extends V>)Preconditions.checkNotNull(param1Table);
    }
    
    public Set<Table.Cell<R, C, V>> cellSet() {
      return Collections.unmodifiableSet(super.cellSet());
    }
    
    public void clear() {
      throw new UnsupportedOperationException();
    }
    
    public Map<R, V> column(@Nullable C param1C) {
      return Collections.unmodifiableMap(super.column(param1C));
    }
    
    public Set<C> columnKeySet() {
      return Collections.unmodifiableSet(super.columnKeySet());
    }
    
    public Map<C, Map<R, V>> columnMap() {
      Function<?, ? extends Map<R, V>> function = Tables.unmodifiableWrapper();
      return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), function));
    }
    
    protected Table<R, C, V> delegate() {
      return (Table)this.delegate;
    }
    
    public V put(@Nullable R param1R, @Nullable C param1C, @Nullable V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public void putAll(Table<? extends R, ? extends C, ? extends V> param1Table) {
      throw new UnsupportedOperationException();
    }
    
    public V remove(@Nullable Object param1Object1, @Nullable Object param1Object2) {
      throw new UnsupportedOperationException();
    }
    
    public Map<C, V> row(@Nullable R param1R) {
      return Collections.unmodifiableMap(super.row(param1R));
    }
    
    public Set<R> rowKeySet() {
      return Collections.unmodifiableSet(super.rowKeySet());
    }
    
    public Map<R, Map<C, V>> rowMap() {
      Function<?, ? extends Map<C, V>> function = Tables.unmodifiableWrapper();
      return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), function));
    }
    
    public Collection<V> values() {
      return Collections.unmodifiableCollection(super.values());
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Tables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */