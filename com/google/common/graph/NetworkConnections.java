package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;

interface NetworkConnections<N, E> {
  void addInEdge(E paramE, N paramN, boolean paramBoolean);
  
  void addOutEdge(E paramE, N paramN);
  
  Set<N> adjacentNodes();
  
  Set<E> edgesConnecting(Object paramObject);
  
  Set<E> inEdges();
  
  Set<E> incidentEdges();
  
  N oppositeNode(Object paramObject);
  
  Set<E> outEdges();
  
  Set<N> predecessors();
  
  @CanIgnoreReturnValue
  N removeInEdge(Object paramObject, boolean paramBoolean);
  
  @CanIgnoreReturnValue
  N removeOutEdge(Object paramObject);
  
  Set<N> successors();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\NetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */