package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
  static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
  
  private final int[] cellColumnInRowIndices;
  
  private final int[] cellRowIndices;
  
  private final ImmutableMap<C, Map<R, V>> columnMap;
  
  private final ImmutableMap<R, Map<C, V>> rowMap;
  
  SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1) {
    ImmutableMap<R, Integer> immutableMap = Maps.indexMap(paramImmutableSet);
    LinkedHashMap<?, ?> linkedHashMap2 = Maps.newLinkedHashMap();
    Iterator iterator1 = paramImmutableSet.iterator();
    while (iterator1.hasNext())
      linkedHashMap2.put(iterator1.next(), new LinkedHashMap<Object, Object>()); 
    LinkedHashMap<?, ?> linkedHashMap1 = Maps.newLinkedHashMap();
    Iterator iterator2 = paramImmutableSet1.iterator();
    while (iterator2.hasNext())
      linkedHashMap1.put(iterator2.next(), new LinkedHashMap<Object, Object>()); 
    int[] arrayOfInt1 = new int[paramImmutableList.size()];
    int[] arrayOfInt2 = new int[paramImmutableList.size()];
    byte b = 0;
    while (b < paramImmutableList.size()) {
      Table.Cell cell = paramImmutableList.get(b);
      Object object = cell.getRowKey();
      iterator2 = (Iterator)cell.getColumnKey();
      cell = (Table.Cell)cell.getValue();
      arrayOfInt1[b] = ((Integer)immutableMap.get(object)).intValue();
      Map<Iterator, ?> map = (Map)linkedHashMap2.get(object);
      arrayOfInt2[b] = map.size();
      map = (Map<Iterator, ?>)map.put(iterator2, cell);
      if (map == null) {
        ((Map<Object, Table.Cell>)linkedHashMap1.get(iterator2)).put(object, cell);
        b++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Duplicate value for row=");
      stringBuilder.append(object);
      stringBuilder.append(", column=");
      stringBuilder.append(iterator2);
      stringBuilder.append(": ");
      stringBuilder.append(cell);
      stringBuilder.append(", ");
      stringBuilder.append(map);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    this.cellRowIndices = arrayOfInt1;
    this.cellColumnInRowIndices = arrayOfInt2;
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder<Object, Object>(linkedHashMap2.size());
    for (Map.Entry<?, ?> entry : linkedHashMap2.entrySet())
      builder.put(entry.getKey(), ImmutableMap.copyOf((Map<?, ?>)entry.getValue())); 
    this.rowMap = (ImmutableMap)builder.build();
    builder = new ImmutableMap.Builder<Object, Object>(linkedHashMap1.size());
    for (Map.Entry<?, ?> entry : linkedHashMap1.entrySet())
      builder.put(entry.getKey(), ImmutableMap.copyOf((Map<?, ?>)entry.getValue())); 
    this.columnMap = (ImmutableMap)builder.build();
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap() {
    return this.columnMap;
  }
  
  ImmutableTable.SerializedForm createSerializedForm() {
    ImmutableMap<C, Integer> immutableMap = Maps.indexMap(columnKeySet());
    int[] arrayOfInt = new int[cellSet().size()];
    Iterator iterator = cellSet().iterator();
    for (byte b = 0; iterator.hasNext(); b++)
      arrayOfInt[b] = ((Integer)immutableMap.get(((Table.Cell)iterator.next()).getColumnKey())).intValue(); 
    return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, arrayOfInt);
  }
  
  Table.Cell<R, C, V> getCell(int paramInt) {
    int i = this.cellRowIndices[paramInt];
    Map.Entry entry1 = this.rowMap.entrySet().asList().get(i);
    ImmutableMap immutableMap = (ImmutableMap)entry1.getValue();
    paramInt = this.cellColumnInRowIndices[paramInt];
    Map.Entry entry2 = immutableMap.entrySet().asList().get(paramInt);
    return cellOf((R)entry1.getKey(), (C)entry2.getKey(), (V)entry2.getValue());
  }
  
  V getValue(int paramInt) {
    int i = this.cellRowIndices[paramInt];
    ImmutableMap immutableMap = this.rowMap.values().asList().get(i);
    paramInt = this.cellColumnInRowIndices[paramInt];
    return immutableMap.values().asList().get(paramInt);
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap() {
    return this.rowMap;
  }
  
  public int size() {
    return this.cellRowIndices.length;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SparseImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */