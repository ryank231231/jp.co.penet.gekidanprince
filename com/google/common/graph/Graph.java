package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public interface Graph<N> {
  Set<N> adjacentNodes(Object paramObject);
  
  boolean allowsSelfLoops();
  
  int degree(Object paramObject);
  
  Set<EndpointPair<N>> edges();
  
  boolean equals(@Nullable Object paramObject);
  
  int hashCode();
  
  int inDegree(Object paramObject);
  
  boolean isDirected();
  
  ElementOrder<N> nodeOrder();
  
  Set<N> nodes();
  
  int outDegree(Object paramObject);
  
  Set<N> predecessors(Object paramObject);
  
  Set<N> successors(Object paramObject);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\Graph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */