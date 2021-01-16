package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
  @CanIgnoreReturnValue
  boolean addNode(N paramN);
  
  @CanIgnoreReturnValue
  V putEdgeValue(N paramN1, N paramN2, V paramV);
  
  @CanIgnoreReturnValue
  V removeEdge(Object paramObject1, Object paramObject2);
  
  @CanIgnoreReturnValue
  boolean removeNode(Object paramObject);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\MutableValueGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */