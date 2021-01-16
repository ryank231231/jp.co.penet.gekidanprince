package com.google.common.graph;

import java.util.Set;

abstract class ForwardingGraph<N> extends AbstractGraph<N> {
  public Set<N> adjacentNodes(Object paramObject) {
    return delegate().adjacentNodes(paramObject);
  }
  
  public boolean allowsSelfLoops() {
    return delegate().allowsSelfLoops();
  }
  
  public int degree(Object paramObject) {
    return delegate().degree(paramObject);
  }
  
  protected abstract Graph<N> delegate();
  
  public Set<EndpointPair<N>> edges() {
    return delegate().edges();
  }
  
  public int inDegree(Object paramObject) {
    return delegate().inDegree(paramObject);
  }
  
  public boolean isDirected() {
    return delegate().isDirected();
  }
  
  public ElementOrder<N> nodeOrder() {
    return delegate().nodeOrder();
  }
  
  public Set<N> nodes() {
    return delegate().nodes();
  }
  
  public int outDegree(Object paramObject) {
    return delegate().outDegree(paramObject);
  }
  
  public Set<N> predecessors(Object paramObject) {
    return delegate().predecessors(paramObject);
  }
  
  public Set<N> successors(Object paramObject) {
    return delegate().successors(paramObject);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ForwardingGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */