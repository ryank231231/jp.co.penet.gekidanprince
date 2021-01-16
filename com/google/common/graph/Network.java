package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public interface Network<N, E> {
  Set<E> adjacentEdges(Object paramObject);
  
  Set<N> adjacentNodes(Object paramObject);
  
  boolean allowsParallelEdges();
  
  boolean allowsSelfLoops();
  
  Graph<N> asGraph();
  
  int degree(Object paramObject);
  
  ElementOrder<E> edgeOrder();
  
  Set<E> edges();
  
  Set<E> edgesConnecting(Object paramObject1, Object paramObject2);
  
  boolean equals(@Nullable Object paramObject);
  
  int hashCode();
  
  int inDegree(Object paramObject);
  
  Set<E> inEdges(Object paramObject);
  
  Set<E> incidentEdges(Object paramObject);
  
  EndpointPair<N> incidentNodes(Object paramObject);
  
  boolean isDirected();
  
  ElementOrder<N> nodeOrder();
  
  Set<N> nodes();
  
  int outDegree(Object paramObject);
  
  Set<E> outEdges(Object paramObject);
  
  Set<N> predecessors(Object paramObject);
  
  Set<N> successors(Object paramObject);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */