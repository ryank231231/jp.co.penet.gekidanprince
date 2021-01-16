package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
  private final Graph<N> graph;
  
  protected N node = null;
  
  private final Iterator<N> nodeIterator;
  
  protected Iterator<N> successorIterator = (Iterator<N>)ImmutableSet.of().iterator();
  
  private EndpointPairIterator(Graph<N> paramGraph) {
    this.graph = paramGraph;
    this.nodeIterator = paramGraph.nodes().iterator();
  }
  
  static <N> EndpointPairIterator<N> of(Graph<N> paramGraph) {
    Directed directed;
    Undirected<N> undirected;
    if (paramGraph.isDirected()) {
      directed = new Directed(paramGraph);
    } else {
      undirected = new Undirected((Graph)directed);
    } 
    return undirected;
  }
  
  protected final boolean advance() {
    Preconditions.checkState(this.successorIterator.hasNext() ^ true);
    if (!this.nodeIterator.hasNext())
      return false; 
    this.node = this.nodeIterator.next();
    this.successorIterator = this.graph.successors(this.node).iterator();
    return true;
  }
  
  private static final class Directed<N> extends EndpointPairIterator<N> {
    private Directed(Graph<N> param1Graph) {
      super(param1Graph);
    }
    
    protected EndpointPair<N> computeNext() {
      while (true) {
        if (this.successorIterator.hasNext())
          return EndpointPair.ordered(this.node, this.successorIterator.next()); 
        if (!advance())
          return (EndpointPair<N>)endOfData(); 
      } 
    }
  }
  
  private static final class Undirected<N> extends EndpointPairIterator<N> {
    private Set<N> visitedNodes;
    
    private Undirected(Graph<N> param1Graph) {
      super(param1Graph);
      this.visitedNodes = Sets.newHashSetWithExpectedSize(param1Graph.nodes().size());
    }
    
    protected EndpointPair<N> computeNext() {
      while (true) {
        while (this.successorIterator.hasNext()) {
          N n = this.successorIterator.next();
          if (!this.visitedNodes.contains(n))
            return EndpointPair.unordered(this.node, n); 
        } 
        this.visitedNodes.add(this.node);
        if (!advance()) {
          this.visitedNodes = null;
          return (EndpointPair<N>)endOfData();
        } 
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\EndpointPairIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */