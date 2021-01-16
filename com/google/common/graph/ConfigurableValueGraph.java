package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class ConfigurableValueGraph<N, V> extends AbstractValueGraph<N, V> {
  private final boolean allowsSelfLoops;
  
  protected long edgeCount;
  
  private final boolean isDirected;
  
  protected final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
  
  private final ElementOrder<N> nodeOrder;
  
  ConfigurableValueGraph(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder) {
    this(paramAbstractGraphBuilder, paramAbstractGraphBuilder.nodeOrder.createMap(((Integer)paramAbstractGraphBuilder.expectedNodeCount.or(Integer.valueOf(10))).intValue()), 0L);
  }
  
  ConfigurableValueGraph(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder, Map<N, GraphConnections<N, V>> paramMap, long paramLong) {
    MapIteratorCache<N, GraphConnections<N, V>> mapIteratorCache;
    this.isDirected = paramAbstractGraphBuilder.directed;
    this.allowsSelfLoops = paramAbstractGraphBuilder.allowsSelfLoops;
    this.nodeOrder = paramAbstractGraphBuilder.nodeOrder.cast();
    if (paramMap instanceof java.util.TreeMap) {
      mapIteratorCache = new MapRetrievalCache<N, GraphConnections<N, V>>(paramMap);
    } else {
      mapIteratorCache = new MapIteratorCache<N, GraphConnections<N, V>>(paramMap);
    } 
    this.nodeConnections = mapIteratorCache;
    this.edgeCount = Graphs.checkNonNegative(paramLong);
  }
  
  public Set<N> adjacentNodes(Object paramObject) {
    return checkedConnections(paramObject).adjacentNodes();
  }
  
  public boolean allowsSelfLoops() {
    return this.allowsSelfLoops;
  }
  
  protected final GraphConnections<N, V> checkedConnections(Object paramObject) {
    GraphConnections<N, V> graphConnections = this.nodeConnections.get(paramObject);
    if (graphConnections != null)
      return graphConnections; 
    Preconditions.checkNotNull(paramObject);
    throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[] { paramObject }));
  }
  
  protected final boolean containsNode(@Nullable Object paramObject) {
    return this.nodeConnections.containsKey(paramObject);
  }
  
  protected long edgeCount() {
    return this.edgeCount;
  }
  
  public V edgeValueOrDefault(Object paramObject1, Object paramObject2, @Nullable V paramV) {
    paramObject1 = this.nodeConnections.get(paramObject1);
    if (paramObject1 == null)
      return paramV; 
    paramObject1 = paramObject1.value(paramObject2);
    return (V)((paramObject1 == null) ? (Object)paramV : paramObject1);
  }
  
  public boolean isDirected() {
    return this.isDirected;
  }
  
  public ElementOrder<N> nodeOrder() {
    return this.nodeOrder;
  }
  
  public Set<N> nodes() {
    return this.nodeConnections.unmodifiableKeySet();
  }
  
  public Set<N> predecessors(Object paramObject) {
    return checkedConnections(paramObject).predecessors();
  }
  
  public Set<N> successors(Object paramObject) {
    return checkedConnections(paramObject).successors();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ConfigurableValueGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */