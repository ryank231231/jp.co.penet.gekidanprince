package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
  protected final Map<E, N> incidentEdgeMap;
  
  protected AbstractUndirectedNetworkConnections(Map<E, N> paramMap) {
    this.incidentEdgeMap = (Map<E, N>)Preconditions.checkNotNull(paramMap);
  }
  
  public void addInEdge(E paramE, N paramN, boolean paramBoolean) {
    if (!paramBoolean)
      addOutEdge(paramE, paramN); 
  }
  
  public void addOutEdge(E paramE, N paramN) {
    boolean bool;
    if (this.incidentEdgeMap.put(paramE, paramN) == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
  }
  
  public Set<E> inEdges() {
    return incidentEdges();
  }
  
  public Set<E> incidentEdges() {
    return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
  }
  
  public N oppositeNode(Object paramObject) {
    return (N)Preconditions.checkNotNull(this.incidentEdgeMap.get(paramObject));
  }
  
  public Set<E> outEdges() {
    return incidentEdges();
  }
  
  public Set<N> predecessors() {
    return adjacentNodes();
  }
  
  public N removeInEdge(Object paramObject, boolean paramBoolean) {
    return !paramBoolean ? removeOutEdge(paramObject) : null;
  }
  
  public N removeOutEdge(Object paramObject) {
    return (N)Preconditions.checkNotNull(this.incidentEdgeMap.remove(paramObject));
  }
  
  public Set<N> successors() {
    return adjacentNodes();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\AbstractUndirectedNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */