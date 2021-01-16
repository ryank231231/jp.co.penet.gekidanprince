package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
  private static final long serialVersionUID = 0L;
  
  HashBasedTable(Map<R, Map<C, V>> paramMap, Factory<C, V> paramFactory) {
    super(paramMap, paramFactory);
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create() {
    return new HashBasedTable<R, C, V>(new LinkedHashMap<R, Map<C, V>>(), new Factory<C, V>(0));
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create(int paramInt1, int paramInt2) {
    CollectPreconditions.checkNonnegative(paramInt2, "expectedCellsPerRow");
    return new HashBasedTable<R, C, V>(Maps.newLinkedHashMapWithExpectedSize(paramInt1), new Factory<C, V>(paramInt2));
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create(Table<? extends R, ? extends C, ? extends V> paramTable) {
    HashBasedTable<?, ?, ?> hashBasedTable = create();
    hashBasedTable.putAll(paramTable);
    return (HashBasedTable)hashBasedTable;
  }
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    return super.contains(paramObject1, paramObject2);
  }
  
  public boolean containsColumn(@Nullable Object paramObject) {
    return super.containsColumn(paramObject);
  }
  
  public boolean containsRow(@Nullable Object paramObject) {
    return super.containsRow(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    return super.containsValue(paramObject);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return super.equals(paramObject);
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    return super.get(paramObject1, paramObject2);
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    return super.remove(paramObject1, paramObject2);
  }
  
  private static class Factory<C, V> implements Supplier<Map<C, V>>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final int expectedSize;
    
    Factory(int param1Int) {
      this.expectedSize = param1Int;
    }
    
    public Map<C, V> get() {
      return Maps.newLinkedHashMapWithExpectedSize(this.expectedSize);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\HashBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */