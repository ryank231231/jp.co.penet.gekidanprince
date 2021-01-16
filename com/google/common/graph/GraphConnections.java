package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import javax.annotation.Nullable;

interface GraphConnections<N, V> {
  void addPredecessor(N paramN, V paramV);
  
  @CanIgnoreReturnValue
  V addSuccessor(N paramN, V paramV);
  
  Set<N> adjacentNodes();
  
  Set<N> predecessors();
  
  void removePredecessor(Object paramObject);
  
  @CanIgnoreReturnValue
  V removeSuccessor(Object paramObject);
  
  Set<N> successors();
  
  @Nullable
  V value(Object paramObject);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\GraphConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */