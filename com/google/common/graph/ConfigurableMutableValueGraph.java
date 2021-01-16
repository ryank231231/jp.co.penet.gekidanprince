package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

final class ConfigurableMutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> implements MutableValueGraph<N, V> {
  ConfigurableMutableValueGraph(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder) {
    super(paramAbstractGraphBuilder);
  }
  
  @CanIgnoreReturnValue
  private GraphConnections<N, V> addNodeInternal(N paramN) {
    boolean bool;
    GraphConnections<N, V> graphConnections = newConnections();
    if (this.nodeConnections.put(paramN, graphConnections) == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    return graphConnections;
  }
  
  private GraphConnections<N, V> newConnections() {
    UndirectedGraphConnections<?, ?> undirectedGraphConnections;
    if (isDirected()) {
      DirectedGraphConnections<?, ?> directedGraphConnections = DirectedGraphConnections.of();
    } else {
      undirectedGraphConnections = UndirectedGraphConnections.of();
    } 
    return (GraphConnections)undirectedGraphConnections;
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
  public V putEdgeValue(N paramN1, N paramN2, V paramV) {
    Preconditions.checkNotNull(paramN1, "nodeU");
    Preconditions.checkNotNull(paramN2, "nodeV");
    Preconditions.checkNotNull(paramV, "value");
    if (!allowsSelfLoops())
      Preconditions.checkArgument(paramN1.equals(paramN2) ^ true, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", paramN1); 
    GraphConnections<N, V> graphConnections1 = this.nodeConnections.get(paramN1);
    GraphConnections<N, V> graphConnections2 = graphConnections1;
    if (graphConnections1 == null)
      graphConnections2 = addNodeInternal(paramN1); 
    V v = graphConnections2.addSuccessor(paramN2, paramV);
    graphConnections1 = this.nodeConnections.get(paramN2);
    graphConnections2 = graphConnections1;
    if (graphConnections1 == null)
      graphConnections2 = addNodeInternal(paramN2); 
    graphConnections2.addPredecessor(paramN1, paramV);
    if (v == null) {
      long l = this.edgeCount + 1L;
      this.edgeCount = l;
      Graphs.checkPositive(l);
    } 
    return v;
  }
  
  @CanIgnoreReturnValue
  public V removeEdge(Object paramObject1, Object paramObject2) {
    Preconditions.checkNotNull(paramObject1, "nodeU");
    Preconditions.checkNotNull(paramObject2, "nodeV");
    GraphConnections graphConnections1 = this.nodeConnections.get(paramObject1);
    GraphConnections graphConnections2 = this.nodeConnections.get(paramObject2);
    if (graphConnections1 == null || graphConnections2 == null)
      return null; 
    paramObject2 = graphConnections1.removeSuccessor(paramObject2);
    if (paramObject2 != null) {
      graphConnections2.removePredecessor(paramObject1);
      long l = this.edgeCount - 1L;
      this.edgeCount = l;
      Graphs.checkNonNegative(l);
    } 
    return (V)paramObject2;
  }
  
  @CanIgnoreReturnValue
  public boolean removeNode(Object paramObject) {
    Preconditions.checkNotNull(paramObject, "node");
    graphConnections = this.nodeConnections.get(paramObject);
    if (graphConnections == null)
      return false; 
    if (allowsSelfLoops() && graphConnections.removeSuccessor(paramObject) != null) {
      graphConnections.removePredecessor(paramObject);
      this.edgeCount--;
    } 
    for (Object object : graphConnections.successors()) {
      ((GraphConnections)this.nodeConnections.getWithoutCaching(object)).removePredecessor(paramObject);
      this.edgeCount--;
    } 
    if (isDirected())
      for (GraphConnections graphConnections : graphConnections.predecessors()) {
        boolean bool;
        if (((GraphConnections)this.nodeConnections.getWithoutCaching(graphConnections)).removeSuccessor(paramObject) != null) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool);
        this.edgeCount--;
      }  
    this.nodeConnections.remove(paramObject);
    Graphs.checkNonNegative(this.edgeCount);
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ConfigurableMutableValueGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */