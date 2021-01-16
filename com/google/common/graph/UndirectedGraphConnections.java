package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
  private final Map<N, V> adjacentNodeValues;
  
  private UndirectedGraphConnections(Map<N, V> paramMap) {
    this.adjacentNodeValues = (Map<N, V>)Preconditions.checkNotNull(paramMap);
  }
  
  static <N, V> UndirectedGraphConnections<N, V> of() {
    return new UndirectedGraphConnections<N, V>(new HashMap<N, V>(2, 1.0F));
  }
  
  static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> paramMap) {
    return new UndirectedGraphConnections<N, V>((Map<N, V>)ImmutableMap.copyOf(paramMap));
  }
  
  public void addPredecessor(N paramN, V paramV) {
    addSuccessor(paramN, paramV);
  }
  
  public V addSuccessor(N paramN, V paramV) {
    return this.adjacentNodeValues.put(paramN, paramV);
  }
  
  public Set<N> adjacentNodes() {
    return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
  }
  
  public Set<N> predecessors() {
    return adjacentNodes();
  }
  
  public void removePredecessor(Object paramObject) {
    removeSuccessor(paramObject);
  }
  
  public V removeSuccessor(Object paramObject) {
    return this.adjacentNodeValues.remove(paramObject);
  }
  
  public Set<N> successors() {
    return adjacentNodes();
  }
  
  public V value(Object paramObject) {
    return this.adjacentNodeValues.get(paramObject);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\UndirectedGraphConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */