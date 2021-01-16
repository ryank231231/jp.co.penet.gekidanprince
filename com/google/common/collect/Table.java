package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface Table<R, C, V> {
  Set<Cell<R, C, V>> cellSet();
  
  void clear();
  
  Map<R, V> column(C paramC);
  
  Set<C> columnKeySet();
  
  Map<C, Map<R, V>> columnMap();
  
  boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  boolean containsColumn(@Nullable Object paramObject);
  
  boolean containsRow(@Nullable Object paramObject);
  
  boolean containsValue(@Nullable Object paramObject);
  
  boolean equals(@Nullable Object paramObject);
  
  V get(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  int hashCode();
  
  boolean isEmpty();
  
  @Nullable
  @CanIgnoreReturnValue
  V put(R paramR, C paramC, V paramV);
  
  void putAll(Table<? extends R, ? extends C, ? extends V> paramTable);
  
  @Nullable
  @CanIgnoreReturnValue
  V remove(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  Map<C, V> row(R paramR);
  
  Set<R> rowKeySet();
  
  Map<R, Map<C, V>> rowMap();
  
  int size();
  
  Collection<V> values();
  
  public static interface Cell<R, C, V> {
    boolean equals(@Nullable Object param1Object);
    
    @Nullable
    C getColumnKey();
    
    @Nullable
    R getRowKey();
    
    @Nullable
    V getValue();
    
    int hashCode();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Table.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */