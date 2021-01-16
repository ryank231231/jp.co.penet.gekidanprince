package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

final class DirectedNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
  protected DirectedNetworkConnections(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
    super(paramMap1, paramMap2, paramInt);
  }
  
  static <N, E> DirectedNetworkConnections<N, E> of() {
    return new DirectedNetworkConnections<N, E>((Map<E, N>)HashBiMap.create(2), (Map<E, N>)HashBiMap.create(2), 0);
  }
  
  static <N, E> DirectedNetworkConnections<N, E> ofImmutable(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
    return new DirectedNetworkConnections<N, E>((Map<E, N>)ImmutableBiMap.copyOf(paramMap1), (Map<E, N>)ImmutableBiMap.copyOf(paramMap2), paramInt);
  }
  
  public Set<E> edgesConnecting(Object paramObject) {
    return new EdgesConnecting<E>((Map<?, E>)((BiMap)this.outEdgeMap).inverse(), paramObject);
  }
  
  public Set<N> predecessors() {
    return Collections.unmodifiableSet(((BiMap)this.inEdgeMap).values());
  }
  
  public Set<N> successors() {
    return Collections.unmodifiableSet(((BiMap)this.outEdgeMap).values());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\DirectedNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */