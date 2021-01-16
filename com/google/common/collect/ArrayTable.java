package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated = true)
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  private final V[][] array;
  
  private final ImmutableMap<C, Integer> columnKeyToIndex;
  
  private final ImmutableList<C> columnList;
  
  private transient ColumnMap columnMap;
  
  private final ImmutableMap<R, Integer> rowKeyToIndex;
  
  private final ImmutableList<R> rowList;
  
  private transient RowMap rowMap;
  
  private ArrayTable(ArrayTable<R, C, V> paramArrayTable) {
    this.rowList = paramArrayTable.rowList;
    this.columnList = paramArrayTable.columnList;
    this.rowKeyToIndex = paramArrayTable.rowKeyToIndex;
    this.columnKeyToIndex = paramArrayTable.columnKeyToIndex;
    Object[][] arrayOfObject = new Object[this.rowList.size()][this.columnList.size()];
    this.array = (V[][])arrayOfObject;
    eraseAll();
    for (byte b = 0; b < this.rowList.size(); b++) {
      V[][] arrayOfV = paramArrayTable.array;
      System.arraycopy(arrayOfV[b], 0, arrayOfObject[b], 0, (arrayOfV[b]).length);
    } 
  }
  
  private ArrayTable(Table<R, C, V> paramTable) {
    this(paramTable.rowKeySet(), paramTable.columnKeySet());
    putAll(paramTable);
  }
  
  private ArrayTable(Iterable<? extends R> paramIterable, Iterable<? extends C> paramIterable1) {
    this.rowList = ImmutableList.copyOf(paramIterable);
    this.columnList = ImmutableList.copyOf(paramIterable1);
    Preconditions.checkArgument(this.rowList.isEmpty() ^ true);
    Preconditions.checkArgument(this.columnList.isEmpty() ^ true);
    this.rowKeyToIndex = Maps.indexMap(this.rowList);
    this.columnKeyToIndex = Maps.indexMap(this.columnList);
    this.array = (V[][])new Object[this.rowList.size()][this.columnList.size()];
    eraseAll();
  }
  
  public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> paramTable) {
    if (paramTable instanceof ArrayTable) {
      paramTable = new ArrayTable<R, C, V>((ArrayTable<R, C, V>)paramTable);
    } else {
      paramTable = new ArrayTable<R, C, V>(paramTable);
    } 
    return (ArrayTable<R, C, V>)paramTable;
  }
  
  public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> paramIterable, Iterable<? extends C> paramIterable1) {
    return new ArrayTable<R, C, V>(paramIterable, paramIterable1);
  }
  
  public V at(int paramInt1, int paramInt2) {
    Preconditions.checkElementIndex(paramInt1, this.rowList.size());
    Preconditions.checkElementIndex(paramInt2, this.columnList.size());
    return this.array[paramInt1][paramInt2];
  }
  
  Iterator<Table.Cell<R, C, V>> cellIterator() {
    return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) {
        protected Table.Cell<R, C, V> get(final int index) {
          return new Tables.AbstractCell<R, C, V>() {
              final int columnIndex = index % ArrayTable.this.columnList.size();
              
              final int rowIndex = index / ArrayTable.this.columnList.size();
              
              public C getColumnKey() {
                return (C)ArrayTable.this.columnList.get(this.columnIndex);
              }
              
              public R getRowKey() {
                return (R)ArrayTable.this.rowList.get(this.rowIndex);
              }
              
              public V getValue() {
                return (V)ArrayTable.this.at(this.rowIndex, this.columnIndex);
              }
            };
        }
      };
  }
  
  public Set<Table.Cell<R, C, V>> cellSet() {
    return super.cellSet();
  }
  
  @Deprecated
  public void clear() {
    throw new UnsupportedOperationException();
  }
  
  public Map<R, V> column(C paramC) {
    ImmutableMap<?, ?> immutableMap;
    Column column;
    Preconditions.checkNotNull(paramC);
    Integer integer = this.columnKeyToIndex.get(paramC);
    if (integer == null) {
      immutableMap = ImmutableMap.of();
    } else {
      column = new Column(immutableMap.intValue());
    } 
    return column;
  }
  
  public ImmutableList<C> columnKeyList() {
    return this.columnList;
  }
  
  public ImmutableSet<C> columnKeySet() {
    return this.columnKeyToIndex.keySet();
  }
  
  public Map<C, Map<R, V>> columnMap() {
    ColumnMap columnMap1 = this.columnMap;
    ColumnMap columnMap2 = columnMap1;
    if (columnMap1 == null) {
      columnMap2 = new ColumnMap();
      this.columnMap = columnMap2;
    } 
    return columnMap2;
  }
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    boolean bool;
    if (containsRow(paramObject1) && containsColumn(paramObject2)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsColumn(@Nullable Object paramObject) {
    return this.columnKeyToIndex.containsKey(paramObject);
  }
  
  public boolean containsRow(@Nullable Object paramObject) {
    return this.rowKeyToIndex.containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    for (V[] arrayOfV : this.array) {
      int i = arrayOfV.length;
      for (byte b = 0; b < i; b++) {
        if (Objects.equal(paramObject, arrayOfV[b]))
          return true; 
      } 
    } 
    return false;
  }
  
  @CanIgnoreReturnValue
  public V erase(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    paramObject1 = this.rowKeyToIndex.get(paramObject1);
    paramObject2 = this.columnKeyToIndex.get(paramObject2);
    return (paramObject1 == null || paramObject2 == null) ? null : set(paramObject1.intValue(), paramObject2.intValue(), null);
  }
  
  public void eraseAll() {
    V[][] arrayOfV = this.array;
    int i = arrayOfV.length;
    for (byte b = 0; b < i; b++)
      Arrays.fill((Object[])arrayOfV[b], (Object)null); 
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    paramObject1 = this.rowKeyToIndex.get(paramObject1);
    paramObject2 = this.columnKeyToIndex.get(paramObject2);
    return (paramObject1 == null || paramObject2 == null) ? null : at(paramObject1.intValue(), paramObject2.intValue());
  }
  
  public boolean isEmpty() {
    return false;
  }
  
  @CanIgnoreReturnValue
  public V put(R paramR, C paramC, @Nullable V paramV) {
    boolean bool2;
    Preconditions.checkNotNull(paramR);
    Preconditions.checkNotNull(paramC);
    Integer integer2 = this.rowKeyToIndex.get(paramR);
    boolean bool1 = true;
    if (integer2 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Row %s not in %s", paramR, this.rowList);
    Integer integer1 = this.columnKeyToIndex.get(paramC);
    if (integer1 != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Column %s not in %s", paramC, this.columnList);
    return set(integer2.intValue(), integer1.intValue(), paramV);
  }
  
  public void putAll(Table<? extends R, ? extends C, ? extends V> paramTable) {
    super.putAll(paramTable);
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public V remove(Object paramObject1, Object paramObject2) {
    throw new UnsupportedOperationException();
  }
  
  public Map<C, V> row(R paramR) {
    ImmutableMap<?, ?> immutableMap;
    Row row;
    Preconditions.checkNotNull(paramR);
    Integer integer = this.rowKeyToIndex.get(paramR);
    if (integer == null) {
      immutableMap = ImmutableMap.of();
    } else {
      row = new Row(immutableMap.intValue());
    } 
    return row;
  }
  
  public ImmutableList<R> rowKeyList() {
    return this.rowList;
  }
  
  public ImmutableSet<R> rowKeySet() {
    return this.rowKeyToIndex.keySet();
  }
  
  public Map<R, Map<C, V>> rowMap() {
    RowMap rowMap1 = this.rowMap;
    RowMap rowMap2 = rowMap1;
    if (rowMap1 == null) {
      rowMap2 = new RowMap();
      this.rowMap = rowMap2;
    } 
    return rowMap2;
  }
  
  @CanIgnoreReturnValue
  public V set(int paramInt1, int paramInt2, @Nullable V paramV) {
    Preconditions.checkElementIndex(paramInt1, this.rowList.size());
    Preconditions.checkElementIndex(paramInt2, this.columnList.size());
    V[][] arrayOfV = this.array;
    V v = arrayOfV[paramInt1][paramInt2];
    arrayOfV[paramInt1][paramInt2] = paramV;
    return v;
  }
  
  public int size() {
    return this.rowList.size() * this.columnList.size();
  }
  
  @GwtIncompatible
  public V[][] toArray(Class<V> paramClass) {
    Object[][] arrayOfObject = (Object[][])Array.newInstance(paramClass, new int[] { this.rowList.size(), this.columnList.size() });
    for (byte b = 0; b < this.rowList.size(); b++) {
      V[][] arrayOfV = this.array;
      System.arraycopy(arrayOfV[b], 0, arrayOfObject[b], 0, (arrayOfV[b]).length);
    } 
    return (V[][])arrayOfObject;
  }
  
  public Collection<V> values() {
    return super.values();
  }
  
  private static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
    private final ImmutableMap<K, Integer> keyIndex;
    
    private ArrayMap(ImmutableMap<K, Integer> param1ImmutableMap) {
      this.keyIndex = param1ImmutableMap;
    }
    
    public void clear() {
      throw new UnsupportedOperationException();
    }
    
    public boolean containsKey(@Nullable Object param1Object) {
      return this.keyIndex.containsKey(param1Object);
    }
    
    Iterator<Map.Entry<K, V>> entryIterator() {
      return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) {
          protected Map.Entry<K, V> get(final int index) {
            return new AbstractMapEntry<K, V>() {
                public K getKey() {
                  return (K)ArrayTable.ArrayMap.this.getKey(index);
                }
                
                public V getValue() {
                  return (V)ArrayTable.ArrayMap.this.getValue(index);
                }
                
                public V setValue(V param3V) {
                  return (V)ArrayTable.ArrayMap.this.setValue(index, param3V);
                }
              };
          }
        };
    }
    
    public V get(@Nullable Object param1Object) {
      param1Object = this.keyIndex.get(param1Object);
      return (param1Object == null) ? null : getValue(param1Object.intValue());
    }
    
    K getKey(int param1Int) {
      return this.keyIndex.keySet().asList().get(param1Int);
    }
    
    abstract String getKeyRole();
    
    @Nullable
    abstract V getValue(int param1Int);
    
    public boolean isEmpty() {
      return this.keyIndex.isEmpty();
    }
    
    public Set<K> keySet() {
      return this.keyIndex.keySet();
    }
    
    public V put(K param1K, V param1V) {
      Integer integer = this.keyIndex.get(param1K);
      if (integer != null)
        return setValue(integer.intValue(), param1V); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getKeyRole());
      stringBuilder.append(" ");
      stringBuilder.append(param1K);
      stringBuilder.append(" not in ");
      stringBuilder.append(this.keyIndex.keySet());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public V remove(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    @Nullable
    abstract V setValue(int param1Int, V param1V);
    
    public int size() {
      return this.keyIndex.size();
    }
  }
  
  class null extends AbstractIndexedListIterator<Map.Entry<K, V>> {
    null(int param1Int) {
      super(param1Int);
    }
    
    protected Map.Entry<K, V> get(final int index) {
      return new AbstractMapEntry<K, V>() {
          public K getKey() {
            return (K)this.this$1.this$0.getKey(index);
          }
          
          public V getValue() {
            return (V)this.this$1.this$0.getValue(index);
          }
          
          public V setValue(V param3V) {
            return (V)this.this$1.this$0.setValue(index, param3V);
          }
        };
    }
  }
  
  class null extends AbstractMapEntry<K, V> {
    public K getKey() {
      return (K)this.this$1.this$0.getKey(index);
    }
    
    public V getValue() {
      return (V)this.this$1.this$0.getValue(index);
    }
    
    public V setValue(V param1V) {
      return (V)this.this$1.this$0.setValue(index, param1V);
    }
  }
  
  private class Column extends ArrayMap<R, V> {
    final int columnIndex;
    
    Column(int param1Int) {
      super(ArrayTable.this.rowKeyToIndex);
      this.columnIndex = param1Int;
    }
    
    String getKeyRole() {
      return "Row";
    }
    
    V getValue(int param1Int) {
      return (V)ArrayTable.this.at(param1Int, this.columnIndex);
    }
    
    V setValue(int param1Int, V param1V) {
      return (V)ArrayTable.this.set(param1Int, this.columnIndex, param1V);
    }
  }
  
  private class ColumnMap extends ArrayMap<C, Map<R, V>> {
    private ColumnMap() {
      super(ArrayTable.this.columnKeyToIndex);
    }
    
    String getKeyRole() {
      return "Column";
    }
    
    Map<R, V> getValue(int param1Int) {
      return new ArrayTable.Column(param1Int);
    }
    
    public Map<R, V> put(C param1C, Map<R, V> param1Map) {
      throw new UnsupportedOperationException();
    }
    
    Map<R, V> setValue(int param1Int, Map<R, V> param1Map) {
      throw new UnsupportedOperationException();
    }
  }
  
  private class Row extends ArrayMap<C, V> {
    final int rowIndex;
    
    Row(int param1Int) {
      super(ArrayTable.this.columnKeyToIndex);
      this.rowIndex = param1Int;
    }
    
    String getKeyRole() {
      return "Column";
    }
    
    V getValue(int param1Int) {
      return (V)ArrayTable.this.at(this.rowIndex, param1Int);
    }
    
    V setValue(int param1Int, V param1V) {
      return (V)ArrayTable.this.set(this.rowIndex, param1Int, param1V);
    }
  }
  
  private class RowMap extends ArrayMap<R, Map<C, V>> {
    private RowMap() {
      super(ArrayTable.this.rowKeyToIndex);
    }
    
    String getKeyRole() {
      return "Row";
    }
    
    Map<C, V> getValue(int param1Int) {
      return new ArrayTable.Row(param1Int);
    }
    
    public Map<C, V> put(R param1R, Map<C, V> param1Map) {
      throw new UnsupportedOperationException();
    }
    
    Map<C, V> setValue(int param1Int, Map<C, V> param1Map) {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ArrayTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */