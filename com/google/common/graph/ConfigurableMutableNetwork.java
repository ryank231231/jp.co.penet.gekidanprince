package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

final class ConfigurableMutableNetwork<N, E> extends ConfigurableNetwork<N, E> implements MutableNetwork<N, E> {
  ConfigurableMutableNetwork(NetworkBuilder<? super N, ? super E> paramNetworkBuilder) {
    super(paramNetworkBuilder);
  }
  
  @CanIgnoreReturnValue
  private NetworkConnections<N, E> addNodeInternal(N paramN) {
    boolean bool;
    NetworkConnections<N, E> networkConnections = newConnections();
    if (this.nodeConnections.put(paramN, networkConnections) == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    return networkConnections;
  }
  
  private NetworkConnections<N, E> newConnections() {
    UndirectedNetworkConnections<?, ?> undirectedNetworkConnections;
    if (isDirected()) {
      if (allowsParallelEdges()) {
        DirectedMultiNetworkConnections<?, ?> directedMultiNetworkConnections = DirectedMultiNetworkConnections.of();
      } else {
        DirectedNetworkConnections<?, ?> directedNetworkConnections = DirectedNetworkConnections.of();
      } 
    } else if (allowsParallelEdges()) {
      UndirectedMultiNetworkConnections<?, ?> undirectedMultiNetworkConnections = UndirectedMultiNetworkConnections.of();
    } else {
      undirectedNetworkConnections = UndirectedNetworkConnections.of();
    } 
    return (NetworkConnections)undirectedNetworkConnections;
  }
  
  @CanIgnoreReturnValue
  public boolean addEdge(N paramN1, N paramN2, E paramE) {
    EndpointPair<N> endpointPair;
    Preconditions.checkNotNull(paramN1, "nodeU");
    Preconditions.checkNotNull(paramN2, "nodeV");
    Preconditions.checkNotNull(paramE, "edge");
    boolean bool1 = containsEdge(paramE);
    boolean bool2 = false;
    if (bool1) {
      EndpointPair<N> endpointPair1 = incidentNodes(paramE);
      endpointPair = EndpointPair.of(this, paramN1, paramN2);
      Preconditions.checkArgument(endpointPair1.equals(endpointPair), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", paramE, endpointPair1, endpointPair);
      return false;
    } 
    NetworkConnections<N, E> networkConnections2 = this.nodeConnections.get(endpointPair);
    if (!allowsParallelEdges()) {
      if (networkConnections2 == null || !networkConnections2.successors().contains(paramN2))
        bool2 = true; 
      Preconditions.checkArgument(bool2, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", endpointPair, paramN2);
    } 
    bool2 = endpointPair.equals(paramN2);
    if (!allowsSelfLoops())
      Preconditions.checkArgument(bool2 ^ true, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", endpointPair); 
    NetworkConnections<N, E> networkConnections1 = networkConnections2;
    if (networkConnections2 == null)
      networkConnections1 = addNodeInternal((N)endpointPair); 
    networkConnections1.addOutEdge(paramE, paramN2);
    networkConnections2 = this.nodeConnections.get(paramN2);
    networkConnections1 = networkConnections2;
    if (networkConnections2 == null)
      networkConnections1 = addNodeInternal(paramN2); 
    networkConnections1.addInEdge(paramE, (N)endpointPair, bool2);
    this.edgeToReferenceNode.put(paramE, (N)endpointPair);
    return true;
  }
  
  @CanIgnoreReturnValue
  public boolean addNode(N paramN) {
    Preconditions.checkNotNull(paramN, "node");
    if (containsNode(paramN))
      return false; 
    addNodeInternal(paramN);
    return true;
  }
  
  @CanIgnoreReturnValue
  public boolean removeEdge(Object paramObject) {
    Preconditions.checkNotNull(paramObject, "edge");
    N n = this.edgeToReferenceNode.get(paramObject);
    boolean bool1 = false;
    if (n == null)
      return false; 
    NetworkConnections networkConnections1 = this.nodeConnections.get(n);
    Object object = networkConnections1.oppositeNode(paramObject);
    NetworkConnections networkConnections2 = this.nodeConnections.get(object);
    networkConnections1.removeOutEdge(paramObject);
    boolean bool2 = bool1;
    if (allowsSelfLoops()) {
      bool2 = bool1;
      if (n.equals(object))
        bool2 = true; 
    } 
    networkConnections2.removeInEdge(paramObject, bool2);
    this.edgeToReferenceNode.remove(paramObject);
    return true;
  }
  
  @CanIgnoreReturnValue
  public boolean removeNode(Object paramObject) {
    Preconditions.checkNotNull(paramObject, "node");
    NetworkConnections networkConnections = this.nodeConnections.get(paramObject);
    if (networkConnections == null)
      return false; 
    Iterator iterator = ImmutableList.copyOf(networkConnections.incidentEdges()).iterator();
    while (iterator.hasNext())
      removeEdge(iterator.next()); 
    this.nodeConnections.remove(paramObject);
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ConfigurableMutableNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */