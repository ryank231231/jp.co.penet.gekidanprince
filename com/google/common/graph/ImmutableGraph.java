package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;

@Beta
public abstract class ImmutableGraph<N> extends ForwardingGraph<N> {
  private static <N> GraphConnections<N, GraphConstants.Presence> connectionsOf(Graph<N> paramGraph, N paramN) {
    DirectedGraphConnections<?, ?> directedGraphConnections;
    UndirectedGraphConnections<?, ?> undirectedGraphConnections;
    Function function = Functions.constant(GraphConstants.Presence.EDGE_EXISTS);
    if (paramGraph.isDirected()) {
      directedGraphConnections = DirectedGraphConnections.ofImmutable(paramGraph.predecessors(paramN), Maps.asMap(paramGraph.successors(paramN), function));
    } else {
      undirectedGraphConnections = UndirectedGraphConnections.ofImmutable(Maps.asMap(directedGraphConnections.adjacentNodes(paramN), function));
    } 
    return (GraphConnections)undirectedGraphConnections;
  }
  
  public static <N> ImmutableGraph<N> copyOf(Graph<N> paramGraph) {
    if (paramGraph instanceof ImmutableGraph) {
      paramGraph = paramGraph;
    } else {
      paramGraph = new ValueBackedImpl<N, Object>(GraphBuilder.from(paramGraph), getNodeConnections(paramGraph), paramGraph.edges().size());
    } 
    return (ImmutableGraph<N>)paramGraph;
  }
  
  @Deprecated
  public static <N> ImmutableGraph<N> copyOf(ImmutableGraph<N> paramImmutableGraph) {
    return (ImmutableGraph<N>)Preconditions.checkNotNull(paramImmutableGraph);
  }
  
  private static <N> ImmutableMap<N, GraphConnections<N, GraphConstants.Presence>> getNodeConnections(Graph<N> paramGraph) {
    // Byte code:
    //   0: invokestatic builder : ()Lcom/google/common/collect/ImmutableMap$Builder;
    //   3: astore_1
    //   4: aload_0
    //   5: invokeinterface nodes : ()Ljava/util/Set;
    //   10: invokeinterface iterator : ()Ljava/util/Iterator;
    //   15: astore_2
    //   16: aload_2
    //   17: invokeinterface hasNext : ()Z
    //   22: ifeq -> 46
    //   25: aload_2
    //   26: invokeinterface next : ()Ljava/lang/Object;
    //   31: astore_3
    //   32: aload_1
    //   33: aload_3
    //   34: aload_0
    //   35: aload_3
    //   36: invokestatic connectionsOf : (Lcom/google/common/graph/Graph;Ljava/lang/Object;)Lcom/google/common/graph/GraphConnections;
    //   39: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   42: pop
    //   43: goto -> 16
    //   46: aload_1
    //   47: invokevirtual build : ()Lcom/google/common/collect/ImmutableMap;
    //   50: areturn
  }
  
  static class ValueBackedImpl<N, V> extends ImmutableGraph<N> {
    protected final ValueGraph<N, V> backingValueGraph;
    
    ValueBackedImpl(AbstractGraphBuilder<? super N> param1AbstractGraphBuilder, ImmutableMap<N, GraphConnections<N, V>> param1ImmutableMap, long param1Long) {
      this.backingValueGraph = new ConfigurableValueGraph<N, V>(param1AbstractGraphBuilder, (Map<N, GraphConnections<N, V>>)param1ImmutableMap, param1Long);
    }
    
    protected Graph<N> delegate() {
      return this.backingValueGraph;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ImmutableGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */