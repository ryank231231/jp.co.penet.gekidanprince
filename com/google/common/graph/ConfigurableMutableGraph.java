package com.google.common.graph;

final class ConfigurableMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
  private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;
  
  ConfigurableMutableGraph(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder) {
    this.backingValueGraph = new ConfigurableMutableValueGraph<N, GraphConstants.Presence>(paramAbstractGraphBuilder);
  }
  
  public boolean addNode(N paramN) {
    return this.backingValueGraph.addNode(paramN);
  }
  
  protected Graph<N> delegate() {
    return this.backingValueGraph;
  }
  
  public boolean putEdge(N paramN1, N paramN2) {
    boolean bool;
    if (this.backingValueGraph.putEdgeValue(paramN1, paramN2, GraphConstants.Presence.EDGE_EXISTS) == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean removeEdge(Object paramObject1, Object paramObject2) {
    boolean bool;
    if (this.backingValueGraph.removeEdge(paramObject1, paramObject2) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean removeNode(Object paramObject) {
    return this.backingValueGraph.removeNode(paramObject);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ConfigurableMutableGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */