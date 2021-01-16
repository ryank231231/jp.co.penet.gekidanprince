package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
public interface MutableNetwork<N, E> extends Network<N, E> {
  @CanIgnoreReturnValue
  boolean addEdge(N paramN1, N paramN2, E paramE);
  
  @CanIgnoreReturnValue
  boolean addNode(N paramN);
  
  @CanIgnoreReturnValue
  boolean removeEdge(Object paramObject);
  
  @CanIgnoreReturnValue
  boolean removeNode(Object paramObject);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\MutableNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */