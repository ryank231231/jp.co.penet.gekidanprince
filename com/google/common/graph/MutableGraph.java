package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
public interface MutableGraph<N> extends Graph<N> {
  @CanIgnoreReturnValue
  boolean addNode(N paramN);
  
  @CanIgnoreReturnValue
  boolean putEdge(N paramN1, N paramN2);
  
  @CanIgnoreReturnValue
  boolean removeEdge(Object paramObject1, Object paramObject2);
  
  @CanIgnoreReturnValue
  boolean removeNode(Object paramObject);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\MutableGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */