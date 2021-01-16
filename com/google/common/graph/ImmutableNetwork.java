package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;

@Beta
public final class ImmutableNetwork<N, E> extends ConfigurableNetwork<N, E> {
  private ImmutableNetwork(Network<N, E> paramNetwork) {
    super(NetworkBuilder.from(paramNetwork), getNodeConnections(paramNetwork), getEdgeToReferenceNode(paramNetwork));
  }
  
  private static <N, E> Function<E, N> adjacentNodeFn(final Network<N, E> network, final N node) {
    return new Function<E, N>() {
        public N apply(E param1E) {
          return network.incidentNodes(param1E).adjacentNode(node);
        }
      };
  }
  
  private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> paramNetwork, N paramN) {
    DirectedNetworkConnections<?, ?> directedNetworkConnections;
    UndirectedNetworkConnections<?, ?> undirectedNetworkConnections;
    if (paramNetwork.isDirected()) {
      Map<?, ?> map1 = Maps.asMap(paramNetwork.inEdges(paramN), sourceNodeFn(paramNetwork));
      Map<?, ?> map2 = Maps.asMap(paramNetwork.outEdges(paramN), targetNodeFn(paramNetwork));
      int i = paramNetwork.edgesConnecting(paramN, paramN).size();
      if (paramNetwork.allowsParallelEdges()) {
        DirectedMultiNetworkConnections<?, ?> directedMultiNetworkConnections = DirectedMultiNetworkConnections.ofImmutable(map1, map2, i);
      } else {
        directedNetworkConnections = DirectedNetworkConnections.ofImmutable(map1, map2, i);
      } 
      return (NetworkConnections)directedNetworkConnections;
    } 
    Map<?, ?> map = Maps.asMap(directedNetworkConnections.incidentEdges(paramN), adjacentNodeFn((Network<?, ?>)directedNetworkConnections, paramN));
    if (directedNetworkConnections.allowsParallelEdges()) {
      UndirectedMultiNetworkConnections<?, ?> undirectedMultiNetworkConnections = UndirectedMultiNetworkConnections.ofImmutable(map);
    } else {
      undirectedNetworkConnections = UndirectedNetworkConnections.ofImmutable(map);
    } 
    return (NetworkConnections)undirectedNetworkConnections;
  }
  
  @Deprecated
  public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> paramImmutableNetwork) {
    return (ImmutableNetwork<N, E>)Preconditions.checkNotNull(paramImmutableNetwork);
  }
  
  public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> paramNetwork) {
    if (paramNetwork instanceof ImmutableNetwork) {
      paramNetwork = paramNetwork;
    } else {
      paramNetwork = new ImmutableNetwork<N, E>(paramNetwork);
    } 
    return (ImmutableNetwork<N, E>)paramNetwork;
  }
  
  private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> paramNetwork) {
    ImmutableMap.Builder builder = ImmutableMap.builder();
    for (E e : paramNetwork.edges())
      builder.put(e, paramNetwork.incidentNodes(e).nodeU()); 
    return (Map<E, N>)builder.build();
  }
  
  private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> paramNetwork) {
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
    //   36: invokestatic connectionsOf : (Lcom/google/common/graph/Network;Ljava/lang/Object;)Lcom/google/common/graph/NetworkConnections;
    //   39: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   42: pop
    //   43: goto -> 16
    //   46: aload_1
    //   47: invokevirtual build : ()Lcom/google/common/collect/ImmutableMap;
    //   50: areturn
  }
  
  private static <N, E> Function<E, N> sourceNodeFn(final Network<N, E> network) {
    return new Function<E, N>() {
        public N apply(E param1E) {
          return network.incidentNodes(param1E).source();
        }
      };
  }
  
  private static <N, E> Function<E, N> targetNodeFn(final Network<N, E> network) {
    return new Function<E, N>() {
        public N apply(E param1E) {
          return network.incidentNodes(param1E).target();
        }
      };
  }
  
  public ImmutableGraph<N> asGraph() {
    return new ImmutableGraph<N>() {
        protected Graph<N> delegate() {
          return asGraph;
        }
      };
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ImmutableNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */