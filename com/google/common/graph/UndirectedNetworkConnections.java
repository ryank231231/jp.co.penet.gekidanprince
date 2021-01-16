package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

final class UndirectedNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
  protected UndirectedNetworkConnections(Map<E, N> paramMap) {
    super(paramMap);
  }
  
  static <N, E> UndirectedNetworkConnections<N, E> of() {
    return new UndirectedNetworkConnections<N, E>((Map<E, N>)HashBiMap.create(2));
  }
  
  static <N, E> UndirectedNetworkConnections<N, E> ofImmutable(Map<E, N> paramMap) {
    return new UndirectedNetworkConnections<N, E>((Map<E, N>)ImmutableBiMap.copyOf(paramMap));
  }
  
  public Set<N> adjacentNodes() {
    return Collections.unmodifiableSet(((BiMap)this.incidentEdgeMap).values());
  }
  
  public Set<E> edgesConnecting(Object paramObject) {
    return new EdgesConnecting<E>((Map<?, E>)((BiMap)this.incidentEdgeMap).inverse(), paramObject);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\UndirectedNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */