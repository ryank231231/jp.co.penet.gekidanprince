package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
  final C singleColumnKey;
  
  final R singleRowKey;
  
  final V singleValue;
  
  SingletonImmutableTable(Table.Cell<R, C, V> paramCell) {
    this(paramCell.getRowKey(), paramCell.getColumnKey(), paramCell.getValue());
  }
  
  SingletonImmutableTable(R paramR, C paramC, V paramV) {
    this.singleRowKey = (R)Preconditions.checkNotNull(paramR);
    this.singleColumnKey = (C)Preconditions.checkNotNull(paramC);
    this.singleValue = (V)Preconditions.checkNotNull(paramV);
  }
  
  public ImmutableMap<R, V> column(C paramC) {
    ImmutableMap<?, ?> immutableMap;
    Preconditions.checkNotNull(paramC);
    if (containsColumn(paramC)) {
      immutableMap = ImmutableMap.of(this.singleRowKey, this.singleValue);
    } else {
      immutableMap = ImmutableMap.of();
    } 
    return (ImmutableMap)immutableMap;
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap() {
    return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, this.singleValue));
  }
  
  ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
    return ImmutableSet.of(cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
  }
  
  ImmutableTable.SerializedForm createSerializedForm() {
    return ImmutableTable.SerializedForm.create(this, new int[] { 0 }, new int[] { 0 });
  }
  
  ImmutableCollection<V> createValues() {
    return ImmutableSet.of(this.singleValue);
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap() {
    return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, this.singleValue));
  }
  
  public int size() {
    return 1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SingletonImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */