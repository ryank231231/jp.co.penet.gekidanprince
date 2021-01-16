package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public interface MapDifference<K, V> {
  boolean areEqual();
  
  Map<K, ValueDifference<V>> entriesDiffering();
  
  Map<K, V> entriesInCommon();
  
  Map<K, V> entriesOnlyOnLeft();
  
  Map<K, V> entriesOnlyOnRight();
  
  boolean equals(@Nullable Object paramObject);
  
  int hashCode();
  
  public static interface ValueDifference<V> {
    boolean equals(@Nullable Object param1Object);
    
    int hashCode();
    
    V leftValue();
    
    V rightValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MapDifference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */