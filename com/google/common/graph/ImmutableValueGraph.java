package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;

@Beta
public final class ImmutableValueGraph<N, V> extends ImmutableGraph.ValueBackedImpl<N, V> implements ValueGraph<N, V> {
  private ImmutableValueGraph(ValueGraph<N, V> paramValueGraph) {
    super(ValueGraphBuilder.from(paramValueGraph), getNodeConnections(paramValueGraph), paramValueGraph.edges().size());
  }
  
  private static <N, V> GraphConnections<N, V> connectionsOf(final ValueGraph<N, V> graph, final N node) {
    DirectedGraphConnections<?, ?> directedGraphConnections;
    UndirectedGraphConnections<?, ?> undirectedGraphConnections;
    Function<N, V> function = new Function<N, V>() {
        public V apply(N param1N) {
          return (V)graph.edgeValue(node, param1N);
        }
      };
    if (graph.isDirected()) {
      directedGraphConnections = DirectedGraphConnections.ofImmutable(graph.predecessors(node), Maps.asMap(graph.successors(node), function));
    } else {
      undirectedGraphConnections = UndirectedGraphConnections.ofImmutable(Maps.asMap(directedGraphConnections.adjacentNodes(node), function));
    } 
    return (GraphConnections)undirectedGraphConnections;
  }
  
  @Deprecated
  public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> paramImmutableValueGraph) {
    return (ImmutableValueGraph<N, V>)Preconditions.checkNotNull(paramImmutableValueGraph);
  }
  
  public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> paramValueGraph) {
    if (paramValueGraph instanceof ImmutableValueGraph) {
      paramValueGraph = paramValueGraph;
    } else {
      paramValueGraph = new ImmutableValueGraph<N, V>(paramValueGraph);
    } 
    return (ImmutableValueGraph<N, V>)paramValueGraph;
  }
  
  private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> paramValueGraph) {
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
    //   36: invokestatic connectionsOf : (Lcom/google/common/graph/ValueGraph;Ljava/lang/Object;)Lcom/google/common/graph/GraphConnections;
    //   39: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   42: pop
    //   43: goto -> 16
    //   46: aload_1
    //   47: invokevirtual build : ()Lcom/google/common/collect/ImmutableMap;
    //   50: areturn
  }
  
  public V edgeValue(Object paramObject1, Object paramObject2) {
    return this.backingValueGraph.edgeValue(paramObject1, paramObject2);
  }
  
  public V edgeValueOrDefault(Object paramObject1, Object paramObject2, @Nullable V paramV) {
    return this.backingValueGraph.edgeValueOrDefault(paramObject1, paramObject2, paramV);
  }
  
  public String toString() {
    return this.backingValueGraph.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ImmutableValueGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */