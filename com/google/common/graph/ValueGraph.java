package com.google.common.graph;

import com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
public interface ValueGraph<N, V> extends Graph<N> {
  V edgeValue(Object paramObject1, Object paramObject2);
  
  V edgeValueOrDefault(Object paramObject1, Object paramObject2, @Nullable V paramV);
  
  boolean equals(@Nullable Object paramObject);
  
  int hashCode();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ValueGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */