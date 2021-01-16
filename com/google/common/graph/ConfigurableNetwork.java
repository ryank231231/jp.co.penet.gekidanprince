package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class ConfigurableNetwork<N, E> extends AbstractNetwork<N, E> {
  private final boolean allowsParallelEdges;
  
  private final boolean allowsSelfLoops;
  
  private final ElementOrder<E> edgeOrder;
  
  protected final MapIteratorCache<E, N> edgeToReferenceNode;
  
  private final boolean isDirected;
  
  protected final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
  
  private final ElementOrder<N> nodeOrder;
  
  ConfigurableNetwork(NetworkBuilder<? super N, ? super E> paramNetworkBuilder) {
    this(paramNetworkBuilder, paramNetworkBuilder.nodeOrder.createMap(((Integer)paramNetworkBuilder.expectedNodeCount.or(Integer.valueOf(10))).intValue()), paramNetworkBuilder.edgeOrder.createMap(((Integer)paramNetworkBuilder.expectedEdgeCount.or(Integer.valueOf(20))).intValue()));
  }
  
  ConfigurableNetwork(NetworkBuilder<? super N, ? super E> paramNetworkBuilder, Map<N, NetworkConnections<N, E>> paramMap, Map<E, N> paramMap1) {
    MapIteratorCache<N, NetworkConnections<N, E>> mapIteratorCache;
    this.isDirected = paramNetworkBuilder.directed;
    this.allowsParallelEdges = paramNetworkBuilder.allowsParallelEdges;
    this.allowsSelfLoops = paramNetworkBuilder.allowsSelfLoops;
    this.nodeOrder = paramNetworkBuilder.nodeOrder.cast();
    this.edgeOrder = paramNetworkBuilder.edgeOrder.cast();
    if (paramMap instanceof java.util.TreeMap) {
      mapIteratorCache = new MapRetrievalCache<N, NetworkConnections<N, E>>(paramMap);
    } else {
      mapIteratorCache = new MapIteratorCache<N, NetworkConnections<N, E>>(paramMap);
    } 
    this.nodeConnections = mapIteratorCache;
    this.edgeToReferenceNode = new MapIteratorCache<E, N>(paramMap1);
  }
  
  public Set<N> adjacentNodes(Object paramObject) {
    return checkedConnections(paramObject).adjacentNodes();
  }
  
  public boolean allowsParallelEdges() {
    return this.allowsParallelEdges;
  }
  
  public boolean allowsSelfLoops() {
    return this.allowsSelfLoops;
  }
  
  protected final NetworkConnections<N, E> checkedConnections(Object paramObject) {
    NetworkConnections<N, E> networkConnections = this.nodeConnections.get(paramObject);
    if (networkConnections != null)
      return networkConnections; 
    Preconditions.checkNotNull(paramObject);
    throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[] { paramObject }));
  }
  
  protected final N checkedReferenceNode(Object paramObject) {
    N n = this.edgeToReferenceNode.get(paramObject);
    if (n != null)
      return n; 
    Preconditions.checkNotNull(paramObject);
    throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", new Object[] { paramObject }));
  }
  
  protected final boolean containsEdge(@Nullable Object paramObject) {
    return this.edgeToReferenceNode.containsKey(paramObject);
  }
  
  protected final boolean containsNode(@Nullable Object paramObject) {
    return this.nodeConnections.containsKey(paramObject);
  }
  
  public ElementOrder<E> edgeOrder() {
    return this.edgeOrder;
  }
  
  public Set<E> edges() {
    return this.edgeToReferenceNode.unmodifiableKeySet();
  }
  
  public Set<E> edgesConnecting(Object paramObject1, Object paramObject2) {
    NetworkConnections<N, E> networkConnections = checkedConnections(paramObject1);
    if (!this.allowsSelfLoops && paramObject1 == paramObject2)
      return (Set<E>)ImmutableSet.of(); 
    Preconditions.checkArgument(containsNode(paramObject2), "Node %s is not an element of this graph.", paramObject2);
    return networkConnections.edgesConnecting(paramObject2);
  }
  
  public Set<E> inEdges(Object paramObject) {
    return checkedConnections(paramObject).inEdges();
  }
  
  public Set<E> incidentEdges(Object paramObject) {
    return checkedConnections(paramObject).incidentEdges();
  }
  
  public EndpointPair<N> incidentNodes(Object paramObject) {
    N n = checkedReferenceNode(paramObject);
    return EndpointPair.of(this, n, (N)((NetworkConnections)this.nodeConnections.get(n)).oppositeNode(paramObject));
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
  
  public Set<E> outEdges(Object paramObject) {
    return checkedConnections(paramObject).outEdges();
  }
  
  public Set<N> predecessors(Object paramObject) {
    return checkedConnections(paramObject).predecessors();
  }
  
  public Set<N> successors(Object paramObject) {
    return checkedConnections(paramObject).successors();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ConfigurableNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */